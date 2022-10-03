package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter file full path: ");
		String path = sc.next();
		
		Map<String, Integer> candidate = new LinkedHashMap<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int votes = Integer.parseInt(fields[1]);
				
				if(candidate.containsKey(name)) {
					candidate.put(name, candidate.get(name) + votes);
				}
				else {
					candidate.put(name, votes);
				}
				line = br.readLine();
			}
			for(String result : candidate.keySet()) {
				System.out.println(result + ": " + candidate.get(result));
			}
		}
		
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		finally {
			sc.close();
		}
	}
}
