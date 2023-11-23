package com.repository;

import com.model.UserDetailsHasChatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsHasChatsRepository extends JpaRepository<UserDetailsHasChatsEntity,Integer> {
}
