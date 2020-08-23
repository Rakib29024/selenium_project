package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class product_purchase {
	WebDriver driver;
	
	public product_purchase(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(css="input[name=search_query]") public WebElement search_box;
	@FindBy(xpath="//*[@id='searchbox']/button") public WebElement search_btn;
	@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[1]/div/a[1]") public WebElement view_product;
	@FindBy(xpath="//*[@id='our_price_display']") public WebElement price;
	@FindBy(xpath="//*[@id='color_14']") public WebElement color;
	@FindBy(xpath="//*[@id='add_to_cart']/button") public WebElement add_to_cart;
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a") public WebElement proceed_to_checkout;
	@FindBy(xpath="//*[@id='center_column']/p[2]/a[1]") public WebElement proceed_to_checkout2;
	@FindBy(xpath="//*[@id='center_column']/form/p/button") public WebElement proceed_to_checkout3;
	@FindBy(xpath="//*[@id='cgv']") public WebElement agree;
	@FindBy(xpath="//*[@id='form']/p/button") public WebElement proceed_to_checkout4;
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div[2]/table/tbody/tr[1]/td[4]/span/span") public WebElement price_status;
	
	public void search_box(String value){
		search_box.sendKeys(value);
	}
	public void search_btn(){
		search_btn.click();
	}
	
	public void view_product(){
		view_product.click();
	}
	
	public String price(){
		return price.getText();
	}
	
	public void color(){
		color.click();
	}
	
	public void add_to_cart(){
		add_to_cart.click();
	}
	
	public void proceed_to_checkout(){
		proceed_to_checkout.click();
	}
	
	public void proceed_to_checkout2(){
		proceed_to_checkout2.click();
	}
	public void proceed_to_checkout3(){
		proceed_to_checkout3.click();
	}
	public void agree(){
		agree.click();
	}
	public void proceed_to_checkout4(){
		proceed_to_checkout4.click();
	}
	public String price_status(){
		return price_status.getText();
	}
}
