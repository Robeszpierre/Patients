package NewPatient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author robeszpierre
 */
public class DragListener implements  DropTargetListener{
    
    JLabel imageLabel=new JLabel();
    JLabel pathlabel=new JLabel();
    String imgName;
    BufferedImage img=null; 
    
    public DragListener(JLabel image, JLabel path, String name){
        try {
            imageLabel=image;
            pathlabel=path;
            imgName=name;
            img=ImageIO.read(new File(Controller.controller.path+Controller.controller.idNumber +File.separatorChar+ imgName +".jpg"));       
        } catch (IOException ex) {
            try {
                img=ImageIO.read(new File(Controller.controller.path+"img"+File.separatorChar+"noimage.jpg"));
            } catch (IOException ex1) {
                Logger.getLogger(DragListener.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }
    
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
        
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        
    }

    //get dropped image and add to label
    @Override
    public void drop(DropTargetDropEvent ev) {
        ev.acceptDrop(DnDConstants.ACTION_COPY);
        
        Transferable t=ev.getTransferable();
        DataFlavor[] df=t.getTransferDataFlavors();
        
        for(DataFlavor f:df){
            try{
                if(f.isFlavorJavaFileListType()){
                    List<File> files=(List<File>) t.getTransferData(f);
                    
                    for(File file: files){
                        displayImage(file.getPath());
                    }
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    
      

    private void displayImage(String path) {
        Image dimg=null;
        try{
            img=ImageIO.read(new File(path));
            dimg = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),
            Image.SCALE_SMOOTH);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        ImageIcon icon=new ImageIcon(dimg);
        imageLabel.setIcon(icon);
        pathlabel.setText(path);
    }
    
    public void save(){
        try {
            File outputfile = new File(Controller.controller.path + Controller.controller.idNumber +File.separatorChar+ imgName +".jpg");
            ImageIO.write(img, "jpg", outputfile);
        } catch (IOException ex) {
            Logger.getLogger(DragListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
