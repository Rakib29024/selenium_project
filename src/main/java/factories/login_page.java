package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_page {
	WebDriver driver;
	
	public login_page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a") public WebElement sign_in_link;
	@FindBy(css="input[name=email]") public WebElement email;
	@FindBy(css="input[name=passwd]") public WebElement password;
	@FindBy(xpath="//*[@id='SubmitLogin']") public WebElement submit;
	@FindBy(xpath="//*[@id='center_column']/h1") public WebElement login_status;
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[2]/a") public WebElement logout;
	
	public void sign_in_link(){
		sign_in_link.click();
	}
	
	public void email(String value){
		email.sendKeys(value);
	}
	
	public void password(String value){
		password.sendKeys(value);
	}
	
	public void submit(){
		submit.click();
	}
	
	public void logout(){
		logout.click();
	}
	
	public String login_status(){
		return login_status.getText();
	}
}
