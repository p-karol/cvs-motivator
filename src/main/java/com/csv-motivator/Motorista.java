

public class Motorista{
    private String CPF;
    private String Nome;
    private Veiculo Veiculo;

     public Motorista(String CPF,String Nome, Veiculo Veiculo){
            this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Veiculo getVeiculo() {
        return Veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        Veiculo = veiculo;
    }

    

   
}