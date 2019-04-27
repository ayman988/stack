package datastructure.stack;
import java.util.Scanner;
public class IExpressionEvaluator {
	static int[][] a=new int[2][50];
	static int k=0;
 Istack Stack=new Istack();
/**
 * Takes a symbolic/numeric infix expression as input and converts it to
 * postfix notation. 
 * @param expression
 *             infix expression
 * @return postfix expression
 */
	public String infixToPostfix(String expression) {
		int n=expression.length(),i,j,flag=0,f;
		char temp;
		String s="",s3="";
		
		 s="";
		for(i=0;i<n;i++) {
			if((expression.charAt(i)=='*'||expression.charAt(i)=='/')&&expression.charAt(i+1)=='-') {
				s=s+expression.charAt(i)+'('+'0'+'-';
				i+=2;
			while((expression.charAt(i)-'0')>=0&&(expression.charAt(i)-'0')<=9) {
					s=s+expression.charAt(i);
					i++;
					flag=1;
				}
				if(flag==1){s=s+')'+expression.charAt(i);}
			 if(flag==0&&expression.charAt(i)=='(') {
					s=s+'(';
					i++;
                while(expression.charAt(i)!=')') {
                	s=s+expression.charAt(i);
                	i++;
                }
                s=s+')'+')';
			}
			}
			else {s=s+expression.charAt(i);}
			flag=0;
			}
		n=s.length();
		for(i=0;i<n;i++) {
			while(i<n&&(s.charAt(i)-'0')>=0&&(s.charAt(i)-'0')<=9) {s3=s3+s.charAt(i);
			i++;}
			implement(s3);
			
			 s3="";
		}
		char c[]=s.toCharArray();
		
		for(i=0;i<n-1;i++)
		{
			if((c[i]=='*'||c[i]=='/')&&((c[i+1]-'0')>=0&&(c[i+1]-'0')<=9))
			{
			  temp=c[i];
			  c[i]=c[i+1];
			  c[i+1]=temp;
			  
			}
		}
		for(i=1;i<n-1;i++) {
			
			if((c[i]=='+'||c[i]=='-')&&c[i+1]!='+'&&c[i+1]!='-'&&c[i+1]!='('&&c[i+1]!=')')
			{
				 temp=c[i];
				  c[i]=c[i+1];
				  c[i+1]=temp;
				  if(c[i]=='*'||c[i]=='/') {i++;}
			}
		}
		for(f=0;f<n;f++) {
		for(i=f;i<n-1;i++)
		{
			if((c[i]=='+'||c[i]=='*'||c[i]=='/'||c[i]=='-')&&c[i+1]=='(')
			{
				j=i+1;
				while(j<n-1&&c[j]!=')') {j++;}
				temp=c[i];
				while((i+1)<n&&i!=j)
				{
					c[i]=c[i+1];
					i++;
				}
				c[j]=temp;
				i++;
			}
		}}
		String s2="";
		for(i=0;i<n;i++) {
			if(c[i]==')'||c[i]=='(') {continue;}
			s2=s2+(c[i]);
		}

		return s2;
	}
/**
 * Evaluate a postfix numeric expression
 * @param expression
 *             postfix expression
 * @return the expression evaluated value
 */
	public float evaluate(String expression) {
	  
		char c[]=expression.toCharArray();		
		int n=expression.length(),i,f=1,h=0;
		for(i=0;i<n;i++)
		{ f=1;
			while(i<n&&(c[i]-'0')>=0&&(c[i]-'0')<=9&&f!=a[1][h]&&h<k){f++;
			i++;}
			if(!((c[i]-'0')<0||(c[i]-'0')>9)) {
			object obj=new object();
			obj.setresult((float)(a[0][h]));
			Stack.push(obj);
			h++;}	
			
		if((c[i]-'0')<0||(c[i]-'0')>9){Stack.push(solve(Stack.pop().getresult(),Stack.pop().getresult(),c[i]));}
		
		}
		return Stack.pop().getresult(); 
	}
	/**
	 * solve two operands expression with single operation
	 * @param B
	 *       first operand
	 * @param A
	 *       second operand
	 * @param c
	 *      operation
	 * @return the evaluated value of the expression
	 */
	public object solve(float B,float A,char c) {
		 object obj=new object();
		float z;
		if(c=='+') {z= A+B;}
		else if(c=='-') {z= A-B;}
		else if(c=='*') {z= A*B;}
		else {z= A/B;}
		obj.setresult(z);
		return obj;
		
	}
	/**
	 * store integers in global array for multi digit numbers
	 * @param s
	 *       a number in the infix expression
	 */
	public void implement(String s) {
		int n=s.length(),i,j=0;
		if(n>0) {
		double temp=0;
		for(i=0;i<n;i++) {
			temp=temp+Math.pow(10,(double)(n-j-1))*(double)(s.charAt(i)-'0');
			j++;
		}
		a[0][k]=(int)(temp);
		a[1][k]=n;
		k++;
		
	}
	}
	public static void main(String[] agrs)
	{
		Scanner input=new Scanner(System.in);
		IExpressionEvaluator Stack3=new IExpressionEvaluator();
		Istack Stack2=new Istack();
	    char c;
	    int a,i,n,flag=0;
	    System.out.println("1:Push");
	    System.out.println("2:Pop");
	    System.out.println("3:Peek");
	    System.out.println("4:Get size");
	    System.out.println("5:Check if empty");
	    System.out.println("6:evaluate expression");
	    c=input.next(".").charAt(0);
	    while(c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6') {
	    if(c=='1') {
	    System.out.println("Enter an integer value:");
	    a=input.nextInt();
	    object obj=new object();
	    obj.setvalue(a);
	    Stack2.push(obj);
	    }
	    if(c=='2') {
	    	System.out.println(Stack2.pop().getvalue());
	    }
	    if(c=='3') {
	    	System.out.println(Stack2.peek().getvalue());
	    }
	    if(c=='4') {
	    	System.out.println(Stack2.peek().getsize());
	    }
	    if(c=='5') {
	    	if(Stack2.isEmpty()==true) {System.out.println("True");}
	    	else {System.out.println("False");}
	    }
	    if(c=='6') {
	    	System.out.println("Enter the infix expression:");
	    	Scanner input2=new Scanner(System.in);
	    	String s=input2.nextLine();
	    	n=s.length();
	    	for(i=0;i<n;i++) {
	    		if(s.charAt(i)!='/'&&s.charAt(i)!='*'&&s.charAt(i)!='-'&&s.charAt(i)!='+'&&s.charAt(i)!=')'&&s.charAt(i)!='('&&s.charAt(i)-'0'>9&&s.charAt(i)-'0'<0){
	    			System.out.println("Invalid Input!");
	    			flag=1;
	    			break;}}
	    if(flag==0){	
	    	s=Stack3.infixToPostfix(s);
	    	System.out.println("the postfix expression:");
	    	System.out.println(s);
	    	System.out.println("the result:");
	    	float x=Stack3.evaluate(s);
	    	System.out.println(x);
	    }}
	    System.out.println("1:Push");
	    System.out.println("2:Pop");
	    System.out.println("3:Peek");
	    System.out.println("4:Get size");
	    System.out.println("5:Check if empty");
	    System.out.println("6:evaluate expression");
	    c=input.next(".").charAt(0);
	    flag=0;
	}
	}
}
