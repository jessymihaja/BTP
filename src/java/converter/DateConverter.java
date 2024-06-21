/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

/**
 *
 * @author jessy
 */
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateConverter {

    public static Date convertStringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // Ou retourner une valeur par défaut ou gérer l'exception comme vous le souhaitez
        }
    }
}