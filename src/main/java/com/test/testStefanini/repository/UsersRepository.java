package com.test.testStefanini.repository;

import com.test.testStefanini.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UsersRepository extends JpaRepository<Users, Long> {
}
