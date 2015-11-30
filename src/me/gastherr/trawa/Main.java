package me.gastherr.trawa;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		double res = 10000;
		double last = 0;
		double przec = res;
		int day = 1;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		do{
			
			int change = (int) (last - res);
			
			System.out.println("=================================");
			System.out.println("Zasoby: "+res+" ("+change+")");
			System.out.println("Dzieñ: "+day);
			System.out.println("=================================");
			
			last = res;
			res += 150;
			
			przec = res; //Po procencie
			res -= res*3/100;
			przec = res;
			int przec2 = (int) przec;
			double roz  = przec - przec2;
			
			res -= roz;
			System.out.println("Przecinek: "+roz);
			day++;
			
		}while(!sc.next().equalsIgnoreCase("exit"));
		
		/**
		int a_day = 0;
		int b_day = 0;
		int car_am = 30;
		
		
		
		for(int i = 0; i<100000; i++){
			
			//Rachunek
			last = res;
			res -= 450;
			res += 600;
			res -= (res * 3) / 100;
			day++;
			
			//MAIN-A
			if (last < res) a_day = day;
			
			//MAIN-B	
			if(last == res) b_day = day;
			
			//MAIN-C
			int rac = res/15;
			if(rac < 30 && rac < car_am) car_am = (int) rac;
			
			
		}
		
		System.out.println("WYNIKI\n");
		System.out.println("OdpA: "+a_day);
		System.out.println("OdpB: "+b_day);
		System.out.println("OdpC: "+car_am);
		 */
		
		
	}

	
	
}
