package ricettario.vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import ricettario.modello.Pietanza;

public class ModelloTabellaPietanze extends AbstractTableModel {

    private List<Pietanza> pietanze = new ArrayList<Pietanza>();

    public List<Pietanza> getPietanze() {
        return pietanze;
    }

    public void setPietanze(List<Pietanza> pietanze) {
        this.pietanze = pietanze;
    }

    //Ritona il numero di righe della tabella
    @Override
    public int getRowCount() {
        return this.pietanze.size();
    }

    //Ritorna il numero di colonne della tabella
    @Override
    public int getColumnCount() {
        return 3;
    }

    //Inserisce i valori della pietanza nelle determinate posizioni della tabella
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pietanza pietanza = this.pietanze.get(rowIndex);
        if (columnIndex == 0) {
            return pietanza.getNome();
        } else if (columnIndex == 1) {
            return pietanza.getIngredienti().size();
        } else if (columnIndex == 2) {
            return pietanza.contieneAllergeni();
        }
        return "";
    }

    //Inserisce i titoli predefiniti della tabella
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Nome";
        } else if (column == 1) {
            return "Numero ingredienti";
        } else if (column == 2) {
            return "Contiene allergeni";
        }
        return "";
    }

    //Metodo per aggiornare la tabella 
    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

    //Metodo per gestire il tipo di risultato presente nella tabella
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        } else if (columnIndex == 1) {
            return Integer.class;
        } else if (columnIndex == 2) {
            return Boolean.class;
        }
        return String.class;
    }

}
