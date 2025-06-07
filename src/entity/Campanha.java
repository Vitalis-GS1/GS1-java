package entity;

import java.util.List;

public class Campanha {
    private Integer id = gerarId();
    private Usuario usuario;
    private String nome;
    private String descricao;
    private Double valorArrecadado = 0.0;
    private List<Doacao> doacoes;

    private static int proximoId = 1;

    public Campanha(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Campanha(Usuario usuario,String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.usuario = usuario;
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorArrecadado() {
        return valorArrecadado;
    }

    public void setValorArrecadado(Double valorArrecadado) {
        this.valorArrecadado = valorArrecadado;
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<Doacao> doacoes) {
        this.doacoes = doacoes;
    }

    public static Integer gerarId() {
        return proximoId++;
    }

    public void fazerDoacao(Doacao doacao) {
        if (doacoes == null) {
            doacoes = new java.util.ArrayList<>();
        }
        doacoes.add(doacao);
        if (valorArrecadado == null) {
            valorArrecadado = 0.0;
        }
        valorArrecadado += doacao.getValorDoacao();
    }

    @Override
    public String toString() {
        return "--- Campanha ---\n" +
                "Nome: " + nome + "\n" +
                "ID: " + id + "\n" +
                "Descrição: " + descricao + "\n" +
                "Valor Arrecadado: R$ " + valorArrecadado + "\n" +
                "Doações: " + (doacoes != null ? doacoes.size() : 0) + "\n" +
                "----------------";
    }
}
