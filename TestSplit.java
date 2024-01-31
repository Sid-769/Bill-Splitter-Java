
class TestSplit {	

	private static int sum(UniqueOrderedList<Integer> soln) {
		CopyableIterator<Integer> it = soln.iterator();

		int sum = 0;
		while (it.hasNext()) {
			sum+=  it.next();

		}
		return sum;
	}

	public static void main (String[] args) { 
		try {

			System.out.println( "Split Test 01 " + (test01() ? "passed" : "failed" ));
		} catch (Exception e) { 
			System.out.println( "Split Test 01 failed, and an exception was thrown "+ e.getClass());
		}

		try {

			System.out.println( "Split Test 02 " + (test02() ? "passed" : "failed" ));
		} catch (Exception e) { 
			System.out.println( "Split Test 02 failed, and an exception was thrown "+ e.getClass());
		}
		try {

			System.out.println( "Split Test 03 " + (test03() ? "passed" : "failed" ));
		} catch (Exception e) { 
			System.out.println( "Split Test 03 failed, and an exception was thrown "+ e.getClass());
		}
		try {

			System.out.println( "Split Test 04 " + (test04() ? "passed" : "failed" ));
		} catch (Exception e) { 
			System.out.println( "Split Test 04 failed, and an exception was thrown "+ e.getClass());
		}

		try {

			System.out.println( "Split Test 05 " + (test05() ? "passed" : "failed" ));
		} catch (Exception e) { 
			System.out.println( "Split Test 05 failed, and an exception was thrown "+ e.getClass());
		}
		try {

			System.out.println( "Split Test 06 " + (test06() ? "passed" : "failed" ));
		} catch (Exception e) { 
			System.out.println( "Split Test 06 failed, and an exception was thrown "+ e.getClass());
		}
		try {

			System.out.println( "Split Test 07 " + (test07() ? "passed" : "failed" ));
		} catch (Exception e) { 
			System.out.println( "Split Test 07 failed, and an exception was thrown "+ e.getClass());
		}
		try {

			System.out.println( "Split Test 08 " + (test08() ? "passed" : "failed" ));
		} catch (Exception e) { 
			System.out.println( "Split Test 08 failed, and an exception was thrown "+ e.getClass());
		}

	}

	public static boolean test01() {
		UniqueOrderedList<Integer> al = new UniqueOrderedList<Integer>();
		UniqueOrderedList<Integer> soln = BillSplitter.split(al, 0);
		return (soln.size()==0);
	}

	public static boolean test02() { 

		UniqueOrderedList<Integer> al = new UniqueOrderedList<Integer>();
		al.add(3);
		UniqueOrderedList<Integer> soln = BillSplitter.split(al, 3);
		CopyableIterator<Integer> it = soln.iterator();

		return (soln.size()==1) && (it.hasNext()) && (it.next()==3);
	}

	public static boolean test03() { 
		Integer[] x = new Integer[]{1,2,3,4,5,6,7};
		UniqueOrderedList<Integer> al = new UniqueOrderedList<Integer>();

		for (int i = 0; i < x.length; i++) {
			al.add(x[i]);
		}
		UniqueOrderedList<Integer> soln = BillSplitter.split(al,100);
		return (soln==null);
	}

	public static boolean test04() { 
		Integer[] x = new Integer[]{1,2,3,4,5,6,7};
		UniqueOrderedList<Integer> al = new UniqueOrderedList<Integer>();

		for (int i = 0; i < x.length; i++) {
			al.add(x[i]);
		}
		UniqueOrderedList<Integer> soln = BillSplitter.split(al,12);
		return (soln!=null && sum(soln) == 12);
	}


	public static boolean test05() { 
		UniqueOrderedList<Integer> al = new UniqueOrderedList<Integer>();
		al.add(3);
		UniqueOrderedList<Integer> soln = BillSplitter.split(al, 10);


		return (soln == null);	
	}

	public static boolean test06() { 
		UniqueOrderedList<Integer> al = new UniqueOrderedList<Integer>();
		al.add(3);
		al.add(10);
		UniqueOrderedList<Integer> soln = BillSplitter.split(al, 15);


		return (soln == null);	
	}
	public static boolean test07() { 
		Integer[] x = new Integer[]{2,3,5,11,23,47,100,300,700,2000};
		UniqueOrderedList<Integer> al = new UniqueOrderedList<Integer>();

		for (int i = 0; i < x.length; i++) {
			al.add(x[i]);
		}
		UniqueOrderedList<Integer> soln = BillSplitter.split(al,2772);
		CopyableIterator<Integer> it = soln.iterator();
		
		Integer[] soln2772 = new Integer[]{ 2,23,47,700,2000 };
		
		boolean result = true;
		int i = 0;
		while (it.hasNext() && result) {
			Integer nex = it.next();
			result = result && (nex.equals(soln2772[i]));
			i++;
		}
		
		result = result && !it.hasNext();
		return (result);
	}
	public static boolean test08() { 
		final int BIG_SIZE = 31;
		UniqueOrderedList<Integer> al = new UniqueOrderedList<Integer>();
		UniqueOrderedList<Integer> soln2 = new UniqueOrderedList<Integer>();
		for (int i = 0; i < BIG_SIZE; i++) { 
			al.add((int)(Math.pow(2, i)));
		}
		
		for (int i = 0; i < BIG_SIZE - 1; i++) { 
			soln2.add((int)(Math.pow(2, i)));
		}
		
		
		UniqueOrderedList<Integer> soln = BillSplitter.split(al,(int)(Math.pow(2,BIG_SIZE-1))-1);
		if (soln != null) { 
			CopyableIterator<Integer> it =  soln.iterator();
			CopyableIterator<Integer> it2 = soln2.iterator();
			
			boolean result = true;
			while (it.hasNext() && result) {
				Integer nex = it.next();
				result = result && (nex.equals(it2.next()));
			
			}
			
			result = result && !it.hasNext();
			return (result);
		} else {
			return false;
		}
	
		

	}

}
