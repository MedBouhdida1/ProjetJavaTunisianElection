package Entities;

import java.text.ParseException;
import java.util.*;

import Enumeration.TypesActivites;

public class Candidat {

    static int count=0;
    long id=0;
    String nom;
    long cin;
    String prenom;
    String dateNaissance;
    String photo;
    String nomPartie;
    String fb;
    String tweeter;
    List<Activite> act = new ArrayList<Activite>();
    Double score;
    ArrayList<Avis> l = new ArrayList<Avis>();//

    Scanner s= new Scanner(System.in);


    public Candidat() {
        this.id=++count;
        this.calculScore();

    }

    public Candidat(String nom,long cin, String prenom, String dateNaissance, String photo, String nomPartie, String fb, String tweeter, List<Activite> act, Double score, ArrayList<Avis> l) {
        this.id=++count;
        this.nom = nom;
        this.cin=cin;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.photo = photo;
        this.nomPartie = nomPartie;
        this.fb = fb;
        this.tweeter = tweeter;
        this.act = act;
        this.score = score;
        this.l = l;
        this.calculScore();
    }


    //Comparaison bel CIN donc n9arnou mbaad bel .getCIN
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidat candidat = (Candidat) o;
        return this.cin == candidat.cin;
    }
    
    public void displayCandidat()
    {
        System.out.println("CIN: "+this.cin);
        System.out.println("NOM: "+ this.nom);
        System.out.println("PRENOM: "+ this.prenom);
        System.out.println("Date de Naissance: "+ this.dateNaissance);
        System.out.println("Photo Link: "+ this.photo);
        System.out.println("Nom Partie: "+ this.nomPartie);
        System.out.println("Facebook: "+ this.fb);
        System.out.println("Twitter: "+ this.tweeter);
        System.out.println("Score: "+ this.score);
        System.out.println("Les activié de candidat: ");
         if(act.isEmpty() || act == null)
         {
             System.out.println("\t no Activity founded");
         }
         else{
            for (Activite activite : act) {
            System.out.println("\tType d'activité: "+activite.type.toString());
            System.out.println("\tdurée d'activité: "+activite.duree);
            System.out.println("\tSupport d'activité: "+activite.support);
            System.out.println("------------------------");
        }
        System.out.println("-------------- les Avis --------------");

            for (Avis avis : l) {
                String nomPrenom = avis.getElecteur().getNom()+" "+avis.getElecteur().getPrenom();

                System.out.println("\t"+nomPrenom+": "+avis.getNote());
            }
    
       
    }

        //TODO: activities
    }
// @Override
// public String toString() {
//     return "Cin " + this.cin;
// }


    @Override
    public int hashCode() {
        return Objects.hashCode(cin);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNomPartie() {
        return nomPartie;
    }

    public void setNomPartie(String nomPartie) {
        this.nomPartie = nomPartie;
    }

    public String getFb() {
        return fb;
    }

    public long getCin() {
        return cin;
    }

    public void setCin(long cin) {
        this.cin = cin;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getTweeter() {
        return tweeter;
    }

    public void setTweeter(String tweeter) {
        this.tweeter = tweeter;
    }

    public List<Activite> getAct() {
        return act;
    }

    public void setAct(List<Activite> act) {
        this.act = act;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public ArrayList<Avis> getL() {
        return l;
    }

    public void setL(ArrayList<Avis> l) {
        this.l = l;
    }


    public Candidat GenreateOne()  {
        System.out.println("Entrer le nom du candidat ");
        String n= s.nextLine();
        System.out.println("Entrer le prenom du candidat ");
        String p=s.nextLine();
        System.out.println("Entrer le num cin du candidat ");
        Long c=s.nextLong();
        System.out.println("Entrer DateNaissance sous la forma DD/MM/YYYY");
        s.nextLine();
        String d=s.nextLine();
        // Date d=new SimpleDateFormat("dd/MM/yyyy").parse(t);
        System.out.println("Entrer le lien de la photo de candidat ");
        String ph=s.nextLine();
        // System.out.println("Entrer le nom de la partie ");
        // String nomPartie=s.nextLine();
        System.out.println("Entrer le lien de FB ");
        String fb=s.nextLine();
        System.out.println("Entrer Lien Twitter ");
        String Twitter=s.nextLine();
        //entrer activité: houni methode nda5loul'ha nombre d'activité w baad ysir saisie
        this.saisieActivit();
        this.calculScore();
        ArrayList<Avis> la=null;

        // Candidat flen = new Candidat(n,c,p,d,ph,nomPartie,fb,Twitter,acti,scor,la);
        this.nom = n;
        this.cin = c;
        this.prenom = p;
        this.dateNaissance = d;
        this.photo = ph;
        this.fb = fb;
        this.tweeter = Twitter;
        // this.score = this.calculScore();
       

        return this;
    }

    public void saisieActivit()
    {
        System.out.println("veuillez intorduire le nombre d\'acitivité");
        int nombre = s.nextInt();
        int choix = -1;
        for(int i = 0; i<nombre;i++)
        {
            do{
                System.out.println("Saisie acitivité num: "+i);
                System.out.println("choisie le type d\'activité: ");
                System.out.println("\t1- Scientifique");
                System.out.println("\t2- Politique");
                System.out.println("\t3- Economique");
                System.out.println("\t4- Sociale");
                System.out.println("\t5- Humanitaire");
                System.out.println("\t6- Autre");
                System.out.print("choix: ");
                choix = s.nextInt();
            }while(choix < 1 || choix >6);
            Activite activit = new Activite();
            System.out.println("Entrer la dureé de l'activité");
            String duree = s.nextLine();
            s.nextLine();
            activit.setDuree(duree);

            System.out.println("Entrer le support de verification");
            String support = s.nextLine();
            activit.setSupport(support);

           
            switch(choix)
            {
                case 1:
                     activit.setType(TypesActivites.Scientifique);
                     break;
                        
                case 2:
                    activit.setType(TypesActivites.Politique);
                    break;
                case 3:
                    activit.setType(TypesActivites.Economique);
                    break;
                case 4: 
                    activit.setType(TypesActivites.Sociale);
                    break;
                case 5:
                    activit.setType(TypesActivites.Humanitaire);
                    break;
                case 6:
                    activit.setType(TypesActivites.Autre);
                    break;
            }
            this.act.add(activit);

             
        }

    }


    public int sommeCoefficient()
    {
        int somme = 0;
        for (Activite activite : act) {
           somme=somme+activite.coefficientActivity();
        }

        return somme;
    }
    public void calculScore(){
        double score=0;
        int nmbreActivity = this.act.size();
        score = this.sommeCoefficient() + nmbreActivity;
        this.setScore(score);
    }

    public boolean ajoutAvis(Avis avis)
    {
        return this.l.add(avis);
    }


//recherche w delete tsir fil list of candidats


}
