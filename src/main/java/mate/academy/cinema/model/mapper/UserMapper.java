package mate.academy.cinema.model.mapper;

import mate.academy.cinema.model.User;
import mate.academy.cinema.model.dto.UserRequestDto;
import mate.academy.cinema.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User convertToUser(UserRequestDto requestDto) {
        User user = new User();
        user.setPassword(requestDto.getPassword());
        user.setEmail(requestDto.getEmail());
        return user;
    }

    public UserResponseDto convertToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
