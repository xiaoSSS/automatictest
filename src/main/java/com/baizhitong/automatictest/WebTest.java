package com.baizhitong.automatictest;

import com.baizhitong.common.vo.ResultVo;
import com.baizhitong.utils.JsonUtils;
import com.baizhitong.utils.StringUtils;
import org.apache.commons.collections.MapUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by wangsj on 2018/4/8.
 */
public class WebTest {

    WebDriver driver;

    FileWriter fileWriter;

    @BeforeClass
    public void pre(){
        Reporter.clear();
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
        driver  = new ChromeDriver();
        try {
            fileWriter = new FileWriter("D:/testResult/result1.txt");
        }catch (Exception ex){

        }
    }

    @AfterClass
    public void post(){
        driver.close();
        driver.quit();
        try {
            if(fileWriter!=null) {
                fileWriter.flush();
                fileWriter.close();
            }
        }catch (Exception ex){}
    }


    @Test(groups = "web",invocationCount = 1,threadPoolSize = 1,dataProvider = "loginData")
    public void t1(String school,String clazz,String name,
                   final String loginAccount,String password,String section,String grade){

        if(StringUtils.isEmpty(loginAccount)||StringUtils.isEmpty(password)){
            Assert.assertTrue(true);
        }

        driver.get("http://test.emooc.com:6900/login/jumpToLogin");

        WebElement element = driver.findElement(By.id("account"));
        element.sendKeys(loginAccount);

        WebElement elePwd = driver.findElement(By.id("password"));
        elePwd.sendKeys(password);

        WebElement submit = driver.findElement(By.id("dologin"));
        submit.click();

        try {
            (new WebDriverWait(driver, 1)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver webDriver) {
                    String url = webDriver.getCurrentUrl();
                    Boolean res = url.startsWith("http://test.emooc.com:6900/");
                    if(!res){
                        Reporter.log("一卡通登录失败,账号为:"+loginAccount);
                    }else{
                        res = res&&!url.equals("http://test.emooc.com:6900/pub/passport/error.html");
                        if(!res){
                            Reporter.log("一卡通登录成功，但系统中未找到该账号,账号为:"+loginAccount);
                        }
                    }
                    return res;
                }
            });
        }catch (RuntimeException ex){
            throw ex;
        }finally{
            driver.get("http://test.emooc.com:6900/logout");
        }
    }


    @DataProvider
    public static Object[][] loginData(){
        Object[][] accout_pwd_group = new Object[10][];
        FileReader fr;
        try {
            fr = new FileReader(new File("D:/1/stuInfo.txt"));
            BufferedReader br = new BufferedReader(fr);
            String info = br.readLine();
            int i = 0;
            while(StringUtils.isNotEmpty(info)){
                String[] infos = info.split(",");
                Object[] account_pwd = new Object[]{infos[0],infos[1],infos[2],infos[3],infos[3].substring(12),infos[4],infos[5]};
                accout_pwd_group[i] = account_pwd;
                i++;
                info = br.readLine();
            }
        }catch (Exception ex){

        }
        return accout_pwd_group;
    }

}
