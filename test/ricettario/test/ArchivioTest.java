package ricettario.test;

import junit.framework.TestCase;
import ricettario.modello.Archivio;
import ricettario.modello.Costanti;
import ricettario.modello.Pietanza;
import ricettario.persistenza.DAOArchivioMock;
import ricettario.persistenza.DAOException;
import ricettario.persistenza.IDAOArchivio;

public class ArchivioTest extends TestCase {
    
    private IDAOArchivio dAOArchivio = new DAOArchivioMock();
    private Archivio archivio;
    
    public void setUp() {
        try {
            this.archivio = dAOArchivio.carica(" ");
        }catch(DAOException ex) {
            fail("Impossibile caricare l'archivio");
        } 
    }
    
    public void testFiltroCategoria() {
        assertEquals(1, archivio.cercaPietanzePerCategoria(Costanti.ANTIPASTO).size());
        assertEquals(2, archivio.cercaPietanzePerCategoria(Costanti.PRIMO).size());
        assertEquals(0, archivio.cercaPietanzePerCategoria(Costanti.SECONDO).size());
        assertEquals(0, archivio.cercaPietanzePerCategoria(Costanti.DESSERT).size());
    }
    
    public void testPietanzaSimileCategoria() {
        Pietanza pietanzaPastaAlleNoci = archivio.getPietanze().get(0);
        Pietanza pietanzaPastaAiGamberi = archivio.getPietanze().get(1);
        assertEquals("Pasta ai gamberi", archivio.cercaPietanzaSimile(pietanzaPastaAlleNoci).getNome());
        assertEquals("Pasta alle noci", archivio.cercaPietanzaSimile(pietanzaPastaAiGamberi).getNome());        
    }
    
}
