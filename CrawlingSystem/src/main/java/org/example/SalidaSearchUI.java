package org.example;
import java.util.List;
public class SalidaSearchUI implements SalidaResultados {
    @Override
    public void mostrarDocumentos(List<Documento> documentos) {
        System.out.println("\n=== INTERFAZ DE BÚSQUEDA ===");
        System.out.println("Mostrando " + documentos.size() + " documentos en el buscador web:");

        for (int i = 0; i < documentos.size(); i++) {
            Documento doc = documentos.get(i);
            System.out.println((i + 1) + ". " + doc.getTitulo());
            System.out.println("   Fuente: " + doc.getFuenteOrigen());
            System.out.println("   Preview: " + doc.getContenido().substring(0, Math.min(80, doc.getContenido().length())) + "...");
            System.out.println();
        }
    }
}