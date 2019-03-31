package systemAcceptanceTests.pageObject;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EditHost extends PageObject {

	private final Logger logger = LoggerFactory.getLogger(CreateUser.class);
	
	private final String INTERESTS_BUTTON = "gwt-uid-16";
	
	private final String CHECKBOX_INT_1 = "gwt-uid-22";
	private final String CHECKBOX_INT_2 = "gwt-uid-23";
	private final String CHECKBOX_INT_3 = "gwt-uid-24";
	private final String CHECKBOX_INT_4 = "gwt-uid-25";

	private final String BUTTON_SAVE = "saveButton";
	
	private final String INCORRECT_MESSAGE = "Error, We couldnt save your interests";
	private final String SUCCESS_MESSAGE = "Saved";
	
	private final String RESULT_NOTIFICACION_CLASS = ".v-Notification-caption";
	
	private WebElement interestsButton;
	
	private WebElement checkboxInt1;
	private WebElement checkboxInt2;
	private WebElement checkboxInt3;
	private WebElement checkboxInt4;
	
	private WebElement saveButton;


	private WebElement resultNotification;
	
	
	public void selectSomeChecks() {
		checkboxInt1 = this.findById(CHECKBOX_INT_1);
		checkboxInt1.click();
		checkboxInt2 = this.findById(CHECKBOX_INT_2);
		checkboxInt2.click();
		checkboxInt3 = this.findById(CHECKBOX_INT_3);
		checkboxInt3.click();
	}

	public void clickSave() {
		saveButton = this.findById(this.BUTTON_SAVE);
		saveButton.click();
	}
	

	public boolean checkSuccess() {
		resultNotification = this.findByCssSelector(RESULT_NOTIFICACION_CLASS);
		String resultText = this.resultNotification.getText();
		System.out.println(resultText);
		return resultText.equals(this.SUCCESS_MESSAGE);
	}
	
	public boolean checkFailure() {
		resultNotification = this.findByCssSelector(RESULT_NOTIFICACION_CLASS);
		String resultText = this.resultNotification.getText();
		logger.info(resultText);
		return resultText.equals(this.INCORRECT_MESSAGE);
	}
	
	public void goToInterests() {
		this.goToPage("http://localhost:8080/HostAbroad/my_profile");
		interestsButton = this.findById(INTERESTS_BUTTON);
		interestsButton.click();
	}
	
}
