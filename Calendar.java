
package calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author Jhampier
 */
public class Calendar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        LocalDate fechaEntrada = LocalDate.now();
        System.out.println("");
        System.out.println("         YEAR: "+fechaEntrada.getYear());
        System.out.println("===========================");

        
        for (int m = 1; m < 13; m++) {
            //Capture the day and month to iterate
            LocalDate fecha = LocalDate.of(fechaEntrada.getYear(), m, fechaEntrada.getDayOfMonth());
            
            int mesActual = fecha.getMonthValue();
            int diaHoy = fecha.getDayOfMonth();
            
            System.out.println("\nMonth: "  + "    " + fecha.getMonth().name());
            //subtract n days from current date
            //f = 1 start of the month
            fecha = fecha.minusDays(diaHoy - 1);
            DayOfWeek weekday = fecha.getDayOfWeek();
            int valor = weekday.getValue(); // 1 = Monday, . . . , 7 = Sunday

            System.out.println("Mon Tue Wed Thu Fri Sat Sun");
            for (int i = 1; i < valor; i++) {
                System.out.print("    ");
            }
            //doesn't know if he will have 31,30,29 or 28 days
            //iterate as long as the date is still in the current month 
            while (fecha.getMonthValue() == mesActual) {
                System.out.printf("%3d", fecha.getDayOfMonth());

                if (fecha.getDayOfMonth() == diaHoy && fecha.getMonth()==fechaEntrada.getMonth()) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                //add a day to the date
                fecha = fecha.plusDays(1);
                if (fecha.getDayOfWeek().getValue() == 1) {
                    System.out.println();
                }
            }
            if (fecha.getDayOfWeek().getValue() != 1) {
                System.out.println();
            }

            }
    }
    
}
