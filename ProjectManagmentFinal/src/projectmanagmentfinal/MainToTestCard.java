/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagmentfinal;

import java.util.Collections;

/**
 *
 * @author cloak
 */
public class MainToTestCard {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Card card = new Card();
        card.add("def1", "def1");
        card.add("def2","def2");
        card.add("def3", "def3");
        
        for(int i =0; i<card.size(); i++){
            System.out.println(card.getDef(i));
            System.out.println(card.getAnwser(i));
        }
        System.out.println("");
        
        card.shuffle();
        
        for(int i =0; i<card.size(); i++){
            System.out.println(card.getDef(i));
            System.out.println(card.getAnwser(i));
        }
        
    }
    
}
