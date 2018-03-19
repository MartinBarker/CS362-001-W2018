
package finalprojectB;

import junit.framework.TestCase;

import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
	   

   }
   
   public void testProgrammingBased(){
    
      System.out.println("___testProgrammingBased___");

      UrlValidator urlVal = new UrlValidator(null, null, 0);
      boolean expected;
      int i = 0;
      String[][] urls = new String [8][2];
 

      urls[0][0] = "httpss://google.com";
      urls[0][1] = "notvalid";
      
      urls[1][0] = "1234512342512345";
      urls[1][1] = "notvalid";

      urls[2][0] = "asdf";
      urls[2][1] = "notvalid";
   
      urls[3][0] = "!@#$%^&*";
      urls[3][1] = "notvalid";
 
      urls[4][0] = null;
      urls[4][1] = "notvalid";

      urls[5][0] = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
      urls[5][1] = "notvalid";

      urls[6][0] = "asdf123!@#";
      urls[6][1] = "notvalid";

      urls[7][0] = "https://google.com";
      urls[7][1] = "valid";

      

      for(i=0; i<8; i++){ 
         System.out.println("Test " + i + ": " + urls[i][0]);
         if(urls[i][1] == "notvalid"){
            expected = false;
         }
         else{
            expected = true;
         }
         assertEquals(urlVal.isValid(urls[i][0]), expected);
   
      }
   }
}
