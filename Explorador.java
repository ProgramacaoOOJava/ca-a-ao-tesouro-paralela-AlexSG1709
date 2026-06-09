package modelo;

public abstract class Explorador {
    private String nome;
    private String tipo;
    private int prioridade;
    private String tarefa;

    public Explorador(String nome, String tipo, int prioridade, String tarefa) {
        this.nome = nome;
        this.tipo = tipo;
        this.prioridade = prioridade;
        this.tarefa = tarefa;
    }

    public abstract void executarTarefa();

    // Getters e Setters
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public int getPrioridade() { return prioridade; }
    public String getTarefa() { return tarefa; }
    
    public void setTarefa(String tarefa) { this.tarefa = tarefa; }
}/**
 * Classe abstrata que representa um explorador na Caça ao Tesouro Paralela.
 * Define a estrutura básica para diferentes tipos de exploradores.
 */
public abstract class Explorador {
    
    // * Construtor que inicializa todos os atributos do explorador.
    


    /**
     * Método abstrato que deve ser implementado pelas subclasses.
     * Define como cada tipo de explorador executa sua tarefa.
     * @throws TarefaInvalidaException Se a tarefa for inválida
     */
    public abstract void executarTarefa() throws TarefaInvalidaException;
    
    /**
     * Exibe o status completo do explorador com formatação clara.
     */
    public void exibirStatus() {

    }
    
    // Getters para acesso aos atributos encapsulados


}

