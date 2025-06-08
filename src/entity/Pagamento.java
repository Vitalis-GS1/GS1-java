package entity;

import java.time.LocalDateTime;
import java.util.UUID;

import enums.StatusPagamento;

public class Pagamento {
    private Integer id = gerarId();
    private String transacao;
    private LocalDateTime dataPagamento;
    private StatusPagamento statusPagamento;

    private static int proximoId = 1;

    public Pagamento(String transacao, LocalDateTime dataPagamento, StatusPagamento statusPagamento) {
        this.transacao = transacao;
        this.dataPagamento = dataPagamento;
        this.statusPagamento = statusPagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransacao() {
        return transacao;
    }

    public void setTransacao(String transacao) {
        this.transacao = transacao;
    }

    public static int getProximoId() {
        return proximoId;
    }

    public static void setProximoId(int proximoId) {
        Pagamento.proximoId = proximoId;
    }

    public LocalDateTime getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDateTime dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public static Integer gerarId() {
        return proximoId++;
    }

     public static String gerarTransacao() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    }

    @Override
    public String toString() {
        return "Id:" + id +" | Data de Pagamento: " + dataPagamento + " - Status do Pagamento: " + statusPagamento;
    }

}
