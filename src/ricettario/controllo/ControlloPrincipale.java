package ricettario.controllo;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import ricettario.Applicazione;
import ricettario.modello.Archivio;
import ricettario.modello.Costanti;
import ricettario.modello.Modello;
import ricettario.modello.Pietanza;
import ricettario.vista.VistaPrincipale;

//Inseriamo le azioni di controllo della classe VistaPrincipale
public class ControlloPrincipale {

    //Inizializza l'azione cerca per tipologia
    private Action azioneCercaTipologia = new AzioneCercaTipologia();
    //Inizializza l'azione cerca pietanza simile
    private Action azioneCercaPietanzaSimile = new AzioneCercaPietanzaSimile();

    //Classe per l'azione di ricerca per tipologia
    private class AzioneCercaTipologia extends AbstractAction {

        public AzioneCercaTipologia() {
            this.putValue(NAME, "Cerca tipologia");
            this.putValue(SHORT_DESCRIPTION, "Cerca tutte le pietanze della tipologia scelta");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String categoria = vistaPrincipale.getComboCategorie();
            if (categoria.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona una categoria");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<Pietanza> pietanzeFiltrate = archivio.cercaPietanzePerCategoria(categoria);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, pietanzeFiltrate);
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
        }
    }

    //Classe per l'azione di ricerca della pietanza simile
    private class AzioneCercaPietanzaSimile extends AbstractAction {
        
        public AzioneCercaPietanzaSimile() {
            this.putValue(NAME, "Cerca simile");
            this.putValue(SHORT_DESCRIPTION, "Cerca la pietanza simile a quella selezionata");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_P);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl P"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {    
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if(rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Devi selezionare una pietanza dalla tabella");
                return;
            }
            Modello modello = Applicazione.getInstance().getModello();
            List<Pietanza> listaFiltrata = (List<Pietanza>) modello.getBeans(Costanti.LISTA_FILTRATA);
            Pietanza pietanzaSelezionata = listaFiltrata.get(rigaSelezionata);
            Archivio archivio = (Archivio) modello.getBeans(Costanti.ARCHIVIO);
            Pietanza pietanzaSimile = archivio.cercaPietanzaSimile(pietanzaSelezionata);
            if(pietanzaSimile == null) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Non esiste alcuna pietanza simile");
                return;
            }
            Applicazione.getInstance().getFrame().mostraMessaggio("La pietanza piu simile a " + pietanzaSelezionata.getNome() + " è " + pietanzaSimile.getNome());
        }
    }

    //Metodo per rendere visibile l'azione di ricerca per tipolgia
    public Action getAzioneCercaTipologia() {
        return azioneCercaTipologia;
    }

    //Metodo per rendere visibile l'azione di ricerca pietanza simile
    public Action getAzioneCercaPietanzaSimile() {
        return azioneCercaPietanzaSimile;
    }

}
