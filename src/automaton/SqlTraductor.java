package automaton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class SqlTraductor {
	
	ArrayList<Tags> rubriques;
	
	ArrayList<String> attrubriques;
	
	ArrayList<String> sql_tables;
	Map<String,String> qualificatifs;
	
	
	ArrayList<String> typeInfo;
	
	
	String sqlrequest="";
	
	private String textArgVal= new String();;
	
	

	
	public SqlTraductor(){
		rubriques= new ArrayList<Tags>();
		this.qualificatifs = new HashMap();
		sql_tables  = new ArrayList<String>();
		attrubriques = new  ArrayList<String>();
		typeInfo= new ArrayList<String>();
	}
	
	
	public ArrayList<String> getTypeInfo() {
		return typeInfo;
	}


	public void setTypeInfo(ArrayList<String> typeInfo) {
		this.typeInfo = typeInfo;
	}


	public ArrayList<String> getSql_tables() {
		return sql_tables;
	}


	public void setSql_tables(ArrayList<String> sql_tables) {
		this.sql_tables = sql_tables;
	}


	public ArrayList<String> getAttrubriques() {
		return attrubriques;
	}


	public void setAttrubriques(ArrayList<String> attrubriques) {
		this.attrubriques = attrubriques;
	}

	/*
	public void addAttRubrique(String r){
		attrubriques.add(r);
	}
	
	public void addQualif(String q){
		qualificatifs.add(q);
	}
	*/
	
	public void  printSqlRequest(){
		 sqlrequest=sqlrequest+ "SELECT ";
		 
		 // Ajout des rubriques
		 if (typeInfo.size()>0){
			 for(int i=0;i<typeInfo.size();i++){ 
				 sqlrequest+=typeInfo.get(i);
			 }
		 }
		 else{
			 sqlrequest+="*";
		 }
		 
		  sqlrequest+=" FROM ";
		  
		// Ajout des Table
		  
		  int numtabl=0;
		  for(int i=0;i<sql_tables.size();i++){ 
			  if (numtabl<sql_tables.size()-1 && numtabl>0 ){
				  sqlrequest+=",";
			  }
				 sqlrequest+=sql_tables.get(i);
				 numtabl++;
			 } 
		  
		  if (qualificatifs.size()>0){
		  
			  sqlrequest+=" WHERE ";
			 // AJout des Qualificatifs
			  
			  /*for(int i=0;i<qualificatifs.size();i++){ 
					 sqlrequest+=qualificatifs.get(i);
				 } */
			  
		      
	
		       Iterator iterator = qualificatifs.entrySet().iterator();
		       int id=0;
		     //   System.out.print("Taille ===="+qualificatifs.size());
		        while (iterator.hasNext()) {
		        	if(id!=0){
		        		 sqlrequest+=" AND ";
		        	}
		        		
				          Map.Entry mapentry = (Map.Entry) iterator.next();
				          System.out.println("clé: "+mapentry.getKey()
				                            + " | valeur: " + mapentry.getValue());
				          sqlrequest+=mapentry.getKey()+"="+mapentry.getValue();
		        	id++;
		        } 
		      //  sqlrequest+=mapentry.getKey()+"="+Val;
			 
		  }
		 
		  System.out.println(sqlrequest);
		
	}
	
	
	
	 public Map<String, String> getQualificatifs() {
		return this.qualificatifs;
	}


	
	
	public void AddArgVal(String arg, String Val) {
		
		this.qualificatifs.put(arg, Val);

	}


	public String getSqlrequest() {
		return sqlrequest;
	}

	
	

}
