/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagmentfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cloak
 */
public class FlashCardGUI extends javax.swing.JFrame {

    /**
     * Creates new form FlashCardGUI
     */
    public FlashCardGUI() {
        initComponents();
        makeDummyCards();
        this.CardLabel.setLineWrap(true);
        this.CardLabel.setWrapStyleWord(true);
        updateCard(this.card);
        LoadCardsNameToComboBox();
    }
    
    private void centering(){
        
    }
    
    public void makeDummyCards(){
        for(int i=0; i < 20; i++){
            card.add(("definition"+i),("Awnser"+i));
        }
    }
    
    public void updateCard(Card card){
        if(flippy == -1 && !creatingCards){
            CardLabel.setText(card.getDef(position));
        }else if(flippy == 1 && !creatingCards){
            CardLabel.setText(card.getAnswer(position));
            
        }else if(flippy == -1 && creatingCards && card.isEmptyAtPostion(position)){
            CardLabel.setText(card.getDef(position));
        }else if(flippy == 1 && creatingCards && card.isEmptyAtPostion(position)){
            CardLabel.setText(card.getAnswer(position));
            
        }else if(flippy == -1 && creatingCards){
            CardLabel.setText("Def");
        }else if(flippy == 1 && creatingCards){
            CardLabel.setText("Answer");
        }
    }
    
    public void saveCard(){
        if(!this.creatorCard.isEmptyAtPostion(position)){
            creatorCard.add("Def","Answer");
            if(flippy == -1){
                creatorCard.setDef(position, this.CardLabel.getText());
            }else if(flippy == 1){
                creatorCard.setAnswer(position, this.CardLabel.getText());
            }
        }else if(this.creatorCard.isEmptyAtPostion(position)){
            if(flippy == -1){
                creatorCard.setDef(position, this.CardLabel.getText());
            }else if(flippy == 1){
                creatorCard.setAnswer(position, this.CardLabel.getText());
            }
        }
    }
    
    public void populateWrongCards(ArrayList<Integer> positionsWrong){
        Card tempCard = new Card();
        for(int i = 0; i < positionsWrong.size(); i++){
            tempCard.add(this.card.getDef(positionsWrong.get(i)), 
                    this.card.getAnswer(positionsWrong.get(i)));
        }
        this.card = tempCard;//advoid having to change more setting
        updateCard(this.card);
    }
    

    File file = new File("cards.txt");
    FileWriter fw;
    PrintWriter pw;
    Scanner scan;
    String line;
    String splitLine[];
    //loads cards from external file
    public void loadCards(String cardWanted){
        try{
            scan = new Scanner(file);
            
            this.card = new Card();//resets the card
            
            while(scan.hasNextLine()){
                line = scan.nextLine();
                splitLine = line.split("@#");
                if(splitLine[0].equals(cardWanted)){
                    System.out.println(line);
                    for(int i = 1; i < splitLine.length; i+=2){
                        this.card.add(splitLine[i], splitLine[i+1]);
                    }
                }
            }
        }catch(Exception ex){
        }
    }
    
