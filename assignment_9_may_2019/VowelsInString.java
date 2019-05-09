import java.util.Scanner;
class VowelsInString{
	public static void main(String[] args) {
		String str = "";
		int counter = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String: ");
		str = sc.nextLine();
		System.out.println("The number of vowels in the string is: " + new VowelsInString().checkVowel(str, counter));
	}

	int checkVowel(String str, int counter){
		//String []arr = str.split("");
		for (int i = 0; i < str.length(); i++) {
			char matStr = str.charAt(i);
			if (matStr == 'a' || matStr == 'e' || matStr == 'i' || matStr == 'o'|| matStr == 'u') {
				//System.out.println("found Vowel");
				counter++;
							
			}			
		}
		return counter;
	}
}