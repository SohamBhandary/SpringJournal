package com.soham.jounralApp.Controllers;

import com.soham.jounralApp.Entity.JournalEntity;
import com.soham.jounralApp.Service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class EntryController {

    @Autowired
     private JournalService js;


    @GetMapping
    public List<JournalEntity> getAll(){
      return   js.getAll();
    }



    @PostMapping
    public ResponseEntity<JournalEntity> createEntry(@RequestBody JournalEntity myentity) {
        myentity.setDate(LocalDateTime.now());
        JournalEntity savedEntity = js.saveEntry(myentity);
        return new ResponseEntity<>(savedEntity, HttpStatus.CREATED); // 201 Created is more appropriate
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntity> getJournalById(@PathVariable ObjectId myId) {
        Optional<JournalEntity> journal = js.findById(myId);
        if (journal.isPresent()) {
            return new ResponseEntity<>(journal.get(), HttpStatus.OK); // 200 OK with body
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
        }
    }


    @DeleteMapping("id/{myId}")
    public ResponseEntity<Void> deleteJournalById(@PathVariable ObjectId myId) {
        js.deleteJournalById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
    }

    @PutMapping("/id/{myId}")
    public ResponseEntity<JournalEntity> updateJournalById(@PathVariable ObjectId myId, @RequestBody JournalEntity newEntry) {
        Optional<JournalEntity> optionalOld = js.findById(myId);

        if (optionalOld.isPresent()) {
            JournalEntity old = optionalOld.get();

            // Only update fields if new values are provided
            if (newEntry.getTitle() != null && !newEntry.getTitle().trim().isEmpty()) {
                old.setTitle(newEntry.getTitle());
            }

            if (newEntry.getContent() != null && !newEntry.getContent().trim().isEmpty()) {
                old.setContent(newEntry.getContent());
            }

            // Save updated journal entry
            JournalEntity updated = js.saveEntry(old);

            // Return updated entry with 200 OK
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            // Return 404 Not Found if entity is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
