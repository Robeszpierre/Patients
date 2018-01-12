
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
    
    static Controller controller=new Controller();
    private MainFrame mainFrame;
    private NewPatientPersonalDatas newPatientPersonalDatas;
    private NewPatientQuestions newPatientQuestions;
    private NewPatientMedicalHistory newJPatientMedicalHistory;
    private NewPatientPresentComplaints newPatientPresentComplaints;
    private NewPatientPsychologicalAnamnesis newPatientPsychologicalAnamnesis;
    private NewPatientTongue newPatientTongue;
    private NewPatientPulse newPatientPulse;
    private NewPatientDiagnose newPatientDiagnose;
    
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
        newPatientPersonalDatas = new NewPatientPersonalDatas();
        newPatientPersonalDatas.setVisible(true);
    }
     
    public void newQuestions() {
        newPatientQuestions = new NewPatientQuestions();
        newPatientQuestions.setVisible(true);
    }
    
    public void newMedicalHistory(){
        newJPatientMedicalHistory=new NewPatientMedicalHistory();
        newJPatientMedicalHistory.setVisible(true);
    }
    
    public void newCompleints(){
        newPatientPresentComplaints=new NewPatientPresentComplaints();
        newPatientPresentComplaints.setVisible(true);
    }
    
    public void newAnamnesis(){
        newPatientPsychologicalAnamnesis=new NewPatientPsychologicalAnamnesis();
        newPatientPsychologicalAnamnesis.setVisible(true);
    }
    
    public void newTongue(){
        newPatientTongue=new NewPatientTongue();
        newPatientTongue.setVisible(true);
    }
    
    public void newPulse(){
        newPatientPulse=new NewPatientPulse();
        newPatientPulse.setVisible(true);
    }
    
    public void newDiagnose(){
        newPatientDiagnose=new NewPatientDiagnose();
        newPatientDiagnose.setVisible(true);
    }
}
