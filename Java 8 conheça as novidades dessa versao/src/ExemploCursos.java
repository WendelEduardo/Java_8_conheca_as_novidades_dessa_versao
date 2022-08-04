import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
	
	@Override
	public String toString() {
		String aux = "";
		aux += "Nome: " + nome + "\n";
		aux += "Alunos: " + alunos + "\n";
		return aux;
	}
}

public class ExemploCursos {
	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
	
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		cursos.stream().filter(c -> c.getAlunos() >= 100).forEach(c -> System.out.println("Cursos maior que 100 alunos: " + c.getNome()));
				
		System.out.println("\nNúmero de cursos maior que 100 alunos: " + cursos.stream().filter(c -> c.getAlunos() >= 100).count());
		
		cursos.stream().filter(c -> c.getAlunos() >= 100).map(Curso::getAlunos).forEach(System.out::println);
	
		int sum = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).sum();
	
		System.out.println(sum);
		
		System.out.println("\n Cursos com mais de 50 alunos");
		cursos.stream().filter(c -> c.getAlunos() >= 50).forEach(c -> System.out.println(c));
		
		
		cursos.stream().filter(c -> c.getAlunos() >= 100).findAny().ifPresent(c -> System.out.println(c.getNome()));
		//Curso curso = optinalCurso.orElse(null);
		
		List<Curso> resultado = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList());
		
		System.out.println(" ------------------- ");
		cursos.parallelStream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos())).forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
		System.out.println(" ------------------- ");
		
		System.out.println(" ");
		cursos.stream().forEach(c -> System.out.println(c.getNome()));
		System.out.println(" ");
		System.out.println(resultado);
		
		System.out.println("\n---------- Quantidade média de alunos");
		System.out.println(cursos.stream().filter(c -> c.getAlunos() > 0).mapToInt(Curso::getAlunos).sum() / cursos.stream().count());
		
		System.out.println("\n---------- Quantidade média de alunos (RESUMIDO)");
		System.out.println(cursos.stream().mapToInt(c -> c.getAlunos()).average());
		
	}
}
