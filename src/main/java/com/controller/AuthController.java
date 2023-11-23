package com.controller;

import com.dto.UserDto;
import com.model.UserDetail;
import com.service.serviceImpl.UserDetailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;

@Controller
public class AuthController {
    private UserDetailServiceImpl userDetailServiceImpl;
    private PasswordEncoder passwordEncoder;

    public AuthController(UserDetailServiceImpl userDetailServiceImpl, PasswordEncoder passwordEncoder) {
        this.userDetailServiceImpl = userDetailServiceImpl;
        this.passwordEncoder=passwordEncoder;
    }

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public String getCurrentUsernameRoles() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role=auth.getAuthorities().toString();
        role=role.replace('[',' ');
        role=role.replace(']',' ');
        role=role.trim();
        return role;
    }



    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register.html";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model)  {
        UserDetail existingUser = userDetailServiceImpl.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "Аккаунт с таким email уже существует");
        }
        if (userDto.getPassword().equals("")){
            model.addAttribute("user",userDto);
            model.addAttribute("empty","empty");
            return "/register";
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }
        return "redirect:/register/end/"+userDto.getEmail()+"/"+userDto.getPassword();
    }
    @GetMapping("/register/end/{email}/{password}")
    public String continueRegistration(@PathVariable("email") String email,@PathVariable("password") String password, Model model){
        // create model object to store form data
        UserDetail user=new UserDetail();
        model.addAttribute("user", user);
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        return "registerEnd.html";
    }

    @PostMapping("/register/end")
    public String endRegistration(String email, String password, UserDetail user, BindingResult result, Model model) throws IOException {
        String dateOfBirth = new SimpleDateFormat("dd-MM-yyyy").format(user.getBirthday());
        //create model object to store form data
        if(user.getName().equals("") || user.getSurname().equals("") ||  dateOfBirth.equals("") || user.getPhone().equals("")){
            model.addAttribute("fail","fail");
            model.addAttribute("user",user);
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            return "registerEnd.html";
        }
        int age= userDetailServiceImpl.calculateAge(dateOfBirth);
        if(age<18){
            model.addAttribute("age","age");
            model.addAttribute("user",user);
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            return "registerEnd.html";
        }
        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "redirect:/register/end/"+email+"/"+password;
        }

        if(user.getPatronymic().isEmpty()){user.setPatronymic("-");}
        if(user.getInfo().isEmpty()){user.setInfo("-");}
        user.setEmail(email);
        user.setPassword(password);
        userDetailServiceImpl.saveUser(user,"ROLE_CANDIDATE");

        return "redirect:/login";
    }


    @GetMapping("/roles")
    public String users(Model model){
        if(getCurrentUsernameRoles().equals("ROLE_CANDIDATE")){
            return "redirect:/candidate/candidateHome";
        }
        else if(getCurrentUsernameRoles().equals("ROLE_ADMIN")){
            return "redirect:/admin/adminHome";
        }
        else if(getCurrentUsernameRoles().equals("ROLE_EMPLOYEE")){
            return "redirect:/employee/employeeHome";
        }
        else {
            return "redirect:/hr/hrHome";
        }
    }

}

