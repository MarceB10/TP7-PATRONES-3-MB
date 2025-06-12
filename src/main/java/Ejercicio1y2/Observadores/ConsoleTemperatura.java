package Ejercicio1y2.Observadores;

public class ConsoleTemperatura implements ObserverTemperatura{
    @Override
    public void updateTemperatura(String temperatura) {
        double valor = Double.parseDouble(temperatura.split(" ")[0]);
        if (valor < 12){
            System.out.println(temperatura + "Hace frio, se encenderá la caldera.");
        }else if (valor>= 12 && valor <= 17){
            System.out.println(temperatura + "Esta lindo");
        } else {
            System.out.println(temperatura + "Hace calor, se encera el aire acondicionado.");
        }
    }
}
