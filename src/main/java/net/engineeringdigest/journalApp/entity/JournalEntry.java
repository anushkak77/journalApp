package net.engineeringdigest.journalApp.entity;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "journal_entries")    // if you do not add collection name, document will find the colection as JournalEntry
public class JournalEntry {

    @Id  //it maps id as a primary key
    private ObjectId id;

    @NonNull
    private String title;

    private String content;

//    private LocalDateTime date;
    private LocalDateTime date = LocalDateTime.now();


}
