/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btp;

import association.Assoc_type_maison_detail_travaux;
import crud.Dao;
import java.util.ArrayList;

/**
 *
 * @author jessy
 */
public class Type_maison extends Dao{
    int idType_Maison;
    String designation;
    String description;
    double surface;
    double duree_travaux;

    public double getDuree_travaux() {
        return duree_travaux;
    }

    public void setDuree_travaux(double duree_travaux) {
        this.duree_travaux = duree_travaux;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public int getIdType_Maison() {
        return idType_Maison;
    }

    public void setIdType_Maison(int idType_Maison) {
        this.idType_Maison = idType_Maison;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public Type_maison(){}
    public ArrayList<Detail_travaux> getALldetail_travaux(){
        ArrayList<Detail_travaux> liste=new ArrayList<Detail_travaux>();
       Assoc_type_maison_detail_travaux assoc=new Assoc_type_maison_detail_travaux();
       ArrayList<Assoc_type_maison_detail_travaux> assocListe=assoc.listeByTypeMaison(this.getIdType_Maison());
        for (Assoc_type_maison_detail_travaux a : assocListe) {
            liste.add(a.getDetail_travaux());
        }
        
        return liste;
    }
    public double getJourConstructionTotal(){
        ArrayList<Detail_travaux> liste_travaux=this.getALldetail_travaux();
        double somme=0;
        for (Detail_travaux d : liste_travaux) {
            somme+=d.getDureeUnitaire();
        }
        return somme;
    }
    public double getPrixConstructionTotal(){
        double somme=0;
       Assoc_type_maison_detail_travaux assoc=new Assoc_type_maison_detail_travaux();
       ArrayList<Assoc_type_maison_detail_travaux> assocListe=assoc.listeByTypeMaison(this.getIdType_Maison());
        for (Assoc_type_maison_detail_travaux a : assocListe) {
            somme+=(a.getDetail_travaux().getPrixUnitaire()*a.getQuantite());
        }
        
        return somme;
    }
    public ArrayList<Type_maison> getAllType_maison(){
        Type_maison m=new Type_maison();
        return m.selectAll("select * from Type_maison");
    }
    
    
}
