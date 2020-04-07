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
    
    public void add(String def, String answer){
        String[] holder = {def, answer};
        theCard.add(holder);
    }
    
    public void setDef(int i, String def){
        theCard.get(i)[0] = def;
    }
    
    public String getDef(int i){
        return theCard.get(i)[0];
    }
    
    public void setAnswer(int i, String answer){
        theCard.get(i)[1] = answer;
    }
    
    public String getAnswer(int i){
        return theCard.get(i)[1];
    }
    
    public int size(){
        return theCard.size();
    }
    
    public void shuffle(){
        Collections.shuffle(theCard);
    }
    
    public boolean isEmptyAtPostion(int i){
        if(theCard.size() < i+1){
            return false;
        }else{
            return true;
        }
    }
    
}
