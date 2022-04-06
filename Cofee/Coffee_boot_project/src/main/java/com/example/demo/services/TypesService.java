package com.example.demo.services;

import com.example.demo.model.Types;
import com.example.demo.repository.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class TypesService {

    @Autowired
    private TypesRepository repo;

    public List<Types> findAllTypes(){
        return repo.findAll();
    }

    public void saveTypes(Types types){
        repo.save(types);
    }

    public void deleteTypes(Integer id){
        repo.deleteById(id);
    }

    public Types findByID(Integer id){
        Optional<Types> result = repo.findById(id);
        return result.get();
    }


}
