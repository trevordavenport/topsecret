import java.util.*;


public class Proof {
	
LineNumber lastLineNumber;
LinkedList myLinkedList;
TheoremSet mytheorems;

private HashMap<LineNumber, LinkedList> myLineNumbers = new HashMap<LineNumber, LinkedList>();

public Proof (TheoremSet theorems) {
	mytheorems = theorems;
}

public LineNumber nextLineNumber ( ) {
	LineNumber valueholder = nextline_helper(myLineNumbers.get(lastLineNumber).getFirst(), myLineNumbers.get(lastLineNumber).getLast());
	lastLineNumber = valueholder;
	return valueholder;
}

public void extendProof (String x) throws IllegalLineException, IllegalInferenceException {
	//add the parsed expression to the hashmap at the key of "lastLineNumber"
	try{
		inputstringparser(x);
	}catch (IllegalLineException e){
		System.err.println(e.getMessage());
	}catch (IllegalInferenceException a){
		System.err.println(a.getMessage());
	}
	myLineNumbers.put(lastLineNumber, myLinkedList);
}

public String toString ( ) {
	return "";
}

public boolean isComplete ( ) {
	return true;
}
public LinkedList inputstringparser(String x) throws IllegalLineException, IllegalInferenceException{
	
	//Might not need this. Attempt to prevent person from inputting an empty line.
	if(x == null){
		throw new IllegalLineException("You must input something.");
	}
	
	String[] myValues = x.split("\\s"); //Splits the input string based on white space.
	
	//Test if the user entered too many inputs for a single line.
	if (myValues.length > 4){
		throw new IllegalLineException("Too many arguments inputted. Max possible is 4.");
	}
	
	for (int i = 0; i < myValues.length; i++){ //Adds each element of the split up input string 
		myLinkedList.add(myValues[i]);         //into a LinkedList in sequential order. 
	}										   //ex. "assume (a=>b)" is put in as "assume", "(a=>b)"
	
	String Expr = (String)myLinkedList.getLast(); //The string representation of the expression in the Linked List.
	String test = (String)myLinkedList.getFirst(); //The string representation of the operator.
	
	//Test checking if the first argument of the input line is anything other than an approved operator.
	//If it is not approved, then it throws an illegal line operator. 
	if (test != "show" || test != "assume" || test != "repeat" || test != "print"  
			|| test != "mc" || test != "ic" || test != "mt" || test != "co" || !mytheorems.myThms.containsKey(test)){
		throw new IllegalLineException("Invalid operator.");
	}
	
	//Test if wrong number of arguments are entered for show, assume, or a theorem.
	if ((test == "show" || test == "assume" || mytheorems.myThms.containsKey(test)) && myLinkedList.size() != 2){
	throw new IllegalLineException("Wrong number of arguments supplied for " + test + "statement.");
	}
	
	//Test if wrong number of arguments are entered for repeat, mc, mt, or co.
	if ((test == "repeat" || test == "mc" || test == "mt" || test == "co") && myLinkedList.size() != 4){
		throw new IllegalLineException("Wrong number of argument for " + test + "statement.");
	}
	
	
	if (test == "print" && myLinkedList.size() != 1){
		throw new IllegalLineException("Wrong number of arguments for " + test + "statement.");
	}
	
	try{	
		Expression newExpr = new Expression(Expr);
	}catch(IllegalLineException e){
		throw e;
	}
	return myLinkedList;
	}
		
}

