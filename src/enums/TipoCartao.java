package enums;

import java.util.Arrays;
import java.util.List;

public enum TipoCartao {
    CREDITO("Crédito", "1"),
    DEBITO("Débito", "2");

    private String tipo;
    private String codigo;

    TipoCartao(String tipo, String codigo) {
        this.tipo = tipo;
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }
    public String getCodigo() {
        return codigo;
    }

    public static TipoCartao fromCodigo(String codigo) {
        List<TipoCartao> tipos = Arrays.asList(TipoCartao.values());
        return tipos.stream()
                .filter(tipo -> tipo.getCodigo().equals(codigo))
                .findAny()
                .orElse(null);
    }
}
