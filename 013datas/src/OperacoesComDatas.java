
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;



public class OperacoesComDatas {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		
		System.out.println("Data:" + sdf.format(d)); // VAI SER CONVERTIDO PARA O HORARIO BR
		
		Calendar cal = Calendar.getInstance(); // INSTANCIANDO OBJETO TIPO CALENDARIO
		cal.setTime(d);
		cal.add(Calendar.HOUR_OF_DAY, 4); // PARA ADICIONAR 4 HORAS A DATA
		d = cal.getTime(); // PASSANDO A NOVA DATA PARA A VARIÁVEL d
		System.out.println("Data + 4 horas: " + sdf.format(d));


		cal.setTime(d);
		int minutes = cal.get(Calendar.MINUTE);
		int month = 1 + cal.get(Calendar.MONTH); // TEM QUE ADICIONAR 1 PQ PARA O JAVA O PRIMEIRO MÊS É 0!!
		System.out.println("Minutes: " + minutes);
		System.out.println("Month: " + month);

	}

}
