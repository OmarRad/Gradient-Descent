/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. 
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class Assignment {


 /** 
     * Random generator 
     */
 private static java.util.Random generator = new java.util.Random();

    /** 
     * In this first method, we are simply using sample points that are
     * on a straight plane. We will use the plane z= x + 2x.
     * In his method, 
     *  1) we create an instance of LinearRegression.
     *  2) we add 2,000 samples from the plane z= x + 2x as follows:
     *   add the sample [(i, 2i), 5i] for 0<=i<=999
     *   add the sample [(2i, i), 4i] for 0<=i<=999
     *  3) we iterate gradient descent 10,000, printing out the
     * current hypothesis and the current cost every 1,000 
     * iterations, using a step alpha of 0.000000003
     */
    private static void setPlane(){
        LinearRegression l = new LinearRegression(2, 2000);
        for (int i = 0; i<=999; i++) {
            double[] double_array = new double[3];
            double_array[0] = 1;
            double_array[1] = i;
            double_array[2] = 2*i;
            l.addSample(double_array, 5*i);
            double[] double_array2 = new double[3];
            double_array2[0] = 1;
            double_array2[1] = 2*i;
            double_array2[2] = i;
            l.addSample(double_array2, 4*i);
        }
        for(int h = 0; h<10; h++) {
            l.gradientDescent(0.000000003, 1000);
            System.out.println(l.currentHypothesis());
            System.out.println("Current cost: " + l.currentCost());
        }
  // your code goes there
 }

 /** 
     * In this second method, we will select a plane at random.
     *  1) we select a line z = ax + by + c, with a, b and c 
     * randomly selected between -100 and +100 
     *  2) we add 5000 samples randomly selected on the plane
     * with x and y both randomly selected between 50 and 4000. 
     * For each sample we add a "noise" 
     * randomly selected between -20 and +20 (that is, for
     * each randomly selected x and y we add the sample 
     *[ (x,y), ax+by+c+noise).
     * where "noise" is randomly selected between -20 and 20
     *  4) we iterate gradient descent (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     */

 private static void randomPlane(){
    LinearRegression v = new LinearRegression(2, 5000);
    double avalue = -100 + (100 - -100) * generator.nextDouble();
    double bvalue = -100 + (100 - -100) * generator.nextDouble();
    double cvalue = -100 + (100 - -100) * generator.nextDouble();
    for(int h = 0; h<5000; h++) {
        double x_1 = 50 + (4000 - 50) * generator.nextDouble();
        double x_2 = 50 + (4000 - 50) * generator.nextDouble();
        double delta = -20 + (20 - -20) * generator.nextDouble();
        double[] double_array = new double[3];
        double_array[0] = 1;
        double_array[1] = x_1;
        double_array[2] = x_2;
        v.addSample(double_array, avalue*x_1+bvalue*x_2+cvalue+delta);
    }
    for (int z=0; z<200; z++) {
        System.out.println(v.currentHypothesis());
        System.out.println("Current cost: " + v.currentCost());
        System.out.println("Aiming for: x_3 = " + cvalue  + " + " + avalue + "x_1" + " + " + bvalue + "x_2");
        
        v.gradientDescent(0.00000000003,70);
    }
    
  // your code goes there
 }


 public static void main(String[] args) {

  StudentInfo.display();

  System.out.println("randomPlane");
  randomPlane();



 }

}