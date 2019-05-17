import java.util.Scanner;
import java.util.Arrays;
class SortingStringObjects{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = sc.nextLine();
		String[] strList = new SortingStringObjects().sortStr(str);
		for (String sortStr : strList) {
				System.out.print(sortStr + " ");
			}
	}

	String[] sortStr(String str){
		String[] arr = str.split(" ");
		Arrays.sort(arr);
		int n = 0;
		if (arr.length % 2 == 0) {
			n = arr.length / 2;
		} else {
			n = (arr.length / 2) + 1;
		}

		for (int i = 0; i < n ; i++ ) {
			arr[i] = arr[i].toUpperCase(); 
		}	
		
		
		return arr;
		
	}
}