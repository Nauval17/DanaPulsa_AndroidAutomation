package demo.locator;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public interface RechargeChooseVoucherPageLocator {
    // Button
    By SELECT_NO_VOUCHER = MobileBy.id("btnSelectNoVoucher");

    // Recycle View
    By VOUCHER_ITEM = MobileBy.id("rvVoucherItem");

    // Image View
    By PHONE_IMAGE = MobileBy.id("ivVoucherIcon");
}
