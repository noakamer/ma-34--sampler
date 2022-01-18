package LabtestSerology;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LabtestSerology {
    private int IDNum;
    private int IDType;
    private String FirstName;
    private String LastName;
    private String ResultDate;
    private String BirthDate;
    private String LabCode;
    private String StickerNumber;
    private int Antidotes;
    private int KitNumber;

    public LabtestSerology(String record) {
        String[] data = record.split(",");
        this.IDNum = Integer.parseInt(data[0]);
        this.IDType = Integer.parseInt(data[1]);
        this.FirstName = data[2];
        this.LastName = data[3];
        this.ResultDate = data[4];
        this.BirthDate = data[5];
        this.LabCode = data[6];
        this.StickerNumber = data[7];
        this.Antidotes = Integer.parseInt(data[8]);
        this.KitNumber = Integer.parseInt(data[9]);
    }
}
