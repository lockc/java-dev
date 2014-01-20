package recipes.serialisation;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBException;

public interface Serialiser {

	public String serialise(Object object) throws JAXBException;
	
	public Object deserialise(String value, Class<?> clazz) throws JAXBException, UnsupportedEncodingException;
}
