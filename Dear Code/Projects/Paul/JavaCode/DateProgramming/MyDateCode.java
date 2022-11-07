import java.util.*;
import java.text.*;
class DobDay{
public static void main(String []args){
Scanner kb=new Scanner(System.in);
System.out.println("Enter your DOB(dd-MMM-yyyy)");
String dob=kb.next();
SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
try
{
Date dt=sdf.parse(dob);
SimpleDateFormat sdfa=new SimpleDateFormat("EEEE");
String day=sdfa.format(dt);
System.out.println("Your are born in "+day);
}
catch(ParseException p){
System.out.println("You enter worng format: "+p.getMessage());
}
}
}