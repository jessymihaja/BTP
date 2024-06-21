/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btp;

import crud.Dao;
import java.util.ArrayList;

/**
 *
 * @author jessy
 */
public class Type_finition extends Dao{
    int idType_finition;
    String designation;
    double pourcentage;

    public int getIdType_finition() {
        return idType_finition;
    }

    public void setIdType_finition(int idType_finition) {
        this.idType_finition = idType_finition;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }
    public Type_finition(){}
    public ArrayList<Type_finition> getAllType_finition(){
        Type_finition y= new Type_finition();
        return y.selectAll("select * from type_finition");
    }
    
    
}
