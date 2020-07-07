package demo.locator.nauval;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface HomePageLocator {
    By DANA_Balance = MobileBy.id("tvBalance");
    By Home_Button = MobileBy.id("navigation_home");
    By MobileRecharge_Button = MobileBy.id("btnMobileRecharge");
    By Promotion_Banner = MobileBy.id("rvPromotion");
    By ViewAll_Button = MobileBy.id("btnPromotionViewAll");
    By History_Button = MobileBy.id("navigation_history");
    By Voucher_Button = MobileBy.id("navigation_voucherr");
    By Profile_Button = MobileBy.id("navigation_profile");
//    By Warning_Message = MobileBy.id();
}