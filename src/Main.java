import entity.*;
import enums.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Usuario  usuario = cadastrarUsuario(scanner);
        System.out.println("Usuário cadastrado com sucesso!");
        System.out.println(usuario);
        System.out.println(usuario.getCampanha());
        System.out.println(usuario.getDoacao());
    }

    private static Usuario cadastrarUsuario(Scanner scanner) {
        System.out.println("--- Cadastro de Usuário ---");
        System.out.println("Pessoa Física (F) ou Pessoa Jurídica (J)? ");
        String tipoUsuario = scanner.nextLine().toUpperCase();

        if (tipoUsuario.equals("F")) {
            PessoaFisica pessoaFisica = cadastrarPessoaFisica(scanner);
            return pessoaFisica;
        } else if (tipoUsuario.equals("J")) {
            PessoaJuridica pessoaJuridica = cadastrarPessoaJuridica(scanner);
            return pessoaJuridica;
        } else {
            System.out.println("Tipo de usuário inválido. Tente novamente.");
            return cadastrarUsuario(scanner);
        }
    }

    private static PessoaFisica cadastrarPessoaFisica(Scanner scanner) {
        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF: ");
        Long cpf = parseLong(scanner.nextLine());
        System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

        List<Endereco> enderecos = cadastrarEnderecos(scanner);
        List<Email> emails = cadastrarEmails(scanner);
        List<Telefone> telefones = cadastrarTelefones(scanner);

        List<Campanha> campanhas = cadastrarCampanhas(scanner);
        List<Doacao> doacoes = fazerDoacao(scanner, campanhas);

        return new PessoaFisica(enderecos, emails, telefones, campanhas, doacoes, cpf, nome, dataNascimento);
    }

    private static PessoaJuridica cadastrarPessoaJuridica(Scanner scanner) {
        System.out.println("Digite a razão social da empresa: ");
        String razao = scanner.nextLine();
        System.out.println("Digite o nome da empresa: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o CNPJ: ");
        Long cnpj = parseLong(scanner.nextLine());

        List<Endereco> enderecos = cadastrarEnderecos(scanner);
        List<Email> emails = cadastrarEmails(scanner);
        List<Telefone> telefones = cadastrarTelefones(scanner);

        List<Campanha> campanhas = cadastrarCampanhas(scanner);
        List<Doacao> doacoes = fazerDoacao(scanner, campanhas);

        return new PessoaJuridica(enderecos, emails, telefones, campanhas, doacoes, cnpj, razao, nome);
    }

    private static List<Endereco> cadastrarEnderecos(Scanner scanner) {
        System.out.print("Quantos endereços deseja cadastrar? ");
        int qtd = parseInt(scanner.nextLine());
        List<Endereco> enderecos = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
        System.out.println("Digite o logradouro: ");
        String logradouro = scanner.nextLine();
        System.out.println("Digite o número: ");
        Integer numero = parseInt(scanner.nextLine());
        System.out.println("Digite o bairro: ");
        String bairro = scanner.nextLine();
        System.out.println("Digite a cidade: ");
        String cidade = scanner.nextLine();
        System.out.println("Digite o estado: ");
        String estado = scanner.nextLine();
        System.out.println("Digite o CEP: ");
        String cep = scanner.nextLine();
        Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, estado, cep);
        enderecos.add(endereco);
        }

        return enderecos;
    }

    private static List<Email> cadastrarEmails(Scanner scanner) {
        System.out.print("Quantos emails deseja cadastrar? ");
        int qtd = parseInt(scanner.nextLine());;
        List<Email> emails = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
        System.out.println("Digite o email: ");
        String emailAddress = scanner.nextLine();
        System.out.println("Digite o tipo de contato: (1) Pessoal, (2) Profissional, (3) Outros");
        String tipo = scanner.nextLine();
        TipoContato tipoContato = TipoContato.fromCodigo(tipo);
        System.out.println("Digite o status: (1) Ativo, (2) Inativo");
        String status = scanner.nextLine();
        Status statusEnum = Status.fromCodigo(status);
        Email email = new Email(emailAddress, tipoContato, statusEnum);
        emails.add(email);
        }
        return emails;
    }

    private static List<Telefone> cadastrarTelefones(Scanner scanner) {
        System.out.print("Quantos telefones deseja cadastrar? ");
        int qtd = parseInt(scanner.nextLine());;
        List<Telefone> telefones = new ArrayList<>();

        for (int i = 0; i < qtd; i++) {
        System.out.println("Digite o DDI do telefone: ");
        Integer ddi = parseInt(scanner.nextLine());
        System.out.println("Digite o DDD do telefone: ");
        Integer ddd = parseInt(scanner.nextLine());
        System.out.println("Digite o número do telefone: ");
        Integer numero = parseInt(scanner.nextLine());
        System.out.println("Digite o tipo de contato: (1) Pessoal, (2) Profissional, (3) Outros");
        String tipo = scanner.nextLine();
        TipoContato tipoContato = TipoContato.fromCodigo(tipo);
        System.out.println("Digite o status: (1) Ativo, (2) Inativo");
        String status = scanner.nextLine();
        Status statusEnum = Status.fromCodigo(status);
        Telefone telefone = new Telefone(ddi, ddd, numero, tipoContato, statusEnum);
        telefones.add(telefone);
        }
        return telefones;
    }

    private static List<Campanha> cadastrarCampanhas(Scanner scanner) {
        System.out.println("Deseja cadastrar uma campanha? (S/N)");
        String resposta = scanner.nextLine().toUpperCase();
        if (resposta.equals("S")) {
            System.out.println("Deseja cadastrar QUANTAS campanhas? ");
            Integer quantidade = parseInt(scanner.nextLine());;
            List<Campanha> campanhas = new ArrayList<>();

            for (int i = 0; i < quantidade; i++) {
                Campanha campanha = criarCampanha(scanner);
                campanhas.add(campanha);
            }
            return campanhas;
        } else if (resposta.equals("N")) {
            return null;
        } else {
            System.out.println("Resposta inválida. Tente novamente.");
            return cadastrarCampanhas(scanner);
        }
    }

    private static Campanha criarCampanha(Scanner scanner) {
        System.out.println("Digite o nome da campanha: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a descrição da campanha: ");
        String descricao = scanner.nextLine();

        return new Campanha(nome, descricao);
    }

    private static List<Doacao> fazerDoacao(Scanner scanner, List<Campanha> campanhas) {
        System.out.println("Deseja fazer uma doação? (S/N)");
        String resposta = scanner.nextLine().toUpperCase();

        if (campanhas == null || campanhas.isEmpty()) {
            System.out.println("Não há campanhas cadastradas. Cadastre uma campanha antes de doar.");
            campanhas = cadastrarCampanhas(scanner);
        }
        if (resposta.equals("S")) {
            System.out.println("Quantas doações deseja fazer? ");
            Integer quantidade = parseInt(scanner.nextLine());;
            List<Doacao> doacoes = new ArrayList<>();

            for (int i = 0; i < quantidade; i++) {
                Doacao doacao = criarDoacao(scanner, campanhas);
                doacoes.add(doacao);
            }
            return doacoes;
        } else if (resposta.equals('N')) {
            return null;
        } else {
            System.out.println("Resposta inválida. Tente novamente.");
            return fazerDoacao(scanner, campanhas);
        }
    }

    private static Doacao criarDoacao(Scanner scanner, List<Campanha> campanhas) {
        System.out.println("Selecione a campanha para doar:");
        for (int i = 0; i < campanhas.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, campanhas.get(i).getNome());
        }

        System.out.print("Digite o número da campanha: ");
        int escolha = parseInt(scanner.nextLine());

        Campanha campanhaSelecionada = campanhas.get(escolha - 1);

        System.out.print("Digite o valor da doação: ");
        Double valor = parseDouble(scanner.nextLine());

        Pagamento pagamento = cadastrarPagemento(scanner);

        Doacao doacao = new Doacao(campanhaSelecionada, LocalDateTime.now(), valor, pagamento);
        campanhaSelecionada.fazerDoacao(doacao);
        return doacao;
    }

    private static Pagamento cadastrarPagemento(Scanner scanner) {
        System.out.println("Selecione o tipo de pagamento: (1) PIX, (2) Cartão");
        String tipoPagamento = scanner.nextLine().toUpperCase();

        if (tipoPagamento.equals("1")) {
            return cadastrarPagamentoPix(scanner);
        } else if (tipoPagamento.equals("2")) {
            return cadastrarPagamento(scanner);
        } else {
            System.out.println("Tipo de pagamento inválido. Tente novamente.");
            return cadastrarPagemento(scanner);
        }
    }

    private static Pagamento cadastrarPagamentoPix(Scanner scanner) {
        System.out.println("Digite a chave PIX: ");
        String chave = scanner.nextLine();
        System.out.println("Digite o tipo de chave PIX: \n (1) CPF (2) CNPJ (3) Telefone (4) Email (5) Aleatória: ");
        String tipoChave = scanner.nextLine();
        TipoChavePix tipo = TipoChavePix.fromCodigo(tipoChave);
        return new PagamentoPix(LocalDateTime.now(), StatusPagamento.APROVADO, chave, tipo);
    }

    private static Pagamento cadastrarPagamento(Scanner scanner) {
        System.out.println("Digite o número do cartão: ");
        Long numeroCartao = parseLong(scanner.nextLine());
        System.out.println("Digite a bandeira do cartão: \n (1) VISA (2) MASTERCARD (3) ELO (4) AMERICAN EXPRESS (5) DINERS CLUB (6) HIPERCARD: ");
        String bandeiraCod = scanner.nextLine();
        BandeiraCartao bandeira = BandeiraCartao.fromCodigo(bandeiraCod);
        System.out.println("Digite a data de validade (MM/AAAA): ");
        String validadeStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        YearMonth validade= YearMonth.parse(validadeStr, formatter);
        System.out.println("Digite o tipo de cartão: \n (1) Crédito (2) Débito: ");
        String tipoCod = scanner.nextLine();
        TipoCartao tipo = TipoCartao.fromCodigo(tipoCod);

        return new PagamentoCartao(LocalDateTime.now(), StatusPagamento.APROVADO, bandeira, validade, numeroCartao, tipo);
    }
}