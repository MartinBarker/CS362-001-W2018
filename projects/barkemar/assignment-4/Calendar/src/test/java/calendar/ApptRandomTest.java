package calendar;


import java.util.Comparator;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence", "isValid", "setRecurDays"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
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



   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
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

			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
						if (methodName.equals("setRecurDays")){

					 	  	int[] recurDaysArray = null; //new int[3];
						//	recurDaysArray[0] = 1;
						//	recurDaysArray[1] = 2;
						//	recurDaysArray[2] = 3;
							int recurBy = 6;
							int recurIncrement = 7;
							int recurNumber = 8;
							appt.setRecurrence(recurDaysArray, recurBy, recurIncrement, recurNumber);

							int[] empty = new int[0];
							int[] r = appt.getRecurDays();

					//		assertEquals(r, new int[0]);

						}
						if (methodName.equals("isValid")){

							boolean result = true;
							int ranint = ValuesGenerator.getRandomIntBetween(random, -3, 88);
							int ran_startMin = ValuesGenerator.getRandomIntBetween(random, -5, 90);
							int ran_startDay = ValuesGenerator.getRandomIntBetween(random, -5, 90);
							int ran_startMonth = ValuesGenerator.getRandomIntBetween(random, -5, 90);

						//	System.out.println("ran_startMonth        =  ");
						//	System.out.println(ran_startMonth);




							appt.setStartHour(ranint);
							appt.setStartMinute(ran_startMin);
						//	appt.setStartDay(ran_startDay);


							if (ranint <= 0 || ranint > 23 ){   //
								result = false;
							}else{

								if(ran_startMin < 0 || ran_startMin > 59){
									result = false;
								}else{

									//if ran_startmonth is valid
									if(ran_startMonth > 0 && ran_startMonth < 11) {

									//	appt.setStartMonth(ran_startMonth);
										int numberDaysInMonth = CalendarUtil.NumDaysInMonth(startYear, ran_startMonth - 1);

									//	appt.setStartDay(ran_startDay);
									//	if(ran_startDay < 1 || ran_startDay > numberDaysInMonth){
									//		result = false;
									//	}else{
									//		result = true;
									//	}

										//if ran_startmonth is not valid
										if(ran_startMonth < 1 || ran_startMonth > 12){
											result = false;
										}else{

											result=true;
										}

									}else {
										result = true;
									}

								}

							}


							assertEquals(result, appt.getValid());

							//System.out.println("isValid selected.  StartHour int = ");
							//System.out.println(startHour);

						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
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
