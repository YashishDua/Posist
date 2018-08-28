/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package posist.record;

public class Record {
    String timestamp;
    String data;
    int nodeNumber;
    String nodeId;
    String referenceNodeId;
    String childReferenceNodeId;
    String genesisReferenceNodeId;
    String hashValue;

    public Record(String timestamp, String data, int nodeNumber, String nodeId,
            String referenceNodeId, String genesisReferenceNodeId, String hashValue) {
        this.timestamp = timestamp;
        this.data = data;
        this.nodeNumber = nodeNumber;
        this.nodeId = nodeId;
        this.referenceNodeId = referenceNodeId;
        this.genesisReferenceNodeId = genesisReferenceNodeId;
        this.hashValue = hashValue;
    }
    
    

    public String getChildReferenceNodeId() {
        return childReferenceNodeId;
    }

    public void setChildReferenceNodeId(String childReferenceNodeId) {
        this.childReferenceNodeId = childReferenceNodeId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getGenesisReferenceNodeId() {
        return genesisReferenceNodeId;
    }

    public void setGenesisReferenceNodeId(String genesisReferenceNodeId) {
        this.genesisReferenceNodeId = genesisReferenceNodeId;
    }

    public String getHashValue() {
        return hashValue;
    }

    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(int nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public String getReferenceNodeId() {
        return referenceNodeId;
    }

    public void setReferenceNodeId(String referenceNodeId) {
        this.referenceNodeId = referenceNodeId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    
    
}
