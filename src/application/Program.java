package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the path of file: ");
		String path = sc.nextLine();
		
		List<Product> list = new ArrayList<>();
		
		File originalFile = new File(path);
		String fileParent = originalFile.getParent();
		
		boolean sucess = new File(fileParent + "\\out").mkdir();
		System.out.println("Directory created: " + sucess);
		
		String newPath = fileParent + "\\out\\summmary.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String items = br.readLine();
			while(items != null) {
				String [] data = items.split(",");
				String name = data[0];
				double price = Double.parseDouble(data[1]);
				int quantity = Integer.parseInt(data[2]);
				
				list.add(new Product(name, price, quantity));
				
				items = br.readLine();
			}
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(newPath))){
				for(Product p:list) {
					bw.write(p.getName() + ", " + String.format("%.2f", p.finalPrice()));
					bw.newLine();
				}
				System.out.println("File summary: Created!");
			}
			catch(IOException e) {
				System.out.println("Error writing on directory: " + e.getMessage());
			}
		}
		catch(IOException e) {
			System.out.println("Error reading on directory: " + e.getMessage());
		}
	
		sc.close();
	}

}
