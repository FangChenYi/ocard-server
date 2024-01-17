package com.ocard.server.mapper.user;

import com.ocard.server.dto.user.CreateUserDTO;
import com.ocard.server.dto.user.UpdateUserDTO;
import com.ocard.server.dto.user.UserDTO;
import com.ocard.server.model.user.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    List<UserDTO> userlistToUserDTOlist(List<User> userList);

    UserDTO usertoUserDTO(User user);

    User createUserDTOtoUser(CreateUserDTO createUserDTO);

    User updateUserDTOtoUser(UpdateUserDTO updateUserDTO);
}
