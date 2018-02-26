package automaton;

import java.util.ArrayList;

/**
 * 
 * @author etudiant
 *
 */
public class State {
	
	
	private int id_etat;
	private ArrayList <Rule> rules;
	
	private State nextState=null;
	
	
	public State(int id){
		id_etat= id;
		rules =  new ArrayList <Rule>();
	}
	
	public boolean verif_etat( String mot){
		boolean ok=false;
		int i=0;
		while (i<rules.size() && ok==false){			
			if(rules.get(i).verifETat(mot)==true){
				ok=true;
				nextState=rules.get(i).getState2();
			}
			else{
				
			}
			i++;
		}

		return ok;
	}

	public int getId_etat() {
		return id_etat;
	}

	public void setId_etat(int id_etat) {
		this.id_etat = id_etat;
	}

	public ArrayList<Rule> getRules() {
		return rules;
	}

	public void setRules(ArrayList<Rule> rules) {
		this.rules = rules;
	}

	public State getNextState() {
		return nextState;
	}

	public void setNextState(State nextState) {
		this.nextState = nextState;
	}
	
	public void addRule(Rule r){
		rules.add(r);
	}
	
	public void printState(){
		
		System.out.println("etat ="+id_etat);
	}


}
