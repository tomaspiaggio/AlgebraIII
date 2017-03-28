package guia1.ej7;

/**
 * Created by matiasvenditti on 3/23/17.
 */
public class Ej7 {

    public static int euclidesIterative(int bigger, int smaller){
        int result = 0;
        while(bigger % smaller != 0){
            result = bigger % smaller;
            bigger = smaller;
            smaller = result;
        }
        return result;
    }

    public static int euclidesRecursive(int bigger, int smaller){
        return (bigger % smaller == 0)? smaller : euclidesRecursive(smaller, bigger % smaller);
    }

}
