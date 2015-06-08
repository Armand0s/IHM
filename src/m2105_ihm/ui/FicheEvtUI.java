/*
 * Module 2105 : module IHM : Carnet d'adresse
 */
package m2105_ihm.ui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import m2105_ihm.nf.Mois;
import m2105_ihm.nf.Contact;
import m2105_ihm.nf.Evenement;

/**
 *
 * @author IUT2
 */
public class FicheEvtUI extends javax.swing.JPanel {
    
    /*
     * Attributs
     */
    private PlanningUI          planning;
    
    private JPanel          panelDateActuelle = new JPanel();
    private JPanel          panelCorpsInfoEvt = new JPanel();
    private JPanel              panelNomEvt = new JPanel();
    private JPanel              panelDateEvt = new JPanel();
    private JPanel              panelParticipants = new JPanel();
    private JPanel                  panelListeParticipant = new JPanel();
    
    /**
     * Creates new form CarnetUI
     */
    public FicheEvtUI(PlanningUI planning) {
        super();
        
        this.planning = planning;
        
        initUIComponents();
        initListeners();
    }

    /**
     * Initialise la gestion des événements
     */
    private void initListeners() {
        
        panelDateActuelle.setLayout(new BorderLayout());                // NORTH
        panelCorpsInfoEvt.setLayout(new GridBagLayout());               // CENTER
            panelNomEvt.setLayout(new BorderLayout());                      // add height = 1
            panelDateEvt.setLayout(new BorderLayout());                     // add height = 1
            panelParticipants.setLayout(new BorderLayout());                // add height = 3
                panelListeParticipant.setLayout(new GridLayout());              // CENTER     
    this.setLayout(new BorderLayout());
                
    panelDateActuelle.add(new JButton("test"));
    //panelCorpsInfoEvt.add(new JButton("test"));
    panelNomEvt.add(new JButton("test"));
    panelDateEvt.add(new JButton("test"));
    //panelParticipants.setBackground(Color.red);
    panelListeParticipant.add(new JButton("test"));
        
        GridBagConstraints c = new GridBagConstraints();
        c.ipadx=105;
        c.ipady=125;
        c.gridx=1;
    
    
    panelParticipants.add(new JLabel("Participants :"), BorderLayout.NORTH);
                panelParticipants.add(panelListeParticipant, BorderLayout.CENTER);
            panelCorpsInfoEvt.add(panelNomEvt,c);
            panelCorpsInfoEvt.add(panelDateEvt,c);
            c.ipady=250;
            panelCorpsInfoEvt.add(panelParticipants,c);
        this.add(panelDateActuelle, BorderLayout.NORTH);
        this.add(panelCorpsInfoEvt, BorderLayout.CENTER);

    }
    
    /**
     * Crée et positionne les composants graphiques constituant l'interface
     */    
    private void initUIComponents() {
        
        /** Projet : à compléter **/    
        
    }

    /**
     * Affecte des valeurs au formulaire pour un événement
     * @param Evenement un événement
     * @return
     */        
    public boolean setValues(Evenement event) {
        if (event == null) { return false; }            
                  
        /** Projet : à compléter **/
            
        return false;
    }

    /**
     * Retourne les valeurs associées au formulaire de fiche événement
     * @param Evenement événement à affecter
     * @return 
     */    
    public boolean getValues(Evenement event) {
        
        if (event == null) { return false; }
        
        /** Projet : à compléter **/
        
        return true;
    }
}
