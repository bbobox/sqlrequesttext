package automaton;

import java.util.ArrayList;

public class Tags {
	
	private ArrayList<String> words;	
	private String name;
	
	
	public Tags(String nom){
		name=nom;
		words= new ArrayList<String>();
				
	}
	
	public void addWords(String word){
		 words.add(word);	
	}
	
	
	public ArrayList<String> getWords(){
		
		return words;
	}
	
	public String getName(){
		return name;
		
	}
	
	public void printSet(){
		System.out.println("tag="+name +"\n");
		for(int i=0;i<words.size();i++){
			
			System.out.println("\t"+words.get(i));
		}
		
		
	}
	
	public boolean contentElement(String word){
		
		boolean ok= false;
		int i=0;
		while(ok==false && i<words.size()){
			if(words.get(i).equalsIgnoreCase(word))
				ok= true;
			i++;
		}
		
		
		return ok;
	}
	
	
	

	 public static void main(String args[]){
		
		Tags test= new Tags("pronom");
		
		test.addWords("quel");
		test.addWords("qui");
		test.addWords("quand");
		
		test.printSet();
		
		
		// Ajouts des verbe
		
		Tags verbe= new Tags("verbre");
		
		verbe.addWords("est");
		verbe.addWords("prepare");
		verbe.addWords("habite");
		
		verbe.printSet();
		
	}
	
	
}
