package entity;

public class Usuario {
    private Integer id;
    private Endereco endereco;
    private Email email;
    private Campanha campanha;
    private Doacao doacao;

    public Usuario(Integer id, Endereco endereco, Email email, Campanha campanha, Doacao doacao) {
        this.id = id;
        this.endereco = endereco;
        this.email = email;
        this.campanha = campanha;
        this.doacao = doacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Campanha getCampanha() {
        return campanha;
    }

    public void setCampanha(Campanha campanha) {
        this.campanha = campanha;
    }

    public Doacao getDoacao() {
        return doacao;
    }

    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
    }
}
