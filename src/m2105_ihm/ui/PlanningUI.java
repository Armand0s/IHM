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
import java.util.HashMap;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.TreeSelectionModel;

import m2105_ihm.Controleur;
import m2105_ihm.nf.Evenement;

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
    private HashMap<Evenement,JButton> hashEvt         = new HashMap<>();
    
    private JPanel      panelCorpsCalendar;
    //                      calendar
    private JPanel          panelCorpsEvtSuivis;
    private JPanel              panelEvtSuite;
    private JPanel      panelCorpsInfo;
    private JPanel          panelCorpsInfoEvt;
    private JPanel              panelNomEvt;
    private JPanel              panelDateEvt;
    private JPanel              panelParticipants;
    private JPanel                  panelListeParticipant;
    private JPanel          panelDateActuelle;
    
    private JPanel panelCentreCorps  = new JPanel();
    private JPanel   panelDate    = new JPanel();
    private JPanel   panelGauche     = new JPanel();
    private JPanel   panelInfo    = new JPanel();
    private JPanel   panelCorps   = new JPanel();
    

    /** 
     * Constructeur : initialise les composants de l'IHM pour les événements
     * @param une instance du controleur
     */
    public PlanningUI(Controleur ctrl) {
        super();
        
        this.controleur = ctrl;
        
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
        

        
    panelCorpsCalendar= new JPanel();
        //                      calendar
        panelCorpsEvtSuivis= new JPanel();
            panelEvtSuite= new JPanel();
    panelCorpsInfo= new JPanel();
        panelCorpsInfoEvt= new JPanel();
            panelNomEvt= new JPanel();
            panelDateEvt = new JPanel();
            panelParticipants= new JPanel();
                panelListeParticipant= new JPanel();
        panelDateActuelle= new JPanel();
        
        
    panelCorpsCalendar.                 setLayout(new BorderLayout()); // WEST      of    this
        //                              calendar                       // NORTH     of    panelCorpsCalendar
        panelCorpsEvtSuivis.            setLayout(new GridLayout());   // CENTER    of    panelCorpsCalendar
            //panelEvtSuite.              setLayout(new BorderLayout()); // Cellule   of    panelCorpsEvtSuivis
    panelCorpsInfo.                     setLayout(new BorderLayout()); // EAST      of    this
        panelNomEvt.                    setLayout(new GridLayout()); // 
        panelCorpsInfoEvt.              setLayout(new BorderLayout()); // 
        panelParticipants.              setLayout(new BorderLayout()); // 
            panelListeParticipant.      setLayout(new GridLayout()); // 
        panelDateActuelle.              setLayout(new BorderLayout()); // NORTH     of    panelCorpsInfo
        
        
        
        
        /*panelCentreCorps  = new JPanel();
        panelDate    = new JPanel();
        panelGauche     = new JPanel();
        panelInfo    = new JPanel();
        panelCorps   = new JPanel();*/
        
        panelDate.   setLayout(new BorderLayout()); // NORTH
        panelCorps.  setLayout(new BorderLayout()); // CENTER
            panelInfo.   setLayout(new BorderLayout()); // NORTH
            panelGauche.    setLayout(new GridLayout(20,1)); // CENTER
            panelCentreCorps. setLayout(new GridLayout(20,1)); // WEST
            
        panelDate.   setBackground(Color.orange); // Rouge
        panelCorps.  setBackground(Color.GREEN); // Vert
            panelInfo.   setBackground(Color.lightGray); // Bleu
            panelGauche.    setBackground(Color.YELLOW); // jaune
            panelCentreCorps. setBackground(Color.PINK); // Rose
        
        
        // Paneldate
        
        // PanelCentreCorps (participants)

        panelCentreCorps.add(new JLabel("Participants : "));
        for (int i = 0; i< 9;i++) {
            panelCentreCorps.add(new JLabel("Particippant n°" + i));
        }
        panelCentreCorps.setPreferredSize(new Dimension(120,10));
        
        // PanelInfo (Info sur Evt
        
        panelInfo.add(new JLabel("Nom evenement : Anniv Machin"), BorderLayout.NORTH);
        panelInfo.add(new JLabel("Date evenement : 18/06/2015"), BorderLayout.SOUTH);
        panelInfo.setPreferredSize(new Dimension(10,50));
        
        
        
        // PanelCorps
        
        
        
        
        panelGauche.add(new JLabel(" Choisir la date "));
        panelGauche.add(calendar);
        panelGauche.add(new JLabel("Evenenemets : "));
        panelGauche.add(new JButton("Anniv Machin"));
        panelGauche.setAutoscrolls(true);
        panelGauche.add(new JButton("Anniv Truc"));
        panelGauche.add(new JButton("Anniv Gus"));
        panelGauche.add(new JButton("Anniv Machin"));
        panelGauche.add(new JButton("Anniv Num"));
        
        // ADD
        
            panelCorps.add(panelInfo,BorderLayout.NORTH);
            panelCorps.add(panelCentreCorps,BorderLayout.CENTER);
        this.add(panelGauche,BorderLayout.WEST);
        this.add(panelCorps, BorderLayout.CENTER);

        

        
        
        
        
        
        
        

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
