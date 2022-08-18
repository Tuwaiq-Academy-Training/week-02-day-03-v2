package com.example.userdate.repository;


import com.example.userdate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User getById(Integer id);
    User findUserByEmail(String email);
    List<User> findUserByAgeGreaterThanEqual(Integer age);
    @Query("SELECT COUNT (u) FROM User u where u.role=?1")
    Integer getRoles(String role);
    User findUserByUsernameAndPassword(String username,String password);
    @Query("SELECT u FROM User u where u.age=?1 and u.joiningYear<=?2")
    List<User> ageAndJoinintgYear(Integer age,String  joiningYear);
    @Query("SELECT  u from User u where u.joiningYear =?1")
    List<User> getUsersByJoiningYear(String joiningYear);
    @Query("SELECT u from User u where u.joiningYear =?1 and u.id =?2")
    User checkJoinYear(String  joiningYear,Integer id);
}