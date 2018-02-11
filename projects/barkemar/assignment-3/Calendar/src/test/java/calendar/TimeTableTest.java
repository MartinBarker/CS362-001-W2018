package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.*;
import java.util.concurrent.Future;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {


	@Test
	// test getApptRange function
	public void testapp1()  throws Throwable  {

		TimeTable testTable = new TimeTable();
		GregorianCalendar TodayDate = new GregorianCalendar(2018, 2, 11);
		GregorianCalendar future = new GregorianCalendar(2018, 2, 13);
		GregorianCalendar TomorrowDate = new GregorianCalendar(2018, 2, 12);

		String title = "title";
		String description = "description";
		int year = 2018;
		int month = 2;

		Appt appt1 = new Appt(4, 10, 10, month, year, title, description);
		Appt appt2 = new Appt(4, 11, 11, month, year, title, description);
		Appt appt3 = new Appt(4, 12, 12, month, year, title, description);

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt1);
		appts.add(appt2);
		appts.add(appt3);

		testTable.deleteAppt( appts, appt1);
		testTable.deleteAppt( appts, appt2);
		testTable.deleteAppt( appts, appt3);


		assertNotEquals(testTable, null);

		assertNotEquals(appts, null);

	    assertNotEquals(testTable.getApptRange(appts, TodayDate, TomorrowDate), null);

		assertNotEquals(testTable.getApptRange(appts, TodayDate, future), null);

		//testTable

		/*
		getApptsRange(list, firstday, LastDay)
					if firstday is NOT before lastday: throw error
		  */
	//	assertNotEquals(testTable.getApptRange(appts, future, TodayDate), true);

		// for ( int i = 1; i < appts.size() - 1; i++){
		//appts.size = 2  ( 0 , 1 ,  2)
		//System.out.println(appts.size());
		//ORIGINAL NO-BUG:  from 1 to 2 (1)
		for(int i = 1; i < appts.size(); i++){
			System.out.println("in for loop, i="+i);
		}
		//with bug: from 1 to 1 ( never prints out once)
		System.out.println("g:"+testTable.getApptRange(appts, TodayDate, TomorrowDate));
	}

	  //tests that the getApptRange function works correctly
		// could not test
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour = 2;
		 int startMinute = 8;
		 int startDay = 12;
		 int startMonth = 4;
		 int startYear = 2018;
		 String title = "cool title!";
		 String description = "cool description!";
		 Appt appt = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);

		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 appts.add(appt);

		 Calendar rightnow3 = Calendar.getInstance();    //current month/year/date is today
		 int thisMonth = rightnow3.get(Calendar.MONTH)+1;
		 int thisYear = rightnow3.get(Calendar.YEAR);
		 int thisDay = rightnow3.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 CalDay firstDay = new CalDay(today);
		 CalDay firstDayClone = new CalDay(today);

		 int thisMonth2 = rightnow3.get(Calendar.MONTH)+1;
		 int thisYear2 = rightnow3.get(Calendar.YEAR)+1;  //will be next year
		 int thisDay2 = rightnow3.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today2 = new GregorianCalendar(thisYear2,thisMonth2,thisDay2);
		 CalDay lastDay = new CalDay(today2);

		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 GregorianCalendar nextDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 while (nextDay.before(lastDay)) {

			 calDays.add(new CalDay(nextDay));
			 nextDay.add(nextDay.DAY_OF_MONTH, 1);
		 }

		 for (int i = 1; i < appts.size()-1; i++) {
			 Appt apptTemp=appts.get(i);
			 if(!apptTemp.getValid()) continue;
			 // Figure out which days the appointment occurs on

			//need getApptOcucureneces function
			 LinkedList<GregorianCalendar> result = new LinkedList<GregorianCalendar>();
			 GregorianCalendar occurrenceDay =
					 new GregorianCalendar(apptTemp.getStartYear(), apptTemp.getStartMonth(),
							 apptTemp.getStartDay());
			 for (int z = 0; z < appt.getRecurNumber()+1; z++) {

				 //Add the day of occurrence to the list if it is after the first day
				 if (!occurrenceDay.before(firstDay)) {
					 result.add(occurrenceDay);
				 }

				 GregorianCalendar nextDay2 = new GregorianCalendar(apptTemp.getStartYear(), apptTemp.getStartMonth(),
						 apptTemp.getStartDay());

				 //Calculate the next recurrence day
				 occurrenceDay = nextDay2; //getNextApptOccurrence(apptTemp, occurrenceDay);
				 //apptTemp = appt , occuranceDay = day
	//			 GregorianCalendar nextDay2 = new GregorianCalendar(apptTemp.getStartYear(), apptTemp.getStartMonth(),
	//					 apptTemp.getStartDay());
	//			 switch(apptTemp.getRecurBy()) {
	//				 case apptTemp.RECUR_BY_WEEKLY:
	//					 int[] recurDays = appt.getRecurDays();
	//
				 }

			 }
			 //return result;

	//		 LinkedList<GregorianCalendar> apptOccursOnDays = result;


			 int daysDifference = 0;
			 nextDay = new GregorianCalendar(thisYear,thisMonth,thisDay);
