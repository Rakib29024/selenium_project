package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class product_add {
	WebDriver driver;
	
	public product_add(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(xpath="//*[@id='homefeatured']/li[2]/div/div[2]/div[2]/a[1]/span") public WebElement add_to_cart_btn;
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/div[1]/img") public WebElement status;
	
	public void add_to_cart_btn(){
		add_to_cart_btn.click();
	}
	
	public boolean status(){
		return status.isDisplayed();
	}
}
