import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Préstamo DVDs/Blu-ray ===");

        boolean right = false;
        String title = "";
        while (!right) {
            System.out.print("Título: ");
            title = sc.nextLine().trim();
            if (!title.isEmpty()) {
                right = true;
            } else {
                System.out.println("El título no puede estar vacío.");
            }
        }

        right = false;
        String type = "";
        while (!right) {
            System.out.print("Tipo de medio (DVD/BluRay): ");
            type = sc.nextLine().trim();
            if (type.equalsIgnoreCase("DVD") ||
                type.equalsIgnoreCase("BluRay")) {
                right = true;
            } else {
                System.out.println("Opción inválida. Debes escribir 'DVD' o 'BluRay'.");
            }
        }

        //  ✅  Nuevo código
        MediaItem media = MediaSimpleFactory.create(type, title);
        

        right = false;
        int days = 0;
        while (!right) {
            System.out.print("Días de préstamo: ");
            String line = sc.nextLine().trim();
            try {
                days = Integer.parseInt(line);
                if (days > 0) {
                    right = true;
                } else {
                    System.out.println("Debe ser un número entero mayor que 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingresa un número entero.");
            }
        }

        boolean isMember = askYesNo(sc, "¿Es socio?");


        // Elegimos la estrategia de precio
        PricingStrategy strat = isMember
            ? new MemberPricingStrategy()
            : new StandardPricingStrategy();
        ILoan loan = new BasicLoan(media, days, strat);

        boolean withInsurance = askYesNo(sc, "¿Añadir seguro (+2 Bs)?");


        if (withInsurance) {
            loan = new InsuranceDecorator(loan);
        }

        double cost = loan.calculateCost();
        System.out.printf(
            "Préstamo de"+media.getTitle()+" por"+ days +"días: costo total = "+cost+"Bs %n"
        );
    }
    private static boolean askYesNo(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt + " (s/n): ");
            String resp = sc.nextLine().trim();
            if (resp.equalsIgnoreCase("s")) {
                return true;
            } else if (resp.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Opción inválida. Debes responder 's' o 'n'.");
            }
        }
    }
}
