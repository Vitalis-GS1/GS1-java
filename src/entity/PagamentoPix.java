package entity;

import enums.TipoChavePix;
import enums.StatusPagamento;
import java.time.LocalDateTime;
import java.util.UUID;

public class PagamentoPix extends Pagamento {
    private String transacao;
    private String chavePix;
    private TipoChavePix tipoChavePix;

    public PagamentoPix(LocalDateTime dataPagamento, StatusPagamento statusPagamento,
                        String chavePix, TipoChavePix tipoChavePix) {
        super(dataPagamento, statusPagamento);
        this.transacao = gerarTransacao();
        this.chavePix = chavePix;
        this.tipoChavePix = tipoChavePix;
    }

    public String getTransacao() {
        return transacao;
    }

    public void setTransacao(String transacao) {
        this.transacao = transacao;
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public TipoChavePix getTipoChavePix() {
        return tipoChavePix;
    }

    public void setTipoChavePix(TipoChavePix tipoChavePix) {
        this.tipoChavePix = tipoChavePix;
    }

    private String encriptarChavePix(String chavePix) {
        int tamanho = chavePix.length();
        String ultimos3 = chavePix.substring(tamanho - 3);
        String mascarado = "*".repeat(tamanho - 3) + ultimos3;
        return mascarado;
    }

    public static String gerarTransacao() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    }

    @Override
    public String toString() {
        return "--- Pagamento ---" + "\n" +
                "Método de Pagamento: Pix" + "\n" +
                "Chave: " + encriptarChavePix(chavePix) + " - " + tipoChavePix.getNome() + " | Transação: " + transacao +"\n" +
                super.toString();
    }
}
