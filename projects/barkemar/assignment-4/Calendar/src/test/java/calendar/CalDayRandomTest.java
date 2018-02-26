package calendar;


import java.util.Comparator;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.*;




/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {



		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			//	 long randomseed =System.currentTimeMillis();
			//	 Random random = new Random(randomseed);


		//		 if(!appt.getValid())continue;
				 for (int i = 0; i < NUM_TESTS; i++) {

				 	// test the add apt function

					 long randomseed =System.currentTimeMillis(); //10

					 Random random = new Random(randomseed);

					 int startHour=ValuesGenerator.RandInt(random);
					 int startMinute=ValuesGenerator.RandInt(random);
					 int startDay=ValuesGenerator.RandInt(random);
					 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					 int startYear=ValuesGenerator.RandInt(random);
					 String title="Birthday Party";
					 String description="This is my birthday party.";
					 //Construct a new Appointment object with the initial data
					 Appt appt = new Appt(startHour, startMinute ,startDay ,startMonth ,startYear ,title,description);

					 //get todays date
					 //Calendar rightnow = Calendar.getInstance();
					 //current month/year/date is today
					 int thisMonth = ValuesGenerator.RandInt(random); //rightnow.get(Calendar.MONTH)+1;
					 int thisYear = ValuesGenerator.RandInt(random); //rightnow.get(Calendar.YEAR);
					 int thisDay = ValuesGenerator.RandInt(random); //rightnow.get(Calendar.DAY_OF_MONTH);
					 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
					 CalDay calday = new CalDay(today);

					 calday.addAppt(appt);

					 LinkedList<Appt> appts = new LinkedList<Appt>();
					 //appts.add(appt);

					 if(appt.getValid() == false){
					 	//System.out.println("appt trying to get added is invalid ");
					 	//linked list will be empty
						 assertEquals(appts, calday.getAppts());
					 }else {

					 	appts.add(appt);
					 	assertEquals(appts, calday.getAppts());

						 int startHour2 = ValuesGenerator.RandInt(random);
						 int startMinute2 = ValuesGenerator.RandInt(random);
						 int startDay2 = ValuesGenerator.RandInt(random);
						 int startMonth2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);
						 int startYear2 = ValuesGenerator.RandInt(random);
						 String title2 = "Birthday Party";
						 String description2 = "This is my birthday party.";
						 //Construct a new Appointment object with the initial data
						 Appt appt2 = new Appt(startHour2, startMinute2, startDay2, startMonth2, startYear2, title2, description2);

						 calday.addAppt(appt2);
					//	 System.out.println("calday.getAppts:");
					//	 System.out.println(calday.getAppts());
						 if (startHour2 > startHour) {
								// then add appt2 after appt, add appt2 at end of list
							 	appts.add(appt2);
							//    assertEquals(appts, calday.getAppts());
						 }

					 }
				 }

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if((iteration%10000)==0 && iteration!=0 )
					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			 }
		 }catch(NullPointerException e){

		 }

		 System.out.println("Done testing...");
	 }
		 
		 
	 }


	
//}
