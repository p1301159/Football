/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package football;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author p1301159
 */
public class Vue_NewPays extends Abstractpano implements ActionListener{
    
    //private JCheckBox coupe;
    private JCheckBox ligue;
    //private JCheckBox ch1;
    //private JCheckBox ch2;
    private JButton creer;
    private JLabel la;
    private JTextField tf;
    private MesRequetes req;
    private GridBagConstraints cont;
    //private MaFenetre fen;

    public Vue_NewPays(MaFenetre f) {
        this.fen=f;
       //this.coupe = new JCheckBox("Coupe");
       this.ligue = new JCheckBox("Ligue");
       //this.ch1 = new JCheckBox("Championat division 1");
       //this.ch2 = new JCheckBox("Championat division 2");
       this.creer=new JButton("Creer");
       this.la=new JLabel("Nom Pays");
       this.tf=new JTextField();
       this.req=new MesRequetes();
       init();
    }

    @Override
    public void init(){
        //coupe.addActionListener(this);
        ligue.addActionListener(this);
        //ch1.addActionListener(this);
        //ch2.addActionListener(this);
        creer.addActionListener(this);
        tf.addActionListener(this);
        
        this.setLayout(new GridBagLayout());
        cont = new GridBagConstraints();
        cont.fill=GridBagConstraints.HORIZONTAL;
        
        cont.gridx=0;
        cont.gridy=0;
        this.add(la,cont);
        
        cont.gridx=1;
        cont.gridy=0;
        cont.gridwidth=2;
        this.add(tf,cont);
        
        cont.gridx=2;
        cont.gridy=1;
        this.add(ligue,cont);
        
        cont.gridx=1;
        cont.gridy=3;
        this.add(creer,cont);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==creer){
            req.ajoutPays(tf.getText(), ligue.isSelected());
            fen.setAbspano(new Vue_Pays(fen));
            fen.setContentPane(fen.getAbspano());
            fen.pack();
        }
    }
}
