package com.soham.jounralApp.Service;

import com.soham.jounralApp.Entity.JournalEntity;
import com.soham.jounralApp.Repository.JournalREPO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalService {
    @Autowired
    private JournalREPO jr;

    public JournalEntity saveEntry(JournalEntity je){
     jr.save(je);

        return je;
    }
    public List<JournalEntity> getAll(){
        return jr.findAll();
    }

    public Optional<JournalEntity> findById(ObjectId id){
        return jr.findById(id);
    }

    public void deleteJournalById(ObjectId id){
        jr.deleteById(id);

    }



}
