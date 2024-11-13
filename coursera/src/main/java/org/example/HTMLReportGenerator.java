package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLReportGenerator implements ReportGenerator {

    @Override
    public void generateReport(ReportInput reportInput, DatabaseConnection databaseConnection, DatabaseDataSource databaseDataSource) throws IOException {


        if (reportInput.getStudentPins().isEmpty()){

        }
        else {
            for (String pin : reportInput.getStudentPins().get()) {
                 var x = databaseDataSource.getStudent(pin);
            }
        }


        System.out.println("Generating HTML report at: ");

    }
}
