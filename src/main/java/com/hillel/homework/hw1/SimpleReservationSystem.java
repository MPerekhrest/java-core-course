package com.hillel.homework.hw1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SimpleReservationSystem {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        ArrayList<Table> tables = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            tables.add(new Table(i));
        }

        boolean running = true;

        while (running) {
            System.out.println("1. Display tables");
            System.out.println("2. Reserve Table");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.println("Select an option: ");
            try {
                int option = Integer.parseInt(bufferedReader.readLine());

                switch (option) {
                    case 1:
                        displayTables(tables);
                        break;
                    case 2:
                        reserveTable(tables, bufferedReader);
                        break;
                    case 3:
                        cancelReservation(tables, bufferedReader);
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option, Please try again");
                }
            }catch (IOException | NumberFormatException e){
                System.out.println("Invalid input. Please enter a number");
            }
        }
    }

    private static void displayTables(ArrayList<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }

    }

    private static void reserveTable(ArrayList<Table> tables, BufferedReader bufferedReader) throws IOException {
        System.out.println("Enter table number to reserve: ");
        try {
            int tableNumber = Integer.parseInt(bufferedReader.readLine());
            if (tableNumber > 0 && tableNumber <= tables.size()) {
                Table table = tables.get(tableNumber - 1);
                if (!table.isReserved()) {
                    table.reserve();
                    System.out.println("Table " + tableNumber + " has been reserved.");
                } else {
                    System.out.println("table is already reserved.");
                }
            } else {
                System.out.println("Invalid table number.");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number");
        }
    }

    public static void cancelReservation(ArrayList<Table> tables, BufferedReader bufferedReader) throws IOException {
        System.out.print("Enter table number to cancel reservation: ");
        try {
            int tableNumber = Integer.parseInt(bufferedReader.readLine());
            if (tableNumber > 0 && tableNumber <= tables.size()) {
                Table table = tables.get(tableNumber - 1);
                if (table.isReserved()) {
                    table.cancelReservation();
                    System.out.println("Reservation for table " + tableNumber + " has been cancelled.");
                } else {
                    System.out.println("table is not reserved.");
                }
            } else {
                System.out.println("Invalid table number.");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number");
        }
    }
}




