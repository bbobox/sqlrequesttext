package automaton;

public class SubAutomatom implements Tag {
	private Motor m;
	int i;
	 Motor automate;
	 
	 String text="";
	
	public SubAutomatom(Motor m, Motor automate){
		this.m=m;
		this.i=i;
		this.automate=automate;
	}

	public boolean contentElement(String word) {
		
		// String query[]= word.split(" ");
		// this.automate.getI();
		// System.out.println("i actuel= "+ this.automate.getI());
		 m.testSequence(this.automate.getI());
		 
		 m.clearMotor();
		 this.automate.setI(m.getI());
		 if(m.lectureAcceptante()==true){
			text=m.getTextAccepted();
			//System.out.println("text="+text);
		 }
		 
		 return m.lectureAcceptante();
		 
	}

	public void addWords(String string) {
		
		
	}

	public String getTextAccepted() {
		// TODO Auto-generated method stub
		//System.out.println("text="+text);
		return text;
	}

	public RequestInfo rI() {
		// TODO Auto-generated method stub
		System.out.print (m.getrInfo().getCouple_rubrique().size());
		return m.getrInfo();
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
