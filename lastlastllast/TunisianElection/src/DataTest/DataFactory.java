package DataTest;

import java.util.ArrayList;
import java.util.List;

import Entities.Activite;
import Entities.Avis;
import Entities.Candidat;
import Entities.Electeur;
import Enumeration.TypesActivites;
import Implementation.ListeDesElecteurs;
import Implementation.ListeDesListe;
import Implementation.ListeElectorale;

public class DataFactory {

   public ListeDesListe listDesList = new ListeDesListe();
   public ListeDesElecteurs electeursList = new ListeDesElecteurs();
    
    public DataFactory()
    {
        this.remplireListeElecteur();
        this.remplireListedesListeElectorale();
    }


    public void remplireListeElecteur()
    {
        Electeur e1 = new Electeur("Ahmed","Hamouda",11403424,26184908,"password");
        Electeur e2 = new Electeur("Aymen","jlassi",11422751,197,"aymen");
        Electeur e3 = new Electeur("Mohamed","bouhdida",11422750,193,"boh");
        this.electeursList.signup(e1);
        this.electeursList.signup(e2);
        this.electeursList.signup(e3);
    }

    private void remplireListedesListeElectorale()
    {

        //generate activities
        List<Activite> listeActivitiesCandidat = new ArrayList<Activite>();
        

        Activite act = new Activite();
        act.setDuree("123");
        act.setType(TypesActivites.Economique);
        act.setSupport("word");

        Activite act2 = new Activite();
        act2.setType(TypesActivites.Humanitaire);
        act2.setSupport("something");
        act2.setDuree("9384");
        listeActivitiesCandidat.add(act);
        listeActivitiesCandidat.add(act2);


        List<Activite> listeActivitiesCandidat2 = new ArrayList<Activite>();
        Activite act3 = new Activite();
        act3.setDuree("60");
        act3.setType(TypesActivites.Politique);
        act3.setSupport("Excel");
        Activite act4 = new Activite();
        act4.setType(TypesActivites.Scientifique);
        act4.setSupport("something");
        act4.setDuree("9384");
        listeActivitiesCandidat2.add(act3);
        listeActivitiesCandidat2.add(act4);

        List<Activite> listeActivitiesCandidat3 = new ArrayList<Activite>();
        Activite act5 = new Activite();
        act5.setDuree("60");
        act5.setType(TypesActivites.Politique);
        act5.setSupport("Excel");
        Activite act6 = new Activite();
        act6.setType(TypesActivites.Scientifique);
        act6.setSupport("something");
        act6.setDuree("9384");
        Activite act7 = new Activite();
        act7.setType(TypesActivites.Sociale);
        act7.setSupport("something");
        act7.setDuree("9384");
        listeActivitiesCandidat3.add(act5);
        listeActivitiesCandidat3.add(act6);
        listeActivitiesCandidat3.add(act7);


        
        Candidat candidat = new Candidat("ahmed",12,"ben hamouda","11/1/1","photo","hezb el 5odhr","facebook","twitter",listeActivitiesCandidat, null,new ArrayList<Avis>());
        Candidat candidat1 = new Candidat("mourad",11,"ben hamouda","13/1/1997","photo","hezb el 5odhr","facebook","twitter",listeActivitiesCandidat2, null,new ArrayList<Avis>());
        Candidat candidat2 = new Candidat("aymen",10,"ben hamouda","13/1/1997","photo","hezb el 5odhr","facebook","twitter",listeActivitiesCandidat3, null,new ArrayList<Avis>());
        Candidat candidat3 = new Candidat("karim",1,"ben hamouda","13/1/1997","photo","hezb el 5odhr","facebook","twitter",listeActivitiesCandidat, null,new ArrayList<Avis>());
        Candidat candidat4 = new Candidat("chiheb",34,"ben hamouda","13/1/1997","photo","hezb el 5odhr","facebook","twitter",listeActivitiesCandidat3, null,new ArrayList<Avis>());
        Candidat candidat5 = new Candidat("montasar",2,"ben hamouda","13/1/1997","photo","hezb el 5odhr","facebook","twitter",listeActivitiesCandidat2, null,new ArrayList<Avis>());

        ListeElectorale listeElectoral = new ListeElectorale("hezb el 5odhr");
        listeElectoral.addNewCandidat(candidat);
        listeElectoral.addNewCandidat(candidat1);
        listeElectoral.addNewCandidat(candidat2);
        listeElectoral.addNewCandidat(candidat3);
        listeElectoral.addNewCandidat(candidat4);

        
        this.listDesList.addNewListElectoral(listeElectoral);
        ListeElectorale listeElectoral2 = new ListeElectorale("el nahdha");
        listeElectoral2.addNewCandidat(candidat5);
        this.listDesList.addNewListElectoral(listeElectoral2);
       
    }




}
