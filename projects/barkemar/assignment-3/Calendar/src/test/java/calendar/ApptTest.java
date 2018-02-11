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

	@Test
	public void testRecur()  throws Throwable  {

		int startHour = 4;
		int startMinute = 2;
		int startDay = 2;
		int startMonth = 2;
		int startYear = 2000;
		String title = "Birthday title";
		String description = "this is my description";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,	startMinute,startDay,startMonth,startYear,title,description);


		int[] recurDaysArray = null;
		int recurBy = 6;
		int recurIncrement = 6;
		int recurNumber = 6;
		appt.setRecurrence(recurDaysArray, recurBy, recurIncrement, recurNumber);


		int RecurNumber = appt.getRecurNumber();
		assertEquals(RecurNumber, 6);

		RecurNumber = appt.getRecurBy();
		assertEquals(RecurNumber, 6);


		assertEquals(appt.isRecurring(), true);


		assertEquals(appt.getRecurIncrement(), 6);

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
		//making suer that isValid() is called within the setStartHour function:

		Appt apptValidRemoved = new Appt(7, startMinute, startDay, startMonth, startYear, title, description);
		apptValidRemoved.setStartHour(99);
		assertEquals(apptValidRemoved.getValid(), false);

		Appt apptValidRemoved2 = new Appt(7, 7, startDay, startMonth, startYear, title, description);
		apptValidRemoved2.setStartMinute(77);
		assertEquals(apptValidRemoved2.getValid(), false);

		Appt apptValidRemoved3 = new Appt(7, 7, 7, startMonth, startYear, title, description);
		apptValidRemoved3.setStartDay(99);
		assertEquals(apptValidRemoved3.getValid(), false);

	//	Appt apptValidRemoved4 = new Appt(7, 7, 7, 7, startYear, title, description);
	//	apptValidRemoved4.setStartMonth(0);
	//	assertEquals(apptValidRemoved4.getValid(), false);

