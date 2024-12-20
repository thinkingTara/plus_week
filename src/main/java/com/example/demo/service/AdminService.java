package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class AdminService {
    private final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: 4. find or save 예제 개선  -> findByIdIn , saveAll 로 변경
    @Transactional
    public void reportUsers(List<Long> userIds) {
        List<User> userList = userRepository.findByIdIn(userIds);
        List<User> updatedUsers = userList
                .stream()
                .map(user-> {user.updateStatusToBlocked();
                    return user;
                })
                .collect(Collectors.toList());

        userRepository.saveAll(updatedUsers);
//        for (Long userId : userIds) {
//            User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 ID에 맞는 값이 존재하지 않습니다."));
//
//            user.updateStatusToBlocked();
//
//            userRepository.save(user);
//        }
    }
}
