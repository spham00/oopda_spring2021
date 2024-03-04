import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookCompare {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Book book1 = new Book("It", "Stephen King", 1986, 1138);
		Book book2 = new Book("Hatchet", "Gary Paulsen", 1986, 208);
		Book book3 = new Book("Game of Thrones", "George R.R. Martin", 1996, 694);
		Book book4 = new Book("A Clash of Kings", "George R.R. Martin", 2000, 1040);
		Book book5 = new Book("A Storm of Swords", "George R.R. Martin", 2003, 1216);
		Book book6 = new Book("A Feast for Crows", "George R.R. Martin", 2007, 784);
		Book book7 = new Book("A Dance With Dragons", "George R.R. Martin", 2013, 1056);
		Book book8 = new Book("The Winds of Winter", "George R.R. Martin", 2020, 90);
		Book book9 = new Book("A Dream of Spring", "George R.R. Martin", 2028, 60);
		Book book10 = new Book("It", "Stephen King", 1986, 1138);

		System.out.println("Enter H for HashSet, L for LinkedHashSet or T for TreeSet: ");
		Scanner sc = new Scanner(System.in);
		char option = sc.next().toUpperCase().charAt(0);

		Set<Book> books = null; // Polymorphism
		switch (option) {
		case 'H':
			books = new HashSet<Book>();
			System.out.println("Using HashSets");
			break;
		case 'L':
			books = new LinkedHashSet<Book>();
			System.out.println("Using LinkedHashSets");
			break;
		case 'T':
			books = new TreeSet<Book>();
			System.out.println("Using TreeSets");
			break;
		}
		
		sc.close();
		
		// Add books in haphazard order
		books.add(book8);  // Winds of Winter
		books.add(book3);  // Game of Thrones
		books.add(book2);  // Hatchet
		books.add(book7);  // A Dance With Dragons
		books.add(book1);  // It
		books.add(book5);  // A Storm of Swords
		books.add(book4);  // A Clash of Kings
		books.add(book6);  // A Feast for Crows
		books.add(book9);  // A Dream of Spring	
		books.add(book10); // It (again)
		
		System.out.println("\n-- Iteration\n");		
		books.forEach(b -> System.out.println(b.getPublicationYear() + " " + b.getTitle()));
	}
}