import java.io.*;
import java.util.Scanner;

class ReplaceWordInFileIO{
	static Scanner sc;
	public static void main(String[] args) {
		String[] files = new String[100];	
		File search = new File("FileIO");
		files = search.list(); // create the list
		//for(String fn : files) // iterate through it
		//System.out.println("found " + fn);
		File myFile = null;
		ReplaceWordInFileIO.sc = new Scanner(System.in);
		System.out.println("Enter the file name");
		String str = sc.nextLine();
		String fileStr = "";
		try{
			for(String fn : files){
				String splitStr = fn.split("\\.")[0];
				if (str.equals(splitStr)) {
					str = str + "." + fn.split("\\.")[1];
					break;
				}
			}
			myFile = new File("FileIO/" + str);
			BufferedReader br = new BufferedReader(new FileReader(myFile));
			if(myFile.exists() == false)
	            {
	                System.out.println("File doesn't exist!!!");
	                System.exit(0);
	            } else {
	            	String updatedStr = "";
	            	System.out.println("Enter the word to be replaced");
	            	String replacableStr = sc.nextLine();
	            	System.out.println("Enter the word replacing the existing word");
	            	String replacingStr = sc.nextLine();
	            	
	            	while((fileStr = br.readLine()) != null) {
	            	//System.out.println("Words of file before replacement : " + fileStr);	
					String[] wordList = fileStr.split(" ");
					for (int i = 0; i < wordList.length; i++) {
						String word = wordList[i];
						if (word.equals(replacableStr)) {
							word = fileStr.replace(replacableStr, replacingStr);
							//System.out.println("Words : " + word);
							//break;
						}
						updatedStr = updatedStr + " " + word;
					}
										

				}
				//System.out.println("Words of file after replacement : " + updatedStr);
				BufferedWriter bw = new BufferedWriter(new FileWriter(myFile));
					bw.write(updatedStr);
					bw.flush();
					bw.close();
	            }
            } catch(IOException ex){
        		System.out.println("File doesn't exist!!!");
        	}
	}
}