package actionsClass;

public class Student {
	private String name;
	private int age;
	
	public void setName(String name){
		this.name=name;
	}
	public void setAge(int age){
	if(age>0)
		this.age=age;
	else
		this.age=0;
	}
	public String getName(){
		System.out.println("Name:"+name);
		return name;}
	public int getAge(){
		System.out.println("Age:"+age);
		return age;}
public static void main(String[] args) {
	Student s=new Student();
	s.setAge(-22);
	s.setName("kiran");
	s.getAge();
	s.getName();
	
}


}
