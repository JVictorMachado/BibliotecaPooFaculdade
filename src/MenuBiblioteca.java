import java.util.ArrayList;
import java.util.Scanner;

public class MenuBiblioteca {
    private Scanner input;
    private ArrayList<Livros> livros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Emprestimo> emprestimos;
    private int numeroEmprestimo;

    public MenuBiblioteca() {
        input = new Scanner(System.in);
        livros = new ArrayList<>();
        usuarios = new ArrayList<>();
        emprestimos = new ArrayList<>();
        numeroEmprestimo = 1;
    }

    public void iniciar() {
        int opcao;

        do {
            System.out.println("=== Sistema de Gestao de Biblioteca Academica ===");
            System.out.println("1 - Usuarios");
            System.out.println("2 - Livros");
            System.out.println("3 - Emprestimos");
            System.out.println("0 - Sair");

            opcao = lerNumero(input, "Escolha uma opcao:");

            switch (opcao) {
                case 1:
                    Usuario.menuUsuarios(input, usuarios);
                    break;
                case 2:
                    Livros.menuLivros(input, livros);
                    break;
                case 3:
                    numeroEmprestimo = Emprestimo.menuEmprestimos(input, emprestimos, usuarios, livros, numeroEmprestimo);
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        input.close();
    }

    public static int lerNumero(Scanner input, String mensagem) {
        int numero = 0;
        boolean certo = false;
        String texto;

        while (certo == false) {
            System.out.println(mensagem);
            texto = input.nextLine();
            try {
                numero = Integer.parseInt(texto);
                certo = true;
            } catch (NumberFormatException erro) {
                if (somenteNumeros(texto)) {
                    System.out.println("Numero muito grande. Digite no maximo 10 numeros.");
                } else {
                    System.out.println("Digite somente numeros.");
                }
            }
        }

        return numero;
    }

    public static String lerNome(Scanner input, String mensagem) {
        String nome = "";
        boolean certo = false;

        while (certo == false) {
            System.out.println(mensagem);
            nome = input.nextLine();

            if (temNumero(nome)) {
                System.out.println("Nome nao pode ter numeros.");
            } else {
                certo = true;
            }
        }

        return nome;
    }

    public static String lerCpf(Scanner input, String mensagem) {
        String cpf = "";
        boolean certo = false;

        while (certo == false) {
            System.out.println(mensagem);
            cpf = input.nextLine();

            if (somenteNumeros(cpf)) {
                if (cpf.length() <= 11) {
                    certo = true;
                } else {
                    System.out.println("CPF muito grande. Digite no maximo 11 numeros.");
                }
            } else {
                System.out.println("Digite somente numeros.");
            }
        }

        return cpf;
    }

    public static boolean somenteNumeros(String texto) {
        boolean correto = true;

        if (texto.length() == 0) {
            correto = false;
        }

        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (letra < '0' || letra > '9') {
                correto = false;
            }
        }

        return correto;
    }

    public static boolean temNumero(String texto) {
        boolean achouNumero = false;

        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (letra >= '0' && letra <= '9') {
                achouNumero = true;
            }
        }

        return achouNumero;
    }
}
