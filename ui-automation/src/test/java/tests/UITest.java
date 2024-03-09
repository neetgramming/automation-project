package tests;

import com.neetgramming.pages.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.TestBase;

import java.text.DecimalFormat;
import java.util.List;

public class UITest extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    private LoginPage loginPage;
    private HomeInventoryPage homeInventoryPage;
    private CartPage cartPage;
    private CheckoutInfoPage checkoutInfoPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private OrderCompletePage orderCompletePage;


    @BeforeClass(groups = {"single", "parallel"})
    public void initClass() {
        loginPage = new LoginPage(driver);
        homeInventoryPage = new HomeInventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        orderCompletePage = new OrderCompletePage(driver);
    }

    @Test(testName = "verifySwagLabsOrderProcess", groups = {"single", "parallel"})
    public void testSwagLabsOrderProcess() {
        loginPage.login();

        softAssert.assertTrue(homeInventoryPage.isPageLoaded(), "Home Inventory Page is not loaded");
        List<String> listSelectedItems  = homeInventoryPage.getSelectedRandomItems(3);
        homeInventoryPage.goToShoppingCart();

        softAssert.assertTrue(cartPage.isPageLoaded(), "Cart Page is not loaded");
        cartPage.checkoutCart();

        softAssert.assertTrue(checkoutInfoPage.isPageLoaded(), "Checkout Info Page is not loaded");
        checkoutInfoPage.continueCheckout("Madhushika", "Weeraman", "10150");

        softAssert.assertTrue(checkoutOverviewPage.isPageLoaded(), "Checkout Overview Page is not loaded");
        softAssert.assertEquals(checkoutOverviewPage.getCartItems(), listSelectedItems, "Incorrect items in cart");
        softAssert.assertEquals(checkoutOverviewPage.getPaymentInfoLabel(), "Payment Information", "Payment Information Label missing");
        softAssert.assertEquals(checkoutOverviewPage.getPaymentInfoContent(), "SauceCard #31337","Payment Information - Content Label missing");
        softAssert.assertEquals(checkoutOverviewPage.getShippingInfoLabel(), "Shipping Information", "Shipping Information Label missing");
        softAssert.assertEquals(checkoutOverviewPage.getShippingInfoContent(), "Free Pony Express Delivery!", "Shipping Information - Content Label missing");
        softAssert.assertEquals(checkoutOverviewPage.getPriceTotalLabel(), "Price Total", "Price Total Label missing");

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        double actualItemTotal = Double.parseDouble(checkoutOverviewPage.getItemTotal().substring(checkoutOverviewPage.getItemTotal().indexOf("$")+1));
        double actualTax = Double.parseDouble(checkoutOverviewPage.getTax().substring(checkoutOverviewPage.getTax().indexOf("$")+1));
        double actualSubTotal = Double.parseDouble(checkoutOverviewPage.getSubTotal().substring(checkoutOverviewPage.getSubTotal().indexOf("$")+1));
        double calculatedItemTotal = Double.parseDouble(decimalFormat.format(checkoutOverviewPage.getCalculatedTotal()));
        double calculatedTax = Double.parseDouble(decimalFormat.format(actualItemTotal * 0.08));
        double calculatedSubTotal = Double.parseDouble(decimalFormat.format(actualItemTotal + actualTax));

        softAssert.assertEquals(actualItemTotal, calculatedItemTotal, "Incorrect Item Total");
        softAssert.assertEquals(actualTax, calculatedTax, "Incorrect Tax");
        softAssert.assertEquals(actualSubTotal, calculatedSubTotal , "Incorrect Sub Total");
        checkoutOverviewPage.finishPayment();

        softAssert.assertTrue(orderCompletePage.isPageLoaded(), "Checkout Complete Page is not loaded");
        softAssert.assertEquals(orderCompletePage.getCompleteLabel(), "Thank you for your order!", "Order not completed");
        softAssert.assertAll();
    }
}