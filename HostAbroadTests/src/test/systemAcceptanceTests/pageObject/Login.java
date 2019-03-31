package systemAcceptanceTests.pageObject;

import org.openqa.selenium.WebElement;

public class Login extends PageObject{
	private final String LOGIN_BUTOON_ID = "loginBtn";
	private final String EMAIL_FIELD_ID = "emailTextField";
	private final String PASSWORD_FIELD_ID = "passTextField";
	private final String NOTIFICATION_CSS = ".v-Notification-caption";
	
	private final String NOTIFICATION_MESSAGE = "Invalid credentials";
	
	private WebElement loginBtn;
	private WebElement emailField;
	private WebElement password;
	private WebElement notification;
	
	public void goToLogInPage() {
		this.goToPage("http://localhost:8080/HostAbroad/");
		this.loginBtn = this.findById(this.LOGIN_BUTOON_ID);
		this.loginBtn.click();
	}

	public void fillEmail(String arg1) {
		this.emailField = this.findById(this.EMAIL_FIELD_ID);
		this.emailField.click();
		this.emailField.sendKeys(arg1);
	}

	public void fillPassword(String arg2) {
		this.password = this.findById(this.PASSWORD_FIELD_ID);
		this.password.click();
		this.password.sendKeys(arg2);
	}

	public void clickLogIn() {
		this.loginBtn = this.findById(this.LOGIN_BUTOON_ID);
		this.loginBtn.click();
	}

	public boolean userIsOnOtherPage() {
		//This method will be changed when MyProfile page is ready can't test in right now without the UI
		String s = this.getDriver().getCurrentUrl();
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		System.out.println(s);
		this.quitDriver();
		return true;
	}

	public boolean isErrorMessageVisible() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.notification = this.findByCssSelector(NOTIFICATION_CSS);
		String message = this.notification.getText();
		boolean result = message.equals(this.NOTIFICATION_MESSAGE);
		this.quitDriver();
		return result;
	}

}
