package strategy;

import java.util.UUID;

public class PixPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        String pixKey = generatePixKey();
        System.out.println("Pagamento via PIX gerado.");
        System.out.println("Chave PIX: " + pixKey);
        System.out.println("Pagamento de R$" + String.format("%.2f", amount) + " realizado com sucesso!\n");
    }

    private String generatePixKey() {
        return UUID.randomUUID().toString();
    }
}
