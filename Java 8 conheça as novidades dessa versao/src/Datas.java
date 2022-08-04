import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate dia = LocalDate.now();
		LocalDate aniversario = LocalDate.of(2014, Month.NOVEMBER, 5);
		
		System.out.println(aniversario.getYear() - dia.getYear());
		
		Period periodo = Period.between(dia, aniversario);
		//System.out.println(periodo.getYears());
		
		LocalDate proximasOlimpiads = aniversario.plusYears(4);
		System.out.println(proximasOlimpiads);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String valorFormatado = proximasOlimpiads.format(formatador);
		System.out.println(valorFormatado);
		
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora.format(formatadorComHoras));
		
		agora.toLocalDate();
	}

}
