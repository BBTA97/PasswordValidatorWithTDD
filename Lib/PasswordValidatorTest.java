package lib;

public class PasswordValidatorTest{
    
    public static void run() {
        System.out.println("--- Running Password Validator Tests ---");
        
        // Test Case 1: รหัสผ่านสั้นควรจะ INVALID
        PasswordStrength result1 = PasswordValidator.validate("123");
        if (result1 == PasswordStrength.INVALID) {
            System.out.println("Test Case 1 Passed: Short password is INVALID.");
        } else {
            System.out.println("Test Case 1 FAILED: Expected INVALID but got " + result1);}

        // Test Case 2: รหัสผ่านตัวอักษรตัวเล็กกับตัวเลข ตัวอัษรพิมพ์ใหญ่กับตัวเลข ตัวอักษรเล็กกับตัวอักษรใหญ่ควรจะ WEAK
        PasswordStrength result2 = PasswordValidator.validate("fffff525");
        if (result2 == PasswordStrength.WEAK) {
            System.out.println("Test Case 2 Passed: Lowercase or Uppercase with number password is WEAK.");
        } else {
            System.out.println("Test Case 2 FAILED: Expected WEAK but got " + result2);}
        
        // Test Case 3: รหัสผ่านที่มีตัวเลข ตัวอักษรเล็กและอัษรพิมพ์ใหญ่ ควรจะ MEDIUM
        PasswordStrength result3 = PasswordValidator.validate("Ddlfldk515");
        if (result3 == PasswordStrength.MEDIUM) {
            System.out.println("Test Case 3 Passed: Lowercase and Uppercase with number password is MEDIUM.");
        } else {
            System.out.println("Test Case 3 FAILED: Expected MEDIUM but got " + result3);}


        // Test Case 4: รหัสผ่านมีทั้งมีตัวเลข ตัวอักษรเล็ก ตัวอักษรพิมพ์ใหญ่ และspecialchar ควรจะ STRONG
        PasswordStrength result4 = PasswordValidator.validate("FFFddAA555");
        if (result4 == PasswordStrength.STRONG) {
            System.out.println("Test Case 4 Passed: Password is STRONG.");
        } else {
            System.out.println("Test Case 4 FAILED: Expected STRONG but got " + result4);}


        System.out.println("--------------------------------");
    }
}
