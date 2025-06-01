package entity;

import java.time.LocalDateTime;

public class Doacao {
    private Integer id = gerarId();
    private Campanha campanha;
    private LocalDateTime dataDoacao;
    private Double valorDoacao;
    private Pagamento pagamento;

    private static int proximoId = 1;

    public Doacao(Campanha campanha, LocalDateTime dataDoacao, Double valorDoacao, Pagamento pagamento) {
        this.campanha = campanha;
        this.dataDoacao = dataDoacao;
        this.valorDoacao = valorDoacao;
        this.pagamento = pagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }

    public LocalDateTime getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(LocalDateTime dataDoacao) {
        this.dataDoacao = dataDoacao;
    }

    public Double getValorDoacao() {
        return valorDoacao;
    }

    public void setValorDoacao(Double valorDoacao) {
        this.valorDoacao = valorDoacao;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public static Integer gerarId() {
        return proximoId++;
    }

    @Override
    public String toString() {
        return "--- Comprovante de Doação ---" + "\n" +
                "Campanha: " + campanha.getNome() + "\n" +
                "Data da Doação: " + dataDoacao + "\n" +
                "Valor da Doação: R$ " + valorDoacao + "\n" + pagamento + "\n" +
                "-----------------------------";
    }
}
