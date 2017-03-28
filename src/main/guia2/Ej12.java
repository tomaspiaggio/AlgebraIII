package guia2.ej12;

/**
 * Created by matiasvenditti on 3/22/17.
 */
public class Ej12 implements Practice2{


    @Override
    public long excercise8(int m, int n) {
        long result = 0;
        for (int i = m; i <= n; i++) {
            result += i;
        }
        return result;
    }

    @Override
    public long excercise9(int m, int n, int r, int s) {
        long result = 0;
        for (int i = m; i <= n; i++) {
            for (int j = r; j < s; j++) {
                result += i*j;
            }
        }
        return result;
    }

    // Method excercise11Sumation could be used as excercise11Sumation(n,2)
    @Override
    public long excercise10(int n) {
        long result = 0;
        for (int i = 0; i <= n; i++) {
            result += i * Math.pow(2,i);
        }
        return result;
    }

    @Override
    public double excercise11Sumation(int m, int x) {
        double result = 0;
        for (int i = 0; i <= m; i++) {
            result += i * Math.pow(x,i);
        }
        return result;
    }

    @Override
    public double excercise11Formula(int n, int x) {
        return ((n*Math.pow(x,n+2) - (n+1)*Math.pow(x,n+1) + x)/(Math.pow(x-1,2)));
    }
}
