package me.gastherr.hasla;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static ArrayList<String> input;
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String filename = "";
		HashMap<Character, Integer> ascii;
		
		
		{
			ascii = new HashMap<>(27);
			String abet = "abcdefghijklmnopqrstuvwxyz";
			int ascii_s = 97;
			for(int i = 0; i<26; i++){
				ascii.put(abet.charAt(i), ascii_s+i);
			}
		}
		
		switch(sc.next()){
		
			case "metoda1":
			
				{
					System.out.print("Podaj nazwê pliku:\n");
					
					filename = sc.next();
					
					ArrayList<String> bf2 = buffer(filename);
					if (bf2 == null) return;
					input = bf2;
					
					//Parzysta liczba znaków
					int matches = 0;
					
					for(String i : input){
						if(i.length() % 2 == 0) matches++;
					}
					
					System.out.print("Iloœæ hase³ z parzyst¹ liczb¹ znaków: "+matches);
					System.out.println();
					break;
				}
				
			case "metoda2":
				
				{
					System.out.print("Podaj nazwê pliku:\n");
					
					filename = sc.next();
					
					ArrayList<String> bf2 = buffer(filename);
					if (bf2 == null) return;
					input = bf2;
					
					//Palindromy
					
					ArrayList<String> palidrons = new ArrayList<>();
					
					over:
					for(String i : input){
						if(i.length() % 2 != 0){
							int am = (i.length() - 1) / 2;
							for(int e = 0; e<am; e++){
								if(i.charAt(e) == i.charAt(i.length()-e-1));
								else continue over;
							}
							palidrons.add(i);
						}
					}
					
					System.out.print("Wykryto "+palidrons.size()+" palidrom. Podaj nazwê pliku do zapisu: \n");
					String filename2 = sc.next();
					
					try {
						PrintWriter outt = new PrintWriter(new File(".", filename2));
						
						for(String pa: palidrons){
							outt.println(pa);
						}
						
						outt.close();
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					
					System.out.println("Wyniki wyeksportowano do pliku: "+filename2);
					System.out.println();
					break;
				}
			
			case "metoda3":
				
			{
				System.out.print("Podaj nazwê pliku:\n");
				
				filename = sc.next();
				
				ArrayList<String> bf2 = buffer(filename);
				if (bf2 == null) return;
				input = bf2;
				
				//ASCII filtr
			
				ArrayList<String> asc = new ArrayList<>();
				
				for(String pass : input){
					int last = 0;
					for(char c : pass.toCharArray()){
						if(ascii.get(c)+last == 220) asc.add(pass);
						else last = ascii.get(c);
					}
				}
				
				System.out.print("Znaleziono "+asc.size()+" hase³ pasuj¹cych do filtra."
						+ "\nPodaj nazwê pliku do którego wyniki maj¹ byæ wyeksportowane\n");
				
				String filename2 = sc.next();
				try {
					PrintWriter out = new PrintWriter(new File(".", filename2));
					
					for(String pass : asc){
						out.println(pass);
					}
					
					out.close();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				System.out.println("Wyniki wyeksportowano do pliku: "+filename2);
				System.out.println();
				break;
			}
				
			default: System.out.println("Komendy do wyboru: metoda1, metoda2, metoda3");
			
		}
		
		if(sc.next().equalsIgnoreCase("metoda1")){
			System.out.print("Podaj nazwê pliku:\n");
			
			filename = sc.next();
			
			ArrayList<String> bf2 = buffer(filename);
			if (bf2 == null) return;
			input = bf2;
			
			//Parzysta liczba znaków
			int matches = 0;
			
			for(String i : input){
				if(i.length() % 2 == 0) matches++;
			}
			
			System.out.print("Iloœæ hase³ z parzyst¹ liczb¹ znaków: "+matches);
			
		}
		else if(sc.next().equalsIgnoreCase("metoda2")){
			System.out.print("Podaj nazwê pliku:\n");
			
			filename = sc.next();
			
			ArrayList<String> bf2 = buffer(filename);
			if (bf2 == null) return;
			input = bf2;
			
			//Palindromy
			
			ArrayList<String> palidrons = new ArrayList<>();
			
			over:
			for(String i : input){
				if(i.length() % 2 != 0){
					int am = (i.length() - 1) / 2;
					for(int e = 0; e<am; e++){
						if(i.charAt(e) == i.charAt(i.length()-e-1));
						else continue over;
					}
					palidrons.add(i);
				}
			}
			
			System.out.print("Wykryto "+palidrons.size()+" palidrom. Podaj nazwê pliku do zapisu: \n");
			String filename2 = sc.next();
			
			try {
				PrintWriter outt = new PrintWriter(new File(".", filename2));
				
				for(String pa: palidrons){
					outt.println(pa);
				}
				
				outt.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			System.out.println("Wyniki wyeksportowano do pliku: "+filename2);
			
		}
		else if(sc.next().equalsIgnoreCase("metoda3")){
			System.out.print("Podaj nazwê pliku:\n");
			
			filename = sc.next();
			
			ArrayList<String> bf2 = buffer(filename);
			if (bf2 == null) return;
			input = bf2;
			
			//ASCII filtr
		
			ArrayList<String> asc = new ArrayList<>();
			
			for(String pass : input){
				int last = 0;
				for(char c : pass.toCharArray()){
					if(ascii.get(c)+last == 220) asc.add(pass);
					else last = ascii.get(c);
				}
			}
			
			System.out.print("Znaleziono "+asc.size()+" hase³ pasuj¹cych do filtra."
					+ "\nPodaj nazwê pliku do którego wyniki maj¹ byæ wyeksportowane\n");
			
			String filename2 = sc.next();
			try {
				PrintWriter out = new PrintWriter(new File(".", filename2));
				
				for(String pass : asc){
					out.println(pass);
				}
				
				out.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			System.out.println("Wyniki wyeksportowano do pliku: "+filename2);
			System.out.println();
			
		}

	}
	
	public static ArrayList<String> buffer(String fname){
		
		if (input != null){
			return input;
		}
		ArrayList<String> out = new ArrayList<>();
		
		try {
			File f = new File("");
			Path absolute = Paths.get(f.getAbsolutePath(), fname);
			BufferedReader buffer = Files.newBufferedReader(absolute);
			
			String line;
			while((line = buffer.readLine()) != null){
				out.add(line);
			}
			
			return out;
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
