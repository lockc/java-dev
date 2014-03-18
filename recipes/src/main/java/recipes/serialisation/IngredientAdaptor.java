package recipes.serialisation;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import recipes.domain.Ingredient;

public class IngredientAdaptor extends XmlAdapter<String, Ingredient> {

	@Override
	public String marshal(Ingredient v) throws Exception {
		return v.getDescription();
	}

	@Override
	public Ingredient unmarshal(String v) throws Exception {
		Ingredient i = new Ingredient();
		i.setDescription(v);
		return i;
	}

}
