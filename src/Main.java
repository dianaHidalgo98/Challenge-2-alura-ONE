
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nameCurrency1 = "";
        String nameCurrency2 = "";

        Scanner scanner = new Scanner(System.in);
        ConsultCurrency consult = new ConsultCurrency();

        while (true) {
            System.out.println("""
                    **********************************************
                    Welcome to Currency Converter
                    1) Dollar =>> Argentine Peso
                    2) Argentine Peso =>> Dollar
                    3) Dollar =>> Brazilian real
                    4) Brazilian real =>> Dollar
                    5) Dollar =>> Colombian peso
                    6) Colombian peso =>> Dollar
                    7) Exit
                    \nSelect an option of the menu
                    **********************************************
                    """);
            var nameCurrency = scanner.nextLine();

            switch (nameCurrency) {
                case "1":
                    nameCurrency1 = "USD";
                    nameCurrency2 = "ARS";
                    break;
                case "2":
                    nameCurrency1 = "ARS";
                    nameCurrency2 = "USD";
                    break;
                case "3":
                    nameCurrency1 = "USD";
                    nameCurrency2 = "BRL";
                    break;
                case "4":
                    nameCurrency1 = "BRL";
                    nameCurrency2 = "USD";
                    break;
                case "5":
                    nameCurrency1 = "USD";
                    nameCurrency2 = "COP";
                    break;
                case "6":
                    nameCurrency1 = "COP";
                    nameCurrency2 = "USD";
                    break;
                case "7":
                    System.out.println("End of program");
                    return;
                default:
                    System.out.println("Invalid option");
                    continue;
            }

            System.out.println("Enter the value you wish to convert: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            try {
                CurrencyData currency = consult.searchCurrency(nameCurrency1, nameCurrency2, amount);
                System.out.println("The value " + amount + " [" + nameCurrency1 + "] " +
                        "corresponds to the final value of =>> " + currency.conversion_result() + " [" +
                        nameCurrency2 + "]\n");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
