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

    public String getStatus() {
        return disponivel ? "Disponivel" : "Emprestado";
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + " | Titulo: " + titulo + " | Autor: " + autor + " | Editora: " + editora + " | Status: " + getStatus();
    }
}
