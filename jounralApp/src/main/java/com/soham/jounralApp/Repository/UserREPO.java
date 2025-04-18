package com.soham.jounralApp.Repository;

import com.soham.jounralApp.Entity.JournalEntity;
import com.soham.jounralApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserREPO extends MongoRepository  <User, ObjectId>{
User findByUserName(String username);

}
