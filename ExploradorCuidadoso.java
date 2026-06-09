package modelo;

public class ExploradorCuidadoso extends Explorador implements Runnable {

    public ExploradorCuidadoso(String nome, String tarefa) {
        super(nome, "Cuidadoso", 2, tarefa);
    }

    @Override
    public void executarTarefa() {
        if (getTarefa() == null || getTarefa().isEmpty()) {
            throw new IllegalArgumentException("TarefaInvalidaException: Tarefa nula ou inválida.");
        }
        System.out.println("Explorador: " + getNome() + " | Tipo: " + getTipo() + " | Status: Mapeando a floresta com cautela.");
    }

    @Override
    public void run() {
        try {
            executarTarefa();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage() + " para " + getNome());
        }
    }
}

