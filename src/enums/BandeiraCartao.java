package enums;

import java.util.Arrays;
import java.util.List;

public enum BandeiraCartao {
    VISA("Visa", "1"),
    MASTERCARD("Mastercard", "2"),
    ELO("Elo", "3"),
    AMERICAN_EXPRESS("American Express", "4"),
    DINERS_CLUB("Diners Club", "5"),
    HIPERCARD("Hipercard", "6"),;

    private final String nome;
    private final String codigo;

    BandeiraCartao(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public String getCodigo() { return codigo; }

    public static BandeiraCartao fromCodigo(String codigo) {
        List<BandeiraCartao> tipos = Arrays.asList(BandeiraCartao.values());
        return tipos.stream()
                .filter(tipo -> tipo.getCodigo().equals(codigo))
                .findAny()
                .orElse(null);
    }
}