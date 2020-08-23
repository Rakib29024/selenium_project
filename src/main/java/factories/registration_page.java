package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class registration_page {
	WebDriver driver;
	
	
	public registration_page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a") public WebElement sign_in_link;
	@FindBy(css="input[name=email_create]") public WebElement email;
	@FindBy(xpath="//*[@id='SubmitCreate']") public WebElement email_submit;
	
	@FindBy(css="input[name=id_gender]") public WebElement gender;
	@FindBy(css="input[name=customer_firstname]") public WebElement firstname;
	@FindBy(css="input[name=customer_lastname]") public WebElement lastname;
	@FindBy(css="input[name=passwd]") public WebElement password;
	@FindBy(css="input[name=newsletter]") public WebElement check_box_1;
	@FindBy(css="input[name=optin]") public WebElement check_box_2;
	@FindBy(css="input[name=firstname]") public WebElement add_firstname;
	@FindBy(css="input[name=lastname]") public WebElement add_lastname;
	@FindBy(css="input[name=company]") public WebElement company;
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[1]/div/select") public WebElement days;
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[2]/div/select") public WebElement months;
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/form/div[1]/div[6]/div/div[3]/div/select") public WebElement years;
	@FindBy(xpath="//*[@id='id_country']") public WebElement id_country;
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[7]/div/select") public WebElement id_state;
	
	@FindBy(css="input[name=address1]") public WebElement address1;
	@FindBy(css="input[name=address2]") public WebElement address2;
	@FindBy(css="input[name=city]") public WebElement city;
	@FindBy(css="input[name=postcode]") public WebElement postcode;
	@FindBy(xpath="//*[@id='other']") public WebElement other;
	@FindBy(css="input[name=phone]") public WebElement phone;
	@FindBy(css="input[name=phone_mobile]") public WebElement phone_mobile;
	@FindBy(css="input[name=alias]") public WebElement alias;
	@FindBy(xpath="//*[@id='submitAccount']") public WebElement submit;
	@FindBy(xpath="//*[@id='center_column']/h1") public WebElement registration_status;
	
	
	public void sign_in_link(){
		sign_in_link.click();
	}
	public void email(String value){
		email.sendKeys(value);
	}
	public void email_submit(){
		email_submit.click();
	}
	public void gender(){
		gender.click();
	}
	public void firstname(String value){
		firstname.sendKeys(value);
	}
	public void lastname(String value){
		lastname.sendKeys(value);
	}
	public void password(String value){
		password.sendKeys(value);
	}
	
	public void check_box_1(){
		check_box_1.click();
	}
	public void check_box_2(){
		check_box_2.click();
	}
	
	public void add_firstname(String value){
		add_firstname.sendKeys(value);
	}
	public void add_lastname(String value){
		add_lastname.sendKeys(value);
	}
	
	public void company(String value){
		company.sendKeys(value);
	}
	
	//dd
	public void days(String value){
		try {
			Select select=new Select(days);
			select.selectByValue(value);
			System.out.println(value +" Selection Successful");
		} catch (Exception e) {
			System.out.println("Error has been occured during selection from DD due to:"+e);		}
		
	}
	
	public void months(String value){
		try {
			Select select=new Select(months);
			select.selectByValue(value);
			System.out.println(value +" Selection Successful");
		} catch (Exception e) {
			System.out.println("Error has been occured during selection from DD due to:"+e);		}
		
	}
	
	public void years(String value){
		try {
			Select select=new Select(years);
			select.selectByValue(value);
			System.out.println(value +" Selection Successful");
		} catch (Exception e) {
			System.out.println("Error has been occured during selection from DD due to:"+e);		}
		
	}
	
	public void id_state(String value){
		try {
			Select select=new Select(id_state);
			select.selectByValue(value);
			System.out.println(value +" Selection Successful");
		} catch (Exception e) {
			System.out.println("Error has been occured during selection from DD due to:"+e);		}
		
	}
	
	public void id_country(String value){
		try {
			Select select=new Select(id_country);
			select.selectByValue(value);
			System.out.println(value +" Selection Successful");
		} catch (Exception e) {
			System.out.println("Error has been occured during selection from DD due to:"+e);		}
		
	}
	
	public void address1(String value){
		address1.sendKeys(value);
	}
	public void address2(String value){
		address2.sendKeys(value);
	}
	public void city(String value){
		city.sendKeys(value);
	}
	public void postcode(String value){
		postcode.sendKeys(value);
	}
	public void other(String value){
		other.sendKeys(value);
	}
	public void phone(String value){
		phone.sendKeys(value);
	}
	public void phone_mobile(String value){
		phone_mobile.sendKeys(value);
	}
	public void alias(String value){
		alias.sendKeys(value);
	}
	public void submit(){
		submit.click();
	}
	
	
	public String registration_status(){
		return registration_status.getText();
	}
}
