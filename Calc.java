import java.util.Stack;

public class Calc /*the class is based on the program from Home work 1*/
{
	private String str;
	
	public Calc(String str)
	{
		this.str=str;
	}
	
	public String Calculator()  
	{
		String answer;
		String errorstr="Enter a number first";
		String errorstr2="Illegal input";
		String errorzero="Cannot divide by 0";
		int i=0;
		float res;
		char[] tokens1 = str.toCharArray(); // convert from string to array of char.
		for(i=0;i<str.length();i++)//checking illegal inputs.
		{
			if(!(tokens1[0]>='0'&&tokens1[0]<='9'))
				return errorstr;
			if(!(tokens1[i]>='0'&&tokens1[i]<='9')&&!(tokens1[i+1]>='0'&&tokens1[i+1]<='9')&&tokens1[i+1]!='-'||
					!(tokens1[str.length()-1]>='0'&&tokens1[str.length()-1]<='9'))
				return errorstr2;
			if(tokens1[i]=='/'&&tokens1[i+1]=='0')
				return errorzero;	
		}
		char[] tokens = new char[str.length() * 2];
		Space(tokens1, tokens, str.length()); 
		
		
		Stack<Float> values = new Stack<Float>(); // Stack for numbers.
		Stack<Character> ops = new Stack<Character>(); // stack for symbols.

		for ( i = 0; i < tokens.length; i++)
		{

			if (tokens[i] >= '0' && tokens[i] <= '9' || i == 0
					|| (tokens[i] == '-' && (tokens[i - 2] == '*' || tokens[i - 2] == '/'))) 
			{
				StringBuffer sbuf = new StringBuffer();
				// There may be more than one digits in number
				while (i < tokens.length
						&& (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.' || tokens[i] == '-')) 
				{
					if (tokens[i] == '-') 
					{
						sbuf.append(tokens[i++]);
						i++;
					}

					else
						sbuf.append(tokens[i++]);
				}
				values.push(Float.parseFloat(sbuf.toString())); // push the number to the numbers stack.
			}

			else if (tokens[i] == '(')
				ops.push(tokens[i]); // push the symbol to the symbol stack

			else if (tokens[i] == ')') 
			{
				while (ops.peek() != '(') // while the top of the stack!='('.
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				// calculate the expression between the (),and push the result
				// to the numbers stack.
				ops.pop(); // do pop to the symbol stack.
			}

			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')
			{

				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));

				ops.push(tokens[i]);
			}
		}

		while (!ops.empty())
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));

		
			  res = values.peek(); 
			  answer=String.valueOf(res);
			  return answer;		  
	}
		
		
	// Returns true if 'op2' has higher or same precedence as 'op1',
	// otherwise returns false.
	public static boolean hasPrecedence(char op1, char op2)
	{
		if (op2 == '(' || op2 == ')')
			return false;
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
			return false;
		else
			return true;
	}

	// A method to apply an operator 'op' on operands 'a'
	// and 'b'. Return the result.
	public static float applyOp(char op, float b, float a)
	{
		switch (op)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':	
			return a / b;
		}
		return 0;
	}

	public static void Space(char from_str[], char in_str[], int len)
	{
		int i, j = 0;
		for (i = 0; i < len; i++) 
		{
			if (i == len - 1)
				in_str[j] = from_str[i];
			else if ((from_str[i] >= '0') && (from_str[i] <= '9')) 
			{
				if ((from_str[i + 1] >= '0') && (from_str[i + 1] <= '9') || (from_str[i + 1] == '.'))
				{
					in_str[j] = from_str[i];
					j++;
				} 
				else if (from_str[i + 1] == '+' || from_str[i + 1] == '-' || from_str[i + 1] == '*'
						|| from_str[i + 1] == '/' || from_str[i + 1] == '(' || from_str[i + 1] == ')')
				{
					in_str[j] = from_str[i];
					in_str[j + 1] = ' ';
					j = j + 2;
				}
			}
			else if (from_str[i] == '.') 
			{
				in_str[j] = from_str[i];
				j++;
			}

			else if (from_str[i] == '+' || from_str[i] == '-' || from_str[i] == '*' || from_str[i] == '/'|| from_str[i] == '(' || from_str[i] == ')')
			{
				in_str[j] = from_str[i];
				in_str[j + 1] = ' ';
				j = j + 2;
			}
		}
	}
}
