public class Converter extends Thread{

	Stack stack;
	Stack operand;
	String read = "", parsed = "", written = "";
	char previousChar = '\0';
	String previousOperator = "", previousOperator2 = "";

	String[] arrayString = new String[20];
	String evaluateString = new String();
	String[] postfix = new String[20];
	String[] arrayStack = new String[20];
	String[] arrayStack2 = new String[20];
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
	}

	public void run(){

			try{
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

									if(previousOperator2.equals("+") || previousOperator2.equals("-")){
										postfix[ctr2++] = stack.pop();
										str = stack.display();
										arrayStack[ctr3++] = str;
									}

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
							previousOperator2 = previousOperator;
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
						if(current.equals("0") && arrayString[i-1].equals("/")){
							Gui.label.setText("Math Error!");
							break;
						}
						else if(ctr2 != 0){
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

				}catch(Exception e){e.printStackTrace();}
				System.out.println();
				System.out.println("*****Converting Infix to Postfix*****");
				System.out.println();
				System.out.println("READ	STACK		PARSED			WRITTEN");

				for(int j = 0; j < 20; j++){
					if(arrayString[j] != null){
						parsed += arrayString[j] + " ";
						written += postfix[j] + " ";
						System.out.println(arrayString[j] + "	" + arrayStack[j] + "		" + parsed + "			" + written);
						
						
						//Gui.lbel[0][j].setText(arrayString[j]);
						//for(int k = 0; k < arrayStack.length; k++){
							Gui.labelConvert[0][0].setText(arrayString[j]);
							Thread.sleep(500);
							Gui.labelConvert[1][0].setText(parsed);
							Thread.sleep(500);
							Gui.labelConvert[2][0].setText(written);
							Thread.sleep(500);
							Gui.labelConvert[3][0].setText(arrayStack[j]);
							Thread.sleep(500);
							Gui.labelConvert[4][0].setText(arrayStack[j]);
							Thread.sleep(500);
							Gui.labelConvert[5][0].setText(arrayStack[j]);
							Thread.sleep(500);
							Gui.labelConvert[6][0].setText(arrayStack[j]);
							Thread.sleep(500);
						//}
					}
				}
				System.out.println("END" + "	" + stack.display() + "		" + parsed + "			" + written);
				System.out.println();
				System.out.print("Postfix: " + written);
				System.out.println();
				System.out.println();
				evaluation();

		}catch(Exception e){
			e.printStackTrace();
	}
}

	public void evaluation(){
			int counter = 0;
			int counter2 = 0;
			String str2 = "";
			String str3 = "";
			String operation1 = "";
			String operation2 = "";
			
			try{
				operand = new Stack(ctr);
				System.out.println();
				System.out.println("*****Evaluating the Postfix*****");
				System.out.println();
				System.out.println("READ	  POP			RESULT					PUSH");
				for(int i = 0; i < ctr; i++){
					if(isNumber(postfix[i])){
						str2 += postfix[i];
						operand.push(postfix[i]);
						arrayStack2[counter++] = str2;
					}else{

						if(postfix[i].equals("+")){
							op1 = Double.parseDouble(operand.pop());
							//operation1 = "" + op1;
							arrayStack2[counter--] = "";
							// Thread.sleep(500);
							op2 = Double.parseDouble(operand.pop());
							//operation2 = "" + op2;
							arrayStack2[counter--] = "";
							
							str3 = operation1 + " " + postfix[i] + " " + operation2;
							//evaluateString[counter2++] = str3;
							//System.out.println(evaluateString[counter2++]);
							// Thread.sleep(500);
							answer = op2 + op1;
						}else if(postfix[i].equals("-")){
							op1 = Double.parseDouble(operand.pop());
							arrayStack2[counter--] = "";
							//operation1 = "" + op1;
							
							op2 = Double.parseDouble(operand.pop());
							arrayStack2[counter--] = "";
							//operation2 = "" + op2;
							
							//str3 = operation1 + " " + postfix[i] + " " + operation2;
							//evaluateString[counter2++] = str3;
							//System.out.println(evaluateString[counter2++]);
							answer = op2 - op1;
						}else if(postfix[i].equals("*")){
							op1 = Double.parseDouble(operand.pop());
							arrayStack2[counter--] = "";
							//operation1 = "" + op1;
							
							op2 = Double.parseDouble(operand.pop());
							arrayStack2[counter--] = "";
							//operation2 = "" + op2;
							
							//str3 = operation1 + " " + postfix[i] + " " + operation2;
							//evaluateString[counter2++] = str3;
							//System.out.println(evaluateString[counter2++]);
							answer = op2 * op1;
						}else if(postfix[i].equals("/")){
							op1 = Double.parseDouble(operand.pop());
							arrayStack2[counter--] = "";
							//operation1 = "" + op1;
							
							op2 = Double.parseDouble(operand.pop());
							arrayStack2[counter--] = "";
							//operation1 = "" + op1;
							
							//str3 = operation1 + " " + postfix[i] + " " + operation2;
							//evaluateString[counter2++] = str3;
							//System.out.println(evaluateString[counter2++]);
							if(op1 == 0){
								Gui.label.setText("Math Error!");
								break;
							}else{
								answer = op2 / op1;
							}
						}else if(postfix[i].equals("")){
							continue;
						}
						operand.push(String.valueOf(answer));
						str2 += String.valueOf(answer);
						arrayStack2[counter++] = str2;
						evaluateString = op1 + " " + " " + postfix[i] + " " + op2;
						System.out.println(evaluateString);
					}
					System.out.println(postfix[i] + "	" + op1 + " " + op2 + "			" + answer + "				        " + answer);
					Thread.sleep(500);
					Gui.labelEvaluate[0][0].setText(postfix[i]);
					Thread.sleep(500);
					Gui.labelEvaluate[1][0].setText(arrayStack2[i]);
					Thread.sleep(500);
					// }
					Gui.labelEvaluate[2][0].setText(arrayStack2[i]);
					Thread.sleep(500);
					Gui.labelEvaluate[3][0].setText(arrayStack2[i]);
					Thread.sleep(500);
					Gui.labelEvaluate[4][0].setText(arrayStack2[i]);
					Thread.sleep(500);
					Gui.labelEvaluate[5][0].setText(evaluateString);
					Thread.sleep(500);
					Gui.labelEvaluate[6][0].setText(String.valueOf(answer));
					Thread.sleep(500);
				}
				System.out.println();
				System.out.println("Answer: " + answer);
		}catch(Exception e){

		}
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
