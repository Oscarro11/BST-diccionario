package main;

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectorTexto {
    
    public static String leerTexto(String ruta) throws FileNotFoundException, IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(ruta));){
            StringBuilder builder = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
                line = br.readLine();
            }

            builder.delete(builder.length() - 2, builder.length());
            return builder.toString();
        }
        catch (Exception e) {
            throw e;
        }
    }

    public static List<Association<String, String>> leerDiccionario(String ruta) throws FileNotFoundException, IOException{
        String texto;
        List<Association<String, String>> diccionario = new ArrayList<Association<String, String>>();

        try {
            texto = leerTexto(ruta);
        } catch (Exception e) {
            throw e;
        }
        
        for (String linea : texto.split("\n")) {
            linea = linea.strip();

            int startIndex = linea.indexOf('(');
            int endIndex = linea.indexOf(')', startIndex + 1);

            if (startIndex == -1 || endIndex == -1 || startIndex > endIndex) {
                continue;
            }
            else{
                String[] entrada = linea.substring(startIndex + 1, endIndex).split(",");

                for (int i = 0; i < entrada.length; i++) {
                    entrada[i] = entrada[i].strip();
                }

                diccionario.add(new Association<String,String>(entrada[0], entrada[1]));
            }
        }

        return diccionario;
    }
}
