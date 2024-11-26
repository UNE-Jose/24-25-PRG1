import java.util.Scanner;

public class Integral {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final double INTERVALO = 0.1;

        double a = obtenerNumeroUsuario(entrada);
        boolean error = false;
        double b;
        double area = 0;

        do {
            b = obtenerNumeroUsuario(entrada);
            error = b<a;
            if (error){
                System.out.println("|  > Error, porfavor introduzca una b mayor que a");
            }
        } while (error);

        for (double x = a; x < b; x += INTERVALO) {
            area += (INTERVALO*resolverFuncion(x));
        }

        System.out.println("| >  El area es de " +  area);
        entrada.close();
    }

    static double obtenerNumeroUsuario(Scanner entrada) {
        final String ERROR = "| >  Porfavor introduzca un numero";
        final String EMBELLECEDOR = "| >  ";

        System.out.print(EMBELLECEDOR);
        while(!entrada.hasNextDouble()){
            System.out.println(ERROR);
            entrada.next();
            System.out.print(EMBELLECEDOR);
        }
        return entrada.nextDouble();
    }

    static double resolverFuncion(double x){
        return (5*(Math.sin(x/1.59)+0.33*Math.sin(3*x/1.59)+0.2*Math.sin(5*x/1.59)));
    }
}
