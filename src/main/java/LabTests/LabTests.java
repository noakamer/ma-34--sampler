package LabTests;

import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;

import java.time.LocalDate;

public class LabTests {
    private int IDNum;
    private int IDType;
    private String FirstName;
    private String LastName;
    private LocalDate ResultDate;
    private LocalDate BirthDate;
    private String LabCode;
    private String StickerNumber;
    private int ResultTestCorona;
    private String Variant;
    private String TestType;
    private LocalDate JoinDate;
    private int HealthCareId;
    private String HealthCareName;

    public LabTests(String record) throws InvalidIdException {
        String[] data = record.split(",");
        this.IDNum = Integer.parseInt(data[0]);
        this.IDType = Integer.parseInt(data[1]);
        this.FirstName = data[2];
        this.LastName = data[3];
        this.ResultDate = LocalDate.parse(data[4]);
        this.BirthDate = LocalDate.parse(data[5]);
        this.LabCode = data[6];
        this.StickerNumber = data[7];
        this.ResultTestCorona = Integer.parseInt(data[8]);
        this.Variant = data[9];
        this.TestType = data[10];
        HealthCareInfoProvider healthCareInfoProvider = new HealthCareInfoProvider();
        PersonInsured person = healthCareInfoProvider.fetchInfo(this.IDNum, this.IDType);
        this.JoinDate = person.getJoinDate();
        this.HealthCareId = person.getHealthCareId();
        this.HealthCareName = person.getHealthCareName();

    }

}
