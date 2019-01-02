package utility;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




public class Screenshot {

                public String screenshotpath="";
                /**
     ********************************************************************** 
     * Method Name: getScreenshot
     * @Description : Capturing screenshot and storing in the folder
     *********************************************************************** 
     */
                
                public void initiateScreenshotPath(String applicationName,String sprintName){
                                
                                SimpleDateFormat st=new SimpleDateFormat("dd-MM-yyyy");
                    Date dt=new Date();
                    String date_time=st.format(dt);
                    String subFolder=sprintName +" "+applicationName + " "+date_time;
                screenshotpath="./Screenshots"+"\\"+subFolder+"\\";
                }
                


                
                /**
                ********************************************************************** 
                 * Method Name: getScreenShot
                * @Description : Taking the screenshot of screen and save it on desktop in folder Named as Automation ScreenShots
                *********************************************************************** 
                 */

                public void getScreenShot(WebDriver driver,String folderName) throws Exception
                {
                                Thread.sleep(3000);
                                TakesScreenshot ts=(TakesScreenshot)driver;
                                File source=ts.getScreenshotAs(OutputType.FILE);
                                File destDir=new File(screenshotpath+folderName);
                                FileUtils.copyFileToDirectory(source, destDir);
                }

                /**
     ********************************************************************** 
     * Method Name: getScreenshot
     * @Description : Capturing screenshot and storing in the folder
     *********************************************************************** 
     */

                public void getScreenshot(WebDriver driver, String folderName) throws Exception
    {
                                
 try {
                                                Thread.sleep(3000);
                                                   TakesScreenshot ts=(TakesScreenshot)driver;
                                                   File source=ts.getScreenshotAs(OutputType.FILE);
                                                   File destDir=new File(screenshotpath+folderName);
                                                   FileUtils.copyFileToDirectory(source, destDir);
                                } catch (Exception e) {
                                                e.printStackTrace();
                                }
                                
    }
                

                
                /**
     ********************************************************************** 
     * Method Name: captureScreenshotAlertBox
     * @Description : Capturing screenshot for the alertbox and storing in the folder
     *********************************************************************** 
     */
                public void captureScreenshotAlertBox(WebDriver driver,String TestcaseID){
                                

                                try {
                                                
                                                Path path = Paths.get(screenshotpath+TestcaseID);
                                                if(Files.exists(path)){
                                                                
                                                                System.out.println("file exist");
                                                                
                                                }else{
                                                                
                                                                File dir = new File(screenshotpath+TestcaseID);
                                                                dir.mkdir();
                                                }
                                                char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                                                StringBuilder sb = new StringBuilder();
                                                Random random = new Random();
                                                for (int i = 0; i < 20; i++) {
                                                    char c = chars[random.nextInt(chars.length)];
                                                    sb.append(c);
                                                }
                                                String output = sb.toString();
                                                
                                                // This code will capture screenshot of current screen                     
                                                BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
                                                
                                                // This will store screenshot on Specific location
                                                ImageIO.write(image, "png", new File(screenshotpath+TestcaseID+"\\"+output+".png"));

                                                
                                } catch (HeadlessException e) {
                                                
                                                e.printStackTrace();
                                } catch (AWTException e) {
                                                
                                                e.printStackTrace();
                                } catch (IOException e) {
                                                
                                                e.printStackTrace();
                                } 
                }
                
                

                
}
