package recipes.serialisation;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

import org.springframework.core.serializer.support.SerializationFailedException;
import org.springframework.stereotype.Component;

@Component
public class XmlSerialiser implements Serialiser {

	private static final String ENCODING = "UTF-8";
	
	
//	public static void main(String [] args) throws SerialisationException {
//		
//		
//		Recipe r = new Recipe();
//		r.setName("MMmm");
//		r.setRecipeId(1);
//		r.setPageNumber(34);
//		
//		List<Recipe> recipes = new ArrayList<>();
//		recipes.add(r);
//		
//		Recipes recipes2 = new Recipes();
//		recipes2.setRecipes(recipes);
//		
//		
//		String value = new XmlSerialiser().serialise(recipes2);
//		System.out.println(value);
//	}
	
	@Override
	public String serialise(Object object) throws SerialisationException {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(object.getClass().getPackage().getName());
			StringWriter writer = new StringWriter();
			context.createMarshaller().marshal(object, writer);
			String value = writer.toString();
			try {
				writer.close();
			} catch (IOException e) {
				
			}
			return value;
		} catch (JAXBException e1) {
			throw new SerializationFailedException("Serialisation error occurred", e1);
		}
	}
	
	@Override
	public Object deserialise(String value, Class<?> clazz) throws SerialisationException {
		
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(clazz.getPackage().getName());
			JAXBElement<?> jaxbElement = 
					context.createUnmarshaller().unmarshal(
							new StreamSource(
									new ByteArrayInputStream(value.getBytes(ENCODING))), clazz);
			
			return jaxbElement.getValue();
			
		} catch (JAXBException | UnsupportedEncodingException e) {
			throw new SerializationFailedException("Deserialisation error occurred", e);
		}
	}


}
