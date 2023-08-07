package com.example.delstyles.services.Implementations;

import com.example.delstyles.dtos.request.UserLoginRequestDto;
import com.example.delstyles.dtos.request.UserRequestDto;
import com.example.delstyles.dtos.response.UserResponseDto;
import com.example.delstyles.entities.User;
import com.example.delstyles.exceptions.InvalidDataException;
import com.example.delstyles.repositories.UserRepository;
import com.example.delstyles.services.UserService;
import com.example.delstyles.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto request) {

        Optional<User> checkUsernameAvailability
                = userRepository.findByUsername(request.getUsername());

        if(checkUsernameAvailability.isPresent()){
            throw new InvalidDataException("This user already exists");
        }

        return Mapper.createNewUser(userRepository.save(User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .userType(request.getUserType())
                .build()));
    }


    @Override
    public UserResponseDto loginUser(UserLoginRequestDto request) {

        Optional<User> user = userRepository.findByUsername(request.getUsername());

        if(user.isPresent()){
            return Mapper.loginUser(user.get());
        }

        throw new InvalidDataException("User not found");
    }
}
