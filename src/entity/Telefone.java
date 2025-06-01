package entity;

import enums.Status;
import enums.TipoContato;

public class Telefone {
    private Integer id = gerarId();
    private Integer numeroDDI;
    private Integer numeroDDD;
    private Integer telefone;
    private TipoContato tipoTelefone;
    private Status status;

    private static int proximoId = 1;

    public Telefone(Integer numeroDDI, Integer numeroDDD, Integer telefone, TipoContato tipoTelefone, Status status) {
        this.numeroDDI = numeroDDI;
        this.numeroDDD = numeroDDD;
        this.telefone = telefone;
        this.tipoTelefone = tipoTelefone;
        this.status = status;
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

    public TipoContato getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoContato tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getNumeroDDD() {
        return numeroDDD;
    }

    public void setNumeroDDD(Integer numeroDDD) {
        this.numeroDDD = numeroDDD;
    }

    public static Integer gerarId() {
        return proximoId++;
    }

    @Override
    public String toString() {
        return "Telefone: +" + numeroDDI + " (" + numeroDDD + ") " + telefone + " | Tipo: " + tipoTelefone.getDescricao() + " | Status: " + status.getDescricao();
    }
}