package com.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import com.example.BST.BST;

public class Controlador {
    private BST<Association<String, String>> diccionario;
    private String texto;

    public Controlador(){}
    
    public void seleccionarDiccionario(String ruta){
        List<Association<String, String>> entradas = new ArrayList<>();

        try{
            entradas = LectorTexto.leerDiccionario(ruta);
        }
        catch (FileNotFoundException e){
            System.err.print("La ruta de archivo para el contenido del diccionario no pudo encontrarse");
        }
        catch (IOException e){
            System.err.print(e.getMessage());
        }

        diccionario = new BST<>();
        for (Association<String,String> entrada : entradas) {
            diccionario.agregar(entrada);
        }
    }

    public void seleccionarTexto(String ruta){
        try{
            texto = LectorTexto.leerTexto(ruta);
        }
        catch (FileNotFoundException e){
            System.err.print("La ruta de archivo para el contenido del diccionario no pudo encontrarse");
        }
        catch (IOException e){
            System.err.print(e.getMessage());
        }
    }

    public String traducirTexto(){
        if (texto == null || diccionario == null) {
            return "";
        }
        else{
            StringBuilder builder = new StringBuilder();

            Matcher leadingMatcher = Pattern.compile("^[^0-9\\p{L}\\s]+").matcher("");
            Matcher trailingMatcher = Pattern.compile("[^0-9\\p{L}\\s]+$").matcher("");

            for (String word : texto.split(" ")) {
                String leadingSymbols = "";
                String trailingSymbols = "";
                
                leadingMatcher.reset(word);
                trailingMatcher.reset(word);

                if (leadingMatcher.find()) {
                    leadingSymbols = leadingMatcher.group();
                }

                if (trailingMatcher.find()) {
                    trailingSymbols = trailingMatcher.group();
                }

                word = word.replaceAll("^[^0-9\\p{L}\\s]+|[^0-9\\p{L}\\s]+$", "");
                Association<String, String> traduccion = diccionario.buscar(new Association<String,String>(word, ""));

                builder.append(leadingSymbols);
                if (traduccion != null) {
                    builder.append(traduccion.getValor() + trailingSymbols);
                }
                else{
                    builder.append("*" + word + leadingSymbols + "*");
                }
                builder.append(" ");
            }

            builder.delete(builder.length() - 1, builder.length());
            return builder.toString();
        }
    }
}
