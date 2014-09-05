package recipes.serialisation;

public interface Serialiser {

	public String serialise(Object object) throws SerialisationException;
	
	public Object deserialise(String value, Class<?> clazz) throws SerialisationException;
}
