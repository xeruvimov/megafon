package com.megafon.task.mapper;

import com.megafon.task.domain.User;
import com.megafon.task.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends AbstractEntityMapper<UserDTO, User> {
}
