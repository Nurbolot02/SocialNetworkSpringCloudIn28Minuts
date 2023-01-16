package com.ntg.socialnetworkspringcloudin28minuts.service.impl;

import com.ntg.socialnetworkspringcloudin28minuts.model.User;
import com.ntg.socialnetworkspringcloudin28minuts.service.abstracts.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final Map<Long, User> userMap = new HashMap<>();

    {
        User adam = User.builder()
                .id(1L)
                .name("Adam")
                .birthDate(LocalDate.now().minusYears(30))
                .build();
        userMap.put(adam.getId(), adam);

        User eva = User.builder()
                .id(2L)
                .name("Eva")
                .birthDate(LocalDate.now().minusYears(25))
                .build();
        userMap.put(eva.getId(), eva);

        User child = User.builder()
                .id(3L)
                .name("Child")
                .birthDate(LocalDate.now().minusYears(7))
                .build();
        userMap.put(child.getId(), child);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public List<User> findAllUsers() {
        return userMap.values().stream().toList();
    }

    @Override
    public void createUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public void updateUser(Long id, User user) {
        userMap.put(id, user);
    }

    @Override
    public void deleteUser(Long user) {
        userMap.remove(user);
    }
}
