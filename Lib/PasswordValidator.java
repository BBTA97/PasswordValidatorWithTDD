package lib;
import javax.management.ConstructorParameters;

public class PasswordValidator {
    
    /**
     * คุณจะต้องเขียน Javadoc ที่สมบูรณ์ที่นี่ในอนาคต
     * เพื่ออธิบายกฎการทำงานของเมธอด
     * @param รับค่า รับค่าเป็นString
     * @return ส่งค่ากลับไปยัง PasswordStrength เพื่อตรวจสอบเงื่อนไขว่าเข้า INVALID,WEAK,MEDIUMหรือSTRONG
     * @throws IllegalArgumentException ถ้ารับค่า null หรือ empty
     */ 

    // TODO: แก้ไข return type ของเมธอดนี้ให้ถูกต้อง
    public static PasswordStrength validate(String password) {
        Boolean LowerCase=false, digit=false, UpperCase=false, SpecialChar=false; 
        
        for (char c : password.toCharArray()) {
           if (Character.isLowerCase(c)) {
                LowerCase = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else if (Character.isUpperCase(c)) {
                UpperCase = true;
            } else if (c == '-' || c == '_') {
                SpecialChar = true;
            }
        }

        if(password == null || password.length()<8 )
            return PasswordStrength.INVALID;

        if (LowerCase && UpperCase && digit && SpecialChar)
        return PasswordStrength.STRONG;

        if (LowerCase && UpperCase && digit)
            return PasswordStrength.MEDIUM;

        return PasswordStrength.WEAK;
    }
}

    //ระดับ INVALID เป็นค่าว่างหรือสั้นเกินไป
    //ระดับ WEAK ตัวอักษรตัวเล็กกับตัวเลข ตัวอัษรพิมพ์ใหญ่กับตัวเลข ตัวอักษรเล็กกับตัวอักษรใหญ่
    //ระดับ MEDIUM มีตัวเลข ตัวอักษรเล็กและอักษรพิมพ์ใหญ่
    //ระดับ STRONG มีตัวเลข ตัวอักษรเล็ก ตัวอักษรพิมพ์ใหญ่ และspecialchar