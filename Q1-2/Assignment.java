/**
 * The class  <b>Assignment</b> is used to
 * test our LinearRegression class. It uses the
 * provided class <b>Display</b> to show the results
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
     * In this second method, we will select a line at random.
     *  1) we select a line y = ax + b, with a randomly selected
     * between -100 and +100 and b randomly selected between 
     * -250 and +250
     *  2) we add 500 samples randomly selected on the line
     * between -100 and +300. For each sample we add a "noise" 
     * randomly selected between -1000 and +1000 (that is, for
     * each randomly selected x, we add the sample (x, ax+b+noise).
     * where "noise" is randomly selected between -1000 and 1000
     *  3) We create an instance of Display
     *  4) we iterate gradient descent (find a number of iterations,
     * a number of updates to the instance of Display, and a 
     * step alpha that seems to work
     */
 private static void randomLine(){
        LinearRegression z = new LinearRegression(500);
        double a = -100 + (100 - -100) * generator.nextDouble();
        double b = -250 + (250 - -250) * generator.nextDouble();
        for(int j=0; j<500; j++) {
            double xvalue = -100 + (300 - -100) * generator.nextDouble();
            double yvalue = (a*xvalue+b-1000) + ((a*xvalue+b+1000) - (a*xvalue+b-1000)) * generator.nextDouble();
            z.addSample(xvalue,yvalue);
        }
        Display graph1 = new Display(z);
        graph1.setTarget(a,b);
        for(int h=0; h<50; h++) {
            System.out.println(z.currentHypothesis());
            System.out.println("Current cost: " + z.currentCost());
            graph1.update();
            z.gradientDescent(0.00000003, 20);
        }
  // your code goes there
 }


 public static void main(String[] args) {

     StudentInfo.display();

  System.out.println("randomLine");
  randomLine();

 }

}