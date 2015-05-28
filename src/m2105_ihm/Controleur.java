/*
 * Module 2105 : module IHM : Carnet d'adresse
 */
package m2105_ihm;

import m2105_ihm.nf.Contact;
import m2105_ihm.nf.GroupeContacts;
import m2105_ihm.nf.NoyauFonctionnel;
import m2105_ihm.nf.Evenement;
import m2105_ihm.nf.Mois;
import m2105_ihm.nf.Region;

import m2105_ihm.ui.CarnetUI;
import m2105_ihm.ui.FenetreUI;
import m2105_ihm.ui.PlanningUI;
import m2105_ihm.ui.BoiteDialogUI;

/**
 *
 * @author IUT2
 */
public class Controleur {
    
    /*
     * Noyau Fonctionnel
     */    
    NoyauFonctionnel nf;
            
    /*
     * Composants
     */
    private CarnetUI carnetUI;
    private FenetreUI fenetre;
    private PlanningUI planningUI;
    private BoiteDialogUI boiteUI;

    /**
     * Constructeur de la fenêtre principale
     */
    public Controleur() {
        initUI();
        initContent();
    }
    
    /**
     * Action créer un nouveau contact
     */
    public void creerContact() {
        
        Contact c = new Contact();
        
        c.setDateNaissance(1, Mois.JANVIER, 1900);
        c.setNom("Nouveau");
        c.setPrenom("Contact");
        c.setNumeroTelephone("");
        c.setEmail("");
        c.setRegion(Region.ALSACE);
        carnetUI.ajouterContact(c);
        nf.addContact(c);
        
    }

    /**
     * Action supprimer contact
     */
    public void supprimerContact() {
        
        
        if (boiteUI.afficherConfirmation(fenetre,carnetUI.getSelectedContact())) {
        nf.removeContact(carnetUI.getSelectedContact());
        carnetUI.retirerContact(carnetUI.getSelectedContact());
        
        }
    }
    
    /**
     * Action créer un groupe de contacts
     */
    public void creerGroupe() {
        
        GroupeContacts g = new GroupeContacts();
        
        g.setNom("Nouveau Groupe");
        
        carnetUI.ajouterGroupe(g);
    }

    /**
     * Action supprimer un groupe de contacts
     */
    public void supprimerGroupe() {
        
        
        
        if (boiteUI.afficherConfirmation(fenetre,carnetUI.getSelectedGroupe())) {
        nf.removeGroupe(carnetUI.getSelectedGroupe());
        carnetUI.retirerGroupe(carnetUI.getSelectedGroupe());
        
        }
    }
    
    /**
     * Crée un nouvel événement
     */
    public void creerEvenement() {
    
       /** Projet **/
       
    }

    /**
     * Supprime un événement existant
     */
    public void supprimerEvenement() {
       
       /** Projet **/
       
    }
    
    /**
     * Ajouter un participant à un événement
     */
    public void ajouterParticipantEvenement() {
    
       /** Projet **/
           
    }

    /**
     * Retire un participant d'un événement
     */
    public void retirerParticipantEvenement() {
    
       /** Projet **/
           
    }

    /**
     * Met à jour la base de données
     */
    public void enregistrer() {
        nf.updateDB();
        
    }    
        
    /**
     * Quitter l'application sans enregistrer les modifications
     */
    public void quitter() {
        System.exit(0);
    }

    /**
     * Création des composants constituant la fenêtre principale
     */
    private void initUI() {
        /* Onglets */
        carnetUI = new CarnetUI(this);
        planningUI = new PlanningUI(this);

        /* Fenêtre principale */
        fenetre = new FenetreUI(this);
        fenetre.addTab(carnetUI, "Carnet");     // onglet carnet
        fenetre.addTab(planningUI, "Planning"); // onglet planning
        fenetre.afficher();
    }
        
    /**
     * Alimente la liste avec la liste des contacts existants
     */
    private void initContent() {
        nf = new NoyauFonctionnel();
                
        for(Contact c : nf.getContacts()) {
            carnetUI.ajouterContact(c);
        }
        
        for(GroupeContacts g : nf.getGroupes()) {
            carnetUI.ajouterGroupe(g);
        }
        
        for(Evenement e : nf.getEvenements()) {
            planningUI.ajouterEvt(e);
        }
        
        carnetUI.show();
    }
    
    public void setContactSelected(boolean selected) {
        fenetre.setMenuContactSelected(selected);
        
    }
    
    public void setEvtSelected(boolean selected) {
        fenetre.setMenuEvenementSelected(selected);
    }    
}