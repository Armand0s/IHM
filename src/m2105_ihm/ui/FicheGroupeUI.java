/*
 * Module 2105 : module IHM : Carnet d'adresse
 */
package m2105_ihm.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import m2105_ihm.nf.Contact;
import m2105_ihm.nf.GroupeContacts;
import m2105_ihm.nf.Symbole;

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
    
    
    private String[]     colonnes = {"Nom","Prenom","Telephone"};
    private JTextField   txNomG;
    private JLabel       labNomG;
    
    private JTable       tabContact;
    private DefaultTableModel model = new DefaultTableModel(); 
    
    private ButtonGroup  symboleGroup;
    private HashMap<Symbole, JCheckBox> checkboxes = new HashMap();
    
    public JButton       btEffacer;
    public JButton       btValider;

    
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
        
        // Nom groupe
        labNomG = new JLabel("Nom du groupe");
        txNomG = new JTextField(20);
        
        /* Table */
        model = new DefaultTableModel(); 
        model.setColumnIdentifiers(colonnes);
        tabContact = new JTable(model);
        add(tabContact.getTableHeader());
        add(tabContact);
        
        btValider = new JButton("Valider");
        btEffacer = new JButton("Effacer");
        
        zoneDessin = new ZoneDessinUI();
        
        
        this.add(labNomG);
        this.add(txNomG);
        //this.add(tabContact.getTableHeader());
        this.add(tabContact);
        this.add(zoneDessin);
        
        /* Check box symboles */
        symboleGroup = new ButtonGroup();
        for (Symbole s : Symbole.values()){
            checkboxes.put(s, new JCheckBox(s.toString()));
            symboleGroup.add(checkboxes.get(s));
            this.add(checkboxes.get(s));
        }
        
        

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
        /* JTable */
        String [] obj = new String[3];
       
        model.setRowCount(0);
        for (Contact contact : groupe.getContacts()) {
            obj[0]=contact.getNom();
            obj[1]=contact.getPrenom();
            obj[2]=contact.getNumeroTelephone();
            
            model.addRow(obj);
        }
        
        txNomG.setText(groupe.getNom());
        
        /* Symbole */
        ButtonModel selection = symboleGroup.getSelection();
        for (Symbole s : Symbole.values()){
            if (Arrays.asList(groupe.getSymboles()).contains(s)){
                checkboxes.get(s).setSelected(true);
            } else {
                checkboxes.get(s).setSelected(false);
            }
            
        }
        
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
