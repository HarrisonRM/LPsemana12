package com.example;

import java.util.Scanner;

public class BancoSimple {
    public static void main(String[] args) {

        String[] nombres = { "Juan Pérez", "María González", "Carlos López" };
        double[] saldos = { 1500.00, 800.00, 1200.00 };
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("----- Menú -----");
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Consultar Saldo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 4) {
                System.out.println("¡Gracias por usar el Banco Simple!");
                break;
            }

            System.out.println("Seleccione una cuenta:");
            for (int i = 0; i < nombres.length; i++) {
                System.out.println(i + ". " + nombres[i]);
            }
            System.out.print("Ingrese el índice de la cuenta: ");
            int indice = scanner.nextInt();

            if (indice < 0 || indice >= nombres.length) {
                System.out.println("Índice inválido. Intente de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double montoDeposito = scanner.nextDouble();
                    saldos[indice] += montoDeposito;
                    System.out.println("Depósito realizado en " + nombres[indice]);
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double montoRetiro = scanner.nextDouble();
                    if (saldos[indice] >= montoRetiro) {
                        saldos[indice] -= montoRetiro;
                        System.out.println("Retiro realizado de " + nombres[indice]);
                    } else {
                        System.out.println("Saldo insuficiente en la cuenta de " + nombres[indice]);
                    }
                    break;
                case 3:
                    System.out.println("El saldo de " + nombres[indice] + " es: " + saldos[indice]);
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}