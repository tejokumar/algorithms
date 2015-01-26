package com.tejo;

import java.io.IOException;
import java.util.Stack;


public class InfixToPostFix {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		String input = "";
		while(true){
			input = MyUtils.getString();
			if("".equals(input))
				break;
			InToPost i2p = new InToPost(input);
			System.out.println(i2p.doTrans());
		}
				
		

	}
	
	
}

class InToPost{
	private String input;
	private String output;
	private Stack<String> operatorStack;
	
	public InToPost(String theInput){
		this.input = theInput;
		this.operatorStack = new Stack<String>();
		this.output = "";
	}
	
	public String doTrans(){
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '+':
			case '-':
				gotOperator(ch, 1);
				break;
			case '*':
			case '/':
				gotOperator(ch, 2);
				break;
			case '(':
				operatorStack.push(ch+"");
				break;
			case ')':
				gotCloseParen();
				break;
			default:
				output = output + ch;
			}			
		}
		while(!operatorStack.isEmpty())
			output = output + operatorStack.pop();
		return output;
	}
	
	public void gotOperator(char opThis,int prec1){
		while(!operatorStack.isEmpty()){
			String opTop = operatorStack.pop();
			if(opTop.equals("(")){
				operatorStack.push(opTop);
				break;
			}else{
				int prec2;
				if(opTop.equals("+") || opTop.equals("-"))
					prec2 = 1;
				else
					prec2 = 2;
				if(prec2<prec1){
					operatorStack.push(opTop);
					break;
				}else
					output = output + opTop;
			}
		}
		operatorStack.push(opThis+"");
	}
	
	public void gotCloseParen(){
		while(!operatorStack.isEmpty()){
			String opx = operatorStack.pop();
			if("(".equals(opx))
				break;
			else
				output = output + opx;
		}
	}
}
