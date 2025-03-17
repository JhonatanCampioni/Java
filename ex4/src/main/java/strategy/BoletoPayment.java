package strategy;

import java.util.Random;

public class BoletoPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        String boletoCode = generateBoletoCode();
        System.out.println("Pagamento via Boleto gerado.");
        System.out.println("Código do Boleto: " + boletoCode);
        System.out.println("Pagamento de R$" + amount + " realizado com sucesso!\n");
    }

    private String generateBoletoCode() {
        return "BOLETO-" + new Random().nextInt(100000);
    }
}