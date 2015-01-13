/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package football;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author p1301159
 */
public class MaFenetre extends JFrame implements ActionListener{
    private GridBagConstraints cont; 
    private Abstractpano abspano;
    private Vue_NewPays vnp;
    private JMenuBar menuBar;
    private JMenuItem mi;
    private JMenu menu;
    
    public MaFenetre() {
       this.setTitle("Football");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setPreferredSize(new Dimension(400, 200));
       init();
    }
    
    public void init(){        
        menuBar=new JMenuBar();
        menu=new JMenu("Ficher");
        mi=new JMenuItem("Accueil");
        mi.addActionListener(this);
        menuBar.add(menu);
        menu.add(mi);
        this.setJMenuBar(menuBar);  
        abspano=new Vue_Pays(this);
        this.setContentPane(abspano);
        this.pack();
    }

    public void affiche(){
        abspano=new Vue_Pays(this);
    }

    public void setAbspano(Abstractpano abspano) {
        this.abspano = abspano;        
    }

    public Abstractpano getAbspano() {
        return abspano;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mi){
            this.setAbspano(new Vue_Pays(this));
            this.setContentPane(this.getAbspano());
            this.pack();
        }
    }
}
