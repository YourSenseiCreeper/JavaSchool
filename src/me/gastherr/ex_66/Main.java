package me.gastherr.ex_66;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		//INPUT
		
		ArrayList<String> out = new ArrayList<>();
		
		File f = new File("");
		
		
		try {
			
		Path absolute = Paths.get(f.getAbsolutePath()+"/src/me/gastherr/ex_66/trojki.txt");
		BufferedReader reader = Files.newBufferedReader(absolute);
		
		String line;
		while((line = reader.readLine()) != null){
			out.add(line);
		}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// ======
		
		//66.1
		
		ArrayList<String> answ_1 = new ArrayList<>();
		
		{//////////////////////////////////
		for(String r : out){
			
		String[] num = r.split(" ");
		
		int last = Integer.parseInt(num[2]);
		num[2] = "0";
		int plus = 0;
		
		for(String r2 : num){
			for(char r3 : r2.toCharArray()){
				plus += Integer.parseInt(r3+"");
			}
		}
		
		if (plus == last) answ_1.add(r);
			
		}
		}//////////////////////////////////
		
		//66.2 + 66.3
		
		ArrayList<String> answ_2 = new ArrayList<>();
		ArrayList<String> answ_3 = new ArrayList<>();
		
		String last = "";
		for(String b : out){
			String[] num = b.split(" ");
		
			int n1 = Integer.parseInt(num[0]);
			int n2 = Integer.parseInt(num[1]);
			int n3 = Integer.parseInt(num[2]);
			
			if(eratos(n1) && eratos(n2)){
				if(n1 * n2 == n3) answ_2.add(b);
			}
			
			//66.3
			
			if(n1*n1+n2*n2 == n3*n3){
				if (last != ""){
					answ_3.add(last);
					answ_3.add(b);
					answ_3.add(" ");
					last = "";
				}
				last = b;
			}
			
			//66.4
			
			//???
		}
		
		//OUTPUT
		for(String a1 : answ_1){
			System.out.println(a1);
		}
		System.out.println("\n//////////////////////////\n");
		
		for(String a2 : answ_2){
			System.out.println(a2);
		}
		System.out.println("\n//////////////////////////\n");
		
		for(String a3 : answ_3){
			System.out.println(a3);
		}
		System.out.println("\n//////////////////////////\n");
	}
	
	
	//Przekszta³cone sito Eratostenesa pod wykrywanie jednostkowe
	public static boolean eratos(int num){
		
		for(int i = 2; i<9; i++){
			if(num % i == 0) return false;
		}
		
		return true;
	}

}
