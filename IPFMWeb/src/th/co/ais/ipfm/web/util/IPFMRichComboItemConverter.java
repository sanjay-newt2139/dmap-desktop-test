package th.co.ais.ipfm.web.util;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

public class IPFMRichComboItemConverter implements javax.faces.convert.Converter{

	@SuppressWarnings("unchecked")
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		//System.out.println("IPFMRichComboItemConverter value = " + value);
		List<SelectItem> selectItems = (List<SelectItem>)component.getAttributes().get("selectItems");
		Iterator<SelectItem> iterator = selectItems.iterator();
		while(iterator.hasNext()) {
			SelectItem selItem = iterator.next();
			IPFMRichComboItem comboBoxItem = (IPFMRichComboItem)selItem.getValue();
			
			if(comboBoxItem.getLabel().equalsIgnoreCase(value)) {
				return comboBoxItem;
			}
		}
//		return null;
		
		IPFMRichComboItem comboBoxItem = new IPFMRichComboItem(null,value);
		return comboBoxItem;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
//		System.out.println("IPFMRichComboItemConverter getAsString = " + value);
		if(value == null) {
			return "";
		}
		IPFMRichComboItem comboBoxItem = (IPFMRichComboItem) value;
		return comboBoxItem.getLabel();
	}

}
