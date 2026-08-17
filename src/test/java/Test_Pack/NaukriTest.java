package Test_Pack;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import org.testng.annotations.Test;
import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NaukriTest {

   @Test
    public void naukriAutomate() {

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setHeadless(true)
                             .setSlowMo(1000)
            );

            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Open Naukri Login
            page.navigate("https://www.naukri.com/nlogin/login");

            // ---------------- LOGIN ----------------

            Locator email = page.getByRole(
                    AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions()
                            .setName("Enter Email ID / Username")
            );

            Locator password = page.getByRole(
                    AriaRole.TEXTBOX,
                    new Page.GetByRoleOptions()
                            .setName("Enter Password")
            );

            email.fill("AkshayAlshi10@gmail.com");
            password.fill("Akshay@123");

            page.getByRole(
                    AriaRole.BUTTON,
                    new Page.GetByRoleOptions()
                            .setName("Login")
                            .setExact(true)
            ).click();

            // Wait for page after login
            page.waitForLoadState();

            // ---------------- OPEN PROFILE ----------------

            Locator menuButton = page.locator(
                    "//div[@class='nI-gNb-drawer__bars']"
            );

            menuButton.click();

            page.getByRole(
                    AriaRole.LINK,
                    new Page.GetByRoleOptions()
                            .setName("View & Update Profile")
            ).click();

            // ---------------- UPDATE RESUME HEADLINE ----------------

            Locator editHeadline = page.locator(
                    "#lazyResumeHead"
            ).getByText("editOneTheme");

            editHeadline.click();

            Locator resumeHeadline = page.locator("#resumeHeadlineTxt");

            resumeHeadline.fill(
                    "QA Automation Engineer | SDET | 3.5+ YOE | Selenium Java | REST Assured | API Testing | TestNG | Jenkins | Playwright."
            );

            page.getByRole(
                    AriaRole.BUTTON,
                    new Page.GetByRoleOptions()
                            .setName("Save")
            ).click();

            Locator crossBtn = page.locator(
                    "xpath=/html/body/div[6]/div[2]/div[1]/span"
            );

            crossBtn.click();






            editHeadline.click();



            resumeHeadline.fill(
                    "QA Automation Engineer | SDET | 3.5+ YOE | Selenium Java | REST Assured | API Testing | TestNG | Jenkins | Playwright"
            );

            page.getByRole(
                    AriaRole.BUTTON,
                    new Page.GetByRoleOptions()
                            .setName("Save")
            ).click();

            // ---------------- CLOSE POPUP ----------------



            if (crossBtn.isVisible()) {
                crossBtn.click();
            }

            // ---------------- UPDATE BASIC DETAILS ----------------

            Locator editBasicDetails = page.locator(
                    "//div[@class='hdn']//em[contains(text(),'editOneTheme')]"
            );

            editBasicDetails.click();

            Locator nameField = page.locator(
                    "//input[contains(@id,'name')]"
            );

            nameField.fill("Akshay Alshi");

            page.locator("#saveBasicDetailsBtn").click();



            editBasicDetails.click();

            nameField.fill("Akshay Suresh Alshi");

            page.locator("#saveBasicDetailsBtn").click();

            System.out.println(
                    "********** Profile Updated Successfully ********"
            );




            // ---------------- LOGOUT ----------------

            menuButton.click();

            page.getByText("Logout").click();

        }
    }
 }

