package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

	// Only Capturing the basic and required controls for the Home Page
	WebDriver driver;
	By btn_addToWishList= By.className("yith-wcwl-add-button");
	By btn_selectOption=By.xpath("//a[text()='Select options']");
	By btn_addToCart=By.xpath("//a[text()='Add to cart']");
	By btn_buyNow=By.xpath("//a[text()='Buy now!']");
	By productDetail=By.cssSelector("h2.woocommerce-loop-product__title");
	By btn_Home=By.xpath("//a[text()='Home']");
	By btn_Shop=By.xpath("//a[text()='Shop']");
	By btn_Sale=By.xpath("//a[text()='Sale']");
	By btn_AboutUs=By.xpath("//a[text()='About Us']");
	By btn_Contact=By.xpath("//a[text()='Contact']");
	By btn_Blog=By.xpath("//a[text()='Blog']");
	By btn_Products=By.xpath("//a[text()='Products']");
	By btn_Compare=By.cssSelector(".header-compare.product");
	By btn_Wishlist=By.className("header-wishlist");
	By btn_MyAccount=By.className("header-my-account");
	By btn_Cart=By.className("header-cart");
	By cookie_Accept=By.xpath("//a[text()='Accept all']");
	By productAdded=By.xpath("id('yith-wcwl-popup-message')");
	
	

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	//Navigation function for different Pages
	public void navigateHomePage()
	{
		driver.findElement(btn_Home).click();
	}
	public void navigateShop()
	{
		driver.findElement(btn_Shop).click();
	}
	public void navigateSale()
	{
		driver.findElement(btn_Sale).click();
	}
	public void navigateAboutUs()
	{
		driver.findElement(btn_AboutUs).click();
	}
	public void navigateContact()
	{
		driver.findElement(btn_Contact).click();
	}
	public void navigateBlog()
	{
		driver.findElement(btn_Blog).click();
	}
	public void navigateProducts()
	{
		driver.findElement(btn_Products).click();
	}
	public void navigateCompare()
	{
		driver.findElement(btn_Compare).click();
	}
	public void navigateWishlist()
	{
		driver.findElement(btn_Wishlist).click();
	}
	public void navigateMyAccount()
	{
		driver.findElement(btn_MyAccount).click();
	}
	public void navigateCart()
	{
		driver.findElement(btn_Cart).click();
	}
	public void addToWishList(int index) throws InterruptedException //Function is implemented to click on basis of index. Product Name will be as per requirement
	{
		driver.findElements(btn_addToWishList).get(index).click();	
	 WebDriverWait wait = new WebDriverWait(driver,10);
	 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productAdded));
	
	}
	public void addToCart(int index) //Function is implemented to click on basis of index. Product Name will be as per requirement
	{
		driver.findElements(btn_addToCart).get(index).click();
	}
	public void selectProduct(int index) //Function is implemented to click on basis of index. Product Name will be as per requirement
	{
		driver.findElements(btn_selectOption).get(index).click();
	}
	public void acceptCookie()
	{
		driver.findElement(cookie_Accept).click();
	}
}
