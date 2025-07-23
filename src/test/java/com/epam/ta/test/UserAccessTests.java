package com.epam.ta.test;

import com.epam.ta.model.User;
import com.epam.ta.page.LoginPage;
import com.epam.ta.service.UserCreator;
import org.junit.Assert;
import org.junit.Test;


public class UserAccessTests extends CommonConditions {
	private final String USERNAME_ERROR = "Username is required";
	private final String PASSWORD_ERROR = "Password is required";

	/*Type any credentials into "Username" and "Password" fields.
	Clear the inputs.
	Hit the "Login" button.
	Check the error messages: "Username is required".*/
	@Test
	public void uc1(){
		User testUser = UserCreator.withCredentialsFromProperty();
		boolean usernameError = new LoginPage(driver)
				.openPage()
				.putDataInFields(testUser)
				.clearAllFields()
				.pressSubmit()
				.checkErrorContains(USERNAME_ERROR);
		Assert.assertTrue( "Username error not found", usernameError);
	}

	/*Type any credentials in username.
	Enter password.
	Clear the "Password" input.
	Hit the "Login" button.*/
	@Test
	public void uc2(){
		User testUser = UserCreator.withCredentialsFromProperty();
		boolean passwordError = new LoginPage(driver)
				.openPage()
				.putDataInFields(testUser)
				.clearPasswordField()
				.pressSubmit()
				.checkErrorContains(PASSWORD_ERROR);
		Assert.assertTrue( "Password error not found", passwordError);
	}

	/*Type credentials in username which are under Accepted username are sections.
	Enter password as secret sauce.
	Click on Login and validate the title “Swag Labs” in the dashboard.*/
	@Test()
	public void uc3(){
		User testUser = UserCreator.withGoodCredentialsFromProperty();
		boolean successLabelVisibility = new LoginPage(driver)
				.openPage()
				.login(testUser)
				.checkAppLogo();
		Assert.assertTrue("Label not found", successLabelVisibility);
	}
}
