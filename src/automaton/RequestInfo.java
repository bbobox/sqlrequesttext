package automaton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RequestInfo {
	
	ArrayList<String> rubrique=null;
	ArrayList<String> list_attributs=null;
	Map<String,String> couple_rubrique;
	
	ArrayList<String> listinfo;
	
	
	
	
	ArrayList<String> listValeurs=null;
	
	
	
	public RequestInfo(){
		couple_rubrique=new HashMap<String,String>();
		//rubrique=
		rubrique= new ArrayList<String>();
		list_attributs= new ArrayList<String>();
		listValeurs= new ArrayList<String>();
		listinfo= new ArrayList<String>();
	}
	
	
	public ArrayList<String> getListinfo() {
		return listinfo;
	}


	public void setListinfo(ArrayList<String> listinfo) {
		this.listinfo = listinfo;
	}


	public void addListAttr(String att){
		list_attributs.add(att);
	}
	
	
	public void addTableRubrique(String tr){
		rubrique.add(tr);
	}
	public ArrayList<String>  getTablesRubrique(){
		return rubrique;
	}
	
	public void addQualificatif(String val, String rubrique){
		couple_rubrique.put(val, rubrique);
		
	}
	
	public void  addAttribute(String att){
		list_attributs.add(att);
		
		
	}
	
	public ArrayList<String> getAttributes(){
		return list_attributs;
	}


	public ArrayList<String> getRubrique() {
		return rubrique;
	}


	public void setRubrique(ArrayList<String> rubrique) {
		this.rubrique = rubrique;
	}


	public Map<String, String> getCouple_rubrique() {
		return couple_rubrique;
	}


	public void setCouple_rubrique(Map<String, String> couple_rubrique) {
		this.couple_rubrique = couple_rubrique;
	}
	
	/*
	 * Creation du couple attribut Valeur
	 */
	public void addValRubrique(String  val){
		
		/*int n= list_attributs.size();
		if (n>0){
			String att=list_attributs.get(n-1);
			couple_rubrique.put(att, val);
		}*/
		listValeurs.add(val);
		
	}


	public ArrayList<String> getListValeurs() {
		return listValeurs;
	}


	public void setListValeurs(ArrayList<String> listValeurs) {
		this.listValeurs = listValeurs;
	}
	
	public void addTypeInfo(String word){
		this.listinfo.add(word);
	}
	
	
	
	

}
