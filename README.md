##This is a very simple lexer :3

You can use it as followse:
```java
TokenInputStream TINP = new TokenInputStream( new StringInput(text) );
...
Token T;
while( (T = TINP.next())!=null )
	{
	//	Do something woth token T
	}
```

license?
Absolutely free!