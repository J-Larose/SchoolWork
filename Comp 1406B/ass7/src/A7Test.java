

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * @author CZL
 *
 *	Test Cases to consider:
 *		Remove:
 *			front, back, middle, every 2 other, empty list, from range(head to tail),
 *			from range(mid to tail), from invalid range, from inverse range,
 *			remove entire list from back, remove entire list from front, 
 *			* This test case removed* remove from invalid position
 *
 *		Add:
 *			front, insert back, insert middle, first element in list, chaining,
 *			size after an add after all add functions
 *
 *		Search:
 *			first person, middle person, last person, person non existent, index of person
 *			at front, back, middle, and non existent
 *
 *		Same as: 
 *			result and expected, null list, empty list, 
 *
 *		olderThan:
 *			older than all, older than none, older than some, older than some with exclusion
 *			check same order as original, older than first guy, older than last guy, 
 *			older than every other guy, check resulting list after calling this		
 *
 *		toString(): 
 *			string match it for a empty list and a non empty list
 */

public class A7Test {
	public static boolean VERBOSE = true;
	public static float GOOD_MARK = 0.5f;
	public static float PARTIAL_MARK = 0.25f;
	
	public static void main(String arg[]) {
		float totalMarks = 0.0f;
		println("Marking Person List:\n");
		totalMarks += testAdd();
		totalMarks += testRemove();
		totalMarks += testSearch();
		totalMarks += testSameAs();
		totalMarks += testOlderThan();
		totalMarks += testToString();
		println(String.format("\nAssignment mark %.2f/20", totalMarks));
	}
	public static void print(String s){System.out.println(s);}
	
	public static float testToString() { print("Test toString...");
		try {
			PersonList l = makeList(5);
			String s = l.toString();
			String ex = "[p1(1), p2(2), p3(3), p4(4), p5(5)]";
			String ex2 = "[p1(1), p2(2), p3(3), p4(4), p5(5),]";
			String ex3 = "[p1(1),p2(2),p3(3),p4(4),p5(5)]";
			String ex4 = "[p1(1),p2(2),p3(3),p4(4),p5(5),]";
			if(s.equals(ex)) {
				return (A7Test.GOOD_MARK)*2;
			} else if(s.equals(ex2) || s.equals(ex3) || s.equals(ex4)) {
				return A7Test.GOOD_MARK;
			} else {
				printerr("To string failed to match excpected");
				return 0.0f;
			}
		} catch (Exception e) {
			printerr("toString Failed");
		}
		return 0.0f;
	}
	
