import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BusResev {
   public static void main(String[] args) {
       int userOption = 1;
       ArrayList<Bus> buses = new ArrayList<Bus>();
       ArrayList<Booking> bookings = new ArrayList<Booking>();
       buses.add(new Bus(1,true,2));
       buses.add(new Bus(2,false,50));
       buses.add(new Bus(3,true,30));
       for(Bus b : buses)
       {
        b.displayDetails();
       }
       Scanner sc = new Scanner(System.in);
       while(userOption == 1)
       {
        System.out.println("Enter 1 for booking and 2 for exit");
        userOption = sc.nextInt();
        if(userOption==1)
        {
         Booking booking = new Booking();
         if(booking.isAvailable(buses,bookings))
         {
            bookings.add(booking);
            System.out.println("Your booking is successfully booked");
         }
         else
         {
            System.out.println("bus is full,booking unable to process");
         }
        }
       } 
     }
}
class Bus 
{
private int busNo ;
private boolean AC;
private int capacity;
Bus(int busNo,boolean ac , int capacity)
{
    this.busNo = busNo;
    this.AC = ac;
    this.capacity = capacity;
}
public int getbusNo()
{
    return busNo;
}
public int getCapacity()
{
    return capacity;
}
public void setCapacity(int cp)
{
    capacity = cp ;
}
public void displayDetails()
{
    System.out.println("Busno is :"+busNo + " ac or non-ac : "+AC +" capacity is " +capacity);
}

}
class Booking
{
String passengerName;
int busNo;
Date date;
public boolean isAvailable(ArrayList<Bus> buses,ArrayList<Booking> bookings )
{  int capacity = 0;
    for(Bus  b : buses)
    {
        if(b.getbusNo() == busNo)
        {
            capacity = b.getCapacity();
        }

    }
    int booked = 0;
    for(Booking bk : bookings)
    {
        if(bk.busNo==busNo&bk.date.equals(date))
        {
            booked++;
        }
    }
    return booked<capacity?true:false;
}
Booking()
{     
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter your Name ");
    passengerName = sc.next();
    System.out.println("Enter bus number ");
    busNo = sc.nextInt();
    System.out.println("Enter Date in dd-mm-yy");
    String dateInput = sc.next();
    SimpleDateFormat simpledate = new SimpleDateFormat("dd-MM-yy");
    try {
        date = simpledate.parse(dateInput);
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}