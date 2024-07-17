package com.portal.portal.usuario.service;

import com.portal.portal.usuario.entity.User;
import com.portal.portal.usuario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{
    private  UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
    public List<User> getAllUsers(){return userRepository.findAll();}
    public void deleteUser(Long id){userRepository.deleteById(id);}
    public User updateUser(Long id, User userDetails){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User userExistente = user.get();
            if (userDetails.getName() != null){
                userExistente.setName(userDetails.getName());
            }else if (userDetails.getEmail() != null){
                userExistente.setEmail(userDetails.getEmail());
            }else if(userDetails.getAddres() != null){
                userExistente.setAddres(userDetails.getAddres());
            }
            return userRepository.save(userExistente);
        }else{
            throw new IllegalArgumentException("No se puede eliminar el usuario");
        }
    }

}
