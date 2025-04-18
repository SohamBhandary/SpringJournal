package com.soham.jounralApp.Service;

import com.soham.jounralApp.Entity.JournalEntity;
import com.soham.jounralApp.Entity.User;
import com.soham.jounralApp.Repository.JournalREPO;
import com.soham.jounralApp.Repository.UserREPO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserREPO userREPO;
    public void saveEntry(User user){
        userREPO.save(user);
    }
    public List<User> getAll(){
        return userREPO.findAll();
    }

    public Optional<User> findById(ObjectId id ){
        return userREPO.findById(id);
    }

    public void deleteById(ObjectId id){
        userREPO.deleteById(id);
    }
    public User findByUserName(String username){
        return userREPO.findByUserName(username);
    }




}
