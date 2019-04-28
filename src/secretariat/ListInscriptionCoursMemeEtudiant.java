package secretariat;

public class ListInscriptionCoursMemeEtudiant implements Iterable<Inscription>{

	private IteratorClasses itClasses;

	private Inscription first;
	
	public ListInscriptionCoursMemeEtudiant(Inscription inscription) {
		 itClasses = new IteratorClasses(inscription);

	}
	public void add(Inscription in) {
		if(first != null)
			in.setProchainCours(first);
		first = in;
	}
	public boolean deleteIt(Cours cours) {
		
		Inscription current = first;
		Inscription previous = first;
		
		while(current.getCours() != cours) {
		
			if(current.getProchainCours() == null)
				return false;
			previous = current;
			current = current.getProchainCours(); 		
		}
		
		if(current == first)
			first = first.getProchainCours();
		else
			previous.setProchainCours(current.getProchainCours());		
		
		return true;
	}
	public boolean modifyIt(Inscription old, Inscription nouv) {
		Inscription current = first;
		Inscription previous = first;
		
		while(current != old) {
		
			if(current.getProchainCours() == null)
				return false;
			previous = current;
			current = current.getProchainCours(); 		
		}
		
		if(current == first) {
			nouv.setProchainCours(first);
			first = nouv;
		}
		else {
			nouv.setProchainCours(current.getProchainCours());
			previous.setProchainCours(nouv);
			
		}
		return true;
	}
	@Override
	public IteratorClasses iterator() {
		// TODO Auto-generated method stub
		return itClasses;
	}
	public String showCours() {
		String cours = "Liste des cours de l'étudiant: ";
		while(itClasses.hasNext()) {
			Inscription current = itClasses.next();
			
			cours += current.getCours().toString() + "/n/n";
			
		}
		if(cours.equals("Liste des cours de l'étudiant: "))
			return "Aucun cours pour cet etudiant";
		else 
			return cours;
		
	}

}
