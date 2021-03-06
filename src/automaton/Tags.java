package automaton;

import java.util.ArrayList;

public class Tags {
	
	private ArrayList<String> words;	
	private String name;
	
	private  boolean is_sql_table;
	private String  table_name="";
	
	private boolean is_rubrique;
	private String rubrique_name="";
	
	
	public Tags(String nom){
		name=nom;
		words= new ArrayList<String>();
		is_sql_table=false;
				
	}
	
	/**
	 * @param nom : nom du tags
	 * @param tablename : nom de la table correspondante
	 */
	
	public Tags(String nom, String tablename){
		this.table_name=tablename;
		is_sql_table=true;
	}
	
	public void addWords(String word){
		 words.add(word);	
	}
	
	
	public ArrayList<String> getWords(){
		
		return words;
	}
	
	public String getName(){
		return name;
		
	}
	
	public void printSet(){
		System.out.println("tag="+name +"\n");
		for(int i=0;i<words.size();i++){
			
			System.out.println("\t"+words.get(i));
		}
		
		
	}
	
	public boolean contentElement(String word){
		
		boolean ok= false;
		int i=0;
		while(ok==false && i<words.size()){
			if(words.get(i).equalsIgnoreCase(word))
				ok= true;
			i++;
		}
		
		
		return ok;
	}
	
	
	public String getTableName(){
		
		return table_name;
	}
	
	
	public boolean isSqlTable(){
		
		return is_sql_table;
	}
	/*

	 public static void main(String args[]){
		
		Tags test= new Tags("pronom");
		
		test.addWords("quel");
		test.addWords("qui");
		test.addWords("quand");
		
		test.printSet();
		
		
		// Ajouts des verbe
		Tags verbe= new Tags("verbre");
		
		verbe.addWords("est");
		verbe.addWords("prepare");
		verbe.addWords("habite");
		
		verbe.printSet();
		
	}*/
	 
	 
	
	
}
