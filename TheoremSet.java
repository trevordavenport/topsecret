import java.util.*;


public class TheoremSet {

	HashMap<String, Expression> myThms;

	public TheoremSet ( ) {
		myThms = new HashMap<String, Expression>();
	}

	public Expression put (String s, Expression e) {

		//Sets the value at Key(s) in myThems to Expression(e) 
		//and returns the old value at S or null if empty.
		return myThms.put(s,e);
	}
}
