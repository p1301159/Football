
package football;

import java.util.ArrayList;

/**
 *
 * @author p1301159
 */
public class Pays {
    private String Nom;
    private boolean coupe;
    private ArrayList<Equipes> equipes;

    public Pays(String Nom, boolean coupe) {
        this.Nom = Nom;
        this.coupe = coupe;
    }    

    public String getNom() {
        return Nom;
    }

    public boolean isCoupe() {
        return coupe;
    }
}
