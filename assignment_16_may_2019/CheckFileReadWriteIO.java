import java.io.*;
import java.util.Scanner;
class CheckFileReadWriteIO{
	public static void main(String[] args) throws IOException {
		String[] files = new String[100];	
		File search = new File("FileIO");
		files = search.list(); // create the list
		//for(String fn : files) // iterate through it
		//System.out.println("found " + fn);
		File myFile = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name");
		String str = sc.nextLine();
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
	            	System.out.println("File exist!!!");
	            	if (myFile.canRead() == false) {
			        	System.out.println("File is not readable!!!");
			        } else {
			        	System.out.println("File is readable!!!");
			        }

			        if (myFile.canWrite() == false) {
			        	System.out.println("File is not writable!!!");
			        } else {
			        	System.out.println("File is writable!!!");
			        }
			        String extension = "";
					int i = str.lastIndexOf('.');
					if (i >= 0) { 
						extension = str.substring(i+1);
						System.out.println("File is of type : " + extension);
						}
						System.out.println("Size of file : " + myFile.length() +" bytes");
			        
	            }

	        } catch(IOException ex){
	        	System.out.println("File doesn't exist!!!");
	        }
	        


	}
}