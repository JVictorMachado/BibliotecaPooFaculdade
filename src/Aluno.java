import java.util.Scanner;

public class Aluno extends Usuario {

    public Aluno(String nome, int matricula, String tipo, String cpf, String email) {
        super(nome, matricula, tipo, cpf, email);
    }

    public static Aluno criar(Scanner input) {
        String nome = MenuBiblioteca.lerNome(input, "Informe o nome do Aluno: ");

        int matricula = MenuBiblioteca.lerNumero(input, "Informe o numero da matricula: ");

        String cpf = MenuBiblioteca.lerCpf(input, "Informe o cpf do Aluno: ");

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
