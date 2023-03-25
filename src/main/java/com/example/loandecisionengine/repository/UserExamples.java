package com.example.loandecisionengine.repository;

import com.example.loandecisionengine.entity.User;

import java.util.Arrays;
import java.util.List;

public class UserExamples {

    // Hardcoded Users
    public UserExamples() {
    }

    User example1 = new User(
            49002010965L,
            0
    );
    User example2 = new User(
            49002010976L,
            1
    );
    User example3 = new User(
            49002010987L,
            2
    );
    User example4 = new User(
            49002010998L,
            3
    );

    List<User> usersExamples = Arrays.asList(example1, example2, example3, example4);

    public User getUserByPersonalCode(long personalCode) {

        for (User user : usersExamples){
            if (user.getPersonalCode() == personalCode){
                return user;
            }
        }
        return null;
    }
}
