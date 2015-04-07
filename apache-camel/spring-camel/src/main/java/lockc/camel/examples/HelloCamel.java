package lockc.camel.examples;

import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * http://camel.apache.org/spring.html
 * http://camel.apache.org/bean-integration.html
 * http://camel.apache.org/pojo-producing.html
 * http://camel.apache.org/using-exchange-pattern-annotations.html
 * 
 */
@Component
public class HelloCamel {
    
    private static final Logger LOG = Logger.getLogger(HelloCamel.class);
    
    @Produce(uri = "test-jms:queue:camel-test")
    private MyProducer producer;
    
    public void doSomething() {
    
        for (int i = 0; i < 10; i++) {
            String message = "Test Message: " + i;
            LOG.info("Sending message: " + message);
            producer.sendMessage(message);
        }
    }
    
    public static void main(String[] args) throws Exception {
    
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        HelloCamel helloCamel = springContext.getBean(HelloCamel.class);
        helloCamel.doSomething();
                
        // wait a bit and then stop
        Thread.sleep(1000);
        
        CamelContext camelContext = (CamelContext) springContext.getBean("camel5a");
        camelContext.stop();
        
        camelContext = (CamelContext) springContext.getBean("camel5b");
        camelContext.stop();
     
        springContext.close();
    }
    
}
