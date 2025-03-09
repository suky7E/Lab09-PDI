package Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex3 {
	public static void main(String[] args) {
		String filename = "StudentData.csv";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = reader.readLine()) != null) {
				 System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("File Error");
		}
	}
}
