import java.io.*;
class DisplayCharLineWordCountFileIO{
	public static void main(String[] args) {
		try{
			File file = new File("readDisplay.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "";
			int counter = 0, countWord = 0, characterCount = 0;

			while((str = br.readLine()) != null)
			{	
					String[] wordList = str.split(" ");
					countWord += wordList.length;
					for (String charCount : wordList) {
						characterCount += charCount.length();
					}


				counter++;
			}
			System.out.println("Number of lines in the file : " + counter);
			System.out.println("Number of words in the file : " + countWord);
			System.out.println("Number of characters in the file : " + characterCount);



			br.close();
		} catch(IOException ex) {
			System.out.println("Exception caught......");
		}
	}
}