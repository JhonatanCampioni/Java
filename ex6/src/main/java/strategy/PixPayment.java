package strategy;

import java.util.Random;

public class PixPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        String pixCode = "PIX-" + new Random().nextInt(100000);
        System.out.println("Pagamento via Pix iniciado.");
        System.out.println("Código Pix: " + pixCode);
        System.out.println("Pagamento de R$" + amount + " realizado com sucesso!\n");
    }
}