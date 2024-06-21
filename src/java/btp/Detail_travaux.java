/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btp;

import crud.Dao;

/**
 *
 * @author jessy
 */
public class Detail_travaux extends Dao{
    int idDetail_travaux;
    int idTravaux;
    String designation;
    double PrixUnitaire;
    double DureeUnitaire;
    String unite;
    String code_travaux;

    public String getCode_travaux() {
        return code_travaux;
    }

    public void setCode_travaux(String code_travaux) {
        this.code_travaux = code_travaux;
    }

    public int getIdDetail_travaux() {
        return idDetail_travaux;
    }

    public void setIdDetail_travaux(int idDetail_travaux) {
        this.idDetail_travaux = idDetail_travaux;
    }

    public int getIdTravaux() {
        return idTravaux;
    }

    public void setIdTravaux(int idTravaux) {
        this.idTravaux = idTravaux;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixUnitaire() {
        return PrixUnitaire;
    }

    public void setPrixUnitaire(double PrixUnitaire) {
        this.PrixUnitaire = PrixUnitaire;
    }

    public double getDureeUnitaire() {
        return DureeUnitaire;
    }

    public void setDureeUnitaire(double DureeUnitaire) {
        this.DureeUnitaire = DureeUnitaire;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
    public Detail_travaux(){}
    public Travaux getTravaux(){
        Travaux t= new Travaux();
        return t.selectOne("select * from travaux where idtravaux="+this.getIdTravaux());
    }
    
}
