package Model;

/**
 * Created by ronnykibet on 1/20/17.
 */
public class UserDetails {
    private double userWeight;
    private double userFeet;
    private double userInches;
    private double userBMI;
    private String userHealthCategory;

    public UserDetails() {
    }

    public UserDetails(double userWeight, double userFeet, double userInches) {
        this.userWeight = userWeight;
        this.userFeet = userFeet;
        this.userInches = userInches;
    }

    public double getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(double userWeight) {
        this.userWeight = userWeight;
    }

    public double getUserFeet() {
        return userFeet;
    }

    public void setUserFeet(double userFeet) {
        this.userFeet = userFeet;
    }

    public double getUserInches() {
        return userInches;
    }

    public void setUserInches(double userInches) {
        this.userInches = userInches;
    }

    public double getUserBMI() {
        return userBMI;
    }

    public void setUserBMI(double userBMI) {
        this.userBMI = userBMI;
    }

    public String getUserHealthCategory() {
        return userHealthCategory;
    }

    public void setUserHealthCategory(String userHealthCategory) {
        this.userHealthCategory = userHealthCategory;
    }
}
