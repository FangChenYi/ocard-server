package com.ocard.server.service.user;

import com.ocard.server.dto.user.CreateUserDTO;
import com.ocard.server.dto.user.UpdateUserDTO;
import com.ocard.server.dto.user.UserDTO;
import com.ocard.server.mapper.user.UserMapper;
import com.ocard.server.model.user.User;
import com.ocard.server.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = (List<User>) userRepository.findAll();
        List<UserDTO> userDTOList = userMapper.userlistToUserDTOlist(userList);
        return userDTOList;
    }

    @Override
    public UserDTO getUserById(Integer userId) throws NoSuchElementException {
        Optional<User> userExisting = userRepository.findById(userId);
        UserDTO userDTO = userMapper.usertoUserDTO(userExisting.get());
        return userDTO;
    }

    @Override
    public UserDTO createUser(CreateUserDTO createUserDTO) {
        User user = userMapper.createUserDTOtoUserDTO(createUserDTO);
        user.setRegistrationDate(LocalDateTime.now());
        userRepository.save(user);
        UserDTO userDTO = userMapper.usertoUserDTO(user);
        return userDTO;
    }


    @Override
    public UserDTO updateUser(Integer userId,
                              UpdateUserDTO updateUserDTO) throws NoSuchElementException {
        Optional<User> userExisting = userRepository.findById(userId);
        User user = userMapper.updateUserDTOtoUser(updateUserDTO);
        user.setUserId(userId);
        user.setRegistrationDate(userExisting.get().getRegistrationDate());
        userRepository.save(user);
        UserDTO userDto = userMapper.usertoUserDTO(user);
        return userDto;
    }

    @Override
    public String deleteUser(Integer userId) throws NoSuchElementException {
        Optional<User> userExisting = userRepository.findById(userId);
        userRepository.deleteById(userExisting.get().getUserId());
        return "Delete userId success.";
    }
}
