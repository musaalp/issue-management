package com.malp.issuemanagement.services.impl;

import com.malp.issuemanagement.entities.User;
import com.malp.issuemanagement.repositories.UserRepository;
import com.malp.issuemanagement.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service // add this service to container as a singleton
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if (user.getEmail() == null) {
            throw new IllegalArgumentException("User email cannot be null");
        }

        return this.userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return this.userRepository.getOne(id);
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public User getByUserName(String username) {
        return this.getByUserName(username);
    }
}
