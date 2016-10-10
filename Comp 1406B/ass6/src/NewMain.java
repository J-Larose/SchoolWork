/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person p = new Person("Jim");
        
        int[] date = {6,3,2016};
        int[] date2 = {6,6,2016};
        
        Book a = new Book("a","aa");
        Book b = new Book("b","bb");
        Book c = new Book("c","cc");
        Book d = new Book("d","dd");
        
        LibraryBook aL = new LibraryBook(a);
        LibraryBook bL = new LibraryBook(b);
        LibraryBook cL = new LibraryBook(c);
        LibraryBook dL = new LibraryBook(d);
        
        LibraryBook[] LB = {aL, bL, cL, dL};
        //~~~~~~~~~~~~~library tests~~~~~~~~~~~~
        
        Library l = new Library(LB);
                
        System.out.println(l.bookInCollection(b));//true
        System.out.println();
        
        l.checkOutBook(b, p, date);
        
        for(Book i : l.getAllBooks()){
            System.out.println(i.getName());
        }
        System.out.println();
        
        for(Book i : l.getAllCheckedOutBooks()){
            System.out.println(i.getName());
        }
        System.out.println();
        
        for(Book i : l.getAllOverDueBooks(date2)){
            System.out.println(i.getName());
        }
        
        System.out.println(l.isCheckedOut(b));//true
        
        System.out.println(l.isOverDue(b,date2).getName());//jim
        
        //~~~~~~~~~~~~~~~librarybook tests~~~~~~~~~~~~~~
        
        System.out.println(bL.checkedOutBy());//Jim
        
        int[] x = bL.dueDate();
        System.out.println(x);//[6,4,2016]
        
        
        
        for(Book i : p.overDueBooks(date2)){
            System.out.println(i.getName());
        }
    }
    
}
