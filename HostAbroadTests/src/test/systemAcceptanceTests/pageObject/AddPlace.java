package systemAcceptanceTests.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class AddPlace extends PageObject {
	
	private final String TEXT_FIELD_ADDRESS = "PlaceAddress";
	private final String TEXT_FIELD_DESCRIPTION = "PlaceDescription";
	private final String COMBOBOX_FAMILY = "gwt-uid-9";
	private final String BUTTON_SAVE = "saveButton";
	
	
	//private final String REGISTER_FAILED_MESSAGE = "Register failed";
	private final String INCORRECT_FIELDS_MESSAGE = "Invalid Address";
	private final String EDIT_SUCCESS_MESSAGE = "Changes saved!";
	private final String RESULT_NOTIFICACION_CLASS = ".v-Notification-caption";
	
	
	private final String SINGLE = "Single";	
	
	private WebElement addressTextField;
	private WebElement descriptionTextField;
	private WebElement familyTextField;
	private WebElement saveBtn;
	private WebElement resultFirst;
	private WebElement resultNotification;
	
	public void fillFormProperly() {
		addressTextField = findById(TEXT_FIELD_ADDRESS);
		addressTextField.sendKeys("test address");
		
		descriptionTextField = findById(TEXT_FIELD_DESCRIPTION);
		descriptionTextField.sendKeys("description");
		
		familyTextField = findById(COMBOBOX_FAMILY);
		familyTextField.sendKeys(SINGLE);
		familyTextField.sendKeys(Keys.ENTER);	
	}
	
	public void fillFormIncorrectly() {
		addressTextField = findById(TEXT_FIELD_ADDRESS);
		addressTextField.sendKeys("test address");
		
		descriptionTextField = findById(TEXT_FIELD_DESCRIPTION);
		descriptionTextField.sendKeys("description");
		
		familyTextField = findById(COMBOBOX_FAMILY);
		familyTextField.sendKeys(SINGLE);
		familyTextField.sendKeys(Keys.ENTER);
	}

	public void clickSave() {
		saveBtn = this.findById(this.BUTTON_SAVE);
		saveBtn.click();
	}

	public boolean checkPlaceAdded() {
		resultNotification = this.findByCssSelector(RESULT_NOTIFICACION_CLASS);
		String resultText = this.resultNotification.getText();
		this.quitDriver();
		return resultText.equals(this.EDIT_SUCCESS_MESSAGE);
	}
	
	/*public boolean checkUserNotCreated() {
		resultNotification = this.findByCssSelector(RESULT_NOTIFICACION_CLASS);
		String resultText = this.resultNotification.getText();
		this.quitDriver();
		return resultText.equals(this.REGISTER_FAILED_MESSAGE);
	}*/
	
	public boolean checkIncorrectFields() {
		resultNotification = this.findByCssSelector(RESULT_NOTIFICACION_CLASS);
		String resultText = this.resultNotification.getText();
		this.quitDriver();
		return resultText.equals(this.INCORRECT_FIELDS_MESSAGE);
	}
}
