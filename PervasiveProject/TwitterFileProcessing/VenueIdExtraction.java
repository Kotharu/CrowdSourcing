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

public class VenueIdExtraction {

	public static void main(String[] args) throws IOException {

		File file = new File(
				"C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/token2_tweet.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(file)));
		String line = null;
		String str1 = "http://t.co/";
		String str2 = "https://t.co/";

		while ((line = br.readLine()) != null) {
			if (line.contains(str1)) {

				String regex = "(http\\:\\//t\\.co\\/\\w+)";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()) {
					String var_1 = matcher.group(1);
					String temp = var_1.split("http\\:\\//t\\.co\\/")[1].split("\\n")[0];

					File file1 = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/venue_id.txt");

					// if file doesn't exists, then create it
					if (!file1.exists()) {
						file1.createNewFile();
					}

					FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(),
							true);
					BufferedWriter bw1 = new BufferedWriter(fw1);
					bw1.write(temp);
					bw1.write("\n");
					bw1.close();

					//System.out.println(var_1);
				}

			}
			
			if (line.contains(str2)) {

				String regex = "(https\\:\\//t\\.co\\/\\w+)";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()) {
					String var_1 = matcher.group(1);
					String temp = var_1.split("https\\:\\//t\\.co\\/")[1].split("\\n")[0];

					File file1 = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/venue_id.txt");

					// if file doesn't exists, then create it
					if (!file1.exists()) {
						file1.createNewFile();
					}

					FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(),
							true);
					BufferedWriter bw1 = new BufferedWriter(fw1);
					bw1.write(temp);
					bw1.write("\n");
					bw1.close();

					//System.out.println(var_1);
				}

			}
		}

		br.close();
		System.out.println("Done");
	}

}
