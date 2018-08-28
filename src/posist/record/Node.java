/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posist.record;

import java.util.ArrayList;

/**
 *
 * @author mca
 */
public class Node {
    public Record record;
    public ArrayList<Record> children;

    public ArrayList<Record> getChildren() {
        return children;
    }

    public Record getRecord() {
        return record;
    }
 
}
