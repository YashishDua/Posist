/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posist.owner;

import java.util.UUID;

/**
 *
 * @author mca
 */
public class Owner {
    private String id;
    private String name;

    public Owner(String name) {
        this.name = name;
        this.id =  UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
   
    
}
