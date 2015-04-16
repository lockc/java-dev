package sandbox.lockc.patterns.structural.decorator;


public abstract class ComponentDecorator implements Component {
    
    protected Component component;
    
    public ComponentDecorator(Component component) {
    
        this.component = component;
    }
    
    
    @Override
    public void draw() {
    
        component.draw();
        
    }
}
