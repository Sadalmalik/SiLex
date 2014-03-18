package ru.ifaculty.java.SiLex;

import java.io.IOException;
import java.io.InputStream;

public class TEST
	{
	public	static	class StringInput extends InputStream
		{
		public	int		p=0;
		public	byte[]	data;
		public	StringInput( String TEXT )		{	data=TEXT.getBytes();	}
		public	int	available()					{	return( data.length-p );	}
		public	int read() throws IOException	{	if( p>=data.length )return(0);	return( data[p++] );	}
		}

	public	static	void	parse( String text )
		{
		Token	T;
		TokenInputStream TINP;
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(text);
		TINP = new TokenInputStream( new StringInput(text) );
		System.out.println();
		while( (T = TINP.next())!=null )	System.out.println(T);
		System.out.println( "\nwords:" );
		for( String W : TINP.getWord() )	System.out.println((W==null?"	~":"	")+W);
		}
	public	static	void main( String[]args )
		{
		parse( "Just,  test	string" );
		parse( "	public int		TYPE;\n	public Token	NEXT	=	null;\n	public String	TEXT	=	null;" );
		parse( "String MyStringName = \"Just  test	string\";" );
		parse( "{\"method\":\"echo\",\"params\":[\"Hello JSON-RPC\"],\"id\":1}" );
		parse( "(defun fibonacci (n)\n(loop repeat (+ n 1)\n	for a = 1 then b\n	and b = 1 then (+ a b)\n	finally (return a)))" );
		parse( "OUT.add(MOD[0]+MOD[7]);" );
		parse( "попробуем много чисел: -1000.05, 100, 83.12E-23" );
		parse( "struct header\n	{\n	BIT32	magic;\n	BIT32	size;\n	}" );
		parse( "-9000.0009e-9" );
		}
	}
