package com.example.demo.services;

import com.example.demo.model.StaffInfor;
import com.example.demo.model.User;
import com.example.demo.repository.StaffInforRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StaffInforRepository repository;

    public void save(User user){
        //Lan dau tao tai khoan
        StaffInfor staffInfor = new StaffInfor();
        staffInfor.setStaff_name("Unknown");
        staffInfor.setStaff_email(user.getEmail());
        staffInfor.setStaff_phone_number("Unknown");
        staffInfor.setStaff_social_link("Unknown");
        staffInfor.setStaff_address("Unknown");
        staffInfor.setStaff_image("Unknown");
        staffInfor.setStaff_gender("Unknown");

        userRepository.save(user);
        repository.save(staffInfor);
    }

    public User findUserById(Integer id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new UserNotFoundException("");
    }

    public User findingUserByUsername(String name){

        User userResult = userRepository.findByEmail(name);
        return userResult;
    }

    public User getCurrentLogginUser(Authentication authentication){
        if(authentication == null){
            return null;
        }

        User user = null;
        Object principal = authentication.getPrincipal();

        if(principal instanceof CustomUserDetail){
            user = ((CustomUserDetail)principal).getUser();
        }

        return user;
    }
}
