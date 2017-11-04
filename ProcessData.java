import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVFormat;

public class ProcessData extends HttpServlet {
	private static String[][] classData;
	private static Course courses[];
	public static void main(String args[]) {
		try {
			File file = new File("C:/Users/jonat/Desktop/spire/Project - C.csv");
			Reader in = new FileReader(file);
			CSVParser parser = new CSVParser(in, CSVFormat.RFC4180);
			List<CSVRecord> records = parser.getRecords();
			classData = new String[records.size()][];
			for(int i = 0; i < records.size(); i++) {
				CSVRecord record = records.get(i);
				classData[i] = new String[record.size()];
				for(int j = 0; j < record.size(); j++)
					classData[i][j] = record.get(j);
			}
			courses = new Course[classData.length];
			for(int i = 0; i < classData.length; i++) {
				String[] majors = new String[5];
				for(int j = 0; j < majors.length; j++) {
					try {
						majors[j] = classData[i][j + 4];
					}
					catch(Exception e) {}
				}

				String[] preReqs = new String[classData[i].length - 3];
				for(int j = 0; j < preReqs.length; j++) {
					try {
						preReqs[j] = classData[i][j + 9];
					}
					catch(Exception e) {}
				}

				courses[i] = new Course(classData[i][0],
										classData[i][1],
										classData[i][2],
										classData[i][3],
										majors,
										preReqs);
				System.out.println(courses[i]);
			}

			//TESTING
			System.out.println();
			Course[] names = searchName("Tech");
			for(int i = 0; i < names.length; i++) { System.out.println(names[i]); }
			
			System.out.println();
			Course[] subject = searchSubject("astron");
			for(int i = 0; i < subject.length; i++) { System.out.println(subject[i]); }

			System.out.println();
			Course[] genEd = searchGenEds("HS U");
			for(int i = 0; i < genEd.length; i++) { System.out.println(genEd[i]); }

		}
		catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static Course[] searchName(String name) {
		int count = 0;
		for(int i = 0; i < courses.length; i++) {
			if(containsIgnoreCase(courses[i].getName(), name)) {
				count++;
			}
		}
		int k = 0;
		Course[] ret = new Course[count];
		for(int i = 0; i < courses.length; i++) {
			if(containsIgnoreCase(courses[i].getName(), name)) {
				ret[k] = courses[i];
				k++;
			}
		}
		return ret;
	}

	public static Course[] searchSubject(String subject) {
		int count = 0;
		for(int i = 0; i < courses.length; i++) {
			if(courses[i].getSubject().equalsIgnoreCase(subject)) {
				count++;
			}
		}
		int k = 0;
		Course[] ret = new Course[count];
		for(int i = 0; i < courses.length; i++) {
			if(courses[i].getSubject().equalsIgnoreCase(subject)) {
				ret[k] = courses[i];
				k++;
			}
		}
		return ret;
	}

	public static Course[] searchCourseNumber(String courseNumber) {
		int count = 0;
		for(int i = 0; i < courses.length; i++) {
			if(courses[i].getCourseNumber().equalsIgnoreCase(courseNumber)) {
				count++;
			}
		}
		int k = 0;
		Course[] ret = new Course[count];
		for(int i = 0; i < courses.length; i++) {
			if(courses[i].getCourseNumber().equalsIgnoreCase(courseNumber)) {
				ret[k] = courses[i];
				k++;
			}
		}
		return ret;
	}

	public static Course[] searchGenEds(String geneds) {
		int count = 0;
		for(int i = 0; i < courses.length; i++) {
			if(courses[i].getGenEds().equalsIgnoreCase(geneds)) {
				count++;
			}
		}
		int k = 0;
		Course[] ret = new Course[count];
		for(int i = 0; i < courses.length; i++) {
			if(courses[i].getGenEds().equalsIgnoreCase(geneds)) {
				ret[k] = courses[i];
				k++;
			}
		}
		return ret;
	}

	public static Course[] searchMajor(String major) {
		int count = 0;
		for(int i = 0; i < courses.length; i++) {
			String[] majors = courses[i].getMajors();
			for(int j = 0; j < majors.length; j++) {
				if(majors[j].equalsIgnoreCase(major)) {
					count++;
				}
			}
		}
		int k = 0;
		Course[] ret = new Course[count];
		for(int i = 0; i < courses.length; i++) {
			String[] majors = courses[i].getMajors();
			for(int j = 0; j < majors.length; j++) {
				if(majors[j].equalsIgnoreCase(major)) {
					ret[k] = courses[i];
					k++;
				}
			}
		}
		return ret;
	}

	public static Course[] searchPreReqs(String preReq) {
		int count = 0;
		for(int i = 0; i < courses.length; i++) {
			String[] preReqs = courses[i].getPreReqs();
			for(int j = 0; j < preReqs.length; j++) {
				if(preReqs[j].equalsIgnoreCase(preReq)) {
					count++;
				}
			}
		}
		int k = 0;
		Course[] ret = new Course[count];
		for(int i = 0; i < courses.length; i++) {
			String[] preReqs = courses[i].getPreReqs();
			for(int j = 0; j < preReqs.length; j++) {
				if(preReqs[j].equalsIgnoreCase(preReq)) {
					ret[k] = courses[i];
					k++;
				}
			}
		}
		return ret;
	}

	private static boolean containsIgnoreCase(String s1, String s2) {
		s1 = s1.toUpperCase();
		s2 = s2.toUpperCase();

		return s1.contains(s2);
	}
}

//class name
//class number
//class description
//gen eds
//major minor
//pre requisites