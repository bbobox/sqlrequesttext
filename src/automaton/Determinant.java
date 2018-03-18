package automaton;

import java.util.ArrayList;

public class Determinant implements Tag{
	

	ArrayList<String>  determinants;
	String text=null;
	 
	
	public Determinant(){
		determinants= new  ArrayList<String>();
	}

	public boolean contentElement(String word) {
		boolean ok= false;
		int i=0;
		while(ok==false && i<determinants.size()){
			if(determinants.get(i).equalsIgnoreCase(word))
				ok= true;
			   text=word;
			i++;
		}

		return ok;
	}

	// AJout de prnoms
	public void addWords(String string) {
		determinants.add(string);
		
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
