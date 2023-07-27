package com.example.flexbook.controller;

import com.example.flexbook.model.Like;
import com.example.flexbook.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    private LikeService LikeService;

    @GetMapping("/{user_id}")
    public List<Like> getLikesByUser(@PathVariable int user_id) {
        return LikeService.getLikeByUser(user_id);
    }

    @PostMapping("/create")
    public ResponseEntity<Like> createLike(@RequestBody Like like){
        Like newLike = LikeService.createLike(like);
        return ResponseEntity.ok().body(newLike);
    }
}
