package ru.ifaculty.java.SiLex;

import java.io.IOException;
import java.io.InputStream;

public class TokenInputStream
	{
	//****************************************************************************************************************************************//
	private	InputStream	INP = null;
	public	TokenInputStream( InputStream I )
		{
		INP = I;
		try {
			list[0]=read();
			list[1]=read();
			list[2]=read();
			list[3]=read();
			list[4]=read();
			list[5]=read();
			test();
			}
		catch (IOException e)
			{	e.printStackTrace();	}
		for( int i=0 ; i<words.length ; i++ )
			words[i]=null;
		}
	//****************************************************************************************************************************************//
	
	

	//****************************************************************************************************************************************//
	private	static	final	byte	flagReady				=	0x08	;
	private	static	final	byte	flagIgnoreSeparator		=	0x04	;
	private	static	final	byte	flagIgnoreEndOfLine		=	0x02	;
	private	byte	flags	=		flagReady | flagIgnoreSeparator | flagIgnoreEndOfLine ;
	public	boolean	ready()							{	return	(flags&flagReady)			!=0	;	}
	private	void	setReady(	boolean f )			{	flags	=	(byte)	(	(flags&~flagReady) | (f?flagReady:0)	)	;	}
	public	boolean	ignoreSeparator()				{	return	(flags&flagIgnoreSeparator)	!=0	;	}
	public	void	setIgnoreSeparator(	boolean f )	{	flags	=	(byte)	(	(flags&~flagIgnoreSeparator) | (f?flagIgnoreSeparator:0)	)	;	}
	public	boolean	ignoreEndOfLine()				{	return	(flags&flagIgnoreEndOfLine)	!=0	;	}
	public	void	setIgnoreEndOfLine(	boolean f )	{	flags	=	(byte)	(	(flags&~flagIgnoreEndOfLine) | (f?flagIgnoreEndOfLine:0)	)	;	}
	//****************************************************************************************************************************************//
	
	
	
	//****************************************************************************************************************************************//
	private	int 		o=0;
	private	String[]	words=new String[1];
	public	String[]	getWord( )	{	packWords();	return(words);	}
	public	String		useWord( String word )
		{
		for( int i=0 ; i<words.length ; i++ )
			{
			if( words[i]!=null )
			if( words[i].equals(word) )
				return( words[i] );
			}
		addWord( word );
		return( words[o-1] );
		}
	private	void		addWord( String b )
		{
		if( o>=words.length )
			{
			String[]temp=new String[words.length*2];
			System.arraycopy(	words,0	,	temp,0	,	words.length	);
			words=temp;
			}
		words[o++]=b;
		}
	private	void		packWords()
		{
		String[]temp=new String[o];
		System.arraycopy(	words,0	,	temp,0	,	o	);
		words=temp;
		}
	//****************************************************************************************************************************************//
	
	
	
	//****************************************************************************************************************************************//
	private	Token[]	list = new Token[6];
	private	Double	parse( Token A , Token B , Token C , Token D , Token E , Token F )
		{
		try	{
			return Double.parseDouble( (A!=null?A.tSS():"") + (B!=null?B.tSS():"") + (C!=null?C.tSS():"") + (D!=null?D.tSS():"") + (E!=null?E.tSS():"") + (F!=null?F.tSS():"") );
			}
		catch( NumberFormatException e)
			{
			return( null );
			}
		}
	private	void	test()
		{
		Double val;
		val = parse( list[0] , list[1] , list[2] , list[3] , list[4] , list[5] );	//	[	- val . val - val	]
		if( val!=null )
			{
			Token T = new Token();
			T.TYPE=Token.TYPE_NUMBER;
			T.NUMB=val;
			list[0]=T;
			list[1]=list[2]=list[3]=list[4]=list[5]=null;
			return;
			}
		
		val = parse( list[0] , list[1] , list[2] , list[3] , list[4] , null );	//	[	val . val - val		]
		if( val!=null )
			{
			Token T = new Token();
			T.TYPE=Token.TYPE_NUMBER;
			T.NUMB=val;
			list[0]=T;
			list[1]=list[5];
			list[2]=list[3]=list[4]=list[5]=null;
			return;
			}
		
		val = parse( list[0] , list[1] , list[2] , list[3] , null , null );	//	[	- val . val		]
		if( val!=null )
			{
			Token T = new Token();
			T.TYPE=Token.TYPE_NUMBER;
			T.NUMB=val;
			list[0]=T;
			list[1]=list[4];
			list[2]=list[5];
			list[3]=list[4]=list[5]=null;
			return;
			}
		
		val = parse( list[0] , list[1] , null , null , null , null );	//	[	- val	]
		if( val!=null )
			{
			Token T = new Token();
			T.TYPE=Token.TYPE_NUMBER;
			T.NUMB=val;
			list[0]=T;
			list[1]=list[2];
			list[2]=list[3];
			list[3]=list[4];
			list[4]=list[5];
			list[5]=null;
			return;
			}

		val = parse( list[0] , null , null , null , null , null );	//	[	val	]
		if( val!=null )
			{
			Token T = new Token();
			T.TYPE=Token.TYPE_NUMBER;
			T.NUMB=val;
			list[0]=T;
			return;
			}
		}
	private	Token	blah=null;
	public	Token	next()
		{
		if( blah!=null && blah.TYPE == Token.TYPE_END_OF_CODE )
			{	return(null);	}
		Token T=null;
		while(	(T=nextUnfiltred())!=null	&&
			(	( ignoreSeparator() && T.TYPE == Token.TYPE_SEPARATOR )
			||	( ignoreEndOfLine() && T.TYPE == Token.TYPE_END_OF_LINE )
				)	);
		if( T!=null )
		if( T.TYPE == Token.TYPE_VALUE )
			T.TEXT = useWord( T.TEXT );
		blah=T;
		return( T );
		}
	public	Token	nextUnfiltred()
		{
		Token R = null;
		
		try {
			test();
			for( int i=0 ; i<list.length ; i++ )
				if( list[i]==null )list[i] = read();
			R=list[0];
			System.arraycopy(	list,1,	list,0	,	list.length-1	);
			list[list.length-1] = read();
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		
		return( R );
		}
	//****************************************************************************************************************************************//
	
	

	//****************************************************************************************************************************************//
	private	int 	p;
	private	byte[]	data;
	private	void	add( byte b )
		{
		if( p>=data.length )
			{
			byte[]temp=new byte[data.length*2];
			System.arraycopy(	data,0	,	temp,0	,	data.length	);
			data=temp;	temp=null;
			}
		data[p++]=b;
		}
	private	void	pack()
		{
		byte[]temp=new byte[p];
		System.arraycopy(	data,0	,	temp,0	,	p	);
		data=temp;	temp=null;
		}
	//****************************************************************************************************************************************//
	
	

	//****************************************************************************************************************************************//
	private boolean read=true;
	private	byte last=0, prev=0;
	private	Token	read() throws IOException
		{
		if( !ready() )	return( null );
		if( INP.available()==0 && read )
			{
			setReady( false );	packWords();
			return( simpleToken((byte)0) );
			}
		
		if( read )last = (byte) INP.read();
		
		Token T = simpleToken( last );
		if( T!=null )
			{
			if( T.TYPE != Token.TYPE_STRING )
				{	read=true;	return( T );	}
			else{	//	Строка
				data = new byte[4];	p=0;
				last = (byte) INP.read();
				while( last!='"' || prev=='\\' )
					{
					add( prev=last );
					last = (byte) INP.read();
					}
				pack();	//	То есть к этому моменту закрывающий " уже прочтён из потока
				T.TEXT = new String( data );
				read=true;	return( T );
				}
			}
		else{	//	Произвольное слово
			data = new byte[4];	p=0;
			while( T==null )
				{
				add( last );
				last = (byte) INP.read();
				T = simpleToken( last );
				}
			pack();
			T.TYPE = Token.TYPE_VALUE;
			T.TEXT = new String( data );
			read=false;	return( T );
			}
		}
	
	private	Token	simpleToken( byte b )
		{
		Token T = new Token();
		switch( b )
			{
			case '"':	T.TYPE = Token.TYPE_STRING;			return( T );
			//------------------------------------------------------------//
			case ' ':
			case '	':	T.TYPE = Token.TYPE_SEPARATOR;		return( T );
			//------------------------------------------------------------//
			case '{':	T.TYPE = Token.TYPE_LBRACE;			return( T );
			case '}':	T.TYPE = Token.TYPE_RBRACE;			return( T );
			case '[':	T.TYPE = Token.TYPE_LSQUARE;		return( T );
			case ']':	T.TYPE = Token.TYPE_RSQUARE;		return( T );
			case '(':	T.TYPE = Token.TYPE_LPARENTHESES;	return( T );
			case ')':	T.TYPE = Token.TYPE_RPARENTHESES;	return( T );
			case '<':	T.TYPE = Token.TYPE_LANGLE;			return( T );
			case '>':	T.TYPE = Token.TYPE_RANGLE;			return( T );
			//------------------------------------------------------------//
			case '.':	T.TYPE = Token.TYPE_DOT;			return( T );
			case ',':	T.TYPE = Token.TYPE_COMMA;			return( T );
			case ':':	T.TYPE = Token.TYPE_COLON;			return( T );
			case ';':	T.TYPE = Token.TYPE_SEMICOLON;		return( T );
			//------------------------------------------------------------//
			case '^':	T.TYPE = Token.TYPE_CIRCUMFLEX;		return( T );
			case '~':	T.TYPE = Token.TYPE_TILDES;			return( T );
			case '@':	T.TYPE = Token.TYPE_AT_SIGN;		return( T );
			case '&':	T.TYPE = Token.TYPE_AMPERSAND;		return( T );
			case '%':	T.TYPE = Token.TYPE_PERCENT;		return( T );
			case '#':	T.TYPE = Token.TYPE_NUMBER_SIGN;	return( T );
			//------------------------------------------------------------//
			case '*':	T.TYPE = Token.TYPE_ASTERISK;		return( T );
			case '-':	T.TYPE = Token.TYPE_MINUS;			return( T );
			case '+':	T.TYPE = Token.TYPE_PLUS;			return( T );
			case '=':	T.TYPE = Token.TYPE_EQUALITY;		return( T );
			case '_':	T.TYPE = Token.TYPE_UNDERSCORE;		return( T );
			case '?':	T.TYPE = Token.TYPE_QUESTION;		return( T );
			case '!':	T.TYPE = Token.TYPE_EXCLAMATION;	return( T );
			case '/':	T.TYPE = Token.TYPE_SLASH;			return( T );
			case '\\':	T.TYPE = Token.TYPE_BACKSLASH;		return( T );
			case '$':	T.TYPE = Token.TYPE_DOLLAR;			return( T );
			//------------------------------------------------------------//
			case '\r':
			case '\n':	T.TYPE = Token.TYPE_END_OF_LINE;	return( T );
			//------------------------------------------------------------//
			case 0:		T.TYPE = Token.TYPE_END_OF_CODE;	return( T );	//	Я полагаю что в текстовом файле вряд-ли встретится 0
			//------------------------------------------------------------//
			default:	return( null );
			}
		}
	//****************************************************************************************************************************************//
	}
