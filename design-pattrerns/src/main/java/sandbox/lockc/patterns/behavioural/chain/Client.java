package sandbox.lockc.patterns.behavioural.chain;

public class Client
{

    public static void main(String[] args)
    {
        ChainHandler chainHandler3 = new ConcreteThreeChainHandler(null);
        ChainHandler chainHandler2 = new ConcreteTwoChainHandler(chainHandler3);
        ChainHandler chainHandler1 = new ConcreteOneChainHandler(chainHandler2);
        
        
        chainHandler1.handle();
        
        
        
        
    }

}
