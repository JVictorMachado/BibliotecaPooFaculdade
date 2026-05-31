import java.util.ArrayList;
import java.util.Scanner;

public class Livros {
    private String titulo;
    private String autor;
    private String isbn;
    private int ano;
    private String editora;
    private boolean disponivel;

    public Livros(String titulo, String autor, String isbn, int ano, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ano = ano;
        this.editora = editora;
        this.disponivel = true;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {

        this.autor = autor;
    }

    public String getIsbn() {

        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getStatus() {
        if (disponivel) {
            return "Disponivel";
        } else {
            return "Emprestado";
        }
    }

    public static void menuLivros(Scanner input, ArrayList<Livros> livros) {
        int opcao;

        do {
            System.out.println("\n=== Menu de Livros ===");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Consultar livro");
            System.out.println("3 - Listar livros");
            System.out.println("0 - Voltar");
            System.out.println("Escolha uma opcao:");

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarLivro(input, livros);
                    opcao = 0;
                    break;
                case 2:
                    consultarLivro(input, livros);
                    break;
                case 3:
                    listarLivros(livros);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    public static void cadastrarLivro(Scanner input, ArrayList<Livros> livros) {
        System.out.println("Qual o titulo do livro: ");
        String titulo = input.nextLine();

        System.out.println("Informe o autor: ");
        String autor = input.nextLine();

        System.out.println("Informe o ISBN: ");
        String isbn = input.nextLine();

        System.out.println("Informe o ano: ");
        int ano = input.nextInt();
        input.nextLine();

        System.out.println("Informe a editora: ");
        String editora = input.nextLine();

        Livros livro = new Livros(titulo, autor, isbn, ano, editora);
        livros.add(livro);

        System.out.println("O livro " + titulo + " foi cadastrado com sucesso!");
    }

    public static void consultarLivro(Scanner input, ArrayList<Livros> livros) {
        System.out.println("Informe o ISBN do livro que deseja consultar: ");
        String isbnConsulta = input.nextLine();
        Livros livroConsulta = buscarLivro(livros, isbnConsulta);

        if (livroConsulta != null) {
            livroConsulta.mostrarDados();
        } else {
            System.out.println("Livro nao encontrado.");
        }
    }

    public static void listarLivros(ArrayList<Livros> livros) {
        boolean encontrou = false;

        for (Livros livro : livros) {
            livro.mostrarDados();
            encontrou = true;
        }

        if (encontrou == false) {
            System.out.println("Nenhum livro cadastrado.");
        }
    }

    public static Livros buscarLivro(ArrayList<Livros> livros, String isbn) {
        for (Livros livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                return livro;
            }
        }
        return null;
    }

    public void mostrarDados() {
        System.out.println("ISBN: " + isbn
                + " | Titulo: " + titulo
                + " | Autor: " + autor
                + " | Editora: " + editora
                + " | Status: " + getStatus());
    }
}
