package LabTests;

public class LabTests {
    private long IDNum;
    private int IDType;
    private String FirstName;
    private String LastName;
    private String ResultDate;
    private String BirthDate;
    private String LabCode;
    private String StickerNumber;
    private int ResultTestCorona;
    private String Variant;
    private String TestType;

    public LabTests(String record) {
        String[] data = record.split(",");
        this.IDNum = Long.parseLong(data[0]);
        this.IDType = Integer.parseInt(data[1]);
        this.FirstName = data[2];
        this.LastName = data[3];
        this.ResultDate = data[4];
        this.BirthDate = data[5];
        this.LabCode = data[6];
        this.StickerNumber = data[7];
        this.ResultTestCorona = Integer.parseInt(data[8]);
        this.Variant = data[9];
        this.TestType = data[10];

    }

}
