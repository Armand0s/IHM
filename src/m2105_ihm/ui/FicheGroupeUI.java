/*
 * Module 2105 : module IHM : Carnet d'adresse
 */
package m2105_ihm.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import m2105_ihm.nf.Contact;
import m2105_ihm.nf.GroupeContacts;

/**
 *
 * @author IUT2
 */
public class FicheGroupeUI extends javax.swing.JPanel {
    /*
     * Composants graphiques constituants l'interface
     */
    
    
    
    private CarnetUI     carnet;
    private ZoneDessinUI zoneDessin;
    
    
    
    private JLabel labNomG;
    private JTable tabContact;
    private JTextField txNomG;
    public JButton btEffacer;
    public JButton btValider;
    private DefaultTableModel model = new DefaultTableModel(); 
    
    /**
     * Creates new form CarnetUI
     */
    public FicheGroupeUI(CarnetUI carnet) { 
        super();
       
        this.carnet = carnet;
        
        initUIComponents();    
        initListeners();
    }

    /**
     * Crée et positionne les composants graphiques constituant l'interface
     */
    private void initUIComponents() {
        
        /** TP 2 : à compléter **/
        
        labNomG = new JLabel("Nom du groupe");
        
        txNomG = new JTextField(20);

        String[] colonnes =  { "Nom", "Prenom" }; 
        
        model.setColumnIdentifiers(colonnes);
        //String[] st = {"a","b"};
        //model.addRow(st);
        tabContact = new JTable(model);
        
        
        btValider = new JButton("Valider");
        btEffacer = new JButton("Effacer");
        
        zoneDessin = new ZoneDessinUI();
        
        
        this.add(labNomG);
        this.add(txNomG);
        //this.add(tabContact.getTableHeader());
        this.add(tabContact);
        
        
        
        this.add(zoneDessin);
        this.add(btValider);
        this.add(btEffacer);
                
        /*this.add(new javax.swing.JButton("Hello !"));
          this.add(new javax.swing.JLabel("Fiche groupe"));
         */
    }

    /**
     * Affecte des valeurs au formulaire de fiche groupe de contacts
     * @param groupe groupe de contacts
     * @return
    */    
    public boolean setValues(GroupeContacts groupe) {
        if (groupe == null) {return false; }
        
        /** TP 2 : à compléter **/
        String[] values = new String[2];
        Contact[] ct = groupe.getContacts();
        model.setRowCount(0);
        for(int i =0; i<groupe.getContacts().length;i++) {
            
            values[0] = ct[i].getNom();
            values[1] = ct[i].getPrenom();
            model.addRow(values);
        }
        
        txNomG.setText(groupe.getNom());
        
        return true;
    }
    
    /**
     * Retourne les valeurs associées au formulaire de fiche groupe de contacts
     * @return
     */    
    public boolean getValues(GroupeContacts groupe) {
        if (groupe == null) { return false; }
        
        /** TP 2 : à compléter **/
        
        /*
         * Ne pas s'occuper des membres du groupe car traité via des
         * commandes du menu qui appelera setValues
         */
        
        groupe.setNom(txNomG.getText());
        
        
        
        return true;
    }
    
    /**
     * Initialise la gestion des événements
     */
    public void initListeners() {        
        /*
         * Réagit aux évènements produits par le bouton effacer
         */
         btEffacer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                carnet.setGroupeModified(false);
            }
        });
        btValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                carnet.setGroupeModified(true);
            }
            
            
        });
    }    
}
