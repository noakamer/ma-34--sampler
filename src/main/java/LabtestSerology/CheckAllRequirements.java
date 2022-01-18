package LabtestSerology;

public class CheckAllRequirements {
    private CheckLabCode checkLabCode;
    private CheckAntidotes checkAntidotes;

    public CheckAllRequirements() {
        this.checkLabCode = new CheckLabCode();
        this.checkAntidotes = new CheckAntidotes();
    }

    public boolean meetsRequirements(LabtestSerology current) {
        if (!(current.getIDType() == 0 && String.valueOf(current.getIDNum()).length() == 9)) {
            return false;
        } else if (!checkLabCode.checkLabCode(current.getLabCode())) {
            return false;
        } else if (!(checkAntidotes.haveEnoughAntidotes(current.getKitNumber(), current.getAntidotes()))) {
            return false;
        } else {
            return true;
        }
    }
}
