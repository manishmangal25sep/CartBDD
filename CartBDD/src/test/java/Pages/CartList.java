package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartList {
	WebDriver driver=null;
	By CartTable= By.className("woocommerce-cart-form");
	By btn_product_Remove= By.className("product-remove");
	By product_Thumbnail= By.className("product-thumbnail");
	By product_Name= By.className("product-name");
	By product_Price= By.className("product-price");
	By product_Quantity= By.className("product-quantity");
	By product_Subtotal= By.className("product-subtotal");
	By CouponCode= By.className("id('coupon_code')");
	By UpdateCart=By.xpath("//button[text()='Update cart']");
	By ApplyCoupon=By.xpath("//button[text()='Apply coupon']");
	
	public CartList(WebDriver driver)
	{
		this.driver=driver;
	}
	public String verifyValueInTable(int index)
	{
		return driver.findElements(product_Name).get(index).getText();
	}
}
