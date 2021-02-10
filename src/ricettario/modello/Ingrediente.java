package ricettario.modello;

public class Ingrediente {
    
    private String nome;
    private int quantita;
    private boolean allergene;
    private int kcla100gr;

    public Ingrediente(String nome, int quantita, boolean allergene, int kcla100gr) {
        this.nome = nome;
        this.quantita = quantita;
        this.allergene = allergene;
        this.kcla100gr = kcla100gr;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public boolean isAllergene() {
        return allergene;
    }

    public int getKcla100gr() {
        return kcla100gr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome ingrediente: ").append(nome);
        sb.append("Quantita: ").append(quantita);
        sb.append("Allergene: ").append(allergene);
        sb.append("Chilocalorie per 100gr: ").append(kcla100gr);
        return sb.toString();
    }
    
    //Metodo per il calcolo dell calorie
    public double getkcal() {
        return this.quantita * this.kcla100gr / 100.0;
    }
    
    
    
    
}
