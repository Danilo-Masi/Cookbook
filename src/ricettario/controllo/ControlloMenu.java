package ricettario.controllo;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import ricettario.Applicazione;
import ricettario.modello.Archivio;
import ricettario.modello.Costanti;
import ricettario.persistenza.DAOException;
import ricettario.persistenza.IDAOArchivio;

//Inseriamo le azioni di controllo della classe Frame
public class ControlloMenu {

    //Inizializza l'azione Carica
    private Action azioneCarica = new AzioneCarica();
    //Inizializza l'azione Esci
    private Action azioneEsci = new AzioneEsci();

    //Classe per  creare l'azione Esci
    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Clicca per uscire");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    //Classe per creare l'azione Carica
    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Clicca per caricare un file");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Q"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getInstance().getdAOArchivio();
            try {
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getInstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getFrame().mostraMessaggio("Caricato l'archivio contenente " + archivio.getPietanze().size() + " pietanze.");
                //Abilita il pulsante di ricerca tipologia una volta caricato l'archivio
                Applicazione.getInstance().getControlloPrincipale().getAzioneCercaTipologia().setEnabled(true);
                //Abilita il pulsante di ricerca pietanza simile una volta caricato l'archivio
                Applicazione.getInstance().getControlloPrincipale().getAzioneCercaPietanzaSimile().setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impossibile caricare l'archivio " + ex.getMessage());
            }
        }
    }

    //Rende visibile all'esterno l'azione Carica
    public Action getAzioneCarica() {
        return azioneCarica;
    }

    //Rende visibile all'esterno l'azione Esci
    public Action getAzioneEsci() {
        return azioneEsci;
    }

}
