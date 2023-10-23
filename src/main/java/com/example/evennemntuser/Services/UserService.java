package com.example.evennemntuser.Services;

import com.example.evennemntuser.Entities.User;
import com.example.evennemntuser.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{


    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int id, User newUser) {
        if (userRepository.findById(id).isPresent()) {
            User existingCandidat = userRepository.findById(id).get();
            existingCandidat.setNom(newUser.getNom());
            existingCandidat.setPrenom(newUser.getPrenom());
            existingCandidat.setEmail(newUser.getEmail());
            return userRepository.save(existingCandidat);
        } else
            return null;
    }

    public String deleteUser(int id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "candidat supprimé";
        } else
            return "candidat non supprimé";
    }

}

