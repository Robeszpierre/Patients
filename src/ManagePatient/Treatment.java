/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagePatient;

import NewPatient.Controller;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robeszpierre
 */
public class Treatment extends javax.swing.JPanel {

    /**
     * Creates new form Treatment
     */
    public Treatment() {
        initComponents();
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(15);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime dateTime = LocalDateTime.now();
        String time = dateTime.format(formatter); 
        jLabel1.setText(time);
    }
    private boolean isFilled;
    public void setIsFilled()
    {
        if(jTextPane1.getText().length()>1||jTextPane2.getText().length()>1||jTextPane3.getText().length()>1
           ||jTextPane4.getText().length()>1||jTextPane5.getText().length()>1)
        {
            isFilled=true;
        }
        else
            isFilled=false;
    }
    public boolean getIsFilled()
    {
        return isFilled;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();

        jScrollPane2.setHorizontalScrollBar(null);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(630, 620));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(627, 620));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Változások");

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel3.setText("Romlás");

        jTextPane1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel4.setText("Javulás");

        jTextPane2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jScrollPane3.setViewportView(jTextPane2);

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel5.setText("Egyéb");

        jTextPane3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jScrollPane4.setViewportView(jTextPane3);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Újabb javaslatok");

        jTextPane4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jScrollPane5.setViewportView(jTextPane4);

        jTextPane5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jScrollPane6.setViewportView(jTextPane5);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Terápia (pontok, masszázs, moxa, köpöly stb.)");

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Dátum módosítása");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(547, 566, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        DateModify d=new DateModify(this);
        d.setVisible(true);
    }//GEN-LAST:event_jButton11MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    // End of variables declaration//GEN-END:variables

    void save(int treatmentNumber, int idNumber) {
          PrintWriter writer = null;
        
            File file = new File(Controller.controller.path+idNumber+File.separatorChar+"Treatments"+File.separatorChar+Integer.toString(treatmentNumber+1)+".txt");
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Treatment.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            writer.println(jLabel1.getText().trim());
            writer.println("***");
        
            writer.println(jTextPane1.getText().trim());
            writer.println("***");
            
            
            writer.println(jTextPane2.getText().trim());
            writer.println("***");
            
            
            writer.println(jTextPane3.getText().trim());
            writer.println("***");
            
            
            writer.println(jTextPane4.getText().trim());
            writer.println("***");
            
            
            writer.println(jTextPane5.getText().trim());
            writer.println("***");
            
            writer.close();
    }

    void load(int i, String path) {
        Scanner input;
        String line, text = "";
        try{
            input=new Scanner(new File(path+"Treatments"+File.separatorChar+i+".txt"));
            
            line=input.nextLine();
            while(!line.equals("***")){
                text+=line+"\n";
                line=input.nextLine();
            }
            jLabel1.setText(text);
            
            
            text = "";
            line=input.nextLine();
            while(!line.equals("***")){
                text+=line+"\n";
                line=input.nextLine();
            }
            if(!text.equals("\n")){
                jTextPane1.setText(text);
            }
            
            text = "";
            line=input.nextLine();
            while(!line.equals("***")){
                text+=line+"\n";
                line=input.nextLine();
            }
            if(!text.equals("\n")){
                jTextPane2.setText(text);
            }
            
            text = "";
            line=input.nextLine();
            while(!line.equals("***")){
                text+=line+"\n";
                line=input.nextLine();
            }
            if(!text.equals("\n")){
                jTextPane3.setText(text);
            }
            
            text = "";
            line=input.nextLine();
            while(!line.equals("***")){
                text+=line+"\n";
                line=input.nextLine();
            }
            if(!text.equals("\n")){
                jTextPane4.setText(text);
            }
            
            text = "";
            line=input.nextLine();
            while(!line.equals("***")){
                text+=line+"\n";
                line=input.nextLine();
            }
            if(!text.equals("\n")){
                jTextPane5.setText(text);
            }
            
            input.close();
        }catch(Exception e){
            System.out.println("FILE NOT FOUND");
    }
    }
    
    void pdf(Document d ) throws DocumentException, IOException
    {
        BaseFont baseFont = BaseFont.createFont(BaseFont.TIMES_ROMAN, BaseFont.CP1250, BaseFont.NOT_EMBEDDED);
                 Font cellFont20 = new Font(baseFont, 20);
                 Font cellFont12italic = new Font(baseFont, 12,Font.ITALIC);
                 Font cellFont12 = new Font(baseFont, 12);
                 Font boldFont22 = new Font(baseFont, 22, Font.BOLD);
                 Font boldFont12 = new Font(baseFont, 12, Font.BOLD);
        d.add(new com.itextpdf.text.Paragraph("Dátum:"+jLabel1.getText(),boldFont12));
        String treat="";
        treat=jTextPane1.getText();
        if(treat.length()>1)
        {
            d.add(new com.itextpdf.text.Paragraph("Romlás:",boldFont12));
            d.add(new com.itextpdf.text.Paragraph(treat,cellFont12));
            d.add(new com.itextpdf.text.Paragraph(""));
        }
        treat="";
        treat=jTextPane2.getText();
        if(treat.length()>1)
        {
            d.add(new com.itextpdf.text.Paragraph("Javulás:",boldFont12));
            d.add(new com.itextpdf.text.Paragraph(treat,cellFont12));
            d.add(new com.itextpdf.text.Paragraph(""));
        }
        treat="";
        treat=jTextPane3.getText();
        if(treat.length()>1)
        {
            d.add(new com.itextpdf.text.Paragraph("Egyéb:",boldFont12));
            d.add(new com.itextpdf.text.Paragraph(treat,cellFont12));
            d.add(new com.itextpdf.text.Paragraph(""));
        }
        treat="";
        treat=jTextPane4.getText();
        if(treat.length()>1)
        {
            d.add(new com.itextpdf.text.Paragraph("Újabb javaslatok:",boldFont12));
            d.add(new com.itextpdf.text.Paragraph(treat,cellFont12));
            d.add(new com.itextpdf.text.Paragraph(""));
        }
        treat="";
        treat=jTextPane5.getText();
        if(treat.length()>1)
        {
            d.add(new com.itextpdf.text.Paragraph("Terápia (pontok, masszázs, moxa, köpöly stb.)",boldFont12));
            d.add(new com.itextpdf.text.Paragraph(treat,cellFont12));
            d.add(new com.itextpdf.text.Paragraph(""));
        }
        
    }

    void setdate(String date) {
        jLabel1.setText(date);
    }

    void setFocus() {
        jTextPane1.requestFocusInWindow();
    }
}
