package systemAcceptanceTests.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class EditPersonalInfo extends PageObject {
	
	private final String TEXT_FIELD_FULL_NAME = "ProfileFullName";
	private final String TEXT_FIELD_USERNAME = "ProfileUsername";
	private final String TEXT_FIELD_EMAIL = "ProfileEmail";
	private final String TEXT_FIELD_DESCRIPTION = "ProfileDescription";
	private final String COMBOBOX_GENDER = "gwt-uid-9";
	private final String COMBOBOX_LANGUAGES = "gwt-uid-11";
	private final String BUTTON_PROFILE_CHANGE_IMAGE = "ProfileChangeImg";
	private final String BUTTON_SAVE = "ProfileSave";
	
	
	//private final String REGISTER_FAILED_MESSAGE = "Register failed";
	private final String INCORRECT_FIELDS_MESSAGE = "Please fill all of the fields correctly. Then click save.";
	private final String EDIT_SUCCESS_MESSAGE = "Changes saved!";
	private final String RESULT_NOTIFICACION_CLASS = ".v-Notification-caption";
	
	
	private final String MALE = "Male";
	private final String FEMALE = "Female";
	private final String OTHER = "Other";
	
	private final String SPANISH = "Spanish";
	private final String SAHARAWI = "Saharawi";
	
	
	private WebElement fullNameTextField;
	private WebElement usernameTextField;
	private WebElement emailTextField;
	private WebElement genderTextField;
	private WebElement languageTextField;
	private WebElement descriptionTextField;
	private WebElement saveBtn;
	private WebElement resetBtn;
	private WebElement resultFirst;
	private WebElement resultNotification;
	
	public void fillFormProperly() {
		fullNameTextField = findById(TEXT_FIELD_FULL_NAME);
		fullNameTextField.sendKeys("fullName");
		
		usernameTextField = findById(TEXT_FIELD_USERNAME);
		usernameTextField.sendKeys("name");
		
		emailTextField = findById(TEXT_FIELD_EMAIL);
		emailTextField.sendKeys("test@hostabroad.com");
		
		genderTextField = findById(COMBOBOX_GENDER);
		genderTextField.sendKeys(MALE);
		genderTextField.sendKeys(Keys.ENTER);
		
		languageTextField = findById(COMBOBOX_LANGUAGES);
		languageTextField.sendKeys(SPANISH);
		languageTextField.sendKeys(Keys.ENTER);
		
		descriptionTextField = findById(TEXT_FIELD_DESCRIPTION);
		descriptionTextField.sendKeys("description");
		
	}
	
	public void fillFormIncorrectly() {
		fullNameTextField = findById(TEXT_FIELD_FULL_NAME);
		fullNameTextField.sendKeys("Test fullName");
		
		usernameTextField = findById(TEXT_FIELD_USERNAME);
		usernameTextField.sendKeys("Test");
		
		emailTextField = findById(TEXT_FIELD_EMAIL);
		emailTextField.sendKeys("test@hostabr");
		
		genderTextField = findById(COMBOBOX_GENDER);
		genderTextField.sendKeys("something");
		genderTextField.sendKeys(Keys.ENTER);
		
		languageTextField = findById(COMBOBOX_LANGUAGES);
		languageTextField.sendKeys("weird language");
		languageTextField.sendKeys(Keys.ENTER);
		
		descriptionTextField = findById(TEXT_FIELD_DESCRIPTION);
		descriptionTextField.sendKeys("description");
	}

	public void clickSave() {
		saveBtn = this.findById(this.BUTTON_SAVE);
		saveBtn.click();
	}

	public boolean checkUserEdited() {
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
