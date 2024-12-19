package am.itspace.authorbook.service;


import am.itspace.authorbook.entity.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findByEmail(String email);
}
