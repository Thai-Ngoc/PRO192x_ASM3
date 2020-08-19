package library_manager;
import java.util.*;
public class BookList {
	private Scanner in = new Scanner(System.in);
	List<Book> myBooks = new ArrayList<>();
	public void add() {
		System.out.println("Enter information for the new book");
		
		
		System.out.print("ID: ");
		String id = in.nextLine();
		
		System.out.println("Title: ");
		String title = in.nextLine();
		
		System.out.println("Author: ");
		String author = in.nextLine();
		
		System.out.println("Is borrowed (1 = yes, 0 = no): ");
		int choice = in.nextInt();
		
		Boolean isBorrowed = false;
		switch(choice) {
		case 1:
			isBorrowed = true;
			break;
		case 2:
			isBorrowed = false;
			break;
		}
		
		addToList(id.toUpperCase(), title, author, isBorrowed);
		System.out.println("A new book has been added");
	}
	
	public void addToList(String id, String title, String author, Boolean isBorrowed) {
		Book book = new Book(id.toUpperCase(), title, author, isBorrowed);
		myBooks.add(book);
	}
	
	public void Search() {
		List<Book> booksFound = new ArrayList<>();
		String searchKey = in.nextLine();
		for (Book book : myBooks) {
			if (book.getTitle().contains(searchKey) ) {
				booksFound.add(book);
			}
		}
		if (booksFound.isEmpty()) {
			System.out.println("No book is found");
		} else {
			System.out.println(String.format("%-10%s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borrowed"));
			for(Book book : booksFound) {
				System.out.println(book.toString());
			}
		}
	}
	
	public void Display() {
		System.out.printf("%-10s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borrowed");
		for (Book book : myBooks) {
			System.out.println(book.toString());
		}
	}
}