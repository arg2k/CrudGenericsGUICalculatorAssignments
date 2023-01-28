package GenericsAssignment;

public class GenericPrintMethod {
	public <E> void print(E arr[]) {
		System.out.print("Elements of the array: ");
		for (E element : arr)
			System.out.print(element + " ");

		System.out.println();
	}
}
