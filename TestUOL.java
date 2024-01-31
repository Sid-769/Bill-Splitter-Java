import java.util.NoSuchElementException;

public class TestUOL {

	private static UniqueOrderedList<Integer> list;

	public static void main (String[] args) { 

		try {
			System.out.println( "UOL Test 01 " + (test01() ? "passed" : "failed" ));
		} catch (Exception e) { 
			System.out.println( "UOL Test 01 failed, and an exception was thrown " + e.getClass());
		}
		
		try {
			System.out.println( "UOL Test 02 " + (test02() ? "passed" : "failed" ));

		} catch (Exception e) { 
			System.out.println( "UOL Test 02 failed, and an exception was thrown "+ e.getClass());
		}

		try {
			System.out.println( "UOL Test 03 " + (test03() ? "passed" : "failed" ));
		} catch (Exception e) { 
			System.out.println( "UOL Test 03 failed, and an exception was thrown " + e.getClass());
		}
		
		try {
			System.out.println( "UOL Test 04 " + (test04() ? "passed" : "failed" ));
		} catch (Exception e) { 
			System.out.println( "UOL Test 04 failed, and an exception was thrown "+ e.getClass());
		}

		try {
			System.out.println( "UOL Test 05 " + (test05() ? "passed" : "failed" ));
		} catch (Exception e) { 
			System.out.println( "UOL Test 05 failed, and an exception was thrown "+ e.getClass());
		}



	}
	public static void setUp() {
		list = new UniqueOrderedList<>();
	}

	public static boolean test01() {

		setUp();
		list.add(1);
		list.add(2);
		list.add(3);

		CopyableIterator<Integer> iterator = list.iterator();

		boolean b1 = iterator.hasNext();
		Integer i1 = iterator.next();
		boolean b2 = iterator.hasNext();
		Integer i2 = iterator.next();
		boolean b3 = iterator.hasNext();
		Integer i3 = iterator.next();
		boolean b4 = iterator.hasNext();

		return b1 && (i1 == 1) && b2 && (i2==2) && b3 && (i3==3) && !b4;

	}

	public static boolean test02() {
		setUp();
		list.add(3);
		list.add(2);
		list.add(1);

		CopyableIterator<Integer> iterator = list.iterator();
		boolean b1 = iterator.hasNext();
		Integer i1 = iterator.next();
		boolean b2 = iterator.hasNext();
		Integer i2 = iterator.next();
		boolean b3 = iterator.hasNext();
		Integer i3 = iterator.next();
		boolean b4 = iterator.hasNext();

		return b1 && (i1 == 1) && b2 && (i2==2) && b3 && (i3==3) && !b4;


	}

	public static boolean test03() {
		setUp();
		CopyableIterator<Integer> iterator = list.iterator();
		return !(iterator.hasNext());
	}
	

	public static boolean test04() { 

		setUp();
		CopyableIterator<Integer> it = list.iterator();
		boolean b1 = !it.hasNext();

		if (!b1) { 
			return false;
		} else {
			try { 
				it.next();
				return false;
			} catch (NoSuchElementException e) {
				return (e.getMessage().equals("iterator empty"));
			}
		}
	}

	public static boolean test05() { 
		setUp();
		list.add(9001);
		CopyableIterator<Integer> it = list.iterator();

		boolean b1 = it.next() == 9001;
		boolean b2 = !it.hasNext();

		if (!(b1&&b2)) {
			return false;
		} else  {

			try { 
				it.next();
				return false;
			} catch (NoSuchElementException e) {
				return (e.getMessage().equals("iterator empty"));
			}
		}


	}

	

}