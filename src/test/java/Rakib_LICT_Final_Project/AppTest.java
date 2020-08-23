package Rakib_LICT_Final_Project;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data_pak.data_access;
import factories.login_page;
import factories.option_verification;
import factories.product_add;
import factories.product_purchase;
import factories.registration_page;
import factories.subscription;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
	public WebDriver driver;
	public String url;
	public String first_name;
	public String last_name;
	public String email;
	public String password;
	public String product;
	public String price;
	public boolean agree;
	data_access test_data;
	
	@BeforeTest
	public void before(){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		test_data=new data_access();
		
		System.out.println(test_data.property);
		
		url=test_data.property.getProperty("url");
		product=test_data.property.getProperty("product");
		price=test_data.property.getProperty("price");
		first_name=test_data.property.getProperty("first_name");
		last_name=test_data.property.getProperty("last_name");
		email=test_data.property.getProperty("email");
		password=test_data.property.getProperty("password");
		
	}
	
	@Test(priority=1)
	public void varify_registration_working_for_all_possetive_value() throws InterruptedException{
		base_url_window_setup();
		register_fun(driver,first_name,last_name,password);
		registration_page register=new registration_page(driver);
		String registration_status=register.registration_status();
		login_page login=new login_page(driver);
		login.logout();
		Assert.assertEquals(registration_status, "MY ACCOUNT");
		
	}
	
	@Test(priority=2)
	public void varify_login_working_for_all_possetive_value() throws InterruptedException{
		base_url_window_setup();
		login_page login=new login_page(driver);
		login.sign_in_link();
		login_fun(driver,email,password);
		String login_status=login.login_status();
		login.logout();
		Assert.assertEquals(login_status, "MY ACCOUNT");
	}
	
	@Test(priority=3)
	public void varify_subscription_working_for_all_possetive_value() throws InterruptedException{
		base_url_window_setup();
		subscription Subscription=new subscription(driver);
		Subscription.email("safeemail"+RandomStringUtils.randomAlphanumeric(5)+"@gamil.com");
		Subscription.submit();
		Assert.assertEquals(Subscription.status(), "Newsletter : You have successfully subscribed to this newsletter.");
	}
	
	@Test(priority=4)
	public void varify_option_working_or_available_in_the_homepage() throws InterruptedException{
		base_url_window_setup();
		option_verification OptionVerification=new option_verification(driver);
		
		Assert.assertEquals(OptionVerification.search(),true);
		Assert.assertEquals(OptionVerification.view_product(),true);
		Assert.assertEquals(OptionVerification.ouer_stories(),"Our stores");
		Assert.assertEquals(OptionVerification.specials(),"Specials");
		Assert.assertEquals(OptionVerification.information(),"Information");
		Assert.assertEquals(OptionVerification.catalog(),"Categories");
		Assert.assertEquals(OptionVerification.contact_us(),"Contact us");
		Assert.assertEquals(OptionVerification.sign_in(),"Sign in");
	}
	
	@Test(priority=5)
	public void varify_produc_purchase_by_searching_from_the_search_option() throws InterruptedException{
		base_url_window_setup();
		product_purchase ProductPurchase=new product_purchase(driver);
		ProductPurchase.search_box(product);
		ProductPurchase.search_btn();
		ProductPurchase.view_product();
		Assert.assertEquals(ProductPurchase.price(),price);
		ProductPurchase.color();
		ProductPurchase.add_to_cart();
		ProductPurchase.proceed_to_checkout();
		ProductPurchase.proceed_to_checkout2();
		login_fun(driver,email,password);
		ProductPurchase.proceed_to_checkout3();
		ProductPurchase.agree();
		ProductPurchase.proceed_to_checkout4();
		Assert.assertEquals(ProductPurchase.price_status(),price);
		login_page login=new login_page(driver);
		login.logout();
	}
	
	@Test(priority=6)
	public void varify_produc_can_add_to_cart_from_the_homepage() throws InterruptedException{
		base_url_window_setup();
		driver.manage().window().setSize(new Dimension(1024,768));
		product_add ProductAdd=new product_add(driver);
		ProductAdd.add_to_cart_btn();
		Assert.assertEquals(ProductAdd.status(),true);
	}
	
	@AfterTest
	public void after() throws InterruptedException{
		Thread.sleep(3000);
		System.out.println("Test-closed");
		driver.quit();

	}
	
	public void base_url_window_setup(){
		driver.get(url);
		System.out.println("Link Opened");
		driver.manage().window().maximize();
		System.out.println("Max Window Size");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Registeration-Test-started");
	}
	
	public static void login_fun(WebDriver driver,String email,String password) throws InterruptedException{
		login_page login=new login_page(driver);
		login.email(email);
		login.password(password);
		login.submit();

	}
	
	public static void register_fun(WebDriver driver,String fname,String lname,String password) throws InterruptedException{
		registration_page register=new registration_page(driver);
		String random_email="safeemail"+RandomStringUtils.randomAlphanumeric(5)+"@gamil.com";
		String firstname=fname+RandomStringUtils.randomAlphabetic(1, 3);
		String lastname=lname+RandomStringUtils.randomAlphabetic(1, 3);
		String add_firstname=fname+RandomStringUtils.randomAlphabetic(1, 3);
		String add_lastname=fname+RandomStringUtils.randomAlphabetic(1, 3);
		String company=RandomStringUtils.randomAlphabetic(4, 8);
		String address1=RandomStringUtils.randomAlphabetic(4, 8);
		String address2=RandomStringUtils.randomAlphabetic(4, 8);
		String city=RandomStringUtils.randomAlphabetic(4, 8);
		String postcode=RandomStringUtils.randomNumeric(5);
		String other=RandomStringUtils.randomAlphabetic(4, 8);
		String phone=RandomStringUtils.randomNumeric(11);
		String phone_mobile=RandomStringUtils.randomNumeric(11);
		String alias=RandomStringUtils.randomAlphabetic(4, 8);
		
		
		register.sign_in_link();
		register.email(random_email);
		register.email_submit();
		register.gender();
		register.firstname(firstname);
		register.lastname(lastname);
		register.password(password);
		register.check_box_1();
		register.check_box_2();
		register.add_firstname(add_firstname);
		register.add_lastname(add_lastname);
		register.company(company);
		
		register.days("1");
		register.months("1");
		register.years("1999");
		register.id_state("1");
		register.id_country("21");
		
		register.address1(address1);
		register.address2(address2);
		register.city(city);
		register.postcode(postcode);
		register.other(other);
		register.phone(phone);
		register.phone_mobile(phone_mobile);
		register.alias(alias);
		register.submit();
	}

}