	public static float testOlderThan() { print("Test olderThan...");
		float marks = 0.0f;
		
		try {
			PersonList l = makeList(5);
			PersonList x = l.olderThan(0);
			int[] ex = new int[] {1,2,3,4,5};
		
			marks += testList(x, ex, "Older than all", ex.length);
			
		} catch (Exception e) {
			printerr("Checking older than all failed");
		}
		
		try {
			PersonList l = makeList(5);
			PersonList x = l.olderThan(6);
			if(x.personAt(0) == null) {
				marks += A7Test.GOOD_MARK;
			} else {
				printerr("Older than non failed");
			}
		} catch (Exception e) {
			marks += A7Test.GOOD_MARK;
		}
		
		try {
			PersonList l = new PersonList();
			l.add(createPerson(34));
			l.add(createPerson(5));
			l.add(createPerson(4));
			l.add(createPerson(14));
			l.add(createPerson(24));
			l.add(createPerson(28));
			l.add(createPerson(14));
			l.add(createPerson(35));
			l.add(createPerson(18));
			l.add(createPerson(22));
			l.add(createPerson(27));
			PersonList x = l.olderThan(20);
			int[] ex = new int[] {27,22,35,28,24,34};
			marks += testList(x, ex, "Older than some", ex.length);
		} catch (Exception e) {
			printerr("Checking older than some failed");
		}
		
		try {
			PersonList l = new PersonList();
			l.add(createPerson(34));
			l.add(createPerson(5));
			l.add(createPerson(4));
			l.add(createPerson(14));
			l.add(createPerson(24));
			l.add(createPerson(28));
			l.add(createPerson(14));
			l.add(createPerson(35));
			l.add(createPerson(18));
			l.add(createPerson(22));
			l.add(createPerson(27));
			PersonList x = l.olderThan(22);
			int[] ex = new int[] {27,35,28,24,34};
			marks += testList(x, ex, "Older than some with exclusion", ex.length);

		} catch (Exception e) {
			printerr("Checking older than some exclusion failed");
		}
		
		try {
			int[] ex = new int[] {27,22,35,28,24,34};
			PersonList l = new PersonList();
			l.add(createPerson(34));
			l.add(createPerson(5));
			l.add(createPerson(4));
			l.add(createPerson(14));
			l.add(createPerson(24));
			l.add(createPerson(28));
			l.add(createPerson(14));
			l.add(createPerson(35));
			l.add(createPerson(18));
			l.add(createPerson(22));
			l.add(createPerson(27));
			
			PersonList s = new PersonList();
			s.add(createPerson(34)).add(createPerson(24)).add(createPerson(28))
					.add(createPerson(35)).add(createPerson(22)).add(createPerson(27));
			PersonList x = l.olderThan(20);
			marks += testList(s,ex,"older with correct order", ex.length);
		} catch (Exception e) {
			printerr("Checking older than's return order failed");
		}
		
		try {
			int[] ex = new int[] {200};
			PersonList l = new PersonList();
			l.add(createPerson(34));
			l.add(createPerson(5));
			l.add(createPerson(4));
			l.add(createPerson(14));
			l.add(createPerson(24));
			l.add(createPerson(28));
			l.add(createPerson(14));
			l.add(createPerson(35));
			l.add(createPerson(18));
			l.add(createPerson(22));
			l.add(createPerson(200));
			
			PersonList x = l.olderThan(35);
			
			marks += testList(x, ex, "Older than first guy in list", ex.length);
			
		} catch (Exception e) {
			printerr("Checking older than first guy in list failed");
		}
		
		try {
			int[] ex = new int[] {200};
			PersonList l = new PersonList();
			l.add(createPerson(200));
			l.add(createPerson(34));
			l.add(createPerson(5));
			l.add(createPerson(4));
			l.add(createPerson(14));
			l.add(createPerson(24));
			l.add(createPerson(28));
			l.add(createPerson(14));
			l.add(createPerson(35));
			l.add(createPerson(18));
			l.add(createPerson(22));
			
			PersonList x = l.olderThan(35);
			
			marks += testList(x, ex, "Older than last guy in list", ex.length);
			
		} catch (Exception e) {
			printerr("Checking older than first guy in list failed");
		}
		
		try {
			int[] ex = new int[] {15,17,19,111};
			PersonList l = new PersonList();
			l.add(createPerson(12));
			l.add(createPerson(111));
			l.add(createPerson(10));
			l.add(createPerson(19));
			l.add(createPerson(8));
			l.add(createPerson(17));
			l.add(createPerson(6));
			l.add(createPerson(15));
			l.add(createPerson(4));
			
			PersonList x = l.olderThan(14);
			
			marks += testList(x, ex, "Older than every other guy in list", ex.length);
			
		} catch (Exception e) {
			printerr("Checking older than every other guy in list failed");
		}
		
		try {
			int[] ex = new int[] {4,15,6,17,8,19,10,111,12};
			PersonList l = new PersonList();
			l.add(createPerson(12));
			l.add(createPerson(111));
			l.add(createPerson(10));
			l.add(createPerson(19));
			l.add(createPerson(8));
			l.add(createPerson(17));
			l.add(createPerson(6));
			l.add(createPerson(15));
			l.add(createPerson(4));
			PersonList x = l.olderThan(14);
			marks += testList(l, ex, "Older than does not keep list in order", ex.length);
		} catch (Exception e) {
			printerr("Checking older than does not keep list in order failed");
		}
		
		return marks;
	}
	
	public static float testSameAs() {print("Test sameAs...");
		float marks = 0.0f;
		
		try {
			PersonList one = makeList(5);
			PersonList two = new PersonList();
			two.add(createPerson(5))
			 	.add(createPerson(4))
			 	.add(createPerson(3))
			 	.add(createPerson(2))
			 	.add(createPerson(1));
			if(one.sameAs(two)) {
				marks += A7Test.GOOD_MARK;
			} else {
				printerr("Comparing two list equal failed");
			}
		} catch (Exception e) {
			printerr("Checking if list same failed");
		}
		
		try {
			PersonList one = new PersonList();
			PersonList two = null;
			if(!one.sameAs(two)) {
				marks += A7Test.GOOD_MARK;
			} else {
				printerr("Checking null list (same as) failed");
			}
		} catch (Exception e) {
			printerr("Checking null list failed");
		}
		
		try {
			PersonList one = new PersonList();
			PersonList two = new PersonList();
			if(one.sameAs(two)) {
				marks += A7Test.GOOD_MARK;
			} else {
				printerr("Checking empty list (same as) failed");
			}
		} catch (Exception e) {
			printerr("Checking empty list failed");
		}
		
		return marks;
	}
	
