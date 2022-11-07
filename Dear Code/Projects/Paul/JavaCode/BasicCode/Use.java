class Values{
private int a;
public Values(int a){
this.a=a;
}
/*public String toString(){
return "Number is "+a;
}*/
}
class ToStringOverride{
public static void main(String[] args){
Values obj=new Values(9);
System.out.println(obj);
String name=new String("sourabh");
System.out.println(name);
}}