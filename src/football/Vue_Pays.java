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
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author p1301159
 */
public class Vue_Pays extends Abstractpano implements ActionListener{
    private GridBagConstraints cont = new GridBagConstraints(); 
    private JButton add;
    private JLabel lab1;
    //private JMenuItem pays[];
    private ArrayList<JButton> button;
    private MesRequetes req;
    private int nbButton=0;
    private MaFenetre fen;
    
    public Vue_Pays(MaFenetre f) {
        this.fen=f;
       this.setPreferredSize(new Dimension(400, 200));
       this.setLayout(new GridBagLayout());
       cont.fill=GridBagConstraints.HORIZONTAL;
       button=new ArrayList<>();
       req=new MesRequetes();
       init();
    }    
    
    @Override
    public void init(){
        //int i=0;
        add=new JButton("Add new Pays");  
        add.addActionListener(this);
        lab1=new JLabel("Pays"); 
        
        cont.gridx=2;
        cont.gridy=0;
        cont.gridwidth=4;
        this.add(lab1,cont);
        cont.gridwidth=1;
        
        initBoutton();
        
        for (int i = 1; i < button.size()+1; i++) {
            cont.gridx = 2;
            cont.gridy = i;
            this.add(button.get(i-1), cont);
        }
        
        cont.gridx=2;
        cont.gridy=button.size()+1;
        this.add(add,cont);
    }
    
    public void initBoutton(){
        for(int i=0;i<req.getPays().size();i++){
            button.add(new JButton(req.getPays().get(i).getNom()));
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            fen.setAbspano(new Vue_NewPays(fen));
            fen.setContentPane(fen.getAbspano());
            fen.pack();
        }
    }
}
