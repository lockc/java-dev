package sandbox.lockc.patterns.behavioural.chain;

public abstract class AbstractChainHandler implements ChainHandler
{
    
    protected ChainHandler successor;

    protected AbstractChainHandler(ChainHandler successor)
    {
    
        this.successor = successor;
    }
    
}