	public static float testSearch() {print("Test search...");
		float marks = 0.0f;
		try {
			PersonList l = makeList(5);
			Person p = l.personAt(0);
			if(p.getAge() == 1 && p.getName().equals("p1"))  {
				marks += A7Test.GOOD_MARK;
			} else {
				printerr("personAt(0) failed");
			}
		} catch (Exception e) {
			println("Testing find first person");
		}
		try {
			PersonList l = makeList(5);
			Person p = l.personAt(2);
			if(p.getAge() == 3 && p.getName().equals("p3"))  {
				marks += A7Test.GOOD_MARK;
			} else {
				printerr("personAt(2) failed");
			}
		} catch (Exception e) {
			println("Testing find middle person");
		}
		
		try {
			PersonList l = makeList(5);
			Person p = l.personAt(4);
			if(p.getAge() == 5 && p.getName().equals("p5"))  {
				marks += A7Test.GOOD_MARK;
			} else {
				printerr("personAt(4) failed");
			}
		} catch (Exception e) {
			println("Testing find last person");
		}

		try {
			PersonList l = makeList(5);
			int p = l.findPosition(createPerson(1)); 
			if(p == 0)  {
				marks += A7Test.GOOD_MARK;
			} else {
				printerr("findPosition(p(1)) failed, maybe did string == instead of equals().  ");
			}
		} catch (Exception e) {
			println("Testing find index of first person");
		}
		
		try {
			PersonList l = makeList(5);
			int p = l.findPosition(createPerson(4));
			if(p == 3)  {
				marks += A7Test.GOOD_MARK;
			} else {
				printerr("findPosition(p(4)) failed, maybe did string == instead of equals()");
			}
		} catch (Exception e) {
			println("Testing find index of middle person");
		}
		
		try {
			PersonList l = makeList(5);
			int p = l.findPosition(createPerson(5));
			if(p == 4)  {
				marks += A7Test.GOOD_MARK;
			} else {
				printerr("findPosition(p(5)) failed, maybe did string == instead of equals()");
			}
		} catch (Exception e) {
			println("Testing find index of last person");
		}
		
		try {
			PersonList l = makeList(5);
			int p = l.findPosition(createPerson(7));
			if(p == -1)  {
				marks += A7Test.GOOD_MARK;
			} else {
				printerr("findPosition(p(7)) failed, maybe did string == instead of equals()");
			}
		} catch (Exception e) {
			println("Testing find index of non existent person");
		}
		
		return marks;
	}
	
