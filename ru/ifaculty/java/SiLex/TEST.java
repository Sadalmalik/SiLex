package ru.ifaculty.java.SiLex;

public class TEST
	{
	public static void main( String[]args )
		{
		Token head;
		
		System.out.println();
		System.out.println();
		System.out.println();
		head = Lexer.parse("Just  test	string");
		System.out.println("Just  test	string");
		System.out.println();
		show( head );
		
		System.out.println();
		System.out.println();
		System.out.println();
		head = Lexer.parse("	public int		TYPE;\n	public Token	NEXT	=	null;\n	public String	TEXT	=	null;");
		System.out.println("	public int		TYPE;\n	public Token	NEXT	=	null;\n	public String	TEXT	=	null;");
		System.out.println();
		show( head );
		
		System.out.println();
		System.out.println();
		System.out.println();
		head = Lexer.parse("String MyStringName = \"Just  test	string\";");
		System.out.println("String MyStringName = \"Just  test	string\";");
		System.out.println();
		show( head );
		
		System.out.println();
		System.out.println();
		System.out.println();
		head = Lexer.parse("{\"method\":\"echo\",\"params\":[\"Hello JSON-RPC\"],\"id\":1}");
		System.out.println("{\"method\":\"echo\",\"params\":[\"Hello JSON-RPC\"],\"id\":1}");
		System.out.println();
		show( head );
		
		System.out.println();
		System.out.println();
		System.out.println();
		head = Lexer.parse("(defun fibonacci (n)\n(loop repeat (+ n 1)\n	for a = 1 then b\n	and b = 1 then (+ a b)\n	finally (return a)))");
		System.out.println("(defun fibonacci (n)\n(loop repeat (+ n 1)\n	for a = 1 then b\n	and b = 1 then (+ a b)\n	finally (return a)))");
		System.out.println();
		show( head );
		
		head = Lexer.parse("OUT.add(MOD[0]+MOD[7]);");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("OUT.add(MOD[0]+MOD[7]);");
		System.out.println();
		show( head );
		}
	public static void show( Token head )
		{
		for( Token temp = head ; temp!=null ; temp = temp.NEXT )
			{	System.out.println( temp.LINE + "	" + temp );	}
		}
	}
