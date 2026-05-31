import java.util.Scanner;

public class Aluno extends Usuario {

    public Aluno(String nome, int matricula, String tipo, String cpf, String email) {
        super(nome, matricula, tipo, cpf, email);
    }

    public static Aluno criar(Scanner input) {
        System.out.println("Informe o nome do Aluno: ");
        String nome = input.nextLine();

        System.out.println("Informe o numero da matricula: ");
        int matricula = input.nextInt();
        input.nextLine();

        System.out.println("Informe o cpf do Aluno: ");
        String cpf = input.nextLine();

        System.out.println("Informe o email do Aluno: ");
        String email = input.nextLine();

        System.out.println(" ---Dados do Aluno---");
        System.out.println("NOME: " + nome);
        System.out.println("MATRICULA: " + matricula);
        System.out.println("TIPO: Aluno");
        System.out.println("CPF: " + cpf);
        System.out.println("EMAIL: " + email);
        System.out.println("Aluno " + nome + " foi cadastrado com sucesso!");

        return new Aluno(nome, matricula, "Aluno", cpf, email);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 3;
    }
}
