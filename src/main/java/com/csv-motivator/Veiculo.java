public class Veiculo{
    private String placa;
    private String marca; 
    private String cor; 
    private String categoria;
    
    public Veiculo(String placa, String marca, String cor, String categoria){
        
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.categoria = categoria;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Veiculo [categoria=" + categoria + ", cor=" + cor + ", marca=" + marca + ", placa=" + placa + "]";
    }

    

    

}