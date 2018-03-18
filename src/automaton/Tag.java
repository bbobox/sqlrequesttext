package automaton;

public interface Tag {
	
	public boolean contentElement(String word);

	public void addWords(String string);

	public String getTextAccepted();
	
	public  RequestInfo rI();

	public void addTable(String rubrique, String table);
	
	
	// concernant les verbes
	public void  addAttribut(String att);
	
	public void addSujet();
	
	public void addObject();
	
	public void addInfoVerbe(String verbe, InfoVerbe infv);
}
