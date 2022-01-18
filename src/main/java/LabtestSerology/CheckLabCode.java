package LabtestSerology;

public class CheckLabCode {
    public boolean checkLabCode(String labCode) {
        if (labCode.length() > 5) {
            return false;
        }
        if (!(labCode.charAt(0) >= '0' && labCode.charAt(0) <= '9')) {
            return false;
        }
        if (!(labCode.charAt(1) >= '0' && labCode.charAt(1) <= '9')) {
            return false;
        }
        if (!(labCode.charAt(2) >= 'A' && labCode.charAt(2) <= 'Z')) {
            return false;
        }
        if (!(labCode.charAt(3) >= 'A' && labCode.charAt(3) <= 'Z')) {
            return false;
        }
        if (!(labCode.charAt(4) >= '0' && labCode.charAt(4) <= '9')) {
            return false;
        }
        return true;
    }
}
