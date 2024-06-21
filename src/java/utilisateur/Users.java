/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilisateur;

import crud.Dao;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author jessy
 */
public class Users extends Dao{
    int idUser;
    String username;
    String hashedPassword;

    public Users() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    public Users(String username, String hashedPassword) {
            this.username = username;
            this.hashedPassword = hashedPassword;
        }

        public boolean checkCredentials(String password) {
            return BCrypt.checkpw(password, hashedPassword);
        }
    public ArrayList getAllUsers(){
        return this.selectAll("select * from users");
    }
}
