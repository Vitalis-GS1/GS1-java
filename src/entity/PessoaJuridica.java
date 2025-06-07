package entity;

import java.util.List;

public class PessoaJuridica extends  Usuario{
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;

    public PessoaJuridica(List<Email> email, List<Telefone> telefones, List<Campanha> campanha, List<Doacao> doacao, String cnpj, String razaoSocial, String nomeFantasia) {
        super(email, telefones, campanha, doacao);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

     //sem doção e sem campanha, pra quando acabar de ser criado
    public PessoaJuridica(List<Email> email, List<Telefone> telefones, String cnpj, String razaoSocial, String nomeFantasia) {
        super(email, telefones);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @Override
    public String toString() {
        return "--- Pessoa Jurídica ---" + "\n" +
                "CNPJ: " + cnpj + "\n" +
                "Razão Social: " + razaoSocial + "\n" +
                "Nome Fantasia: " + nomeFantasia + "\n" +
                super.toString();
    }
}
