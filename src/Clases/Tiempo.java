
package Clases;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

public class Tiempo {
    //String hora,minuto,segundos;
    //String horas,minutos;
    int hora,minuto,segundos;
    int auxhoras,auxminutos;
    Calendar fecha = new GregorianCalendar();
    
    
    String año = Integer.toString(fecha.get(Calendar.YEAR));
    String mes = Integer.toString(fecha.get(Calendar.MONTH));
    String dia = Integer.toString(fecha.get(Calendar.DATE));
    public String fechacompleta = dia + " de " + mes + " del " + año;
    
    String horas = Integer.toString(fecha.get(Calendar.HOUR_OF_DAY));
    String minutos = Integer.toString(fecha.get(Calendar.MINUTE));
    public String horacompleta = horas + ":" + minutos;
    
    
    
    /*public void hora(){
    Calendar calen = new GregorianCalendar();
    Date horaActu = new Date();
    
    calen.setTime(horaActu);
    hora = calen.get(Calendar.HOUR_OF_DAY)>9?""+calen.get(Calendar.HOUR_OF_DAY):"0"+calen.get(Calendar.HOUR_OF_DAY);
    minuto = calen.get(Calendar.MINUTE)>9?""+calen.get(Calendar.MINUTE):"0"+calen.get(Calendar.MINUTE);
    segundos = calen.get(Calendar.SECOND)>9?""+calen.get(Calendar.SECOND):"0"+calen.get(Calendar.SECOND);
}*/

}

