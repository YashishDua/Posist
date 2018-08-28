/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posist;

import java.util.ArrayList;
import java.util.Scanner;
import posist.record.*;
import posist.owner.Owner;

public class Posist {

    static Scanner s;
    static Owner currentOwner = null;
    ArrayList<Record> records;

    public static void main(String[] args) {
        s = new Scanner(System.in);
        createOwner();
        Posist posist = new Posist();
        boolean showMenu = true;
        while (showMenu) {
            showMenu = posist.showMenu();
        }

    }

    public boolean showMenu() {
        System.out.println("Select an option to proceed.");
        System.out.println("1. Create a record");
        System.out.println("2. Attach a node to a parent");
        int option = s.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter value of record");
                int value = s.nextInt();

                System.out.println("Enter node number of parent");
                int nodeNumber = s.nextInt();

                RecordsHelper recordsHelper = new RecordsHelper(records);
                Record createdRecord = recordsHelper.createRecord(currentOwner, value, nodeNumber);
                System.out.println("Created the record with node number! " + createdRecord.getNodeNumber());
                if(createdRecord.getNodeNumber() == 1) {
                    System.out.println("Also, this is the genisis node!");
                }
                return false;
            case 2:
                System.out.println("Enter nodeNumber of record");
                int childNodeNumber = s.nextInt();

                System.out.println("Enter nodeNumber of parent");
                int parentNodeNumber = s.nextInt();

                
                

        }
        return false;
    }

    public static void createOwner() {
        System.out.println("Hi, Let's setup your account!");
        System.out.println("What's your name?");
        String ownerName = s.next();
        currentOwner = new Owner(ownerName);
    }
}
