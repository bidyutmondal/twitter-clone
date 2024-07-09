package com.example.user_management.service;

import com.example.user_management.entity.User;
import com.example.user_management.entity.UserRelationship;
import com.example.user_management.repository.UserRelationshipRepository;
import com.example.user_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagementService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRelationshipRepository userRelationshipRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
//        if (existingUser.isPresent()) {
//            updatedUser.setId(id);
//            return Optional.of(userRepository.save(updatedUser));
//        }
        return Optional.empty();
    }

    public boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean followUser(Long followerId, Long followingId) {
        List<UserRelationship> follower = userRelationshipRepository.findByFollowerId(followerId);
        Optional<User> following = userRepository.findById(followingId);
//        if (follower.isPresent() && following.isPresent()) {
//            Optional<UserRelationship> existingRelationship =
//                    userRelationshipRepository.findByFollowerIdAndFollowingId(followerId, followingId);
//            if (!existingRelationship.isPresent()) {
//                UserRelationship userRelationship = new UserRelationship();
//                userRelationship.setFollower(follower.get());
//                userRelationship.setFollowing(following.get());
//                userRelationshipRepository.save(userRelationship);
//                return true;
//            }
//        }
        return false;
    }

    public boolean unfollowUser(Long followerId, Long followingId) {
        Optional<User> follower = userRepository.findById(followerId);
        Optional<User> following = userRepository.findById(followingId);
//        if (follower.isPresent() && following.isPresent()) {
//            Optional<UserRelationship> existingRelationship =
//                    userRelationshipRepository.findByFollowerIdAndFollowingId(followerId, followingId);
//            if (existingRelationship.isPresent()) {
//                userRelationshipRepository.delete(existingRelationship.get());
//                return true;
//            }
//        }
        return false;
    }

}
