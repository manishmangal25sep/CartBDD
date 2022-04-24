package stepDefinition;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CartList;
import Pages.HomePage;
import Pages.WishList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddToCart {

	WebDriver driver=null;
	HomePage hp=null;
	WishList wl=null;
	 CartList atc=null;
	 String productName="";
	int lowestIndex=1;
	String[] WishListProduct=new String[4];// to store product name added to wishlist
	AddToCart itemList;
	@Given("I Add four different products to my WishList")
	public void addItemToWishList() throws InterruptedException {
		String projectPath= System.getProperty("user.dir");
		System.out.println("System Path"+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://testscriptdemo.com/");
		List<WebElement> products=driver.findElements(By.cssSelector("h2.woocommerce-loop-product__title"));
		HomePage hp= new HomePage(driver);
		hp.acceptCookie();
		driver.manage().window().maximize();	
		int index;
		  for(index=0;index<4;index++) {
		  if(index>0)
		hp.addToWishList(index-1);
		  else
			  hp.addToWishList(index);  
		  WishListProduct[index]=products.get(index).getText();
		 }
	}

	@When("I view my wishlist table")
	public void viewWishList() {
		HomePage hp= new HomePage(driver);
		 hp.navigateWishlist();
		  
	}

	@Then("I find total four selected items in my WishList")
	public void verifyWishList() {
		WishList wl=new WishList(driver);
		  for(int i=1,j=WishListProduct.length-1;i<=WishListProduct.length;i++,j--)
		  {
			 String productName= wl.verifyValueInTable(i);
			 Assert.assertTrue(productName!=WishListProduct[j]);//Comparing Last index of Array with 1st index of Webelement List 
		  }
	}

	@When("I Search for Lowest Price Product")
	public void search_LowestPrice() {
		WishList wl=new WishList(driver);
		String Amount="";
		  String lowest=wl.getPrice(1);
		 Amount=lowest.substring(lowest.length()-5, lowest.length());
		// System.out.println(Amount);
		  double lowestValue=Double.parseDouble(Amount);
		  
		  for(int i=1;i<=WishListProduct.length;i++)
		  {
			String productName= wl.getPrice(i);
			Amount=productName.substring(productName.length()-5, productName.length());
			double lowestCompare=Double.parseDouble(Amount);
			if(lowestCompare<lowestValue)
			{
				lowestValue=lowestCompare;
				lowestIndex=i;
			}
		  }
	}
	@And("I am able to add the lowest price item to my Cart")
	public void addItemToCart() throws InterruptedException {
		WishList wl=new WishList(driver);
		String productName= wl.verifyValueInTable(lowestIndex);// to fetch the Product Name
		  wl.addToCart(lowestIndex); // to add product to cart
		  System.out.println(productName);
		  Thread.sleep(3000);
	}
	@Then("I am able to verify the item in my cart")
	public void verifyCart() {
		HomePage hp= new HomePage(driver);
		hp.navigateCart();
		  CartList atc= new CartList(driver);
		  String fetchedProductName=atc.verifyValueInTable(0);
		  Assert.assertTrue(productName!=fetchedProductName);
		  driver.close();
	}
}
