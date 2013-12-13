package ru.ifaculty.java.SiLex;

public class Token
	{
	public static final int TYPE_SEPARATOR		=	0	;	//	пробел, таб
	
	public static final int TYPE_VALUE			=	1	;	//	WORD
	public static final int TYPE_STRING			=	2	;	//	"WORD"
	
	public static final int TYPE_LBRACE			=	3	;	//		{
	public static final int TYPE_RBRACE			=	4	;	//		}
	public static final int TYPE_LSQUARE		=	5	;	//		[
	public static final int TYPE_RSQUARE		=	6	;	//		]
	public static final int TYPE_LPARENTHESES	=	7	;	//		(
	public static final int TYPE_RPARENTHESES	=	8	;	//		)
	
	public static final int TYPE_DOT			=	9	;	//		.
	public static final int TYPE_COMMA			=	10	;	//		,
	public static final int TYPE_COLON			=	11	;	//		:
	public static final int TYPE_SEMICOLON		=	12	;	//		;
	
	public static final int TYPE_CIRCUMFLEX		=	13	;	//		^
	public static final int TYPE_TILDES			=	14	;	//		~
	public static final int TYPE_AT_SIGN		=	15	;	//		@
	public static final int TYPE_AMPERSAND		=	16	;	//		&
	public static final int TYPE_PERCENT		=	17	;	//		%
	public static final int TYPE_NUMBER_SIGN	=	18	;	//		#

	public static final int TYPE_ASTERISK		=	19	;	//		*
	public static final int TYPE_MINUS			=	20	;	//		-
	public static final int TYPE_PLUS			=	21	;	//		+
	public static final int TYPE_EQUALITY		=	22	;	//		=
	public static final int TYPE_UNDERSCORE		=	23	;	//		_

	public static final int TYPE_QUESTION		=	24	;	//		?
	public static final int TYPE_EXCLAMATION	=	25	;	//		!
	
	public static final int TYPE_SLASH			=	26	;	//		/
	public static final int TYPE_BACKSLASH		=	27	;	//		\
	public static final int TYPE_DOLLAR			=	28	;	//		$
	
	public static final int TYPE_END_OF_CODE	=	-1	;	//	end of file
	public static final int TYPE_END_OF_LINE	=	-2	;	//	end of line, \n
	
	public int		TYPE,	LINE;
	public Token	NEXT	=	null;
	public String	TEXT	=	null;
	
	public String toString()
		{
		switch( TYPE )
			{
			case TYPE_SEPARATOR:	return("TOKEN	SEPARATOR");
			case TYPE_VALUE:		return("VALUE	"+TEXT);
			case TYPE_STRING:		return("STRING	\""+TEXT+"\"");

			case TYPE_LBRACE:		return("TOKEN	{");
			case TYPE_RBRACE:		return("TOKEN	}");
			case TYPE_LSQUARE:		return("TOKEN	[");
			case TYPE_RSQUARE:		return("TOKEN	]");
			case TYPE_LPARENTHESES:	return("TOKEN	(");
			case TYPE_RPARENTHESES:	return("TOKEN	)");

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
	}
