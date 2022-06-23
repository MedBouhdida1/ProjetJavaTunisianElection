package Implementation;

import Entities.Avis;
import Entities.Candidat;
import Entities.Electeur;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class ListeElectorale {
    private static int count = 0;
    private long id;
    private String nomPartie;
    private double score;
    private Set<Candidat> listeCandidat=new HashSet<Candidat>();
    public ListeElectorale()
    {
        this.id = count++;
     
    }   

    //constructors Full parametre
    public ListeElectorale(String nomPartie, Set<Candidat> listeCandidat)
    {
        this.id = count++;
        this.nomPartie = nomPartie;
        this.listeCandidat = listeCandidat;
        this.calculScoreListeEelectoral();
    }
    //constructor without candidat & score
    public ListeElectorale(String nomPartie)
    {
        this.id = count++;
        this.nomPartie = nomPartie;
        this.score = 0.0;
    }

    //Ajout un candidat a une liste Electoral
    public boolean addNewCandidat(Candidat candidat)
    {
       if(this.listeCandidat.add(candidat))
       {
           this.calculScoreListeEelectoral();
           return true;
       }
       return false;
    }

    //verif Liste candidat s'il est vide


    

    public void displayCinNameCandidat() //display format: ["id:nomPrenom","id:nomPrenmo"] ofcondidat
    {
        if(this.listeCandidat.isEmpty())
        {
            System.out.println("\tliste des candidat est vide! ");
        }
        else
        {
            String affichage="";
            for(Candidat candidat:this.listeCandidat)
            {
                String cin = String.valueOf(candidat.getCin());
                String nomPrenom = candidat.getNom()+"_"+candidat.getPrenom();
                double score = candidat.getScore();
                affichage +=  "\""+cin+":"+nomPrenom+"(score: "+score+")"+"\",";
            }
            System.out.println("\t["+affichage+"]");
        }

    }   
    




    //getters & setters
    public long getID() {
        return id;
    }
    public void setID(long iD) {
        this.id = iD;
    }
    public String getNomPartie() {
        return nomPartie;
    }
    public void setNomPartie(String nomPartie) {
        this.nomPartie = nomPartie;
    }
    public Double getScore() {
        return score;
    }
    public void setScore(Double score) {
        this.score = score;
    }

    public Set<Candidat> getListCandidat()
    {
        return this.listeCandidat;
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return Objects.hashCode(nomPartie);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof ListeElectorale)) return false;
        ListeElectorale listeElect = (ListeElectorale) obj;
        return listeElect.getNomPartie().equals(this.nomPartie);
    }

    public boolean removeCandidat(long cin)
    {
        Candidat candidat = new Candidat();
        candidat.setCin(cin);
        return this.listeCandidat.remove(candidat);
    }
    

    //return somme de Score
    public double sommeScoreDesCondidat()
    {
        int somme = 0;
        for (Candidat candidat : listeCandidat) {
            somme +=candidat.getScore();
        }
        return somme;
    }

    public void calculScoreListeEelectoral()
    {
        double scoreTotaleListeElectoral = this.sommeScoreDesCondidat()/this.listeCandidat.size();
        this.setScore(scoreTotaleListeElectoral);
    }

    





    
}
