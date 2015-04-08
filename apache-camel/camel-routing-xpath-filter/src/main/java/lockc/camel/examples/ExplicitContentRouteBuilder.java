package lockc.camel.examples;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A router that originates from a JMS queue, expects XML and
 * checks for explicit content.  If the content is marked 
 * as explicit it multicasts it to another JMS queue and to 
 * file in parallel
 * 
 */
@Component
public class ExplicitContentRouteBuilder extends RouteBuilder {
    
    @Override
    public void configure() throws Exception {
        // @formatter:off
        from("test-jms:queue:content")
            .filter(xpath("//Content-Warning[@explicit='true']"))
            .multicast().parallelProcessing()
                .to("file://test", "test-jms:queue:explicit-content");
        // @formatter:on
    }
    
}
