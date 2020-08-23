package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class option_verification {
	WebDriver driver;
	
	public option_verification(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver,this);
	}
	
	@FindBy(css="input[name=search_query]") public WebElement search;
	@FindBy(xpath="//*[@id='homefeatured']/li[4]/div/div[1]/div/a[1]") public WebElement view_product;
	@FindBy(xpath="//*[@id='block_various_links_footer']/ul/li[4]/a") public WebElement ouer_stories;
	@FindBy(xpath="//*[@id='block_various_links_footer']/ul/li[1]/a") public WebElement specials;
	@FindBy(xpath="//*[@id='block_various_links_footer']/h4") public WebElement information;
	@FindBy(xpath="//*[@id='footer']/div/section[2]/h4") public WebElement catalog;
	@FindBy(xpath="//*[@id='block_various_links_footer']/ul/li[5]/a") public WebElement contact_us;
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a") public WebElement sign_in;
	
	
	public boolean search(){
		return search.isDisplayed();
	}
	public boolean view_product(){
		return view_product.isDisplayed();
	}
	
	public String ouer_stories(){
		return ouer_stories.getText();
	}
	public String specials(){
		return specials.getText();
	}
	public String information(){
		return information.getText();
	}
	public String catalog(){
		return catalog.getText();
	}
	public String contact_us(){
		return contact_us.getText();
	}
	public String sign_in(){
		return sign_in.getText();
	}
}
