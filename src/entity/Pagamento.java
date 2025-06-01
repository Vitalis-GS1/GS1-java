package entity;

import java.time.LocalDateTime;
import enums.StatusPagamento;

public class Pagamento {
    private Integer id = gerarId();
    private LocalDateTime dataPagamento;
    private StatusPagamento statusPagamento;

    private static int proximoId = 1;

    public Pagamento(LocalDateTime dataPagamento, StatusPagamento statusPagamento) {
        this.dataPagamento = dataPagamento;
        this.statusPagamento = statusPagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Id:" + id +" | Data de Pagamento: " + dataPagamento + " - Status do Pagamento: " + statusPagamento;
    }

}
