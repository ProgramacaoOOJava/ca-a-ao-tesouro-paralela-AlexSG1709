package br.com.cacaaotesouro;

import java.util.concurrent.Semaphore;

public class ExploradorRapido extends Explorador {

    public ExploradorRapido(String nome, int prioridade, Tarefa tarefa, Semaphore semaforo) {
        super(nome, "Rápido", prioridade, tarefa, semaforo);
    }

    @Override
    public void executarTarefa() {
        System.out.println("Explorador: " + getNome() + " | Tipo: " + getTipo() + " | Status: " + getTarefa().getDescricao());
        try {
            // Explorador rápido termina a ação em menos tempo (simulação)
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
