package ca.sheridancollege.controllers;

import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random; 

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import ca.sheridancollege.DataStructure.DataStruc;
import ca.sheridancollege.beans.Matrix;
import ca.sheridancollege.beans.StoreData;
import ca.sheridancollege.database.DataBaseAccess;


@Controller
public class HomeController {
	@Autowired
	private DataBaseAccess ds;
	
	private int sz;
	private char[][] arr;
	

	@GetMapping("/")
	public String goHome(Model model) {
		
		model.addAttribute("data",new StoreData());
				
		return "home.html";
		
	}
	
	@GetMapping("/add")
	public String doUserChoice(Model model,@ModelAttribute("data") StoreData data) {
				
		DataStruc.dt.add(data);
	
		ds.addDrink(data);
		
		sz=(int) data.getNo();
		
		arr= new char[sz][sz]; 
		Random r = new Random();
		
	    char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

	    for(int i = 0; i < arr.length; i++){
	        for(int j = 0; j < arr[i].length; j++){
	           
	        	int randNum = r.nextInt(26);
	            arr[i][j] = alphabet[randNum];
	            
	        }System.out.println();
	    }
		
	    saveMatrixToFile();
	
	    return "rules.html";
	}


	@GetMapping("/search")
	public String goSearch(Model model) {
		
		model.addAttribute("max",new Matrix());
		
		return "search.html";
		
	}
	
	@GetMapping("/play")
	public String doPlay(Model model,@ModelAttribute("max") Matrix max) {
				
		DataStruc.mat.add(max);		
		
		max.patternSearch(arr,sz);
		model.addAttribute("datas",DataStruc.mat);
				
		return "results.html";
	}
	
	@GetMapping("/over")
	public String goOver() {
			
		return "over.html";
		
	}
	
public void saveMatrixToFile() {
		
		File file = new File("charMatrix.txt");
		
		try {
		
			FileWriter fw= new FileWriter(file);
			
			String firstLine = String.format("m= %d, n= %d\n",sz,sz);
			fw.write(firstLine);
		
			for(int i=0; i<sz; i++) {	
				String line="";
			
				for(int j=0; j<sz; j++) {
			
					line=line+arr[i][j]+" ";
				}
				fw.write(line+"\n");
			}
					
			fw.close();
			
		}catch (IOException ex) {
			System.out.println("IO Exception Error");
		 }
		
	}


}
