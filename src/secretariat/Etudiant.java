package secretariat;

import java.util.Iterator;

import secretariat.exception.BadInstanciationException;
import secretariat.exception.NotImplementedException;

public class Etudiant {

	private String codePermanent, nom, prenom;
	private int noProgramme, credits;
	private double moyenneCumul;

	private transient int nombreCours;

	// Représente la liste des inscriptions
	/**
	 * On doit pouvoir obtenir un {@link Iterator} qui nous permet de parcourir la
	 * liste des inscriptions de l'étudiant.
	 */
	private ListInscriptionCoursMemeEtudiant listInscript;


	public Etudiant(String codePermanent, String nom, String prenom, int noProgramme, int credits) {
		super();
		this.codePermanent = codePermanent;
		this.nom = nom;
		this.prenom = prenom;
		this.noProgramme = noProgramme;
		this.credits = credits;
		this.moyenneCumul = 0;
		listInscript = new ListInscriptionCoursMemeEtudiant(null);
		
		valideEtat();
	}

	/**
	 * Valide la consistance des entrées. Le cas échéant, lance une
	 * {@link BadInstanciationException}.
	 * 
	 * <p>
	 * 
	 * TODO - À vous de l'implémenter ( <i>indice</i>: vous pouvez vous inspirer de
	 * celle présente dans {@link Cours})
	 */
	private void valideEtat() {
		if(codePermanent == null)
			throw new BadInstanciationException("Code permanent nul");
		if(nom == null)
			throw new BadInstanciationException("Nom nul");
		if(prenom == null)
			throw new BadInstanciationException("Prenom nul");
		if(noProgramme < 0)
			throw new BadInstanciationException("Numero de programme impossible");
	}	
	
	public void addToList(Inscription inscript) {
		
		listInscript.add(inscript);
		
	}

	public void deleteFromList(Cours cours){
		listInscript.deleteIt(cours);
	}
	public double getMoyenneCumul() {
		return moyenneCumul;
	}

	public String getCodePermanent() {
		return codePermanent;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getNoProgramme() {
		return noProgramme;
	}

	public int getCredits() {
		return credits;
	}

	public int getNombreCours() {
		return nombreCours;
	}

	/**
	 * TODO Doit retourner un <b>nouvel</b> {@link Iterator} d'inscription
	 * permettant de parcourir la list des inscriptions.
	 * 
	 * @return
	 */
	public Iterator<Inscription> getIterateurInscription() {
		return listInscript.iterator();
	}

	public void setMoyenneCumul(double moyenneCumul) {
		this.moyenneCumul = moyenneCumul;
	}

	public void setNoProgramme(int noProgramme) {
		this.noProgramme = noProgramme;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String showCours() {
		return listInscript.showCours();
		
	}

}