//			 Iterator<GregorianCalendar> itr = apptOccursOnDays.iterator();
//			 while (itr.hasNext()) {
//				 GregorianCalendar apptOccursOn = (GregorianCalendar) itr.next();

//				 while (nextDay.before(apptOccursOn)) {
//					 //	daysDifference++;
	//				 nextDay.add(nextDay.DAY_OF_MONTH, 1);
//				 }

//				 CalDay calDayOfAppt = (CalDay) calDays.get(daysDifference);
//				 calDayOfAppt.addAppt(apptTemp);

			 }

//	 }
	//test that public deleteappt works
	 @Test
	  public void test02()  throws Throwable  {
		 int startHour = 2;
		 int startMinute = 8;
		 int startDay = 12;
		 int startMonth = 4;
		 int startYear = 2018;
		 String title = "cool title!";
		 String description = "cool description!";
		 Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		 Appt appt2 = new Appt(startHour+1, startMinute+1, startDay+1, startMonth+1, startYear+1, title, description);
		 Appt appt3 = new Appt(startHour+8, startMinute+8, startDay, startMonth, startYear, title, description);

		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 LinkedList<Appt> appts_just1 = new LinkedList<Appt>();
		 appts.add(appt1);
		 appts_just1.add(appt1);
		 appts.add(appt2);

		 Calendar rightnow3 = Calendar.getInstance();    //current month/year/date is today
		 int thisMonth = rightnow3.get(Calendar.MONTH)+1;
		 int thisYear = rightnow3.get(Calendar.YEAR);
		 int thisDay = rightnow3.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 CalDay firstDay = new CalDay(today);

		 firstDay.addAppt(appt1);
		 firstDay.addAppt(appt2);

		 TimeTable timeTable=new TimeTable();
		 LinkedList<Appt> listDeletedAppts = timeTable.deleteAppt(appts, appt2);
		 LinkedList<Appt> listDeletedAppts_Null = timeTable.deleteAppt(appts, appt3);


		 LinkedList<Appt> appts_new = new LinkedList<Appt>();
		 appts_new.add(appt1);
		 LinkedList<Appt> appts_new_more = appts_new;
		 appts_new_more.add(appt2);

     //	 assertEquals(appts_new.get(0), timeTable.deleteAppt(appts_new_more, appt2).get(0));
	//	 firstDay.deleteAppt
		 assertEquals(null, timeTable.deleteAppt(appts, appt3) );
		assertEquals(null, timeTable.deleteAppt(null, null));
		assertEquals(null, timeTable.deleteAppt(appts, null));
		 assertEquals(null, timeTable.deleteAppt(null, appt3));

		 //mutation safeguards:



	 }

	@Test
	// test permute function
	public void testPermute()  throws Throwable  {
		Appt Appt1 = new Appt(8,21 ,1 ,	11 ,	2018,	"t","d");
		Appt Appt2 = new Appt(2,2 ,2 ,	11 ,	2018 ,"t","d");
		Appt Appt3 = new Appt(2,3 ,3 ,11 ,2018 ,"t","d");
		Appt Appt4 = new Appt(2,3 ,21 ,11 ,2018 ,"t","d");
		Appt Appt5 = new Appt(2,5 ,110000 ,11 ,2018 ,"t","d");

		TimeTable timetableTest = new TimeTable();
		GregorianCalendar today = new GregorianCalendar(2018, 11, 2); //5
		GregorianCalendar yesterday = new GregorianCalendar(2018, 11, 3); //4
		GregorianCalendar tomorrow = new GregorianCalendar(2018, 11, 4); //30
		LinkedList<Appt> appts = new LinkedList<Appt>();

		int[] testArray = new int[]{0,1,2,3,4};


		appts.add(Appt1);
		appts.add(Appt2);
		appts.add(Appt3);
		appts.add(Appt4);
		appts.add(Appt5);

		timetableTest.getApptRange(appts, today, tomorrow);

		timetableTest.permute(appts, testArray);

		timetableTest.deleteAppt(appts, Appt1);


	}

	//test tht permute works
	@Test
	public void test03() throws Throwable {
		int startHour = 2;
		int startMinute = 8;
		int startDay = 12;
		int startMonth = 4;
		int startYear = 2018;
		String title = "cool title!";
		String description = "cool description!";
		Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
		Appt appt2 = new Appt(startHour+4, startMinute, startDay, startMonth, startYear, title, description);

		LinkedList<Appt> appts = new LinkedList<Appt>();
		appts.add(appt1);
		appts.add(appt2);
		appts.add(appt1);

		int[] myIntArray = {3,2,1};

		LinkedList<Appt> apptsUpdatedList=new LinkedList<Appt>(appts);

		int nexti =  0;
		for(int i = 0;i<myIntArray.length;i++){
			int newi = myIntArray[nexti];
			newi = myIntArray[nexti];
	//		Collections.swap(apptsUpdatedList,newi,newi);          //causing out of bounds error?
	//		nexti = newi;
		}
		//apptsUpdatedList = the updated permuted array;

		TimeTable timeTable=new TimeTable();

		//thought this would work, but it didnt!
//		assertEquals(apptsUpdatedList, timeTable.permute(appts, myIntArray));
	}


//add more unit tests as you needed
}