    //loads options from the file
    public void LoadCardsNameToComboBox(){
        FlashCardComboBox.removeAllItems();
        FlashCardComboBox.addItem("Flash Cards");
        try {
            scan = new Scanner(file);
            while(scan.hasNextLine()){
                line = scan.nextLine();
                splitLine = line.split("@#");
                this.FlashCardComboBox.addItem(splitLine[0]);
            }
            scan.close();
        } catch (FileNotFoundException ex) {
        }
    }
    
    
    public void writeToFile(Card card, String name){
        line = name;
        for(int i = 0; i < card.size(); i++){
            line += "@#"+card.getDef(i);
            line += "@#"+card.getAnswer(i);
        }
        
        try { 
            fw = new FileWriter(file, true);
            pw = new PrintWriter(fw);
            
            pw.println(line);
            pw.close();
        } catch (IOException ex) {
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CardPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CardLabel = new javax.swing.JTextArea();
        NextButton = new javax.swing.JButton();
        PervButton = new javax.swing.JButton();
        FlipButton = new javax.swing.JButton();
        CreateButton = new javax.swing.JButton();
        LoadButton = new javax.swing.JButton();
        FlashCardComboBox = new javax.swing.JComboBox<>();
        ShuffleButton = new javax.swing.JButton();
        DoneButton = new javax.swing.JButton();
        wrongButton = new javax.swing.JButton();
        revisitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        CardPanel.setBackground(new java.awt.Color(255, 255, 255));
        CardPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CardPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CardPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CardPanelMouseClicked(evt);
            }
        });

        jScrollPane2.setBorder(null);

        CardLabel.setEditable(false);
        CardLabel.setColumns(20);
        CardLabel.setRows(5);
        CardLabel.setPreferredSize(new java.awt.Dimension(482, 232));
        CardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CardLabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CardLabel);

        javax.swing.GroupLayout CardPanelLayout = new javax.swing.GroupLayout(CardPanel);
        CardPanel.setLayout(CardPanelLayout);
        CardPanelLayout.setHorizontalGroup(
            CardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );
        CardPanelLayout.setVerticalGroup(
            CardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        NextButton.setText("Next");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        PervButton.setText("Pervous");
        PervButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PervButtonActionPerformed(evt);
            }
        });

        FlipButton.setText("Flip");
        FlipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FlipButtonActionPerformed(evt);
            }
        });

        CreateButton.setText("Create New Study Deck");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        LoadButton.setText("Load Study Deck");
        LoadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadButtonActionPerformed(evt);
            }
        });

        FlashCardComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fake Cards" }));

        ShuffleButton.setText("Shuffle");
        ShuffleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShuffleButtonActionPerformed(evt);
            }
        });

        DoneButton.setText("Done");
        DoneButton.setEnabled(false);
        DoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneButtonActionPerformed(evt);
            }
        });

        wrongButton.setText("Wrong");
        wrongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wrongButtonActionPerformed(evt);
            }
        });

        revisitButton.setText("Visit Wrong");
        revisitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revisitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PervButton)
                        .addGap(18, 18, 18)
                        .addComponent(CardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NextButton, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(FlashCardComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CreateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LoadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DoneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ShuffleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wrongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(revisitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(FlipButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(CardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PervButton)
                            .addComponent(NextButton))
                        .addGap(142, 142, 142)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FlipButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wrongButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(revisitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CreateButton)
                            .addComponent(LoadButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(FlashCardComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DoneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ShuffleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        // TODO add your handling code here:
        if(creatingCards){
            saveCard();
            position++;
            if(flippy == 1){
                flippy*=-1;//makes sure you end on up the definition
            }
            updateCard(this.creatorCard);
        }else if(position < card.size()-1){
            position++;
            if(flippy == 1){
                flippy*=-1;//makes sure you end on up the definition
            }
            updateCard(this.card);
        }
        //this.ShuffleButton.setVisible(false); //used to test for a button later
    }//GEN-LAST:event_NextButtonActionPerformed

    private void PervButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PervButtonActionPerformed
        // TODO add your handling code here:
        if(position > 0 && creatingCards){
            saveCard();
            position--;
            if(flippy == 1){
                flippy*=-1;//makes sure you end on up the definition
            }
            updateCard(this.creatorCard);
        }else if(position > 0){
            position--;
            if(flippy == 1){
                flippy*=-1;//makes sure you end on up the definition
            }
            updateCard(this.card);
        }
    }//GEN-LAST:event_PervButtonActionPerformed

    private void FlipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FlipButtonActionPerformed
        // TODO add your handling code here:
        if (!creatingCards) {
            flippy *= -1;  //multiply by -1 to switch sign
            updateCard(this.card);
        }else if(creatingCards){
            saveCard();
            flippy*=-1;  //multiply by -1 to switch sign
            updateCard(this.creatorCard);
        }
    }//GEN-LAST:event_FlipButtonActionPerformed

    private void CardPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CardPanelMouseClicked
        // TODO add your handling code here:
        if (!creatingCards) {
            flippy *= -1;  //multiply by -1 to switch sign
            updateCard(this.card);
        }
    }//GEN-LAST:event_CardPanelMouseClicked

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        // TODO add your handling code here:
        creatingCards = true;
        JOptionPane.showMessageDialog(null, "While creating cards you have to use the flip button.");
        position = 0;
        flippy = -1;
        updateCard(this.creatorCard);
        this.CardLabel.setEditable(true);
        if(this.FlashCardComboBox.getItemCount() == 1){
            this.FlashCardComboBox.addItem("User Created Cards");
        }
        this.DoneButton.setEnabled(true);
        this.wrongButton.setEnabled(false);
        this.revisitButton.setEnabled(false);
        wrongCards.clear();
    }//GEN-LAST:event_CreateButtonActionPerformed

    private void DoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButtonActionPerformed
        // TODO add your handling code here:
        saveCard();
        creatingCards = false;
        String name = JOptionPane.showInputDialog("Enter Cards Name\n leave blank to cancel","");
        position = 0;
        flippy = -1;
        updateCard(this.card);
        this.CardLabel.setEditable(false);
        this.DoneButton.setEnabled(false);
        
        if(name.equals("")){
        }else{
            writeToFile(creatorCard, name);
        }
        
        LoadCardsNameToComboBox();
        
        this.wrongButton.setEnabled(true);
        this.revisitButton.setEnabled(true);
        wrongCards.clear();
    }//GEN-LAST:event_DoneButtonActionPerformed

    private void LoadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadButtonActionPerformed
        // TODO add your handling code here:
        if(this.FlashCardComboBox.getSelectedIndex() == 0){
            this.card = new Card();//clears old 
            makeDummyCards();
        }else if(this.FlashCardComboBox.getSelectedIndex() >= 1){
            loadCards(FlashCardComboBox.getItemAt(FlashCardComboBox.getSelectedIndex()));
        }
        position = 0;
        flippy = -1;
        updateCard(this.card);
        wrongCards.clear();
    }//GEN-LAST:event_LoadButtonActionPerformed

    private void ShuffleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShuffleButtonActionPerformed
        // TODO add your handling code here:
        position = 0;
        flippy = -1;
        this.card.shuffle();
        updateCard(this.card);
        wrongCards.clear();
    }//GEN-LAST:event_ShuffleButtonActionPerformed

    private void CardLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CardLabelMouseClicked
        // TODO add your handling code here:
        if (!creatingCards) {
            flippy *= -1;  //multiply by -1 to switch sign
            updateCard(this.card);
        }
    }//GEN-LAST:event_CardLabelMouseClicked

    private void wrongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wrongButtonActionPerformed
        // TODO add your handling code here:
        wrongCards.add(position);
    }//GEN-LAST:event_wrongButtonActionPerformed

    private void revisitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revisitButtonActionPerformed
        // TODO add your handling code here:
        if (wrongCards.size() > 0) {
            position = 0;
            flippy = -1;
            populateWrongCards(wrongCards);
            wrongCards.clear();//clears to be reused
        }
    }//GEN-LAST:event_revisitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FlashCardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlashCardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlashCardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlashCardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlashCardGUI().setVisible(true);
            }
        });
    }
    
    
    
    //custom Variables
    private ArrayList<Integer> wrongCards = new ArrayList<Integer>();
    private Card card = new Card();
    private Card creatorCard = new Card();//used to holded players entry 
    private boolean creatingCards = false;
    private int flippy = -1, position = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CardLabel;
    private javax.swing.JPanel CardPanel;
    private javax.swing.JButton CreateButton;
    private javax.swing.JButton DoneButton;
    private javax.swing.JComboBox<String> FlashCardComboBox;
    private javax.swing.JButton FlipButton;
    private javax.swing.JButton LoadButton;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PervButton;
    private javax.swing.JButton ShuffleButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton revisitButton;
    private javax.swing.JButton wrongButton;
    // End of variables declaration//GEN-END:variables
}
