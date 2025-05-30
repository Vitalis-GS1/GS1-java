package entity;

public class Endereco {
    private Integer id;
    private Integer numeroDDI;
    private Integer numeroDDD;
    private Integer telefone;
    private String tipoTelefone;

    public Endereco(String tipoTelefone, Integer telefone, Integer numeroDDD, Integer numeroDDI, Integer id) {
        this.tipoTelefone = tipoTelefone;
        this.telefone = telefone;
        this.numeroDDD = numeroDDD;
        this.numeroDDI = numeroDDI;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroDDI() {
        return numeroDDI;
    }

    public void setNumeroDDI(Integer numeroDDI) {
        this.numeroDDI = numeroDDI;
    }

    public Integer getNumeroDDD() {
        return numeroDDD;
    }

    public void setNumeroDDD(Integer numeroDDD) {
        this.numeroDDD = numeroDDD;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
