/**
 * @author Jacob Larose
 * @since 2016-02-28
 * @custom.citations "I did not use any reference material in developing this assignment."
 */

public class Person{
  /* attributes */
  private final String        name;   // assume each person has a unique name
  private       LibraryBook[] books;  // library books checked out by the person
  
  /* constructor */
  public Person(String name){
    this.name = name;
    this.books = new LibraryBook[0];
  }
  
  /* getters */
  public String getName(){ return name; }
  public LibraryBook[] getLibraryBooks(){ return books; }
  
  /**
   * Adds the book to the person's list of books checked out.
   * 
   * @param b is a LibarayBook that the person is checking out from the library
   */
  public void addBook(LibraryBook b){
      LibraryBook[] newBooks = new LibraryBook[this.books.length+1];
      System.arraycopy(this.books, 0, newBooks, 0, this.books.length);
      newBooks[this.books.length] = b;
      
      this.books = newBooks;
  }

  /**
   * Find all books the person has checked out that are overdue.
   * 
   * @param date is the current date.  It is an array of 3 integers that represent a date 
   * [day, month, year].
   * @return an array of books that the person has checked out that are overdue (based on the .
   */
  public Book[] overDueBooks(int[] date){
      Book[] overdue = new Book[0];
      for (LibraryBook book : this.books) {
          if (book.isCheckedOut()) {
              if (book.dueDate()[2] == date[2]) {
                  if (book.dueDate()[1] == date[1]) {
                      if (book.dueDate()[0] == date[0]) {
                      } 
                      else if (book.dueDate()[2] > date[2]) {
                          
                      }
                      else {
                          overdue = addBook(book.getBook(), overdue);
                      }
                  }else if (book.dueDate()[2] > date[2]) {
                      
                  } 
                  else {
                      overdue = addBook(book.getBook(), overdue);
                  }
              }else if (book.dueDate()[2] > date[2]) {
                  
              } 
              else {
                  overdue = addBook(book.getBook(), overdue);
              }
          }
      }
      return overdue;
  }
  private Book[] addBook(Book b, Book[] l){
        Book[] newBooks = new Book[l.length+1];
        System.arraycopy(l, 0, newBooks, 0, l.length);
        newBooks[newBooks.length-1] = b;

        return newBooks;
  }
}