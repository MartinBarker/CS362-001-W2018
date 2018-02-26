package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;




public class TimeTableRandomTest {

	/**
	 * Generate Random Tests that tests TimeTable Class.
	 */
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	public static int RandomSelectRecur(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return the value of the  appointments to recur
	}
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
	public static int RandomSelectRecurForEverNever(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return appointments to recur forever or Never recur
	}

	@Test
	public void radnomtest()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing TimeTable...");

		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {

				long randomseed =System.currentTimeMillis();
				Random random = new Random(randomseed);

				for (int i = 0; i < NUM_TESTS; i++) {



					//all valid appointmnets
					int startHour=ValuesGenerator.getRandomIntBetween(random,0,23);
					int startMinute=ValuesGenerator.getRandomIntBetween(random,0,59);
					int startDay=ValuesGenerator.RandInt(random);
					int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
					int startYear=2018;
					String title="Birthday Party";
					String description="This is my birthday party.";
					//Construct a new Appointment object with the initial data
					Appt appt = new Appt(startHour, startMinute ,startDay ,startMonth ,startYear ,title,description);

					//set reccurences for appt
					int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
					int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
					int recur=ApptRandomTest.RandomSelectRecur(random);
					int recurIncrement = ValuesGenerator.RandInt(random);
					int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);

					appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);

					//generate appt2
					startHour=ValuesGenerator.getRandomIntBetween(random,0,23);
					startMinute=ValuesGenerator.getRandomIntBetween(random,0,59);
					startDay=ValuesGenerator.RandInt(random);
					startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);

					//Construct a new Appointment object with the initial data
					Appt appt2 = new Appt(startHour, startMinute ,startDay ,startMonth ,startYear ,title,description);

					//generate appt3
					startHour=ValuesGenerator.getRandomIntBetween(random,0,23);
					startMinute=ValuesGenerator.getRandomIntBetween(random,0,59);
					startDay=ValuesGenerator.RandInt(random);
					startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
					//Construct a new Appointment object with the initial data
					Appt appt3 = new Appt(startHour, startMinute ,startDay ,startMonth ,startYear ,title,description);

					//generate appt4
					Appt appt4 = null;

					LinkedList<Appt> appts = new LinkedList<Appt>();


					appts.add(appt);
					appts.add(appt2);
					appts.add(appt3);


					/**
					 * create timetable
 					 */
					TimeTable timetable=new TimeTable();

					int year=ValuesGenerator.RandInt(random);
					int month=ValuesGenerator.getRandomIntBetween(random, 1, 12);;
					int day=ValuesGenerator.getRandomIntBetween(random, 0, 30);;


					GregorianCalendar today = new GregorianCalendar(year, month, day);
					GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
					tomorrow.add(Calendar.DAY_OF_MONTH,3);
					LinkedList<CalDay> calDays = new LinkedList<CalDay>();
					calDays = timetable.getApptRange(appts, today, tomorrow);


					LinkedList<Appt> appts2 = new LinkedList<Appt>();
					appts2 = timetable.deleteAppt(appts,appt2);
					//appts2: delete appt2 from appts


					appts2 = timetable.deleteAppt(appts,appt4);
					//appts2: delete appt4 from appts
					//appts2 = null
					assertNull(appts2);

					appts2 = timetable.deleteAppt(appts2,appt4);
					//appts2: delete appt4 from appts2
					appts.add(appt2);

					appts2 = timetable.deleteAppt(appts,appt2);


				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			} //For TestTimeout

		}catch(NullPointerException e){

		}

	}
}


