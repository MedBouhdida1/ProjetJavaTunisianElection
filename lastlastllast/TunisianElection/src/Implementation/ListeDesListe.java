package Implementation;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Entities.Avis;
import Entities.Candidat;
import Entities.Electeur;

public class ListeDesListe {
    Set<ListeElectorale> listeAhzeb = new HashSet<ListeElectorale>();

    public ListeDesListe(Set<ListeElectorale> listeAhzeb) {
        this.listeAhzeb = listeAhzeb;
    }
    public ListeDesListe()
    {

    }   

    /* Add methods */

    // ajout nouvaux 7ezb
    public boolean addNewListElectoral(ListeElectorale hezb) {
        return this.listeAhzeb.add(hezb);
    }

    //ajout candidat to a hezb 
    public boolean addCandidatToElectoralByName(Candidat candidat) //menu
    {   
        ListeElectorale foundElectorale=this.getElectoralByName(candidat.getNomPartie());
        return foundElectorale.addNewCandidat(candidat);
    }

    /* END */
    /* get&display methods */

    // displaly All hezbs (display hezb data like => id partie: 0, name:"hezb el
    // khodhr",candidat:["0: anas","1: aymen","2: bouhdida"] )
    public void displayElectoral() { //Menu
        for (ListeElectorale listeElectorale : this.listeAhzeb) {
            System.out.println("id Partie: " + listeElectorale.getID());
            System.out.println("Nom Partie: " + listeElectorale.getNomPartie());
            System.out.println("Score Partie: " + listeElectorale.getScore());
            System.out.println("La liste des candidat:");
            listeElectorale.displayCinNameCandidat();
            System.out.println("-------------------------\n");
        }
    }

    public void displayAllNomPartie() //Menu
    {
        System.out.print("\t\tles listes Electorale disponible: ");
        System.out.print("\t\t  [");
        for(ListeElectorale listElectoral:this.listeAhzeb)
        {
            System.out.print(listElectoral.getNomPartie()+", ");
        }
        System.out.print("]");
        System.out.println("\n");
    }

    // get hezb by nomHezb
    public ListeElectorale getElectoralByName(String nomPartie) 
    {

        for(ListeElectorale listElect:this.listeAhzeb)
        {
            if(listElect.getNomPartie().equals(nomPartie))
                return listElect;
        }
        return null;
    }

    public boolean foundElectoralByName(String nomPartie) //used menu
    {
        for(ListeElectorale electoral : this.listeAhzeb)
        {
            if (electoral.getNomPartie().equals(nomPartie))
                return true;
        }
        return false;
    }



    /* End */

    /* Recherche candidat by Cin */
    public void chercheCandidatByCin() //Menu
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("saisie Cin candidat a chercher: ");
        int cin = scanner.nextInt();
        Candidat candidatFound = this.getCandidatByCin(cin) ;
        if(candidatFound != null)
            candidatFound.displayCandidat();
        else
            System.out.println("Candidat NOT Found !");
    }

    public Candidat getCandidatByCin(int cin)
    {
        for (ListeElectorale listeElectorale : listeAhzeb) {
            for(Candidat candidat: listeElectorale.getListCandidat())
            {
                if(candidat.getCin() == cin) return candidat;
            }
        }
        return null;
    }
    /*End recherche */

    /* Delete Candidat By Cin */
    public void deleteCandidatByCin() //Menu
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("saisie le CIN de candidat a supprimer: ");
        long cin = scanner.nextLong();
        boolean deleted = false;
        //loop on the list until remove equal to true else if it's false (candidat not exist) 
        for (ListeElectorale listeElectorale : listeAhzeb) {
            if(listeElectorale.removeCandidat(cin) == true)
            {
                deleted = true;
                listeElectorale.calculScoreListeEelectoral();
                break;
            }
        }
        if(deleted) System.out.println("Le Candidat "+cin+" supprimer avec succées!");
        else 
            System.out.println("le Candidat "+cin+" n\'existe pas");

    }

    /* END */


    /* Creer liste electorale */
    public void creerListeElectoral() //Menu
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------- Creer Nouveau List Electorale --------------");
        System.out.print("saisier le Nom Partie: ");
        String nomPartie = scanner.nextLine();
        ListeElectorale newListeElectoral = new ListeElectorale();
        newListeElectoral.setNomPartie(nomPartie);

        if(this.listeAhzeb.add(newListeElectoral))
            System.out.println("Operation avec succées");
        else
            System.out.println("erreur: cette partie deja existe");
    }
    /* END */

    /* Supprimer liste electorale */
    public void supprimerListeElectorale() //Menu
    {   
        Scanner scanner = new Scanner(System.in);
        this.displayAllNomPartie();
        System.out.print("saisie le nom de la liste Electorale: ");
        String nomListeElectorale = scanner.nextLine();
        ListeElectorale listeElectorale = new ListeElectorale();
        listeElectorale.setNomPartie(nomListeElectorale);

        if(this.listeAhzeb.remove(listeElectorale))
            System.out.println("la liste supprimer avec succées");
        else
            System.out.println("erreur apparus au cours de suppression!");
    }

    public void introduireAvis(Electeur electeur)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisie Cin de Candidat que vous voulez evaluer");
        long cin = scanner.nextLong();
        int avisNote = -1;
        boolean candidatFound = false;

        for (ListeElectorale listeElectorale : listeAhzeb) {
            
            for (Candidat candidat : listeElectorale.getListCandidat()) {
                    if(candidat.getCin() == cin)
                    {
                        candidatFound = true;
                        do{
                            System.out.println("donner votre Avis entre 0 et 100");
                            avisNote = scanner.nextInt();
                        } while(avisNote < 0 || avisNote > 100);

                        Avis avis = new Avis();
                        avis.setElecteur(electeur);
                        avis.setNote(avisNote);
                       

                        candidat.ajoutAvis(avis);
                        
                    }
            }
        }

        if(!candidatFound) System.out.println("Cin de candidat non valide");
    }
}
