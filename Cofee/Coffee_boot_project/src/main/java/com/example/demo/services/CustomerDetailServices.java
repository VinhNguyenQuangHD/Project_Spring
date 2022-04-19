package com.example.demo.services;

import com.example.demo.model.CustomerInfor;
import com.example.demo.model.Production;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetailServices {
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerInfor> ListAll(){
        return customerRepository.findAll();
    }

    public void saveInforCustomer(CustomerInfor infor){
        customerRepository.save(infor);
    }

    public void deleteCustomer(Integer id){
        customerRepository.deleteById(id);
    }

    public CustomerInfor FindCustomerId(Integer id) throws UserNotFoundException {
        Optional<CustomerInfor> customerInfor = customerRepository.findById(id);
        if(customerInfor.isPresent()){
            return customerInfor.get();
        }
        throw new UserNotFoundException("User not found !!!");
    }
}
