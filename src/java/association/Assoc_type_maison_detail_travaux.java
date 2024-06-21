/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package association;

import btp.Detail_travaux;
import crud.Dao;
import java.util.ArrayList;

/**
 *
 * @author jessy
 */
public class Assoc_type_maison_detail_travaux extends Dao{
    int id;
    int idType_maison;
    int idDetail_travaux;
    double quantite;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdType_maison() {
        return idType_maison;
    }

    public void setIdType_maison(int idType_maison) {
        this.idType_maison = idType_maison;
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
    public Assoc_type_maison_detail_travaux(){}
    public ArrayList<Assoc_type_maison_detail_travaux> listeByTypeMaison(int idMaison){
        Assoc_type_maison_detail_travaux a=new Assoc_type_maison_detail_travaux();
        return a.selectAll("select * from assoc_type_maison_detail_travaux where idType_maison="+idMaison);
    } 
    public Detail_travaux getDetail_travaux(){
        Detail_travaux d=new Detail_travaux();
        return d.selectOne("select * from detail_travaux where idDetail_travaux="+ this.getIdDetail_travaux());
    }
    
}
