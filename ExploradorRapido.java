package modelo;

public class ExploradorRapido extends Explorador implements Runnable {
    
    public ExploradorRapido(String nome, String tarefa) {
        super(nome, "Rápido", 1, tarefa);
    }

    @Override
    public void executarTarefa() {
        if (getTarefa() == null || getTarefa().isEmpty()) {
            throw new IllegalArgumentException("TarefaInvalidaException: Tarefa nula ou inválida.");
        }
        System.out.println("Explorador: " + getNome() + " | Tipo: " + getTipo() + " | Status: Vasculhando a caverna rapidamente!");
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
