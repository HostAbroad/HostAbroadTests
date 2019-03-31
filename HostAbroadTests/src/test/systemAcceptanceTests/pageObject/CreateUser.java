package systemAcceptanceTests.pageObject;

import org.openqa.selenium.WebElement;

public class CreateUser extends PageObject {
	
	private final String TEXT_FIELD_FULL_NAME = "Full nameTextField";
	private final String TEXT_FIELD_NICKNAME = "NicknameTextField";
	private final String TEXT_FIELD_EMAIL = "EmailTextField";
	private final String TEXT_FIELD_PASSWORD = "passwordField";
	private final String BUTTON_RESET = "resetBtn";
	private final String BUTTON_SAVE = "saveBtn";
	private final String REGISTER_FAILED_MESSAGE = "Register failed";
	private final String INCORRECT_FIELDS_MESSAGE = "Please fill all of the fields correctly. Then click save.";
	private final String REGISTER_SUCCESS_MESSAGE = "User successfully created.";
	private final String RESULT_NOTIFICACION_CLASS = ".v-Notification-caption";
	
	private WebElement fullNameTextField;
	private WebElement nicknameTextField;
	private WebElement emailTextField;
	private WebElement passwordTextField;
	private WebElement saveBtn;
	private WebElement resetBtn;
	private WebElement resultFirst;
	private WebElement resultNotification;
	
	public void fillFormProperly() {
		fullNameTextField = findById(TEXT_FIELD_FULL_NAME);
		fullNameTextField.sendKeys("Test fullName");
		
		nicknameTextField = findById(TEXT_FIELD_NICKNAME);
		nicknameTextField.sendKeys("Test");
		
		emailTextField = findById(TEXT_FIELD_EMAIL);
		emailTextField.sendKeys("test@hostabroad.com");
		
		passwordTextField = findById(TEXT_FIELD_PASSWORD);
		passwordTextField.sendKeys("Test1234");
	}
	
	public void fillFormIncorrectly() {
		fullNameTextField = findById(TEXT_FIELD_FULL_NAME);
		fullNameTextField.sendKeys("Test fullName");
		
		nicknameTextField = findById(TEXT_FIELD_NICKNAME);
		nicknameTextField.sendKeys("Test");
		
		emailTextField = findById(TEXT_FIELD_EMAIL);
		emailTextField.sendKeys("test@hostabr");
		
		passwordTextField = findById(TEXT_FIELD_PASSWORD);
		passwordTextField.sendKeys("Test1");
	}

	public void clickSave() {
		saveBtn = this.findById(this.BUTTON_SAVE);
		saveBtn.click();
	}
	
	public void clickReset() {
		this.resetBtn = this.findById(this.BUTTON_RESET);
		this.resetBtn.click();
	}

	public boolean checkUserCreated() {
		resultNotification = this.findByCssSelector(RESULT_NOTIFICACION_CLASS);
		String resultText = this.resultNotification.getText();
		this.quitDriver();
		return resultText.equals(this.REGISTER_SUCCESS_MESSAGE);
	}
	
	public boolean checkUserNotCreated() {
		resultNotification = this.findByCssSelector(RESULT_NOTIFICACION_CLASS);
		String resultText = this.resultNotification.getText();
		this.quitDriver();
		return resultText.equals(this.REGISTER_FAILED_MESSAGE);
	}
	
	public boolean checkIncorrectFields() {
		resultNotification = this.findByCssSelector(RESULT_NOTIFICACION_CLASS);
		String resultText = this.resultNotification.getText();
		this.quitDriver();
		return resultText.equals(this.INCORRECT_FIELDS_MESSAGE);
	}
	
	public boolean checkEmptyFields() {
		boolean result = (fullNameTextField.getText().equals("")) &&
						 (nicknameTextField.getText().equals("")) &&
						 (emailTextField .getText().equals("")) &&
						 (passwordTextField.getText().equals(""));
		this.quitDriver();
		return 	result;
	}

}
