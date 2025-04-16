package com.soham.jounralApp.Controllers;

import com.soham.jounralApp.Entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class EntryController {

    private Map<Long, JournalEntity> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntity> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntity myentry) {
        journalEntries.put(myentry.getId(), myentry);
        return true;
    }
     @GetMapping("id/{myId}")
    public JournalEntity getJournalById(@PathVariable Long myId){
      return   journalEntries.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public JournalEntity deleteJournalById(@PathVariable Long myId){
        return   journalEntries.remove(myId);
    }
    @PutMapping("/id/{id}")
    public JournalEntity updateJournalById(@PathVariable Long myId, @RequestBody JournalEntity myEntry){
        return   journalEntries.put(myId,myEntry);
    }

}
