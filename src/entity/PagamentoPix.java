package entity;

import enums.TipoChavePix;
import enums.StatusPagamento;
import java.time.LocalDateTime;

public class PagamentoPix extends Pagamento {
    private String chavePix;
    private TipoChavePix tipoChavePix;


    public PagamentoPix(String transacao, LocalDateTime dataPagamento, StatusPagamento statusPagamento,
            String chavePix, TipoChavePix tipoChavePix) {
        super(transacao, dataPagamento, statusPagamento);
        this.chavePix = chavePix;
        this.tipoChavePix = tipoChavePix;
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
    if (chavePix == null || chavePix.isEmpty()) {
        return "Chave inválida";
    }
    int tamanho = chavePix.length();
    if (tamanho <= 3) {
        return "*".repeat(tamanho);
    }

    String ultimos3 = chavePix.substring(tamanho - 3);
    String mascarado = "*".repeat(tamanho - 3) + ultimos3;

    return mascarado;
}
   

    @Override
    public String toString() {
        return "--- Pagamento ---" + "\n" +
                "Método de Pagamento: Pix" + "\n" +
                "Chave: " + encriptarChavePix(chavePix) + " - " + tipoChavePix.getNome() + "\n" +
                super.toString();
    }
}
