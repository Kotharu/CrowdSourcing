package TwitterFileProcessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;

public class LocationExtraction {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		File file = new File(
				"C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/nag_pervasive2.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		String line = null;
		String str1 = "http://t.co/";
		String str2 = "https://t.co/";

		while ((line = br.readLine()) != null) {
			/*if (line.contains(str1)) {

					File file1 = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/loc.txt");

					// if file doesn't exists, then create it
					if (!file1.exists()) {
						file1.createNewFile();
					}

					FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(),true);
					BufferedWriter bw1 = new BufferedWriter(fw1);
					bw1.write(line);
					bw1.write("\n");
					bw1.close();

			}*/
			
			if (line.contains(str2)) {

					File file1 = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/Swarm data/swarm_checkins.txt");

					// if file doesn't exists, then create it
					if (!file1.exists()) {
						file1.createNewFile();
					}

					FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(),
							true);
					BufferedWriter bw1 = new BufferedWriter(fw1);
					bw1.write(line);
					bw1.write("\n");
					bw1.close();

			}
		}

		br.close();
		System.out.println("Done");
	}

}
