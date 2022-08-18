package com.example.userdate.service;

import com.example.userdate.model.User;
import com.example.userdate.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public void addUser(User user){
        userRepository.save(user);
    }
    public User findUserById(Integer id){
        return userRepository.getById(id);
    }
    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
    public List<User> findUserByAgeGreaterThanEqual(Integer age){
        return userRepository.findUserByAgeGreaterThanEqual(age);
    }
    public  Integer getRoles(String role){
        return userRepository.getRoles(role);
    }

    public boolean checkUsers(String username,String password){
        if(userRepository.findUserByUsernameAndPassword(username,password)!= null)
            return true;
        return false;
    }
    public List<User> ageAndJoinintgYear(Integer age,String joiningYear){
        return userRepository.ageAndJoinintgYear(age,joiningYear);
    }
    public boolean updateUser(User user,Integer id){
        User newUser = userRepository.getById(id);
        if(newUser != null) {
            if (newUser.getRole().equals("Admin")) {
                newUser.setUsername(user.getUsername());
                newUser.setEmail(user.getEmail());
                newUser.setPassword(user.getPassword());
                newUser.setAge(user.getAge());
                newUser.setJoiningYear(user.getJoiningYear());
                userRepository.save(newUser);
                return true;
            }
        }
        return false;
    }
    public boolean updatePassword(Integer id,String password){
        User newUser = userRepository.getById(id);
        if(newUser != null){
            newUser.setPassword(password);
            userRepository.save(newUser);
            return true;
        }
        return false;
    }
    public boolean checkJoinYear(String joiningYear, Integer id)  {
        User checkUser = userRepository.checkJoinYear(joiningYear,id);
        if(checkUser != null){
            if(checkUser.getJoiningYear().equals(joiningYear))
                return true;
        }

        return false;
    }
    public  List<User> getUsersByJoiningYear(String joiningYear){
        return userRepository.getUsersByJoiningYear(joiningYear);
    }
}