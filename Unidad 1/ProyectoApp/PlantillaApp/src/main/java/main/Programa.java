package main;

import java.util.ArrayList;
import java.util.List;

public class Programa {

	public static void main(String[] args) {
            // Escribir instrucciones a continuacion para que se ejecuten.
            // Clase 5
            /*       ArrayList<Inversor> inversores = new ArrayList<>();
            Inversor i1 = new Inversor();
            Inversor i2 = new Inversor();

            i1.nombre = "Juan Pérez";
            i1.capital = 5000;
            i1.empresas = new String[3];
            i1.empresas[0] = "Iberdrola";
            i1.empresas[1] = "Fenosa";

            i2.nombre = "María Sanchez";
            i2.capital = 5500;
            i2.empresas = new String[3];
            i2.empresas[0] = "Iberdrola";
            i2.empresas[1] = "Endesa";
            i2.empresas[2] = "Fenosa";

            inversores.add(i1);
            inversores.add(i2);
            */

            //Clase 6
            /* int vMedio;
            vMedio = Seis.valorMedio(4, 7);
            System.out.println("Valor medio: " + vMedio);

            boolean condition;
            condition = Seis.esPar(4);
            System.out.println("4 es par? " + condition);
            condition = Seis.esPar(7);
            System.out.println("7 es par? " + condition);
                 String[] words = {"Abc", "Def", "Ghi", "Jkl"};
            String  output;
            output = Seis.item(words, 2);
            System.out.println("Word 2: " + output);
            output = Seis.item(words, 7);
            System.out.println("Word 7: " + output);
             */

                 //Clase 7
            //Ejercicio 1
            /*int       mEdad = Console.readInteger("Introduce mayoria de edad: ");
            int         vEdad = Console.readInteger("Introduce edad de viejo: ");
            int         miEdad = Console.readInteger("Introduce tu edad: ");
            String      resultado = (miEdad > mEdad && miEdad < vEdad) ? "Eres mayor"
                : (miEdad < mEdad ? "Eres joven" : "Eres viejo");
            System.out.println(resultado);
            //Ejercicio 2
            String opcion = solicitarCandidato();
            String partido = evaluarVoto(opcion);
            System.out.println(partido);
             */

            //Clase 8
            //Ejercicio 1
            /*int[]       numeros = getNumbers();
            int         menor = getMinor(numeros);
            System.out.println("Numero menor: " + menor);
            //Ejercicio 2
            int numero = Console.readInteger("Introduce un numero: ");
            mostrarTriangulo(numero);*/
            //Ejercicio 3
            /*
            Cliente[] clientes = { new Cliente(12, "Ana"), new Cliente(24, "Felipe"),
                new Cliente(3, "Agustín"), new Cliente(17, "Cecilia") };
            Cliente.getClient(clientes, 16);
             */

            //Clase 9
            //Ejercicio 1
            /*Producto p1;
            Producto p2;

            p1 = applyIva(12, "Cereales", 3.43);
            p2 = applyIva(12, "Fuet", 1.40);
            System.out.println("Producto 1: " + p1.producto + ", Precio: " + p1.precio);
            System.out.println("Producto 2: " + p2.producto + ", Precio: " + p2.precio);
             */
            //Ejercicio 2
            //Crea un método que reciba como argumento el año actual y una colección de años de nacimiento.
            // Haz que la función retorne un una colección con las edades correspondientes a las fechas de nacimiento.
            /*
            int[]   colection;
            Año     today = new Año(2024, 07,13);
            Año[]    dates = {new Año(1999, 01, 16), new Año(2001, 8, 03),
                new Año(2000, 07, 13), new Año(2003, 10, 10)};
            colection = getAges(today, dates);
            for (int x = 0; x < colection.length; x++)
            {
                System.out.println("Edad " + x + ": " + colection[x]);
            }
             */
            //Ejercicio 3
            /* List<String> words = new ArrayList<>();
            words = seleccionar("Es", "España", "Catalunya", "Estocolmo", "Finlandia");
            System.out.println(words.toString()); */
            //Ejercicio 4
            //Resuelve el algoritmo usando recursividad. Si divides una lista por la mitad,
            // el valor mínimo es el menor de los valores mínimos de cada sublista.
            int min = valorMinimo(List.of(4,5,2,10,41));
            System.out.println("Min: " + min);
        }

        private static int  valorMinimo(List<Integer> numbers){
            if (numbers.size() == 1)
                return (numbers.get(0));
            int posMitad = numbers.size() / 2;
            int min1 = valorMinimo(numbers.subList(0, posMitad));
            int min2 = valorMinimo(numbers.subList(posMitad, numbers.size()));

            return (min1 < min2 ? min1 : min2);
        }

        private static List<String> seleccionar(String corte, String... palabras){
            List<String> words = new ArrayList<>();
            for (String a: palabras)
            {
                if (a.startsWith(corte)){
                    words.add(a);
                }
            }
            return (words);
        }

        private static int[]    getAges(Año actual, Año[] dates){
            int[]   ages = new int[dates.length];
            int     i = 0;

            for (Año a: dates)
            {
                int age =  actual.year - a.year;
                if (a.month > actual.month)
                    age--;
                else if (a.month == actual.month && a.day > actual.day)
                    age--;
                ages[i++] = age;
            }
            return (ages);
        }

        static Producto applyIva(double iva, String product, double precio){
            if (product.charAt(0) == 'C')
                precio *=  1.21;
            else
                precio *= (1 + (iva / 100));
            return (new Producto(product, precio));
        }

        private static void mostrarTriangulo(int numero){
            for (int i = 1; i <= numero; i+=2)
            {
                    for (int j = i; j > 0; j-=2)
                    {
                            System.out.print(j + " ");
                    }
                    System.out.println("");
            }
        }

        private static int[]    getNumbers(){
                int         cantidad = Console.readInteger("Cuantos numeros quieres introducir?");
                int[]       numeros = new int[cantidad];

                for (int i = 0; i < cantidad; i++)
                {
                        numeros[i] = Console.readInteger("Introduce numero " + (i + 1));
                }
                return numeros;
        }

        private static int      getMinor(int[] numeros){
            int menor = numeros[0];

            for (int i = 1; i < numeros.length; i++)
            {
                    if (numeros[i] < menor)
                            menor = numeros[i];
            }
            return menor;
        }

        private static String solicitarCandidato(){
            return (Console.readText("Elije candidato (A, B o C): "));
        }

        private static String evaluarVoto(String voto){
            String resultado = "Usted ha votado por el partido ";
            switch (voto)
            {
                case "A":
                        resultado += "rojo";
                        break;
                case "B":
                        resultado += "verde";
                        break;
                case "C":
                        resultado += "azul";
                        break;
                default:
                        resultado = "Opcion errónea";
                        break;
            }
            return (resultado);
        }

        record  Producto(String producto, double precio) {}
        record  Año(int year, int month, int day) {}
}

