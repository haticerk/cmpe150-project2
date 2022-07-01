package cmpe150project2;

import java.util.Scanner;

public class project2 {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		String firstLine = input.nextLine();
		//I took the first line
		Scanner newFl =new Scanner(lines(firstLine));
		//to get name and value more easily, � changed to scanner
		String name1 = newFl.next();
		//name1 is the name of my first variable
		//because � didn't mention before,program don't know that is this an integer or a double.So � used to containing '.'
		int ilines1 = -1;
		double dlines1 = -1;
		// because � don't know which one will occur, � gave some values and then � will use which one changed
		if(newFl.hasNextInt()){
			ilines1 = newFl.nextInt();
		}if(newFl.hasNext()){
			String e = newFl.next();
			dlines1 = Double.parseDouble(e);
		}  
		
		String secondLine = input.nextLine();
		//I took the second line
		Scanner newSl =new Scanner(lines(secondLine));
		String name2 = newSl.next();
		int ilines2 = -1;
		double dlines2 = -1;
		if(newSl.hasNextInt()){
			ilines2 = newSl.nextInt();
		}else{
			String e = newSl.next();
			dlines2 = Double.parseDouble(e);
		}
		// program works same as what � did first line 
		String thirdLine = input.nextLine();
		//� took the third line 
		Scanner newTl =new Scanner(lines(thirdLine));
		String name3 = newTl.next();
		int ilines3 = -1;
		double dlines3 = -1;
		if(newTl.hasNextInt()){
			ilines3 = newTl.nextInt();
		}else{
			String e = newTl.next();
			dlines3 = Double.parseDouble(e);
		}
		//again, program works same as what � did first line 
		String lastLine = input.nextLine();
		lastLine.toLowerCase();
		//because � take names of variables in lower case, � did my last line in lower case
		//now � replace the name of variable with the value of variable 
		while(lastLine.contains(name1)){
			String s1 = name1.substring(0,1);
			int i1 = lastLine.indexOf(s1);
			int i2 = i1 + name1.length()-1;
			//this part is necessary to understand if my variable is integer or double
			if(ilines1!=-1){
				lastLine = lastLine.substring(0,i1) + ilines1 + lastLine.substring(i2+1);
			}if(dlines1!=-1){
				lastLine = lastLine.substring(0,i1) + dlines1 + lastLine.substring(i2+1);
			}
		}while(lastLine.contains(name2)){
			String s1 = name2.substring(0,1);
			int i1 = lastLine.indexOf(s1);
			int i2 = i1 + name2.length()-1;
			if(ilines2!=-1){
				lastLine = lastLine.substring(0,i1) + ilines2 + lastLine.substring(i2+1);
			}if(dlines2!=-1){
				lastLine = lastLine.substring(0,i1) + dlines2 + lastLine.substring(i2+1);
			}
		}while(lastLine.contains(name3)){
			String s1 = name3.substring(0,1);
			int i1 = lastLine.indexOf(s1);
			int i2 = i1 + name3.length() -1 ;
			if(ilines3!=-1){
				lastLine = lastLine.substring(0,i1) + ilines3 + lastLine.substring(i2+1);
			}if(dlines3!=-1){
				lastLine = lastLine.substring(0,i1) + dlines3 + lastLine.substring(i2+1);
			}
		}
		while(lastLine.contains(" ")){
			int space = lastLine.indexOf(" ");
			lastLine = lastLine.substring(0,space) + lastLine.substring(space+1);
		}
		//again, � get rid of spaces to work more easily
		lastLine = lastLine.substring(0,lastLine.length()-1);
		//and � get rid of ';'
		//in this part � aim to work with the parenthesis
		while(lastLine.contains(")")){
			int iparantesis = lastLine.indexOf(")");
			//to work more easily,  � used the index of ')'
			String forward = lastLine.substring(iparantesis+1);
			//to save the rest of line  
			int max=0;
			for(int a=0;a<lastLine.substring(0,lastLine.indexOf(")")).length();a++){
				char c = lastLine.charAt(a);
				if(c=='('){
					max= a;
				}	
			}
			//to get the first '(' before the ')'
			
			String back = lastLine.substring(0,max);
			//to save the beginning of line
			String newLine = lastLine.substring(max+1,iparantesis);
			//now the variable newLine equals to operation which � need to do
			lastLine = back + cal2(calculation(newLine))+ forward ;
			//this cal2(calculation) will do my operation with operator precedence 
			//and now lastLine equals to line without this parenthesis
		}
		String finalresult = cal2(calculation(lastLine));
		System.out.println(finalresult);
		//and the result 
	}
