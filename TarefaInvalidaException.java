package br.com.cacaaotesouro;

public class TarefaInvalidaException extends Exception {
    public TarefaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
