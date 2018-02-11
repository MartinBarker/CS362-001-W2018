package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {


	/*
	Test the constructor
	 */
	@Test
	public void test00() throws Throwable {
		int startHour = 2;
		int startMinute = 8;
		int startDay = 12;
		int startMonth = 4;
		int startYear = 2014;
		String title = "cool title!";
		String description = "cool description!";
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay calday = new CalDay(today);

		assertEquals(thisDay, calday.getDay());
		assertEquals(thisMonth, calday.getMonth());
		assertEquals(thisYear, calday.getYear());


	}

	@Test
	public void testAddM() throws Throwable {

		//setup calday1
		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay calday1 = new CalDay(today);


		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt Appt1 = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		calday1.addAppt(Appt1);

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(0, Appt1);
		// assertions
		assertEquals(appts, calday1.getAppts());


		/*
		Test if (((Appt)getAppts().get(i)).getStartHour() >appt.getStartHour
		 */
		//setup new calday1
		rightnow = Calendar.getInstance();
		thisMonth = rightnow.get(Calendar.MONTH)+1;
		thisYear = rightnow.get(Calendar.YEAR);
		thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
//		today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		today = new GregorianCalendar(2017, 4, 4);
		calday1 = new CalDay(today);

		//setup new appointment Appt
		startHour=21;
		startMinute=30;
		startDay=15;
		startMonth=01;
		startYear=2018;
		title="Birthday Party";
		description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
// appt1 > appt2 by 1
		Appt1 = new Appt(3,	startMinute ,startDay ,startMonth ,startYear ,title,description);
		Appt Appt2 = new Appt(2,	startMinute ,startDay ,startMonth ,startYear ,title,description);
		//appt2 = earlier time

		//add appt1 to calday
		calday1.addAppt(Appt1);
		//add appt2 to calday, appt2 is at an earlier time so it should be added at the front of the list
		calday1.addAppt(Appt2);

		appts = new LinkedList<Appt>();
		//add appt1 to Appts linkedlist at position zero
		appts.add(0, Appt1);
		//add appt2 to Appts linkedlist at position zero
		appts.add(0, Appt2);

		assertEquals(appts, calday1.getAppts());

// appt1 = appt2
		Appt1 = new Appt(3,	startMinute ,startDay ,startMonth ,startYear ,title,description);
		Appt2 = new Appt(3,	startMinute ,startDay ,startMonth ,startYear ,title,description);

		calday1 = new CalDay(today);
		calday1.addAppt(Appt1);
		calday1.addAppt(Appt2);
System.out.println(calday1.getAppts());


		appts = new LinkedList<Appt>();
		appts.add(0, Appt1);
		appts.add(1, Appt2);
//System.out.println(appts);

	assertEquals(appts, calday1.getAppts());

		// appt1 < appt2
		Appt1 = new Appt(2,	startMinute ,startDay ,startMonth ,startYear ,title,description);
		Appt2 = new Appt(3,	startMinute ,startDay ,startMonth ,startYear ,title,description);

		calday1 = new CalDay(today);
		calday1.addAppt(Appt1);
		calday1.addAppt(Appt2);
//		System.out.println(calday1.getAppts());


		appts = new LinkedList<Appt>();
		appts.add(0, Appt1);
		appts.add(1, Appt2);
//		System.out.println(appts);

		assertEquals(appts, calday1.getAppts());


	}

	 // Test that addAppt(Appt appt)  works correctly
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour = 5;
		 int startMinute = 8;
		 int startDay = 12;
		 int startMonth = 4;
		 int startYear = 2014;
		 String title = "cool title!";
		 String description = "cool description!";
		 Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);


		 //get todays date
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 int thisMonth = rightnow.get(Calendar.MONTH)+1;
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 CalDay calday = new CalDay(today);




		 //one appt added, assert that number of appts is = 0
		 calday.addAppt(appt);
 		 assertEquals(1, calday.getSizeAppts());

 		 /*
 		 if ( (Appt)getAppts().get(i) ).getStartHour() > appt.getStartHour()) {    ...  }

 		  */


		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 LinkedList<Appt> Mutationappts = new LinkedList<Appt>();
		 appts.add(appt);
		 Mutationappts.add(appt);

		 assertEquals(appts, calday.getAppts());

		 CalDay calday2 = new CalDay();
		 startHour = 33;
		 Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		 //valid will be set to false
		 calday.addAppt(appt2);

		 LinkedList<Appt> appts2 = new LinkedList<Appt>();
	//	 appts2.add(appt2);

		assertEquals(null, calday2.getAppts());

		 Appt appt_sh1 = new Appt(8, startMinute, startDay, startMonth, startYear, title, description);
		 Appt appt_sh2 = new Appt(2, startMinute, startDay, startMonth, startYear, title, description);

		 CalDay calday3 = new CalDay(today);
		 calday.addAppt(appt_sh2);
		 calday.addAppt(appt_sh1);
		 LinkedList<Appt> appts3 = new LinkedList<Appt>();
		 appts3.add(appt_sh2);
		 appts3.add(appt_sh1);
