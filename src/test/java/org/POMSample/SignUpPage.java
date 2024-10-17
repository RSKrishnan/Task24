package org.POMSample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
	//@findBy method is used to get the xpath
	@FindBy(css="a#signin2")
	public static WebElement login;
	
	@FindBy(id="sign-username")
	public static WebElement username;
	
	@FindBy(id="sign-password")
	public static WebElement password;
	
	@FindBy(xpath="//button[text()='Sign up']")
	public static WebElement submit;
	
	
}
