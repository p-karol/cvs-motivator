

public class Motorista{
    private String CPF;
    private String Nome;
    private Veiculo Veiculo;

     public Motorista(String CPF,String Nome, Veiculo Veiculo){
            this.CPF = CPF;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public Veiculo getVeiculo() {
        return this.Veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.Veiculo = veiculo;
    }


   
}