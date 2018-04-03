/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. 
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class Assignment {




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




 public static void main(String[] args) {

  StudentInfo.display();

  System.out.println("setPlane");
  setPlane();


 }

}