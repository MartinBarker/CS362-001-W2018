package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
	/**
	 * Test that the gets methods work as expected.
	 */
	@Test
	public void test01() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute,
				startDay,
				startMonth,
				startYear,
				title,
				description);
		// assertions
		assertTrue(appt.getValid());
		assertEquals(21, appt.getStartHour());
		assertEquals(30, appt.getStartMinute());
		assertEquals(15, appt.getStartDay());
		assertEquals(01, appt.getStartMonth());
		assertEquals(2018, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());
	}

	/**
	 * Test that the set methods work as expected.
	 */
	@Test
	public void test02() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		// assertions
		appt.setStartHour(15);
		assertEquals(15, appt.getStartHour());
		appt.setStartMinute(10);
		assertEquals(10, appt.getStartMinute());
		appt.setStartDay(10);
		assertEquals(10, appt.getStartDay());
		appt.setStartMonth(10);
		assertEquals(10, appt.getStartMonth());
		appt.setStartYear(2007);
		assertEquals(2007, appt.getStartYear());

		appt.setTitle("new title");
		assertEquals("new title", appt.getTitle());
		appt.setTitle(null);
		assertEquals("", appt.getTitle());

		appt.setDescription("new description");
		assertEquals("new description", appt.getDescription());
		appt.setDescription(null);
		assertEquals("", appt.getDescription());

		//no getValid(), since getValid will always be a bool with no chance of it being null.

	}

	/**
	 *   Test that the isValid function works  correctly
	 */
	@Test
	public void test021() throws Throwable {
//		Appt appt = new Appt(2, 4, 2, 11, 2019, ":ttt", "ddd");
		//cant just test to confirm that something is a data type. Assume it will always receive boolean.s
		//	assertEquals(appt.getValid(), Boolean);



	}

	/**
	 * Test that the setRecurrence() function works correctly
	 **/
	@Test
	public void test03() throws Throwable {

		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		int[] recurDaysArray = new int[3];

		recurDaysArray[0] = 1;
		recurDaysArray[1] = 2;
		recurDaysArray[2] = 3;
		int recurBy = 6;
		int recurIncrement = 7;
		int recurNumber = 8;
		appt.setRecurrence(recurDaysArray, recurBy, recurIncrement, recurNumber);

		assertEquals(recurDaysArray, appt.getRecurDays());  // //

		assertEquals(recurBy, appt.getRecurBy());
		assertEquals(recurIncrement, appt.getRecurIncrement());
		assertEquals(recurNumber, appt.getRecurNumber());

	//testing for	appt.getRecurIncrement();
	//int recurIncrement = 7;
		assertEquals(recurIncrement, appt.getRecurIncrement());
	// did not do anything to testing percentalge ^

//////////// Cannot do testing for setRecurDays function because setRecurDays is private
		// thought i could do testing for setRecurDays by passing it a null value through setRecurrence, but that produces an error when testing.
//		int[] recurDaysArrayNull = null;       // new int[0];
//		int[] newArr = new int[0];
//		appt.setRecurrence(null, recurBy, recurIncrement, recurNumber);
//		assertEquals(newArr, appt.getRecurDays());
//	try'd to test that setRecurDays would return new int[0] if passed in array was = 0, but threw error

	}

	/**
	 *  Test that public boolean isRecurring() works correctly
	 */
	@Test
	public void test041() throws Throwable{
		//returns bool based on if something equals RECUR_NUMBER_NEVER, don't know what this means
		//cant just test for 'bool' value. need to specifiy the data type. So cannot test this function
	}

	/**
	 * test that isRecurring() function works correctly
	 * public boolean isRecurring() {
	 * return getRecurNumber() != RECUR_NUMBER_NEVER;
	 * }
	 **/
	@Test
	public void test04() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		int[] recurDaysArray = new int[3];
		int[] recurDaysArrayNull = null;       // new int[0];
		int[] returnedArray = new int[0];
		recurDaysArray[0] = 1;
		recurDaysArray[1] = 2;
		recurDaysArray[2] = 3;
		int recurBy = 6;
		int recurIncrement = 7;
		int recurNumber = 8;      // <-----what isRecurring() uses.
		// returns true if recurNumber != RECUR_NUMBER_NEVER
		// RECUR_NUMBER_NEVER = never reoccurs, test for NULL?


	//	appt.setRecurrence(recurDaysArray, recurBy, recurIncrement, null);
	//////////////////// CANT JUST TEST FOR NULL IN setRecurrence()
	appt.setRecurrence(recurDaysArray, recurBy, recurIncrement, 0);
	//learned that RECUR_NUMBER_NEVER can be = 0, like "appointmnet reoccurs zero times"
	boolean tempbool = false;  // recurNumber == RECUR_NUMBER_NEVER  // false when recieves null
	assertEquals(false, appt.isRecurring());

	appt.setRecurrence(recurDaysArray, recurBy, recurIncrement, 3);
	//learned that RECUR_NUMBER_NEVER can be = 0, like "appointmnet reoccurs zero times"
	// boolean tempbool = false;  // recurNumber == RECUR_NUMBER_NEVER  // false when recieves null
	assertEquals(true, appt.isRecurring());

	// ^^^^ these two final tests didn't add to my code coverage score
	}

	/**
	 * Test that function getRecurIncrement() works correctly
	 */
	@Test
	public void test05() throws Throwable {
		int startHour = 21;
		int startMinute = 30;
		int startDay = 15;
		int startMonth = 01;
		int startYear = 2018;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		int[] recurDaysArray = new int[3];
		int[] recurDaysArrayNull = null;       // new int[0];
		int[] returnedArray = new int[0];
		recurDaysArray[0] = 1;
		recurDaysArray[1] = 2;
		recurDaysArray[2] = 3;
		int recurBy = 6;
		int recurIncrement = 7;
		int recurNumber = 8;
		appt.setRecurrence(recurDaysArray, recurBy, recurIncrement, recurNumber);

		assertEquals(recurIncrement,appt.getRecurIncrement());

	}

	/**
	 *  Test that string toString() works correctly
	 */
		//   if getValid = false, toString will return String NULL
	    //   if getvalid = true, string will return :
	    // 	 retString = appt.getStartMonth()+"/"+appt.getStartDay()+"/"+appt.getStartYear() + " at ";
		//   return "\t"+ retString +  appt.represntationApp()  + " ," +  appt.getTitle()+ ", "+  appt.getDescription()+"\n";
	@Test
	public void test051() throws Throwable{

		// for me to change getValid to false, I need to make isValid set this.valid = false, which means :
		// isValid will set this.valid = false IF:   startHour <= 0 OR startHour > 23
		// 									or IF:   startHour > 0 AND startHour <= 24  && startMinute <0 OR startMinute >59
		//                                  or IF:   startHour > 0 AND startHour <= 24  && startMinute >= AND startMinute <= 59

		int startHour = 0;
		int startMinute = 29;
		int startDay = 14;
		int startMonth = 03;
		int startYear = 2016;
		String title = "tt";
		String description = "dd";
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

// Learned that changing appt declaration from 	Appt appt = new Appt(1, 3, 5, 2, 5, "t", "d");
//to 	Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
//made me gain TWO WHOLE percentages, need to do this for all other appt declarations

		// startHour <= 0  ;   isValid will set this.valid to false, getValid will return false
		assertEquals( null, appt.toString());

		startHour = 4;
		Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		//sets isValid() = true which sets getValid = true
		String day = startMonth+"/"+startDay+"/"+startYear + " at ";
//		String day2 = "\t"+ day +  appt.represntationApp()  + " ," +  title+ ", "+  description+"\n";
// need to determine represntationApp()

		String half = (startHour > 11) ? "pm" : "am"; //half = "am"
		int printableHour = startHour;       		//printablehour = "4"
	//	String day2 = printableHour + ":" + startMinute + half;
	//	String day2 = "4" + ":" + "29" + "am";

//		assertEquals(day2, appt.toString());
// could not come up with testing for toString because representationApp is private

	}

	/**
	 *  Test that compareTo() function is correct
	 */
	@Test
	public void test06() throws Throwable{
		int startHour = 8;
		int startMinute = 8;
		int startDay = 8;
		int startMonth = 8;
		int startYear = 8;
		String title = "Birthday Party";
		String description = "This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		startHour = 2;
		startMinute = 2;
		startDay = 2;
		startMonth = 2;
		startYear = 2;
		Appt compareAppt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);


		int startMinutef = appt.getStartMinute() - compareAppt.getStartMinute();
		int startHourf=	appt.getStartHour() - compareAppt.getStartHour();
		int dayf = appt.getStartDay()- compareAppt.getStartDay();
		int monthf = appt.getStartMonth()  -compareAppt.getStartMonth();
		int yearf = appt.getStartDay() -compareAppt.getStartYear();

		int compareFinal = startMinutef+startHourf+dayf+monthf+yearf;
		assertEquals(compareFinal, appt.compareTo(compareAppt));

	}

	// cant test toString() ? or any private functions

}