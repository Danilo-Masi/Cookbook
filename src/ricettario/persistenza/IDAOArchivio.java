package ricettario.persistenza;

import ricettario.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DAOException;
    
}
