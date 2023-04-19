/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.mobicents.protocols.api.IpChannelType;
import org.mobicents.protocols.sctp.*;
/**
 *
 * @author vineet
 */
public class SS7Client {

    // SCTP
    private ManagementImpl sctpManagement;
    private static final Logger logger = Logger.getLogger(SS7Client.class);
    
    public void main(String[] args) {
        try {
            initSCTP(IpChannelType.SCTP);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SS7Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initSCTP(IpChannelType ipChannelType) throws Exception {
		logger.debug("Initializing SCTP Stack ....");
		this.sctpManagement = new ManagementImpl("Client");
		this.sctpManagement.setSingleThread(true);
		this.sctpManagement.setConnectDelay(10000);
		this.sctpManagement.start();
		this.sctpManagement.removeAllResourses();

		// 1. Create SCTP Association
		sctpManagement.addAssociation("127.0.0.1", 8889, "127.0.0.1", 5896, "Assco",ipChannelType, null);
		logger.debug("Initialized SCTP Stack ....");
	}
}
