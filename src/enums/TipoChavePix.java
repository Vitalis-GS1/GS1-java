package enums;

import java.util.Arrays;
import java.util.List;

public enum TipoChavePix {
    CPF("CPF", "1"),
    CNPJ("CNPJ", "2"),
    TELEFONE("Telefone", "3"),
    EMAIL("Email", "4"),
    ALEATORIA("Aleatória", "5");

    private String nome;
    private String codigo;

    TipoChavePix(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public String getCodigo() { return codigo; }

    public static TipoChavePix fromCodigo(String codigo) {
        List<TipoChavePix> tipos = Arrays.asList(TipoChavePix.values());
        return tipos.stream()
                .filter(tipo -> tipo.getCodigo().equals(codigo))
                .findAny()
                .orElse(null);
    }
}
