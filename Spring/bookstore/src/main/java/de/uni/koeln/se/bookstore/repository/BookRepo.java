package de.uni.koeln.se.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;
import de.uni.koeln.se.bookstore.datamodel.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
    
}
