
package finalprojectA;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {
   // private final boolean printStatus = false;

   public UrlValidatorTest(String testName) {
      super(testName);
   }



   public void testManualTest()
   {




//You can use this function to implement your manual testing
      System.out.println("Startin manual testing");

      String[] schemes = {"http","https"};
      UrlValidator urlVal = new UrlValidator(schemes, 0);



      System.out.println("\n~~~~~~~~~~~~\nurlVal_2 test start");
      UrlValidator urlVal_2 = new UrlValidator(schemes, 0);
      boolean result2 = urlVal_2.isValid("http://www.google.com");
      System.out.println("result2 = "+result2);
      //assertTrue(urlVal.isValid("http://www.google.com"));
      System.out.println("calling isvalidSceme: "+urlVal_2.isValidScheme("http"));

      System.out.println("urlVal_2 test over\n~~~~~~~~~~~~\n");

      System.out.println("\n~~~~~~~~~~~~\nurlVal_3 test start");
      UrlValidator urlVal_3 = new UrlValidator(schemes, 0);
      boolean result3 = urlVal_3.isValid("https://www.google.com");
      System.out.println("result3 = "+result3);
      //assertTrue(urlVal.isValid("http://www.google.com"));
      System.out.println("urlVal_3 test over\n~~~~~~~~~~~~\n");

      System.out.println("\n~~~~~~~~~~~~\nurlVal_4 test start");
      UrlValidator urlVal_4 = new UrlValidator(schemes, 0);
      boolean result4 = urlVal_4.isValid("httpz://www.google.com");
      System.out.println("result4 = "+result4);
      //assertTrue(urlVal.isValid("http://www.google.com"));
      System.out.println("urlVal_4 test over\n~~~~~~~~~~~~\n");



      for (int sIndex = 0; sIndex < testScheme.length; sIndex++) {
         ResultPair testPair = testScheme[sIndex];
         boolean result = urlVal.isValidScheme(testPair.item);
         System.out.println("sIndex = "+sIndex + "\n testPair.item = "+testPair.item + "\n result = "+result+"\n");
         /*      assertEquals(testPair.item, testPair.valid, result);
         if (printStatus) {
            if (result == testPair.valid) {
               System.out.print('.');
            } else {
               System.out.print('X');
            }
         }
   */   }



      //   boolean result = urlVal.isValid("http://www.google.com");
      //   System.out.println("result = "+result);
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
      //   testIsValid(testUrlParts, UrlValidator.ALLOW_ALL_SCHEMES);
      // setUp();
      // int options = UrlValidator.ALLOW_2_SLASHES + UrlValidator.ALLOW_ALL_SCHEMES + UrlValidator.NO_FRAGMENTS;

      // testIsValid(testUrlPartsOptions, options);

   }

   //-------------------- Test data for creating a composite URL
   /**
    * The data given below approximates the 4 parts of a URL
    * <scheme>://<authority><path>?<query> except that the port number
    * is broken out of authority to increase the number of permutations.
    * A complete URL is composed of a scheme+authority+port+path+query,
    * all of which must be individually valid for the entire URL to be considered
    * valid.
    */
   ResultPair[] testUrlScheme = {new ResultPair("http://", true),
           new ResultPair("ftp://", true),
           new ResultPair("h3t://", true),
           new ResultPair("3ht://", false),
           new ResultPair("http:/", false),
           new ResultPair("http:", false),
           new ResultPair("http/", false),
           new ResultPair("://", false),
           new ResultPair("", true)};

   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
           new ResultPair("go.com", true),
           new ResultPair("go.au", true),
           new ResultPair("0.0.0.0", true),
           new ResultPair("255.255.255.255", true),
           new ResultPair("256.256.256.256", false),
           new ResultPair("255.com", true),
           new ResultPair("1.2.3.4.5", false),
           new ResultPair("1.2.3.4.", false),
           new ResultPair("1.2.3", false),
           new ResultPair(".1.2.3.4", false),
           new ResultPair("go.a", false),
           new ResultPair("go.a1a", true),
           new ResultPair("go.1aa", false),
           new ResultPair("aaa.", false),
           new ResultPair(".aaa", false),
           new ResultPair("aaa", false),
           new ResultPair("", false)
   };
   ResultPair[] testUrlPort = {new ResultPair(":80", true),
           new ResultPair(":65535", true),
           new ResultPair(":0", true),
           new ResultPair("", true),
           new ResultPair(":-1", false),
           new ResultPair(":65636", true),
           new ResultPair(":65a", false)
   };
   ResultPair[] testPath = {new ResultPair("/test1", true),
           new ResultPair("/t123", true),
           new ResultPair("/$23", true),
           new ResultPair("/..", false),
           new ResultPair("/../", false),
           new ResultPair("/test1/", true),
           new ResultPair("", true),
           new ResultPair("/test1/file", true),
           new ResultPair("/..//file", false),
           new ResultPair("/test1//file", false)
   };
   //Test allow2slash, noFragment
   ResultPair[] testUrlPathOptions = {new ResultPair("/test1", true),
           new ResultPair("/t123", true),
           new ResultPair("/$23", true),
           new ResultPair("/..", false),
           new ResultPair("/../", false),
           new ResultPair("/test1/", true),
           new ResultPair("/#", false),
           new ResultPair("", true),
           new ResultPair("/test1/file", true),
           new ResultPair("/t123/file", true),
           new ResultPair("/$23/file", true),
           new ResultPair("/../file", false),
           new ResultPair("/..//file", false),
           new ResultPair("/test1//file", true),
           new ResultPair("/#/file", false)
   };

   ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
           new ResultPair("?action=edit&mode=up", true),
           new ResultPair("", true)
   };

   Object[] testUrlParts = {testUrlScheme, testUrlAuthority, testUrlPort, testPath, testUrlQuery};
   Object[] testUrlPartsOptions = {testUrlScheme, testUrlAuthority, testUrlPort, testUrlPathOptions, testUrlQuery};
   int[] testPartsIndex = {0, 0, 0, 0, 0};

   //---------------- Test data for individual url parts ----------------
   ResultPair[] testScheme = {new ResultPair("http", true),
           new ResultPair("ftp", false),
           new ResultPair("httpd", false),
           new ResultPair("telnet", false)};

}
