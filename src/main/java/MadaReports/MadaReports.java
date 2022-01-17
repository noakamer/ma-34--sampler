package MadaReports;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MadaReports {
    private String MDACODE;
    private long IDNum;
    private int IDType;
    private String FirstName;
    private String LastName;
    private String City;
    private String Street;
    private int BuildingNumber;
    private String Barcode;
    private String GetDate;
    private String TakeDate;
    private String ResultDate;

    public MadaReports(String record) {
        String[] data = record.split(",");
        this.MDACODE = data[0];
        this.IDNum = Long.parseLong(data[1]);
        this.IDType = Integer.parseInt(data[2]);
        this.FirstName = data[3];
        this.LastName = data[4];
        this.City = data[5];
        this.Street = data[6];
        this.BuildingNumber = Integer.parseInt(data[7]);
        this.Barcode = data[8];
        this.GetDate = data[9];
        this.TakeDate = data[10];
        this.ResultDate = data[11];
    }

}
