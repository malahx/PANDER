package fr.redpanda.pander.businesscode;

import java.util.ArrayList;
import java.util.List;

import fr.redpanda.pander.entities.Candidate;
import fr.redpanda.pander.entities.Company;
import fr.redpanda.pander.entities.Job;
import fr.redpanda.pander.entities.Skill;

public class Matching {

	private Candidate candidate;
	private Company company;
	private Job job;
	private int calculateRatio;
	

	private List<Skill> getTechSkills(List<Skill> skills) {
		return null;
	}
	
	private List<Skill> getSoftSkills(List<Skill> skills) {
		return null;
	}
	
	private List<Skill> getEqualSkills(List<Skill> candidateSkills, Skill jobSkills) {
		return null;
	}
	
	public int matchingCalc() 
		matchingResult = 
		return ;
	}

	// Variables pour fixer des boucles éventuelles.
	int ii = 0;
	int jj = 0;
	
	// Variable pour le résultat du matching.
	int matchingResult;

	// Recherche de la taille des listes afin de pouvoir calculer les ratios de calcul du matching.
	int SkillsNumber = Skill.size();
	int SkillsNumberCandidate = candidateSkills.size();
	int SkillsNumberJob = jobSkills.size();
	
	

}



//
//
////ALGOROTHME PANDER CONNECTION
////
////- L'algorithme doit prendre des données issues des compétences d'un candidat
////mais également les compétences demandées pour un poste proposé.
////- Il doit comparer les compétences identiques entre le candidat et le poste.
////- Il doit proposer un taux de matching correspondant au pourcentage des
////compétences nécessaires.
//
//
//ALGORITHME MATCHING_PANDER_CONNECTION
//
//CONSTANTE
//	
//	ENTIER : CS_T <- 10
//	ENTIER : JS_T <- 10
//
//VARIABLE
//
//	// PRISE DES TABLES DE DONNEES CORRESPONDANT AUX COMPETENCES DES CANDIDATS
//	// ET AUX POSTES PROPOSES
//
//	TABLEAU<CHAINE>[CS_T] : CandidateSkills
//	TABLEAU<CHAINE>[JS_T] : JobSkills
//
//
//	// COMPTEURS :
//
//	ENTIER : ii <- 0
//	ENTIER : jj <- 0
//
//
//	// MATCH POINT :
//
//	REEL : mp <- 0
//
//
//	// TABLEAU DES COMPETENCES COMMUNES :
//
//	TABLEAU<CHAINE>[1] : CommonSkills
//
//
//	// VARIABLE DE CALCUL :
//
//	ENTIER : n <- 0
//
//
//DEBUT
//
//	// 1. CALCUL DE CORRESPONDANCE ENTRE LES TABLEAUX :
//
//	POUR ii DE 0 A CS_T -1 PAS DE 1 FAIRE
//		POUR jj DE 0 A JS_T -1 PAS DE 1 FAIRE
//
//			SI CandidateSkills[ii] = JobSkills[jj] ALORS
//				n <- Len(CommonSkills)
//				CommonSkills[n-1] <- CandidateSkills[ii]
//				Redim(CommonSkills, n +1)
//
//			FINSI
//
//		FINPOUR
//	FINPOUR 
//
//
//	// 2. CALCUL DU RESULTAT DE MATCHING :
//
//	mp <- Len(CommonSkills) / Len(JobSkills)
//
//	Ecrire("Matching de : " & (mp*100) & " %")  
//
//FIN
