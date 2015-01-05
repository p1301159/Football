package football;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class MesRequetes{

    private int idCurrentClient = -1;
    private ArrayList<Pays> pays=new ArrayList<>();

    public MesRequetes() {
        NomPays();
    }
    
    public int getIdCurrentClient() {
        return idCurrentClient;
    }
       
    public void setIdCurrentClient(int idCurrentClient) {
        this.idCurrentClient = idCurrentClient;
    }
    
    public void NomPays() {
        try {
            Statement st = ConnexionBD.getConnexion().createStatement();
            ResultSet rs = st.executeQuery("select `nom_pays`,`coupe_de_la_Ligue` from `pays`");
            while (rs.next()) {
                pays.add(new Pays(rs.getString("nom_pays"),rs.getBoolean("Coupe_de_la_Ligue")));
            }
            
        } catch (Exception ex) {
            
        }
    }
    
    
    
    public String ajoutPays(String nom,String bool) {
        try {
            ArrayList<Integer> list = new ArrayList();
            Statement st = ConnexionBD.getConnexion().createStatement();
            ResultSet rs = st.executeQuery("INSERT INTO Pays (Nom_Pays, Coupe_de_la_Ligue) VALUES (\'"+nom+"\', \'"+bool+"\');");
            return "ça marche";
        } catch (Exception ex) {
            return "nope";
        }
    }
    
    public ArrayList<Pays> getPays() {
        return pays;
    }   
}