package com.ryankolbe.repository.implementation;

import com.ryankolbe.model.User;
import com.ryankolbe.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepository userRepository = null;
    private Set<User> users;

    private UserRepositoryImpl() {
        this.users = new HashSet<>();
    }

    public static UserRepository getUserRepository() {
        if (userRepository == null) userRepository = new UserRepositoryImpl();
        return userRepository;
    }

    @Override
    public User create(User user) {
        this.users.add(user);
        return user;
    }

    @Override
    public User read(final String userId) {
        return search(userId);
    }

    @Override
    public User update(User user) {
        User userTemp = search(user.getUserId());
        if (userTemp != null) {
            User userNew = new User.Builder()
                    .copy(userTemp)
                    .build();
            return create(userNew);
        }
        return null;
    }

    @Override
    public void delete(String userId) {
        User user = search(userId);
        if (userId != null) this.users.remove(user);
    }

    public User search(final String userId) {
        for (User userSearch : this.users) {
            if (userSearch.getUserId().equals(userId))
                return userSearch;
        }
        return null;
    }

    @Override
    public Set<User> getAll() {
        return this.users;
    }
}
