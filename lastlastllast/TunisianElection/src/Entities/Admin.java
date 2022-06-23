package Entities;

import java.io.Console;
import java.util.Objects;
import java.util.Scanner;

public class Admin {
    private long CIN=12345678;
    private String password="0000";


    public Admin(long CIN, String password) {
        this.CIN = CIN;
        this.password = password;
    }

    public Admin() {
    }


    public boolean signIn(){
        Long c;
        String p;
        int length;
        do {
            System.out.println("Bonjour, entrer votre CIN");
            Scanner s = new Scanner(System.in);
            c = s.nextLong();
            length = (int)(Math.log10(c)+1);

        }
        while(length!=8);

        do {
            Console console = System.console();
            char[] passwordInput = console.readPassword("Donner votre mot de passe: ");
            p = String.valueOf(passwordInput);

        }
        while(p=="");

        if( login(c,p))
        {
            System.out.println("Login successful");
            return true;
        }
        else
            System.out.println("Login failed");
            return false;
    }

    public boolean login(long cin,String pw){
        if (cin!=this.CIN)
            return false;
        if(!pw.equals(this.password))
            return false;
        return true;
    }

    public long getCIN() {
        return CIN;
    }

    public void setCIN(long CIN) {
        this.CIN = CIN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "CIN=" + CIN +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return CIN == admin.CIN && password.equals(admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CIN, password);
    }
}
