package service;


import model.Role;
import model.User;

import repository.UserRepository;

import utility.IdGenerator;
import utility.ValidationUtil;



/**
 * Handles user related business operations.
 */
public class UserService {


    private final UserRepository userRepository;



    public UserService(
            UserRepository userRepository
    ) {

        this.userRepository = userRepository;

    }



    /**
     * Register normal USER
     */
    public User registerUser(
            String name,
            String email,
            String password
    ) {



        if(!ValidationUtil.isValidName(name)) {

            throw new RuntimeException(
                    "Invalid name"
            );

        }



        if(!ValidationUtil.isValidEmail(email)) {

            throw new RuntimeException(
                    "Invalid email"
            );

        }



        if(!ValidationUtil.isValidPassword(password)) {

            throw new RuntimeException(
                    "Password must contain minimum 4 characters"
            );

        }



        if(userRepository.existsByEmail(email)) {


            throw new RuntimeException(
                    "Email already registered"
            );


        }




        User user =
                new User(

                        IdGenerator.generateUserId(),
                        name,
                        email,
                        password,
                        Role.USER

                );



        userRepository.save(user);



        return user;


    }







    /**
     * Create ADMIN account
     *
     * Used for demo/admin setup.
     */
    public User createAdmin(

            String name,
            String email,
            String password

    ) {



        if(userRepository.existsByEmail(email)) {


            return userRepository.findByEmail(email);


        }



        User admin =
                new User(

                        IdGenerator.generateUserId(),
                        name,
                        email,
                        password,
                        Role.ADMIN

                );



        userRepository.save(admin);



        return admin;


    }








    /**
     * Login user/admin
     */
    public User login(
            String email,
            String password
    ) {


        User user =
                userRepository.findByEmail(email);



        if(user == null) {


            throw new RuntimeException(
                    "User not found"
            );


        }



        if(!user.getPassword()
                .equals(password)) {


            throw new RuntimeException(
                    "Invalid password"
            );


        }



        return user;


    }








    /**
     * Find user
     */
    public User getUserById(
            int id
    ) {


        return userRepository.findById(id);


    }



}