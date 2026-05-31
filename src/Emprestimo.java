import java.util.ArrayList;
import java.util.Scanner;

public class Emprestimo {
    private int numero;
    private Usuario usuario;
    private ArrayList<Livros> livros;
    private String data;
    private String status;
    private boolean ativo;

    public Emprestimo(int numero, Usuario usuario, ArrayList<Livros> livros, String data) {
        this.numero = numero;
        this.usuario = usuario;
        this.livros = livros;
        this.data = data;
        this.status = "Ativo";
        this.ativo = true;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Livros> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livros> livros) {
        this.livros = livros;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean estaAtivo() {
        return ativo;
    }

    public void finalizar() {
        this.status = "Devolvido";
        this.ativo = false;
    }

    public static int menuEmprestimos(Scanner input, ArrayList<Emprestimo> emprestimos,
                                      ArrayList<Usuario> usuarios, ArrayList<Livros> livros,
                                      int numeroEmprestimo) {
        int opcao;

        do {
            System.out.println("\n=== Menu de Emprestimos ===");
            System.out.println("1 - Realizar emprestimo");
            System.out.println("2 - Devolver livros");
            System.out.println("3 - Listar emprestimos");
            System.out.println("0 - Voltar");

            opcao = MenuBiblioteca.lerNumero(input, "Escolha uma opcao:");

            switch (opcao) {
                case 1:
                    numeroEmprestimo = realizarEmprestimo(input, emprestimos, usuarios, livros, numeroEmprestimo);
                    break;
                case 2:
                    devolverLivro(input, emprestimos);
                    break;
                case 3:
                    listarEmprestimos(emprestimos);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        return numeroEmprestimo;
    }

    public static int realizarEmprestimo(Scanner input, ArrayList<Emprestimo> emprestimos,
                                         ArrayList<Usuario> usuarios, ArrayList<Livros> livros,
                                         int numeroEmprestimo) {
        int matriculaEmprestimo = MenuBiblioteca.lerNumero(input, "Informe a matricula do usuario: ");

        Usuario usuarioEmprestimo = Usuario.buscarUsuario(usuarios, matriculaEmprestimo);

        if (usuarioEmprestimo == null) {
            System.out.println("Usuario nao encontrado.");
            return numeroEmprestimo;
        }

        int quantidadeLivros = MenuBiblioteca.lerNumero(input, "Quantos livros deseja emprestar: ");

        if (quantidadeLivros > usuarioEmprestimo.getLimiteEmprestimos()) {
            System.out.println("Quantidade acima do limite para esse usuario.");
            return numeroEmprestimo;
        }

        System.out.println("Informe a data do emprestimo: ");
        String data = input.nextLine();

        ArrayList<Livros> livrosEmprestados = new ArrayList<>();
        int livrosEncontrados = 0;

        for (int i = 0; i < quantidadeLivros; i++) {
            System.out.println("Informe o ISBN do livro: ");
            String isbnEmprestimo = input.nextLine();
            Livros livroEmprestimo = Livros.buscarLivro(livros, isbnEmprestimo);

            if (livroEmprestimo != null && livroEmprestimo.isDisponivel()) {
                livrosEmprestados.add(livroEmprestimo);
                livrosEncontrados++;
            } else {
                System.out.println("Livro nao encontrado ou indisponivel.");
            }
        }

        if (livrosEncontrados == quantidadeLivros) {
            for (Livros livro : livrosEmprestados) {
                livro.emprestar();
            }

            Emprestimo emprestimo = new Emprestimo(numeroEmprestimo, usuarioEmprestimo, livrosEmprestados, data);
            emprestimos.add(emprestimo);
            numeroEmprestimo++;

            System.out.println("Emprestimo realizado com sucesso!");
            emprestimo.mostrarDados();
        } else {
            System.out.println("Emprestimo nao realizado.");
        }

        return numeroEmprestimo;
    }

    public static void devolverLivro(Scanner input, ArrayList<Emprestimo> emprestimos) {
        int numeroDevolucao = MenuBiblioteca.lerNumero(input, "Informe o numero do emprestimo: ");

        Emprestimo emprestimoDevolucao = buscarEmprestimo(emprestimos, numeroDevolucao);

        if (emprestimoDevolucao != null && emprestimoDevolucao.estaAtivo()) {
            for (Livros livro : emprestimoDevolucao.getLivros()) {
                livro.devolver();
            }
            emprestimoDevolucao.finalizar();
            System.out.println("Devolucao realizada com sucesso!");
        } else {
            System.out.println("Emprestimo nao encontrado ou ja devolvido.");
        }
    }

    public static void listarEmprestimos(ArrayList<Emprestimo> emprestimos) {
        boolean encontrou = false;

        for (Emprestimo emprestimo : emprestimos) {
            emprestimo.mostrarDados();
            encontrou = true;
        }

        if (encontrou == false) {
            System.out.println("Nenhum emprestimo cadastrado.");
        }
    }

    public static Emprestimo buscarEmprestimo(ArrayList<Emprestimo> emprestimos, int numero) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getNumero() == numero) {
                return emprestimo;
            }
        }
        return null;
    }

    public void mostrarDados() {
        String livrosTexto = "";
        boolean primeiroLivro = true;

        for (Livros livro : livros) {
            if (primeiroLivro == false) {
                livrosTexto = livrosTexto + ", ";
            }
            livrosTexto = livrosTexto + livro.getTitulo() + " (" + livro.getIsbn() + ")";
            primeiroLivro = false;
        }

        System.out.println("Emprestimo: " + numero
                + " | Usuario: " + usuario.getNome() + " - Matricula: " + usuario.getMatricula()
                + " | Livros: " + livrosTexto
                + " | Data: " + data
                + " | Status: " + status);
    }
}
