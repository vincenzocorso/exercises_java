/**
* Permette di creare oggetti che rappresentano autori letterari.
* @author Vincenzo Corso (vincenzocorso99@gmail.com)
* @version 0.1
*/
public class Autore
{
	private String nome;
	private String cognome;

	/**
	* Crea un autore conoscendo nome e cognome di quest'ultimo.
	* @param nome Il nome dell'autore.
	* @param cognome Il cognome dell'autore.
	*/
	public Autore(String nome, String cognome)
	{
		this.nome = nome;
		this.cognome = cognome;
	}

	/**
	* Restituisce il nome dell'autore.
	*/
	public String getNome()
	{
		return this.nome;
	}

	/**
	* Restituisce il cognome dell'autore.
	*/
	public String getCognome()
	{
		return this.cognome;
	}

	/**
	* Restituisce una rappresentazione tramite stringa dell'autore.
	* @return Stringa nel formato 'Nome Cognome'.
	*/
	@Override
	public String toString()
	{
		return this.getNome() + " " + this.getCognome();
	}
}