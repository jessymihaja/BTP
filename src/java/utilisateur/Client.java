/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilisateur;

import crud.Dao;
import devis.Devis;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author jessy
 */
public class Client extends Dao{
    int idClient;
    String numero;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNumero() {
        return numero;
    }
     public void setNumero(String numero) {
        // Vérifie si le numéro commence par 033, 034 ou 038 et contient exactement 10 chiffres
        Pattern pattern = Pattern.compile("^033\\d{7}|034\\d{7}|038\\d{7}$");
        if (pattern.matcher(numero).matches()) {
            this.numero =numero;
        } else {
            throw new IllegalArgumentException("Le numero de telephone doit commencer par 033, 034 ou 038 et contenir exactement 10 chiffres.");
        }
    }
 
    public Client(){}
    
    public ArrayList<Client> getAllClient(){
        Client c=new Client();
        return c.selectAll("select * from Client");
    }
    
    public ArrayList<Devis>getDevisByClient(){
        Devis d= new Devis();
        return d.selectAll("select * from Devis where idClient="+ this.getIdClient());
    }
    
    public Client getClientByNumero(String numero){
        Client c=new Client();
        String apos="'";
        String newnum=apos+numero+apos;
        return c.selectOne("select * from client where numero=" + newnum);
    }
    public Client(String numero){
        this.setNumero(numero);
    }
    public static void main(String[] args) {
        Client c= new Client();
        c.setIdClient(7);
        ArrayList<Devis> liste=(c.getDevisByClient());
        for (Devis devis : liste) {
            System.out.println(devis.getDateDebut());
        }
    }
    
}
