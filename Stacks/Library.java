import java.util.Scanner;
import java.util.Stack;

public class Library {
    private Stack<Book> books = new Stack<>();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Library main = new Library();
        main.Start();
    }
	
	public void Start() {
	   Scanner sc = new Scanner(System.in);
		
        boolean validInput = false;
            System.out.println("\nWhat do you want to do?");
            System.out.println("[1] DISPLAY BOOKS");
            System.out.println("[2] ADD BOOKS");
	    System.out.println("[3] BORROW BOOKS");
	    System.out.println("[4] RETURN BOOKS");
	    System.out.println("[5] EXIT");
		
		while (!validInput) {

            try {
                int ans = sc.nextInt();
                sc.nextLine(); 

                switch (ans) {
                    case 1:        
                    	displayBooks();
                        validInput = true;
                        break;

		    case 2:
			System.out.print("Enter book name: ");
			String bookName = sc.nextLine();
			System.out.print("Enter author: "); 
			String author = sc.nextLine(); 
			addBooks(bookName, author); 
			validInput = true;
			break;

                    case 3:
                    	System.out.print("Enter book name: ");
                    	String borrow = sc.nextLine();
                    	borrowBooks(borrow);
                        validInput = true;
                        break;

                    case 4:
                    	System.out.print("Enter book name: ");
			String bookReturn = sc.nextLine();
			System.out.print("Enter author: "); 
			String authorReturn = sc.nextLine(); 
			addBooks(bookReturn, authorReturn); 
			validInput = true;
			break;
                        
                    case 5:
                        System.out.println("Adios kaibigang bangus!");
                        validInput = true;
                        break;

                    default:
                        System.out.println("Input error: This is not in the choices");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Input error: Please enter a valid number.");
                sc.nextLine(); 
            }
        }
		
	}
	
	public void displayBooks(){  
		   System.out.println("\nWhat do you want to do? \n[1] VIEW THE FIRST BOOK \n[2] VIEW ALL \n[3] EXIT");
		   while(true) {
			   int ans = sc.nextInt();
			if(books.isEmpty()) {
				System.out.println("The library is empty.");
			    Start();
			}else{
				if(ans == 1) {
			   System.out.println("First book: " + books.peek());
			   Start();
		   }else if(ans == 2) {
			   System.out.println("Book: " + books);
			   Start();  
		   }else if(ans == 3) {
			   Start();
		   }else {
			   System.out.println("Input error: This is not in the choices");
		   }
	    }   
	   }     
	   }
	   
	   public void addBooks(String bookName, String author) {
        Book book = new Book(bookName, author);
        books.push(book);
        System.out.println(bookName + " by " + author + " has been added!");
        Start();
    }
	   
	public void borrowBooks(String bookName) {
		boolean bookFound = false;
		
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(bookName)) { 
				books.remove(book);
				System.out.println(bookName + " has been borrowed.");
				bookFound = true;
				break;
			}
		}

		if (!bookFound) {
			System.out.println(bookName + " not found.");
		} else if (books.isEmpty()) {
			System.out.println("The library is empty.");
		}
		Start();
	}
	 
	   public void returnBooks(String bookName, String author) {
        Book book = new Book(bookName, author);
        books.push(book);
        System.out.println(bookName + " by " + author + " has been returned.");
        Start();
    }

	   class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return title + " by " + author;
        }
    }

}
