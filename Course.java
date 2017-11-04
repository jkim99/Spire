import java.io.*;
public class Course {
	private String subject;
	private String courseNumber;
	private String name;
	private String genEds;
	public Course(String sub, String cnum, String n, String ge) {
		subject = sub;
		courseNumber = cnum;
		name = n;
		genEds = ge;
	}

	public String getSubject() {
		return subject;
	}
	
	public String getCourseNumber() {
		return courseNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getGenEds() {
		return genEds;
	}

	public String toString() {
		return subject + "   " + courseNumber + "   " + name + "   " + genEds + "   ";
	}
}


/*
14625720
67501042

javac -cp commons-csv-1.5.jar ProcessData.java Course.java
java -cp .;commons-csv-1.5.jar ProcessData
*/