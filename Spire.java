import java.util.*;
public class Spire {
	private String course;
	private double finalScore;
	private ArrayList<Double> grades;

	public Spire() {
		
	}
	public double addGrade(double x) {
		grades.add(new Double(x));
	}
}