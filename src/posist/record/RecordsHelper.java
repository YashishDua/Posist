/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posist.record;

import java.security.Key;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import posist.owner.Owner;
import posist.record.*;

public class RecordsHelper {
     static int curretnNodeNumber = 0;
     ArrayList<Record> records;

    public RecordsHelper(ArrayList<Record> records) {
        this.records = records;
    }

    public Record createRecord(Owner currentOwner, float value, int nodeNumber) {
       
        String timeStamp = String.valueOf(new Timestamp(System.currentTimeMillis()));
        String id = UUID.randomUUID().toString();
        String data = encrypt(currentOwner.getId() + value + currentOwner.getName(), currentOwner.getId());
        String genesisReferenceNodeId;
        curretnNodeNumber++;
        if(records.size() != 0) {
            genesisReferenceNodeId = records.get(0).getGenesisReferenceNodeId();
        } else {
            genesisReferenceNodeId = id;
        }
        String referenceNodeId = getParentNodeId(nodeNumber);
        String[] toBeHashed = {timeStamp, data, id, referenceNodeId,
            genesisReferenceNodeId, String.valueOf(curretnNodeNumber)};
        String hashValue = hash(toBeHashed);
        return new Record(timeStamp, data, curretnNodeNumber, id, referenceNodeId, genesisReferenceNodeId, hashValue);
    }
    
    private String getChildrenReferenceNodesId(int nodeNumber) {
        for(Record record : records) {
            //
        }
        return "";
    }
    
    private String getParentNodeId(int nodeNumber) {
        for(Record record: records) {
            if(record.getNodeNumber() == nodeNumber)
                return record.getNodeId();
        }
        return "";
    }
    
    private String hash(String[] values) {
        int hashCode = -1;
        for(String s: values)
            hashCode += s.hashCode();
        return String.valueOf(hashCode);
    }

    public static String encrypt(String data, String ownerEncryptionKey) {
        String key = ownerEncryptionKey;
        try {
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return new String(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String decrypt(String encryptedData, String ownerDecryptionKey) {
        String key = ownerDecryptionKey;
        try {
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] encrypted = encryptedData.getBytes();
            String decrypted = new String(cipher.doFinal(encrypted));
            return decrypted;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
