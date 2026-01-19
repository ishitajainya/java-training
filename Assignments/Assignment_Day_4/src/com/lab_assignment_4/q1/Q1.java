package com.lab_assignment_4.q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Q1 {
	public static void main(String args[]) {
		Map<String, Integer> mp = new HashMap<>();
		try(BufferedReader br = new BufferedReader(new FileReader("src\\com\\lab_assignment_4\\q1\\source.txt"))){
			String line;
			while((line = br.readLine()) != null) {
				line = line.toLowerCase().replaceAll("[^a-z\\s]", "").trim();
				if(line.isEmpty()) continue;
				String words[] = line.split("\\s+");
				for(String word : words) {
					mp.put(word, mp.getOrDefault(word, 0) + 1);
				}
			}
			for(Map.Entry<String, Integer> entry : mp.entrySet()) {
				System.out.println("Word : " + entry.getKey() + "  Freq : " + entry.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
