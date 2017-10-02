/**
 * The Category class creates objects that hold data about the specific categories used to calculate payoff values.
 *
 * @author Sidarth Shahri
 */

public class Category {
    // Variable Declarations
    private String categoryName;    // Name of each category
    private double fracOfSpend;     // Number between 0 and 1
    private int parentValue;        // Number between 0 and 100
    private int childValue;         // Number between 0 and 100

    // Constructors
    public Category() {
        this.categoryName = null;
        this.fracOfSpend = 0.0;
        this.parentValue = -1;
        this.childValue = -1;
    }

    public Category(String name, double fracOfSpend, int parentValue, int childValue) {
        this.categoryName = name;
        this.fracOfSpend = fracOfSpend;
        this.parentValue = parentValue;
        this.childValue = childValue;
    }

    // Function declarations
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setFracOfSpend(double fracOfSpend) {
        this.fracOfSpend = fracOfSpend;
    }

    public void setParentValue(int parentValue) {
        this.parentValue = parentValue;
    }

    public void setChildValue(int childValue) {
        this.childValue = childValue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getFracOfSpend() {
        return fracOfSpend;
    }

    public int getParentValue() {
        return parentValue;
    }

    public int getChildValue() {
        return childValue;
    }

    public void print() {
        System.out.printf("Category Name: %s\n", categoryName);
        System.out.printf("   Fraction of expenditure: %.2f\n", fracOfSpend);
        System.out.printf("   Parent Value: %d\n", parentValue);
        System.out.printf("   Child Value: %d\n\n", childValue);
    }
}
