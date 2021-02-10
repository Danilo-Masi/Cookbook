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
        assertEquals(0, archivio.cercaPietanzePerCategoria(Costanti.ANTIPASTO).size());
        assertEquals(2, archivio.cercaPietanzePerCategoria(Costanti.PRIMO).size());
        assertEquals(1, archivio.cercaPietanzePerCategoria(Costanti.SECONDO).size());
        assertEquals(0, archivio.cercaPietanzePerCategoria(Costanti.DESSERT).size());
    }
    
    public void testPietanzaSimileCategoria() {
        Pietanza pastaAlPesto = archivio.getPietanze().get(0);
        Pietanza cotoletta = archivio.getPietanze().get(2);
        assertEquals("Cotoletta", archivio.cercaPietanzaSimile(pastaAlPesto).getNome());
        assertEquals("Pasta al pesto", archivio.cercaPietanzaSimile(cotoletta).getNome());        
    }
    
}
