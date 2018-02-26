package automaton;

import java.util.ArrayList;

	
 
public class Rule {
	
	private State state1;
	private State state2;
	
	private ArrayList<Tags> possibilities;
		
	public Rule (State e2){
		possibilities= new ArrayList<Tags>();
		state2=e2;
	}
	


	public State getState1() {
		return state1;
	}


	public void setState1(State state1) {
		this.state1 = state1;
	}


	public State getState2() {
		return state2;
	}


	public void setState2(State state2) {
		this.state2 = state2;
	}


	public ArrayList<Tags> getPossibilities() {
		return possibilities;
	}


	public void setPossibilities(ArrayList<Tags> possibilities) {
		this.possibilities = possibilities;
	}
	
	
	public void addTags(Tags t){
		
		possibilities.add(t);
		
	}
	
	
	public boolean verifETat(String mot){
		boolean ok=false;
		int i=0;
		while(i<possibilities.size() && ok==false){
			
			Tags t= possibilities.get(i);
			boolean test= t.contentElement(mot);
			if (test==true){
				ok= true;
			}
			i++;
		}
		
		return ok;
	}
	
	

}
