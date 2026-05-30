import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        int opcao;
        do {
            System.out.println(" --- Seja bem vindo a Biblioteca ---");
            System.out.println(" 1 - Cadastrar livros \n 2 - Cadastar Usuarios \n 4 - Consultar livros \n 0 - Encerrar programa \n ");
            System.out.println("Digite a opção desejada: ");
            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Qual livro gostaria de cadastrar: ");
                    String c_livro = input.nextLine();
                    System.out.println("O livro "+c_livro+" foi cadastrado com sucesso!");


                    break;

                case 2:
                    Usuario user = Usuario.criar();
                    break;


                case 3:
                    ;
                    System.out.println("Qual livro gostaria de cadastrar: ");
                    // String c_livro = input.nextLine();
                    System.out.println("O livro foi consultado com sucesso!");
                    break;



                case 0:
                    System.out.println("O sistema foi encerrado com sucesso!");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }


        } while (opcao!= 0);
    }
}

