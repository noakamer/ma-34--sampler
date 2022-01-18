package PositiveCoronaPeople;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PositiveCoronaPeople implements Serializable {
    private int IDNum;
    private int IDType;
    private String FirstName;
    private String LastName;
    private String City;
    private String Street;
    private int BuildingNumber;
    private String Barcode;
    private String BirthDate;
    private String LabCode;
    private String ResultDate;
    private String TakeDate;
    private String StickerNumber;
    private int ResultTestCorona;
    private String Variant;
    private String TestType;

    public PositiveCoronaPeople(int IDNum, int IDType, String FirstName, String LastName,
                                String City, String Street, int BuildingNumber, String Barcode,
                                String BirthDate, String LabCode, String ResultDate, String TakeDate,
                                String StickerNumber, int ResultTestCorona, String Variant, String TestType) {
        this.IDNum = IDNum;
        this.IDType = IDType;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.City = City;
        this.Street = Street;
        this.BuildingNumber = BuildingNumber;
        this.Barcode = Barcode;
        this.BirthDate = BirthDate;
        this.LabCode = LabCode;
        this.ResultDate = ResultDate;
        this.TakeDate = TakeDate;
        this.StickerNumber = StickerNumber;
        this.ResultTestCorona = ResultTestCorona;
        this.Variant = Variant;
        this.TestType = TestType;
    }

}
