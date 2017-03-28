package main.guia1.ej3;

/**
 * Created by matiasvenditti on 3/14/17.
 */
public class Ej3 {


    /**
     * Ejercicio 3
     */
    public static int zerosIterative(int number){
        int result = 0;
        while(number > 0){
            if(number % 10 == 0) result++;
            number/=10;
        }
        return result;
    }

    public static int zerosRecursive(int number) {
        return zerosAuxiliary(number, 0);
    }

    /**
     * Auxiliares
     */
    private static int zerosAuxiliary(int number, int counter){
        if(number <= 0) return counter;
        else if(number%10 == 0)
            return zerosAuxiliary(number/10, ++counter);
        return zerosAuxiliary(number/10, counter);
    }
}
