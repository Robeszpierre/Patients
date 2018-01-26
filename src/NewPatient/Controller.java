package NewPatient;

import Main.MainFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author robeszpierre
 */
public class Controller {    
    
    static public Controller controller=new Controller();
    
    public int idNumber;
    public String path=File.separatorChar+"home"+File.separatorChar+"robeszpierre"+File.separatorChar+"NetBeansProjects"+File.separatorChar+"Patients"+File.separatorChar+"src"+File.separatorChar+"Patients"+File.separatorChar;
    public String sex;
    
    private MainFrame mainFrame;
    private PersonalDatas newPatientPersonalDatas;
    private Questions newPatientQuestions;
    private MedicalHistory newPatientMedicalHistory;
    private Complaints newPatientPresentComplaints;
    private PsychologicalAnamnesis newPatientPsychologicalAnamnesis;
    private Tongue newPatientTongue;
    private Pulse newPatientPulse;
    private Diagnose newPatientDiagnose;
    private Ear newPatientEar;
    
    public void start(){
        mainFrame=new MainFrame();
        mainFrame.setVisible(true);
    }
    
    
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                controller.start();
            }
        });
    }

    public void newPatient(){
        newPatientPersonalDatas = new PersonalDatas();
        newPatientPersonalDatas.setVisible(true);
        File file = new File(path + "idNumber.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
            idNumber=sc.nextInt();
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        idNumber++;
    }
     
    public void newQuestions() {
        newPatientQuestions = new Questions();
        newPatientQuestions.setVisible(true);
    }
    
    public void newMedicalHistory(){
        newPatientMedicalHistory=new MedicalHistory();
        newPatientMedicalHistory.setVisible(true);
    }
    
    public void newCompleints(){
        newPatientPresentComplaints=new Complaints();
        newPatientPresentComplaints.setVisible(true);
    }
    
    public void newAnamnesis(){
        newPatientPsychologicalAnamnesis=new PsychologicalAnamnesis();
        newPatientPsychologicalAnamnesis.setVisible(true);
    }
    
    public void newTongue(){
        newPatientTongue=new Tongue();
        newPatientTongue.setVisible(true);
    }
    
    public void newEar(){
        newPatientEar=new Ear();
        newPatientEar.setVisible(true);
    }
    
    public void newPulse(){
        newPatientPulse=new Pulse();
        newPatientPulse.setVisible(true);
    }
    
    public void newDiagnose(){
        newPatientDiagnose=new Diagnose();
        newPatientDiagnose.setVisible(true);
    }
    
    public void save() throws IOException{
        newPatientPersonalDatas.save(path);
        newPatientMedicalHistory.save(path);
        newPatientPresentComplaints.save(path);
        newPatientQuestions.save(path);
        newPatientPsychologicalAnamnesis.save(path);
        newPatientDiagnose.save(path);
        newPatientPulse.save(path);
              
        PrintWriter writer;
        try {
            String path2=path+"/idNumber.txt";
            File file = new File(path2);
            writer = new PrintWriter(file, "UTF-8");
            writer.println(idNumber);
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(PersonalDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        newPatientTongue.save(path); 
        newPatientEar.save(path); 
    }
    
    public void setSex(String s){
        sex=s;
    }
}
