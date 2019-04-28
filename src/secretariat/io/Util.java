package secretariat.io;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import secretariat.Cours;
import secretariat.Etudiant;
import secretariat.Inscription;
import secretariat.TableauPrincipal;
import secretariat.exception.NotImplementedException;

/**
 * Pour les modules de lecture-écriture, c'est à vous de les créer. Il
 * <b>faut</b> les référencer ici pour qu'on puisse les tester à la correction.
 *
 */
public class Util {

	public static Reader<Collection<Etudiant>> getEtudiantReader() {
		throw new NotImplementedException();
	}

	public static Writer<Iterable<Etudiant>> getEtudiantWriter() {
		
		return null;
	
		
		
	}

	public static Reader<Collection<Cours>> getCoursReader() {
		throw new NotImplementedException();
	}

	public static Writer<Iterable<Cours>> getCoursWriter() {
		throw new NotImplementedException();
	}

	/**
	 * Pour la lecture des {@link Inscription Inscriptions}, il faut une visibilité
	 * vers les {@link Cours} et {@link Etudiant Étudiants} du
	 * {@link TableauPrincipal}.
	 * 
	 * @param tableau
	 * @return
	 */
	public Reader<Collection<Inscription>> getInscriptionReader(TableauPrincipal tableau) {
		throw new NotImplementedException();
	}

	public Writer<Iterable<Inscription>> getInscriptionWriter() {
		throw new NotImplementedException();
	}

}
