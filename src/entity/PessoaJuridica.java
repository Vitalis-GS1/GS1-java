package entity;

import java.util.List;

public class PessoaJuridica extends  Usuario{
    private Long cnpj;
    private String razaoSocial;
    private String nomeFantasia;

    public PessoaJuridica(List<Endereco> endereco, List<Email> email, List<Telefone> telefones, List<Campanha> campanha, List<Doacao> doacao, Long cnpj, String razaoSocial, String nomeFantasia) {
        super(endereco, email, telefones, campanha, doacao);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
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
