package factory;

// Implementação da notificação por push notification
public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("[PUSH] Notificação enviada: " + message);
    }
}