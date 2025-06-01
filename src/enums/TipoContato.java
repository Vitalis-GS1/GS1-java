package enums;

import java.util.Arrays;
import java.util.List;

public enum TipoContato {
    PESSOAL("Contato Pessoal", "1"),
    PROFISSIONAL("Contato Profissional", "2"),
    OUTROS("Outros","3");

    private String descricao;
    private String codigo;

    TipoContato(String descricao, String codigo) {
        this.descricao = descricao;
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getCodigo() {
        return codigo;
    }

    public static TipoContato fromCodigo(String codigo) {
        List<TipoContato> tipos = Arrays.asList(TipoContato.values());
        return tipos.stream()
                .filter(tipo -> tipo.getCodigo().equals(codigo))
                .findAny()
                .orElse(null);
    }
}
