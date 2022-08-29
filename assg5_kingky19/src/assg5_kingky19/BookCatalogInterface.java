package assg5_kingky19;

import java.util.ArrayList;

public interface BookCatalogInterface {
	public void loadData(String filename);
	public void displayCatalog();
	public Book searchForBook(String title);
	public boolean addBook(String isbn,String title,String author, String publisher,String year);
	public boolean updateBook(String isbn,String title,String author, String publisher,String year);
	public boolean removeBook(String title);
	public ArrayList<Book> getBooksByPublisher(String publisher);
	public void Sort();
	public void Save();

}
