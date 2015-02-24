package sandbox.lockc.patterns.behavioural.chain;

import java.util.Objects;

public class ConcreteThreeChainHandler extends AbstractChainHandler
{
    public ConcreteThreeChainHandler(ChainHandler successor)
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
