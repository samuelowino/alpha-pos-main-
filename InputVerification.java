/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alpha;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputVerification {

    public static boolean verifyEmails(Object emailText) {

        try {

            String emailPatternForPersonalAccountsEmails = "(([a-zA-Z0-9]+)(@)([a-zA-Z]+)([.]+)([a-zA-Z]{2,3}+))";
            String emailPatternForInstitutionDormainsEmails = "([a-zA-Z0-9]+)([.]+)([a-zA-Z0-9]+)(@)([a-zA-Z]+)([.]+)([a-zA-Z]+)([.]+)([a-zA-Z]{2}+)([.]+)([a-zA-Z]{2}+)";
            String emailPatternForWebHostingServerSMTPEmails = "([a-zA-Z]+)(@)([a-zA-Z]+)([.]+)([a-zA-Z]+)([.]+)([a-zA-Z]{2}+)([.]+)([a-zA-Z]{2}+)";
            String emailPatternForWeblevelTowSMTPEmails = "([a-zA-Z]+)(@)([a-zA-Z]+)([.]+)([a-zA-Z]+)([.]+)([a-zA-Z]{2}+)";

            Pattern pp1 = Pattern.compile(emailPatternForPersonalAccountsEmails);
            Matcher m1 = pp1.matcher(emailText.toString());
            Pattern pp2 = Pattern.compile(emailPatternForInstitutionDormainsEmails);
            Matcher m2 = pp2.matcher(emailText.toString());
            Pattern pp3 = Pattern.compile(emailPatternForWebHostingServerSMTPEmails);
            Matcher m3 = pp3.matcher(emailText.toString());
            Pattern pp4 = Pattern.compile(emailPatternForWeblevelTowSMTPEmails);
            Matcher m4 = pp4.matcher(emailText.toString());

            return m1.matches() || m2.matches() || m3.matches() || m4.matches();

        } catch (Exception e) {
            System.out.println("ERR: " + e.getMessage());
            return false;
        }

    }

    public static boolean verifyNumbersOnlyFields(Object enteredString) {
        
        Pattern numbersOnlyPattern = Pattern.compile("\\d*");
        Matcher numbersOnlyMatcher = numbersOnlyPattern.matcher(enteredString.toString());
        return numbersOnlyMatcher.matches();
    }

    public static boolean verifyPasswordStrength(final String enteredPassword) {

        String passwordStrength = "";
        String message = "";
        Pattern passwordRegex = Pattern.compile("[a-zA-Z]+");
        Pattern passwordRegexLevelTwo = Pattern.compile("[0-9]+");
        Matcher passwordStrengthMatcher = passwordRegex.matcher(enteredPassword);
        Matcher passwordStrengthMatcherLevelTwo = passwordRegexLevelTwo.matcher(enteredPassword);

        if (passwordStrengthMatcher.find() && passwordStrengthMatcherLevelTwo.find()) {

            passwordStrength = "100% STRONG!!";
            return  true;

        } else if (!passwordStrengthMatcher.find() && !passwordStrengthMatcherLevelTwo.find()) {
          
            passwordStrength = "4% WEAK";
            message = "Upper case and lowercase characters required!";
            return false;

        } else if (!passwordStrengthMatcher.find()) {
           
            passwordStrength = "40% WEAK!!";
            message = "Upper case and lowercase characters required!";
            return false;

        } else if (!passwordStrengthMatcherLevelTwo.find()) {

            passwordStrength = "60%";
            message = "A digit between 0-9 required";
            return false;
        }else{
            return false;
        }

    }

    public static Boolean verifyTextOnlyFields(Object firstNames) {

        Pattern textOnlyPattern = Pattern.compile("[a-zA-Z ]+");
        Matcher textOnlyMatcher = textOnlyPattern.matcher(firstNames.toString());
        return textOnlyMatcher.matches();
    }

    public boolean passwordConfirmation(String enteredPassword, String confirmedPassword) {

        return enteredPassword.equals(confirmedPassword);

    }

    public static boolean verifiyNumbersWithTex(Object ID) {
        Pattern IDPattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher IDMatcher = IDPattern.matcher(ID.toString());
        return IDMatcher.matches();

    }

    public static boolean verifyWebAddress(Object webAddress) {
        Pattern webAddressPattern = Pattern.compile("[a-zA-Z0-9:\\.//]*");
        Matcher webAddressMatcher = webAddressPattern.matcher(webAddress.toString());
        return webAddressMatcher.matches();
    }

    public static boolean verifyAddress(Object physicalAddress) {
        Pattern addressPattern = Pattern.compile("[a-zA-Z0-9 ]*");
        Matcher addressMatcher = addressPattern.matcher(physicalAddress.toString());
        return addressMatcher.matches();
    }
    
    public static boolean verifyNamesWithInitials(Object nameWithInitials){
        Pattern fullNamesWithInititlsPattern = Pattern.compile("[a-zA-Z\\. ]*");
        Matcher fullNamesWithInitialsMatcher = fullNamesWithInititlsPattern.matcher(nameWithInitials.toString());
        return fullNamesWithInitialsMatcher.matches();
    }

}
