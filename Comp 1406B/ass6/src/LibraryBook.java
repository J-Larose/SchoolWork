/**
 * A library book.
 * 
 * COMP1406 - Winter 2016 - Assignment 6
 */

/**
 * @author Jacob Larose
 * @since 2016-02-28
 * @custom.citations "I did not use any reference material in developing this assignment."
 */

public class LibraryBook{
  private Book   book;          // the actual book
  private Person checkedOutBy;  // a person that has checked out this book
  private int[] dueDate;
 
  /* ocnstructor */
  public LibraryBook(Book b){
    book = b;
  }
  
  /* provided getter methods */
  public String getName(){return book.getName();}
  public String getAuthor(){return book.getAuthor();}
  
  public String  checkedOutBy(){return checkedOutBy.getName();}
  /**
   * @param x random bool for overload
   * @return Person it is checked out by
   */
  public Person checkedOutBy(boolean x){return checkedOutBy;}
  
  public Book getBook(){return this.book;}
 
  
  /*--------------------------------------*/
  /* methods that you must complete       */
  /*--------------------------------------*/

  /**
   * checks out a library book for person p on given date
   * 
   * @param p is a person that is checking out the book
   * @parm date is the date that the book is checked out
   * @return Nothing. Has the side effect that the current library book
   * is checked out by the person p on given date specified by the input.
   */
  public void checkOut(Person p, int[] date){
      this.checkedOutBy = p;
      this.dueDate = new int[3];
      this.dueDate[0] = date[0];
      this.dueDate[1] = date[1]+1;
      this.dueDate[2] = date[2];
  }

  
  /** 
   * Checks if the book is currently checked out or not.
   * 
   * @return true if the book is currently checked out and false otherwise.
   */
  public boolean isCheckedOut(){
      if (this.checkedOutBy == null){
          return false;
      }
      return true;
  }
  
  /**
   * If the book is checked out this is its due date. The date is represented
   * by an array of three integers [day, month, year].  sFor example, if the due date
   * was February 29, 2016, the returned array would be [29,2,2016].
   * 
   * @return an array with 3 integers that represent the due date of the book, if it is checked out.
   * The date is in the form [day, month, year]. 
   * If the book is not checked out then returns the array [-1, -1, -1].
   * 
   */
  public int[]  dueDate(){
      if (this.dueDate == null){
          int[] x = {-1,-1,-1};
          return x;
      }else{
          return this.dueDate;
      }
  }
}