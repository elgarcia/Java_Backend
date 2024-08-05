package com.elias;

public class Main
{
    private static Cliente getInfo(){
        Cliente client = new Cliente();

        client.name = Console.readText("Introduce client name: ");
        client.dateInfo = new Age();
        client.dateInfo.getAge();
        return (client);
    }

    private static int   calculateAge(Cliente client){
        int age;
        java.time.LocalDate fechaActual = java.time.LocalDate.now();
        int anhoActual = fechaActual.getYear();
        int mesActual = fechaActual.getMonthValue();
        int diaActual = fechaActual.getDayOfMonth();

        age = anhoActual - client.dateInfo.year;
        if (client.dateInfo.month > mesActual)
            age--;
        else if (mesActual == client.dateInfo.month && client.dateInfo.day > diaActual)
            age--;
        return (age);
    }

    private static void showInfo(Cliente client){
        System.out.println("Saludos " + client.name + ", ya sé que tienes " + client.age + " años de edad");
    }

    public static void main( String[] args ) {
        Cliente client;

        client = getInfo();
        client.age = calculateAge(client);
        showInfo(client);
    }
}
