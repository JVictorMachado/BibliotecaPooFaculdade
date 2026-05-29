import java.util.*;

class Cliente {
    private String cpf;
    private String nome;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " | CPF: " + cpf;
    }
}

class Conta {
    private int numero;
    private Cliente cliente;
    private double saldo;

    public Conta(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public String getResumo() {
        return "Conta: " + numero + " | " + cliente.toString() + " | Saldo: R$ " + saldo;
    }

    public int getNumero() {
        return numero;
    }
}

public class SistemaConta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Cliente> clientes = new HashMap<>();
        Map<Integer, Conta> contas = new HashMap<>();

        int opcao;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Abrir Conta");
            System.out.println("3. Operações em Conta");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("--- Cadastro de Cliente ---");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    if (clientes.containsKey(cpf)) {
                        System.out.println("Cliente já cadastrado.");
                    } else {
                        clientes.put(cpf, new Cliente(cpf, nome));
                        System.out.println("Cliente cadastrado com sucesso.");
                    }
                    break;

                case 2:
                    System.out.println("--- Abertura de Conta ---");
                    System.out.print("CPF do cliente: ");
                    String cpfConta = scanner.nextLine();
                    Cliente cliente = clientes.get(cpfConta);
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado. Cadastre o cliente primeiro.");
                    } else {
                        System.out.print("Número da conta: ");
                        int numeroConta = scanner.nextInt();
                        if (contas.containsKey(numeroConta)) {
                            System.out.println("Número de conta já existente.");
                        } else {
                            contas.put(numeroConta, new Conta(numeroConta, cliente));
                            System.out.println("Conta criada com sucesso.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Digite o número da conta: ");
                    int numero = scanner.nextInt();
                    Conta conta = contas.get(numero);
                    if (conta == null) {
                        System.out.println("Conta não encontrada.");
                        break;
                    }
                    int op;
                    do {
                        System.out.println("\n--- Menu da Conta ---");
                        System.out.println("1. Consultar Saldo");
                        System.out.println("2. Depositar");
                        System.out.println("3. Sacar");
                        System.out.println("4. Ver Resumo da Conta");
                        System.out.println("0. Voltar");
                        System.out.print("Escolha uma opção: ");
                        op = scanner.nextInt();

                        switch (op) {
                            case 1:
                                conta.consultarSaldo();
                                break;
                            case 2:
                                System.out.print("Valor para depósito: R$ ");
                                double deposito = scanner.nextDouble();
                                conta.depositar(deposito);
                                break;
                            case 3:
                                System.out.print("Valor para saque: R$ ");
                                double saque = scanner.nextDouble();
                                conta.sacar(saque);
                                break;
                            case 4:
                                System.out.println(conta.getResumo());
                                break;
                            case 0:
                                System.out.println("Voltando ao menu principal.");
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                    } while (op != 0);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}