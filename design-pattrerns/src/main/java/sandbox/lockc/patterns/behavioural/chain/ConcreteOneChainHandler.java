package sandbox.lockc.patterns.behavioural.chain;

import java.util.Objects;

public class ConcreteOneChainHandler extends AbstractChainHandler
{
    public ConcreteOneChainHandler(ChainHandler successor)
    {
        super(successor);
    }    
    
    @Override
    public void handle()
    {
        System.out.println(this.getClass().getSimpleName());
        if(Objects.nonNull(successor)) {
            successor.handle();
        }
    }

}
