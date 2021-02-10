package ricettario.persistenza;

import ricettario.modello.Archivio;
import ricettario.modello.Costanti;
import ricettario.modello.Ingrediente;
import ricettario.modello.Pietanza;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {

        Archivio archivio = new Archivio();
        
        //Inizializziamo una nuiva pietanza
        Pietanza pietanzaPastaAlleNoci = new Pietanza("Pasta alle noci", Costanti.PRIMO, 10.0);
        //Aggiungiamo gli ingredienti
        pietanzaPastaAlleNoci.aggiungiIngrediente(new Ingrediente("Pasta", 80, false, 400));
        pietanzaPastaAlleNoci.aggiungiIngrediente(new Ingrediente("Noci", 30, true, 200));
        pietanzaPastaAlleNoci.aggiungiIngrediente(new Ingrediente("Panna", 100, true, 500));
        //Aggiungiamo la pietanza all'archivio
        archivio.aggiungiPietanza(pietanzaPastaAlleNoci);
        
        Pietanza pietanzaPastaAiGamberi = new Pietanza("Pasta ai gamberi", Costanti.PRIMO, 10.0);
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Pasta", 80, false, 400));
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Gamberi", 30, true, 200));
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Panna", 100, true, 500));
        archivio.aggiungiPietanza(pietanzaPastaAiGamberi);
        
        Pietanza antipastoallitaliana = new Pietanza("Italiana", Costanti.ANTIPASTO, 20.0);
        antipastoallitaliana.aggiungiIngrediente(new Ingrediente("Latticini", 150, false, 400));
        antipastoallitaliana.aggiungiIngrediente(new Ingrediente("Prosciutto", 33, false, 200));
        antipastoallitaliana.aggiungiIngrediente(new Ingrediente("Miele", 3, false, 500));
        archivio.aggiungiPietanza(antipastoallitaliana);
        
        return archivio;
    }

}
