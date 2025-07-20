package testComponents;

import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Attachment;

public abstract class allure {

    @Attachment(value = "Log Message", type = "text/plain")
    public static String logMessage(String message) {
        return message;
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshot(byte[] screenshotData) {
        return screenshotData;
    }
//    @Attachment(value = "Screenshot", type = "image/png")
//    public byte[] takeScreenshot() {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }
}