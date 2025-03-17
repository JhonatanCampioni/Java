package factory;

// Implementação da notificação por e-mail
public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("[EMAIL] Notificação enviada: " + message);
    }
}