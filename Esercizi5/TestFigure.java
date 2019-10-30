import geometria.Punto;
import geometria.figurepiane.*;

public class TestFigure
{
	public static void main(String[] args)
	{
		Punto[] vertici;

		vertici = new Punto[]{new Punto(-2.0, 0.0), new Punto(0.0, 4.0), new Punto(2.0, 1.0), new Punto(2.0, -1.0)};
		Quadrilatero a = new Quadrilatero(vertici);
		vertici = new Punto[]{new Punto(0.0, 3.0), new Punto(3.0, 3.0), new Punto(5.0, 0.0), new Punto()};
		Trapezio b = new Trapezio(vertici);
		vertici = new Punto[]{new Punto(-1.0, 3.0), new Punto(3.0, 3.0), new Punto(1.0, -1.0), new Punto(-3.0, -1.0)};
		Parallelogramma c = new Parallelogramma(vertici);
		vertici = new Punto[]{new Punto(), new Punto(0.0, 3.0), new Punto(5.0, 3.0), new Punto(5.0, 0.0)};
		Rettangolo d = new Rettangolo(vertici);
		vertici = new Punto[]{new Punto(), new Punto(0.0, 3.0), new Punto(3.0, 3.0), new Punto(3.0, 0.0)};
		Quadrato e = new Quadrato(vertici);
		vertici = new Punto[]{new Punto(0.0, 2.0), new Punto(1.0, 4.0), new Punto(2.0, 2.0), new Punto(1.0, 0.0)};
		Rombo f = new Rombo(vertici);

		Quadrilatero[] quadrilateri = new Quadrilatero[]{a, b, c, d, e, f};
		for(Quadrilatero q : quadrilateri)
			System.out.println("Perimetro: " + q.calcolaPerimetro() + "\nArea: " + q.calcolaArea() + "\n");
	}
}