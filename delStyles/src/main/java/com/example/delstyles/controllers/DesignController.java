package com.example.delstyles.controllers;

import com.example.delstyles.dtos.request.DesignRequestDto;
import com.example.delstyles.dtos.response.DesignResponseDto;
import com.example.delstyles.services.DesignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/delstyles")
public class DesignController {
    private final DesignService designService;

    private final HttpSession session;

    @PostMapping(path="/createdesign")
    public ResponseEntity<DesignResponseDto> createDesign(@RequestBody DesignRequestDto request) {
        return ResponseEntity.ok(designService.createDesign(request, (String) session.getAttribute("username")));
    }

    @PostMapping(path="/finddesignbytitle")
    ResponseEntity<?> findDesignByTitle(@RequestBody DesignRequestDto request){
        return ResponseEntity.ok(designService.findDesignByTitle(request));
    }

    @DeleteMapping(path="/deletedesign")
    ResponseEntity<?> deleteDesign(@RequestBody DesignRequestDto request){
        return ResponseEntity.ok(designService.deleteDesign(request, (String)session.getAttribute("username")));
    }
}
