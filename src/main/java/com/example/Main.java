package com.example;

import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);
    private static Controlador controlador = new Controlador();

    public static void main(String[] args) {
        boolean continuar = true;
        int opcion = 0;

        escribir("Bienvenido al simulador de traduccion de documentos");
        while (continuar) {
            escribir("""
                
                Seleccione una opcion del menu: 
                
                1. Elegir diccionario
                2. Elegir texto a traducir
                3. Traducir texto
                4. Salir
                """
                );
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:   
                    escribir("Ingrese la ruta absoluta del archivo .txt con el diccionario a usar");
                    controlador.seleccionarDiccionario(teclado.nextLine());

                    break;

                case 2:   
                    escribir("Ingrese la ruta absoluta del archivo .txt con el texto a traducir");
                    controlador.seleccionarTexto(teclado.nextLine());

                    break;

                case 3:   
                    escribir("Este es el texto traducido: \n");
                    escribir(controlador.traducirTexto());

                    break;

                case 4:
                    escribir("Gracias por usar el programa, esperamos volver a verlo pronto");
                    continuar = false;
                    break;
            
                default:
                    escribir("La opcion ingresada no corresponde con alguna de las del menu, intentelo de nuevo\n");
                    break;
            }
        }
    }
    

    private static void escribir(String texto){
        System.out.println(texto);
    }
}