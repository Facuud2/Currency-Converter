package github.facuud2.main;

import github.facuud2.services.ConvertionRate;
import github.facuud2.services.ConvertionRateRec;
import github.facuud2.services.PairConvertion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PairConvertion pairConvertion = new PairConvertion();

        Map<Integer, String[]> conversiones = new HashMap<>();
        conversiones.put(1, new String[]{"ARS", "USD"});
        conversiones.put(2, new String[]{"USD", "ARS"});
        conversiones.put(3, new String[]{"USD", "EUR"});
        conversiones.put(4, new String[]{"EUR", "USD"});
        conversiones.put(5, new String[]{"USD", "BRL"});
        conversiones.put(6, new String[]{"BRL", "USD"});

        try (Scanner scanner = new Scanner(System.in)) {
            int option;
            do {
                System.out.printf("""
                    Selecciona una de las siguientes opciones: 
                    1. ARS -> USD
                    2. USD -> ARS
                    3. USD -> EUR
                    4. EUR -> USD
                    5. USD -> BRL
                    6. BRL -> USD 
                    
                    9. Salir\n""");

                option = scanner.nextInt();

                if (option >= 1 && option <= 6) {
                    System.out.println("Ingrese la cantidad a convertir: ");
                    float cantidad = scanner.nextFloat();

                    String[] codigos = conversiones.get(option);
                    String base_code = codigos[0];
                    String target_code = codigos[1];

                    ConvertionRateRec convertionRateRec = pairConvertion.pairConvertion(base_code, target_code);
                    ConvertionRate convertionRate = new ConvertionRate(convertionRateRec);


                    System.out.printf("""
                    La cantidad %.2f [%s] equivalen a %.2f [%s]\n""",
                            cantidad, base_code, cantidad * convertionRate.getConversion_rate(), target_code);
                }
            } while (option != 9);
        } catch (Exception e) {
            System.out.println("Se produjo un error inesperado: " + e);
        }
    }
}
