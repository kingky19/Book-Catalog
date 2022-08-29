package assg5_kingky19;


import java.util.*;

public class LibraryApplication extends BookCatalog {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookCatalog bookCat = new BookCatalog();
		bookCat.loadData(filename);
		Scanner scanner = new Scanner(System.in);
		String choice = "";
		String bookISBN;
		String bookTitle;
		String bookAuthor;
		String bookPublisher;
		String bookYear;
		boolean fileUpdated = false; 
		
		while(!choice.equals("9")) {
			System.out.println("1. Display all books.");
			System.out.println("2. Search for a book");
			System.out.println("3. Add a new book");
			System.out.println("4. Update an existing book");
			System.out.println("5. Remove a book");
			System.out.println("6. Search for books by publisher");
			System.out.println("7. Sort all the books based on title.");
			System.out.println("8. Save data");
			System.out.println("9. Exit");
			
			choice = scanner.nextLine();
			
			switch(Integer.parseInt(choice)) {
			// case 1 display books.
			case 1: 
				System.out.println();
				System.out.println("The books are: ");
				bookCat.displayCatalog();
				System.out.println("Please press Enter to continue");
				scanner.nextLine();
				break;
			// case 2 search for book.
			case 2:
				System.out.println();
				System.out.println("Enter title of book");
				choice = scanner.nextLine();        
				Book temp = bookCat.searchForBook(choice);
				System.out.println();
				if(temp != null)
					System.out.println(temp);
				else {
					System.out.println("Book does not exist.");
				}
				System.out.println("Please press Enter to continue");
				scanner.nextLine();
				break;
			// case 3 add book.	
			case 3:
				System.out.println();
				System.out.println("Please enter the title of the new book.");
				bookTitle = scanner.nextLine();
				if(bookCat.searchForBook(bookTitle) != null) {
					System.out.println("The book already exist.");
					break;
				}
				System.out.println("Please enter the ISBN of the new book.");
				bookISBN = scanner.nextLine();
				System.out.println("Please enter the author of the new book.");
				bookAuthor = scanner.nextLine();
				System.out.println("Please enter the publisher of the new book.");
				bookPublisher = scanner.nextLine();
				System.out.println("Please enter the publishing year of the new book.");
				bookYear = scanner.nextLine();
				bookCat.addBook(bookISBN, bookTitle, bookAuthor, bookPublisher, bookYear);
				fileUpdated = true;
				System.out.println();
				System.out.println("The new book was succesfully added.");
				System.out.println();
				System.out.println("Please press Enter to continue");
				scanner.nextLine();
				break;
			// case 4 update book	
			case 4:
				System.out.println();
				System.out.println("What book do you wish to update? Please enter the title.");
				choice = scanner.nextLine();
				System.out.println();
				Book tempBook = bookCat.searchForBook(choice);
				
				if(tempBook == null) {
					System.out.println("The book does not exist.");
					break;
				}
				bookISBN = tempBook.getISBN();
				bookTitle = tempBook.getTitle();
				bookAuthor = tempBook.getAuthor();
				bookPublisher = tempBook.getPublisher();
				bookYear = tempBook.getYear();
		
				while(!choice.equals("0")) {
					System.out.println();
					System.out.println("What part of the book do you wish to update?");
					System.out.println();
					System.out.println("0. Back to main menu");
					System.out.println("1. ISBN");
					System.out.println("2. Author");
					System.out.println("3. Publisher");
					System.out.println("4. Publishing year");
					
					choice = scanner.nextLine();
					switch(Integer.parseInt(choice)) {
					case 0:
						break;
					case 1:
						System.out.println();
						System.out.println("What is the new ISBN of the book?");
						bookISBN = scanner.nextLine();
						System.out.println("You have updated the ISBN.");
						break;
					case 2:
						System.out.println();
						System.out.println("Who is the new author of the book?");
						bookAuthor = scanner.nextLine();
						System.out.println("You have updated the author.");
						break;
					case 3:
						System.out.println();
						System.out.println("Who is the new publisher of the book?");
						bookPublisher = scanner.nextLine();
						break;
					case 4:
						System.out.println();
						System.out.println("What is the new publishing year of the book?");
						bookYear = scanner.nextLine();
						break;
					
					}
						
				}
				bookCat.updateBook(bookISBN,bookTitle,bookAuthor,bookPublisher,bookYear);
				fileUpdated = true;
				System.out.println();
				System.out.println("Please press Enter to continue");
				scanner.nextLine();
				break;
			// case 5 remove book.	
			case 5:
				System.out.println();
				System.out.println("Please enter the title of book you wish to remove.");
				choice = scanner.nextLine();
				bookCat.removeBook(choice);
				fileUpdated = true;
				System.out.println();
				System.out.println("Please press Enter to continue");
				scanner.nextLine();
				break;
			// case 6 search for publisher.	
			case 6:
				System.out.println();
				System.out.println("Please enter the name of the publisher you wish to search for.");
				choice  = scanner.nextLine();
			
				Iterator<Book> pubBook = bookCat.getBooksByPublisher(choice).iterator();
				System.out.println();
				while(pubBook.hasNext()) {
					System.out.println(pubBook.next());
				}
				
				System.out.println("Please press Enter to continue");
				scanner.nextLine();
				break;
			// case 7 is sort method.	
			case 7:
				bookCat.Sort();
				fileUpdated = true;
				System.out.println();
				System.out.println("You sorted the books alphabetically by title.");
				System.out.println();
				System.out.println("Please press Enter to continue");
				scanner.nextLine();
				break;
			// case 8 is save method.	
			case 8:
				System.out.println();
				System.out.println("Saving to the text file");
				bookCat.Save();
				System.out.println("The text file was successfully saved.");
				System.out.println();
				System.out.println("Please press Enter to continue");
				scanner.nextLine();
				break;
			// case 9 is exit.	
			case 9:
				System.out.println();
				if(fileUpdated) {
					System.out.println("Saving");
					bookCat.Save();
				}
				System.out.println();
				System.out.println("Have a good day!");
				System.exit(0);
				
			}
			
		}
		
		scanner.close();
	}
	

}
