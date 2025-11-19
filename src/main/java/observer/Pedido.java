package observer;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private List<Observer> observadores = new ArrayList<>();
    private String status;

    public void adicionarObservador(Observer observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observer observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores() {
        for (Observer observador : observadores) {
            observador.atualizar(status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        notificarObservadores();
    }

    public String getStatus() {
        return status;
    }
}
