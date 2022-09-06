/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orchestrator;

/**
 *
 * @author hassa
 */
public class IntentDetails {
    String userID;
    String messageID;
    String responderID;
    
    public IntentDetails(String userID, String messageID, String responderID) {
        this.userID = userID;
        this.messageID = messageID;
        this.responderID = responderID;
    }
}
