import java.util.Scanner;

public class BMICalculator {
	
	int flag = 0;
	float calcBMI;
		
	public static void main(String[] args) {
	    BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}	
	
	public float weight;
	public float height;
	public float BMI;
	public int Category;
	
		public float getweight() {
			return weight;
		}
		
		public void setWeight(float newWeight) {
			weight = newWeight;
		}
		
		public float getheight() {
			return height;		
		}
			
		public void setHeight(float newHeight) {
			height = newHeight;
		}
			
		public float getBMI() {
			return BMI;
			}
	
		// prompt/read user data
		public void readUserData() {
			
			Scanner input = new Scanner(System.in);
			
			
			System.out.println("For Metric Input 1, For Imperial Input 2: ");
			int unitType = input.nextInt();
			
			// loop until proper value found
			if (unitType != 1 && unitType != 2) {
				while (unitType != 1 && unitType != 2) {
					System.out.println("Try Again. Please enter your choice...");
					System.out.println("For Metric Input 1, For Imperial Input 2: ");
						unitType = input.nextInt();
				}
			}
			
			// relay flag to read type of desired unit
			flag = readUnitType(unitType, flag);
			
			// read data to imperial or metric
			readMeasurementData(flag);
			
			input.close();
	
		}
		
			// determine type of unit
			private int readUnitType(int unitType, int flag){
				
				// set flag for metric
				if (unitType == 1)
					flag = 1;
			
				// set flag for imperial
				if (unitType == 2)
					flag = 2;
				
				return flag;
			}
	
			// read data based on unit type
			private void readMeasurementData(int flag){
				
				if (flag == 1)
				readMetricData();
				
				if (flag == 2)
				readImperialData();
				
			}
			
				// read metric data
				private void readMetricData(){
									
					Scanner input = new Scanner(System.in);
					
					// prompt user
					System.out.println("- METRIC -");
					System.out.println("Please enter your height...");
					System.out.println("Centimeters: ");
						float cm = input.nextInt();
					
					
					// terminate if height is negative
					if (cm < 0) {
						System.out.println("- Program Terminated -");
						System.exit(0);
					}
						
					// calculate cm to m
					float m = 1;
					m = cm / 100;
										
					// set height in cm
					setHeight(m);
	
					System.out.println("Please enter your weight in Kilos: ");
					int kilo = input.nextInt();
					
					
					// terminate if weight is negative
					if (kilo < 0) {
						System.out.println("- Program Terminated -");
						System.exit(0);
					}
					
						
					// set pounds
					setWeight(kilo);				
								
					input.close();
	
				}
				
				// read imperial data
				private void readImperialData(){
					
					int totalInches;
					
					Scanner input = new Scanner(System.in);
					
					// prompt user
					System.out.println("- IMPERIAL -");
					System.out.println("Please enter your height...");
					System.out.println("Feet: ");
						int feet = input.nextInt();				
					System.out.println("Inches: ");
						int inches = input.nextInt();
	
					totalInches = (feet * 12) + inches;
					
					
					// terminate if height is negative
					if (totalInches < 0) {
						System.out.println("- Program Terminated -");
						System.exit(0);
					}
					
					// set height in inches
					setHeight(totalInches);
	
					System.out.println("Please enter your weight: ");
					int poundsImperial = input.nextInt();

					
					// terminate if weight is negative
					if (poundsImperial < 0) {
						System.out.println("- Program Terminated -");
						System.exit(0);
					}
					
					// set pounds
					setWeight(poundsImperial);				
								
					input.close();
				}
			
		
			// once data input is complete, calculate BMI
			public void calculateBmi() {
				
				float calcHeight;
				float calcWeight;
				
				calcHeight = getheight();
				calcWeight = getweight();
				
					// calculate for metric
					if (flag == 1) {
						
						// squaring the meters
						float Squared = (calcHeight * calcHeight);
						
						// calculating bmi
						calcBMI = (calcWeight) / Squared;
					}
					
					// calculate for imperial
					if (flag == 2) {
						
						// squaring the inches
						float Squared = (calcHeight * calcHeight);
						
						// calculating bmi
						calcBMI = (703 * (calcWeight)) / Squared;
					}
					
					calculateBMICategory();
				
			}
		
		private void calculateBMICategory() {
			
			System.out.println("- BMI CATEGORY: -");
			
			if (calcBMI < 18.5)
				System.out.println("Under Weight");

			if (calcBMI >= 18.5 && calcBMI <= 24.9)
				System.out.println("Normal Weight");
			
			if (calcBMI >= 25 && calcBMI <= 29.9)
				System.out.println("Overweight");

			if (calcBMI >= 30)
				System.out.println("Obesity");
		}
		
	// display BMI results
	public void displayBmi() {

		System.out.printf("Your BMI is %.2f", calcBMI);

	}
	
}
