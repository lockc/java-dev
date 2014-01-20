package sandbox.lockc.patterns.behavioural.observer;

import java.util.Observable;
import java.util.Observer;

public class TellMe implements Observer {

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println(arg1);
	}

}
