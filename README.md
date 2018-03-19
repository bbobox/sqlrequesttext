# sqlrequesttext
Text syntactic and semantic analysis and translation to sql request.

Etudiants: BOKA Yao
	 IBRIR Yassine


Lancement du programme:
	
	java -jar sqlrequesttext.jar


Utilisation:

	Saisir la requette dans le zone de texte reservée et en fonction des mots possibles

	Nb: un mot utilisé comme valeur d'attribut/champ s'ecrit <mavariable>


======================================================================================

Mots et types representés dans le  dictionnaire/ Lexique

	Tables:
		etudiant/etudiants: representatant la première table et composé des attributs
			etudiant (ID unique)
			date-de-naissance
			diplome
			adresse (la ville)

		diplome : representant la deuxième table et composé des attributs
			diplome (ID unique)
			niveau
			responsable


	Determinants:
		le, la, des, de, la, un, l'

	Pronoms interrogatifs:
		quel, qui, quand

	Verbe:
		sont, est, habite ( de sujet:etudiant), prepare( de sujet: etudiant et objet:diplome)
		


		
			
	





