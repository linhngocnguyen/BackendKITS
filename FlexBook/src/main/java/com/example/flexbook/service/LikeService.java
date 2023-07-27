package com.example.flexbook.service;

import com.example.flexbook.model.Like;
import com.example.flexbook.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public Like createLike(Like newLike){
        newLike.setCreated_at(Timestamp.from(Instant.now()));
        return likeRepository.save(newLike);
    }
    public List<Like> getLikeByUser(int user_id){
        return likeRepository.likesByUser(user_id);
    }
}
