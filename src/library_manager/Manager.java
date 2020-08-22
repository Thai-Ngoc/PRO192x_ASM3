package library_manager;
import java.util.*;
public class Manager {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookList bookList = new BookList();
		boolean choose = true;
		while(choose) {
			System.out.println("Welcome to the online book library");
			System.out.println("---------------------");
			System.out.println("1. Enter a new book");
			System.out.println("2. Search a book by book title");
			System.out.println("3. Display books");
			System.out.println("4. Borrow a book by book id");
			System.out.println("5. Exit");
			System.out.print("Your choice: ");
			int choice = in.nextInt();
			
			switch(choice) {
			case 1:
				bookList.add();
				break;
			case 2:
				bookList.Search();
				break;
			case 3:
				bookList.Display();
				break;
			case 4:
				bookList.Borrow();
				break;
			case 5:
				bookList.exit();
				choose = false;
				break;
			}
		
		} 

	}

}
