/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagePatient;

import Main.EncryptDecrypt;
import NewPatient.Controller;
import NewPatient.PersonalDatas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author robeszpierre
 */
public class SelectPatient extends javax.swing.JFrame {

    DefaultListModel listModel;
    ArrayList<String> elements;
    /**
     * Creates new form SelectPatient
     */
    public SelectPatient() throws Exception{
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        searchBox.requestFocusInWindow();
        
        Scanner inputPatients=null;
        
        try {
            inputPatients=new Scanner(new File(Controller.controller.path+"patients.txt"), "UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SelectPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        elements= new ArrayList<String>();
        listModel = new DefaultListModel();
        
        Calendar today = Calendar.getInstance();
        
        while(inputPatients.hasNext()){
            String nextPatient=EncryptDecrypt.decrypt(inputPatients.nextLine());
            if(nextPatient.equals("")){
                continue;
            }
            
            String patientNumber = "";

            // Create a Pattern object
            Pattern r = Pattern.compile("\\d+");
            
            Matcher m = r.matcher(nextPatient);
            if (m.find( )) {
               patientNumber=m.group(0);
            }else {
               System.out.println("NO MATCH");
            }
            
            Scanner inputEndDate = null;
            String startDate = null;
        
            try {
                inputEndDate=new Scanner(new File(Controller.controller.path+patientNumber+File.separatorChar+"finalreport.txt"), "UTF-8");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SelectPatient.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
            startDate=EncryptDecrypt.decrypt(inputEndDate.nextLine());
            } catch (Exception ex) {
                System.out.println(ex);
            }

            SimpleDateFormat dateFromat = new SimpleDateFormat("yyyy-MM-dd");
            
            try {
                Calendar endDate = Calendar.getInstance();
                endDate.setTime(dateFromat.parse(startDate));
                endDate.add(Calendar.YEAR, 1);
                
                if(endDate.compareTo(today)<0){
                    nextPatient="<html><font color=red>"+nextPatient+"</html>"; 
                } 
            } catch (ParseException ex) {
                //not a date
            }
            elements.add(nextPatient);
        }
        updateListContent(elements);
                  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        searchBox = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setTitle("Beteg kiválasztása");
        setResizable(false);

        jList1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jList1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jList1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Kiválaszt");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        searchBox.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchBoxKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBoxKeyPressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(200, 0, 0));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Töröl");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
            .addComponent(searchBox, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBox, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            selectPatient();
        } catch (Exception ex) {
            Logger.getLogger(SelectPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void selectPatient() throws Exception{
        int patientId = getPatientId();      
        
        new ManageMain(patientId);
        this.setVisible(false);
        Controller.controller.mainFrame.setVisible(false);
    }
    
    private int getPatientId(){
        Matcher matcher = Pattern.compile("\\d+").matcher(jList1.getSelectedValue());
        matcher.find();
        int patientId = Integer.valueOf(matcher.group());
        return patientId;
    }
    
    private void updateListContent(ArrayList<String> elements){
        listModel.removeAllElements();
        for(String val : elements){
            listModel.addElement(val);
        }
        jList1.setModel(listModel);
        jList1.setSelectedIndex(0);
    }
    
    private void searchBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyTyped
            search();
    }//GEN-LAST:event_searchBoxKeyTyped

    private void search(){
        ArrayList<String> result=new ArrayList<>();
            for(String val: elements){
                if(val.toLowerCase().contains(searchBox.getText().toLowerCase())){
                    result.add(val);
                }
            }
            listModel.removeAllElements();
            updateListContent(result);
    }
    
    private void searchBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyPressed
        int keyCode = evt.getKeyCode();
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                jList1.setSelectedIndex(jList1.getSelectedIndex()-1);
                break;
            case KeyEvent.VK_DOWN:
                jList1.setSelectedIndex(jList1.getSelectedIndex()+1);
                break;
            case KeyEvent.VK_ENTER:
        {
            try {
                selectPatient();
            } catch (Exception ex) {
                Logger.getLogger(SelectPatient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
        }
    }//GEN-LAST:event_searchBoxKeyPressed

    private void jList1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jList1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                selectPatient();
            } catch (Exception ex) {
                Logger.getLogger(SelectPatient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jList1KeyPressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
       int dialogButton = 0;
       Object[] options = {"Igen", "Nem"};
       int n = JOptionPane.showOptionDialog(null,
        "Biztosan törölni szeretné a kijelölt páciens adatait?",
        "Megerősítés",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,     //do not use a custom Icon
        options,  //the titles of buttons
        options[0]); //default button title
        if(n == JOptionPane.YES_OPTION){
            int patientId=getPatientId();
            System.out.println(patientId);
            String selecteditem=jList1.getSelectedValue();
            int counter=0;
            for(String s: elements){
                if(s.equals(selecteditem)){
                    elements.remove(counter);
                    updateListContent(elements);
                    search();
                    File dir=new File(Controller.controller.path+patientId);
                    System.out.println(dir);
                    deleteDirectory(dir);
                    try {
                        deletePatient(selecteditem);
                    } catch (Exception ex) {
                        Logger.getLogger(SelectPatient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                counter++;
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchBox;
    // End of variables declaration//GEN-END:variables

    public static boolean deleteDirectory(File directory) {
    if(directory.exists()){
        File[] files = directory.listFiles();
        if(null!=files){
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                }
                else {
                    files[i].delete();
                }
            }
        }
    }
    return(directory.delete());
}

    private void deletePatient(String selecteditem)throws Exception {
        Scanner inputPatients=null;
        
        try {
            inputPatients=new Scanner(new File(Controller.controller.path+"patients.txt"), "UTF-8");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SelectPatient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String tmp="";
        
        while(inputPatients.hasNext()){
            String input=EncryptDecrypt.decrypt( inputPatients.nextLine());
            if(input.equals(selecteditem)){
                
            }else if(("<html><font color=red>"+input+"</html>").equals(selecteditem)){
                
            }else{
                tmp+=input+"\n";
            }
        }
        inputPatients.close();
        PrintWriter writer;
        try{
        File file = new File(Controller.controller.path+"patients.txt");
        writer = new PrintWriter(file);
        writer.println(tmp);
        writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonalDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
