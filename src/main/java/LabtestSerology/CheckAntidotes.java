package LabtestSerology;

public class CheckAntidotes {

    public boolean haveEnoughAntidotes(int kitNum, int antidotes) {
        if (kitNum != 15 && kitNum != 16 && kitNum != 17) {
            return false;
        }
        if (!((kitNum == 15 && antidotes >= 500) || (kitNum == 16 && antidotes >= 1500) || (kitNum == 17 && antidotes >= 3000))) {
            return false;
        }
        return true;
    }
}
