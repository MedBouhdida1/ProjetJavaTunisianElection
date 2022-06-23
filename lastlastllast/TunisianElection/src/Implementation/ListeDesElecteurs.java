package Implementation;

import Entities.Electeur;

import java.util.HashSet;

public class ListeDesElecteurs {
    //kol-users
    //login
    //signup
    HashSet<Electeur> listelects = new HashSet<Electeur>();

    public boolean login(long cin,String password){
        Electeur E = recherche(cin);

            if (E != null) {
                if(E.getPassword().equals(password) ) {
                    System.out.println("Succès");
                    return true;
                }
                else {
                    System.out.println("mot de passe incorrect");
                    return false;
                }
            }
            else{
                System.out.println("Cin incorrect ou n'existe pas");
                return false;
            }
    }
    public boolean signup(Electeur E){
        return listelects.add(E)?true:false;
    }

    public Electeur recherche(long cin){
        for (Electeur E:listelects){
            if (E.getCIN() == cin)
                return E;
        }
        return null;
    }
    public boolean delete(long cin){
        Electeur E = recherche(cin);
            if (E == null) {
                System.out.println("Cette electeur n'existe pas");
                return false;
            }
            else {
                listelects.remove(E);
                System.out.println("L'électeur a été supprimé avec succès");
                return true;
            }
    }
    public void afficherListeElecteur(){
        for (Electeur E:listelects){
            System.out.println( E.toString());
        }
    }
}
