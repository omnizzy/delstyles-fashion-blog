package com.example.delstyles.services;

import com.example.delstyles.dtos.request.DesignRequestDto;
import com.example.delstyles.dtos.response.DesignResponseDto;

import java.util.List;

public interface DesignService {

    DesignResponseDto createDesign(DesignRequestDto request, String username);

    DesignResponseDto findDesignByTitle(DesignRequestDto request);

    List<DesignResponseDto> findAllDesign(String username);

    List<DesignResponseDto> findDesignByCategory(DesignRequestDto request);

    DesignResponseDto editDesign(DesignRequestDto request, String username);

    String deleteDesign(DesignRequestDto request, String username);

}
