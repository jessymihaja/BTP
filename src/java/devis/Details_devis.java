/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package devis;

import association.Assoc_type_maison_detail_travaux;
import btp.Detail_travaux;
import crud.Dao;
import java.util.ArrayList;

/**
 *
 * @author jessy
 */
public class Details_devis extends Dao{
    int idDetail_devis;
    int idDevis;
    int idDetail_travaux;
    double quantite;
    double prixUnitaire;

    Details_devis() {
    }

    public int getIdDetail_devis() {
        return idDetail_devis;
    }

    public void setIdDetail_devis(int idDetail_devis) {
        this.idDetail_devis = idDetail_devis;
    }

    public int getIdDevis() {
        return idDevis;
    }

    public void setIdDevis(int idDevis) {
        this.idDevis = idDevis;
    }

    public int getIdDetail_travaux() {
        return idDetail_travaux;
    }

    public void setIdDetail_travaux(int idDetail_travaux) {
        this.idDetail_travaux = idDetail_travaux;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    public Detail_travaux getDetail_travaux(){
        Detail_travaux d=new Detail_travaux();
        return d.selectOne("select * from detail_travaux where idDetail_travaux="+ this.getIdDetail_travaux());
    }
    public Devis getDevis(){
        Devis d=new Devis();
        return d.selectOne("select * from devis where idDevis="+this.getIdDevis());
    }

    public Details_devis(int idDevis, int idDetail_travaux, double quantite, double prixUnitaire) {
        this.setIdDevis(idDevis);
        this.setIdDetail_travaux(idDetail_travaux);
        this.setQuantite(quantite);
        this.setPrixUnitaire(prixUnitaire);
    }
    

}
