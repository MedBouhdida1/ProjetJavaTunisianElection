package Traitement;

import java.text.ParseException;
import java.util.Scanner;
import java.io.Console;

import DataTest.DataFactory;
import Entities.Admin;
import Entities.Electeur;

public class Main {

    public static void main(String[] args) throws ParseException  {
        DataFactory data = new DataFactory();
        AdminView adminView;
        int choix = -1;

        while(choix != 0)
        {
            ScreenEvent.clear();
            System.out.println("---------------------- Tunisien Election Manager ----------------");
            System.out.println("1- sign in (Electeur)");
            System.out.println("2- sin Up (Electeur)");
            System.out.println("3- Log as Admin");
            System.out.println("4- Visualiser les scores");
            System.out.println("0- Exit\n");

            System.out.print("choix:\t");
            Scanner scanner = new Scanner(System.in);
            choix = scanner.nextInt();  

            switch(choix)
            {
                case 1:
                       
                        boolean authGuardElecteur = false;
                        int retry = -1;
                        do{
                            ScreenEvent.clear();
                            System.out.print("Donner votre CIN: ");
                            Long cin = scanner.nextLong();
                            // System.out.println("");
                            Console console = System.console();
                            char[] passwordInput = console.readPassword("Donner votre mot de passe: ");
                            ScreenEvent.clear();
                            authGuardElecteur=data.electeursList.login(cin, String.valueOf(passwordInput));
                            if(authGuardElecteur == false)
                            {
                                System.out.println("1- retry");
                                System.out.println("0- back\n");
                                System.out.print("choix: ");
                                retry = scanner.nextInt();
                            }else
                            {
                                Electeur electeur = data.electeursList.recherche(cin);
                                ElecteurView electeurView = new ElecteurView(data, electeur);
                                electeurView.menuElecteur();
                                data = electeurView.getDataFactory();
                            }
                        }while(!authGuardElecteur && retry !=0);
                  
                        break;
                case 2: 
                        ScreenEvent.clear();
                        Electeur E1 = new Electeur();
                        E1=E1.createElecteur();
                        data.electeursList.signup(E1);
                        
                        break;
                
                case 3: 
                        boolean authGuardAdmin = false;
                        int retryAdmin = -1;
                      
                        do{
                            ScreenEvent.clear();
                          
                            Admin admin = new Admin();
                            authGuardAdmin=admin.signIn();
                            if(authGuardAdmin == false)
                            {
                                System.out.println("1- retry");
                                System.out.println("0- back\n");
                                System.out.print("choix: ");
                                retry = scanner.nextInt();
                            }else{
                                //admin Menu
                                ScreenEvent.clear();
                                adminView = new AdminView(data);
                                adminView.MenuAdmin();
                                data = adminView.getDataFactory();
                                
                               
                            }
                            

                        }while(!authGuardAdmin && retryAdmin != 0);
                        break;
                case 4: 
                        ScreenEvent.clear();
                        //Visualiser les score 
                        data.listDesList.displayElectoral();
                        ScreenEvent.pauseScreen();
                        break;

            }


        }

        
        
    }



}
