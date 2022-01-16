package MadaReports;

import java.util.List;

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

    public MadaReports(List<String> data){
        this.MDACODE = data.get(0);
        this.IDNum = Long.parseLong(data.get(1));
        this.IDType = Integer.parseInt(data.get(2));
        this.FirstName = data.get(3);
        this.LastName = data.get(4);
        this.City = data.get(5);
        this.Street = data.get(6);
        this.BuildingNumber = Integer.parseInt(data.get(7));
        this.Barcode = data.get(8);
        this.GetDate = data.get(9);
        this.TakeDate = data.get(10);
        this.ResultDate = data.get(10);
    }

}
