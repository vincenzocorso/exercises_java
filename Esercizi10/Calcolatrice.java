import stack.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Calcolatrice
{
	public static boolean isOperator(String s)
	{
		return (s.equals("+") || s.equals("*") || s.equals("-") | s.equals("/"));
	}
	
	private static double applyOperator(double operando1, double operando2, String operatore)
	throws IllegalArgumentException
	{
		if(operatore.equals("+"))
			return operando1 + operando2;
		else if(operatore.equals("*"))
			return operando1 * operando2;
		else if(operatore.equals("/"))
			return operando1 / operando2;
		else if(operatore.equals("-"))
			return operando1 - operando2;
		else throw new IllegalArgumentException();
	}

	public static double calcolaEspressioneInfissa(String exp)
	{
		Stack<Double> operandi = new ArrayListStack<>();
		Stack<String> operatori = new ArrayListStack<>();
		
		Scanner in = new Scanner(exp);
		while(in.hasNext())
		{
			while(in.hasNextDouble())
				operandi.push(in.nextDouble());
			
			if(in.hasNext())
			{
				String operatore = in.next();
				if(operatore.equals(")"))
				{
					double o2 = operandi.pop();
					operandi.push(applyOperator(operandi.pop(), o2, operatori.pop()));
				}
				else if(isOperator(operatore))
					operatori.push(operatore);
			}
		}
		return operandi.pop();
	}
	
	public static double calcolaEspressionePostfissa(String exp)
	{
		ArrayListStack<Double> stack = new ArrayListStack<>();
		Scanner in = new Scanner(exp);
		while(in.hasNext())
		{
			while(in.hasNextDouble())
				stack.push(in.nextDouble());
			
			if(in.hasNext())
			{
				String operator = in.next();
				if(operator.equals("+"))
					stack.push(stack.pop() + stack.pop());
				else if(operator.equals("*"))
					stack.push(stack.pop() * stack.pop());
				else if(operator.equals("-"))
				{
					double secondOperand = stack.pop();
					stack.push(stack.pop() - secondOperand);
				}
				else if(operator.equals("/"))
				{
					double secondOperand = stack.pop();
					stack.push(stack.pop() / secondOperand);
				}
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args)
	{
		String exp = "2 3 + 5 * 8 2 * + 3 4 + *";
		System.out.println("Risultato: " + calcolaEspressionePostfissa(exp));
		
		exp = "2 -3 -";
		System.out.println("Risultato: " + calcolaEspressionePostfissa(exp));

		exp = "( ( ( 2 / 2 ) * 3 ) + ( ( 4 * 2 ) / 4 ) )";
		System.out.println("Risultato: " + calcolaEspressioneInfissa(exp));

		exp = "( ( 1 + 3 ) + ( 3 * ( 1 - 2 ) ) )";
		System.out.println("Risultato: " + calcolaEspressioneInfissa(exp));
	}
}