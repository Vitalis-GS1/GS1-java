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

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();
        List<Campanha> campanhas = new ArrayList<>();
        List<Doacao> doacoes = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Criar campanha");
            System.out.println("3 - Fazer doação");
            System.out.println("4 - Listar campanhas");
            System.out.println("5 - Listar doações");
            System.out.println("6 - Listar usuarios");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    usuarios.add(cadastrarUsuario(scanner));
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;

                case 2:
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado ainda.");
                        break;
                    }
                    System.out.println("Escolha o receptor (índice): ");
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(i + " - " + usuarios.get(i));
                    }
                    int idxReceptor = scanner.nextInt();
                    scanner.nextLine();
                    if (idxReceptor < 0 || idxReceptor >= usuarios.size()) {
                        System.out.println("Índice inválido.");
                        break;
                    }
                    campanhas.addAll(cadastrarCampanhas(scanner));
                    System.out.println("Campanha criada com sucesso!");
                    break;

                case 3:
                    if (usuarios.isEmpty() || campanhas.isEmpty()) {
                        System.out.println("Cadastre pelo menos um usuário e uma campanha antes de doar.");
                        break;
                    }

                    System.out.println("Escolha o doador (índice): ");
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(i + " - " + usuarios.get(i));
                    }
                    int idxDoador = scanner.nextInt();

                    System.out.println("Escolha a campanha (índice): ");
                    for (int i = 0; i < campanhas.size(); i++) {
                        System.out.println(i + " - " + campanhas.get(i));
                    }
                    int idxCampanha = scanner.nextInt();

                    doacoes.addAll(fazerDoacao(scanner, campanhas));
                    System.out.println("Doação registrada com sucesso!");
                    break;

                case 4:
                    if (campanhas.isEmpty()) {
                        System.out.println("Nenhuma campanha cadastrada.");
                    } else {
                        System.out.println("\n--- Campanhas ---");
                        for (Campanha c : campanhas) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 5:
                    if (doacoes.isEmpty()) {
                        System.out.println("Nenhuma doação realizada.");
                    } else {
                        System.out.println("\n--- Doações ---");
                        for (Doacao d : doacoes) {
                            System.out.println(d);
                        }
                    }
                    break;

                    case 6:
                    listarUsuarios(usuarios);
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
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
        return new PessoaFisica(enderecos, emails, telefones, cpf, nome, dataNascimento);
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

        return new PessoaJuridica(enderecos, emails, telefones, cnpj, razao, nome);
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
        } else if (resposta.equals("N")) {
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

        //gambiarra a ser investigada pois o parse simplesmente nao quer funcionar
        System.out.print("Digite o número da campanha: ");
String entrada = scanner.nextLine();
while (entrada.isBlank() || !entrada.matches("\\d+")) {
    System.out.print("");
    entrada = scanner.nextLine();
}
int escolha = Integer.parseInt(entrada);


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
    private static void listarUsuarios(List<Usuario> usuarios) {
    for (int i = 0; i < usuarios.size(); i++) {
        System.out.println(i + 1 + " - " + usuarios.get(i));
        System.out.println(usuarios.get(i).getCampanha());
        System.out.println(usuarios.get(i).getDoacao());
    }
}
}