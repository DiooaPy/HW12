package de.uni.koeln.se.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import de.uni.koeln.se.bookstore.datamodel.Book;


@SpringBootApplication
@EntityScan(basePackages = "de.uni.koeln.se.bookstore.datamodel")
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		
	}

}
