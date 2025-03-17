package factory;

// Implementação da notificação por SMS
public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("[SMS] Notificação enviada: " + message);
    }
}