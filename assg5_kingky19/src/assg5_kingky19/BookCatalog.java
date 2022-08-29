package assg5_kingky19;

import java.io.*;
import java.util.*;

public class BookCatalog implements BookCatalogInterface {
	
	final static String filename = "assg5_BookCatalog.txt";
	ArrayList<Book> bookLibrary = new ArrayList<Book>();
	
	/*
	 * The loadData method has a filename as a parameter and loads all the data from the file. 
	 */
	
	public void loadData(String filename) {
		
		try {
			
			Scanner infile = new Scanner(new File(filename));
			while(infile.hasNextLine()) {
				addBook(infile.nextLine(),
				        infile.nextLine(),
						infile.nextLine(),
						infile.nextLine(),
						infile.nextLine());
				
				
				if(!infile.hasNextLine())
					break;
				else
					infile.nextLine();
			}
				infile.close();
		
		}
		catch (FileNotFoundException e) {
			System.out.println("unable to open the file " + filename + ".");
			System.exit(1);
		}
		
		
		
		
	}
	
	/*
	 * The displayCatalog method takes in no parameter and displays the
	 * complete information of all the books in the catalog.  
	 */
    
	public void displayCatalog() {
		Iterator<Book> iter = bookLibrary.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	
		
	}
	
	/*
	 * The searchForBook method takes in a title as a parameter and returns
	 * the Book object if found. If nothing is found it returns null.
	 */
	
	public Book searchForBook (String title) {
		Iterator<Book> iter = bookLibrary.iterator();
		for(int i = 0; iter.hasNext(); i++) {
			if(iter.next().getTitle().equals(title)) {
				return bookLibrary.get(i);
			}	
		}
		return null;
	
	}
	
	/*
	 * The addBook method is used to add a new Book. It takes in 5 parameters that reprsent
	 * the ISBN, title, author, publisher, and publishing year. If the title of the book 
	 * already exist in the catalog the message "The book already exist" is printed. 
	 * This method returns a boolean value. If the book is added it returns true otherwise 
	 * it returns false. 
	 */
	
	public boolean addBook(String isbn,String title,String author, String publisher,String year) {
		
		
		if(searchForBook(title) == null) {
			Book newBook = new Book(isbn,title,author,publisher,year);
			bookLibrary.add(newBook);
			return true;
		}
		else
			System.out.println("The book already exist.");
			return false;
		
	}
	
	/*
	 * The updatedBook method is used to updated the information of a book that already exist.
	 * It has 5 parameters of that represent the ISBN, title, author, publisher, and publishing year.
	 * If the book title is not found then the message "The book does not exist" is printed.
	 * Otherwise the book information is updated. This method returns a boolean value. If the book has
	 * been updated returns true otherwise returns false.  
	 */
	
	public boolean updateBook(String isbn,String title,String author, String publisher,String year) {
		Book tempBook = searchForBook(title);
		if(tempBook == null) {
			System.out.println("The book does not exist.");
			return false;
		}
		else {
			bookLibrary.get(bookLibrary.indexOf(tempBook)).setISBN(isbn);
			bookLibrary.get(bookLibrary.indexOf(tempBook)).setAuthor(author);
			bookLibrary.get(bookLibrary.indexOf(tempBook)).setPublisher(publisher);
			bookLibrary.get(bookLibrary.indexOf(tempBook)).setPublishYear(year);
			return true;
		}
			
	}
	
	/*
	 * The removeBook method is used to remove a book from the catalog. It has a parameter that represents
	 * the title. If the book is not found it prints out the message "The book does not exist.". If the book
	 * is removed then it returns true, otherwise it returns false.
	 */
	
	public boolean removeBook(String title) {
		Book tempBook = searchForBook(title);
		
		if(tempBook == null) {
			System.out.println();
			System.out.println("The book does not exist.");
			return false;
		}
		else {
			
			bookLibrary.remove(tempBook);
			System.out.println();
			System.out.print("You have deleted the book");
			System.out.println();
			return true;
		}
		
	}
	
	/*
	 * The getBooksByPublisher method takes in a publisher as a parameter and returns an ArrayList object
	 * with all the books by the user inputed publisher. If there are no books by the publisher nothing is
	 * returned and the size is zero.
	 */
	
	public ArrayList<Book> getBooksByPublisher(String publisher) {
		
		ArrayList<Book> pubBook = new ArrayList<Book>();
		Iterator<Book> iter = bookLibrary.iterator();
		
		while(iter.hasNext()) {
			Book tempBook = iter.next();
			if(tempBook.getPublisher().equals(publisher)) {
				 pubBook.add(tempBook);
			}
			
		}
		return pubBook;
	}
	
	/*
	 * The sort method sorts all the books by the title takes no parameters and returns nothing.
	 */
	
	public void Sort() {
		
		Collections.sort(bookLibrary);
		
	}
	
	/*
	 * The Save method writes the book catalog back to the text file if the information has be changed
	 */
	public void Save() {
		
		//String filename = "assg5_BookCatalog.txt";
		PrintWriter outputFile = null;
		Iterator<Book> iter = bookLibrary.iterator();
		try {
			outputFile = new PrintWriter(filename);
			while(iter.hasNext()) {
				outputFile.println(iter.next());
			}
			outputFile.close();
		}
		catch(IOException e) {
			System.out.println(e);
			System.exit(1);
		}
		
		
	}

}
