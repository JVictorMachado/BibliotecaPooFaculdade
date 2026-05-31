import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    // Atributos da classe
    private String nome;
    private int matricula;
    private String tipo;
    private String cpf;
    private String email;

    // Metodos da classe

    // Metodo construtor

    public Usuario(String nome, int matricula, String tipo, String cpf, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.tipo = tipo;
        this.cpf = cpf;
        this.email = email;
    }

    // Metodos acessadores

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLimiteEmprestimos() {
        return 3;
    }

    public static void menuUsuarios(Scanner input, ArrayList<Usuario> usuarios) {
        int opcao;

        do {
            System.out.println("\n=== Menu de Usuarios ===");
            System.out.println("1 - Cadastrar usuario");
            System.out.println("2 - Listar usuarios");
            System.out.println("0 - Voltar");

            opcao = MenuBiblioteca.lerNumero(input, "Escolha uma opcao:");

            switch (opcao) {
                case 1:
                    if (cadastrarUsuario(input, usuarios)) {
                        opcao = 0;
                    }
                    break;
                case 2:
                    listarUsuarios(usuarios);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    public static boolean cadastrarUsuario(Scanner input, ArrayList<Usuario> usuarios) {
        int opcao;
        boolean cadastrou = false;

        do {
            System.out.println("\n=== Cadastro de Usuario ===");
            System.out.println("1 - Aluno");
            System.out.println("2 - Professor");
            System.out.println("0 - Voltar");

            opcao = MenuBiblioteca.lerNumero(input, "Escolha uma opcao:");

            switch (opcao) {
            case 1:
                Aluno aluno = Aluno.criar(input);
                usuarios.add(aluno);
                cadastrou = true;
                opcao = 0;
                break;
            case 2:
                Professor professor = Professor.criar(input);
                usuarios.add(professor);
                cadastrou = true;
                opcao = 0;
                break;
            case 0:
                break;
            default:
                System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        return cadastrou;
    }

    public static void listarUsuarios(ArrayList<Usuario> usuarios) {
        boolean encontrou = false;

        for (Usuario usuario : usuarios) {
            usuario.mostrarDados();
            encontrou = true;
        }

        if (encontrou == false) {
            System.out.println("Nenhum usuario cadastrado.");
        }
    }

    public static Usuario buscarUsuario(ArrayList<Usuario> usuarios, int matricula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula() == matricula) {
                return usuario;
            }
        }
        return null;
    }

    public void mostrarDados() {
        System.out.println("NOME: " + nome
                + " | MATRICULA: " + matricula
                + " | TIPO: " + tipo
                + " | CPF: " + cpf
                + " | EMAIL: " + email);
    }
}
