package automaton;

import java.util.ArrayList;

public class Motor {
	
	String[] seq;
	ArrayList<State> etats;
	State init_e;
	State final_e;
	State current_state;
	String chaine;
	
	public Motor(String s[],State e, State fe){
		
		seq=s;
		chaine="";
		init_e=e;
		final_e=fe;
		ArrayList<State> etats= new ArrayList<State>();
		etats.add(init_e);
		etats.add(final_e);
		current_state=init_e;
		
	}
	
	
	public void aaddState( State e){
		etats.add(e);
	}
	
	
	public void testSequence(int i){
		
		 if (i>=seq.length){
			 
			 System.out.println("texte reconnu="+chaine);
			 System.out.println("fin de lecture");
		 }
		 
		 else {
			 
			 String current_word=seq[i];
			 
			 if (current_state.verif_etat(current_word)==false){
				 
				 System.out.println("texte reconnu="+chaine);
			 }
			 
			 else{
				 
				 	if (current_state.verif_etat(current_word)){
						chaine=chaine+" "+current_word;
						current_state=current_state.getNextState();
						testSequence(i+1);
						
					}
			} 
			 
		 }
}
	
	
	
	
	 public static void main(String args[]){
		 
		 // test du moteur
		 
		 State e1= new State(1);
		 State e2 = new State(2);
		 State e3 = new State(3);
		 
		 // ajouts des Pronoms
		 Tags t1= new Tags("pronom");
		 t1.addWords("quel");
		 t1.addWords("qui");
		 t1.addWords("quand");
			
		 // ajouts des Pronoms
		 Tags verbe= new Tags("verbre");
		 verbe.addWords("est");
		 verbe.addWords("prepare");
		 verbe.addWords("habite");
		
		// ajouts des regles de transitions
		 	//Regle1
		 Rule r1= new Rule(e2);
		 r1.addTags(t1);
		 e1.addRule(r1);
		
		 	//Regle2
		 Rule r2= new Rule(e3);
		 r2.addTags(verbe);
		 e2.addRule(r2);
		
		 String query[]= {"qui","prepare"};
		
		 Motor m= new Motor(query,e1,e3);
			
		 m.testSequence(0);
	 
	 }

}
