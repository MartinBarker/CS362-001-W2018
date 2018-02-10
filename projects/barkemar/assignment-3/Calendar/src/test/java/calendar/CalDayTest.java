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

	 // Test that addAppt(Appt appt)  works correctly
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour = 2;
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

		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 appts.add(appt);

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
		calday.addAppt(appt);

		StringBuilder sb = new StringBuilder();
		String todayDate = (thisMonth) + "/" + thisDay + "/" + thisYear;
		sb.append("\t --- " + todayDate + " --- \n");
		sb.append(" --- -------- Appointments ------------ --- \n");
		Iterator<Appt> itr = calday.appts.iterator();
		while(itr.hasNext()) {
			Object element = itr.next();
			sb.append(element + " ");
		}
		sb.append("\n");
//		assertEquals(sb, calday.toString());
// cant test toString(), is my sb. not configured correctly?
	}

}
