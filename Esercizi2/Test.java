public class Test
{
	static final double PI = 3.14;
	static int num;

	public static void main(String[] args)
	{
		Test t = new Test();
		System.out.println(Test.PI);
		System.out.println(PI);
		System.out.println(++Test.num);
		System.out.println(++num);
		System.out.println(++t.num);
	}
}