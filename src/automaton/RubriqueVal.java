package automaton;

public class RubriqueVal implements Tag {
	
	 RequestInfo rI= new RequestInfo();
	 
	 String text=null;
	 
	public RubriqueVal(){
		
		
	}

	// tout les mot sont accepetés comme valeur de rubrique
	public boolean contentElement(String word) {
		
		
		if (word.startsWith("<")){
			
			System.out.println("VALEUR="+word);
			text=word;
			rI.addValRubrique(word);
			return true;
		}
		
		else{
			return false;
		}
	}

	public void addWords(String string) {
		// TODO Auto-generated method stub
		
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
