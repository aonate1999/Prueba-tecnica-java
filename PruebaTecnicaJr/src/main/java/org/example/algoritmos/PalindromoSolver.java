package org.example.algoritmos;

import java.text.Normalizer;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PalindromoSolver {

    public static void runThreWordCheck() {
        Scanner sc = new Scanner(System.in);
        StringBuilder acumuladoRaw = new StringBuilder();

        System.out.println("===verificador de Palindromos - Modo Interactivo===");
        System.out.println("Ingresa 3 palabras y veremos si puedes formar palindromos.");
        System.out.println("Te mostrare resultados tanto individuales como acumulados. \n");

        //se piden las tres palabras
        for (int idx = 1; idx <= 3; idx++) {
            System.out.println("Escribre la palabra" + idx + ": ");
            String palabraRaw = sc.nextLine();

            //limpia y normalizacion de palabra
            String palabraNormalizada = normalizeString(palabraRaw);
            System.out.println(" Despues de limpiarla: \" " + palabraNormalizada + "\"");
            // si la palabra no tiene letras validas depues de limpiarla
            if (palabraNormalizada.isEmpty()) {
                System.out.println("Esta palabra no tiene letras validas para trabajar");
            } else {
                String palSolo = construirPalindromo(palabraNormalizada);
                if ("Not Possible".equals(palSolo)) {
                    System.out.println("    Esta palabra sola no es un palindromo ");
                } else {
                    System.out.println(" Esta palabra es un palindromo" + palSolo);
                }
            }

            acumuladoRaw.append(palabraRaw).append(" ");
            String acumuladoNormalizado = normalizeString(acumuladoRaw.toString());
            System.out.println("   Texto acumulado limpio: \"" + acumuladoNormalizado + "\"");

            //verifica si todo el texto junto puede formar un palindromo
            if (acumuladoNormalizado.isEmpty()) {
                System.out.println(" El texto acumulado no tiene letras Validas\n");
            } else {
                String palAcumulado = construirPalindromo(acumuladoNormalizado);
                if ("Not Possible".equals(palAcumulado)) {
                    System.out.println(" El texto completo no puede ser Palindromo\n ");
                } else {
                    System.out.println("El texto completo si puede ser un palindromo: \n" + palAcumulado + "\n");
                }
            }
        }

        //Resultado Final
        String finalNormalizado = normalizeString(acumuladoRaw.toString());
        System.out.println("\n === RESULTADO FINAL ===");
        System.out.println("Tu texto original: \"" + acumuladoRaw.toString().trim() + "\"");
        System.out.println("Despues de limpiarlo: \"" + finalNormalizado + "\"");

        if (finalNormalizado.isEmpty()) {
            System.out.println(" No hay letras suficientes para formar un palindromo");
        } else {
            String finalpal = construirPalindromo(finalNormalizado);
            System.out.println("veredicto final: " + finalpal);
        }
    }

    public static String normalizeString(String s) {
        //Si nos pasan algo vacio o null devolvemos texto vacio
        if (s == null) return "";
        s = s.trim().toLowerCase();
        // Este paso quita los acentos de las letras
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("\\p{M}", "");
        // Solo nos quedamos con letras del alfabeto (incluimos la ñ)
        s = s.replaceAll("[^a-zñ]", "");

        return s;
    }
    public static String construirPalindromo(String str) {
        // Usamos TreeMap para que las letras se ordenen automáticamente (a, b, c...)
        // Esto nos dará palíndromos más bonitos y ordenados
        TreeMap<Character, Integer> frecuencia = new TreeMap<>();

        // Contamos cuántas veces aparece cada letra
        for (char c : str.toCharArray()) {
            frecuencia.put(c, frecuencia.getOrDefault(c, 0) + 1);
        }

        // Ahora verificamos la regla fundamental de los palíndromos
        int letrasConCantidadImpar = 0;
        char letraDelCentro = 0;

        for (Map.Entry<Character, Integer> entry : frecuencia.entrySet()) {
            if (entry.getValue() % 2 != 0) { // Si esta letra aparece cantidad impar
                letrasConCantidadImpar++;
                letraDelCentro = entry.getKey(); // Guardamos cuál es esa letra
            }
        }

        // Si hay más de una letra con cantidad impar, es imposible hacer palíndromo
        if (letrasConCantidadImpar > 1) {
            return "Not Possible";
        }
        // Ahora lo construimos paso a paso
        // Primero armamos la mitad izquierda del palíndromo
        StringBuilder mitadIzquierda = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : frecuencia.entrySet()) {
            // Para cada letra, ponemos la mitad de sus ocurrencias en la mitad izquierda
            int vecesEnCadaMitad = entry.getValue() / 2;
            for (int i = 0; i < vecesEnCadaMitad; i++) {
                mitadIzquierda.append(entry.getKey());
            }
        }
        // Ahora construimos el palíndromo completo
        StringBuilder palindromoCompleto = new StringBuilder(mitadIzquierda);
        // Si hay una letra que aparece cantidad impar, va en el centro
        if (letrasConCantidadImpar == 1) {
            palindromoCompleto.append(letraDelCentro);
        }
        // Finalmente agregamos la mitad derecha (que es la izquierda al revés)
        palindromoCompleto.append(mitadIzquierda.reverse());
        return palindromoCompleto.toString();
    }
}

