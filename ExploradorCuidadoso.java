package br.com.cacaaotesouro;

import java.util.concurrent.Semaphore;

public class ExploradorCuidadoso extends Explorador {

    public ExploradorCuidadoso(String nome, int prioridade, Tarefa tarefa, Semaphore semaforo) {
        super(nome, "Cuidadoso", prioridade, tarefa, semaforo);
    }

    @Override
    public void executarTarefa() {
        System.out.println("Explorador: " + getNome() + " | Tipo: " + getTipo() + " | Status: " + getTarefa().getDescricao());
        try {
            // Explorador cuidadoso demora mais tempo analisando o terreno (simulação)
            Thread.sleep(2500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
