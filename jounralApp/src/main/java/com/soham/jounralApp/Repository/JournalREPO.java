package com.soham.jounralApp.Repository;

import com.soham.jounralApp.Entity.JournalEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalREPO extends MongoRepository  <JournalEntity, ObjectId>{


}
