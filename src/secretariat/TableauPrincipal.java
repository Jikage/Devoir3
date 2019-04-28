package secretariat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import secretariat.exception.NotImplementedException;

/**
 * Le tableau principal contient la liste des cours et la liste des étudiants.
 * Comme elle a une visibilité vers les deux listes, c'est cette classe qui aura
 * la responsabilité de gérer l'ajout/retrait d'une inscription.
 *
 */
public class TableauPrincipal {

	private List<Cours> listeCours = new ArrayList<Cours>();
	private List<Etudiant> listeEtudiants= new ArrayList<Etudiant>();
	
	public TableauPrincipal() {
		
		listeCours.add(new Cours("PTT01","Culture de patates", 13, listeCours));
		listeEtudiants.add(new Etudiant("LordPatate","Tate","Pa",495,0));
	}

	public void ajouterEtudiant(Etudiant etud) {
		listeEtudiants.add(etud);		
	}

	public void ajouterCours(Cours cours) {
		listeCours.add(cours);
	}

	/**
	 * Réalise l'inscription d'un étudiant à un cours. L'étudiant et le cours
	 * <b>DOIVENT</b> être présents dans les listes pour pouvoir faire
	 * l'inscription.
	 * 
	 * <p>
	 * 
	 * <i>Conseil</i>: Que se passe-t-il si un objet reçu en argument est une copie
	 * d'un objet contenu dans une liste (même contenu, instances différentes) ?
	 * Gérez cette éventualité.
	 * 
	 * @param cours L'instance du cours
	 * @param etud  L'instance de l'étudiant
	 * @return si l'inscription a pu être réalisée.
	 */
	public boolean inscrire(Cours cours, Etudiant etud) {
		if(coursExiste(cours)&&etudExiste(etud)) {
			cours.addToList(new Inscription(cours, etud));
			etud.addToList(new Inscription(cours, etud));
			return true;
		}
		else
			return false;
	}
	public boolean coursExiste(Cours cours) {
		for(Cours c: listeCours) {
			 if(c == cours)
				 return true;
		}
		return false;
	}
	public boolean coursExiste(String sigle) {
		for(Cours c: listeCours) {
			 if(c.getSigle().equals(sigle))
				 return true;
		}
		return false;
	}
	public boolean etudExiste(Etudiant etud) {
		for(Etudiant e: listeEtudiants) {
			 if(e == etud)
				 return true;
		}
		return false;
	}
	public boolean etudExiste(String codePermanent) {
			for(Etudiant e: listeEtudiants) {
				 if(e.getCodePermanent().equals(codePermanent))
					 return true;
			}
			return false;
	}
	/**
	 * Réalise l'inscription d'un étudiant à un cours. L'étudiant et le cours
	 * <b>DOIVENT</b> être présents dans les listes pour pouvoir faire
	 * l'inscription.
	 * 
	 * <p>
	 * 
	 * <i>Indice</i>: une fois les objets trouvés dans les listes, vous pouvez
	 * déléguer à l'autre méthode.
	 * 
	 * @param sigle Le sigle du cours
	 * @param codePermanent Le code permanent de l'étudiant
	 * @return si l'inscription a pu être réalisée.
	 */
	public boolean inscrire(String sigle, String codePermanent) {
		
		if(coursExiste(sigle)&&etudExiste(codePermanent)) {
			if(findCours(sigle).getListInscript().isInscritTo(codePermanent)) {
				inscrire(findCours(sigle), findEtud(codePermanent));
				return true;
				}
			return false;
		}
		else
			return false;
	}

	private Etudiant findEtud(String codePermanent) {
		
		for(Etudiant e: listeEtudiants) {
			 if(e.getCodePermanent().equals(codePermanent))
				 return e;
		}
			
		return null;
	}

	private Cours findCours(String sigle) {
		
		for(Cours c: listeCours) {
			 if(c.getSigle().equals(sigle))
				 return c;
		}
			
		return null;
	}

	/**
	 * Réalise la désinscription d'un étudiant à un cours.
	 * 
	 * 
	 * <p>
	 * 
	 * <i>Conseil</i>: Que se passe-t-il si un objet reçu en argument est une copie
	 * d'un objet contenu dans une liste (même contenu, instances différentes) ?
	 * Gérez cette éventualité.
	 * 
	 * @param cours L'instance du cours
	 * @param etud  L'instance de l'étudiant
	 * @return si l'inscription a pu être réalisée.
	 */
	public boolean desinscrire(Cours cours, Etudiant etud) {
		if(coursExiste(cours)&&etudExiste(etud)) {
			cours.deleteFromList(etud);
			etud.deleteFromList(cours);
			return true;
		}
		else
			return false;
	}

	/**
	 * Réalise la désinscription d'un étudiant à un cours.
	 * 
	 * 
	 * @param cours L'instance du cours
	 * @param etud  L'instance de l'étudiant
	 * @return si l'inscription a pu être réalisée.
	 */
	public boolean desinscrire(String sigle, String codePermanent) {
		if(coursExiste(sigle)&&etudExiste(codePermanent)) {
			if(findCours(sigle).getListInscript().isInscritTo(codePermanent));
			desinscrire(findCours(sigle), findEtud(codePermanent));
			return true;
		}
		else
			return false;
	}

	public String showCours() {
		
		Iterator<Cours> iterator = listeCours.iterator();
		String show = "\n\nSigle: ";
		
		while(iterator.hasNext()) {
			
		show +=	iterator.next().getSigle() + "\n";
			
		}
		
		show += "\n\n";
		
		return show;
		
	}
	
	public String showCodeP() {
		
		Iterator<Etudiant> iterator = listeEtudiants.iterator();
		String show = "\n\nSigle: ";
		
		while(iterator.hasNext()) {
			
		show +=	iterator.next().getCodePermanent() + "\n";
			
		}
		
		show += "\n\n";
		
		return show;
		
	}
	public Iterable<Cours> getCours() {
		return listeCours;
	}

	public Iterable<Etudiant> getEtudiants() {
		return listeEtudiants;
	}

	public String showCoursOf(String codeToVef) {
		String lesCours;
		
		Iterator<Etudiant> iterator = listeEtudiants.iterator();
		while(iterator.hasNext()) {
			Etudiant etudiant = iterator.next();
			if(etudiant.getCodePermanent().equals(codeToVef)) {
				return etudiant.showCours();
				
			}
			
		}
		return "Aucun etudiant trouvé";
	}

	public boolean showEtudiantOf(String sigleToVef) {
		Iterator<Cours> iterator = listeCours.iterator();
		while(iterator.hasNext()) {
			Cours cours = iterator.next();
			if(cours.getSigle().equals(sigleToVef)) {
				cours.showEtudiants();
				return true;
			}
			
		}
		return false;
	}

	public boolean modif(String oldSigle, String oldCodeP,String newSigle, String newCodeP) {
		
		return false;
	}
}
