import factory.PaymentFactory;
import strategy.PaymentProcessor;
import strategy.PaymentStrategy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecione um método de pagamento:");
            System.out.println("1: Pix");
            System.out.println("2: Cartão de Crédito");
            System.out.println("3: Boleto");
            System.out.println("4: Sair");
            System.out.print("Opção: ");

            int choice = scanner.nextInt();
            if (choice == 4) break;

            System.out.print("Digite o valor da transação: R$");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha

            String paymentType = switch (choice) {
                case 1 -> "pix";
                case 2 -> "cartao";
                case 3 -> "boleto";
                default -> {
                    System.out.println("Opção inválida, tente novamente.\n");
                    yield null;
                }
            };

            if (paymentType == null) continue;

            PaymentStrategy strategy = PaymentFactory.createPaymentMethod(paymentType);
            PaymentProcessor processor = new PaymentProcessor(strategy);
            processor.executePayment(amount);
        }

        System.out.println("Encerrando o sistema de pagamentos...");
        scanner.close();
    }
}