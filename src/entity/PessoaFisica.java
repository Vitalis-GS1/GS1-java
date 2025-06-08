package entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class PessoaFisica extends Usuario{
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;

    public PessoaFisica(List<Email> email, List<Telefone> telefones, List<Campanha> campanha, List<Doacao> doacao, String cpf, String nome, LocalDate dataNascimento) {
        super(email, telefones, campanha, doacao);
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    //sem doção e sem campanha, pra quando acabar de ser criado
     public PessoaFisica(List<Email> email, List<Telefone> telefones, String cpf, String nome, LocalDate dataNascimento) {
        super(email, telefones);
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public static Integer getIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();

    }

    @Override
    public String toString() {
        return "--- Pessoa Física ---" + "\n" +
                "CPF: " + cpf + "\n" +
                "Nome: " + nome + "\n" +
                "Idade: " + getIdade(dataNascimento) + " | Data de Nascimento: " + dataNascimento + "\n" +
                super.toString();
    }
}
