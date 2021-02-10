package ricettario.persistenza;

import ricettario.modello.Archivio;
import ricettario.modello.Costanti;
import ricettario.modello.Ingrediente;
import ricettario.modello.Pietanza;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {

        Archivio archivio = new Archivio();
        
        Pietanza pastaAlPesto = new Pietanza("Pasta al pesto", Costanti.PRIMO, 5.0);
        pastaAlPesto.aggiungiIngrediente(new Ingrediente("Pasta", 100, false, 400));
        pastaAlPesto.aggiungiIngrediente(new Ingrediente("Pesto", 10, true, 100));
        archivio.aggiungiPietanza(pastaAlPesto);
        
        Pietanza pastaAlleCozze = new Pietanza("Pasta alle cozze", Costanti.PRIMO, 10.0);
        pastaAlleCozze.aggiungiIngrediente(new Ingrediente("Pasta", 100, false, 400));
        pastaAlleCozze.aggiungiIngrediente(new Ingrediente("Cozze", 150, true, 500));
        archivio.aggiungiPietanza(pastaAlleCozze);
        
        
        Pietanza cotolotta = new Pietanza("Cotoletta", Costanti.SECONDO, 7.0);
        cotolotta.aggiungiIngrediente(new Ingrediente("Carne di pollo", 100, false, 200));
        cotolotta.aggiungiIngrediente(new Ingrediente("Pane sbriciolato", 50, true, 300));
        cotolotta.aggiungiIngrediente(new Ingrediente("Olio", 5, true, 500));
        archivio.aggiungiPietanza(cotolotta);
        
        return archivio;
    }

}
