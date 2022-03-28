package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repo;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("hello@gmail.com");
        user.setPassword("123456");
        user.setUsername("testguy");

        User saved_user = repo.save(user);

        Assertions.assertThat(saved_user).isNotNull();
        Assertions.assertThat(saved_user.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        Iterable<User> user = repo.findAll();
        Assertions.assertThat(user).hasSizeGreaterThan(0);

        for(User user1 : user){
            System.out.println(user1);
        }
    }

    @Test
    public void testUpdate(){
        Integer userId = 1;
        Optional<User> optimizeUser = repo.findById(userId);

        User user = optimizeUser.get();
        user.setPassword("Not like what y think");
        repo.save(user);

        User updateU = repo.findById(userId).get();
        Assertions.assertThat(updateU.getPassword()).isEqualTo("Not like what y think");

    }

    @Test
    public void testGet(){
        Integer userId = 1;

        Optional<User> optimizeUser = repo.findById(userId);
        Assertions.assertThat(optimizeUser).isPresent();
        System.out.println(optimizeUser.get());
    }

    @Test
    public void testDelete(){
        Integer userId = 1;

        repo.deleteById(userId);

        Optional<User> optimizeUser = repo.findById(userId);
        Assertions.assertThat(optimizeUser).isNotPresent();
    }
}
