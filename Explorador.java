package br.com.cacaaotesouro;

import java.util.concurrent.Semaphore;

public abstract class Explorador implements Runnable {
    private String nome;
    private String tipo;
    private int prioridade;
    private Tarefa tarefa;
    private Semaphore semaforo;

    public Explorador(String nome, String tipo, int prioridade, Tarefa tarefa, Semaphore semaforo) {
        this.nome = nome;
        this.tipo = tipo;
        this.prioridade = prioridade;
        this.tarefa = tarefa;
        this.semaforo = semaforo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public Semaphore getSemaforo() {
        return semaforo;
    }

    // Método abstrato exigido pelo enunciado
    public abstract void executarTarefa();

    @Override
    public void run() {
        try {
            // Validar a exceção customizada antes de tentar obter a permissão
            if (this.tarefa == null || this.tarefa.getDescricao().trim().isEmpty()) {
                throw new TarefaInvalidaException("Tarefa inválida para " + this.nome);
            }

            // Exibir mensagem aguardando permissão do semáforo
            System.out.println(this.nome + " aguardando permissão...");
            
            // Adquire uma licença do semáforo (Região Crítica sincronizada)
            semaforo.acquire();
            
            // Executa a lógica de busca diferenciada de cada subclasse
            executarTarefa();
            
        } catch (TarefaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("O explorador " + this.nome + " foi interrompido.");
            Thread.currentThread().interrupt();
        } finally {
            // Garante a liberação do semáforo mesmo se ocorrer erro na execução
            if (this.tarefa != null && !this.tarefa.getDescricao().trim().isEmpty()) {
                semaforo.release();
            }
        }
    }
}
