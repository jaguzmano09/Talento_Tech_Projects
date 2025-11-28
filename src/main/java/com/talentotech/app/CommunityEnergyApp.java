package com.talentotech.app;


import com.talentotech.dao.CommunityDAO;
import com.talentotech.model.Community;
import com.talentotech.util.DatabaseConnection;
import java.util.List;
import java.util.Scanner;

public class CommunityEnergyApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final CommunityDAO communityDAO = new CommunityDAO();

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE COMUNIDADES ENERGÉTICAS ===");

        if (!DatabaseConnection.testConnection()) {
            System.err.println("No hay conexión a la base de datos.");
            return;
        }

        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione opción: ");
            continuar = procesarOpcion(opcion);
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Listar Comunidades");
        System.out.println("2. Buscar Comunidad por ID");
        System.out.println("3. Insertar Comunidad");
        System.out.println("4. Eliminar Comunidad");
        System.out.println("5. Eliminar Comunidad");
        System.out.println("0. Salir");
    }

    private static boolean procesarOpcion(int opcion) {
        switch (opcion) {
            case 1: listarComunidades(); break;
            case 2: buscarComunidad(); break;
            case 3: insertarComunidad(); break;
            case 4: eliminarComunidad(); break;
            case 0: return false;
            default: System.out.println("Opción no válida");
        }
        return true;
    }

    private static void listarComunidades() {
        List<Community> lista = communityDAO.listarTodos();
        System.out.println("\nLISTA DE COMUNIDADES (" + lista.size() + "):");
        for (Community c : lista) {
            System.out.printf("ID: %d | %s | %s | Meta: %.2f MW%n",
                    c.getCommunityId(), c.getNombre(), c.getRegion(), c.getMetaEnergiaMW());
        }
    }

    private static void insertarComunidad() {
        System.out.println("\n--- NUEVA COMUNIDAD ---");
        System.out.print("Nombre: "); String nombre = scanner.nextLine();
        System.out.print("Región: "); String region = scanner.nextLine();
        int pob = leerEntero("Población: ");
        int ano = leerEntero("Año Inicio: ");
        double meta = leerDouble("Meta MW: ");

        Community c = new Community(0, nombre, region, pob, ano, meta);
        if (communityDAO.insertar(c) > 0) {
            System.out.println("✅ Comunidad guardada.");
        } else {
            System.out.println("❌ Error al guardar.");
        }
    }

    private static void buscarComunidad() {
        int id = leerEntero("ID a buscar: ");
        Community c = communityDAO.buscarPorId(id);
        if (c != null) System.out.println("Encontrada: " + c);
        else System.out.println("No existe.");
    }

    private static void eliminarComunidad() {
        int id = leerEntero("ID a eliminar: ");
        if (communityDAO.eliminar(id) > 0) System.out.println("✅ Eliminada.");
        else System.out.println("❌ Error o no existe.");
    }

    // Utilidades de Lectura
    private static int leerEntero(String msg) {
        System.out.print(msg);
        try { return Integer.parseInt(scanner.nextLine()); }
        catch (Exception e) { return 0; }
    }

    private static double leerDouble(String msg) {
        System.out.print(msg);
        try { return Double.parseDouble(scanner.nextLine()); }
        catch (Exception e) { return 0.0; }
    }
}