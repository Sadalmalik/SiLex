package ru.ifaculty.java.SiLex;

public class Lexer
	{
	public static Token head, tail;
	public static Token nextToken()
		{
		SEP=false;
		if( head==null )
			{
			head=tail=new Token();
			tail.LINE=LINE;
			}
		else{
			if( WRD )
				{
				WRD=false;
				tail.TEXT = TEXT.toString();
				TEXT.setLength(0);
				}
			tail.NEXT=new Token();
			tail=tail.NEXT;
			tail.LINE=LINE;
			}
		return( tail );
		}
	public static int LINE=0;
	public static boolean WRD, SEP, STR;
	public static StringBuilder TEXT = new StringBuilder();
	public static Token parse( String IN )
		{
		int i=0;
		
		LINE=0;
		head=null;
		tail=null;
		TEXT.setLength(0);
		
		WRD=false;
		SEP=false;
		STR=false;
		
		char[]data = IN.toCharArray();
		
		for( i=0 ; i<data.length ; i++ )
			{
			if( STR )	//	особый случай прост =)
				{
				if( data[i]=='"' && data[i-1]!='\\' )
					{
					STR=false;
					tail.TEXT = TEXT.toString();
					TEXT.setLength(0);
					}
				else{
					TEXT.append(data[i]);
					}
				continue;
				}
			switch( data[i] )
				{
				case ' ':
				case '	':
					if( !SEP )
						{
						nextToken().TYPE = Token.TYPE_SEPARATOR;
						SEP=true;
						}
					break;
				//------------------------------------------------------------//
				case '{':	nextToken().TYPE = Token.TYPE_LBRACE;			break;
				case '}':	nextToken().TYPE = Token.TYPE_RBRACE;			break;
				case '[':	nextToken().TYPE = Token.TYPE_LSQUARE;			break;
				case ']':	nextToken().TYPE = Token.TYPE_RSQUARE;			break;
				case '(':	nextToken().TYPE = Token.TYPE_LPARENTHESES;		break;
				case ')':	nextToken().TYPE = Token.TYPE_RPARENTHESES;		break;
				//------------------------------------------------------------//
				case '.':	nextToken().TYPE = Token.TYPE_DOT;				break;
				case ',':	nextToken().TYPE = Token.TYPE_COMMA;			break;
				case ':':	nextToken().TYPE = Token.TYPE_COLON;			break;
				case ';':	nextToken().TYPE = Token.TYPE_SEMICOLON;		break;
				//------------------------------------------------------------//
				case '^':	nextToken().TYPE = Token.TYPE_CIRCUMFLEX;		break;
				case '~':	nextToken().TYPE = Token.TYPE_TILDES;			break;
				case '@':	nextToken().TYPE = Token.TYPE_AT_SIGN;			break;
				case '&':	nextToken().TYPE = Token.TYPE_AMPERSAND;		break;
				case '%':	nextToken().TYPE = Token.TYPE_PERCENT;			break;
				case '#':	nextToken().TYPE = Token.TYPE_NUMBER_SIGN;		break;
				//------------------------------------------------------------//
				case '*':	nextToken().TYPE = Token.TYPE_ASTERISK;			break;
				case '-':	nextToken().TYPE = Token.TYPE_MINUS;			break;
				case '+':	nextToken().TYPE = Token.TYPE_PLUS;				break;
				case '=':	nextToken().TYPE = Token.TYPE_EQUALITY;			break;
				case '_':	nextToken().TYPE = Token.TYPE_UNDERSCORE;		break;
				case '?':	nextToken().TYPE = Token.TYPE_QUESTION;			break;
				case '!':	nextToken().TYPE = Token.TYPE_EXCLAMATION;		break;
				case '/':	nextToken().TYPE = Token.TYPE_SLASH;			break;
				case '\\':	nextToken().TYPE = Token.TYPE_BACKSLASH;		break;
				case '$':	nextToken().TYPE = Token.TYPE_DOLLAR;			break;
				//------------------------------------------------------------//
				case '\n':	nextToken().TYPE = Token.TYPE_END_OF_LINE;	LINE++;	break;
				case '"':	nextToken().TYPE = Token.TYPE_STRING;STR=true;	break;
				default:
					if( WRD )	{	TEXT.append(data[i]);	}
					else{
						TEXT.append(data[i]);
						nextToken().TYPE = Token.TYPE_VALUE;
						WRD=true;	STR=false;	SEP=false;
						}
					break;
				}
			}
		nextToken().TYPE = Token.TYPE_END_OF_CODE;
		return( head );
		}
	}
