package sandbox.lockc.patterns.behavioural.chain.other;

public class ConcreteThreeChainHandler implements ChainHandler
{

    @Override
    public void handle(Request request)
    {
        System.out.println(this.getClass().getSimpleName());
        
        request.doChain();
    }

}
