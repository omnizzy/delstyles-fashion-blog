package com.example.delstyles.services.Implementations;

import com.example.delstyles.dtos.request.DesignRequestDto;
import com.example.delstyles.dtos.response.DesignResponseDto;
import com.example.delstyles.entities.Design;
import com.example.delstyles.entities.User;
import com.example.delstyles.enums.UserType;
import com.example.delstyles.exceptions.InvalidDataException;
import com.example.delstyles.repositories.DesignRepository;
import com.example.delstyles.repositories.UserRepository;
import com.example.delstyles.services.DesignService;
import com.example.delstyles.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class DesignServiceImpl implements DesignService {

    private final DesignRepository designRepository;

    private final UserRepository userRepository;

    private final HttpSession session;

    @Override
    public DesignResponseDto createDesign(DesignRequestDto request, String username) {

        Optional<User> user = userRepository.findByUsername(username);

        if(user.isPresent() && user.get().getUserType().equals(UserType.ADMIN)){
            Design design = new Design();
            design.setUser(user.get());
            design.setTitle(request.getDesignTitle());
            design.setDescription(request.getDescription());
            design.setCategory(request.getCategory());
            design.setCreatedAt(LocalDateTime.now());

            Design newDesign = designRepository.save(design);

            return Mapper.createNewDesign(newDesign);
        }

        throw new InvalidDataException("This user cannot create a design");
    }

    @Override
    public DesignResponseDto findDesignByTitle(DesignRequestDto request) {

        Optional<Design> design = designRepository.findDesignByTitle(request.getDesignTitle());
        if(design.isPresent()){

            return Mapper.findDesignByTitle(design.get());

        }
        throw new InvalidDataException("Design does not exist");

    }

    @Override
    public List<DesignResponseDto> findAllDesign(String username) {
        return null;
    }


    @Override
    public List<DesignResponseDto> findDesignByCategory(DesignRequestDto request) {
        return null;
    }

    @Override
    public DesignResponseDto editDesign(DesignRequestDto request, String username) {
        return null;
    }

    @Override
    public String deleteDesign(DesignRequestDto request, String username) {

        Optional<Design> design = designRepository.findDesignByTitle(request.getDesignTitle());
        if(design.isEmpty()){
            throw new InvalidDataException("Design does not exist");
        }

        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent() && user.get().getUserType().equals(UserType.ADMIN)){
            designRepository.delete(design.get());
            return "Design successfully deleted";
        }

        throw new InvalidDataException("You are unauthorized to delete this design");
    }

}
