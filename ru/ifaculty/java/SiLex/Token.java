package ru.ifaculty.java.SiLex;

public class Token
	{
	public static final int TYPE_SEPARATOR		=	0	;	//	пробел, таб
	
	public static final int TYPE_VALUE			=	1	;	//	WORD
	public static final int TYPE_STRING			=	2	;	//	"WORD"
	public static final int TYPE_NUMBER			=	3	;	//	WORD
	
	public static final int TYPE_LBRACE			=	4	;	//		{
	public static final int TYPE_RBRACE			=	5	;	//		}
	public static final int TYPE_LSQUARE		=	6	;	//		[
	public static final int TYPE_RSQUARE		=	7	;	//		]
	public static final int TYPE_LPARENTHESES	=	8	;	//		(
	public static final int TYPE_RPARENTHESES	=	9	;	//		)
	public static final int TYPE_LANGLE			=	10	;	//		<
	public static final int TYPE_RANGLE			=	11	;	//		>
	
	public static final int TYPE_DOT			=	12	;	//		.
	public static final int TYPE_COMMA			=	13	;	//		,
	public static final int TYPE_COLON			=	14	;	//		:
	public static final int TYPE_SEMICOLON		=	15	;	//		;
	
	public static final int TYPE_CIRCUMFLEX		=	16	;	//		^
	public static final int TYPE_TILDES			=	17	;	//		~
	public static final int TYPE_AT_SIGN		=	18	;	//		@
	public static final int TYPE_AMPERSAND		=	19	;	//		&
	public static final int TYPE_PERCENT		=	20	;	//		%
	public static final int TYPE_NUMBER_SIGN	=	21	;	//		#

	public static final int TYPE_ASTERISK		=	22	;	//		*
	public static final int TYPE_MINUS			=	23	;	//		-
	public static final int TYPE_PLUS			=	24	;	//		+
	public static final int TYPE_EQUALITY		=	25	;	//		=
	public static final int TYPE_UNDERSCORE		=	26	;	//		_

	public static final int TYPE_QUESTION		=	27	;	//		?
	public static final int TYPE_EXCLAMATION	=	28	;	//		!
	
	public static final int TYPE_SLASH			=	29	;	//		/
	public static final int TYPE_BACKSLASH		=	30	;	//		\
	public static final int TYPE_DOLLAR			=	31	;	//		$
	
	public static final int TYPE_END_OF_CODE	=	-1	;	//	end of file
	public static final int TYPE_END_OF_LINE	=	-2	;	//	end of line, \n
	
	public int		TYPE;
	public String	TEXT	=	null;
	public Number	NUMB	=	null;
	
	public String toString()
		{
		switch( TYPE )
			{
			case TYPE_SEPARATOR:	return("TOKEN	SEPARATOR");
			case TYPE_VALUE:		return("VALUE	"+TEXT);
			case TYPE_STRING:		return("STRING	\""+TEXT+"\"");
			case TYPE_NUMBER:		return("NUMBER	"+NUMB);

			case TYPE_LBRACE:		return("TOKEN	{");
			case TYPE_RBRACE:		return("TOKEN	}");
			case TYPE_LSQUARE:		return("TOKEN	[");
			case TYPE_RSQUARE:		return("TOKEN	]");
			case TYPE_LPARENTHESES:	return("TOKEN	(");
			case TYPE_RPARENTHESES:	return("TOKEN	)");
			case TYPE_LANGLE:		return("TOKEN	<");
			case TYPE_RANGLE:		return("TOKEN	>");
			
			case TYPE_DOT:			return("TOKEN	.");
			case TYPE_COMMA:		return("TOKEN	,");
			case TYPE_COLON:		return("TOKEN	:");
			case TYPE_SEMICOLON:	return("TOKEN	;");

			case TYPE_CIRCUMFLEX:	return("TOKEN	^");
			case TYPE_TILDES:		return("TOKEN	~");
			case TYPE_AT_SIGN:		return("TOKEN	@");
			case TYPE_AMPERSAND:	return("TOKEN	&");
			case TYPE_PERCENT:		return("TOKEN	%");
			case TYPE_NUMBER_SIGN:	return("TOKEN	#");

			case TYPE_ASTERISK:		return("TOKEN	*");
			case TYPE_MINUS:		return("TOKEN	-");
			case TYPE_PLUS:			return("TOKEN	+");
			case TYPE_EQUALITY:		return("TOKEN	=");
			case TYPE_UNDERSCORE:	return("TOKEN	_");

			case TYPE_QUESTION:		return("TOKEN	?");
			case TYPE_EXCLAMATION:	return("TOKEN	!");

			case TYPE_SLASH:		return("TOKEN	/");
			case TYPE_BACKSLASH:	return("TOKEN	\\");
			case TYPE_DOLLAR:		return("TOKEN	$");

			case TYPE_END_OF_CODE:	return("TOKEN	END OF CODE");
			case TYPE_END_OF_LINE:	return("TOKEN	END OF LINE");
			}
		return("TOKEN	UNDEFINED");
		}

	public String toShortString()
		{	return( tSS() );	}
	public String tSS()	//	короткое имя
		{
		switch( TYPE )
			{
			case TYPE_SEPARATOR:	return(" ");
			case TYPE_VALUE:		return(TEXT);
			case TYPE_STRING:		return("\""+TEXT+"\"");
			case TYPE_NUMBER:		return(""+NUMB);

			case TYPE_LBRACE:		return("{");
			case TYPE_RBRACE:		return("}");
			case TYPE_LSQUARE:		return("[");
			case TYPE_RSQUARE:		return("]");
			case TYPE_LPARENTHESES:	return("(");
			case TYPE_RPARENTHESES:	return(")");
			case TYPE_LANGLE:		return("<");
			case TYPE_RANGLE:		return(">");

			case TYPE_DOT:			return(".");
			case TYPE_COMMA:		return(",");
			case TYPE_COLON:		return(":");
			case TYPE_SEMICOLON:	return(";");

			case TYPE_CIRCUMFLEX:	return("^");
			case TYPE_TILDES:		return("~");
			case TYPE_AT_SIGN:		return("@");
			case TYPE_AMPERSAND:	return("&");
			case TYPE_PERCENT:		return("%");
			case TYPE_NUMBER_SIGN:	return("#");

			case TYPE_ASTERISK:		return("*");
			case TYPE_MINUS:		return("-");
			case TYPE_PLUS:			return("+");
			case TYPE_EQUALITY:		return("=");
			case TYPE_UNDERSCORE:	return("_");

			case TYPE_QUESTION:		return("?");
			case TYPE_EXCLAMATION:	return("!");

			case TYPE_SLASH:		return("/");
			case TYPE_BACKSLASH:	return("\\");
			case TYPE_DOLLAR:		return("$");

			case TYPE_END_OF_CODE:	return("");
			case TYPE_END_OF_LINE:	return("\n");
			}
		return("");
		}
	}