// my first method do multiplication and division
	public static String calculation(String newLine){
		// first,� controlled if the line contains '*' or '/' or both of them 
		while(newLine.contains("*") && newLine.contains("/")){
			//when the line contains both of them, � looked which one occurs first
			int carpi = newLine.indexOf("*");
			int bolu = newLine.indexOf("/");
			int operation =0;
			if(carpi<bolu){
				operation = carpi;
			}else{
				operation = bolu;
			}
		// � described a double and an integer to each of my number which will be used because � dont know if it is an integer or not 
			double d1 = -1, d2 = -1;
			int i1 = -1, i2 = -1; 
			
			if(say�Alt(newLine,operation).contains(".")){
				d1 = Double.parseDouble(say�Alt(newLine,operation));
			}else{
				i1 = Integer.parseInt(say�Alt(newLine,operation));
			}
			
			if(say�Ust(newLine,operation).contains(".")){
				d2 = Double.parseDouble(say�Ust(newLine,operation));
			}else{
				i2 = Integer.parseInt(say�Ust(newLine,operation));
			}
	// and again � described a double and an integer to my result because � dont know what my result is  
			int resulti = -1;
			double resultd = -1;
	//then � did operation 		
			if(operation == carpi){
				if(!(i1==-1)){
					if(!(i2==-1)){
						resulti = i1*i2;
					}else{
						resultd = i1*d2;
					}
				}else{
					if(!(i2==-1)){
						resultd = d1*i2;
					}else{
						resultd = d1*d2;
					}
				}	
			}else{
				if(!(i1==-1)){
					if(!(i2==-1)){
						resulti = i1/i2;
					}else{
						resultd = i1/d2;
					}
				}else{
					if(!(i2==-1)){
						resultd = d1/i2;
					}else{
						resultd = d1/d2;
					}
				}
			}
	// finally � replaced the operation with my result 		
			if(!(resultd==-1)){
				newLine = newLine.substring(0,s�n�rAlt(newLine,operation)) + resultd + newLine.substring(s�n�rUst(newLine,operation));
			}if(!(resulti ==-1)){
				newLine = newLine.substring(0,s�n�rAlt(newLine,operation)) + resulti + newLine.substring(s�n�rUst(newLine,operation));
			}
		}
	//the content is same as the upper one, this part is only the lines which contains only multiplication 	
		while(newLine.contains("*") && !(newLine.contains("/"))){	
			int operation = newLine.indexOf("*");
			
			double d1 = -1, d2 = -1;
			int i1 = -1, i2 = -1; 
			if(say�Alt(newLine,operation).contains(".")){
				d1 = Double.parseDouble(say�Alt(newLine,operation));
			}else{
				i1 = Integer.parseInt(say�Alt(newLine,operation));
			}
			if(say�Ust(newLine,operation).contains(".")){
				d2 = Double.parseDouble(say�Ust(newLine,operation));
			}else{
				i2 = Integer.parseInt(say�Ust(newLine,operation));
			}
			
			int resulti = -1;
			double resultd = -1;
			if(!(i1==-1)){
				if(!(i2==-1)){
					resulti = i1*i2;
				}else{
					resultd = i1*d2;
				}
			}else{
				if(!(i2==-1)){
					resultd = d1*i2;
				}else{
					resultd = d1*d2;
				}
			}
			if(!(resultd==-1)){
					newLine = newLine.substring(0,s�n�rAlt(newLine,operation)) + resultd + newLine.substring(s�n�rUst(newLine,operation));
			}if(!(resulti ==-1)){
					newLine = newLine.substring(0,s�n�rAlt(newLine,operation)) + resulti + newLine.substring(s�n�rUst(newLine,operation));
			}
		}
	//the content is same as the upper one, this part is only the lines which contains only division	
		while(newLine.contains("/") && !(newLine.contains("*"))){
			int operation = newLine.indexOf("/");
			
			double d1 = -1, d2 = -1;
			int i1 = -1, i2 = -1; 
			if(say�Alt(newLine,operation).contains(".")){
				d1 = Double.parseDouble(say�Alt(newLine,operation));
			}else{
				i1 = Integer.parseInt(say�Alt(newLine,operation));
			}
			if(say�Ust(newLine,operation).contains(".")){
				d2 = Double.parseDouble(say�Ust(newLine,operation));
			}else{
				i2 = Integer.parseInt(say�Ust(newLine,operation));
			}
			
			int resulti = -1;
			double resultd = -1;
			if(!(i1==-1)){
				if(!(i2==-1)){
					resulti = i1/i2;
				}else{
					resultd = i1/d2;
				}
			}else{
				if(!(i2==-1)){
					resultd = d1/i2;
				}else{
					resultd = d1/d2;
			
				}
			}
			
			if(!(resultd==-1)){
					newLine = newLine.substring(0,s�n�rAlt(newLine,operation)) + resultd + newLine.substring(s�n�rUst(newLine,operation));
			}if(!(resulti ==-1)){
					newLine = newLine.substring(0,s�n�rAlt(newLine,operation)) + resulti + newLine.substring(s�n�rUst(newLine,operation));
			}
			
		}
		// and this method returns a line without any multiplication and division operation
		return newLine;
		
	}
	// my other calculation method is cal2. this method does addition and subtraction 
	public static String cal2(String line){
	// first � controlled that the line contains '+' or '-' or both of them	
		while(line.contains("+")&&line.contains("-")){
		// in this part, � calculated the line which contains both '+' and'-' 
			// � looked which one occurs first
			int plus = line.indexOf("+");
			int minus = line.indexOf("-");
			int operation =0;
			if(plus<minus){
				operation = plus;
			}else{
				operation = minus;
			}
			// � described a double and an integer to each of my number which will be used because � dont know if it is an integer or not 
			double d1 = -1, d2 = -1;
			int i1 = -1, i2 = -1; 
			
			if(say�Alt(line,operation).contains(".")){
				d1 = Double.parseDouble(say�Alt(line,operation));
			}else{
				i1 = Integer.parseInt(say�Alt(line,operation));
			}
			if(say�Ust(line,operation).contains(".")){
				d2 = Double.parseDouble(say�Ust(line,operation));
			}else{
				i2 = Integer.parseInt(say�Ust(line,operation));
			}
			// � described a double and an integer to my result because � dont know if it is an integer or not 
			int resulti = -1;
			double resultd = -1;
			if(operation == plus){
				if(!(i1==-1)){
					if(!(i2==-1)){
						resulti = i1+i2;
					}else{
						resultd = i1+d2;
					}
				}else{
					if(!(i2==-1)){
						resultd = d1+i2;
					}else{
						resultd = d1+d2;
					}
				}	
			}else{
				if(!(i1==-1)){
					if(!(i2==-1)){
						resulti = i1-i2;
					}else{
						resultd = i1-d2;
					}
				}else{
					if(!(i2==-1)){
						resultd = d1-i2;
					}else{
						resultd = d1-d2;
					}
				}
			}
			// finally � replaced the operation with my result 	
			if(!(resultd==-1)){
				line = line.substring(0,s�n�rAlt(line,operation)) + resultd + line.substring(s�n�rUst(line,operation));
			}if(!(resulti ==-1)){
				line = line.substring(0,s�n�rAlt(line,operation)) + resulti + line.substring(s�n�rUst(line,operation));
			}
		}
		while(line.contains("+")&&!(line.contains("-"))){
			//the content is same as the upper one, this part is only the lines which contains only addition		
			int operation = line.indexOf("+");
			
			double d1 = -1;
			double d2 = -1;
			int i1 = -1;
			int i2 = -1; 
			
			if(say�Alt(line,operation).contains(".")){
				d1 = Double.parseDouble(say�Alt(line,operation));
			}else{
				i1 = Integer.parseInt(say�Alt(line,operation));
			}
			
			if(say�Ust(line,operation).contains(".")){
				d2 = Double.parseDouble(say�Ust(line,operation));
			}else{
				i2 = Integer.parseInt(say�Ust(line,operation));
			}
			
			int resulti = -1;
			double resultd = -1;
			if(!(i1==-1)){
				if(!(i2==-1)){
					resulti = i1+i2;
				}else{
					resultd = i1+d2;
				}
			}else{
				if(i2==-1){
					resultd = d1+d2;
				}else{
					resultd = d1+i2;
				}
			}
			if(!(resultd==-1)){
				line = line.substring(0,s�n�rAlt(line,operation)) + resultd + line.substring(s�n�rUst(line,operation));
			}if(!(resulti == -1 )){
				line = line.substring(0,s�n�rAlt(line,operation)) + resulti + line.substring(s�n�rUst(line,operation));
			}	
			
		}	
		while(line.contains("-")&&!(line.contains("+"))){
			//the content is same as the upper one, this part is only the lines which contains only subtraction	
			int operation = line.indexOf("-");
			
			double d1 = -1, d2 = -1;
			int i1 = -1, i2 = -1; 
			if(say�Alt(line,operation).contains(".")){
				d1 = Double.parseDouble(say�Alt(line,operation));
			}else{
				i1 = Integer.parseInt(say�Alt(line,operation));
			}
			if(say�Ust(line,operation).contains(".")){
				d2 = Double.parseDouble(say�Ust(line,operation));
			}else{
				i2 = Integer.parseInt(say�Ust(line,operation));
			}
			
			int resulti = -1;
			double resultd = -1;
			
			if(!(i1==-1)){
				if(!(i2==-1)){
					resulti = i1-i2;
				}else{
					resultd = i1-d2;
				}
			}else{
				if(!(i2==-1)){
					resultd=d1-i2;
				}else{
					resultd = d1-d2;
				}
			}
			if(!(resultd==-1)){
				line = line.substring(0,s�n�rAlt(line,operation)) + resultd + line.substring(s�n�rUst(line,operation));
			}if(!(resulti ==-1)){
				line = line.substring(0,s�n�rAlt(line,operation)) + resulti + line.substring(s�n�rUst(line,operation));
			}	
		}	
		// and finally it returns only a number  
		return line;
	}
	// � used this method to find the number which comes just before the operator 
	public static String say�Alt(String line, int operation){
		line = line.substring(0,operation);
		// � used the variable helpingline to find last operator just before the number 
		String helpingline = line;
		int plus = 0;
		int minus = 0; 
		int first = 0;
		// � controlled if it contains '+' or '-'. � didnt control '*' or '/' because my code will done this operations 
		if(line.contains("+")||line.contains("-")){
			while(helpingline.contains("+")){
				plus = plus + helpingline.indexOf("+")+1;
				int anotherplus = helpingline.indexOf("+");
				helpingline = helpingline.substring(anotherplus+1);
			}while(helpingline.contains("-")){
				minus = minus+ helpingline.indexOf("-")+1;
				int anotherminus = helpingline.indexOf("-");
				helpingline = helpingline.substring(anotherminus+1);
			}
			if(plus<minus){
				first = minus;
			}else{
				first = plus;
		    }
		} 
		line = line.substring(first);
		//there line equals to number 
		return line;	
	}
	//// � used this method to find the number which comes just after the operator
	public static String say�Ust(String line, int operation){
		line = line.substring(operation+1);
		int plus = 10000000;
		int minus = 10000000;
		int carpi = 10000000;
		int bolu = 10000000;
		int last = line.length();
		// now � need to control '*' and '/' because there might be 
		if(line.contains("+")||line.contains("-")||line.contains("*")||line.contains("/")){
			if(line.contains("*")){
				carpi = line.indexOf("*");
			}if(line.contains("/")){
				bolu = line.indexOf("/");
			}if(line.contains("+")){
				plus = line.indexOf("+");
			}if(line.contains("-")){
				minus = line.indexOf("-");
			}
			int last1;
		    if(plus<minus){
		    	last1 = plus;
		    }else{
		    	last1= minus;
		    }
		    int last2;
		    if(carpi<bolu){
		    	last2 = carpi;
		    }else{
		    	last2 = bolu;
		    }
		    if(last1<last2){
		    	last=last1;
		    }else{
		    	last=last2;
		    }
		} 
		line = line.substring(0,last);
		//line equals to a number 
		return line;
	}
	// � used this methods to find where my operation ends 
	// s�n�rAlt gives me the lower one
	public static int s�n�rAlt(String line, int operation){
		line = line.substring(0,operation);
		String helpingline = line;
		int plus = 0;
		int minus = 0; 
		int first = 0;
		if(line.contains("+")||line.contains("-")){
			while(helpingline.contains("+")){
				plus = plus + helpingline.indexOf("+")+1;
				int anotherplus = helpingline.indexOf("+");
				helpingline = helpingline.substring(anotherplus+1);
			}while(helpingline.contains("-")){
				minus = minus + helpingline.indexOf("-")+1;
				int anotherminus = helpingline.indexOf("-");
				helpingline = helpingline.substring(anotherminus+1);
			}
			if(plus<minus){
				first = minus;
			}else{
				first = plus ;
			}
		} 
		return first;
		
	}
	// s�sn�rUst gives me the upper one 
	public static int s�n�rUst(String line,int operation){
		int a = operation + 1;
		line = line.substring(operation+1);
		int plus = 10000000;
		int minus = 10000000;
		int carpi = 10000000;
		int bolu = 10000000;
		int last = line.length();
		if(line.contains("+")||line.contains("-")||line.contains("*")||line.contains("/")){
			if(line.contains("+")){
				plus = line.indexOf("+");
			}if(line.contains("-")){
				minus = line.indexOf("-");
			}if(line.contains("*")){
				carpi= line.indexOf("*");
			}if(line.contains("/")){
				bolu= line.indexOf("/");
			}
			int last1;
		    if(plus<minus){
		    	last1 = plus;
		    }else{
		    	last1= minus;
		    }
		    int last2;
		    if(carpi<bolu){
		    	last2 = carpi;
		    }else{
		    	last2 = bolu;
		    }
		    if(last1<last2){
		    	last=last1;
		    }else{
		    	last=last2;
		    }
		} 
		return last+a;
	}	
	//This method helps me to take the name and the value of my variable without any character like '=' or ';'.
	public static String lines(String line){
		line.toLowerCase();
		while(line.contains(" ")){
			int space = line.indexOf(" ");
			line = line.substring(0,space) + line.substring(space+1);
		}
		//� did this to ease my job
		String name = "";//the variable "name" will give me the name of my variable 
		String number = "";//the variable "number" will give me the value of my variable
		
		if(line.startsWith("i")){
			line = line.substring(line.indexOf("t")+1);
			name = name + line.substring(0,line.indexOf("="));
			number = number + line.substring(line.indexOf("=")+1,line.indexOf(";"));
		}if(line.startsWith("d")){
			line = line.substring(line.indexOf("e")+1);
			name = name + line.substring(0,line.indexOf("="));
			number = number + line.substring(line.indexOf("=")+1,line.indexOf(";"));
			if(!(number.contains("."))){
				number = number + ".0";
			}// because the value of a double might be '2' or like this, I need to be sure that it will be perceived like a double
		}
		String end = name + " " + number;
		//now � have only the name and the value;
		return end;
	}
}
