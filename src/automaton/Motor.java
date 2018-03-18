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
		 
		 // test du moteur
		 
		 State e1= new State(1);
		 State e2 = new State(2);
		 State e3 = new State(3);
		 State e4 = new State(4);
		 State e5 = new State(5);
		 e1.setEpsiloTransition(e3);
		
		 // ajouts des Pronoms
		 Tag pronoms_interr= new PronInterro();
		 pronoms_interr.addWords("quel");
		 pronoms_interr.addWords("qui");
		 pronoms_interr.addWords("quand");
			
		 // ajouts des Pronoms
		 Tag verbe= new Verbe();
		 verbe.addWords("est");
		 verbe.addWords("prepare");
		 
		 // Information sur le verbe Preparer
		 InfoVerbe infoPrepare= new InfoVerbe();
		 infoPrepare.setAttribut("diplome");
		 infoPrepare.setSujet("etudiant");
		 infoPrepare.setObjet("diplome");
		 
		 
		 
		 
		 verbe.addWords("habite");
		 InfoVerbe info= new InfoVerbe();
		 info.setAttribut("adresse");
		 info.setSujet("etudiant");
		 verbe.addInfoVerbe("habite", info);
		 
		 verbe.addInfoVerbe("prepare",  infoPrepare);
		 
		 
		 verbe.addWords("sont");
		
		 
		 // ajout  des determinanats
		 Tag det= new Determinant();
		 
		 det.addWords("les");
		 det.addWords("le");
		 det.addWords("des");
		 det.addWords("de");
		 det.addWords("la");
		 det.addWords("un");
		 
		 // ajout du "Tag" table
		 
		 Tag table_rubrique= new Table_Rubrique();
		 
		 table_rubrique.addWords("etudiant");
		 table_rubrique.addWords("etudiants");
		 table_rubrique.addWords("diplome");
		 
		 // Dictionnaire ensemble d'Attributs
		 
		 Tag att_rubrique= new Nom_Rubrique();
		
		 att_rubrique.addWords("nom");
		 att_rubrique.addTable("nom", "etudiant");
		 
		 att_rubrique.addWords("prenom");
		 att_rubrique.addTable("prenom", "etudiant");
		
		 att_rubrique.addWords("ville");
		 att_rubrique.addWords("adresse");
		 att_rubrique.addTable("adresse", "etudiant");
		 
		 att_rubrique.addWords("date-de-naissance");
		 att_rubrique.addTable("date-de-naissance", "etudiant");
		 
		 att_rubrique.addWords("diplome");
		 att_rubrique.addTable("diplome", "etudiant");
		 
		 att_rubrique.addWords("responsable");
		 att_rubrique.addTable("responsable", "diplome");
		 
		 att_rubrique.addWords("niveau");
		 att_rubrique.addTable("niveau", "diplome");
		 
		 
		 Rule r4_5=new Rule(e5);
		 r4_5.addTags(att_rubrique);
		 e4.addRule(r4_5);
		
		
		// ajouts des regles de transitions
		 	//Regle1
		 Rule r1= new Rule(e2);
		 r1.addTags(pronoms_interr);
		 e1.addRule(r1);
		
		 	//Regle2
		 Rule r2= new Rule(e3);
		 r2.addTags(verbe);
		 e2.addRule(r2);
		 
		 	//Regles3
		 Rule r3= new Rule(e3);
		 r3.addTags(det);
		 e3.addRule(r3);
		 
		 	// Regle4
		 Rule r4= new Rule(e5);
		 r4.addTags(table_rubrique);
		 r4.addTags(att_rubrique);
		 e3.addRule(r4);
		 

		
		 System.out.println("Saisissez le texte la question de requette");
		 Scanner in = new Scanner(System.in); 
		// str = in.readLine();
		 
		String query=in.nextLine(); //"responsable du diplome m2info";
		 String query2="quel est le etudiant";
		
		 Motor m= new Motor( query,e1,e5,"princiaple");
		 
		 // SOus Autmate
		 
		 State e6= new State(6);
		 State e7= new State(7);
		 State e8= new State(8);
		 State e9= new State(9);
		 State e10= new State(10);
		 
		
			
		 // ajout tage essai
		 
		 Tag essai= new Mot("qui");
		 Rule r6_7= new Rule(e7);
		 r6_7.addTags(essai);
		 e6.addRule(r6_7);
		 
		 Tag de= new Mot("de");
		 Tag du= new Mot("du");
		 Tag des= new Mot("des");
		 
		 Rule r6_8= new Rule(e8);
		 r6_8.addTags(de);
		 r6_8.addTags(du);
		 r6_8.addTags(des);
		 e6.addRule(r6_8);
		 
		 Rule r7_8= new Rule(e8);
		 r7_8.addTags(verbe);
		 e7.addRule(r7_8);
		 
		 
		 
		 Tag Val= new  RubriqueVal();
		 
		 Rule r8_8= new Rule(e8);
		 r8_8.addTags(det);
		 e8.addRule(r8_8);
		 
		 
		 
		 
		 Rule r8_9= new Rule(e9);
		 r8_9.addTags(att_rubrique);
		 e8.addRule(r8_9);
		 
		 Rule r8_10= new Rule(e10);
		 r8_10.addTags(Val);
		 e8.addRule(r8_10);
		 
		 Rule r9_10= new Rule(e10);
		 r9_10.addTags(Val);
		 e9.addRule(r9_10);
		 
		 Motor m2= new Motor( query,e6,e10,"sous_automate");
		 Tag sous_auto= new SubAutomatom(m2, m);
		 
		 	//Regles automate
		 Rule ro= new Rule(e5);
		 ro.addTags(sous_auto);
		 e5.addRule(ro);
		 
		 
		 // Epsilo transition de l'etat 9
		
		
		 m.testSequence(0);
		 System.out.println();
		 System.out.println("====================");
		 System.out.println();
		 m.constructionTraduction();
		// System.out.println(m.getI());
	 
	 }

	public void setI(int i) {
		this.i = i;
	}


	public RequestInfo getrInfo() {
		return rInfo;
	}

}
