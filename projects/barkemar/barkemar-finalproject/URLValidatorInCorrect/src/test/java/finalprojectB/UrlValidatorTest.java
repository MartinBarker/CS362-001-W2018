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
   // private final boolean printStatus = false;
   private static final String URL_REGEX =
           "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?";
   private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
   public UrlValidatorTest(String testName) {
      super(testName);
   }



   /**
    * Schema/Protocol (ie. http:, ftp:, file:, etc).
    */
   private static final int PARSE_URL_SCHEME = 2;

   private static final String SCHEME_REGEX = "^\\p{Alpha}[\\p{Alnum}\\+\\-\\.]*";
   private static final Pattern SCHEME_PATTERN = Pattern.compile(SCHEME_REGEX);
   public static final long ALLOW_ALL_SCHEMES = 1 << 0;
 //  private final Set<String> allowedSchemes; // Must be lower-case

   public void testManualTest()
   {
//You can use this function to implement your manual testing
      System.out.println("Startin manual testing");

      String[] schemes = {"http","https"};
      UrlValidator urlVal = new UrlValidator(schemes, 0);
/*
      System.out.println("\n~~~~~~~~~~~~\nurlVal_2 test start OPTION SET = 1");
      UrlValidator urlVal_2 = new UrlValidator(schemes, 1);
      boolean result2 = urlVal_2.isValid("http://www.google.com");
      System.out.println("result2 = "+result2);
      //assertTrue(urlVal.isValid("http://www.google.com"));

      System.out.println("calling isvalidSceme: "+urlVal_2.isValidScheme("http"));
      // System.out.println("calling isValidAuthority: "+urlVal_2.isValidAuthority("http"));
      //  System.out.println("calling isValidAuthority: "+urlVal_2.isValidFragment("http"));
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
*/


      //   boolean result = urlVal.isValid("http://www.google.com");
      //   System.out.println("result = "+result);
   }

   private boolean isOn(long flag) {
      return (1 & flag) > 0;
   }

   public void testYourFirstPartition()
   {
      System.out.println("__________first partrion testing__________");
      //String[] schemes = {"http","https","ftp"};

      UrlValidator urlVal = new UrlValidator(null, null, 0);

      boolean expected = true;
      System.out.println("\n1) testing normal url (should = true)");
      String site =  "http://www.google.com:80";

      // Check the whole url address structure
      Matcher urlMatcher = URL_PATTERN.matcher(site);
      if (!urlMatcher.matches()) {
         expected = false;
         System.out.println("test: url address structure does not match");
      }

      String scheme = urlMatcher.group(PARSE_URL_SCHEME);
      System.out.println("test: scheme = "+scheme);
      System.out.println("test: urlVal.isValidScheme(scheme) = "+ urlVal.isValidScheme(scheme));
/*      System.out.println("test: urlVal.isValidScheme(http) = "+ urlVal.isValidScheme("http"));
      System.out.println("test: urlVal.isValidScheme(https) = "+ urlVal.isValidScheme("https"));
      System.out.println("test: urlVal.isValidScheme(HTTP) = "+ urlVal.isValidScheme("HTTP"));
      System.out.println("test: urlVal.isValidScheme(HTTPS) = "+ urlVal.isValidScheme("HTTPS"));
      System.out.println("test: urlVal.isValidScheme(ftp) = "+ urlVal.isValidScheme("ftp"));
      System.out.println("test: urlVal.isValidScheme(FTP) = "+ urlVal.isValidScheme("FTP"));
*/



      System.out.println("site = "+site);
      boolean newresult = urlVal.isValid(site);
      System.out.println("result = "+newresult);

///////////////////  part 2   ///////////////////////////////////////////
/*
      System.out.println("\n2)");
      String[] schemes = {"http","https","ftp", "file"};
      UrlValidator urlVal2 = new UrlValidator(schemes, null, 1);
      site =  "file:///blablabla";
      System.out.println("site = "+site);
      newresult = urlVal2.isValid(site);
      System.out.println("result = "+newresult);

*/

/*
      System.out.println("\n3) testing url (should = true)");
      site =  "https://www.google.com:80";
      System.out.println("site = "+site);
      newresult = urlVal.isValid(site);
      System.out.println("result = "+newresult);

      System.out.println("\n2) testing url with uppercase scheme (should = true)");
      site =  "HTTP://www.google.com:80";
      System.out.println("site = "+site);
      newresult = urlVal.isValid(site);
      System.out.println("result = "+newresult);
      //if scheme is uppercase, isvalid() should automatically test if the lowercase version is valid

      System.out.println("\n3) testing url with uppercase scheme (should = true)");
      site =  "HTTPS://www.google.com:80";
      System.out.println("site = "+site);
      newresult = urlVal.isValid(site);
      System.out.println("result = "+newresult);
*/
   }

   public void testProgrammingBased(){
      System.out.println("___testProgrammingBased___");

   // TO DO:
    //create a 2d array of urls and whether or not they are valid
    // ex:
      String[][] urls = new String[10][2];
   //assign values
      urls[0][0] = "site.com";
      urls[0][1] = "valid";

      urls[1][0] = "invalidurlblablabla";
      urls[1][1] = "notvalid";
      //etc ... multiple

   //loop through testing them
      // for loop going from i to 10 (since we have 10 elements in the array of urls)
      //{
            // if urls[i][1] == notvalid, set boolean expefcted = false
            // else set boolean expected = true

            //assertequals( urlVal.isValid( urls[i][0] ), expected )
      //}


      System.out.println("end");
   }


   protected boolean isValidScheme(String scheme) {
      if (scheme == null) {
         return false;
      }

      // TODO could be removed if external schemes were checked in the ctor before being stored
      if (!SCHEME_PATTERN.matcher(scheme).matches()) {
         return false;
      }

  //    if (isOff(ALLOW_ALL_SCHEMES) && !allowedSchemes.contains(scheme.toLowerCase(Locale.ENGLISH))) {
  //       return false;
  //    }

      return true;
   }
/*
   private boolean isOff(long flag) {
      return (1 & flag) == 0;
   }

   Matcher matchURL(String value) {

      return URL_PATTERN.matcher(value);
   }
*/
   public void testYourSecondPartition(){
      //You can use this function to implement your Second Partition testing
     // System.out.println("testUrlPathOptions[0] = "+testUrlPathOptions[0]);


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