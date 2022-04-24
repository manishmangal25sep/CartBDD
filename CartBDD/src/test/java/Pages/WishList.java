package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishList {
	
	WebDriver driver;
	By WishListTable= By.className("wishlist-items-wrapper");
	By btn_product_Remove= By.className("product-remove");
	By product_Thumbnail= By.className("product-thumbnail");
	By product_Name= By.className("product-name");
	By product_Price= By.className("product-price");
	By product_StockStatus= By.className("product-stock-status");
	By product_AddToCart= By.className("product-add-to-cart");
	public WishList(WebDriver driver)
	{
		this.driver=driver;
	}
	//returns product Name from a Index
	public String verifyValueInTable(int index)
	{
		return driver.findElements(product_Name).get(index).getText();
	}
	public String getPrice(int index)
	{
		return driver.findElements(product_Price).get(index).getText();
	}
	public void addToCart(int index)
	{
		driver.findElements(product_AddToCart).get(index).click();
	}
}
