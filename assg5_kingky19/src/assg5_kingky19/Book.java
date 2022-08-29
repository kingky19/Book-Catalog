package assg5_kingky19;

public class Book implements Comparable<Book> {
	
	String bookISBN;
	String bookTitle;
	String bookAuthor;
	String bookPublisher;
	String bookYear;
	
	/*
	 * This constructor sets the String variables above to the inputs from the user for the Book.
	 */
	
	public Book(String isbn,String title,String author, String publisher,String year) {
		
		this.bookISBN = isbn;
		this.bookTitle = title;
		this.bookAuthor = author;
		this.bookPublisher = publisher;
		this.bookYear = year;
		
	}
	
	/*
	 * The getISBN method gets the ISBN of a book and returns it.
	 */
	
	public String getISBN() {
		return bookISBN;
	}
	
	/*
	 * The getTitle method gets the title of a book and returns it.
	 */
	
	public String getTitle() {
		return bookTitle;
	}
	
	/*
	 * The getAuthor method gets the author of a book and returns it.
	 */
	
	public String getAuthor() {
		return bookAuthor;
	}
	
	/*
	 * The getPublisher method gets the publisher of a book and returns it.
	 */
	
	public String getPublisher() {
		return bookPublisher;
	}
	
	/*
	 * The getYear method get the publishing year of the book and returns it.
	 */
	
	public String getYear() {
		return bookYear;
	}
	
	/*
	 * The setISBN method takes in a ISBN and sets the bookISBN to the user inputed ISBN.
	 */
	
	public void setISBN(String ISBN) {
		bookISBN = ISBN;
	}
	
	/*
	 * The setAuthor method takes in a author and sets the bookAuthor to the user inputed author.
	 */
	
	public void setAuthor(String Author) {
		bookAuthor = Author;
	}
	
	/*
	 * The setPublisher method takes in a publisher and sets the bookPublisher to the user inputed publisher.
	 */
	
	public void setPublisher(String Publisher) {
		bookPublisher = Publisher;
	}
	
	/*
	 * The setPublishYear method takes in a parameter publisher of type string and sets the bookYear
	 *  to the user inputed publishing year.
	 */
	
	public void setPublishYear(String pubYear) {
		bookYear = pubYear;
	}
	
	/*
	 * The toString method takes in no parameter and returns a string object. The string object says
	 * all the information of the book.
	 */
	
	@Override
	public String toString() {
		return   bookISBN + "\n"  + bookTitle + "\n" + bookAuthor + "\n" +  
				 bookPublisher + "\n"  + bookYear + "\n";
	}
	
	/*
	 * The equals method takes in an object title and then compares it to the next book title based on alphabetical order. And returns
	 * true or false based on the results of the compare. 
	 */
	
	@Override
	public boolean equals(Object title) {
		if (title == null)
			return false;
		
		if(title instanceof Book) {
			Book temp = (Book)title;
			return (this.bookTitle == temp.bookTitle);
		}
		else 
			return false;
		
	}
	/*
	 * The compareTo method takes in a Book object of book. If the titles are equal it returns 0. 
	 * If one the titles are greater than another title it returns 1. If the titles are less than then
	 * it returns -1.
	 */
	
	@Override
	public int compareTo(Book book) {	
		return this.bookTitle.compareTo(book.bookTitle);
	}

}
