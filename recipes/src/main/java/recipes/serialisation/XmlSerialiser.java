package recipes.serialisation;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

public class XmlSerialiser implements Serialiser {

	private static final String ENCODING = "UTF-8";
	
	@Override
	public String serialise(Object object) throws JAXBException {
		
		JAXBContext context = JAXBContext.newInstance(object.getClass().getPackage().getName());
		
		context.createMarshaller().marshal(object, System.out);
		
		return null;
	}
	
	@Override
	public Object deserialise(String value, Class<?> clazz) throws JAXBException, UnsupportedEncodingException {
		
		JAXBContext context = JAXBContext.newInstance(clazz.getPackage().getName());
		
		JAXBElement<?> jaxbElement = 
				context.createUnmarshaller().unmarshal(
						new StreamSource(
								new ByteArrayInputStream(value.getBytes(ENCODING))), clazz);
		
		return jaxbElement.getValue();
	}


}