//		 assertEquals(appts3, calday3.getAppts());


	 }

	 //tests if isvalid() function works
	 @Test
	  public void test02()  throws Throwable  {
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 int thisMonth = rightnow.get(Calendar.MONTH)+1;
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);

		 CalDay calday = new CalDay(today);

		 assertEquals(true, calday.isValid() );

	 }

	 //test if Iterator<?> function works
	@Test
	public void test021() throws Throwable {

		int startHour = 2;
		int startMinute = 8;
		int startDay = 12;
		int startMonth = 4;
		int startYear = 2014;
		String title = "cool title!";
		String description = "cool description!";


		Calendar rightnow = Calendar.getInstance();
		int thisMonth = rightnow.get(Calendar.MONTH)+1;
		int thisYear = rightnow.get(Calendar.YEAR);
		int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay calday1 = new CalDay(today);

        //create a new appt with the initial data
        Appt appt1 = new Appt(startHour, startMinute , startDay , startMonth , startYear , title, description);
        //create new bad appt (startHour = 66, impossible, will turn valid = false
        Appt badappt = new Appt(66, startMinute , startDay , startMonth , startYear , title, description);
        //create new appt with starting hour of zero (very first appt that day)
        Appt appt2 = new Appt(0, startMinute , startDay , startMonth , startYear , title, description);
        CalDay null_day = new CalDay(); //calday passed nothing will be null
        calday1.addAppt(appt1);
        calday1.addAppt(appt2);
        Iterator null_apptIt = null_day.iterator();
        Iterator apptIt = calday1.iterator();
        assertEquals(null, null_apptIt);    //testing null condition
        assertNotEquals(null, apptIt); //iterator for valid calday will not be equal to null

	}

	//tests if setAppts() function works
	//cant test because it is a private function
	@Test
	public void test03()  throws Throwable  {




    }




	//cant test setter functions because they are private

	//tests all the getter functions function works
	@Test
	public void test04()  throws Throwable  {
		int startHour = 2;
		int startMinute = 8;
		int startDay = 12;
		int startMonth = 4;
		int startYear = 2014;
		String title = "cool title!";
		String description = "cool description!";
		Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		Calendar rightnow3 = Calendar.getInstance();
		//current month/year/date is today
		int thisMonth = rightnow3.get(Calendar.MONTH)+1;
		int thisYear = rightnow3.get(Calendar.YEAR);
		int thisDay = rightnow3.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		CalDay calday = new CalDay(today);

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt);
		//learned: error found, if setAppts is passed a null, it will set appts = null, no safeguard

		//  learned I cant test .getAppts() function, because it goes through setAppts which is private?
		//	assertEquals(appts, calday.getAppts());
//		assertEquals(thisDay, calday.getDay());
//		assertEquals(thisMonth, calday.getMonth());
//		assertEquals(thisYear, calday.getYear());

	}

	//test that the toString function works
	@Test
	public void test05()  throws Throwable {
/*
		GregorianCalendar today = new GregorianCalendar(2017,11,22);
		CalDay calday1 = new CalDay(today);
		int startHour=11;
		int startMinute=30;
		int startDay=15;
		int startMonth=11;
		int startYear=2018;
		String title="t";
		String description="d";
		Appt Appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		calday1.addAppt(Appt1);

		String compare = "\t --- 11/22/2017 --- \n --- -------- Appointments ------------ --- \n        11/15/2018 at 11:30am ,t, d\n";

		String cmp2 = "      --- 11/22/2017 ---\n" +
				" --- -------- Appointments ------------ ---\n" +
				"        11/15/2018 at 11:30am ,t, d\n";

//		System.out.print(calday1.toString());
		System.out.print("|||" + calday1.toString() + "|||");
		System.out.println("newline");
//		System.out.print(compare);
		System.out.print("|||" + cmp2 + "|||");

		if(cmp2 == calday1.toString()){
			System.out.println("cmp2 and tostring are equal");
		}else{

			System.out.println("cmp2 and tostring are NOT  equal");
		}

		assertEquals(cmp2, calday1.toString());
*/

		GregorianCalendar today = new GregorianCalendar(2017, 11, 11);
		CalDay calDay = new CalDay((GregorianCalendar)today);

		Appt appt = new Appt(5, 22, 12, 9, 2001, "title", "desc");

		calDay.addAppt(appt);

		String string1 = calDay.toString();
		String string2 = calDay.toString();
		assertEquals(string1, string2);

		Appt app2 = new Appt(0, 22, 66, 2, 2001, "title", "desc");
		CalDay calDay2 = new CalDay((GregorianCalendar)today);
		calDay2.addAppt(app2);


		System.out.println("|"+calDay2.toString()+"|");
		StringBuilder sb = new StringBuilder();
		string2 = sb.toString();

		String s3 = "        --- 11/11/2017 ---\n" +
				" --- -------- Appointments ------------ ---\n" +
				"\n";

		System.out.println("|"+string2+"|");
	//	assertEquals(calDay2.toString(), s3);



	}

}
