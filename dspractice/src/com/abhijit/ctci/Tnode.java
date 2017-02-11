package com.abhijit.ctci;

import java.util.HashMap;
import java.util.Map;

public class Tnode {
	boolean isCompleteWord;
	Map<Character,Tnode> childrens = new HashMap<Character,Tnode>();
	String completeWord;	
}
