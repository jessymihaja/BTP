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
public class Travaux extends Dao{
    int idTravaux;
    String code;
    String designation;

    public int getIdTravaux() {
        return idTravaux;
    }

    public void setIdTravaux(int idTravaux) {
        this.idTravaux = idTravaux;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public Travaux(){
    }
}
