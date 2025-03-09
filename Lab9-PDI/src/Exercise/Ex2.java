package Exercise;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		String filename = "StudentData.csv";
		
		String[] name = new String[3];
		String[] ID = new String[3];
		String[] major = new String[3];
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i<3; i++) {
		
			System.out.print("Enter Student Name: ");
			name[i] = input.nextLine();
			System.out.print("Enter Student ID: ");
			ID[i] = input.nextLine();
			System.out.print("Enter Student Major: ");
			major[i] = input.nextLine();
			System.out.println("");
		
		}
		
		input.close();
		
		try(FileWriter fw = new FileWriter(filename)) {
			fw.write("Student Info:\n");
			for(int i = 0; i<3; i++) {
				// Horizontal Line
//				fw.write("Name: "+ name[i] + "," + "ID: " + ID[i] + "," + "Major: " + major[i] + ",");
				
				// Vertical Line
				fw.write("Name" + name[i] + "\n");
				fw.write("ID: "+ ID[i] + "\n");
				fw.write("Major: "+ major[i] + "\n");
			}
		}
		catch (IOException e) {
			System.out.println("File Error");
		}
		
		System.out.println("File Created");
	}
}
