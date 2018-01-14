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
    
    public DragListener(JLabel image, JLabel path){
        imageLabel=image;
        pathlabel=path;
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
    
    BufferedImage img=null;

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
    
    public void save() throws IOException{
        File outputfile = new File(Controller.controller.path + Controller.controller.idNumber +File.separatorChar+ "tongue.png");
        ImageIO.write(img, "png", outputfile);
    }
}
