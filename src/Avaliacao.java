public class Avaliacao {
    private int estrelas; // 1 a 5
    private String comentario;
    private Cliente autor; // Quem falou mal?

    public Avaliacao(int estrelas, String comentario, Cliente autor) {
        this.estrelas = estrelas;
        this.comentario = comentario;
        this.autor = autor;
    }
    // getters...
}