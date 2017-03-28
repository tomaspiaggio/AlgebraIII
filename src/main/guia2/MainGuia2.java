package main.guia2;


/**
 * Created by matiasvenditti on 3/22/17.
 */
public class MainGuia2 {

    public static void main(String[] args) {
        /**
         * Constantes utilizadas por los métodos
         */

        Ej12 instance = new Ej12();

        final int m = 2;
        final int n = 4;
        final int r = 4;
        final int s = 8;
        final int x = 10;

        System.out.println("Ejercicio 8.\t" + instance.excercise8(m, n));
        System.out.println("Ejercicio 9.\t" + instance.excercise9(m, n, r, s));
        System.out.println("Ejercicio 10.\t" + instance.excercise10(n));
        System.out.println("Ejercicio 11 a.\t" + instance.excercise11Sumation(n, x));
        System.out.println("Ejercicio 11 b.\t" + instance.excercise11Formula(n, x));
    }
}
