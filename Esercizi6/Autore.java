public class Autore implements Comparable<Autore>
{
	private String nome;
	private String cognome;

	public Autore(String nome, String cognome)
	{
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome()
	{
		return this.nome;
	}

	public String getCognome()
	{
		return this.cognome;
	}

	@Override
	public String toString()
	{
		return this.cognome + " " + this.nome;
	}

	@Override
	public boolean equals(Object o)
	{
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		Autore a = (Autore)o;
		if(!this.nome.equals(a.nome)) return false;
		if(!this.cognome.equals(a.cognome)) return false;
		return true;
	}

	@Override
	public int compareTo(Autore a)
	{
		int comp = this.cognome.compareToIgnoreCase(a.cognome);
		return (comp != 0) ? comp : this.nome.compareToIgnoreCase(a.nome);
	}
}