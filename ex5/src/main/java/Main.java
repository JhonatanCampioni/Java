import factory.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SISTEMA DE NOTIFICAÇÕES ===");
            System.out.println("Escolha um tipo de notificação (email, sms, push) ou digite 'sair' para encerrar.");
            System.out.print("Tipo: ");

            String type = scanner.nextLine().trim().toLowerCase();
            if (type.equals("sair")) break;

            System.out.print("Digite a mensagem a ser enviada: ");
            String message = scanner.nextLine();

            try {
                Notification notification = NotificationFactory.createNotification(type);
                notification.send(message);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage() + "\n");
            }
        }

        System.out.println("Encerrando o sistema de notificações...");
        scanner.close();
    }
}
