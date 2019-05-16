import java.io.*;
class ReadDisplayFileIO{
	public static void main(String[] args) {
		try{
			File file = new File("readDisplay.txt");

			/*BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			 bw.write("Hello");
			 bw.newLine();
			 bw.write("my");
			 bw.newLine();
			 bw.write("name");
			 bw.newLine();
			 bw.write("is");
			 bw.newLine();
			 bw.write("hussham");
			 bw.flush();
			 bw.close();*/

			//StringBuilder sb = new StringBuilder("");
 
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = "";
			int counter = 1;
			while((str = br.readLine()) != null)
			{
			    //sb.append(str);
			//System.out.println(str);
			// str = br.readLine();
			// System.out.println(str);
				System.out.println("Line number " +counter +" is : " + str);
				counter++;
			}
			br.close();
			// fr.close();
			//System.out.println("Contents from file are : " + sb);
		} catch(IOException ex){
			System.out.println("Exception caught...");
		}
	}
}