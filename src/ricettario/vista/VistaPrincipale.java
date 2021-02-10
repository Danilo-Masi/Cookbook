package ricettario.vista;

import java.util.List;
import ricettario.Applicazione;
import ricettario.modello.Costanti;
import ricettario.modello.Pietanza;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        inizializzaComponenti();
        inizializzaAzioni();
        this.tabellaPietanze.setModel(new ModelloTabellaPietanze());
    }
    
    //Metodo per cambiare i componenti all'interno della comboBox
    private void inizializzaComponenti() {
        this.comboCategoria.removeAllItems();
        this.comboCategoria.addItem("");
        this.comboCategoria.addItem(Costanti.ANTIPASTO);
        this.comboCategoria.addItem(Costanti.PRIMO);
        this.comboCategoria.addItem(Costanti.SECONDO);
        this.comboCategoria.addItem(Costanti.DESSERT);
    }

    private void inizializzaAzioni() {
        this.bottoneCercaCategoria.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaTipologia());
        this.bottoneCercaSimile.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaPietanzaSimile());
    }
    
    //Ritorna la comboBox selezionata
    public String getComboCategorie() {
        return this.comboCategoria.getSelectedItem().toString();
    }
    
    //Ritorna la riga selezionata nella tabella
    public int getRigaSelezionata() {
        return this.tabellaPietanze.getSelectedRow();
    }
    
    //Metodo per aggiornare i valori della tabella
    public void aggiornaTabella() {
        List<Pietanza> listaPietanze = (List<Pietanza>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
        ModelloTabellaPietanze modelloTabella = (ModelloTabellaPietanze) this.tabellaPietanze.getModel();
        modelloTabella.setPietanze(listaPietanze);
        modelloTabella.aggiornaContenuto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        bottoneCercaCategoria = new javax.swing.JButton();
        javax.swing.JScrollPane ScrollPane = new javax.swing.JScrollPane();
        tabellaPietanze = new javax.swing.JTable();
        bottoneCercaSimile = new javax.swing.JButton();

        jLabel1.setText("Categoria: ");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bottoneCercaCategoria.setText("jButton1");

        tabellaPietanze.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        ScrollPane.setViewportView(tabellaPietanze);

        bottoneCercaSimile.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottoneCercaSimile))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(bottoneCercaCategoria)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(bottoneCercaCategoria))
                .addGap(18, 18, 18)
                .addComponent(ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bottoneCercaSimile)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCercaCategoria;
    private javax.swing.JButton bottoneCercaSimile;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JTable tabellaPietanze;
    // End of variables declaration//GEN-END:variables

}
