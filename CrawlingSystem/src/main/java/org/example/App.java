package org.example;

import java.util.ArrayList;
import java.util.List;
public class App {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CRAWLING E INDEXACIÓN ===\n");

        // 1. Creamos las instancias de las fuentes de datos
        System.out.println("1. Inicializando fuentes de datos...");
        FuenteDatos fuenteArchivo = new FuenteArchivo();
        FuenteDatos fuenteWeb = new FuenteWeb();
        FuenteDatos fuenteBaseDatos = new FuenteBaseDatos();

        // 2. Obtenemos los documentos de todas las fuentes
        System.out.println("\n2. Obteniendo documentos de todas las fuentes...");
        List<Documento> todosLosDocumentos = new ArrayList<>();

        // Obtenemos los documentos de cada fuente
        todosLosDocumentos.addAll(fuenteArchivo.obtenerDocumentos());
        todosLosDocumentos.addAll(fuenteWeb.obtenerDocumentos());
        todosLosDocumentos.addAll(fuenteBaseDatos.obtenerDocumentos());

        System.out.println("\nTotal de documentos indexados: " + todosLosDocumentos.size());

        // 3. Mostramos los resultados en diferentes salidas
        System.out.println("\n3. Mostrando resultados en diferentes interfaces...");

        // Creamos instancias de salidas
        SalidaResultados salidaUI = new SalidaSearchUI();
        SalidaResultados salidaDashboard = new SalidaDashboard();

        // Mostramos en Search UI
        salidaUI.mostrarDocumentos(todosLosDocumentos);

        // Mostramos en Dashboard
        salidaDashboard.mostrarDocumentos(todosLosDocumentos);

        // 4. Probamos funcionalidad de búsqueda
        System.out.println("\n4. Probando funcionalidad de búsqueda...");
        Buscador buscador = new Buscador();
        List<Documento> resultadosBusqueda = buscador.buscar("Java tutorial", todosLosDocumentos);

        // Mostramos resultados de búsqueda
        System.out.println("\nResultados de la búsqueda:");
        salidaUI.mostrarDocumentos(resultadosBusqueda);

        System.out.println("\n=== PROCESO COMPLETADO ===");
    }
}