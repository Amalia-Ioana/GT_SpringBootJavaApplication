package com.AmaliaStefan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.AmaliaStefan.entity.Users;
import com.AmaliaStefan.reporitory.UserRepository;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public boolean registerNewUser(String username, String password, String role) {
        if (userRepository.existsByUsername(username)) {
            return false; // utilizatorul deja exista
        }

        // Encode the password
        String encodedPassword = passwordEncoder.encode(password);

        // Create new user with default role "ROLE_USER"
        Users newUser = new Users(username, encodedPassword, role, true);
        userRepository.save(newUser);
        return true;
    }


//    public boolean registerNewUser(String username, String password, String role) {
//        if (userRepository.existsByUsername(username)) {
//            return false; // utilizatorul deja exista
//        }
//        // Verifica daca rolul este "admin" si daca in cazul in care incearca sa se logeze cu admin, se seteaza la "user"
//        if ("admin".equalsIgnoreCase(role)) {
//            role = "user";
//        }
//        
//        String encodedPassword = passwordEncoder.encode(password);
//        // enabled = 1 
//        Users newUser = new Users(username, encodedPassword, role, true);
//        userRepository.save(newUser);
//        return true;
//    }
}
