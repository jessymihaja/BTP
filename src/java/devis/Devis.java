/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devis;

import association.Assoc_type_maison_detail_travaux;
import btp.Detail_travaux;
import btp.Type_finition;
import btp.Type_maison;
import crud.Dao;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import utilisateur.Client;

/**
 *
 * @author jessy
 */
public class Devis extends Dao{
    int idDevis;
    int idClient;
    int idType_maison;
    int idType_finition;
    Date dateDebut;
    Date dateDevis;
    String ref_devis;
    String lieu;

    public String getRef_devis() {
        return ref_devis;
    }

    public void setRef_devis(String devis) {
        this.ref_devis = devis;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getIdDevis() {
        return idDevis;
    }

    public void setIdDevis(int idDevis) {
        this.idDevis = idDevis;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdType_maison() {
        return idType_maison;
    }

    public void setIdType_maison(int idType_maison) {
        this.idType_maison = idType_maison;
    }

    public int getIdType_finition() {
        return idType_finition;
    }

    public void setIdType_finition(int idType_finition) {
        this.idType_finition = idType_finition;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateDevis() {
        return dateDevis;
    }

    public void setDateDevis(Date dateDevis) {
        this.dateDevis = dateDevis;
    }
    public Devis(){}
    
    public Client getClient(){
        Client c=new Client();
        return c.selectOne("select * from Client where idClient="+this.getIdClient());
    } 
    public Type_maison getType_maison(){
        Type_maison t =new Type_maison();
        return t.selectOne("select * from Type_maison where idType_maison="+this.getIdType_maison());
    }
    public Type_finition getType_finition(){
        Type_finition t=new Type_finition();
        return t.selectOne("select * from Type_finition where idType_finition="+this.getIdType_finition());
    }
    public Date getDateFin() {
        Double duree = this.getType_maison().getJourConstructionTotal();
        int jours = (int) Math.ceil(duree);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String formattedDate = sdf.format(this.getDateDebut());

        // Convertir String en java.util.Date
        Date utilDate =Date.valueOf(formattedDate);

        // Convertir java.util.Date en java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        return sqlDate;
    }

    public Devis(int idClient, int idType_maison, int idType_finition, Date dateDebut, String lieu) {
        this.setIdClient(idClient);
        this.setIdType_maison(idType_maison);
        this.setIdType_finition(idType_finition);
        this.setDateDebut(dateDebut);
        this.setLieu(lieu);
        this.setRef_devis("0000");
        this.setDateDevis(new Date(System.currentTimeMillis()));
    }
    
    public ArrayList<Details_devis> createDevis_detail(){
        Devis d=new Devis();
        ArrayList<Details_devis> liste=new ArrayList<>();
        Assoc_type_maison_detail_travaux assoc= new Assoc_type_maison_detail_travaux();
        ArrayList<Assoc_type_maison_detail_travaux> listeassoc=assoc.listeByTypeMaison(this.getIdType_maison());
        for (Assoc_type_maison_detail_travaux a : listeassoc) {
            liste.add(new Details_devis(this.getIdDevis(), a.getIdDetail_travaux(),a.getQuantite(), a.getDetail_travaux().getPrixUnitaire()));
        }
        
        
        return liste;
    }
    public Devis getLastDevis(){
        Devis d=new Devis();
        return d.selectOne("select * from devis where iddevis=(select(max(iddevis)) from devis)");
    }
    public ArrayList<Details_devis> getDetails_devis(){
        Details_devis d=new Details_devis();
        return d.selectAll("select * from detail_devis where idDevis="+this.getIdDevis());
    }
    
    
}
