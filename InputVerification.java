/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha;


import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;

public class  InputVerification {

    private static Pattern emailAddressRegex;
    private static Pattern phoneNumberRegex;
    private static Pattern passwordRegex;
    private static Pattern passwordRegexLevelTwo;
    private static Pattern officialNamesRegex;
    private static Pattern officialNamesRegexLevelTwo;
    private static Matcher emailAddressMatcher;
    private static Matcher phoneNumbersMatcher;
    private static Matcher passwordStrengthMatcher;
    private static Matcher passwordStrengthMatcherLevelTwo;
    private static Matcher officialNamesMatcher;
    private static Matcher officialNamesMatcherLevelTwo;
    private static Pattern idMatcher;
    private static Matcher idPattern;
    public static  String passwordStrength;
    public static String message = "";

    public static boolean verifyEmails(Object emailText) {
        
        boolean isValid = false;
        
        try {
            
            String p = "(([a-zA-Z0-9]+)(@)([a-zA-Z]+)([.]+)([a-zA-Z]{2,3}+))";
            String p2 = "([a-zA-Z0-9]+)([.]+)([a-zA-Z0-9]+)(@)([a-zA-Z]+)([.]+)([a-zA-Z]+)([.]+)([a-zA-Z]{2}+)([.]+)([a-zA-Z]{2}+)";
            String p3 = "([a-zA-Z]+)(@)([a-zA-Z]+)([.]+)([a-zA-Z]+)([.]+)([a-zA-Z]{2}+)([.]+)([a-zA-Z]{2}+)";
            String p4 = "([a-zA-Z]+)(@)([a-zA-Z]+)([.]+)([a-zA-Z]+)([.]+)([a-zA-Z]{2}+)";

            Pattern pp1 = Pattern.compile(p);
            Matcher m1 = pp1.matcher(emailText.toString());
            Pattern pp2 = Pattern.compile(p2);
            Matcher m2 = pp2.matcher(emailText.toString());
            Pattern pp3 = Pattern.compile(p3);
            Matcher m3 = pp3.matcher(emailText.toString());
            Pattern pp4 = Pattern.compile(p4);
            Matcher m4 = pp4.matcher(emailText.toString());
            
            isValid = m1.matches() || m2.matches() || m3.matches() || m4.matches();
             return isValid;
            
        } catch (Exception e) {
            System.out.println("ERR: " + e.getMessage());
            return false;
        }
       
    }


    public static  boolean verifyPhoneNumbers(Object enteredPhoneNumber) {

        phoneNumberRegex = Pattern.compile("\\d*");
        phoneNumbersMatcher = phoneNumberRegex.matcher(enteredPhoneNumber.toString());
        boolean isPhoneNumberApproved = false;
        isPhoneNumberApproved = phoneNumbersMatcher.matches();
        return isPhoneNumberApproved;
    }

    public static boolean verifyPasswordStrength(final String enteredPassword) {

        passwordRegex = Pattern.compile("[a-zA-Z]+");
        passwordRegexLevelTwo = Pattern.compile("[0-9]+");
        passwordStrengthMatcher = passwordRegex.matcher(enteredPassword);
        passwordStrengthMatcherLevelTwo = passwordRegexLevelTwo.matcher(enteredPassword);
        boolean isPasswordApproved = false;
        

        if (passwordStrengthMatcher.find() && passwordStrengthMatcherLevelTwo.find()) {

            isPasswordApproved = true;
            passwordStrength = "100% STRONG!!";

        } else if (!passwordStrengthMatcher.find() && !passwordStrengthMatcherLevelTwo.find()) {
            isPasswordApproved = false;
            passwordStrength = "4% WEAK";
            message = "Upper case and lowercase characters required!";

        } else if (!passwordStrengthMatcher.find()) {
            isPasswordApproved = false;
            passwordStrength = "40% WEAK!!";
            message = "Upper case and lowercase characters required!";

        } else if (!passwordStrengthMatcherLevelTwo.find()) {

            isPasswordApproved = false;
            passwordStrength = "60%";
            message = "A digit between 0-9 required";
        }

        return isPasswordApproved;
    }

    public static Boolean verifyUserTextOnlyFields(Object firstNames) {

        officialNamesRegex = Pattern.compile("[a-zA-Z ]+");
        officialNamesMatcher = officialNamesRegex.matcher(firstNames.toString());
        officialNamesRegexLevelTwo = Pattern.compile("[^0-9]+");
        officialNamesMatcherLevelTwo = officialNamesRegexLevelTwo.matcher(firstNames.toString());
        boolean isNameApproved = false;

        if (officialNamesMatcher.matches() && officialNamesMatcherLevelTwo.matches()) {
            isNameApproved = true;
        } else if (!officialNamesMatcher.matches() || !officialNamesMatcherLevelTwo.matches()) {
            isNameApproved = false;
        } 
        return isNameApproved;
    }
    
    public boolean passwordConfirmation(String enteredPassword,String confirmedPassword){
        
        boolean isPasswordsSame = false;
        isPasswordsSame = enteredPassword.equals(confirmedPassword);
        return isPasswordsSame;
    }
    
    public  static boolean verifiyID(Object ID){
        boolean isIDValid = false;
        idMatcher = Pattern.compile("[a-zA-Z0-9]*");
        idPattern = idMatcher.matcher(ID.toString());
        isIDValid = idPattern.matches();
        return isIDValid;
    }

}

