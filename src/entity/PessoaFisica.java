package entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class PessoaFisica extends Usuario{
    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;

    public PessoaFisica(List<Endereco> endereco, List<Email> email, List<Telefone> telefones, List<Campanha> campanha, List<Doacao> doacao, Long cpf, String nome, LocalDate dataNascimento) {
        super(endereco, email, telefones, campanha, doacao);
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
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

    public static Integer idade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();

    }

    @Override
    public String toString() {
        return "--- Pessoa Física ---" + "\n" +
                "CPF: " + cpf + "\n" +
                "Nome: " + nome + "\n" +
                "Idade: " + idade(dataNascimento) + " | Data de Nascimento: " + dataNascimento + "\n" +
                super.toString();
    }
}
