package com.myapp.presentation;

import com.myapp.data.InMemoryMediaRepository;
import com.myapp.data.MediaStock;

import java.util.Scanner;

public class ConsoleUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            InMemoryMediaRepository repository = new InMemoryMediaRepository();
            LoanFacade facade = new LoanFacade(repository);
            LoanRequestDTO dto = new LoanRequestDTO();
            while (true) {
                System.out.print("Título: ");
                String title = sc.nextLine();
                if (title.trim().isEmpty()) {
                    System.out.println("El título no puede estar vacío. Intente de nuevo.");
                    continue;
                }
                if (repository.findStock(title).isPresent()) {
                    dto.setTitle(title);
                    break;
                }
                System.out.println("Título no disponible en el catálogo. Intente con otro nombre.");
            }

            // Selección de tipo de medio con verificación en tiempo real
            while (true) {
                System.out.print("Tipo (DVD/BluRay): ");
                String type = sc.nextLine();
                if (type.equalsIgnoreCase("DVD") || type.equalsIgnoreCase("BluRay")) {
                    dto.setType(type);
                    if (repository.findStock(dto.getTitle()).get().isAvailable(type)) break;
                    else System.out.println("No hay stock disponible de " + type + ". Elija otro formato.");
                } else {
                    System.out.println("Tipo inválido. Debe ser DVD o BluRay.");
                }
            }

            // Entrada de días de préstamo con validación
            while (true) {
                System.out.print("Días de préstamo: ");
                try {
                    int days = Integer.parseInt(sc.nextLine());
                    if (days <= 0) {
                        System.out.println("El número de días debe ser mayor a cero.");
                        continue;
                    }
                    dto.setDays(days);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(" Por favor, ingrese un número válido.");
                }
            }

            // Opciones de socio y seguro
            System.out.print("¿Es socio? (s/n): ");
            dto.setMember(sc.nextLine().equalsIgnoreCase("s"));

            System.out.print("¿Desea agregar seguro? (s/n): ");
            dto.setInsurance(sc.nextLine().equalsIgnoreCase("s"));

            // Procesamiento del préstamo
            try {
                double cost = facade.submitLoan(dto);
                System.out.println("\n===== RESUMEN DEL PRÉSTAMO =====");
                System.out.println("Título: " + dto.getTitle());
                System.out.println("Formato: " + dto.getType());
                System.out.println("Días: " + dto.getDays());
                System.out.println("Socio: " + (dto.isMember() ? "Sí" : "No"));
                System.out.println("Seguro: " + (dto.isInsurance() ? "Sí" : "No"));
                System.out.printf("Costo total: %.2f Bs\n", cost);
            } catch (Exception ex) {
                System.out.println("\nERROR: " + ex.getMessage());
            }
        } finally {
            // Cerrar el Scanner para evitar fugas de recursos
            sc.close();
        }
    }
}
