package enums;

import java.util.Arrays;
import java.util.List;

public enum Status {
    ATIVO("Ativo","1"),
    INATIVO("Inativo","2");

    private String descricao;
    private String codigo;

    Status(String descricao, String codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    public String getCodigo() {
        return codigo;
    }
    public static Status fromCodigo(String codigo) {
        List<Status> tipos = Arrays.asList(Status.values());
        return tipos.stream()
                .filter(tipo -> tipo.getCodigo().equals(codigo))
                .findAny()
                .orElse(null);
    }
}
