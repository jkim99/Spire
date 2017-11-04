import java.io.*;
public class Course {
	private int courseNumberInt;
	private String subject;
	private String courseNumber;
	private String name;
	private String genEds;
	private String[] majors;
	private String[] preReqs;

	public Course(String sub, String cnum, String n, String ge, String[] m, String[] pr) {
		subject = sub;
		courseNumber = cnum;
		name = n;
		genEds = ge;
		majors = m;
		preReqs = pr;
		courseNumberInt = Integer.valueOf("0" + courseNumber.replaceAll("\\D+",""));
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

	public String[] getMajors() {
		return majors;
	}

	public String[] getPreReqs() {
		return preReqs;
	}

	public String toString() {
		String major = "";
		String preReq = "";
		for(int i = 0; i < majors.length; i++)
			major += majors[i].replace("\0", "") + " ";
		for(int i = 0; i < preReqs.length; i++)
			preReq += preReqs[i] == null ? "" : preReqs[i];
 		return subject + "   " + courseNumber + "   " + name + "   " + genEds + "   " + major + "   " + preReq + "   ";
	}
}


/*
14625720
67501042

cd Desktop/spire
javac -cp commons-csv-1.5.jar;apache-tomcat-9.0.1/lib/servlet-api.jar ProcessData.java Course.java
java -cp .;commons-csv-1.5.jar;apache-tomcat-9.0.1/lib/servlet-api.jar ProcessData
*/