	public static float testRemove() {print("Test remove...");
		float marks = 0.0f;
		try {
			int[] ex = new int[] {2,3,4,5};
			PersonList l = makeList(5);
			l.remove(0);
			marks += testList(l, ex, "remove front", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on remove front.");
		}
		try {
			int[] ex = new int[] {1,2,3,4};
			PersonList l = makeList(5);
			l.remove(4);
			marks += testList(l, ex, "remove back", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on remove back.");
		}
		try {
			int[] ex = new int[] {1,2,4,5};
			PersonList l = makeList(5);
			l.remove(2);
			marks += testList(l, ex, "remove middle", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on remove middle.");
		}
		try {
			int[] ex = new int[] {1,3,5,7,9};
			PersonList l = makeList(10);
			l.remove(1);
			l.remove(2);
			l.remove(3);
			l.remove(4);
			l.remove(5);
			marks += testList(l, ex, "remove every two", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on remove every two.");
		}
		try {
			int[] ex = new int[0];
			PersonList l = new PersonList();
			l.remove(0);
			marks += testList(l, ex, "remove empty list", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on remove empty list.");
		}
		try {
			int[] ex = new int[0];
			PersonList l = makeList(5);
			l.remove(0,5);
			marks += testList(l, ex, "remove head to tail range", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on remove head to tail range.");
		}
		try {
			int[] ex = new int[] {1,2};
			PersonList l = makeList(5);
			l.remove(2,5);
			marks += testList(l, ex, "remove mid to tail range", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on remove mid to tail range.");
		}
		
		try {
			int[] ex = new int[] {3,4,5};
			PersonList l = makeList(5);
			PersonList r = l.remove(2,5);
			marks += testList(r, ex, "remove range in same order", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on remove range with order check.");
		}
		
		try {
			int[] ex = new int[] {1,5};
			PersonList l = makeList(5);
			l.remove(1,4);
			marks += testList(l, ex, "remove range in same order", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on remove head to mid range.");
		}
		
		try {
			int[] ex = new int[0];
			PersonList l = makeList(5);
			l.remove(0);
			l.remove(0);
			l.remove(0);
			l.remove(0);
			l.remove(0);
			marks += testList(l, ex, "remove entire list from front", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on remove entire list from front.");
		}
		
		try {
			int[] ex = new int[0];
			PersonList l = makeList(5);
			l.remove(4);
			l.remove(3);
			l.remove(2);
			l.remove(1);
			l.remove(0);
			marks += testList(l, ex, "remove entire list from front", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on remove entire list from back.");
		}
		
//		try {
//			int[] ex = new int[] {1,2,3,4,5};
//			PersonList l = makeList(5);
//			l.remove(7);
//			marks += testList(l, ex, "remove list from invalid index", ex.length);
//		} catch (Exception e) {
//			printerr("Tester failed on remove from invalid position.");
//		}
		
		try {
			
			ExecutorService executor = Executors.newSingleThreadExecutor();
			Future<Float> future = executor.submit(new TaskRemove()); // Timeout of 10 minutes.
			try {
				marks += future.get(1, TimeUnit.SECONDS);
			}catch(TimeoutException e) {
				future.cancel(true);
				printerr("Get Size after remove has an infinite loop.");
			}
			executor.shutdown();
			
		} catch (Exception e) {
			printerr("Tester failed on get size after remove");
		}

		return marks;
	}
	
	public static float testAdd() {print("Test add...");
		float marks = 0.0f;
		try {
			int[] ex = new int[] {1};
			PersonList l = makeList(1);
			marks += testList(l, ex, "add first", ex.length);
			l = new PersonList();
			l.add(createPerson(1));
			marks += testList(l, ex, "add first case 2", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on first element in list.");
		}
		try {
			// Test front
			int[] ex = new int[] {1,2,3,4,5};
			PersonList l = makeList(5);
			marks += testList(l, ex, "add front", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on add front case.");
		}
		
		try {
			int[] ex = new int[] {1,2,3,4,5};
			PersonList l = makeList(5);
			l.add(createPerson(6), 5);
			if(l.personAt(5).getAge() != 6) {
				println("Did not insert person to back to of list propertly at index 5.");
			} else {
				marks += A7Test.GOOD_MARK;
			}
		} catch (Exception e) {
			printerr("Tester failed on add back case.");
		}
		
		try {
			int[] ex = new int[] {1,2,3,6,4,5};
			PersonList l = makeList(5);
			l.add(createPerson(6), 3);
			marks += testList(l, ex, "add middle at index 6", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on add middle case.");
		}
		
		try {
			int[] ex = new int[] {5,4,3,2,1};
			PersonList l = new PersonList();
			l.add(createPerson(1))
			 .add(createPerson(2))
			 .add(createPerson(3))
			 .add(createPerson(4))
			 .add(createPerson(5));
			marks += testList(l, ex, "add 5 people thru chaining", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on chaining list.");
		}
		
		try {
			int[] ex = new int[] {1,2,3,4,1,2,3,4,5,6,7,8,9,10,5};
			PersonList l = makeList(5);
			PersonList r = makeList(10);
			l.add(r,4);
			marks += testList(l, ex, "merge list of 5 with list of 10", ex.length);
		} catch (Exception e) {
			printerr("Tester failed on merge list.");
		}
		
		try {
			
			ExecutorService executor = Executors.newSingleThreadExecutor();
			Future<Float> future = executor.submit(new Task()); // Timeout of 10 minutes.
			try {
				marks += future.get(1, TimeUnit.SECONDS);
			}catch(TimeoutException e) {
				future.cancel(true);
				printerr("Get Size has an infinite loop.");
			}
			executor.shutdown();
			
		} catch (Exception e) {
			printerr("Tester failed on size after add.");
		}
		return marks;
	}
	
	public static float testList(PersonList l, int[] e, String test, int size) {
		try {
//			if(l.size() == 0 && (e.length != 0)) {
//				printerr(String.format("PersonList had a length 0: %s", test));
//				return 0.0f;
//			}
//			if(l.size() != e.length) {
//				printerr(String.format("PersonList did not match the correct size on test: %s", test));
//				for(int i = 0; i < l.size(); i++) {
//					if(l.personAt(i).getAge() != e[i]) {
//						printerr(String.format("PersonList did not match correct person at index %s (when l.size() != e.length)", i));
//						return 0.0f;
//					}
//				}
//				return A7Test.PARTIAL_MARK;
//			} else {
				for(int i = 0; i < size; i++) {
					if(l.personAt(i).getAge() != e[i]) {
						printerr(String.format("PersonList did not match correct person at index %s", i));
						return 0.0f;
					}
				}
				return A7Test.GOOD_MARK;
			//}		
		} catch (Exception t) {
			printerr(String.format("Exception occured while testing %s.", test));
			return 0.0f;
		}
	}
	
	public static float testList(PersonList l, int[] e, String test) {
		try {
			if(l.size() == 0 && (e.length != 0)) {
				printerr(String.format("PersonList had a length 0: %s", test));
				return 0.0f;
			}
			if(l.size() != e.length) {
				printerr(String.format("PersonList did not match the correct size on test: %s", test));
				for(int i = 0; i < l.size(); i++) {
					if(l.personAt(i).getAge() != e[i]) {
						printerr(String.format("PersonList did not match correct person at index %s (when l.size() != e.length)", i));
						return 0.0f;
					}
				}
				return A7Test.PARTIAL_MARK;
			} else {
				for(int i = 0; i < e.length; i++) {
					if(l.personAt(i).getAge() != e[i]) {
						printerr(String.format("PersonList did not match correct person at index %s", i));
						return 0.0f;
					}
				}
				return A7Test.GOOD_MARK;
			}		
		} catch (Exception t) {
			printerr(String.format("Exception occured while testing %s.", test));
			return 0.0f;
		}
	}
	
	public static PersonList makeList(int size) {
		try {
			if(size == 0) return new PersonList();
			PersonList l = new PersonList(createPerson(size));
			for(int i = size - 1; i > 0; --i) {
				l.add(createPerson(i));
			}
			return l;
		} catch (Exception e) {
			printerr(String.format("Exception on making list size %d", size));
		}
		return null;
	}
	
	public static Person createPerson(int id) {
		return new Person("p"+id, id);
	}

	public static void println(String msg) {
		System.out.println(msg);
	}
	
	public static void printlg(String msg) {
		if(A7Test.VERBOSE) {
			System.out.println(msg);
		}
	}
	
	public static void printerr(String msg) {
		System.err.println(msg);
	}
	
	
	public static class TaskRemove implements Callable<Float> {
	    @Override
	    public Float call() throws Exception {
	    	float marks = 0.0f;
	    	PersonList l = makeList(5);
			l.remove(2);
			
			
			if(l.size() == 4) {
				l.remove(2,3);
				if(l.size() == 3) {
					marks += A7Test.GOOD_MARK;
				} else {
					println("Failed to calculate size after removal of 1 range element.");
				}
			} else {
				println("Failed to calculate size after removal of 1 element.");
			}
			return marks;
	    }
	}
	public static class Task implements Callable<Float> {
	    @Override
	    public Float call() throws Exception {
	    	float marks = 0.0f;
	    	int[] ex = new int[] {1,2,3,6,4,5};
			PersonList l = makeList(5);
			if(l.size() == 5) {
				l.add(createPerson(6));
				if(l.size() == 6) {
					l.add(createPerson(7), 2);
					if(l.size() == 7) {
						PersonList a = makeList(3);
						l.add(a, 2);
						if(l.size() == 10) {
							marks += A7Test.GOOD_MARK;
						} else {
							println("Failed to determined size after add person list.");
						}
					} else {
						println("Failed to determined size after add middle.");
					}
				} else {
					println("Failed to determined size after add front.");
				}
				
			} else {
				println("Failed to determined size of 5.");
			}
			return marks;
	    }
	}
}

///**
// * 
// * @author CZL
// *
// *	Test Cases to consider:
// *		Remove:
// *			front, back, middle, every 2 other, empty list, from range(head to tail),
// *			from range(mid to tail), from invalid range, from inverse range,
// *			remove entire list from back, remove entire list from front, 
// *			* This test case removed* remove from invalid position
// *
// *		Add:
// *			front, insert back, insert middle, first element in list, chaining,
// *			size after an add after all add functions
// *
// *		Search:
// *			first person, middle person, last person, person non existent, index of person
// *			at front, back, middle, and non existent
// *
// *		Same as: 
// *			result and expected, null list, empty list, 
// *
// *		olderThan:
// *			older than all, older than none, older than some, older than some with exclusion
// *			check same order as original, older than first guy, older than last guy, 
// *			older than every other guy, check resulting list after calling this		
// *
// *		toString(): 
// *			string match it for a empty list and a non empty list
// */

