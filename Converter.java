public class Converter{

	Stack stack;
	Stack operand;
	String read = "", parsed = "", written = "";
	char previousChar = '\0';
	String previousOperator = "";

	String[] arrayString = new String[20];
	String[] postfix = new String[20];
	String[] arrayStack = new String[20];
	String str = "";
	int ctr = 0, ctr2 = 0, ctr3 = 0;

	double op1 = 0.0;
	double op2 = 0.0;
	double answer = 0.0;

	public void inputToArray(String string){
		for(int i = 0; i < string.length(); i++){
			if(string.charAt(i) != ' '){
				str += String.valueOf(string.charAt(i));
			}else{
				arrayString[ctr++] = str;
				str = "";
			}
		}
		if(!str.equals("")){
			arrayString[ctr++] = str;
		}
		infixToPostfix();
	}

	public void infixToPostfix(){
		//inputToArray(string);
		str = "";
		stack = new Stack(ctr);
		for(int i = 0; i < ctr; i++){
			String current = arrayString[i];
			if(current.equals("*") || current.equals("/") || current.equals("+") || current.equals("-")){
				if(stack.isEmpty() == true){
					if(!current.equals(")")){
						stack.push(current);
						str = stack.display();
						arrayStack[ctr3++] = str;
					}
				}else{
					if(current.equals("+") || current.equals("-")){
						if(previousOperator.equals("+") || previousOperator.equals("-")){
							postfix[ctr2++] = stack.pop();
							str = stack.display();
							arrayStack[ctr3++] = str;
						}else if(previousOperator.equals("*") || previousOperator.equals("/")){
							postfix[ctr2++] = stack.pop();
							str = stack.display();
							arrayStack[ctr3++] = str;
						}
						stack.push(current);
						str = stack.display();
						arrayStack[ctr3++] = str;
					}else if(current.equals("*") || current.equals("/")){
						if(previousOperator.equals("*") || previousOperator.equals("/")){
							postfix[ctr2++] = stack.pop();
							str = stack.display();
							arrayStack[ctr3++] = str;
						}
						stack.push(current);
						str = stack.display();
						arrayStack[ctr3++] = str;
					}
				}
					previousOperator = current;
			}else if(current.equals("(")){
				postfix[ctr2++] = "";
				stack.push(current);
				str = stack.display();
				arrayStack[ctr3++] = str;
				previousOperator = current;
				continue;
			}else if(current.equals(")")){
				postfix[ctr2++] = "";
				while(!stack.isEmpty()){
					String c = stack.pop();
					if(!c.equals("(")){
						postfix[ctr2++] = c;
					}else
						break;
				}
					str = stack.display();
					arrayStack[ctr3++] = str;
				continue;
			}else{
				if(ctr2 != 0){
					postfix[ctr2++] = current;
					arrayStack[ctr3++] = arrayStack[ctr3-2];
				}else{
					postfix[ctr2++] = current;
					arrayStack[ctr3++] = arrayStack[ctr3-1];
				}
			}
		}

		try{
			while(!stack.isEmpty()){
				postfix[ctr2++] = stack.pop();
				str = stack.display();
				arrayStack[ctr3++] = str;
			}
		}catch(Exception e){}

		System.out.println();
		System.out.println("*****Converting Infix to Postfix*****");
		System.out.println();
		System.out.println("READ	STACK		PARSED			WRITTEN");

		for(int j = 0; j < 20; j++){
			if(arrayString[j] != null){
				parsed += arrayString[j] + " ";
				written += postfix[j] + " ";
				System.out.println(arrayString[j] + "	" + arrayStack[j] + "		" + parsed + "			" + written);
			}
		}
		System.out.println();
		System.out.print("Postfix: " + written);
		System.out.println();
		System.out.println();
		evaluation();
	}


	public void evaluation(){
		operand = new Stack(ctr);
		System.out.println();
		System.out.println("*****Evaluating the Postfix*****");
		System.out.println();
		System.out.println("READ	  POP			RESULT					PUSH");
		for(int i = 0; i < ctr; i++){
			if(isNumber(postfix[i])){
				operand.push(postfix[i]);
			}else{

				if(postfix[i].equals("+")){
					op1 = Double.parseDouble(operand.pop());
					op2 = Double.parseDouble(operand.pop());
					answer = op2 + op1;
				}else if(postfix[i].equals("-")){
					op1 = Double.parseDouble(operand.pop());
					op2 = Double.parseDouble(operand.pop());
					answer = op2 - op1;
				}else if(postfix[i].equals("*")){
					op1 = Double.parseDouble(operand.pop());
					op2 = Double.parseDouble(operand.pop());
					answer = op2 * op1;
				}else if(postfix[i].equals("/")){
					op1 = Double.parseDouble(operand.pop());
					op2 = Double.parseDouble(operand.pop());
					answer = op2 / op1;
				}else if(postfix[i].equals("")){
					continue;
				}
				operand.push(String.valueOf(answer));
				System.out.println(postfix[i] + "	" + op1 + " " + op2 + "			" + answer + "				        " + answer);
			}
		}
		System.out.println();
		System.out.println("Answer: " + answer);
	}

	public boolean isNumber(String string){
		try{
			Double.parseDouble(string);
		}catch(Exception ex){
			return false;
		}
		return true;
	}
}
