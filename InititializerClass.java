/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha;

import salesinventory.DrugInventoryTransactions;

/**
 * @author Samuel Owino
 */import javax.swing.*;
public class InititializerClass {
    
    public static void main(String[] args) {
        if(DrugInventoryTransactions.getApplicationContext() == 0){
            LogInScreen mainPOSInterface = new LogInScreen(true);
        }else if(DrugInventoryTransactions.getApplicationContext() == 1){
            while(true){
                JOptionPane.showMessageDialog(null,"Connot Connect to Alpha Restaurant POS.sql...");
            }
        }
    }
}
