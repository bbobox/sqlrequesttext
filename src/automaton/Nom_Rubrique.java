package automaton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import automaton.RequestInfo;
import automaton.Table_Rubrique;
import automaton.Tag;



/**
 * Nom d'une rubrique;
 * @author etudiant
 *
 */
public class Nom_Rubrique  implements Tag {
	
	String text=null;
	
	RequestInfo rI= new RequestInfo(); 
	
	Table_Rubrique table;
	
	Map<String, ArrayList<String>> rubriques;
	
	
	
	public Nom_Rubrique(){
		rubriques= new HashMap<String, ArrayList<String>>();
	}

	public boolean contentElement(String word) {
		boolean ok=false;
		
		if( rubriques.containsKey(word)){
			text=word;
			ok=true;
			rI.addTableRubrique( getTable(word));
			 rI.addAttribute(word);
			 
			 
			 if(rI.getListinfo().size()==0){
				 rI.getListinfo().add(word);
				 System.out.println("TYPE INFO AJOUTéé"+word);
			 }
		}

		return ok;
	}

	// AJout de rubrique
	public void addWords(String rubrique) {
			rubriques.put(rubrique, new ArrayList<String>());
	}
	
	public void addTable(String rubrique, String table){
		if (rubriques.containsKey(rubrique)){
			rubriques.get(rubrique).add(table);
		}
	}
	
	public String getTable(String rubrique){
		 int n= rubriques.get(rubrique).size();
		 
		 if (n==0){
			 
			 return null;
		 }
		 else{
			 
			 return rubriques.get(rubrique).get(n-1);
		 }
	}
	
	

	public String getTextAccepted() {
		// TODO Auto-generated method stub
		return text;
	}

	public RequestInfo rI() {
		// TODO Auto-generated method stub
		return rI;
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
