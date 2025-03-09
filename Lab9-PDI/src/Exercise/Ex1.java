package Exercise;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		// Create file and Generate 1000 Number
		String filename = "LuckyNumber.txt";
		Random random = new Random();
		try(FileWriter fw = new FileWriter(filename)) {
			for(int i = 0; i <= 1000; i++) {
				int number = random.nextInt(1000);
				fw.write(number + "\n");
				
			}
		} catch (IOException e) {
			System.out.println("File Error");
		}
		
		System.out.println("File Create\n");
		
		//Read data from LuckyNumber.txt file
		try (FileReader reader = new FileReader(filename)) {
			int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
		} catch (IOException e) {
			System.out.println("File Error");
		}
		
		// Find min and max number
		int min = 1000;
        int max = 0;
        
        try (FileReader reader = new FileReader(filename); Scanner scanner = new Scanner(reader)) {
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number < min) min = number;
                if (number > max) max = number;
            }
            System.out.println("Minimum number: " + min);
            System.out.println("Maximum number: " + max);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
    }
		
}
