package GenericsAssignment;

public class TesterClass {

	public static void main(String[] args) {
		GenericPrintMethod ge = new GenericPrintMethod();
		Integer arr[] = { 1, 2, 3 };
		Double arr2[] = { 1.1, 2.2, 3.3 };
		Character arr3[] = { 'a', 'b', 'c' };
		String arr4[] = { "Mohit" , "Argha", "Rohit" };
		ge.print(arr);
		ge.print(arr2);
		ge.print(arr3);
		ge.print(arr4);
	}

}
