
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Préstamo DVDs/Blu-ray ===");
        System.out.print("Tipo de medio (DVD/BluRay): ");
        String type = sc.nextLine().trim();

        System.out.print("Título: ");
        String title = sc.nextLine().trim();

        MediaFactory factory = type.equalsIgnoreCase("BluRay")
            ? new BluRayFactory()
            : new DVDFactory();
        MediaItem media = factory.createMedia(title);

        System.out.print("Días de préstamo: ");
        int days = Integer.parseInt(sc.nextLine().trim());

        System.out.print("¿Es socio? (s/n): ");
        boolean isMember = sc.nextLine().equalsIgnoreCase("s");
        PricingStrategy strat = isMember
            ? new MemberPricingStrategy()
            : new StandardPricingStrategy();

        ILoan loan = new BasicLoan(media, days, strat);

        System.out.print("¿Añadir seguro (+2 Bs)? (s/n): ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            loan = new InsuranceDecorator(loan);
        }

        double cost = loan.calculateCost();
        System.out.println("Prestamo de el:"+media.getTitle()+" - por: "+days+"dias");
        System.out.printf("Costo Total:"+cost);
    }
}