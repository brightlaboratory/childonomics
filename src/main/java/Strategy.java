/**
 * The Strategy class creates objects that contain multiple category objects in a dynamic array.
 *
 * @author Sidarth Shahri
 */

public class Strategy {
    // Variable Declarations
    public Category catArray[];
    private double parentPayoff;
    private double childPayoff;

    // Constructors
    public Strategy(int input) {
        catArray = new Category[input];
        parentPayoff = 0.0;
        childPayoff = 0.0;
    }

    // Functions
    public void generatePayoffValues(int numOfCategories) {
        for (int i = 0; i < numOfCategories; i++) {
            parentPayoff += catArray[i].getFracOfSpend() * catArray[i].getParentValue();
            childPayoff += catArray[i].getFracOfSpend() * catArray[i].getChildValue();
        }
    }

    public double getChildPayoff() {
        return childPayoff;
    }

    public double getParentPayoff() {
        return parentPayoff;
    }
}
