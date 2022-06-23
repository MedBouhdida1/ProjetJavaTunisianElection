package Entities;

import Enumeration.TypesActivites;

import java.util.Objects;

public class Activite {
    static int count=0;
    long ID;
    String duree;
    String support;
    TypesActivites type;
//TODO: id auto inc
    public Activite(String duree, String support, TypesActivites type) {
        this.ID = ++count;
        this.duree = duree;
        this.support = support;
        this.type = type;
    }

    public Activite() {
    }

    public long getID() {
        return ID;
    }



    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public TypesActivites getType() {
        return type;
    }

    public void setType(TypesActivites type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Activites{" +
                "ID=" + ID +
                ", duree='" + duree + '\'' +
                ", support='" + support + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activite activite = (Activite) o;
        return ID == activite.ID && duree.equals(activite.duree) && support.equals(activite.support) && type == activite.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, duree, support, type);
    }

    public int coefficientActivity()
    {
        switch(this.type)
        {
            case Economique:
                return 12;
            case Humanitaire:
                return 2;
            case Politique:
                 return 20;
            case Scientifique:
                    return 9;
            case Sociale:
                return 18;
            
            default: return 5;
        }

        
        
    }
}
