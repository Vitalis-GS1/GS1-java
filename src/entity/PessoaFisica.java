package entity;

import java.time.LocalDate;

public class PessoaFisica extends Usuario{
    private Long cpf;
    private String nome;
    private LocalDate dataNascimento;


    public PessoaFisica(Integer id, Endereco endereco, Email email, Campanha campanha, Doacao doacao,
                        Long cpf, String nome, LocalDate dataNascimento) {
        super(id, endereco, email, campanha, doacao);
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    //To Do: criar funcao para validacao de idade (apenas +18)


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
}
