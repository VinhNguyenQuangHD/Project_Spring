package com.example.demo.services;

import com.example.demo.model.StaffInfor;
import com.example.demo.repository.StaffInforRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class StaffInforService {

    @Autowired
    private StaffInforRepository staffInforRepository;

    public List<StaffInfor> show_all_staff_infor(){
        return staffInforRepository.findAll();
    }

    public StaffInfor findStaffByEmail(String email) throws UserNotFoundException{
        StaffInfor staff = staffInforRepository.findByEmail(email);
        if(staff == null){
            throw new UsernameNotFoundException("User not found !!!");
        }
        return staff;
    }

    public void StaffSaveInformation(MultipartFile file,StaffInfor staffInfor) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        if(filename.contains("..")){
            System.out.print("Invalid file !!!");
        }
        else {
            staffInfor.setStaff_image(Base64.getEncoder().encodeToString(file.getBytes()));
        }
        staffInforRepository.save(staffInfor);
    }

    public StaffInfor findStaffInforById(Integer id) throws UserNotFoundException{
        Optional<StaffInfor> staff = staffInforRepository.findById(id);
        if(staff.isPresent()){
            return staff.get();
        }
        throw new UserNotFoundException("");
    }

    public void deleteStaffInfor(Integer id){
        staffInforRepository.deleteById(id);
    }
}
