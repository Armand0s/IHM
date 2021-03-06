/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2105_ihm.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import m2105_ihm.Controleur;
import m2105_ihm.nf.Contact;
import m2105_ihm.nf.Evenement;
import m2105_ihm.nf.Mois;


/**
 *
 * @author Armand
 */
public class DialogCreerEvtUI extends JFrame {
    
    
        //private JFrame this = new JFrame();
        private JPanel corps = new JPanel();
        private JTextField nomEvt = new JTextField();
        private JComboBox comboJour = new JComboBox();
        private JComboBox comboMois = new JComboBox();
        private JComboBox comboAnnee = new JComboBox();
        private JButton butAnnuler = new JButton("Annuler");
        private JButton butValider = new JButton("Valider");
        private GregorianCalendar g = new GregorianCalendar();
        
        private BoiteDialogUI boiteUI;        
        private Controleur controleur;
        
        
        private Evenement evt;
        
        
        
        
        public DialogCreerEvtUI(Controleur controleur) {
            this.controleur = controleur;
            
            
            initComponent();
            initListeners();
                    
            this.setVisible(true);
        }
    
        
        public void initComponent() {
    
            

        this.setSize(new Dimension(250,200));
        this.setLayout(new BorderLayout());
        
        this.add(new JLabel("                     Nouvel Evenement"), BorderLayout.NORTH);
          
        
          

        corps.setLayout(new GridLayout(5,2));
        
        
        /////////////////////
        /// Nom evenement ///
        /////////////////////
        corps.add(new JLabel("Nom"));
        corps.add(nomEvt);
        
        //////////////////////
        /// Jour evenement ///
        //////////////////////
        
        corps.add(new JLabel("Jour"));
        for (int i = 1; i< 31; i++) {
            comboJour.addItem(Integer.toString(i));
        }
        corps.add(comboJour);
        
        //////////////////////
        /// Mois evenement ///
        //////////////////////
        
        Mois[] months = Mois.values();
        corps.add(new JLabel("Mois"));
        for (Mois m : months) {
            comboMois.addItem(m);
        }
        corps.add(comboMois);
        
        ///////////////////////
        /// Annee evenement ///
        ///////////////////////
        
        corps.add(new JLabel("Annee"));
        for (int i = g.get(Calendar.YEAR) - 50; i< g.get(Calendar.YEAR) +49; i++) {
            comboAnnee.addItem(Integer.toString(i));
        }
        corps.add(comboAnnee);
        
        //////////////
        /// Button ///
        //////////////
        
        
                
        corps.add(butValider);
        corps.add(butAnnuler);
        
        
        
        this.add(corps, BorderLayout.CENTER);
                
        
                
        }
        
        
        
        
        public void initListeners() {
            
            butValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                construireEvt();
                    close();
                
            }
        });
        
        butAnnuler.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }
        });
 
        }
    
        public void construireEvt() {

            
            Evenement evt = new Evenement(
                nomEvt.getText(),
                comboJour.getSelectedIndex() +1,
                (Mois) comboMois.getSelectedItem(),
                comboAnnee.getSelectedIndex() + 1965
                );
            
            if (evt.getIntitule().isEmpty()){
                evt.setIntitule("Sans nom");
            }
            
            this.evt = evt;
            
            System.out.println(this.evt.toString());

            
            
        }
        
        public void close() {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        
        
        public Evenement getEvt() {
            return evt;
        }
    
}
