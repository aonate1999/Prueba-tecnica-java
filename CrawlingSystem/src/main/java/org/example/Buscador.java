package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Buscador {
    public List<Documento> buscar(String consulta, List<Documento> documentos) {
        System.out.println("\nRealizando búsqueda para: '" + consulta + "'");
        System.out.println("Buscando en " + documentos.size() + " documentos...");

        // Simulacion de que devolvemos los primeros 2 documentos
        List<Documento> resultados = documentos.stream()
                .limit(2)
                .collect(Collectors.toList());

        System.out.println("Se encontraron " + resultados.size() + " resultados relevantes.");
        return resultados;
    }
}
