package PositiveCoronaPeople;

import LabTests.LabTests;
import MadaReports.MadaReports;

public class CreateNewPeople {

    public PositiveCoronaPeople create(MadaReports madaReport, LabTests labTest) {
        return new PositiveCoronaPeople(madaReport.getIDNum(), madaReport.getIDType(),
                madaReport.getFirstName(), madaReport.getLastName(), madaReport.getCity(),
                madaReport.getStreet(), madaReport.getBuildingNumber(), madaReport.getBarcode(),
                labTest.getBirthDate(), labTest.getLabCode(), labTest.getResultDate(),
                madaReport.getTakeDate(), labTest.getStickerNumber(), labTest.getResultTestCorona(),
                labTest.getVariant(), labTest.getTestType());
    }
}
