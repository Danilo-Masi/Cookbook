package ricettario.modello;

import java.util.ArrayList;
import java.util.List;

public class Archivio {
    
    private List<Pietanza> pietanze = new ArrayList<Pietanza>();
    
    //Metodo per rendere accessibile la pietanza all'esterno
    public List<Pietanza> getPietanze() {
        return pietanze;
    }
    
    //Metodo per aggiungere una pietanza nella lista delle pietanze
    public void aggiungiPietanza(Pietanza pietanza) {
        this.pietanze.add(pietanza);
    }
    
    //Metodo per ricercare una pietanza in base alla categoria selezionata dall'utente
    public List<Pietanza> cercaPietanzePerCategoria(String categoria) {
        List<Pietanza> listaFiltrata = new ArrayList<Pietanza>();
        for (Pietanza pietanza : this.pietanze) {
            if(pietanza.getCategoria().equals(categoria)) {
                listaFiltrata.add(pietanza);
            }
        }
        return listaFiltrata;
    }
    
    //Metodo per ricercare la pietanza piu simile a quella selezionata dall'utente
    public Pietanza cercaPietanzaSimile(Pietanza pietanza) {
        Pietanza pietanzaSimile = null;
        for (Pietanza altraPietanza : pietanze) {
            if(!altraPietanza.getNome().equals(pietanza.getNome())) {
                if(pietanzaSimile == null || (Math.abs(altraPietanza.getKcal() - pietanza.getKcal())  < Math.abs(pietanzaSimile.getKcal() - pietanza.getKcal()))) {
                    pietanzaSimile = altraPietanza;
                }
            }
        }
        return pietanzaSimile;
    }
    
}
