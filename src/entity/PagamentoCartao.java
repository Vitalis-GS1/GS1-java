package entity;

import enums.BandeiraCartao;
import enums.TipoCartao;
import enums.StatusPagamento;
import java.time.LocalDateTime;
import java.time.YearMonth;

public class PagamentoCartao extends Pagamento {
    private BandeiraCartao bandeiraCartao;
    private Long numeroCartao;
    private YearMonth dataVencimento;
    private TipoCartao tipoCartao;

    public PagamentoCartao(String transacao, LocalDateTime dataPagamento, StatusPagamento statusPagamento,
            BandeiraCartao bandeiraCartao, Long numeroCartao, YearMonth dataVencimento, TipoCartao tipoCartao) {
        super(transacao, dataPagamento, statusPagamento);
        this.bandeiraCartao = bandeiraCartao;
        this.numeroCartao = numeroCartao;
        this.dataVencimento = dataVencimento;
        this.tipoCartao = tipoCartao;
    }

    public BandeiraCartao getBandeiraCartao() {
        return bandeiraCartao;
    }

    public void setBandeiraCartao(BandeiraCartao bandeiraCartao) {
        this.bandeiraCartao = bandeiraCartao;
    }

    public Long getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Long numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public YearMonth getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(YearMonth dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public TipoCartao getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(TipoCartao tipoCartao) {
        this.tipoCartao = tipoCartao;
    }

    private String encriptarNumeroCartao(Long numeroCartao) {
        int tamanho = numeroCartao.toString().length();
        String ultimos3 = numeroCartao.toString().substring(tamanho - 3);
        String mascarado = "*".repeat(tamanho - 3) + ultimos3;
        return mascarado;
    }

    @Override
    public String toString() {
        return "--- Pagamento ---" + "\n" +
                "Método de Pagamento: Cartão de " + tipoCartao.getTipo() + "\n" +
                "Bandeira: " + bandeiraCartao.getNome() + " | Número do Cartão: " + encriptarNumeroCartao(numeroCartao) + " | Data de Vencimento" + dataVencimento  +"\n" +
                super.toString();
    }
}
