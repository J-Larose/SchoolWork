/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacob
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person p1 = new Person("a", 1);
        Person p2 = new Person("b", 2);
        Person p3 = new Person("c", 3);
        Person p4 = new Person("d", 4);
        Person p5 = new Person("e", 5);
        
        PersonList list = new PersonList(p1);
        String str = list.toString();
        System.out.println(str);
        
        list.add(p2);
        str = list.toString();
        System.out.println(str);
        
        PersonList addList = new PersonList(p4);
        addList.add(p5);
        System.out.println("addlist "+addList.toString());
        System.out.println(list.toString());
        
        list.add(addList, 0);
        System.out.println(list.toString());

        
        list.add(p3, 1);
        System.out.println(list.toString());
        
        System.out.println(list.findPosition(p1));
        
        PersonList older = list.olderThan(1);         
        System.out.println(older.toString());
        
        System.out.println(list.personAt(1).getName());
        
        System.out.println(list.remove(0).getName());
        System.out.println(list.toString());
        
        PersonList rmv = list.remove(1, 3);
        System.out.println(rmv.toString());
        System.out.println(list.toString());
        
        PersonList y = new PersonList(p1);
        y.add(p3);
        
        System.out.println(y.size());
        
        boolean x = list.sameAs(y);
        System.out.println(x);
        
        System.out.println(list.size());
        
        
    }
    
}
