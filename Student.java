package practice;

public class Student {
	private String Major;
	private Course courses[];
	private String name;
	private String studentId;

	Student(String Major,String name,String studentId,Course c[])
	{

		this.Major=Major;
		this.name=name;
		this.studentId=studentId;
		courses=c;
	}

	public Course[] getCourses()
	{
		return courses;
	}

	public String getMajor() {
		return Major;
	}



	public String getName() {
		return name;
	}



	public String getStudentId() {
		return studentId;
	}
}
