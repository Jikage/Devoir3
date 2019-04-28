package secretariat;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.omg.PortableServer.LifespanPolicyValue;

public class MenuPrincipale {

	public static void main(String[] args) {
		
			TableauPrincipal tp = new TableauPrincipal();
			int choixMenu1 = 0;

			boolean valide = true;

			Scanner scan = new Scanner(System.in);

			System.out.println("Bienvenue...");

			do {

					choixMenu1 = 0;

					// Permet de mettre un delais pour que le programme soit plus agreable
					try {
						TimeUnit.MILLISECONDS.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					erase();

					System.out.println(
							"Menu principale\n\nEntrer le chiffre correspondant à votre choix et appuyer sur la touche entré: \n\n"
									+ "1 ---- Inscrire un étudiant à un cours\n" 
									+ "2 ---- Annuler une inscription\n" 
									+ "3 ---- Modification de l’inscription\n"
									+ "4 ---- Obtention de la liste des cours suivis par l’étudiant\n"
									+ "5 ---- Obtention de la liste des étudiants inscrits à un cours donné\n"
									+ "6 ---- Sauvegarde des informations relatives aux étudiants, aux cours et aux inscriptions dans des fichiers\n"
									+ "7 ---- Lecture des informations relatives aux étudiants, aux cours et aux inscriptions à partir des fichiers\n"
									+ "8 ---- Quitter\n");
					
					System.out.print("Sélection: ");

					choixMenu1 = lectureInt(scan);
				

				switch (choixMenu1) {

				case 1:
					String codeP,sigle;
					while(true) {
						erase();
						System.out.print(tp.showCodeP());
						System.out.println("Inscrivez le code permanent ");
						codeP = scan.nextLine();
						
						erase();
						System.out.print(tp.showCours())	;
						System.out.println("Inscrivez le sigle du cours");
						sigle = scan.nextLine();
						
						if(tp.inscrire(sigle, codeP)) {
							System.out.println("Inscription enregistré");
							break;
						}
						else
							System.out.println("mauvais code permanent ou sigle entree");
					}
					;
					break;

				case 2:
					String delCodeP,delSigle;
					while(true) {
						erase();
						System.out.print(tp.showCours());
						System.out.println("Inscrivez le sigle du cours de l'inscription a annuler");
						delCodeP = scan.nextLine();
						
						erase();
						System.out.print(tp.showCodeP())	;
						System.out.println("Inscrivez le code permanent du cours a annuler");
						delSigle = scan.nextLine();
						
						if(tp.desinscrire(delSigle, delCodeP)) {
							System.out.println("Inscription annuler avec succes");
							break;
						}
						else
							System.out.println("mauvais code permanent ou sigle entree");
					}
					;
					break;
					
				case 3:
					String modifCodeP,modifSigle,newcodeP,newsigle;
					while(true) {
						erase();
						System.out.print(tp.showCours());
						System.out.println("Inscrivez le sigle du cours de l'inscription a modifier");
						modifCodeP = scan.nextLine();
						
						erase();
						System.out.print(tp.showCodeP())	;
						System.out.println("Inscrivez le code permanent du cours a modifier");
						modifSigle = scan.nextLine();
						
						erase();
						System.out.print(tp.showCours());
						System.out.println("Inscrivez le sigle du cours de la nouvelle inscription");
						newcodeP = scan.nextLine();
						
						erase();
						System.out.print(tp.showCodeP())	;
						System.out.println("Inscrivez le code permanent de la nouvelle inscription");
						newsigle = scan.nextLine();
						
						if(tp.modif(modifSigle, modifCodeP,newsigle, newcodeP)) {
							System.out.println("Inscription modifier avec succes");
							break;
						}
						else
							System.out.println("mauvais code permanent ou sigle entree. Il se peut que l'inscripion existe deja.");
					}
					;
					break;
					
				case 4:
					erase();
					System.out.println("voici la liste des etudiants ");
					System.out.print(tp.showCodeP())	;
					System.out.println("Inscrivez le code permanent ");
					String codeToVef = scan.nextLine();
					System.out.println(tp.showCoursOf(codeToVef));
					;
					break;
					
				case 5:
					erase();
					System.out.println("voici la liste des cours ");
					System.out.print(tp.showCodeP())	;
					System.out.println("Inscrivez le sigle ");
					String sigleToVef = scan.nextLine();
					System.out.println(tp.showEtudiantOf(sigleToVef));
					;
					break;
					
				case 6:
					;
					break;
				
				case 7:
					
					;
					break;
				case 8:
					erase();
					System.out.print("Vous avez choisi de quitter\n");
					valide = false;
					;
					break;
				default:
					erase();
					System.out.print("ce n'est pas une option valide\n");
					;
					break;
				}

			} while (valide);
		}
	private static int lectureInt(Scanner scan) {
		int valeur = 0;
		boolean validation = true;

		do {
			try {
				valeur = scan.nextInt();
				scan.nextLine();
				validation = false;
			} catch (Exception e) {
				System.out.println("veuillez entrer un nombre valide");
				scan.nextLine();
			}
		} while (validation);

		return valeur;
	}
	public static void erase() {
		for (int i = 0; i < 100000; i++)
			System.out.print("\b");
	}
}
