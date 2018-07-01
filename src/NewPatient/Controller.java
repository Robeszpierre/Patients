package NewPatient;

import Main.MainFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.CodeSource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sun.security.krb5.Checksum;

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
    public String path=null; 
    public String sex;
    public MainFrame mainFrame;
    private PersonalDatas newPatientPersonalDatas;
    private Questions newPatientQuestions;
    private MedicalHistory newPatientMedicalHistory;
    private Complaints newPatientPresentComplaints;
    private PsychologicalAnamnesis newPatientPsychologicalAnamnesis;
    private Tongue newPatientTongue;
    private Pulse newPatientPulse;
    private Diagnose newPatientDiagnose;
    private Ear newPatientEar;
    
    
    //statistic
    public int numOfPatients;
    public int numOfMan;
    public int numOfWoman;
    public int sumOfAge;
    public int avgAge;
    public int sumOfManAge;
    public int avgManAge;
    public int sumOfWomanAge;
    public int avgWomanAge;
    
    public int treatmentInProgress;
    public int healed;
    public int partiallyHealed;
    public int notHealed;
    public int other;
    
    public int sumOfTreatments;
    
    public void start(){
        if(checkLicence()){
        new Login();
        setPath();
        mainFrame=new MainFrame();
        mainFrame.setVisible(true);
        initStat();
        }else{
            JOptionPane.showMessageDialog(null, "Lejárt az előfizetése! Ha meg szeretné hosszabítani, akkor lépjen kapcsolatba a fejlesztővel az alábbi e-mail címen: robeszpierre@gmail.com");
        }
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
        
        newPatientQuestions.setVisible(true);
    }
    
    public void newMedicalHistory(){
        
        newPatientQuestions = new Questions();
        newPatientMedicalHistory=new MedicalHistory();
        newPatientPresentComplaints=new Complaints();
        newPatientPsychologicalAnamnesis=new PsychologicalAnamnesis();
        newPatientTongue=new Tongue();
        newPatientEar=new Ear();
        newPatientPulse=new Pulse();
        newPatientDiagnose=new Diagnose();
        
        newPatientMedicalHistory.setVisible(true);
    }
    
    public void newCompleints(){
        newPatientPresentComplaints.setVisible(true);
    }
    
    public void newAnamnesis(){
        newPatientPsychologicalAnamnesis.setVisible(true);
    }
    
    public void newTongue(){
        newPatientTongue.setVisible(true);
    }
    
    public void newEar(){
        newPatientEar.setVisible(true);
    }
    
    
    
    public void newPulse(){  
        newPatientPulse.setVisible(true);
    }
    
    public void newDiagnose(){
        newPatientDiagnose.setVisible(true);
    }
    
    public void previous1(){
        newPatientMedicalHistory.setVisible(true);
    }
    
    public void previous2(){
        newPatientPresentComplaints.setVisible(true);
    }
    
    public void previous3(){
        newPatientPsychologicalAnamnesis.setVisible(true);
    }
    
    public void previous4(){
        newPatientQuestions.setVisible(true);
    }
    
    public void previous5(){
        newPatientTongue.setVisible(true);
    }
    
    public void previous6(){
        newPatientEar.setVisible(true);
    }
    
    public void previous7(){
        newPatientPulse.setVisible(true);
    }
    
    public void save() throws IOException, Exception{
        newPatientPersonalDatas.save(path);
        newPatientMedicalHistory.save(path);
        newPatientPresentComplaints.save(path);
        newPatientQuestions.save(path);
        newPatientPsychologicalAnamnesis.save(path);
        newPatientDiagnose.save(path);
        newPatientPulse.save(path);
        
        
        treatmentInProgress++;
              
        PrintWriter writer;
        try {
            String path2=path+File.separatorChar+"idNumber.txt";
            File file = new File(path2);
            writer = new PrintWriter(file);
            writer.println(idNumber);
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonalDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PrintWriter writer2 = null;
        try {
            writer2 = new PrintWriter(path+idNumber+File.separatorChar+"finalreport.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Can't make final report txt");
        }
        writer2.println("***");
        writer2.println("***");
        writer2.println("────────");
        writer2.println("***");
        
        writer2.close();
        
        saveStatistic();
        
        File directory = new File(path+idNumber+File.separatorChar+"Treatments");
        directory.mkdir();
        
        newPatientTongue.save(path); 
        newPatientEar.save(path); 
    }
    
    public void setSex(String s){
        sex=s;
    }

    private void initStat() {
        try {
            Scanner input=new Scanner(new File(path+"statistic.txt"));
            numOfPatients=Integer.parseInt(input.nextLine());
            numOfMan=Integer.parseInt(input.nextLine());
            numOfWoman=Integer.parseInt(input.nextLine());
            sumOfAge=Integer.parseInt(input.nextLine());
            sumOfManAge=Integer.parseInt(input.nextLine());
            sumOfWomanAge=Integer.parseInt(input.nextLine());
            treatmentInProgress=Integer.parseInt(input.nextLine());
            healed=Integer.parseInt(input.nextLine());
            partiallyHealed=Integer.parseInt(input.nextLine());
            notHealed=Integer.parseInt(input.nextLine());
            other=Integer.parseInt(input.nextLine());
            sumOfTreatments=Integer.parseInt(input.nextLine());
            
            input.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void countAvg() {
        avgAge=sumOfAge/numOfPatients;
        try{
            avgManAge=sumOfManAge/numOfMan;
        }catch(Exception e){
        }
        try{
            avgWomanAge=sumOfWomanAge/numOfWoman;
        }catch(Exception e){
        }
    }

    public void saveStatistic() {
        PrintWriter writer3=null;
        try {
            writer3 = new PrintWriter(path+"statistic.txt");
            writer3.println(numOfPatients);
            writer3.println(numOfMan);
            writer3.println(numOfWoman);
            writer3.println(sumOfAge);
            writer3.println(sumOfManAge);
            writer3.println(sumOfWomanAge);
            writer3.println(treatmentInProgress);
            writer3.println(healed);
            writer3.println(partiallyHealed);
            writer3.println(notHealed);
            writer3.println(other);
            writer3.println(sumOfTreatments);
        } catch (FileNotFoundException ex) {
            System.out.println("Can't make statistic.txt");
        }

        writer3.close();
    }  

    private void setPath() {
        CodeSource codeSource = Controller.class.getProtectionDomain().getCodeSource();
        File jarFile = null;
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        String jarDir = jarFile.getParentFile().getPath();    
        jarDir+="/Betegek/";
        path=jarDir;
    }

    private Boolean checkLicence() {
	Calendar today = Calendar.getInstance();
	Calendar outdate = new GregorianCalendar(2118, 9, 4);
        if(today.before(outdate)){
            return true;
        }else{
            return false;
        }
    }
}
