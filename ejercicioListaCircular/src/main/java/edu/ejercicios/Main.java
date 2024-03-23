package edu.ejercicios;

import edu.ejercicios.ListaCircular.ListaCircular;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ListaCircular lista = new ListaCircular();

        lista.agregarInicio(0);
        lista.agregarInicio(2);
        lista.agregarInicio(3);
        lista.agregarAlFinal(-4);

        System.out.println(lista.mostarInicio());

        System.out.println(lista.tieneCiclo(1));

        System.out.println("Cantidad de Datos: " + lista.getNumDatos());

    }
}