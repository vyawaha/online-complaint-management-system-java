package repository;


import model.User;

import java.util.ArrayList;
import java.util.List;



/**
 * Repository class responsible for
 * User data management.
 *
 * Currently uses ArrayList.
 *
 * Later can be replaced with JDBC/MySQL.
 */
public class UserRepository {


    private final List<User> users;



    public UserRepository() {

        users = new ArrayList<>();

    }



    /**
     * Save new user
     */
    public void save(
            User user
    ) {

        users.add(user);

    }



    /**
     * Find user by email
     */
    public User findByEmail(
            String email
    ) {


        for(User user : users) {


            if(user.getEmail()
                    .equalsIgnoreCase(email)) {


                return user;

            }

        }


        return null;

    }



    /**
     * Find user by ID
     */
    public User findById(
            int userId
    ) {


        for(User user : users) {


            if(user.getUserId() == userId) {


                return user;

            }

        }


        return null;

    }



    /**
     * Check duplicate email
     */
    public boolean existsByEmail(
            String email
    ) {


        return findByEmail(email) != null;


    }



    /**
     * Return all users
     */
    public List<User> findAll() {


        return users;

    }


}