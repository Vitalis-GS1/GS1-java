package entity;

public class Endereco {
    private Integer id = gerarId();
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    private static int proximoId = 1;

    public Endereco(String logradouro, Integer numero, String bairro, String cidade, String estado, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public static Integer gerarId() {
        return proximoId++;
    }

    @Override
    public String toString() {
        return "Logradouro: " + logradouro + ", " + numero + ", Bairro: " + bairro +
               " - Cidade: " + cidade + ", Estado: " + estado + " | " + cep;
    }
}
