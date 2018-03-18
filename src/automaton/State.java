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
	
   private String text="";
   
   RequestInfo rInfo;
   
   boolean hasTransition=false; 
   
   State epsiloTransition=null;
	
	
	public boolean isTransition() {
	return  hasTransition;
}

public void setTransition(boolean transition) {
	this.hasTransition = transition;
	
}

public State getEpsiloTransition() {
	return epsiloTransition;
}

public void setEpsiloTransition(State epsiloTransition) {
	this.epsiloTransition = epsiloTransition;
	hasTransition=true;
}

	public State(int id){
		id_etat= id;
		rules =  new ArrayList <Rule>();
		
		rInfo= new RequestInfo();
	}
	
	public boolean verif_etat( String mot){
		boolean ok=false;
		int i=0;
		while (i<rules.size() && ok==false){			
			if(rules.get(i).verifETat(mot)==true){
				ok=true;
				nextState=rules.get(i).getState2();
				text=rules.get(i).getTextAccepted();
				rInfo=rules.get(i).rInfo;
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
	
	public boolean equals(State s){
		return (s.getId_etat()==this.getId_etat());
		
	}
	
	public String getTextAccepted() {
		// TODO Auto-generated method stub
		return text;
	}
	
	
	public RequestInfo rI() {
		
		return rInfo;
	}


}
