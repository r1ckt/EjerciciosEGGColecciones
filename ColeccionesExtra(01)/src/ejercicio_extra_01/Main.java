/*
Diseñar un programa que lea una serie de valores numéricos enteros desde el teclado y
los guarde en un ArrayList de tipo Integer. La lectura de números termina cuando se
introduzca el valor -99. Este valor no se guarda en el ArrayList. A continuación, el
programa mostrará por pantalla el número de valores que se han leído, su suma y su
media (promedio).
*/
package ejercicio_extra_01;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        ArrayList<Integer> serie = new ArrayList<>();
        int count = 0;
        int sum = 0;
        
        while(true){
            int num = scan.nextInt();
            if(num == -99){
                break;
            }
            count++;
            sum += num;
            serie.add(num);
        }
        System.out.println("Valores ingresados: ");
        System.out.println(serie.toString());
        System.out.printf("Cantidad de valores ingresados: %d\n", count);
        System.out.printf("Suma: %d\n", sum);
        System.out.printf("Promedio: %.2f\n", 1.0 * sum/count);
    }
    
}
