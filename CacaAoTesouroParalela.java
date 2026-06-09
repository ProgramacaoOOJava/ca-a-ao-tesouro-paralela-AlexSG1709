package br.com.cacaaotesouro;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class CacaAoTesouroParalela {
    public static void main(String[] args) {
        System.out.println("--- Desafio Caça ao Tesouro Paralela - Nível Aventureiro --- \n");

        // Configuração do Semáforo: permite que apenas 2 exploradores atuem simultaneamente no mapa
        Semaphore semaforoMapa = new Semaphore(2);

        // Criação de Objetos Imutáveis (Tarefas)
        Tarefa t1 = new Tarefa("Vasculhando a caverna!");
        Tarefa t2 = new Tarefa("Mapeando a floresta com cautela.");
        Tarefa t3 = new Tarefa("Explorando ruínas antigas.");
        Tarefa t4 = new Tarefa(""); // Provocará a exceção customizada

        // Lista para gerenciar as Threads conforme pedido nas Simplificações
        ArrayList<Thread> listaThreads = new ArrayList<>();

        // Instanciando os 4 exploradores (Passando os parâmetros exigidos)
        Explorador exp1 = new ExploradorRapido("Alice", 3, t1, semaforoMapa);
        Explorador exp2 = new ExploradorCuidadoso("Bob", 1, t2, semaforoMapa);
        Explorador exp3 = new ExploradorRapido("Charlie", 2, t3, semaforoMapa);
        Explorador exp4 = new ExploradorCuidadoso("Clara", 1, t4, semaforoMapa);

        // Criando as Threads vinculadas aos comportamentos Runnable dos exploradores
        Thread thread1 = new Thread(exp1);
        Thread thread2 = new Thread(exp2);
        Thread thread3 = new Thread(exp3);
        Thread thread4 = new Thread(exp4);

        // Adicionando na ArrayList
        listaThreads.add(thread1);
        listaThreads.add(thread2);
        listaThreads.add(thread3);
        listaThreads.add(thread4);

        // Inicializando a execução concorrente de todas as threads ao mesmo tempo
        for (Thread t : listaThreads) {
            t.start();
        }

        // Aguarda a finalização para organizar a saída do console de forma limpa
        for (Thread t : listaThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n--- Expedição do Nível Aventureiro Finalizada ---");
    }
}
