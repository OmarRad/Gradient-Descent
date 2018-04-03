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
     *   add the sample [(i, 2i), 5i] for 0&lt;=i&lt;=999
     *   add the sample [(2i, i), 4i] for 0&lt;=i&lt;=999
     *  3) we iterate gradient descent 10,000, printing out the
     * current hypothesis and the current cost every 1,000 
     * iterations, using a step alpha of 0.000000003
     */
    private static void setPlane(){
        LinearRegression n = new LinearRegression(2, 2000);
        for (int i = 0; i<=999; i++) {
            double[] double_array = new double[3];
            double_array[0] = 1;
            double_array[1] = i;
            double_array[2] = 2*i;
            n.addSample(double_array, 5*i);
            double[] double_array2 = new double[3];
            double_array2[0] = 1;
            double_array2[1] = 2*i;
            double_array2[2] = i;
            n.addSample(double_array2, 4*i);
        }
        for(int h = 0; h<10; h++) {
            n.gradientDescent(0.000000003, 1000);
            System.out.println(n.currentHypothesis());
            System.out.println("Current cost: " + n.currentCost());
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
    LinearRegression e = new LinearRegression(2, 5000);
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
        e.addSample(double_array, avalue*x_1+bvalue*x_2+cvalue+delta);
    }
    for (int z=0; z<200; z++) {
        System.out.println(e.currentHypothesis());
        System.out.println("Current cost: " + e.currentCost());
        System.out.println("Aiming for: x_3 = " + cvalue  + " + " + avalue + "x_1" + " + " + bvalue + "x_2");
        e.gradientDescent(0.00000000003,70);
    }
  // your code goes there
 }

 /** 
     * In this third method, we will follow the same approach
     * that the one followed in the method  randomPlane, but
     * this time we will have a variable number of dimensions,
     * specified by the parameter "dimension". We will
     * create 5000 samples of "dimension" dimension, where each
     * dimension will be ranmly selected between  -100 and +100,
     * and a randomly selected noise between -20 and +20 will be
     * added to the result.We will then iterate gradient descent 
     * (find a number of iterations,
     * and a step alpha that seems to work, regularly printing
     * the target,  the current hypothesis and the current cost)
     *
     * @param dimension the number of features
     */
 private static void randomDimension(int dimension){
    LinearRegression d = new LinearRegression(dimension, 5000);
    double[] double_array_t = new double[dimension+1];
    //double_array_t[0] = -100 + (100 - -100) * generator.nextDouble();
    //5String aim = "Aiming for : " + double_array_t[0] + " * x_0";
    String aim = "";
    for(int i=0; i<dimension+1; i++){
      double_array_t[i] = -100 + (100 - -100) * generator.nextDouble();
      if (i>0) {
        aim += " + " + double_array_t[i] + " * x_" + i;
      }  else {
        aim = "Aiming for : " + double_array_t[i] + " * x_0";
      }
    }
    for(int j = 0; j<5000; j++) {
        double[] double_array_x = new double[dimension+1];
        double_array_x[0] = 1.0;
        for (int k = 0; k<dimension+1; k++) {
            double_array_x[k] = 50 + (4000 - 50) * generator.nextDouble();
        }
        double r = -20 + (20 - -20) * generator.nextDouble();;
        for(int i = 0; i < dimension + 1; i++) {
            r += double_array_x[i] * double_array_t[i];
        }
        d.addSample(double_array_x, r);
    }
    for (int z=0; z<50; z++) {
        System.out.println(d.currentHypothesis());
        System.out.println("Current cost: " + d.currentCost());
        System.out.println(aim);
        d.gradientDescent(0.0000000003,100);
    }
}
 


 public static void main(String[] args) {

  StudentInfo.display();

  System.out.println("randomDimension");
  randomDimension(50);


 }

}