package library_manager;
import java.util.*;
public class BookList {
	Scanner in;
	List<Book> myBooks = new ArrayList<>();
	public void add() {
		//enter information of books by Scanner
		in = new Scanner(System.in);
		System.out.println("Enter information for the new book");
		System.out.print("ID: ");
		String id = "";
		while(in.hasNext()) {
			id = in.next();
			if(checkId(id)) {
				break;
			} else {
				System.out.print("ID has already existed, please type again ");
				
			}
		}
		
		in.nextLine();
		
		System.out.print("Title: ");
		String title = in.nextLine();
		
		System.out.print("Author: ");
		String author = in.nextLine();
		
		System.out.print("Is borrowed (1 = yes, 0 = no): ");
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
		//add books to the library
		addToList(id.toUpperCase(), title, author, isBorrowed);
		System.out.println("A new book has been added");
		System.out.println();
	}
	
	 boolean checkId(String s) {
		for(Book abook : myBooks) {
			if(abook.getId().equals(s)) {
				return false;
			}
		}
		return true;
		
	}
	
	public void addToList(String id, String title, String author, Boolean isBorrowed) {
		//method add books to library
		Book book = new Book(id.toUpperCase(), title, author, isBorrowed);
		myBooks.add(book);
	}
	
	public void Search() {
		//method search book by id
		in = new Scanner(System.in);
		List<Book> booksFound = new ArrayList<>();
		System.out.print("Enter the book title to search ");
		String searchKey = in.nextLine();
		for (Book book : myBooks) {
			//browse each book of library
			if (book.getTitle().contains(searchKey) ) {
				//add book to list bookFound if search key is equal to book's id
				booksFound.add(book);
			}
		}
		if (booksFound.isEmpty()) {
			//if library do not have book user wants
			System.out.println("No book is found");
		} else {
			//if library have book user wants
			System.out.println(String.format("%-10s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borrowed"));
			for(Book book : booksFound) {
				System.out.println(book.toString());
			}
		}
		System.out.println();
	}
	
	public void Display() {
		//print out list of books in library
		System.out.printf("%-10s%-20s%-20s%-20s", "ID", "Title", "Author", "Is borrowed");
		System.out.println();
		for (Book book : myBooks) {
			System.out.println(book);
		}
		System.out.println();
	}
	
	public void Borrow() {
		//borrow books by id
		in = new Scanner(System.in);
		System.out.print("Enter book ID to borrow ");
		String searchKey = in.nextLine(); //user entering id or title of the book want to borrow
		for (Book book : myBooks) { 
			//use loop to browse each book in the library
			if (book.getId().equalsIgnoreCase(searchKey)) { 
				//if the library has the book which is wanted to borrow
				if (book.getIsBorrowed()) {
					//if this book has been borrowed
					System.out.println("You can not borrow this book. The book has been borrowed");
					System.out.println();
					return;
				}
				//if this book has been in the library yet
				book.setIsBorrowed(true); 
				System.out.println("You have successfully borrow the book: " + book.getTitle());
				System.out.println();
				return;	
			} 
		}
		
		for (Book book : myBooks) {
			if (!book.getId().equalsIgnoreCase(searchKey)) {
				//if the library has the book which is wanted to borrow
				System.out.println("Library currently does not have this book");
				System.out.println();
				return;
			}
		}
		System.out.println();
	}
	
	public void exit() { //exit the program
		System.out.println("-------------------------------End-------------------------------");
	}
}