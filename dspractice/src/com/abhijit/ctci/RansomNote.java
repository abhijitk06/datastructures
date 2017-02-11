package com.abhijit.ctci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public RansomNote(String magazine, String note) {
       String magazineWords[] =  magazine.split(" ");
       String noteWords[] = note.split( " ");
       magazineMap = new HashMap<String,Integer>();
       for(String dWord: magazineWords){ 
           if(!dWord.trim().isEmpty()){
           if(magazineMap.containsKey(dWord)){
               magazineMap.put(dWord, 1+ (magazineMap.get(dWord)));
           }else{
               magazineMap.put(dWord, 1);
           }
      
           }
        }      
       noteMap = new HashMap<String,Integer>();
               for(String dWord: noteWords){
              if(!dWord.trim().isEmpty()){      
           if(noteMap.containsKey(dWord)){
               noteMap.put(dWord, 1+ (noteMap.get(dWord)));
           }else{
               noteMap.put(dWord, 1);
           }
       }
               }
    }
    
    public boolean solve() {
        for(String note: noteMap.keySet()){
            int numVal = noteMap.get(note);
            int magVal = magazineMap.get(note);
            if( !((magazineMap.containsKey(note)) &&  (magVal >= numVal)) ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
        RansomNote s = new RansomNote("o l x imjaw bee khmla v o v o imjaw l khmla imjaw x", "imjaw l khmla x imjaw o l l o khmla v bee o o imjaw imjaw o");
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
