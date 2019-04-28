package secretariat;


public class ListInscriptionEtudMemeCours implements Iterable<Inscription>{

	IteratorEtudiant itEtud;
	Inscription first;
	
	public ListInscriptionEtudMemeCours(Inscription inscription) {
		itEtud = new IteratorEtudiant(inscription);
	}
	public void add(Inscription in) {
		if(first != null)
			in.setProchainCours(first);
		first = in;
	}
	public boolean deleteIt(Etudiant etud) {
		
		Inscription current = first;
		Inscription previous = first;
		
		while(current.getEtudiant()!= etud) {
		
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
	public void modifyIt(Inscription old, Inscription nouv) {
		
	}
	@Override
	public IteratorEtudiant iterator() {
		// TODO Auto-generated method stub
		return itEtud;
	}
	public String showEtudiant() {
		// TODO Auto-generated method stub
		return "";
	}
	public boolean isInscritTo(String codePermanent) {
		while(itEtud.hasNext()) {
			Inscription current = itEtud.next();
			if(current.getEtudiant().getCodePermanent().equals(codePermanent));
				return true;
		}
		return false;
	}

}
