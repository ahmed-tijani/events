package com.example.evennemntuser.Services;

import com.example.evennemntuser.Entities.User;

public interface IUserService {

    User addUser(User user);
    User updateUser(int id, User newUser);
    String deleteUser(int id);
}
