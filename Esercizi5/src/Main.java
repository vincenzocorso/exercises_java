public class Main
{
	public static void main(String[] args)
	{
		Persona persona = new Persona("Mario", "Rossi");
		Studente studente = new Studente("Vincenzo", "Corso", "Universita' degli studi di Palermo", "0678740");
		Impiegato impiegato = new Impiegato("Marco", "Verdi", null, 1732.31);
		Impiegato impiegato2 = new Impiegato("Valentino", "Blu", impiegato, 1500.32);
		Dirigente dirigente = new Dirigente("Donald", "Draper", 1800.41, "Energia & Co.");

		Persona[] persone = new Persona[]{persona, studente, impiegato, impiegato2, dirigente};
		for(Persona p : persone)
			p.presentati();
		
		System.out.println("");

		for(Persona p : persone)
			System.out.println(p);
	}
}