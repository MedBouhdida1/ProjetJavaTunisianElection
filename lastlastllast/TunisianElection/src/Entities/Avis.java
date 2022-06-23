package Entities;

import java.util.Objects;
import java.util.Scanner;

public class Avis {
    int note;
    Electeur electeur;

    public Avis(int note, Electeur electeur) {
        this.note = note;
        this.electeur = electeur;
    }

    public Avis() {
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Electeur getElecteur() {
        return this.electeur;
    }

    public void setElecteur(Electeur electeur) {
        this.electeur = electeur;
    }

    public Avis createAvis(Electeur electeur)
    {
        System.out.println("Veuillez introduire un note sur 100:");
        Scanner sc=new Scanner(System.in);
        this.note=sc.nextInt();
        this.electeur=electeur;

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avis avis = (Avis) o;
        return (this.electeur == avis.getElecteur() && this.note == avis.getNote());
    }

    @Override
    public int hashCode() {
        return Objects.hash(electeur,note);
    }

    @Override
    public String toString() {
        return "Avis{" +
                "note=" + note +
                    electeur.toString()+
                '}';
    }
}
