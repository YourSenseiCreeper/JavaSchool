package me.gastherr.napisy;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		//DATABASE
		int answ_a = 0;
		int answ_b = 0;
		
		int answ_c0 = 0;
		int answ_c1 = 0;
		HashMap<Integer, Integer> numbers = new HashMap<>();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Podaj nazwê pliku zawieraj¹cego dane:\n");
		String fname = sc.next();
		
		//LOADING FILE
		ArrayList<String> rows = new ArrayList<>();
		
		try {
			File f = new File("");
			Path absolute = Paths.get(f.getAbsolutePath(), fname);
			BufferedReader buffer = Files.newBufferedReader(absolute);
			
			String line;
			while((line = buffer.readLine()) != null){
				rows.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		//MAIN-A
		
		int zero = 0;
		int one = 0;
		
		for(String a : rows){
			if(a.length() %2 == 0) answ_a++;
			
			//MAIN-B
			for(char c : a.toCharArray()){
				if (c == '0') zero++;
				else one++;
			}
			if (zero == one) answ_b++;
			
			//MAIN-C
			if (zero-one == zero) answ_c0++;
			if (one-zero == one) answ_c1++;
			
			//MAIN-D
			int l = a.length();
			if(numbers.get(l) == null){
				numbers.put(l, 1);
			}
			numbers.replace(l, numbers.get(l)+1);
			
			zero = 0;
			one = 0;
		}
		
		System.out.println("\nWYNIKI:\n");
		System.out.print("Odp A: "+answ_a+"\n");
		System.out.print("Odp B: "+answ_b+"\n");
		System.out.print("Odp C0: "+answ_c0+"\n");
		System.out.print("Odp C1: "+answ_c1+"\n");
		System.out.print("Odp D: \n");
		for(int a : numbers.keySet()){
			System.out.println(a+"-znakowych: "+numbers.get(a));
		}
	}

}
