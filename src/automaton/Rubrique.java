package automaton;

import java.util.ArrayList;

public class Rubrique  implements Tag{
	
	private String  table;
	
	private String name;
	
	private ArrayList<String> possibles_values;
	String text=null;
	
	
	public Rubrique(String name, String table){
		this.name= name;
		this.table=table;
		possibles_values= new ArrayList<String> ();
		
	}
	

	

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getPossibles_values() {
		return possibles_values;
	}

	public void setPossibles_values(ArrayList<String> possibles_values) {
		this.possibles_values = possibles_values;
	}

	public boolean contentElement(String word) {
		// TODO Auto-generated method stub
		return false;
	}

	public void addWords(String word) {
		possibles_values.add(word);	
		
	}




	public String getTextAccepted() {
		// TODO Auto-generated method stub
		return null;
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
