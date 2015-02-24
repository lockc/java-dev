package sandbox.lockc.patterns.behavioural.chain;

import java.util.Objects;

public class ConcreteTwoChainHandler extends AbstractChainHandler
{
    
    public ConcreteTwoChainHandler(ChainHandler successor)
    {
    
        super(successor);
    }
    
    @Override
    public void handle()
    {
    
        System.out.println(this.getClass().getSimpleName());
        if (Objects.nonNull(successor)) {
            successor.handle();
        }
    }
    
}
