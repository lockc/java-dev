package sandbox.lockc.patterns.behavioural.chain.other;

import java.util.ArrayList;
import java.util.List;

public class Request implements Chainable
{
    public List<ChainHandler> chain = new ArrayList<ChainHandler>();
        
    private short index = 0;
    
    @Override
    public void doChain() {
        if(chain.size() == index) {
            System.out.println("End of chain.");
            return;
        }
        chain.get(index++).handle(this);
    }

}
