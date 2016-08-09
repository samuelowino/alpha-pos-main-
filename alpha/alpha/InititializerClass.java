/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha;

import salesinventory.DrugInventoryTransactions;
/**
 * @author Samuel Owino
 */

import javax.swing.*;

public class InititializerClass {

    public static void main(String[] args) {
        if (DrugInventoryTransactions.getApplicationContext() == 0) {
            LogInScreen logInScreen = new LogInScreen(true);
        } else if (DrugInventoryTransactions.getApplicationContext() == 1) {
            while (true) {
                JOptionPane.showMessageDialog(null, "404 ERROR \n Server Not Found...");
            }
        }
    }
}
