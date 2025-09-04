package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface UserRepository extends MongoRepository<User, ObjectId> {

   // In Java interfaces, all methods are implicitly public abstract, even if you don’t explicitly write public.
    User findByUserName(String userName);

    //Spring Data JPA / MongoDB allows you to Just declare a method in the repository interface, and Spring will auto-implement it at runtime based on the method name.

    void deleteByUserName(String username);
}

//controller --> service --> repository