/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package faconverter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;





public class MainFrame extends javax.swing.JFrame {
    ArrayList<String> input = new ArrayList<>();
    ArrayList<String> alphabet = new ArrayList<>();
    ArrayList<String> states = new ArrayList<>();
    ArrayList<String> finalStates = new ArrayList<>();
    ArrayList<String[]> dArray = new ArrayList<>();
    
    private String finalRGText; //gets final text from text area
    private String[] finalRG; // converts final text to an array

    private String currentLine;
    
    private String displayImportText = "";
    
    private String initialState;
    


    /**
     * Creates new form NewJFrame
     */
    public MainFrame() {
        initComponents();
        stringTextArea.setVisible(false);
        checkStringButton.setVisible(false);
        outputTextArea.setEditable(false);
        helpTextArea.setEditable(false);
    }

    
    private void clearAll() {
    // code to be executed
        DefaultTableModel table1 = (DefaultTableModel) jTable1.getModel();
        table1.setColumnCount(0);
        table1.setRowCount(0);
        inputTextArea.setText("");
        outputTextArea.setText("");
        input.clear();
        alphabet.clear();
        states.clear();
        finalStates.clear();
        dArray.clear();
  }
    
    
    private String setFormatter(String printValue) {
       
        String output;
        
        if(printValue.length() == 1){
            return "{" + printValue + "}";
        }else{
             ArrayList<String> list = new ArrayList<>(Arrays.asList(printValue.split("(?!^)")));
             output = list.toString().replace("[","{").replace("]","}");
        }
        
        return output;
  }
    
    
    
    private boolean InputTextAreaChecker(){
        String prevImport = inputTextArea.getText();
         
         //Resets Everything when button is pressed:
         clearAll();
         
         if(!prevImport.equals("")){
             
         

        inputTextArea.setText(prevImport);
        
        finalRGText =  inputTextArea.getText(); // get final text form text Area
        finalRG = finalRGText.split("\n"); // convert it to array
 
        
        finalRGText =  inputTextArea.getText(); // get final text form text Area
        finalRG = finalRGText.split("\n"); // convert it to array
        
        for (String finalRG1 : finalRG) { // loop in array
            currentLine = finalRG1;
            // Get State
            String state = currentLine.split("→")[0];
            states.add(state); 
            
            // Get alphabet and other
            String dValues = currentLine.split("→")[1];
            dArray.add(dValues.split("\\|"));
            
            String[] y = dValues.split("\\|"); // 0A, 1B
            
            for (String y1 : y) {
                String first = String.valueOf(y1.charAt(0)); //0
                boolean contains = alphabet.contains(first);
                boolean isFinal = y1.equals("ε");
                
                if (y1.length() > 1) {
                    if(!contains){
                        alphabet.add(first);
                    }
                } else if(isFinal){
                    finalStates.add(state);
                    if(!contains){
                        alphabet.add(first);
                    }
                    
                }
            }
        }
        
        
         if(alphabet.size() < 3){
              JOptionPane.showMessageDialog(rootPane,"Alphabet should cannot be less than 3 , including ε!");
               return false;
         }else{
                         
             //Start
             String outputTextAreaText = "M=(Q, ∑, δ, p0, F)\n";
             
             //States:
             outputTextAreaText += "Q=";
             String s = states.toString().replace('[', '{').replace(']', '}')+"\n";
             outputTextAreaText += s;
             
            //Alphabet:
             outputTextAreaText += "Σ=";
             String a = alphabet.toString().replace('[', '{').replace(']', '}').replace(", ε","") + "\n";
             outputTextAreaText += a;
             
             outputTextAreaText += "𝛿:Q x Σε → Pow(Q)\n";
        
             initialState = states.get(0);
             outputTextAreaText += "p0="+initialState+"\n";
             
             //Final States:
             outputTextAreaText += "Q=";
             String f = finalStates.toString().replace('[', '{').replace(']', '}')+"\n";
             outputTextAreaText += f;
    
             outputTextArea.setText(outputTextAreaText); 
             
             
             
                return true;
         }
         }else{
             
            JOptionPane.showMessageDialog(rootPane,"Alphabet should cannot be less than 3 , including ε!");
            return false;
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

        TabbedPaneContainer = new javax.swing.JTabbedPane();
        HomePageFrame = new javax.swing.JPanel();
        line1Label = new javax.swing.JLabel();
        line2Label = new javax.swing.JLabel();
        line3Label = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        nameLabel2 = new javax.swing.JLabel();
        leaderLabel = new javax.swing.JLabel();
        participationLabel = new javax.swing.JLabel();
        partPercentLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameLabel6 = new javax.swing.JLabel();
        partPercentLabel4 = new javax.swing.JLabel();
        partPercentLabel5 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        FunctionsPageFrame = new javax.swing.JPanel();
        inputContainerPanel = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        importButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        rgToNFAButton = new javax.swing.JButton();
        rgToNFANoEpsilonButton = new javax.swing.JButton();
        rgToDFAButton = new javax.swing.JButton();
        rgToMinDFAButton = new javax.swing.JButton();
        testStringsButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextPane();
        arrowButton = new javax.swing.JButton();
        epsilonButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        stringTextArea = new javax.swing.JTextArea();
        checkStringButton = new javax.swing.JButton();
        HelpPageFrame = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        helpTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1020, 800));

