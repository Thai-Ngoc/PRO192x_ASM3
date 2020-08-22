package library_manager;

public class Book {
	//private fields
	private String id;
	private String title;
	private String author;
	private Boolean isBorrowed = false;
	//constructor
	public Book(String id, String title, String author, Boolean isBorrowed) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isBorrowed = isBorrowed;
	}
	//getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Boolean getIsBorrowed() {
		return isBorrowed;
	}

	public void setIsBorrowed(Boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	
	public String toString() { //method format outputs
		return String.format("%-10s%-20s%-20s%-20b", id, title, author, isBorrowed);
	}
	
}
