package main;

public class Seis {
    static int valorMedio(int x, int y){
        return ((x + y) / 2);
    }

    static boolean esPar(int a){
        if (a % 2 == 0)
            return true;
        else
            return false;
    }

    static String  item(String[] input, int pos){
        int rpos = pos - 1;
        if (pos > input.length)
            rpos = input.length - 1;
        if (pos <= 0)
            rpos = 0;
        return input[rpos];
    }
}
