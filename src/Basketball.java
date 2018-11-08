import javafx.scene.control.Label;

public class Basketball {

	private static int twoPoints;
	private static int threePoints;
	private static int foul;
	private static int miss;
	private static int totalShots;
	private static double twoPointAvg;
	
	public static void main(String[] args) {
		System.out.println(Basketball.twoPoints);

	}


	public static int setFoul() {
		return foul +=1;
	}
	public static int setMiss() {
		return miss +=1;
	}
	
	

	public static int getTwoPoints() {
		
		return twoPoints;
	}

	public static void setTwoPoints(int twoPoints) {
		Basketball.twoPoints = twoPoints;
	}

	public static int getThreePoints() {
		
		return threePoints;
	}

	public static void setThreePoints(int threePoints) {
		Basketball.threePoints = threePoints;
		
	}
public static int getFouls() {
		
		return foul;
	}
public static void setFouls(int foul) {
	Basketball.foul = foul;
	
}
public static int getMisses() {
	
	return miss;
}
public static void setMisses(int miss) {
Basketball.miss = miss;

}


}
