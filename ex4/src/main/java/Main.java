import strategy.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SISTEMA DE PAGAMENTOS ===");
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
            scanner.nextLine();

            System.out.print("Confirmar pagamento de R$" + String.format("%.2f", amount) + "? (S/N): ");
            String confirm = scanner.nextLine().trim().toUpperCase();

            if (!confirm.equals("S")) {
                System.out.println("Pagamento cancelado.\n");
                continue;
            }

            PaymentStrategy strategy;
            switch (choice) {
                case 1:
                    strategy = new PixPayment();
                    break;
                case 2:
                    strategy = new CreditCardPayment();
                    break;
                case 3:
                    strategy = new BoletoPayment();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.\n");
                    continue;
            }

            PaymentProcessor processor = new PaymentProcessor(strategy);
            processor.executePayment(amount);
        }

        System.out.println("Encerrando o sistema de pagamentos...");
        scanner.close();
    }
}
