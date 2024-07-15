
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nameCurrency1 = "";
        String nameCurrency2 = "";
        boolean validOption = true;

        Scanner scanner = new Scanner(System.in);
        ConsultCurrency consult = new ConsultCurrency();

        while(validOption) {
            System.out.println("""
                **********************************************
                \nWelcome to Currency Converter
                \n1) Dollar =>> Argentine Peso 
                \n2) Argentine Peso =>> Dollar
                \n3) Dollar =>> Brazilian real
                \n4) Brazilian real =>> Dollar
                \n5) Dollar =>> Colombian peso
                \n6) Colombian peso =>> Dollar
                \n7) Exit
                
                \nSelect an option of the menu
                \n**********************************************     
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
            double ammount = scanner.nextDouble();
            scanner.nextLine();
            try {
                CurrencyData currency = consult.searchCurrency(nameCurrency1, nameCurrency2, ammount);
                System.out.println( "The value " + ammount + " [" + nameCurrency1 + "] " +
                        "corresponds to the final value of =>> " + currency.conversion_result() + " [" +
                        nameCurrency2 + "] ");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
