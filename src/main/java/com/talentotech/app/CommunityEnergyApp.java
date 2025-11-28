package com.talentotech.app;

import com.talentotech.dao.CommunityDAO;
import com.talentotech.dao.EnergyProjectDAO;
import com.talentotech.dao.HouseholdDAO;

import com.talentotech.model.Community;
import com.talentotech.model.EnergyProject;
import com.talentotech.model.Household;

import com.talentotech.util.DatabaseConnection;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CommunityEnergyApp {

    private static final Scanner scanner = new Scanner(System.in);

    private static final CommunityDAO communityDAO = new CommunityDAO();
    private static final EnergyProjectDAO projectDAO = new EnergyProjectDAO();
    private static final HouseholdDAO householdDAO = new HouseholdDAO();

    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE COMUNIDADES ENERGÉTICAS ===");

        if (!DatabaseConnection.testConnection()) {
            System.err.println("❌ No hay conexión a la base de datos.");
            return;
        }

        boolean continuar = true;

        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = leerEntero("Seleccione opción: ");
            continuar = procesarMenuPrincipal(opcion);
        }

        scanner.close();
    }

    // ============================
    // MENÚ PRINCIPAL
    // ============================
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Gestionar Comunidades");
        System.out.println("2. Gestionar Proyectos Energéticos");
        System.out.println("3. Gestionar Households");
        System.out.println("0. Salir");
    }

    private static boolean procesarMenuPrincipal(int opcion) {
        switch (opcion) {
            case 1: menuComunidades(); break;
            case 2: menuProyectos(); break;
            case 3: menuHouseholds(); break;
            case 0: return false;
            default: System.out.println("Opción no válida.");
        }
        return true;
    }


    // ==========================================================
    // SUBMENÚ DE COMUNIDADES
    // ==========================================================
    private static void menuComunidades() {
        System.out.println("\n--- MENÚ COMUNIDADES ---");
        System.out.println("1. Listar");
        System.out.println("2. Buscar por ID");
        System.out.println("3. Insertar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver");

        int opcion = leerEntero("Seleccione: ");

        switch (opcion) {
            case 1: listarComunidades(); break;
            case 2: buscarComunidad(); break;
            case 3: insertarComunidad(); break;
            case 4: eliminarComunidad(); break;
            case 0: return;
            default: System.out.println("Opción inválida.");
        }
    }

    private static void listarComunidades() {
        List<Community> lista = communityDAO.listarTodos();
        System.out.println("\n--- COMUNIDADES ---");
        lista.forEach(c ->
                System.out.printf("ID %d | %s | %s%n", c.getCommunityId(), c.getNombre(), c.getRegion())
        );
    }

    private static void insertarComunidad() {
        System.out.println("\n--- NUEVA COMUNIDAD ---");
        String nombre = leerTexto("Nombre: ");
        String region = leerTexto("Región: ");
        int pop = leerEntero("Población: ");
        int ano = leerEntero("Año inicio: ");
        double meta = leerDouble("Meta MW: ");

        Community c = new Community(0, nombre, region, pop, ano, meta);

        if (communityDAO.insertar(c) > 0)
            System.out.println("✅ Comunidad Insertada.");
        else
            System.out.println("❌ Error al insertar.");
    }

    private static void buscarComunidad() {
        int id = leerEntero("ID: ");
        Community c = communityDAO.buscarPorId(id);
        System.out.println(c != null ? c : "No encontrada.");
    }

    private static void eliminarComunidad() {
        int id = leerEntero("ID: ");
        if (communityDAO.eliminar(id) > 0)
            System.out.println("Eliminada.");
        else
            System.out.println("Error al eliminar.");
    }


    // ==========================================================
    // SUBMENÚ DE PROYECTOS
    // ==========================================================
    private static void menuProyectos() {
        System.out.println("\n--- MENÚ PROYECTOS ENERGÉTICOS ---");
        System.out.println("1. Listar");
        System.out.println("2. Buscar por ID");
        System.out.println("3. Insertar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver");

        int opcion = leerEntero("Seleccione: ");

        switch (opcion) {
            case 1: listarProyectos(); break;
            case 2: buscarProyecto(); break;
            case 3: insertarProyecto(); break;
            case 4: eliminarProyecto(); break;
            case 0: return;
            default: System.out.println("Opción inválida.");
        }
    }

    private static void listarProyectos() {
        List<EnergyProject> lista = projectDAO.listarTodos();
        System.out.println("\n--- PROYECTOS ---");
        lista.forEach(p ->
                System.out.printf("ID %d | Tipo: %s | %.2f MW%n",
                        p.getProject_id(), p.getTipo_proyecto(), p.getCapacidad_MW())
        );
    }

    private static void insertarProyecto() {
        System.out.println("\n--- NUEVO PROYECTO ---");
        int community = leerEntero("Community ID: ");
        String tipo = leerTexto("Tipo de proyecto: ");
        double capacidad = leerDouble("Capacidad MW: ");
        String estado = leerTexto("Estado: ");
        LocalDate fecha = LocalDate.parse(leerTexto("Fecha lanzamiento (YYYY-MM-DD): "));

        EnergyProject p = new EnergyProject(0, community, tipo, capacidad, estado, fecha);

        if (projectDAO.insertar(p) > 0)
            System.out.println("Proyecto creado.");
        else
            System.out.println("Error.");
    }

    private static void buscarProyecto() {
        int id = leerEntero("ID: ");
        EnergyProject p = projectDAO.buscarPorId(id);
        System.out.println(p != null ? p : "No encontrado.");
    }

    private static void eliminarProyecto() {
        int id = leerEntero("ID: ");
        if (projectDAO.eliminar(id) > 0) System.out.println("Eliminado.");
        else System.out.println("Error.");
    }


    // ==========================================================
    // SUBMENÚ DE HOUSEHOLDS
    // ==========================================================
    private static void menuHouseholds() {
        System.out.println("\n--- MENÚ HOUSEHOLDS ---");
        System.out.println("1. Listar");
        System.out.println("2. Buscar por ID");
        System.out.println("3. Insertar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver");

        int opcion = leerEntero("Seleccione: ");

        switch (opcion) {
            case 1: listarHouseholds(); break;
            case 2: buscarHousehold(); break;
            case 3: insertarHousehold(); break;
            case 4: eliminarHousehold(); break;
            case 0: return;
            default: System.out.println("Opción inválida.");
        }
    }

    private static void listarHouseholds() {
        List<Household> lista = householdDAO.listarTodos();
        System.out.println("--- HOUSEHOLDS ---");
        lista.forEach(h ->
                System.out.printf("ID %d | Dirección: %s | %d residentes%n",
                        h.getHouseholdId(), h.getDireccion(), h.getNumResidentes())
        );
    }

    private static void insertarHousehold() {
        System.out.println("\n--- NUEVO HOUSEHOLD ---");

        int comId = leerEntero("Community ID: ");
        String dir = leerTexto("Dirección: ");
        int res = leerEntero("Número de residentes: ");
        String nivel = leerTexto("Nivel socioeconómico: ");

        Household h = new Household(0, comId, dir, res, nivel);

        if (householdDAO.insertar(h) > 0)
            System.out.println("Household creado.");
        else
            System.out.println("Error.");
    }

    private static void buscarHousehold() {
        int id = leerEntero("ID: ");
        Household h = householdDAO.buscarPorId(id);
        System.out.println(h != null ? h : "No encontrado.");
    }

    private static void eliminarHousehold() {
        int id = leerEntero("ID: ");
        if (householdDAO.eliminar(id) > 0)
            System.out.println("Eliminado.");
        else
            System.out.println("Error.");
    }


    // ============================================
    // MÉTODOS DE UTILIDAD
    // ============================================
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

    private static String leerTexto(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }
}
