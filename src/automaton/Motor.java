package automaton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Motor {
	
	String[] seq;
	ArrayList<State> etats;
	State init_e;
	State final_e;
	State current_state;
	String chaine;
	String nom_automate;
	int i=0;
	
	ArrayList<String> rubriqueSqlTables;
	ArrayList<String> rubriqueName;
	ArrayList<String> rubriqueValues;
	
	String name;
	boolean accept=false;
	
	RequestInfo rInfo;
	
	SqlTraductor sqlTrad;
	
	ArrayList<String> listeAttributs; 
	
	public Motor(String s,State e, State fe, String nom_motor){
		
		seq=s.split(" ");
		chaine="";
		init_e=e;
		final_e=fe;
		ArrayList<State> etats= new ArrayList<State>();
		etats.add(init_e);
		etats.add(final_e);
		current_state=init_e;
		
		name=nom_motor;
		rInfo=new RequestInfo();
		
		sqlTrad= new SqlTraductor();
		listeAttributs=  new ArrayList<String>();
		
	}
	 //-------------------------------------------------------------------
	
	
	public ArrayList<String> getListeAttributs() {
		return listeAttributs;
	}
	
	public void addAttribut(String att){
		listeAttributs.add(att);
		
	}
	
	public void supAttribut(String att){
		listeAttributs.add(att);
		listeAttributs.clear();
	}
	



	public void setListeAttributs(ArrayList<String> listeAttributs) {
		listeAttributs = listeAttributs;
	}



	public void  clearMotor(){
		current_state=init_e;
	}
	
	
	public void aaddState( State e){
		etats.add(e);
	}
	
	
	public void testSequence(int i){
		 this.i=i;
		 System.out.print(name+": i="+i);
		 if (i<seq.length){
			 System.out.print(" mot_suivant:"+seq[this.i]); 
		 }
		 System.out.println(" Etat actuel :"+current_state.getId_etat());
		 
		 if (i>seq.length-1 ){
			 
			 if (current_state.equals(final_e)){
				 
				 System.out.println("SUCESS|"+name+">>"+"Etat:"+current_state.getId_etat()+">> "+"texte reconnu="+chaine);
				 accept=true;
				 
			 }
			 else{
				 
				 System.out.println("ECHEC|"+name+">>"+"Etat:"+current_state.getId_etat()+">> "+"texte reconnu="+chaine);
				 accept=false;
			 }
			 
		 }
		 
		 else{
			 String current_word=seq[this.i];
			 
			 if (current_state.verif_etat(current_word)==false){
			
				 
				 if (current_state.equals(final_e)){ // si l'etat est acceptant
					 System.out.println("SUCESS|"+name+">>"+"Etat:"+current_state.getId_etat()+">> "+"texte reconnu="+chaine);
					 accept=true;
				 } else{
					
					 System.out.println(current_state.isTransition());
					 if(current_state.isTransition()==true){
						 current_state=current_state.getEpsiloTransition();
						 testSequence(this.i);
					 }
					 else{
					 
						 System.out.println("ECHEC|"+name+">>"+"Etat:"+current_state.getId_etat()+">> "+"texte reconnu="+chaine);
						 accept=false;
					 }
				 }
			 }else {
				 
				 
				 chaine=chaine+" "+ current_state.getTextAccepted();//current_word;
				 addRInfo(current_state.rI());
				 current_state=current_state.getNextState();
				 testSequence(this.i+1);
			 }
			 
		 }
		 
		 
		
}
	
	
	
	public boolean lectureAcceptante(){
		return accept;
	}
	
	public int getI(){
		
		return this.i;
	}
	
	public String getTextAccepted(){
		return chaine;
	}
	
	public void  addRInfo(RequestInfo rI){
		
		//AJout des Tables
		for(int i=0; i<rI.getTablesRubrique().size();i++){
			rInfo.addTableRubrique(rI.getTablesRubrique().get(i));
			
		}	
		
		for(int i=0; i<rI.getAttributes().size();i++){
			rInfo.addAttribute(rI.getAttributes().get(i));
			
			//System.out.println("Attribut ajouté :"+rI.getAttributes().get(i));
			
		}
		
		for(int i=0; i<rI.getListinfo().size();i++){
			//System.out.println(name+"*********"+rI.getListinfo().get(i));
			rInfo.addTypeInfo(rI.getListinfo().get(i));
			///System.out.println(name+"*********"+rInfo.getListinfo().size());
			
			//System.out.println("Attribut ajouté :"+rI.getAttributes().get(i));
			
		}
		
		//Rajouts des  Attributs=Valeur
		
		int nbAtt=  rInfo.getAttributes().size(); 
		if (nbAtt>0){
			String argument=rInfo.getAttributes().get(nbAtt-1);
			 int nbVal= rI.getListValeurs().size();
			 if (nbVal>0){
				 String val=rI.getListValeurs().get(nbVal-1);
				 rInfo.addQualificatif(argument, val);
				 //System.out.println( rInfo.getCouple_rubrique().size());
				
				  System.out.println(argument+" = "+val);
				  
				//  sqlTrad.AddArgVal(argument, val);
				 
			 }
		}
		
		if (rI.getCouple_rubrique().size()>0){
			
			//System.out.print ("recuperation des valeurs");
			
			Set cles = rI.getCouple_rubrique().keySet();
		    Iterator it = cles.iterator();
		    while (it.hasNext()){
		     String cle = (String) it.next(); // tu peux typer plus finement ici
		     String valeur =rI.getCouple_rubrique().get(cle); // tu peux typer plus finement ici
		     sqlTrad.AddArgVal(cle, valeur); 
		     rInfo.addQualificatif(cle, valeur);
		    } 
		}

	}
	
	// construction du traducteur
	
	public void constructionTraduction(){
		// 
		sqlTrad.setSql_tables(rInfo.getRubrique());
		sqlTrad.setAttrubriques(rInfo.getAttributes());
		sqlTrad.setTypeInfo(rInfo.getListinfo());
		//System.out.println(name+"*********"+rInfo.getListinfo().size());
		
		//sqlTrad.setQualificatifs(rInfo.getCouple_rubrique());
		//System.out.println(sqlTrad.getQualificatifs().size());
		
		sqlTrad.printSqlRequest();
		
	}
	
	
	 public static void main(String args[]){
		 
		
	 }

	public void setI(int i) {
		this.i = i;
	}


	public RequestInfo getrInfo() {
		return rInfo;
	}

}
