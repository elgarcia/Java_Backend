package main;

public enum RangoEdad {
    Joven(0,18), Adulto(18, 40), Mayor(40,70), Anciano(70);
    private int minEdad , maxEdad;
    RangoEdad( int min, int max) {
        this.minEdad = min;
        this.maxEdad = max;
    }
    RangoEdad(int min) {
        this(min, Integer.MAX_VALUE);
    }

    public ValoresRango getRangoEdades() {
        return new ValoresRango(this.minEdad, this.maxEdad);
    }

    public String toString() {
        return name() + "("+this.minEdad+", "+ this.maxEdad+")";
    }

    public record ValoresRango(int min, int max) {}


//    public static class ValoresRango {
//        private int min, max;
//
//        public ValoresRango(int min, int max) {
//            this.min = min;
//            this.max = max;
//        }
//
//        public int getMin() {
//            return min;
//        }
//
//        public int getMax() {
//            return max;
//        }
//    }
}

class RangoEdad2 {
    public RangoEdad2 Joven = new RangoEdad2("Joven", 0, 18);
    public RangoEdad2 Adulto = new RangoEdad2("Adulto", 18, 40);
    public RangoEdad2 Mayor = new RangoEdad2("Mayor", 40, 70);
    public RangoEdad2 Anciano = new RangoEdad2("Anciano", 70, 200);

    private int minEdad , maxEdad;
    private String nombre ;
    private RangoEdad2(String nombre , int min, int max) {
        this.nombre = nombre;
        this.minEdad = min;
        this.maxEdad = max;
    }
    public String toString() {
        return getNombre();
    }

    public int getMinEdad() {
        return minEdad;
    }

    public int getMaxEdad() {
        return maxEdad;
    }

    public String getNombre() {
        return nombre;
    }
}