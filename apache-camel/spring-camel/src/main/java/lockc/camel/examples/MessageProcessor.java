package lockc.camel.examples;

import org.apache.log4j.Logger;

/**
 * A bean to process some messages
 *
 */
public class MessageProcessor {
    
    private static final Logger LOG = Logger.getLogger(MessageProcessor.class);
    
    public String process(String message) {
        LOG.info(String.format("Processing message %s", message));
        return message + " - processed!";
    }
}
