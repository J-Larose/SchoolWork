/**
 * This class represents a Library
 * 
 * COMP1406 - Winter 1026 - Assignment 6
 */

/**
 * @author Jacob Larose
 * @since 2016-02-28
 * @custom.citations "I did not use any reference material in developing this assignment."
 */


public class Library{
  private LibraryBook[] bookCollection;
  private Person[] libraryUsers;
  
  public Library(){ 
    // create an empty library
  }
  
  public Library(LibraryBook[] books){
    // create a library with some books in it!
    bookCollection = books;
  }
  /**
   * Covert Book object to equivalent LibraryBook object
   * @param b Book object
   * @return LibraryBook object 
   */
  private LibraryBook bToLb(Book b){
      for (LibraryBook bookCollection1 : bookCollection) {
          if (bookCollection1.getName().equals(b.getName()) && bookCollection1.getAuthor().equals(b.getAuthor())) {
              return bookCollection1;
          }
      }
      return null;
  }
  
  public void addBooks(LibraryBook[] books){
    // add some books to a library
    LibraryBook[] newBookCollection = new LibraryBook[ bookCollection.length + books.length ];
    int len = bookCollection.length;
    for(int i=0; i<len; i+=1){
      newBookCollection[i] = bookCollection[i];
    }
   
    for(int i=0; i<books.length; i+=1){
      newBookCollection[len+i] = books[i];
    }
    bookCollection = newBookCollection;
  }
  
  /**
   * @return all books in the libraries collection
   */
  public Book[] getAllBooks(){
      Book[] books = new Book[this.bookCollection.length];
      for(int i=0; i<this.bookCollection.length; i++){
          books[i] = this.bookCollection[i].getBook();
      }
      return books;
  }
  private Book[] addBook(Book b, Book[] l){
        Book[] newBooks = new Book[l.length+1];
        System.arraycopy(l, 0, newBooks, 0, l.length);
        newBooks[newBooks.length-1] = b;

        return newBooks;
  }
  /**
   * @return all books in the library's colletion that are currently checked out
   */
  public Book[] getAllCheckedOutBooks(){
      Book[] books = new Book[0];
      for (LibraryBook bookCollection1 : this.bookCollection) {
          if (bookCollection1.isCheckedOut() == true) {
              books = this.addBook(bookCollection1.getBook(), books);
          }
      }
      return books;
  }
  
  /**
   * @param date is the current date in the format of an array of three integers [day, month, year].
   * @return all books in the libraries colletion that are currently checked out
   * and are overdue (based on the current date as specified by the input).
   */
  public Book[] getAllOverDueBooks(int[] date){
      Book[] books = new Book[0];
      for (LibraryBook bookCollection1 : this.bookCollection) {
          if (bookCollection1.isCheckedOut()){
            if (bookCollection1.dueDate()[2] == date[2]) {
                if (bookCollection1.dueDate()[1] == date[1]) {
                    if (bookCollection1.dueDate()[0] == date[0]) {
                        //not overdue
                    } else if(bookCollection1.dueDate()[2] > date[2]){
                        //not overdue
                    }
                    else {
                        books = addBook(bookCollection1.getBook(), books);
                    }
                }else if(bookCollection1.dueDate()[2] > date[2]){
                    //not overdue
                }
                else {
                    books = addBook(bookCollection1.getBook(), books);
                }
            } else if(bookCollection1.dueDate()[2] > date[2]) {
                //not overdue
            }
            else {
                books = addBook(bookCollection1.getBook(), books);
            }
          }          
      }
      return books;
  }
  
  
  /**
   * @param b is a book.
   * @return true if the book b is in the libraries collection and false otherwise. 
   * It does not mater if it is checked out or not. 
   */
  public boolean bookInCollection(Book b){
      return this.bToLb(b) != null;
  }
  
  
  /**
   * @param b is a book that is in the libraries collection.
   * @return true if the book b is checked out
   */
  public boolean isCheckedOut(Book b){
      LibraryBook lB = this.bToLb(b);
      
      return lB.isCheckedOut();
  }
  
  /**
   * @param b is a book that is in the libraries collection.
   * @param date is the current date represented as an array of three integers [day, month, year].
   * @return the person that has the book b checked out if the book is overdue, 
   * based on the current date as specified by the input,  
   * and returns null otherwise. 
   */
  public Person isOverDue(Book b, int[] date){
      LibraryBook lB = this.bToLb(b);
     
    if(lB.dueDate()[2] > date[2]){
        if(lB.dueDate()[1] > date[1]){
            if (lB.dueDate()[0] > date[0]){
                return null;
            }else{
                return lB.checkedOutBy(true);
            }
        }else{
            return lB.checkedOutBy(true);
        }
    }else{
        return lB.checkedOutBy(true);
    }
  }
  
  
  /**
   * Check out a book from the library.
   * 
   * @param b is a book in the libraries collection.
   * @param p is a person with a library card in the library.
   * @param date is the current date [day, month, year].
   * @return Nothing. Has the side effect of checking out the LibraryBook
   * corresponding to the book b for the person p. The due date for the library book
   * is ONE MONTH after the check out date. 
 * For example, if you take the book out on Jan 3rd then the due date is Feb 3rd of the same year, or if the book was checked out
 *on Sept 12th then the due date would be Oct 12th of the same year. 
 * And if the book was checked out on December 19th 2012 the due date would be January 2013.
   */
  public void checkOutBook(Book b, Person p, int[] date){
      LibraryBook lB = this.bToLb(b);
      
      lB.checkOut(p, date);
      p.addBook(lB);
  }
  
  
  
}