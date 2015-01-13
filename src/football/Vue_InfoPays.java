/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package football;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 *
 * @author Ange
 */
public class Vue_InfoPays extends Abstractpano implements ActionListener{

    private JLabel lab;
    private JButton coupe;
    private JButton ligue;
    private JButton ch1;
    private JButton ch2;
    private GridBagConstraints cont = new GridBagConstraints(); 
    private MesRequetes req;
    
    public Vue_InfoPays(MaFenetre f, String Pays) {
        this.fen = f;
        this.lab=new JLabel(Pays);
        this.coupe = new JButton("Coupe");
        this.ch1 = new JButton("Championat division 1");
        this.ch2 = new JButton("Championat division 2");
        this.req = new MesRequetes();
        this.setPreferredSize(new Dimension(400, 300));
        this.setLayout(new GridBagLayout());
        cont.fill = GridBagConstraints.HORIZONTAL;
        init();
    }

    @Override
    public void init() {
        
        cont.gridx=0;
        cont.gridy=0;
        this.add(lab,cont);
        
        cont.gridx=0;
        cont.gridy=1;
        this.add(coupe,cont);
        
        for (int i = 0; i < req.getPays().size(); i++) {
            if (req.getPays().get(i).getNom().equals(lab.getText()) && req.getPays().get(i).isCoupe() == true) {
                this.ligue = new JButton("Ligue");
                cont.gridx = 1;
                cont.gridy = 1;
                this.add(ligue, cont);
            }
        }
        
        cont.gridx=0;
        cont.gridy=2;
        this.add(ch1,cont);
        
        cont.gridx=1;
        cont.gridy=2;
        this.add(ch2,cont);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
