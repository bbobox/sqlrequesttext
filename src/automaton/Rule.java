package automaton;

import java.util.ArrayList;

	
 
public class Rule {
	
	private State state1;
	private State state2;
	
	private ArrayList<Tag> possibilities;
	
	private ArrayList<Motor> sub_automatom;
	
    String text= "";
    
    RequestInfo rInfo;
		
	public Rule (State e2){
		possibilities= new ArrayList<Tag>();
		sub_automatom= new ArrayList<Motor>();
		state2=e2;
		
		rInfo= new RequestInfo();
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


	public ArrayList<Tag> getPossibilities() {
		return possibilities;
	}


	public void setPossibilities(ArrayList<Tag> possibilities) {
		this.possibilities = possibilities;
	}
	
	
	public void addTags(Tag t1){
		
		possibilities.add(t1);
		
	}
	
	
	public boolean verifETat(String mot){
		boolean ok=false;
		int i=0;
		while(i<possibilities.size() && ok==false){
			
			Tag t= possibilities.get(i);
			boolean test= t.contentElement(mot);
			if (test==true){
				ok= true;
				text=t.getTextAccepted();
				if (t.rI()!=null){
					rInfo=t.rI();
				}
			}
			i++;
		}
		
		return ok;
	}
	
	public String getTextAccepted(){
		return text;
	}
	
	public RequestInfo rI() {
		
		return rInfo;
	}
	
	

}
