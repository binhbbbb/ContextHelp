package org.vaadin.jonatan.contexthelp.demo;

import java.util.Arrays;

import org.vaadin.jonatan.contexthelp.ContextHelp;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class AddressForm extends Form {

	private static final String companyHelp = "Fill the <i>company</i> field with the name of your company if your address is for official company business.";
	private static final String nameHelp = "Fill the <i>name</i> field with your name or the name of the contact person for your company.";
	private static final String streetHelp = "Fill the <i>street</i> field with the name of the street along with the street number, e.g. <b>Mallikuja 21 B 2</b>.";
	private static final String postalCodeHelp = "Fill the <i>Postal code</i> field with the postal code and city name, e.g. <b>20500 Turku</b>.";
	private static final String countryHelp = "Fill the <i>Country</i> field with the country where this address is situated.";

	private TextField companyField = new TextField("Company");
	private TextField nameField = new TextField("Name");
	private TextField streetField = new TextField("Street");
	private TextField postalCodeField = new TextField("Postal code");
	private TextField countryField = new TextField("Country");

	public class AddressFieldFactory extends DefaultFieldFactory {
		private static final long serialVersionUID = -442936912458334994L;

		public Field createField(Item item, Object propertyId,
				Component uiContext) {
			if ("company".equals(propertyId)) {
				return companyField;
			} else if ("name".equals(propertyId)) {
				return nameField;
			} else if ("street".equals(propertyId)) {
				return streetField;
			} else if ("postalCode".equals(propertyId)) {
				return postalCodeField;
			} else if ("country".equals(propertyId)) {
				return countryField;
			}
			return super.createField(item, propertyId, uiContext);
		}
	}

	public AddressForm() {
        // Set custom IDs to allow for easier TestBench testing
        companyField.setId("address.company");
        nameField.setId("address.name");
        streetField.setId("address.street");
        postalCodeField.setId("address.postalCode");
        countryField.setId("address.country");

		companyField.setNullRepresentation("");
		nameField.setNullRepresentation("");
		streetField.setNullRepresentation("");
		postalCodeField.setNullRepresentation("");
		countryField.setNullRepresentation("");

		ContextHelp contextHelp = ContextHelpDemoUI.getContextHelp();
		contextHelp.addHelpForComponent(companyField, companyHelp);
		contextHelp.addHelpForComponent(nameField, nameHelp);
		contextHelp.addHelpForComponent(streetField, streetHelp);
		contextHelp.addHelpForComponent(postalCodeField, postalCodeHelp);
		contextHelp.addHelpForComponent(countryField, countryHelp);

		Address address = new Address();
		BeanItem<Address> item = new BeanItem<Address>(address);
		setFormFieldFactory(new AddressFieldFactory());
		setItemDataSource(item, Arrays.asList("company", "name", "street",
				"postalCode", "country"));
	}
}
