 package ricettario.modello;

import java.util.ArrayList;
import java.util.List;

public class Pietanza {
    
    private String nome;
    private String categoria;
    private double costo;
    private List<Ingrediente> ingredienti = new ArrayList<Ingrediente>();

    public Pietanza(String nome, String categoria, double costo) {
        this.nome = nome;
        this.categoria = categoria;
        this.costo = costo;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getCosto() {
        return costo;
    }
    
    //Metodo che rende gli ingredienti accessibili all'esterno
    public List<Ingrediente> getIngredienti() {
        return ingredienti;
    }
    
    //Metodo per aggiungere un ingrediente alla lista degli ingredienti
    public void aggiungiIngrediente(Ingrediente e) {
       ingredienti.add(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome pietanza: ").append(nome);
        sb.append("Categoria: ").append(categoria);
        sb.append("Costo: ").append(costo);
        sb.append("Ingredienti: ").append(ingredienti);
        return sb.toString();
    }
    
    //Metooo per il calcolo delle calorie
    public double getKcal() {
        double somma = 0.0;
        for (Ingrediente ingrediente : ingredienti) {
            somma += ingrediente.getkcal();
        }
        return somma;
    }
    
    //Metodo per la verifica di presenza degli allergeni
    public boolean contieneAllergeni() {
        for (Ingrediente ingrediente : ingredienti) {
            if(ingrediente.isAllergene()) {
                return true;
            }
        }
        return false;
    }
    
    
    
}
