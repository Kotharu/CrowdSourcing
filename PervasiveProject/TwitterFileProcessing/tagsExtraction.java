package TwitterFileProcessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class tagsExtraction {
	
	public static void main(String[] args) throws IOException {
		File file = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/Swarm data/swarm_checkins.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		while( (line = br.readLine())!= null ){		        
		    String [] tokens = line.split("---");
		    
		    
		    String var_1 = tokens[0];		    		    
		    File file1 = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/Swarm data/token1_date.txt");
		    
			// if file doesnt exists, then create it
			if (!file1.exists()) {
				file1.createNewFile();
			}
 
			FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(),true);
			BufferedWriter bw1 = new BufferedWriter(fw1);
			bw1.write(var_1);
			bw1.write("\n");
			bw1.close();
			
			String var_2 = tokens[1];
			File file2 = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/Swarm data/token2_tweet.txt");
		    
			// if file doesnt exists, then create it
			if (!file2.exists()) {
				file2.createNewFile();
			}
 
			FileWriter fw2 = new FileWriter(file2.getAbsoluteFile(),true);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			bw2.write(var_2);
			bw2.write("\n");
			bw2.close();
			
			
		    String var_3 = tokens[2];		    
		    File file3 = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/Swarm data/token3_RTcount.txt");
		    
			// if file doesnt exists, then create it
			if (!file3.exists()) {
				file3.createNewFile();
			}
 
			FileWriter fw3 = new FileWriter(file3.getAbsoluteFile(),true);
			BufferedWriter bw3 = new BufferedWriter(fw3);
			bw3.write(var_3);
			bw3.write("\n");
			bw3.close();
			
			
			
		    String var_4 = tokens[3];
		    File file4 = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/Swarm data/token4_username.txt");
		    
			// if file doesnt exists, then create it
			if (!file4.exists()) {
				file4.createNewFile();
			}
 
			FileWriter fw4 = new FileWriter(file4.getAbsoluteFile(),true);
			BufferedWriter bw4 = new BufferedWriter(fw4);
			bw4.write(var_4);
			bw4.write("\n");
			bw4.close();
			
		    
		    String var_5 = tokens[4];
		    File file5 = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/Swarm data/token5_GeoLocation.txt");
		    
			// if file doesnt exists, then create it
			if (!file5.exists()) {
				file5.createNewFile();
			}
 
			FileWriter fw5 = new FileWriter(file5.getAbsoluteFile(),true);
			BufferedWriter bw5 = new BufferedWriter(fw5);
			bw5.write(var_5);
			bw5.write("\n");
			bw5.close();
			
			
			
		}
		System.out.println("Done");
		br.close();
		}
	
}