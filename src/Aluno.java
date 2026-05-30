public class Aluno extends Usuario{
    //Atributos da classe


    // Metodos da classe


    //Metodos acessadores

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public int getMatricula() {
        return super.getMatricula();
    }

    @Override
    public void setMatricula(int matricula) {
        super.setMatricula(matricula);
    }

    @Override
    public String getTipo() {
        return super.getTipo();
    }

    @Override
    public void setTipo(String tipo) {
        super.setTipo(tipo);
    }

    @Override
    public int getCpf() {
        return super.getCpf();
    }

    @Override
    public void setCpf(int cpf) {
        super.setCpf(cpf);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    // Construtor super_class
    public Aluno(String nome, int matricula, String tipo, int cpf, String email) {
        super(nome, matricula, tipo, cpf, email);
    }
}
