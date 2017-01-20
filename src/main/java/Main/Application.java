package Main;

import Model.UserDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ronnykibet on 1/19/17.
 */
@Controller
@ComponentScan
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

    private static double feet=0.0, weight=0, inches = 0.0;
    private static double BMIRounded = 0.0;

    public static void main(String[] args) {
        //double bmi = calculateBMI();
        //System.out.println("Your BMI is " + bmi);
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap model) {
        UserDetails userDetails = new UserDetails();
        model.addAttribute("userDetails", userDetails);

        return "index";
    }

    @PostMapping("/")
    public String calculateBMIButtonPressed(@ModelAttribute(value = "userDetails") UserDetails userDetails){

        System.out.println("User Weight"+userDetails.getUserWeight());
        System.out.println("User Height Feet"+userDetails.getUserFeet());
        System.out.println("User Height Inches"+userDetails.getUserInches());
        double BMI = calculateBMI(userDetails.getUserWeight(), userDetails.getUserFeet(), userDetails.getUserInches());
        System.out.println("Your BMI is " + BMI);
        userDetails.setUserBMI(BMI);

        //set user health category
        if(BMI < 16.0){
            userDetails.setUserHealthCategory("Very Severely Underweight");
        }else if(BMI >= 16.0 && BMI <= 16.9){
            userDetails.setUserHealthCategory("Severely Underweight");
        }else if(BMI >= 17.0 && BMI <= 18.4){
            userDetails.setUserHealthCategory("Underweight");
        }else if (BMI >= 18.5 && BMI <= 24.9){
            userDetails.setUserHealthCategory("Normal");
        }else if(BMI >= 25.0 && BMI <= 29.9){
            userDetails.setUserHealthCategory("Overweight");
        }else if(BMI >= 30.0 && BMI <= 34.9){
            userDetails.setUserHealthCategory("Obese Class I");
        }else if(BMI >=35.0 && BMI <= 39.9){
            userDetails.setUserHealthCategory("Obese Class II");
        }else if(BMI >= 40.0){
            userDetails.setUserHealthCategory("Obese Class III");
        }
        System.out.println("Your BMI is category " + userDetails.getUserHealthCategory());


        return "index";

    }

    private static double calculateBMI(Double userWeight, Double heightFeet, Double heightInches){

        weight = userWeight;
        feet = heightFeet;
        inches = heightInches;
        double height =  ((feet * 12) + inches); //inches
        BMIRounded = (double) Math.round((weight * 703) / (height * height) * 10) / 10;
        return BMIRounded;
    }


}
