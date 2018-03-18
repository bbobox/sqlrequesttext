package automaton;

import java.util.ArrayList;

public class Table_Rubrique implements Tag {
	
	private ArrayList<String> ensemble_Rubrique;
	String text=null;
	
	RequestInfo rI= new RequestInfo(); 
	
	public Table_Rubrique(){
		ensemble_Rubrique=new ArrayList<String>();
	
		
	}
	
	public void  addValRubrique(String val){
		
		ensemble_Rubrique.add(val);
	}

	public boolean contentElement(String word) {
		boolean ok= false;
		int i=0;
		while(ok==false && i<ensemble_Rubrique.size()){
			if(ensemble_Rubrique.get(i).equalsIgnoreCase(word))
				ok= true; text=word;
				rI.addTableRubrique(word);
			i++;
		}

		return ok;
	}

	public void addWords(String string) {
		addValRubrique(string);
	}

	public String getTextAccepted() {
		// TODO Auto-generated method stub
		return text;
	}

	public RequestInfo rI() {
		// TODO Auto-generated method stub
		return rI;
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
