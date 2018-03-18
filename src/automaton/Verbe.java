package automaton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Verbe implements Tag{
	
	//Table_Rubrique sujet;
	//Rubrique objet;
	//String verbe_name;
	Map<String, InfoVerbe> verbes;
	
	
	
	String text=null;
	
	RequestInfo rI= new RequestInfo(); 
	

	
	String attribuCorrespondant=null;
	
	public Verbe(){
		// verbe_name=verbe;
		verbes = new HashMap<String, InfoVerbe>();
		}

	public boolean contentElement(String word) {
		boolean ok= false;
		//int i=0;
		
		if (verbes.containsKey(word)){
		//while(ok==false && i<verbes.size()){
		//	if(verbes.get(i).equalsIgnoreCase(word))
			System.out.println("VERBE="+word);
			
			
			if (verbes.get(word).getAttribut()!=null && verbes.get(word).getObjet()==null){
				System.out.println("Attribut="+verbes.get(word).getAttribut());
				rI.addListAttr(verbes.get(word).getAttribut()); // attribut de verbel'attribut dans la liste l'attente d'attribut
			}
			ok= true; 
			text=word;
			//i++;	
			
			// si le sujet et l'objet sont differents de Zero
			
			if (verbes.get(word).getSujet()!=null && verbes.get(word).getObjet()!=null){
				String table_sujet= verbes.get(word).getSujet();
				String attribut=  verbes.get(word).getAttribut();
				
				String table_object= verbes.get(word).getObjet();
				rI.addQualificatif(table_sujet+"."+attribut, table_object+"."+attribut);
				
				System.out.println("Ajout du couple-------------------"+rI.getCouple_rubrique().size());
				
				rI.addListAttr(table_object+"."+attribut);
				rI.addTableRubrique(table_object);
				
			}
			
			
		}
		

		return ok;

	}
	
	// ajout d'un attribut
	
	public void addAttribut(String att){
		attribuCorrespondant=att;
	}
	
	// ajout d'un object
	
	public String getAttribuCorrespondant() {
		return attribuCorrespondant;
	}

	public void setAttribuCorrespondant(String attribuCorrespondant) {
		this.attribuCorrespondant = attribuCorrespondant;
	}

	public void addObjet(String object){
		
		object=object;
	}
	
	

	
	// ajou d'un sujet
   /*	
	public void addSujet(String sujet){
		
		object=sujet;
	}

	public String getObject() {
			return object;
	
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}*/

	// ajout d'un verbe à la liste
	public void addWords(String verbe) {
		
		verbes.put(verbe, new  InfoVerbe());
	}
	
	public void addInfoVerbe(String verbe, InfoVerbe infv){
		
		verbes.put(verbe, infv);
		
	}
	
	public void addSujet(String verbe, String sujet){
		
		if (verbes.containsKey(verbe)){
			verbes.get(verbe).setSujet(sujet);
		}
		
	}
	
	public void addObjet(String verbe, String object){
			
			if (verbes.containsKey(verbe)){
				verbes.get(verbe).setObjet(object);
			}
			
		}
	
	public void addAttrCorrespond(String verbe, String att){
		
		if (verbes.containsKey(verbe)){
			verbes.get(verbe).setAttribut(att);
		}
		
	}
	
	
	public void addSujet(){
		
	}
	
	public void addObject(){
		
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
	
	

	
		
}
