import java.util.Scanner;

public class Usuario {

    // Atributos da classe
    private String nome;
    private int matricula;
    private String tipo;
    private int cpf;
    private String email;

    // Metodos da classe

    public static Usuario criar(){

        Scanner input = new Scanner(System.in);
        String c_tipo;
        do{
            System.out.println("Informe o tipo de usuario (ex: Aluno | Professor): ");
            c_tipo = input.nextLine().trim();
            if (!c_tipo.isEmpty()) {
                c_tipo = c_tipo.substring(0, 1).toUpperCase() + c_tipo.substring(1).toLowerCase();
            }
            switch (c_tipo){
                case "Aluno":

                    System.out.println("Informe o nome do Aluno: ");
                    String a_nome = input.nextLine();

                    System.out.println("Informe o numero da matricula: ");
                    int a_matricula = input.nextInt();
                    input.nextLine();

                    System.out.println("Informe o cpf do Aluno: ");
                    int a_cpf = input.nextInt();
                    input.nextLine();

                    System.out.println("Informe o email do Aluno: ");
                    String a_email = input.nextLine();

                    System.out.printf(" ---Dados do Aluno---\n"
                            +"\nNOME: " + a_nome
                            +"\nMATRICULA: " + a_matricula
                            +"\nTIPO: " + c_tipo
                            +"\nCPF: " + a_cpf
                            +"\nEMAIL: " + a_email+ "\n");


                    System.out.println("\n Aluno " +a_nome+ " foi cadastrado com sucesso!");

                    return new  Aluno(a_nome,a_matricula,c_tipo,a_cpf,a_email);

                case "Professor":
                    System.out.println("Informe o nome do Professor: ");
                    String p_nome = input.nextLine();

                    System.out.println("Informe o numero da matricula: ");
                    int p_matricula = input.nextInt();
                    input.nextLine();

                    System.out.println("Informe o cpf do Professor: ");
                    int p_cpf = input.nextInt();
                    input.nextLine();

                    System.out.println("Informe o email do Professor: ");
                    String p_email = input.nextLine();

                    System.out.printf(" ---Dados do Professor---\n"
                            +"\nNOME: " + p_nome
                            +"\nMATRICULA: " + p_matricula
                            +"\nTIPO: " + c_tipo
                            +"\nCPF: " + p_cpf
                            +"\nEMAIL: " + p_email+ "\n");


                    System.out.println("\n Professor " +p_nome+ " cadastrado com sucesso!");

                    return new Professor(p_nome,p_matricula,c_tipo,p_cpf,p_email);

                default:
                    System.out.println("Entrada invalida... ");
            }

        }while (!c_tipo.equals("Aluno") && !c_tipo.equals("Professor"));

        return null;

    }


    // Metodo construtor

    public Usuario(String nome, int matricula, String tipo, int cpf, String email) {
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}