/*
 * Module 2105 : module IHM : Carnet d'adresse
 */
package m2105_ihm.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import m2105_ihm.nf.Contact;
import m2105_ihm.nf.Evenement;
import m2105_ihm.nf.Mois;

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
    private JLabel              labelCurrentDate = new JLabel();
    private JPanel          panelCorpsInfoEvt = new JPanel();
    private JPanel              panelNomEvt = new JPanel();
    private JPanel              panelDateEvt = new JPanel();
    private JPanel              panelParticipants = new JPanel();
    private JPanel                  panelListeParticipant = new JPanel();
    
    private JButton buttonTest = new JButton();
    

    
    private GregorianCalendar calendar = new GregorianCalendar();
    
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
       
    
    
    buttonTest.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newEvt();
            }
        });
    
    
    
    
    
    
    
    ///////////////////////////
    /////// Remplissage ///////
    ///////////////////////////
    
    
    //panelDateActuelle.add(new JButton("test"));
    //panelCorpsInfoEvt.add(new JButton("test"));
    panelNomEvt.add(new JButton("test"));
    panelDateEvt.add(new JButton("test"));
    //panelParticipants.setBackground(Color.red);
    panelListeParticipant.add(buttonTest);
    
    
    
        
    
    
    
    
    
    
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
        
        this.add(panelCorpsInfoEvt, BorderLayout.CENTER);
            panelDateActuelle.add(labelCurrentDate);
            //panelDateActuelle.setBorder(new Border());
        this.add(panelDateActuelle, BorderLayout.NORTH);

    }
    
    /**
     * Crée et positionne les composants graphiques constituant l'interface
     */    
    private void initUIComponents() {
        
        this.labelCurrentDate.setText("  Date Actuelle : " 
                + calendar.get(Calendar.DAY_OF_MONTH) 
                + " / "
                + (calendar.get(Calendar.MONTH)+1)
                + " / "
                + (calendar.get(Calendar.YEAR)));
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
    
    
    public static Evenement newEvt() {
        
        final JFrame fenetre = new JFrame();
        fenetre.setLayout(new BorderLayout());
        final JPanel corps = new JPanel();
        final GregorianCalendar g = new GregorianCalendar();
        
        fenetre.setSize(new Dimension(250,200));

          Mois[] months = Mois.values();
        
          

        corps.setLayout(new GridLayout(5,2));
        corps.add(new JLabel("Nom"));
        final JTextField nomEvt = new JTextField();
        corps.add(nomEvt);
        corps.add(new JLabel("Jour"));
        final JComboBox comboJour = new JComboBox();
        for (int i = 1; i< 31; i++) {
            comboJour.addItem(Integer.toString(i));
        }
        corps.add(comboJour);
        
        
        
        
        
        corps.add(new JLabel("Mois"));
        final JComboBox comboMois = new JComboBox();
        for (Mois m : months) {
            comboMois.addItem(m.toString());
        }
        corps.add(comboMois);
        
        
        corps.add(new JLabel("Annee"));
        final JComboBox comboAnnee = new JComboBox();
        for (int i = g.get(Calendar.YEAR) - 50; i< g.get(Calendar.YEAR) +49; i++) {
            comboAnnee.addItem(Integer.toString(i));
        }
        corps.add(comboAnnee);
        

        
        final JButton butAnnuler = new JButton("Annuler");
        final JButton butValider = new JButton("Valider");
                
        corps.add(butValider);
        corps.add(butAnnuler);
        
        
        fenetre.add(corps, BorderLayout.CENTER);
        fenetre.add(new JLabel("                     Nouvel Evenement"), BorderLayout.NORTH);
        
        fenetre.setVisible(true);
        
        butValider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Evenement evt = new Evenement(
                nomEvt.getText(),
                comboJour.getSelectedIndex() +1,
                (Mois) comboMois.getSelectedItem(), // BUG
                comboAnnee.getSelectedIndex() + 1965
                );
            }
        });
        
        butAnnuler.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            fenetre.setVisible(false);
            }
        });
        
        
        
        
        
        return null;
        
        
    }
    
    
    
}
