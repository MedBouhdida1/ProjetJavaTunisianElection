package Traitement;

import java.util.Scanner;

import DataTest.DataFactory;
import Entities.Electeur;

public class ElecteurView {
    int choixElecteur = -1;
    Scanner scanner = new Scanner(System.in);
    Electeur electeur ;
    DataFactory dataFactory;

    public ElecteurView(DataFactory dataFactory,Electeur electeur)
    {
        this.dataFactory = dataFactory;
        this.electeur = electeur;
    }


    public void menuElecteur()
    {
        while(this.choixElecteur != 0)
        {
            ScreenEvent.clear();
            this.menuBanner();
            System.out.print("Choix: ");
            this.choixElecteur = scanner.nextInt();

            switch(this.choixElecteur)
            {
                case 1:
                        ScreenEvent.clear();
                        this.dataFactory.listDesList.chercheCandidatByCin();
                        ScreenEvent.pauseScreen();
                        break;
                case 2:
                    ScreenEvent.clear();
                    this.dataFactory.listDesList.displayElectoral();
                    ScreenEvent.pauseScreen();
                    break;
                case 3:
                    ScreenEvent.clear();
                    this.dataFactory.listDesList.introduireAvis(this.electeur);
                    ScreenEvent.pauseScreen();
                    break;
            }

        }
    }

    public void menuBanner()
    {
       System.out.println("----------------- Welcome "+ this.electeur.getNom()+" "+this.electeur.getPrenom() +"--------------\n");
       System.out.println("1- Recherche Candidat by Cin");
       System.out.println("2- afficher les liste electoral");
       System.out.println("3- introduit une note à un candidat");
       System.out.println("0- Logout\n");
    } 


    public DataFactory getDataFactory()
    {
        return this.dataFactory;
    }
}
