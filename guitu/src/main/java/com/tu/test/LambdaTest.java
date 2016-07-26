package com.tu.test;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

	public static void main(String[] args) {
		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
			       "Stanislas Wawrinka",  
			       "David Ferrer","Roger Federer",  
			       "Andy Murray","Tomas Berdych",  
			       "Juan Martin Del Potro"}; 
		List<String> players = Arrays.asList(atp);
		
		//老的方式
		for (String player : players) {
			System.out.print(player + ";");
		}
		
		System.out.println();
		System.out.println("===========");
		
		//lambda表达式
		players.forEach((player) -> System.out.print(player + ";"));
		
		System.out.println();
		System.out.println("===========");
		players.forEach(System.out::println); 
	}

}
