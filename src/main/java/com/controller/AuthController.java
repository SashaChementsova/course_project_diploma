package com.controller;

import com.dto.UserDto;
import com.model.UserDetailsEntity;
import com.service.UserDetailService;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class AuthController {
    private UserDetailService userDetailService;
    private PasswordEncoder passwordEncoder;

    public AuthController(UserDetailService userDetailService, PasswordEncoder passwordEncoder) {
        this.userDetailService = userDetailService;
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

    @GetMapping("/index")
    public String home() {
//        UserEntity user=userService.findUserById(1);
//        user.setPassword(passwordEncoder.encode("123456"));
//        userService.updateUser(user);
        return "index";
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
        UserDetailsEntity existingUser = userDetailService.findUserByEmail(userDto.getEmail());

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
        UserDetailsEntity user=new UserDetailsEntity();
        model.addAttribute("user", user);
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        return "registerEnd.html";
    }

    @PostMapping("/register/end")
    public String endRegistration(String email, String password, UserDetailsEntity user, BindingResult result, Model model) throws IOException {
        String dateOfBirth = new SimpleDateFormat("dd-MM-yyyy").format(user.getBirthday());
        //create model object to store form data
        if(user.getName().equals("") || user.getSurname().equals("") ||  dateOfBirth.equals("") || user.getPhone().equals("")){
            model.addAttribute("fail","fail");
            model.addAttribute("user",user);
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            return "registerEnd.html";
        }
        int age=userDetailService.calculateAge(dateOfBirth);
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
        userDetailService.saveUser(user,"ROLE_CANDIDATE");

        return "redirect:/login";
    }


    @GetMapping("/roles")
    public String users(Model model){
        System.out.println(getCurrentUsernameRoles());
        if(getCurrentUsernameRoles().equals("ROLE_CANDIDATE")){
            System.out.println("BEGIN");
            return "redirect:/candidate/candidateHome";
        }
        else if(getCurrentUsernameRoles().equals("ROLE_ADMIN")){
            return "redirect:/admin/adminHome";
        }
        else if(getCurrentUsernameRoles().equals("ROLE_EMPLOYEE")){
            return "redirect:/employee/employeeHome";
        }
        else{
            return "redirect:/hr/hrHome";
        }
    }


    @GetMapping("/hr/hrHome")
    public String hrHome(Model model){
         return "hr.html";
    }

    @GetMapping("/candidate/candidateHome")
    public String candidateHome(Model model){
        System.out.println("CONTR CAND");
        return "candidate.html";
    }

    @GetMapping("/employee/employeeHome")
    public String employeeHome(Model model){
        return "employee.html";
    }

    @GetMapping("/admin/adminHome")
    public String adminHome(Model model){
        return "admin.html";
    }

}

//        String uploadDir="./src/main/resources/photo-user/"+email;
//        Path uploadPath = Paths.get(uploadDir);
//        if(!Files.exists(uploadPath)){
//            Files.createDirectories(uploadPath);
//        }
//        if(image==null){
//            Path pathDefolt=Paths.get("D:\\bsuir\\6 семестр\\кп ситаирис\\course_project\\defolt_photo.jpg");
//            userDTO.setPhoto("defolt_photo.jpg");
//            Path filePath=uploadPath.resolve("defolt_photo.jpg");
//            Files.copy(pathDefolt,filePath, StandardCopyOption.REPLACE_EXISTING);
//        }
//        else{
//            String fileName= StringUtils.cleanPath(image.getOriginalFilename());
//            userDTO.setPhoto(fileName);
//            try(InputStream inputStream=image.getInputStream()){
//                Path filePath=uploadPath.resolve(fileName);
//                Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
//            } catch (Exception e){
//                throw new IOException("Не может сохранить файл "+fileName);
//            }
//        }
