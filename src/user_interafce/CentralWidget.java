package user_interafce;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import automaton.Determinant;
import automaton.InfoVerbe;
import automaton.Mot;
import automaton.Motor;
import automaton.Nom_Rubrique;
import automaton.PronInterro;
import automaton.RubriqueVal;
import automaton.Rule;
import automaton.State;
import automaton.SubAutomatom;
import automaton.Table_Rubrique;
import automaton.Tag;
import automaton.Verbe;

public class CentralWidget extends JPanel  {
	
	
	private JPanel grandPanel;
	private JPanel zoneGauche;
	private JPanel zoneDroit;
	
	private JPanel zoneDroitHaut;
	private JPanel zoneDroitBas;
	
	private  JTextArea zonesaisie;
	
	private JEditorPane affichageDroitHaut;
	private JEditorPane affichageDroitBas;
	
	private JButton btnGo;

	
	public CentralWidget(){
		
		 btnGo= new JButton("Afficher Requette");
		 grandPanel= new JPanel(new GridLayout(1, 2));
		
		grandPanel.setBackground(new Color(2));
		
		zoneGauche= new JPanel();
		
		affichageDroitHaut= new JEditorPane();
		affichageDroitHaut.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(affichageDroitHaut);
		
		affichageDroitBas= new JEditorPane();
		affichageDroitBas.setEditable(false);
		
		JScrollPane scrollPane2 = new JScrollPane(affichageDroitBas);
		
		zonesaisie= new JTextArea();
		zonesaisie.setLineWrap(true);
		Dimension dim=new Dimension();
		dim.setSize(300, 30);
		//zonesaisie.setBackground(Color.BLACK);
		zonesaisie.setEditable(true);
		zonesaisie.setPreferredSize(dim);
		//zonesaisie.setHorizontalAlignment(JTextField.CENTER);
		
		zoneDroit= new JPanel(new GridLayout(2,1));
		//zoneGauche.setBackground(Color.blue);
		zoneDroitHaut= new JPanel(new GridLayout(1, 1));
		
		//affichageDroitHaut.setSize(zoneDroitHaut.getMaximumSize());
		
		zoneDroitHaut.add(scrollPane);
		
		
		
		zoneDroitBas= new JPanel(new GridLayout(1, 1));
		
		zoneDroitBas.add(scrollPane2);
		
		//zoneDroitBas.add(affichageDroitBas);
		
		zoneGauche.add(zonesaisie);
		zoneGauche.add(btnGo);
		
		btnGo.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				String text= zonesaisie.getText();
				
				//System.out.print(text);
				
				String res=traitement(text);
				affichageDroitHaut.setText(res);
			}
		});
		
		zoneDroit.add(zoneDroitHaut);
		zoneDroit.add(zoneDroitBas);
		
		grandPanel.add(zoneGauche);
		grandPanel.add(zoneDroit);
		
		
		
		setLayout(new BorderLayout());
		add(grandPanel);
		
	}
	
	
	public String  traitement( String  text){
   	 State e1= new State(1);
		 State e2 = new State(2);
		 State e3 = new State(3);
		 State e4 = new State(4);
		 State e5 = new State(5);
		 e1.setEpsiloTransition(e3);
		
		
		 // ajouts des Pronoms
		 Tag pronoms_interr= new PronInterro();
		 pronoms_interr.addWords("quel");
		 pronoms_interr.addWords("qui");
		 pronoms_interr.addWords("quand");
			
		 // ajouts des Pronoms
		 Tag verbe= new Verbe();
		 verbe.addWords("est");
		 verbe.addWords("prepare");
		 
		 // Information sur le verbe Preparer
		 InfoVerbe infoPrepare= new InfoVerbe();
		 infoPrepare.setAttribut("diplome");
		 infoPrepare.setSujet("etudiant");
		 infoPrepare.setObjet("diplome");
		 
		 
		 
		 
		 verbe.addWords("habite");
		 InfoVerbe info= new InfoVerbe();
		 info.setAttribut("adresse");
		 info.setSujet("etudiant");
		 verbe.addInfoVerbe("habite", info);
		 
		 verbe.addInfoVerbe("prepare",  infoPrepare);
		 
		 
		 verbe.addWords("sont");
		
		 
		 // ajout  des determinanats
		 Tag det= new Determinant();
		 
		 det.addWords("les");
		 det.addWords("le");
		 det.addWords("des");
		 det.addWords("de");
		 det.addWords("la");
		 det.addWords("un");
		 det.addWords("l'");
		 
		 // Dictionnaire ensemble d'Attributs de Tables
		 
		 Tag table_rubrique= new Table_Rubrique();
		 
		 table_rubrique.addWords("etudiant");
		 table_rubrique.addWords("etudiants");
		 table_rubrique.addWords("diplome");
		 
		 // Dictionnaire ensemble d'Attributs de Table
		 
		 Tag att_rubrique= new Nom_Rubrique();
		
		 att_rubrique.addWords("nom");
		 att_rubrique.addTable("nom", "etudiant");
		 
		 att_rubrique.addWords("prenom");
		 att_rubrique.addTable("prenom", "etudiant");
		
		 att_rubrique.addWords("ville");
		 
		 att_rubrique.addWords("adresse");
		 att_rubrique.addTable("adresse", "etudiant");
		 
		 att_rubrique.addWords("date-de-naissance");
		 att_rubrique.addTable("date-de-naissance", "etudiant");
		 
		 att_rubrique.addWords("diplome");
		 att_rubrique.addTable("diplome", "etudiant");
		 
		 att_rubrique.addWords("responsable");
		 att_rubrique.addTable("responsable", "diplome");
		 
		 att_rubrique.addWords("niveau");
		 att_rubrique.addTable("niveau", "diplome");
		 
		 
		 Rule r4_5=new Rule(e5);
		 r4_5.addTags(att_rubrique);
		 e4.addRule(r4_5);
		
		
		// ajouts des regles de transitions
		 	//Regle1
		 Rule r1= new Rule(e2);
		 r1.addTags(pronoms_interr);
		 e1.addRule(r1);
		
		 	//Regle2
		 Rule r2= new Rule(e3);
		 r2.addTags(verbe);
		 e2.addRule(r2);
		 
		 	//Regles3
		 Rule r3= new Rule(e3);
		 r3.addTags(det);
		 e3.addRule(r3);
		 
		 	// Regle4
		 Rule r4= new Rule(e5);
		 r4.addTags(table_rubrique);
		 r4.addTags(att_rubrique);
		 e3.addRule(r4);
		 

		
		// System.out.println("Saisissez le texte la question de requette");
		// Scanner in = new Scanner(System.in); 
		 
		//String query=in.nextLine(); //"responsable du diplome m2info";
		 String query2="quel est le etudiant";
		
		 Motor m= new Motor( text,e1,e5,"princiaple");
		 
		 // SOus Autmate
		 
		 State e6= new State(6);
		 State e7= new State(7);
		 State e8= new State(8);
		 State e9= new State(9);
		 State e10= new State(10);
		 
		
			
		 // ajout tage essai
		 
		 Tag essai= new Mot("qui");
		 Rule r6_7= new Rule(e7);
		 r6_7.addTags(essai);
		 e6.addRule(r6_7);
		 
		 Tag de= new Mot("de");
		 Tag du= new Mot("du");
		 Tag des= new Mot("des");
		 
		 Rule r6_8= new Rule(e8);
		 r6_8.addTags(de);
		 r6_8.addTags(du);
		 r6_8.addTags(des);
		 e6.addRule(r6_8);
		 
		 Rule r7_8= new Rule(e8);
		 r7_8.addTags(verbe);
		 e7.addRule(r7_8);
		 
		 
		 
		 Tag Val= new  RubriqueVal();
		 
		 Rule r8_8= new Rule(e8);
		 r8_8.addTags(det);
		 e8.addRule(r8_8);
		 
		 e9.setEpsiloTransition(e6);
		 
		 
		 Rule r8_9= new Rule(e9);
		 r8_9.addTags(att_rubrique);
		 r8_9.addTags(table_rubrique);
		 e8.addRule(r8_9);
		 
		 Rule r8_10= new Rule(e10);
		 r8_10.addTags(Val);
		 e8.addRule(r8_10);
		 
		 Rule r9_10= new Rule(e10);
		 r9_10.addTags(Val);
		 e9.addRule(r9_10);
		 
		 Motor m2= new Motor( text,e6,e10,"sous_automate");
		 Tag sous_auto= new SubAutomatom(m2, m);
		 
		 	//Regles automate
		 Rule ro= new Rule(e5);
		 ro.addTags(sous_auto);
		 e5.addRule(ro);
		 
		 
		 // Epsilo transition de l'etat 9
		
		
		 m.testSequence(0);
		 System.out.println();
		 System.out.println("====================");
		 System.out.println();
		return  m.constructionTraduction();
   	
   }

}
