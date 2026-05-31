import java.util.Scanner;

public class Professor extends Usuario {

    public Professor(String nome, int matricula, String tipo, String cpf, String email) {
        super(nome, matricula, tipo, cpf, email);
    }

    public static Professor criar(Scanner input) {
        String nome = MenuBiblioteca.lerNome(input, "Informe o nome do Professor: ");

        int matricula = MenuBiblioteca.lerNumero(input, "Informe o numero da matricula: ");

        String cpf = MenuBiblioteca.lerCpf(input, "Informe o cpf do Professor: ");

        System.out.println("Informe o email do Professor: ");
        String email = input.nextLine();

        System.out.println(" ---Dados do Professor---");
        System.out.println("NOME: " + nome);
        System.out.println("MATRICULA: " + matricula);
        System.out.println("TIPO: Professor");
        System.out.println("CPF: " + cpf);
        System.out.println("EMAIL: " + email);
        System.out.println("Professor " + nome + " cadastrado com sucesso!");

        return new Professor(nome, matricula, "Professor", cpf, email);
    }

    @Override
    public int getLimiteEmprestimos() {
        return 5;
    }
}
