package secretariat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import secretariat.exception.BadInstanciationException;
import secretariat.exception.NotImplementedException;

public class Cours {

	private String sigle, nom;

	private int maxEtudiants;
	private transient int nbEtudiant;
	private List<Cours> prerequis = new ArrayList<>();

	/**
	 * TODO On doit pouvoir obtenir un {@link Iterator} qui nous permet de parcourir
	 * la liste des inscriptions du cours.
	 */
	private transient Iterable<Inscription> inscriptions;
	private ListInscriptionEtudMemeCours listInscript;

	
	public Cours(String sigle, String nom, int maxEtudiants, List<Cours> prerequis) 
	{
		this.sigle = sigle;
		this.nom = nom;
		this.maxEtudiants = maxEtudiants;
		this.prerequis = prerequis;
		listInscript = new ListInscriptionEtudMemeCours(null);

		valideEtat();
	}
	
	public ListInscriptionEtudMemeCours getListInscript() {
		return listInscript;
	}

	public void addToList(Inscription inscript) {
		
		listInscript.add(inscript);
		
	}
	
	public void deleteFromList(Etudiant etud){
		listInscript.deleteIt(etud);
	}

	/**
	 * Valide la consistance des entrées. Le cas échéant, lance une
	 * {@link BadInstanciationException}.
	 */
	private void valideEtat() {
		if (sigle == null)
			throw new BadInstanciationException("Sigle nulle");
		if (nom == null)
			throw new BadInstanciationException("Nom nulle");

	}

	public String getSigle() {
		return sigle;
	}

	public String getNom() {
		return nom;
	}

	public int getMaxEtudiants() {
		return maxEtudiants;
	}

	public int getNbEtudiant() {
		return nbEtudiant;
	}

	public List<Cours> getPrerequis() {
		return prerequis;
	}

	/**
	 * TODO Doit retourner un <b>nouvel</b> {@link Iterator} d'inscription
	 * permettant de parcourir la list des inscriptions.
	 * 
	 * <p>
	 * 
	 * <i>Indice</i> : Vous pouvez déléguer cette responsabilité à
	 * {@link Iterable#iterator()}.
	 * 
	 * @return
	 */
	public Iterator<Inscription> getIterateurInscription() {
		return inscriptions.iterator();
	}

	public void setPrerequis(List<Cours> prerequis) {
		this.prerequis = prerequis;
	}

	public void showEtudiants() {
		listInscript.showEtudiant();
		
	}


}
