package org.example;

import java.util.ArrayList;
import java.util.List;

public class FuenteArchivo implements FuenteDatos {
    @Override
    public List<Documento> obtenerDocumentos() {
        System.out.println("Conectando a sistema de archivos local...");

        List<Documento> documentos = new ArrayList<>();
        // Documentos simulamos  de archivos
        documentos.add(new Documento(
                "Manual de Usuario.pdf",
                "Este es el contenido del manual de usuario que explica cómo utilizar el sistema...",
                "FuenteArchivo"
        ));
        documentos.add(new Documento(
                "Reporte Mensual.docx",
                "Reporte mensual de actividades y métricas del equipo de desarrollo...",
                "FuenteArchivo"
        ));
        documentos.add(new Documento(
                "Configuración.txt",
                "Archivo de configuración del sistema con parámetros de conexión...",
                "FuenteArchivo"
        ));
        System.out.println("Se obtuvieron " + documentos.size() + " documentos del sistema de archivos.");
        return documentos;
    }
}