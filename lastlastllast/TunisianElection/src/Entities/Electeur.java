package Entities;


import java.io.Console;
import java.util.Objects;
import java.util.Scanner;

public class Electeur {
        String nom;
        String prenom;
        long CIN;
        long tel;
        String password;

        public Electeur() {
        }

        public Electeur(String nom, String prenom, long CIN, long tel, String password) {
                this.nom = nom;
                this.prenom = prenom;
                this.CIN = CIN;
                this.tel = tel;
                this.password = password;
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

        public long getCIN() {
                return CIN;
        }

        public void setCIN(long CIN) {
                this.CIN = CIN;
        }

        public long getTel() {
                return tel;
        }

        public void setTel(long tel) {
                this.tel = tel;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        @Override
        public String toString() {
                return "Electeur{" +
                        "nom='" + nom + '\'' +
                        ", prenom='" + prenom + '\'' +
                        ", CIN=" + CIN +
                        ", tel=" + tel +
                        ", password='" + password + '\'' +
                        '}';
        }
        public Electeur createElecteur(){
                Scanner sc= new Scanner(System.in);
                String nom;
                String prenom;
                long CIN;
                long tel;
                String pass;

                System.out.println("Donnez votre NOM");
                nom = sc.nextLine();
                System.out.println("Donnez votre PRENOM");
                prenom = sc.nextLine();
                System.out.println("Donnez votre num CIN");
                CIN = sc.nextLong();
                System.out.println("Donnez votre TEL");
                tel = sc.nextLong();
                Console console = System.console();
                char[] passwordInput = console.readPassword("Donner votre mot de passe: ");
                sc.nextLine();


                this.setNom(nom);
                this.setPrenom(prenom);
                this.setCIN(CIN);
                this.setTel(tel);
                this.setPassword(String.valueOf(passwordInput));
                return this;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Electeur)) return false;
                Electeur electeur = (Electeur) o;
                return getCIN() == electeur.getCIN();
        }

        @Override
        public int hashCode() {
                return Objects.hash(getCIN());
        }
        //public Avis introduirAvid(){
       //         return Avis;
        //}
}
