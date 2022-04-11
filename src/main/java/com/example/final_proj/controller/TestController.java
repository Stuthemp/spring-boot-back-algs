package com.example.final_proj.controller;

import com.example.final_proj.exceptions.AlgorithmNotFoundException;
import com.example.final_proj.models.AlgsRate;
import com.example.final_proj.payload.request.LikesRequest;
import com.example.final_proj.payload.request.LoginRequest;
import com.example.final_proj.security.services.AlgorithmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    AlgorithmsService algorithmsService;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }
    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @PostMapping("/likes")
    public int likesQuantity(@RequestBody LikesRequest likesRequest) throws AlgorithmNotFoundException {

        String name = likesRequest.getName();
        return algorithmsService.getNumberOfLikes(name);
    }

    @PostMapping("/add_like")
    public int addLike(@RequestBody LikesRequest likesRequest) throws AlgorithmNotFoundException {
        String name = likesRequest.getName();
        System.out.println(name);
        AlgsRate alg = algorithmsService.getAlgorithmByName(name);
        int currLikes = alg.getLikes();
        int updatedLikes = currLikes  + 1;
        algorithmsService.setLikesQuantity(name,updatedLikes);
        return updatedLikes;
    }

    @PostMapping("/subtract_like")
    public int subtractLike(@RequestBody LikesRequest likesRequest) throws AlgorithmNotFoundException {
        String name = likesRequest.getName();
        AlgsRate alg = algorithmsService.getAlgorithmByName(name);
        int currLikes = alg.getLikes();
        int updatedLikes = currLikes  - 1;
        algorithmsService.setLikesQuantity(name,updatedLikes);
        return updatedLikes;
    }
}
