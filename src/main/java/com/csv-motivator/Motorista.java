

public class Motorista{
    private String CPF;
    private String Nome;
    private Veiculo Veiculo;

    enum FormaPagamento {
        DINHEIRO,
        CARTAO,
        TODAS;
    }

    private FormaPagamento Pagamento;

     public Motorista(String CPF,String Nome, Veiculo Veiculo, String Pagamento){
            this.CPF = CPF;
            this.Nome = Nome;
            this.Veiculo = Veiculo;
            this.Pagamento = FormaPagamento.valueOf(Pagamento);
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

    public void setPagamento(FormaPagamento Pagamento){
        this.Pagamento = Pagamento;
    }

    public FormaPagamento getPagamento(){
        return this.Pagamento;
    }

    @Override
    public String toString() {
        return CPF + "," + Nome + "," + Veiculo.toString() + "," + Pagamento;
    }

    
}