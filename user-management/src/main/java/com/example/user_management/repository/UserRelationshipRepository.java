package com.example.user_management.repository;

import com.example.user_management.entity.UserRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRelationshipRepository extends JpaRepository<UserRelationship, Long> {
    List<UserRelationship> findByFollowerId(Long followerId);

    List<UserRelationship> findByFollowingId(Long followingId);

    Optional<UserRelationship> findByFollowerIdAndFollowingId(Long followerId, Long followingId);
}
