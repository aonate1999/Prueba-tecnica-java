package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class SalidaDashboard implements SalidaResultados {
    @Override
    public void mostrarDocumentos(List<Documento> documentos) {
        System.out.println("\n=== DASHBOARD EJECUTIVO ===");
        System.out.println("Resumen estadístico de documentos indexados:");

        // Estadísticas por fuente
        Map<String, Long> documentosPorFuente = documentos.stream()
                .collect(Collectors.groupingBy(Documento::getFuenteOrigen, Collectors.counting()));

        System.out.println("\nDistribución por fuente:");
        documentosPorFuente.forEach((fuente, cantidad) ->
                System.out.println("  " + fuente + ": " + cantidad + " documentos"));

        System.out.println("\nTotal de documentos procesados: " + documentos.size());

        // Mostrar ejemplos
        System.out.println("\nÚltimos documentos indexados:");
        documentos.stream()
                .limit(3)
                .forEach(doc -> System.out.println("  - " + doc.getTitulo() + " (" + doc.getFuenteOrigen() + ")"));
    }
}