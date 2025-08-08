package org.example;
import  java.util.ArrayList;
import java.util.List;
public class FuenteWeb implements FuenteDatos {
    @Override
    public List<Documento> obtenerDocumentos() {
        System.out.println("Realizando crawling de sitios web...");

        List<Documento> documentos = new ArrayList<>();

        // Documentos Simulados web
        documentos.add(new Documento(
                "Página Principal - TechBlog",
                "Bienvenidos a nuestro blog técnico donde compartimos las últimas novedades...",
                "FuenteWeb"
        ));

        documentos.add(new Documento(
                "Tutorial JavaScript - DevSite",
                "Aprende JavaScript desde cero con este tutorial completo que cubre...",
                "FuenteWeb"
        ));

        documentos.add(new Documento(
                "Noticias Tecnología",
                "Las últimas noticias del mundo de la tecnología y desarrollo de software...",
                "FuenteWeb"
        ));
        System.out.println("Se obtuvieron " + documentos.size() + " documentos de sitios web.");
        return documentos;
    }
}