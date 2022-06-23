package Traitement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import DataTest.DataFactory;
import Entities.Candidat;

public class AdminView {

    int choixAdmin=-1;
    Scanner scanner = new Scanner(System.in);
    DataFactory dataFactory;


    public AdminView()
    {
        this.choixAdmin = -1;
        this.dataFactory = new DataFactory();
    }

    public AdminView(DataFactory dataFactory)
    {
        this.choixAdmin = -1;
        this.dataFactory = dataFactory;
    }


    public void MenuAdmin() throws ParseException
    {
        while(this.choixAdmin != 0)
        {
            ScreenEvent.clear();;
            this.menuBanner();
            System.out.print("Choix: ");
            this.choixAdmin = scanner.nextInt();

            switch(this.choixAdmin)
            {
                case 1: //creer candidat
                    ScreenEvent.clear();
                    Candidat candidat = new Candidat();
                    candidat = candidat.GenreateOne();
                    //aprés l'ajout d'un candidat on doit l'ajouter a une liste electorale
                    boolean founded = false;
                    String nomPartie = "";
                    System.out.println("\n------------");
                    this.dataFactory.listDesList.displayAllNomPartie();
                    while(!founded)
                    {
                        System.out.println("Ajouter le candidat a une liste Electorale");
                        scanner.nextLine();
                        nomPartie = scanner.nextLine();
                        founded = this.dataFactory.listDesList.foundElectoralByName(nomPartie);
                        if(!founded) System.out.println("Nom partie non valide! ");
                    }
                    candidat.setNomPartie(nomPartie);
                    boolean addToElectoralList= this.dataFactory.listDesList.addCandidatToElectoralByName(candidat);
                    if (addToElectoralList) System.out.println("candidat ajouter avec succées");
                    else System.out.println("problem au niveau d\'ajout de candidat (verifie si le candidat est existe)..");
                    ScreenEvent.pauseScreen();
                    break;
                
                case 2:
                        ScreenEvent.clear();
                        this.dataFactory.listDesList.chercheCandidatByCin();
                        ScreenEvent.pauseScreen();
                        break;
                case 3: 
                        ScreenEvent.clear();
                        this.dataFactory.listDesList.deleteCandidatByCin();
                        ScreenEvent.pauseScreen();


                case 4:
                    ScreenEvent.clear();
                    this.dataFactory.listDesList.displayElectoral();
                    ScreenEvent.pauseScreen();
                    break;
                case 5:
                    ScreenEvent.clear();
                    this.dataFactory.listDesList.creerListeElectoral();
                    ScreenEvent.pauseScreen();
                    break;
                case 6: 
                    ScreenEvent.clear();
                    this.dataFactory.listDesList.supprimerListeElectorale();
                    ScreenEvent.pauseScreen();
                   

                    
                    

            }
        }

        

    }

    public void menuBanner()
     {
        System.out.println("----------------- Welcome Admin --------------");
        System.out.println("1- Creer un nouveau Candidat");
        System.out.println("2- Recherche Candidat by Cin");
        System.out.println("3- Delete Candidat By Cin");
        System.out.println("4- afficher les liste electoral");
        System.out.println("5- creer liste electoral");
        System.out.println("6- supprimer liste electoral"); 
        System.out.println("0- Logout");
     }

    public DataFactory getDataFactory()
    {
        return this.dataFactory;
    }


    
}
