/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagmentfinal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author cloak
 */
public class Card {
    private ArrayList<String[]> theCard = new ArrayList();

    public Card() {
    }
    
    public void add(String def, String anwser){
        String[] holder = {def, anwser};
        theCard.add(holder);
    }
    
    public String getDef(int i){
        return theCard.get(i)[0];
    }
    
    public String getAnwser(int i){
        return theCard.get(i)[1];
    }
    
    public int size(){
        return theCard.size();
    }
    
    public void shuffle(){
        Collections.shuffle(theCard);
    }
    
}
