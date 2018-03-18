package automaton;

import java.util.ArrayList;

public class Mot implements Tag {
	
	//private ArrayList<String> words;	
	private String mot;
	String text=null;
	
	
	public Mot(String nom){
		mot=nom;
		//words= new ArrayList<String>();
			
	}
	
	public void addWords(String word){
		// words.add(word);	
	}
	

	/*public ArrayList<String> getWords(){
		
		return words;
	}*/
	
	public String getName(){
		return mot;
		
	}
	
	/*public void printSet(){
		System.out.println("tag="+name +"\n");
		for(int i=0;i<words.size();i++){
			
			System.out.println("\t"+words.get(i));
		}
		
		
	}*/

	public boolean contentElement(String word){
			if ( word.equalsIgnoreCase(mot)){
				text=word;
			}
				
	
		return word.equalsIgnoreCase(mot);
	}

	public String getTextAccepted() {
		// TODO Auto-generated method stub
		return text;
	}

	public RequestInfo rI() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addTable(String rubrique, String table) {
		// TODO Auto-generated method stub
		
	}

	public void addAttribut(String att) {
		// TODO Auto-generated method stub
		
	}

	public void addSujet() {
		// TODO Auto-generated method stub
		
	}

	public void addObject() {
		// TODO Auto-generated method stub
		
	}

	public void addInfoVerbe(String verbe, InfoVerbe infv) {
		// TODO Auto-generated method stub
		
	}
	
	
}
