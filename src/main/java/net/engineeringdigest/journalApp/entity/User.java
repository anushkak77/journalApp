package net.engineeringdigest.journalApp.entity;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor   // 👈 add this
@AllArgsConstructor
@Document(collection = "users")
@Data
@Builder
public class User {
    @Id
    private ObjectId id;
    @Indexed(unique = true)    //beacuase of indexing we can search document fast
    @NonNull   // username should not be null
    private String userName;
    @NonNull
    private String password;
    @DBRef     //it will only save the references of JournalEntry in the journalEntries list. Its basically act as a foreign key here which connects users and journal tables.
    private List<JournalEntry> journalEntries = new ArrayList<>();
    private List<String> roles;   // roles means what is the user is authorized to do.
}
