/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package football;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class ConnexionBD {
    private static Connection connect = null;

    private ConnexionBD() {
        if (connect == null) {
            try {
                Class.forName("org.sqlite.JDBC").newInstance();
                //on r�cup�re le nom de la bd dans le fichier nomBD.txt
                connect = DriverManager.getConnection("jdbc:sqlite:FootBase.sqlite");
            } catch (Exception ex) {
                connect = null;
                System.err.println(ex.getMessage());
            }
        }
    }

    public static Connection getConnexion() {
        if (connect==null){
            new ConnexionBD();
            System.out.println("Connexion etablie");
        }
        else
            System.out.println("Connexion deja existante");
        return connect;
    }
}