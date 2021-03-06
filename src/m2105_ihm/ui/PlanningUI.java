/*
 * Module 2105 : module IHM : Carnet d'adresse
 */
package m2105_ihm.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.TreeSelectionModel;

import m2105_ihm.Controleur;
import m2105_ihm.nf.Evenement;
import m2105_ihm.nf.NoyauFonctionnel;

/**
 *
 * @author IUT2
 */
public class PlanningUI extends JPanel {
    /**
     * Creates new form CarnetUI
     */
    private Controleur                 controleur;
    private FicheEvtUI                 ficheEvt;
    private JTextField                 calendar        = new CalendarUI();
    //private HashMap<Evenement,JButton> hashEvt         = new HashMap<>();
    
    private JPanel      panelCorpsCalendar = new JPanel();
    //                      calendar
    private JPanel          panelCorpsEvt= new JPanel();
    //private JPanel              panelEvtSuite;
    private JPanel      evtUI = new FicheEvtUI(this);
   
    private Cal test =  new Cal();

    private NoyauFonctionnel nf;
    
    /** 
     * Constructeur : initialise les composants de l'IHM pour les événements
     * @param une instance du controleur
     */
    public PlanningUI(Controleur ctrl, NoyauFonctionnel nf) {
        super();
        
        this.controleur = ctrl;
        this.nf = nf;
        
        initComponents();        
    }

    /**
     * Crée et place les composants graphiques de l'interface
     */
    private void initComponents() {
        /*
         * Fiche événement
         */        
        ficheEvt = new FicheEvtUI(this);
        this.setLayout(new BorderLayout());
        /*GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.gridheight = 2;*/
        
        
   
        
    // this : BorderLayout
    panelCorpsCalendar.setLayout(new BorderLayout());               // WEST (with preferedSize)
        //      calendar                                                // NORTH
        panelCorpsEvt.setLayout(new GridLayout());                      // CENTER
            //JPanel              panelEvtSuite;                            // add
        

    GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx=1;
        c.ipady=100;
        c.gridx=1;
                

        //panelCorpsCalendar.add(new JButton("test"));
    panelCorpsEvt.add(new JButton("test"));    
    //panelCorpsInfo.add(new JButton("test"));

    
    
    
    
    test.setPreferredSize(new Dimension(390,220));
    
    this.add(evtUI, BorderLayout.EAST); 
        panelCorpsCalendar.add(panelCorpsEvt, BorderLayout.CENTER);
        
        panelCorpsCalendar.add(test, BorderLayout.NORTH);
        panelCorpsCalendar.setPreferredSize(new Dimension(390,200));
    this.add(panelCorpsCalendar, BorderLayout.WEST);
        
    System.out.println(test.getComponents().length);
    JPanel j = (JPanel) test.getComponent(0);
    JLabel l = (JLabel) j.getComponent(j.getComponents().length-1);
    System.out.println(l.getText());
    

    
     /*     
    
    
    test.setPreferredSize(new Dimension(200,200));
    this.add(test);    
                
      */         
                
                
       
        
    }  
    
    
    /**
     * Ajoute une entrée dans la liste de événements
     * @param title texte affiché dans la liste pour un contact
     * @param Contact objet contact associé
     */
    public boolean ajouterEvt(Evenement evt) {
        if (evt == null) { return false; }
        
        /** Projet à completer **/
            
        return true;
    }
    
    /**
     * Retire une entrée dans l'arbre pour les contacts
     * @param Contact contact à retirer
     */    
    public boolean retirerEvt(Evenement evt) {
        if (evt == null) { return false; }
        
        /** Projet à completer **/
            
        return false;
    }
    
    /*
     * Retourne l'événement sélectionné
     */
    public Evenement getSelectedEvt() {    
        
        /** Projet à completer **/

        return null;
    }
}
