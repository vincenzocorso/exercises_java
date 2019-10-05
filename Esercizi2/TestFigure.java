import geometria.figurepiane.*;
import geometria.figuresolide.*;

// Per compilare: javac -d ./ ./Figure/*.java

public class TestFigure
{
	public static void main(String[] args)
	{
		Cerchio a = new Cerchio(2.0);
		System.out.println("Area cerchio: " + a.calcolaArea());

		Quadrato b = new Quadrato(2.0);
		System.out.println("Area quadrato: " + b.calcolaArea());
		b.raddoppiaLato();
		System.out.println("Area quadrato: " + b.calcolaArea());

		Cubo c = new Cubo(2.0);
		System.out.println("Volume cubo: " + c.calcolaVolume());
	}
}