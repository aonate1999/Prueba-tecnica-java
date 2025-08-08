package org.example;
import java.util.List;
import java.util.ArrayList;
public class FuenteBaseDatos implements FuenteDatos{
    @Override
    public List<Documento> obtenerDocumentos() {
        System.out.println("Conectando a base de datos...");

        List<Documento> documentos = new ArrayList<>();

        // Documentos simulados de base de datos
        documentos.add(new Documento(
                "Usuario ID 001",
                "Perfil de usuario: Juan Pérez, desarrollador senior con 5 años de experiencia...",
                "FuenteBaseDatos"
        ));

        documentos.add(new Documento(
                "Proyecto Alpha",
                "Información del proyecto Alpha: sistema de gestión empresarial desarrollado en Java...",
                "FuenteBaseDatos"
        ));

        System.out.println("Se obtuvieron " + documentos.size() + " documentos de la base de datos.");
        return documentos;
    }
}



