package Test_Pack;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NaukriTest {

    @Test
    public void naukariAutomate(){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false).setSlowMo(500));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();


            page.navigate("https://www.naukri.com/nlogin/login");


            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Email ID / Username")).click();
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Email ID / Username")).press("CapsLock");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Email ID / Username")).fill("A");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Email ID / Username")).press("CapsLock");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Email ID / Username")).fill("Akshay");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Email ID / Username")).press("CapsLock");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Email ID / Username")).fill("AkshayA");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Email ID / Username")).press("CapsLock");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Email ID / Username")).fill("AkshayAlshi10@gmail.com");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Password")).click();
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Password")).press("CapsLock");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Password")).fill("A");
//            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Password")).press("CapsLock");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Password")).fill("Akshay@123");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login").setExact(true)).click();
            page.locator("//div[@class='nI-gNb-drawer__bars']").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("View & Update Profile")).click();
            page.locator("#lazyResumeHead").getByText("editOneTheme").click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save")).click();
            page.locator(".nI-gNb-drawer__bars").click();
            page.getByText("Logout").click();
        }

    }

}