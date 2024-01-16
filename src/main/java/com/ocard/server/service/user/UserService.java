package com.ocard.server.service.user;

import com.ocard.server.dto.user.CreateUserDTO;
import com.ocard.server.dto.user.UpdateUserDTO;
import com.ocard.server.dto.user.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Integer userId);

    UserDTO createUser(CreateUserDTO createUserDTO);

    UserDTO updateUser(Integer userId, UpdateUserDTO updateUserDTO);

    String deleteUser(Integer userId);
}
