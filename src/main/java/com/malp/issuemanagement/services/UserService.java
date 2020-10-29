package com.malp.issuemanagement.services;

import com.malp.issuemanagement.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);

    User getById(Long id);

    Page<User> getAll(Pageable pageable);

    User getByUserName(String username);
}
