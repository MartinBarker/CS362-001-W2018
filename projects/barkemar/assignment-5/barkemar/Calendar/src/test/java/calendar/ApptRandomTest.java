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
				System.out.println(" Seed:"+randomseed );
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

		//		 System.out.println("new appt constructed");

//			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
	//				System.out.println("methodname="+ methodName);
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

				//			System.out.println("testing isvalid");
							boolean result = true;
							int ran_startHour = ValuesGenerator.getRandomIntBetween(random, -3, 88);
							int ran_startMin = ValuesGenerator.getRandomIntBetween(random, -5, 90);
							int ran_startDay = ValuesGenerator.getRandomIntBetween(random, -5, 90);
							int ran_startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
							startYear = ValuesGenerator.getRandomIntBetween(random, 1, 9999);

							System.out.println("\n Appt Values: \n"+" startYear = "+startYear+"\n ran_startHour = "+ran_startHour+"\n ran_startMin = "+ran_startMin +"\n ran_startDay="+ran_startDay+"\n ran_startMonth = "+ran_startMonth+" ");


							appt.setStartHour(ran_startHour);
							appt.setStartMinute(ran_startMin);
							appt.setStartDay(ran_startDay);
						appt.setStartYear(startYear);
							appt.setStartMonth(ran_startMonth);

							//preliminary check for startmonth, since it is used to calcualte NumDaysInMonth
		//					if(ran_startMonth < 1 || ran_startMonth > 12) {

		//						System.out.println("ran_startMonth is false so dont continue");
		//						int numberDaysInMonth = CalendarUtil.NumDaysInMonth(startYear, ran_startMonth - 1);
		//						System.out.println("numberDaysInMonth = "+numberDaysInMonth);

		//						result=false;
		//					}else {
		//						appt.setStartMonth(ran_startMonth);

					//		System.out.println("getMonth = "+appt.getStartMonth());
					//			int ND= CalendarUtil.NumDaysInMonth(startYear,startMonth-1);
					//			System.out.println("NUmDaysInMonth = "+ND);

					//		System.out.println("result="+result);
			//				System.out.println("\n Appt Values: \n"+" ran_startHour = "+ran_startHour+"\n ran_startMin = "+ran_startMin +"\n ran_startDay="+ran_startDay+"\n ran_startMonth = "+ran_startMonth+" ");

			//				if(result!=false) {

								if (ran_startHour < 0 || ran_startHour > 23) {
								//	System.out.println("ran_startHour is not valid, so set result = false");
									result = false;
								} else {

									if (ran_startMin < 0 || ran_startMin > 59) {

								//		System.out.println("ran_startMin is not valid, so set result = false");
										result = false;
									} else {

										int NumDaysInMonth= CalendarUtil.NumDaysInMonth(startYear,ran_startMonth-1);
			//							System.out.println("(test)NumDaysInMonth = "+NumDaysInMonth);
										if(ran_startDay<1 || ran_startDay>NumDaysInMonth) {
											result = false;
										}else{
														//     <    original
											if (ran_startMonth < 1 || ran_startMonth > 12) {
												result = false;
											} else {
												result = true;
											}

										}

									}

								}
		//					}
							System.out.println("This appt.getValid() should be equal to result = "+ result);
							System.out.println("Actual appt.getValid() = "+appt.getValid());
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
