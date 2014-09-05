package recipes.serialisation;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import recipes.domain.RecipeBook;

public class RecipeBookAdaptor extends XmlAdapter<String, RecipeBook>{

	@Override
	public String marshal(RecipeBook v) throws Exception {
		return v.getName();
	}

	@Override
	public RecipeBook unmarshal(String v) throws Exception {
		RecipeBook book = new RecipeBook();
		book.setName(v);
		return book;
	}

}
