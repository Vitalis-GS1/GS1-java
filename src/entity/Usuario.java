package entity;

import java.util.List;

public class Usuario {
    private Integer id = gerarId();
    private List<Endereco> endereco;
    private List<Email> email;
    private List<Telefone> telefones;
    private List<Campanha> campanha;
    private List<Doacao> doacao;

    private static int proximoId = 1;

    public Usuario(List<Endereco> endereco, List<Email> email, List<Telefone> telefones, List<Campanha> campanha, List<Doacao> doacao) {
        this.endereco = endereco;
        this.email = email;
        this.telefones = telefones;
        this.campanha = campanha;
        this.doacao = doacao;
    }
     //sem doção e sem campanha, pra quando acabar de ser criado
    public Usuario(List<Endereco> endereco, List<Email> email, List<Telefone> telefones) {
        this.endereco = endereco;
        this.email = email;
        this.telefones = telefones;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Campanha> getCampanha() {
        return campanha;
    }

    public void setCampanha(List<Campanha> campanha) {
        this.campanha = campanha;
    }

    public List<Doacao> getDoacao() {
        return doacao;
    }

    public void setDoacao(List<Doacao> doacao) {
        this.doacao = doacao;
    }

    public static Integer gerarId() {
        return proximoId++;
    }

    @Override
    public String toString() {
        return  "ID: " + id + "\n" +
                "Endereço: " + endereco + "\n" +
                "Email: " + email + "\n" +
                "Telefone: " + telefones + "\n" +
                (campanha != null ? "Campanhas: " + campanha.size() + "\n" : "") +
                (doacao != null ? "Doações: " + doacao.size() + "\n" : "") +
                "----------------\n";
    }
}