        line1Label.setText("TIC2151 Theory of Computation");

        line2Label.setText("Tutorial group TT2L");

        line3Label.setText("Group 1");

        nameLabel1.setText("Member 1");

        nameLabel2.setText("Ahmed Elsayed Mosatafa Sanad");

        leaderLabel.setText("Leader");

        partPercentLabel1.setText("Participation: X%");

        jLabel1.setText("Abdulrahman Ibrahim  Obeidallah");

        nameLabel4.setText("Member 2");

        jLabel2.setText("1191302429");

        jLabel3.setText("1181102208");

        nameLabel5.setText("Yucedag Ahmet Baki");

        jLabel4.setText("1201202756");

        nameLabel6.setText("Member 3");

        partPercentLabel4.setText("Participation: X%");

        partPercentLabel5.setText("Participation: X%");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faconverter/images/ahmet_150x150.jpeg"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faconverter/images/abdul_150x150.jpeg"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/faconverter/images/ahmed_1_150x150.jpeg"))); // NOI18N

        javax.swing.GroupLayout HomePageFrameLayout = new javax.swing.GroupLayout(HomePageFrame);
        HomePageFrame.setLayout(HomePageFrameLayout);
        HomePageFrameLayout.setHorizontalGroup(
            HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePageFrameLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(participationLabel)
                .addGap(30, 30, 30)
                .addGroup(HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(HomePageFrameLayout.createSequentialGroup()
                        .addComponent(nameLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(leaderLabel))
                    .addComponent(jLabel2)
                    .addComponent(partPercentLabel1)
                    .addComponent(line3Label)
                    .addGroup(HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(line1Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(line2Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                    .addComponent(jLabel6))
                .addGap(36, 36, 36)
                .addGroup(HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(nameLabel4)
                    .addComponent(nameLabel2)
                    .addComponent(jLabel3)
                    .addComponent(partPercentLabel4))
                .addGap(46, 46, 46)
                .addGroup(HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(partPercentLabel5)
                    .addComponent(nameLabel6)
                    .addComponent(nameLabel5)
                    .addComponent(jLabel4))
                .addContainerGap(10124, Short.MAX_VALUE))
        );
        HomePageFrameLayout.setVerticalGroup(
            HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePageFrameLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(HomePageFrameLayout.createSequentialGroup()
                        .addComponent(line1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(line2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(line3Label)
                        .addGap(44, 44, 44)
                        .addGroup(HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(participationLabel)
                                .addComponent(partPercentLabel1))
                            .addComponent(partPercentLabel4)))
                    .addComponent(partPercentLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(HomePageFrameLayout.createSequentialGroup()
                        .addGroup(HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel1)
                            .addComponent(nameLabel4)
                            .addComponent(leaderLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameLabel2)))
                    .addGroup(HomePageFrameLayout.createSequentialGroup()
                        .addComponent(nameLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLabel5)))
                .addGap(47, 47, 47)
                .addGroup(HomePageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        TabbedPaneContainer.addTab("Home", HomePageFrame);

        inputTextArea.setColumns(20);
        inputTextArea.setRows(5);
        inputContainerPanel.setViewportView(inputTextArea);

        importButton.setText("Import");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        rgToNFAButton.setText("NFA");
        rgToNFAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgToNFAButtonActionPerformed(evt);
            }
        });

        rgToNFANoEpsilonButton.setText("NFA w/o ε ");
        rgToNFANoEpsilonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgToNFANoEpsilonButtonActionPerformed(evt);
            }
        });

        rgToDFAButton.setText("DFA");
        rgToDFAButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rgToDFAButtonActionPerformed(evt);
            }
        });

        rgToMinDFAButton.setText("Min DFA");

        testStringsButton.setText("Test");
        testStringsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testStringsButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jScrollPane3.setViewportView(outputTextArea);

        arrowButton.setText("→");
        arrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arrowButtonActionPerformed(evt);
            }
        });

        epsilonButton.setText("ε");
        epsilonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                epsilonButtonActionPerformed(evt);
            }
        });

        stringTextArea.setColumns(20);
        stringTextArea.setRows(5);
        jScrollPane4.setViewportView(stringTextArea);

        checkStringButton.setText("Check Strings");
        checkStringButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkStringButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FunctionsPageFrameLayout = new javax.swing.GroupLayout(FunctionsPageFrame);
        FunctionsPageFrame.setLayout(FunctionsPageFrameLayout);
        FunctionsPageFrameLayout.setHorizontalGroup(
            FunctionsPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FunctionsPageFrameLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(FunctionsPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rgToNFANoEpsilonButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rgToDFAButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rgToNFAButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rgToMinDFAButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(testStringsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(arrowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(epsilonButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(FunctionsPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FunctionsPageFrameLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(importButton)
                        .addGap(88, 88, 88)
                        .addComponent(clearButton))
                    .addGroup(FunctionsPageFrameLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(FunctionsPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(inputContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))))
                .addGap(51, 51, 51)
                .addGroup(FunctionsPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkStringButton)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        FunctionsPageFrameLayout.setVerticalGroup(
            FunctionsPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FunctionsPageFrameLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(FunctionsPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FunctionsPageFrameLayout.createSequentialGroup()
                        .addGroup(FunctionsPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputContainerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(jScrollPane4))
                        .addGroup(FunctionsPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FunctionsPageFrameLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(importButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FunctionsPageFrameLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(FunctionsPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(checkStringButton)
                                    .addComponent(clearButton)))))
                    .addGroup(FunctionsPageFrameLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(arrowButton)
                        .addGap(18, 18, 18)
                        .addComponent(epsilonButton)))
                .addGap(18, 18, 18)
                .addGroup(FunctionsPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FunctionsPageFrameLayout.createSequentialGroup()
                        .addComponent(rgToNFAButton)
                        .addGap(18, 18, 18)
                        .addComponent(rgToNFANoEpsilonButton)
                        .addGap(18, 18, 18)
                        .addComponent(rgToDFAButton)
                        .addGap(18, 18, 18)
                        .addComponent(rgToMinDFAButton)
                        .addGap(18, 18, 18)
                        .addComponent(testStringsButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        TabbedPaneContainer.addTab("RG to FA", FunctionsPageFrame);

        helpTextArea.setColumns(20);
        helpTextArea.setRows(5);
        helpTextArea.setText("How to use the program:\n\n1.RG to NFA:\n    - In order for the program to convert RG to NFA the user have to:\n    - Enter min 3 alphabet including epsilon (ε) example: a,b,ε\n    - Enter each state in new line and State Letter must be followed by arrow (User can use arrow button on left side) then directions\n    - example: R (arrow) bR|aS (if user wishes to enter multiple directions | must be used)\n    - User must click Convert RG To NFA button\n\n2. RG to NFA without epsilon:\n    - In order for the program to convert RG to NFA without ε the user have to:\n    - Enter min 3 alphabet including epsilon (ε) example: a,b,ε\n    - Enter each state in new line and State Letter must be followed by arrow (User can use arrow button on left side) then directions\n    - example: R (arrow) bR|aS (if user wishes to enter multiple directions | must be used)\n    - User must click To NFA without ε button\n\n5. Check strings for RG:\n    - The user needs to enter the regular grammar as right regular, the transition symbol that should be used is (arrow) and epsilon (ε)\n    - Using only the regular grammar alphabet, the user can enter the strings to check, minimum 5 strings.");
        jScrollPane1.setViewportView(helpTextArea);

        javax.swing.GroupLayout HelpPageFrameLayout = new javax.swing.GroupLayout(HelpPageFrame);
        HelpPageFrame.setLayout(HelpPageFrameLayout);
        HelpPageFrameLayout.setHorizontalGroup(
            HelpPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 10794, Short.MAX_VALUE)
        );
        HelpPageFrameLayout.setVerticalGroup(
            HelpPageFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
        );

        TabbedPaneContainer.addTab("Help", HelpPageFrame);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPaneContainer)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TabbedPaneContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkStringButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkStringButtonActionPerformed
        // TODO add your handling code here:
        //get Strings:
        String[] stringsToCheck =  stringTextArea.getText().split("\n");

        if(InputTextAreaChecker()){
          if(stringsToCheck.length < 5){
                JOptionPane.showMessageDialog(rootPane,"You have to enter minimum 5 strings at once!!");

            }else{
                
              //place it inside else:
              for ( int i =0; i< stringsToCheck.length;i++){// for every string
                  
                boolean stringValidity = false;
                String currentString = stringsToCheck[i]; //1111 
                String[] currentTransitions = dArray.get(0);// initial state: 0B|1C
                String currentState = "";
                
//                if(i==3){
//                        System.out.println( "currentTransitions: "+ Arrays.toString(currentTransitions) ); 
//                }
                
                 for ( int c =0; c< currentString.length();c++){ // loop in 1111 
                    String currentChar =  String.valueOf(currentString.charAt(c)); //1
                    
//                    if(i==3){
//                        System.out.println( "currentChar: "+ currentChar ); 
//                       
//                    }
                    
                    for ( int x =0; x < currentTransitions.length;x++){ 
                        if(currentTransitions[x].contains(currentChar)){
                           currentState = String.valueOf(currentTransitions[x].charAt(1));
                           currentTransitions = dArray.get(states.indexOf(currentState));
                           stringValidity = true;
                           
                           //final state check
                           if(c == currentString.length()-1 ){
                               
                            if( finalStates.contains(currentState)){ // if current state is final like: B
                                stringValidity = true;  
                            }else{
                                if(i==3){
                            System.out.println( "1 currentState: "+ currentState );
                            System.out.println( "1 currentTransitions: "+ Arrays.toString(currentTransitions) );
                            }
                                // if state has Epsilon to final like: c->B
                                for (int z=0; z< currentTransitions.length;z++){
                                    if(currentTransitions[z].length() == 1 && finalStates.contains(currentTransitions[z])){
                                         stringValidity = true;
                                         break;
                                    }else{
                                        stringValidity = false;
                                    }
                                }
                                
                                
      
                            }
//                            if(i==3){
//                            System.out.println( "currentState: "+ currentState );
//                            }
                            
                        }
                           break;
                        }else{
                            stringValidity = false;
                        }
                        
                         
                    }
                    
                    
//                    if(i==3){
//                       System.out.println( "currentTransitions: "+ Arrays.toString(currentTransitions) ); 
//                      //System.out.println( "currentState: "+ currentState ); 
//                    }
                    
                    
  
                 }
                 
                 //print string checking:
                 if(i==0){
                    stringTextArea.setText("");
                 }
                 
                 String currentStringTextAreatext = stringTextArea.getText();
                 
                 if(stringValidity){ //true
                     stringTextArea.setText(currentStringTextAreatext + stringsToCheck[i] + " OK" + "\n");
                 }else{//false
                     stringTextArea.setText(currentStringTextAreatext + stringsToCheck[i] + " NO" + "\n");
                 }
   
              }

    }
            

        }
    }//GEN-LAST:event_checkStringButtonActionPerformed

    private void epsilonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_epsilonButtonActionPerformed
        // TODO add your handling code here:
        String currentText = inputTextArea.getText();
        inputTextArea.setText(currentText+"ε");
    }//GEN-LAST:event_epsilonButtonActionPerformed

    private void arrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arrowButtonActionPerformed
        // TODO add your handling code here:
        String currentText = inputTextArea.getText();
        inputTextArea.setText(currentText+"→");
    }//GEN-LAST:event_arrowButtonActionPerformed

    private void rgToDFAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgToDFAButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rgToDFAButtonActionPerformed

    private void rgToNFANoEpsilonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgToNFANoEpsilonButtonActionPerformed
        // TODO add your handling code here:

        DefaultTableModel table1 = (DefaultTableModel) jTable1.getModel(); //table initializer

        if(InputTextAreaChecker()){

            ArrayList<String> alphabetNew = new ArrayList<>();

            alphabetNew =  alphabet;
            alphabetNew.remove("ε");

            //Print Columns:-----------
            table1.addColumn("𝛿NFA");
            for(int i = 0; i< alphabetNew.size(); i++){
                table1.addColumn(alphabetNew.get(i)); // add alphabet columns
            }

            //Print Rows:--------------

            for(int z = 0; z< states.size(); z++){

                String currentState = states.get(z);// A
                String [] currentDvalues = dArray.get(z); // [0A,1B]

                String[] rowPrint = new String[alphabet.size()+1];

                if(z == 0){
                    rowPrint[0]= ">" + currentState;
                }else{
                    rowPrint[0]=currentState;
                }

                for(int i = 0; i< alphabetNew.size(); i++){
                    String currentValue = "";
                    String currentAlphabet = alphabetNew.get(i); // holds current alphabet 0

                    for(int v = 0; v< currentDvalues.length; v++){ //Loop in state Values
                        if(currentDvalues[v].length() > 1){ // Current value : 0A
                            String currentdValue = String.valueOf(currentDvalues[v].charAt(0)); // holds 0
                            if(currentdValue.equals(currentAlphabet)){
                                currentValue += String.valueOf(currentDvalues[v].charAt(1));

                                // check B if it has the alhpabet if yes add it
                                ArrayList<String> valueOfState = new ArrayList<>(); //holds B values [0A|C]
                                String newState = String.valueOf(currentDvalues[v].charAt(1));

                                int cIndex = states.indexOf(newState);
                                String [] newDArray = dArray.get(cIndex);
                                for(String value:newDArray) {valueOfState.add(value);}

                                // check if b has the value and include it
                                for(int u = 0; u < valueOfState.size(); u++){
                                    if(valueOfState.get(u).length() == 1 && !valueOfState.get(u).equals("ε")){
                                        currentValue += valueOfState.get(u);
                                    }
                                }

                            }

                        }else{ //B or ε

                            String epCheck = String.valueOf(currentDvalues[v].charAt(0));
                            if(!epCheck.equals("ε")){
                                // check B if it has the alhpabet if yes add it
                                ArrayList<String> valueOfState = new ArrayList<>(); //holds B values [0A|C]
                                String newState = String.valueOf(currentDvalues[v].charAt(0));

                                int cIndex = states.indexOf(newState);
                                String [] newDArray = dArray.get(cIndex);
                                for(String value:newDArray) {valueOfState.add(value);}

                                System.out.println("valueOfState: " + valueOfState);
                                // check if b has the value and include it
                                for(int u = 0; u < valueOfState.size(); u++){
                                    if(valueOfState.get(u).length() == 1 && !valueOfState.get(u).equals("ε")){
                                        currentValue += valueOfState.get(u);
                                    }else{
                                        String newCheck = String.valueOf(valueOfState.get(u).charAt(0));
                                        System.out.println("newCheck: " + newCheck);
                                        System.out.println("currentAlphabet: " + currentAlphabet);
                                        if(newCheck.equals(currentAlphabet) ){
                                            currentValue += String.valueOf(valueOfState.get(u).charAt(1));
                                        }

                                    }
                                }

                                //currentValue += String.valueOf(currentDvalues[v].charAt(0));

                            }else{
                                rowPrint[0]= "*" + currentState;
                            }

                        }
                    }

                    //Add current value to row
                    if(currentValue.equals("")){
                        rowPrint[i+1]= "Ø";
                    }else{
                        rowPrint[i+1]= setFormatter(currentValue);
                    }

                }

                table1.addRow(rowPrint);

            }

        }

    }//GEN-LAST:event_rgToNFANoEpsilonButtonActionPerformed

    //convert RG To NFA
    private void rgToNFAButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rgToNFAButtonActionPerformed

        DefaultTableModel table1 = (DefaultTableModel) jTable1.getModel(); //table initializer

        if(InputTextAreaChecker()){

            //Print in table:-----------------------------

            //Print Columns:-----------
            table1.addColumn("𝛿NFA");
            for(int i = 0; i< alphabet.size(); i++){
                table1.addColumn(alphabet.get(i)); // add alphabet columns
            }

            //Print Rows:--------------

            for(int z = 0; z< states.size(); z++){

                String currentState = states.get(z);// A
                String [] currentDvalues = dArray.get(z); // [0A,1B]

                String[] rowPrint = new String[alphabet.size()+1];

                if(z == 0){
                    rowPrint[0]= ">" + currentState;
                }else{
                    rowPrint[0]=currentState;
                }

                for(int i = 0; i< alphabet.size(); i++){
                    String currentValue = "";
                    String currentAlphabet = alphabet.get(i); // holds current alphabet 0

                    for(int v = 0; v< currentDvalues.length; v++){ //Loop in state Values
                        if(currentDvalues[v].length() > 1){ // Current value : 0A
                            String currentdValue = String.valueOf(currentDvalues[v].charAt(0)); // holds 0
                            if(currentdValue.equals(currentAlphabet)){
                                currentValue += String.valueOf(currentDvalues[v].charAt(1));
                            }

                        }else{ //B
                            if(currentAlphabet.equals("ε")){
                                String epCheck = String.valueOf(currentDvalues[v].charAt(0));
                                if(!epCheck.equals("ε")){
                                    currentValue += String.valueOf(currentDvalues[v].charAt(0));
                                }else{
                                    rowPrint[0]= "*" + currentState;
                                }

                            }
                        }
                    }

                    //Add current value to row
                    if(currentValue.equals("")){
                        rowPrint[i+1]= "Ø";
                    }else{
                        rowPrint[i+1]= setFormatter(currentValue);
                    }

                }

                table1.addRow(rowPrint);

            }

        }

    }//GEN-LAST:event_rgToNFAButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed

        clearAll();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        // TODO add your handling code here:

        displayImportText="";
        inputTextArea.setText(displayImportText);

        try{
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            String line;
            while((line = reader.readLine()) != null){
                input.add(line);
                displayImportText += line + "\n";
            }
            //        System.out.println("displayImportText: " + displayImportText);
            inputTextArea.setText(displayImportText);
            reader.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_importButtonActionPerformed

    private void testStringsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testStringsButtonActionPerformed
        // TODO add your handling code here:
         stringTextArea.setVisible(true);
         checkStringButton.setVisible(true);
         stringTextArea.setText("ε" + "\n" + "1111" + "\n" + "10101010" + "\n" + "0101010" + "\n" + "1");
         //stringTextArea.setText("ε" + "\n" + "aaa" + "\n" + "bbbb" + "\n" + "abbbbab" + "\n" + "aab");
    }//GEN-LAST:event_testStringsButtonActionPerformed

    

    
    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FunctionsPageFrame;
    private javax.swing.JPanel HelpPageFrame;
    private javax.swing.JPanel HomePageFrame;
    private javax.swing.JTabbedPane TabbedPaneContainer;
    private javax.swing.JButton arrowButton;
    private javax.swing.JButton checkStringButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton epsilonButton;
    private javax.swing.JTextArea helpTextArea;
    private javax.swing.JButton importButton;
    private javax.swing.JScrollPane inputContainerPanel;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel leaderLabel;
    private javax.swing.JLabel line1Label;
    private javax.swing.JLabel line2Label;
    private javax.swing.JLabel line3Label;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel nameLabel2;
    private javax.swing.JLabel nameLabel4;
    private javax.swing.JLabel nameLabel5;
    private javax.swing.JLabel nameLabel6;
    private javax.swing.JTextPane outputTextArea;
    private javax.swing.JLabel partPercentLabel1;
    private javax.swing.JLabel partPercentLabel4;
    private javax.swing.JLabel partPercentLabel5;
    private javax.swing.JLabel participationLabel;
    private javax.swing.JButton rgToDFAButton;
    private javax.swing.JButton rgToMinDFAButton;
    private javax.swing.JButton rgToNFAButton;
    private javax.swing.JButton rgToNFANoEpsilonButton;
    private javax.swing.JTextArea stringTextArea;
    private javax.swing.JButton testStringsButton;
    // End of variables declaration//GEN-END:variables
}
