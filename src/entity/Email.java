package entity;

import enums.Status;
import enums.TipoContato;

public class Email {
    private Integer id = gerarId();
    private String email;
    private TipoContato tipo;
    private Status status;

    public Email(String email, TipoContato tipo, Status status) {
        this.email = email;
        this.tipo = tipo;
        this.status = status;
    }

    private static int proximoId = 1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoContato getTipo() {
        return tipo;
    }

    public void setTipo(TipoContato tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static Integer gerarId() {
        return proximoId++;
    }

    @Override
    public String toString() {
        return "Email: " + email + " | Tipo: " + tipo.getDescricao() + " | Status: " + status.getDescricao();
    }
}
