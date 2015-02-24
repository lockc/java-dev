package sandbox.lockc.patterns.behavioural.chain.other;

public class Client
{

    public static void main(String[] args)
    {
        ChainHandler chainHandler3 = new ConcreteThreeChainHandler();
        ChainHandler chainHandler2 = new ConcreteTwoChainHandler();
        ChainHandler chainHandler1 = new ConcreteOneChainHandler();
        
        Request request = new Request();
        request.chain.add(chainHandler1);
        request.chain.add(chainHandler2);
        request.chain.add(chainHandler3);
        request.chain.add(chainHandler1);
        
        request.doChain();
    }

}