//		Appt apptValidRemoved5 = new Appt(7, 7, 7, startMonth, startYear, title, description);
//		apptValidRemoved5.setStartYear(9);
//		assertEquals(apptValidRemoved5.getValid(), false);

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


	//Test the representationApp function
	@Test
	public void testRep() throws Throwable {

		int startHour=21;
		int startMinute=11;
		int startDay=22;
		int startMonth=02;
		int startYear=2010;
		String title="BirthdayTitle";
		String description="BirthdayDescription";
		Appt Appt1 = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description);
		// assertions
	//	System.out.println(Appt1.toString());
		String newString = "\t2/22/2010 at 9:11pm ,BirthdayTitle, BirthdayDescription\n";

		assertEquals(newString, Appt1.toString());

		/*
				String half = (getStartHour() > 11) ? "pm" : "am";
				//if StartHour > 11: pm,
				 if StartHour  < 11; am
		 */
		Appt Appt2 = new Appt(9,startMinute ,startDay ,startMonth ,startYear ,title,description);
	//	System.out.println(Appt2.toString());
		newString = "\t2/22/2010 at 9:11am ,BirthdayTitle, BirthdayDescription\n";
		assertEquals(newString, Appt2.toString());

		Appt Appt3 = new Appt(11,startMinute ,startDay ,startMonth ,startYear ,title,description);
	//	System.out.println(Appt3.toString());
		newString = "\t2/22/2010 at 11:11am ,BirthdayTitle, BirthdayDescription\n";
		assertEquals(newString, Appt3.toString());

		Appt Appt4 = new Appt(12,startMinute ,startDay ,startMonth ,startYear ,title,description);
		//	System.out.println(Appt4.toString());
		newString = "\t2/22/2010 at 12:11pm ,BirthdayTitle, BirthdayDescription\n";
		assertEquals(newString, Appt4.toString());

		Appt Appt5 = new Appt(13,startMinute ,startDay ,startMonth ,startYear ,title,description);
		//	System.out.println(Appt4.toString());
		newString = "\t2/22/2010 at 1:11pm ,BirthdayTitle, BirthdayDescription\n";
		assertEquals(newString, Appt5.toString());

	}


	/**
	 *   Test that the isValid function works  correctly
	 */
	@Test
	public void test021() throws Throwable {

		int startHour = 6;
		int startMinute = 7;
		int startDay = 7;
		int startMonth = 7;
		int startYear = 2012;
		String title = "Birthday title";
		String description = "this is my description";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,	startMinute,startDay,startMonth,startYear,title,description);


		/*setHour
			Testing:  if(startHour<=0 || startHour>23)
						return false
				//MY ADDED ERROR:
			Original: if(startHour < 0 …)
			Bug:      if(startHour <= 0

		*/
		Appt appt0 = new Appt(0,	startMinute,startDay,startMonth,startYear,title,description);
		assertEquals(   appt0.getValid() , false);

		Appt apptneg4 = new Appt(-4,	startMinute,startDay,startMonth,startYear,title,description);
		assertEquals(   apptneg4.getValid() , false);

		Appt appt1 = new Appt(1,	startMinute,startDay,startMonth,startYear,title,description);
		assertEquals(   appt1.getValid() , true);

		Appt appt23 = new Appt(23,	startMinute,startDay,startMonth,startYear,title,description);
		assertEquals(  appt23.getValid() , true);

		Appt appt24 = new Appt(24,	startMinute,startDay,startMonth,startYear,title,description);
		assertEquals(  appt24.getValid() , false);

		Appt appt33 = new Appt(33,	startMinute,startDay,startMonth,startYear,title,description);
		assertEquals(  appt33.getValid() , false);


		/*test Minute
				if(startMinute<0 || startMinute>59)
        			this.valid=false;
		*/
		Appt apptneg = new Appt(startHour,	-1,startDay,startMonth,startYear,title,description);
		assertEquals(apptneg.getValid(), false);

		Appt apptmin0 = new Appt(startHour,	0,startDay,startMonth,startYear,title,description);
		assertEquals(apptmin0.getValid(), true);

		Appt apptminMiddle = new Appt(startHour,	23,startDay,startMonth,startYear,title,description);
		assertEquals(apptminMiddle.getValid(), true);

		Appt apptmin59 = new Appt(startHour,59,startDay,startMonth,startYear,title,description);
		assertEquals(apptmin59.getValid(), true);

		Appt appt60 = new Appt(startHour,60,startDay,startMonth,startYear,title,description);
		assertEquals(appt60.getValid(), false);

		Appt apptmin99 = new Appt(startHour,99,startDay,startMonth,startYear,title,description);
		assertEquals(apptmin99.getValid(), false);

		/*test Day
						if(startDay<1 || startDay>NumDaysInMonth)
							this.valid=false;
		 */
		Appt apptdayneg1 = new Appt(startHour,	startMinute,-1,startMonth,startYear,title,description);
		assertEquals(apptdayneg1.getValid(), false);

		Appt apptday1 = new Appt(startHour,	startMinute,1,startMonth,startYear,title,description);
		assertEquals(apptday1.getValid(), true);

		Appt apptday2 = new Appt(startHour,	startMinute,2,startMonth,startYear,title,description);
		assertEquals(apptday2.getValid(), true);

		int NumDaysInMonth = CalendarUtil.NumDaysInMonth(startYear,startMonth-1);
		Appt apptdayNDIM = new Appt(startHour,	startMinute,NumDaysInMonth-1, startMonth,startYear,title,description);
		//startday = numdaysinmonth-1
		assertEquals(apptdayNDIM.getValid(), true);

		Appt apptdayNDIM2 = new Appt(startHour,	startMinute,NumDaysInMonth, startMonth,startYear,title,description);
		//startday = numdaysinmonth
		assertEquals(apptdayNDIM2.getValid(), true);

		Appt apptdayNDIM3 = new Appt(startHour,	startMinute, NumDaysInMonth+1, startMonth,startYear,title,description);
		//startday = numdaysinmonth+1
		assertEquals(apptdayNDIM3.getValid(), false);

		/* startMonth
						if(startMonth<1 || startMonth>12)
                			this.valid=false;

		Appt appt = new Appt(startHour,	startMinute,startDay,startMonth,startYear,title,description);
		 */

		//  int NumDaysInMonth= CalendarUtil.NumDaysInMonth(startYear,startMonth-1);
		// in order to get to the if(startMonth statements, these conditions need to be true:
		//			startHour must be between 1 and 23
		//			startDay must be between 1 and NumDaysInMonth



//		Appt apptmonthneg = new Appt(startHour,startMinute, startDay, 0,startYear,title,description);
//		int NumDaysInMonth= CalendarUtil.NumDaysInMonth(startYear,startMonth-1);
//			NumDaysInMonth = CalendarUtil.NumDaysInMonth(2012, -1)
// 						   = not valid, cant test
//		assertEquals(apptmonthneg.getValid(), false);


//		Appt apptmonth1 = new Appt(startHour,startMinute, startDay, 1,startYear,title,description);
//			NumDaysInMonth = CalendarUtil.NumDaysInMonth(2012, 0)
// 						   = not valid, cant test
//		assertEquals(apptmonth1.getValid(), false);



		Appt apptmonth12 = new Appt(startHour,startMinute, startDay, 12,startYear,title,description);
//			NumDaysInMonth = CalendarUtil.NumDaysInMonth(2012, 11)
// 						   = valid, can test
		assertEquals(apptmonth12.getValid(), true);

		Appt apptmonth11 = new Appt(startHour,startMinute, startDay, 11,startYear,title,description);
		assertEquals(apptmonth11.getValid(), true);



//		Appt apptmonth13 = new Appt(startHour,startMinute, startDay, 13,startYear,title,description);
//		assertEquals(apptmonth13.getValid(), false);

	}

	@Test
	public void test09() throws Throwable {
		//toString, representationApp, and compareTo test
		Appt appt = new Appt(12, 2, 2, 2, 2000, "T", "D");
		Appt appt2 = new Appt(3, 2, 2, 2, 2000, "T", "D");
		Appt appt3 = new Appt(0, 0, 1, 2, 2000, "T", "D");



		int iTest = appt.compareTo(appt2);
		assertEquals(appt.compareTo(appt2), 9);


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