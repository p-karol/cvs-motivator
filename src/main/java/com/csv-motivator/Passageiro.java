public class Passageiro {
    private String CPF;
    private String Nome;
    private String Nro_Cartao;

    enum FormaPagamento {
        DINHEIRO,
        CARTAO,
        TODAS;
    }

   private FormaPagamento Pagamento;

    public Passageiro(String CPF, String Nome, String Nro_Cartao, String Pagamento) {
        this.CPF = CPF;
        this.Nome = Nome;
        this.Nro_Cartao = Nro_Cartao;
        this.Pagamento = FormaPagamento.valueOf(Pagamento);
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

    public String getNro_Cartao() {
        return Nro_Cartao;
    }

    public void setNro_Cartao(String nro_Cartao) {
        Nro_Cartao = nro_Cartao;
    }

    @Override
    public String toString() {
        return CPF + "," + Nome + "," + Pagamento + "," + Nro_Cartao;
    }

   
    public FormaPagamento getPagamento() {
        return Pagamento;
    }

    public void setPagamento(FormaPagamento pagamento) {
        Pagamento = pagamento;
    }
}