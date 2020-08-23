package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class subscription {

	WebDriver driver;
	
	public subscription(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(css="input[name=email]") public WebElement email;
	@FindBy(xpath="//*[@id='newsletter_block_left']/div/form/div/button") public WebElement submit;
	@FindBy(xpath="//*[@id='columns']/p") public WebElement status;

	public void email(String value){
		email.sendKeys(value);
	}
	
	
	public void submit(){
		submit.click();
	}
	
	public String status(){
		return status.getText();
	}
}
