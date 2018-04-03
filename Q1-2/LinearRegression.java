/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent with 1 variable.
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class LinearRegression {


 /** 
     * Number of samples (usually "m" in litterature) 
     */
 private int nbreOfSamples;


 /** 
     * the sample vector
     */
 private double[] samples;

 /** 
     * the samples target values
     */
 private double[] samplesValues;

 /** 
     * the current hypthesis function: theta0 + theta1 x
     */
 private double theta0, theta1;


 /** 
     * used to ensure that the object is ready
     */
 private int currentNbreOfSamples;



 /** 
     * counts how many iterations have been performed
     */
 private int iteration;

 private static int counter = 0;
 /** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is y = 0;
     * 
     * 
     * @param m the number of samples that we will have
     *
     */
  public LinearRegression(int m){
    this.nbreOfSamples = m;
    this.iteration=0;// your code goes there
    this.samples = new double[m];
    this.samplesValues = new double[m];
 }

 /** 
     * Adds a new sample to samples and to samplesValues. This
     * method must be iteratively called with all the samples
     * before the gradient descent can be started
     * 
     * @param x the new sample
     * @param y the corresponding expected value
     *
  */
 public void addSample(double x, double y){   
        this.samples[currentNbreOfSamples] = x;
        this.samplesValues[currentNbreOfSamples] = y;
        currentNbreOfSamples++;
    }
  // your code goes there
 

 /** 
     * Returns the current hypothesis for the value of the input
     * @param x the input for which we want the current hypothesis
     * 
  * @return theta0 + theta1 x
  */
 private double hypothesis(double x){
    return this.theta0 + this.theta1 * x;// your code goes there
 }

 /** 
     * Returns a string representation of hypthesis function
     * 
  * @return the string "theta0 + theta1 x"
  */
 public String currentHypothesis(){
    return ("Current hypothesis: " + this.theta0 + " + " + this.theta1 + " x");
  // your code goes there
 }

 /** 
     * Returns the current cost
     * 
  * @return the current value of the cost function
  */
 public double currentCost(){
    double sum = 0;
    for(int i=0; i<this.nbreOfSamples; i++) {
        sum += java.lang.Math.pow(this.theta0 + this.theta1 * this.samples[i] - samplesValues[i], 2);
    }// your code goes there
    return sum/this.nbreOfSamples;
 }

 /** 
     * runs several iterations of the gradient descent algorithm
     * 
     * @param alpha the learning rate
     *
     * @param numberOfSteps how many iteration of the algorithm to run
     */
 public void gradientDescent(double alpha, int numberOfSteps) {
    double theta0sum = 0;
    double theta1sum = 0;
    for(int i=0; i<numberOfSteps; i++){
        for(int j=0; j<this.nbreOfSamples; j++){
            theta0sum += this.theta0 + this.theta1 * this.samples[j] - this.samplesValues[j];
            theta1sum += (this.theta0 + this.theta1 * this.samples[j] - this.samplesValues[j])*this.samples[j];
        }
        this.theta0 -= 100000*alpha * 2 / this.nbreOfSamples * theta0sum;
        this.theta1 -= alpha * 2 / this.nbreOfSamples * theta1sum;
        this.iteration++;
    }
  // your code goes there
 }



 /** 
     * Getter for theta0
     *
  * @return theta0
  */

 public double getTheta0(){
    return this.theta0;// your code goes there
 }

 /** 
     * Getter for theta1
     *
  * @return theta1
  */

 public double getTheta1(){
    return this.theta1;// your code goes there
 }

 /** 
     * Getter for samples
     *
  * @return samples
  */

 public double[] getSamples(){
    return this.samples;// your code goes there
 }

 /** 
     * Getter for getSamplesValues
     *
  * @return getSamplesValues
  */

 public double[] getSamplesValues(){
    return this.samplesValues;// your code goes there
 }

 /** 
     * Getter for iteration
     *
  * @return iteratio
  n
  */

 public int getIteration(){
    return this.iteration;// your code goes there
 }
}