/**
 * The class  <b>LinearRegression</b> implements gradient
 * descent for multiple variables
 *
 * @author gvj (gvj@eecs.uottawa.ca)
 *
 */

public class LinearRegression{


 /** 
     * Number of features (usually "n" in litterature) 
     */
 private int nbreOfFeatures;

 /** 
     * Number of samples (usually "m" in litterature) 
     */
 private int nbreOfSamples;


 /** 
     * the nbreOfFeatures X nbreOfSamples Matrix of samples
     */
 private double[][] samplesMatrix;

 /** 
     * the nbreOfSamples Matrix of samples target values
     */
 private double[] samplesValues;

 /** 
     * the nbreOfFeatures Matrix theta of current hypthesis function
     */
 private double[] theta;


 /** 
     * number of samples received so far
     */
 private int currentNbreOfSamples;

 /** 
     * a place holder for theta during descent calculation
     */
 private double[] tempTheta;


 /** 
     * counts how many iterations have been performed
     */
 private int iteration;

 /** 
     * Object's contructor. The constructor initializes the instance
     * variables. The starting hypthesis is theta[i]=0.0 for all i
     * 
     * @param n the number of features that we will have
     * @param m the number of samples that we will have
  *
     */
  public LinearRegression(int n, int m){
    nbreOfSamples = m;
    nbreOfFeatures = n+1;
    iteration = 0;
    samplesMatrix = new double[m][nbreOfFeatures];
    samplesValues = new double[m];
    theta = new double[nbreOfFeatures];
    tempTheta = new double[nbreOfFeatures];
    currentNbreOfSamples = 0;
  // your code goes there
 }

 /** 
     * Add a new sample to samplesMatrix and samplesValues
     * 
     * @param x the vectors of samples
     * @param y the coresponding expected value
     *
  */
 public void addSample(double[] x, double y){
    samplesMatrix[currentNbreOfSamples] = x;
    samplesValues[currentNbreOfSamples] = y;
    currentNbreOfSamples++;
  // your code goes there
 }

 /** 
     * Returns the current hypothesis for the value of the input
     * @param x the input vector for which we want the current hypothesis
     * 
  * @return h(x)
  */

 private double hypothesis(double[] x){
    double sum = 0;
    for (int i = 0; i<nbreOfFeatures; i++) {
        sum += theta[i] * x[i];
    }
    return sum;
  // your code goes there

 }

 /** 
     * Returns a string representation of hypthesis function
     * 
  * @return the string "theta0 x_0 + theta1 x_1 + .. thetan x_n"
  */

 public String currentHypothesis(){
    String sum = Double.toString(theta[0]);
    for (int i = 1; i<nbreOfFeatures; i++) {
        sum += " + " + theta[i] + "*x_" + i;
    }
    return (sum);
  // your code goes there
 }

 /** 
     * Returns the current cost
     * 
  * @return the current value of the cost function
  */

 public double currentCost(){
    double sum = 0;
    for(int i=0; i<nbreOfSamples; i++) {
        sum += java.lang.Math.pow(hypothesis(samplesMatrix[i]) - samplesValues[i], 2);
    }
    return sum/nbreOfSamples;
  // your code goes there
 }

 /** 
     * runs several iterations of the gradient descent algorithm
     * 
     * @param alpha the learning rate
     *
     * @param numberOfSteps how many iteration of the algorithm to run
     */

 public void gradientDescent(double alpha, int numberOfSteps) {
    for(int i=0; i<numberOfSteps; i++) {
        tempTheta = new double[nbreOfFeatures];

        for(int j=0; j<nbreOfFeatures;j++) {
            for(int h=0; h<nbreOfSamples; h++) {
                tempTheta[j] += (hypothesis(samplesMatrix[h]) - samplesValues[h]) * samplesMatrix[h][j];
            }
            tempTheta[j] = alpha*2 / nbreOfSamples * tempTheta[j];
        }
        for (int d=0; d<nbreOfFeatures; d++) {
            theta[d] -= tempTheta[d];
        }
        iteration++;
    }
  // your code goes there
 }


 /** 
     * Getter for theta
     *
  * @return theta
  */

 public double[] getTheta(){
    return theta;
  // your code goes there

 }

 /** 
     * Getter for iteration
     *
  * @return iteration
  */

 public int getIteration(){
    return iteration;
  // your code goes there

 }
}