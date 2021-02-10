package ricettario;

import javax.swing.SwingUtilities;
import ricettario.controllo.ControlloMenu;
import ricettario.controllo.ControlloPrincipale;
import ricettario.modello.Modello;
import ricettario.persistenza.DAOArchivioMock;
import ricettario.persistenza.IDAOArchivio;
import ricettario.vista.Frame;
import ricettario.vista.VistaPrincipale;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    public static Applicazione getInstance() {
        return singleton;
    }

    //Inizializziamo tutti gli oggetti che ci servono
    private Modello modello;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private IDAOArchivio dAOArchivio;
    
    //Rendiamo gli oggetti accessibili all'esterno

    public Modello getModello() {
        return modello;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public IDAOArchivio getdAOArchivio() {
        return dAOArchivio;
    }
    
    
    public void inizializza() {
        //Creazione dei componenti
        this.modello = new Modello();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.dAOArchivio = new DAOArchivioMock();
        //Inizializzazione dei componenti
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public static void main(String[] args) {
               
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }

}
