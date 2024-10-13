package com.yui.projectApi.service;

import com.yui.projectApi.entities.User;
import com.yui.projectApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User save(User user){
        return repository.save(user);
    }

    public User update(Integer id, User updateUser){
        return repository.findById(id)
                .map(user -> {
                    user.setName(updateUser.getName());
                    user.setEmail(updateUser.getEmail());
                    user.setTel(updateUser.getTel());

                    return repository.save(user);
                })
                .orElse(null);

    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
