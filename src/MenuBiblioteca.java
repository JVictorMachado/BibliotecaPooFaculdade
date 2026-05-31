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
            System.out.println("Escolha uma opcao:");

            opcao = input.nextInt();
            input.nextLine();

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
}
