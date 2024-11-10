package org.example;

import java.io.IOException;
import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


public interface ReportGenerator {
    void generateReport( ReportInput reportInput, DatabaseConnection databaseConnection,  DatabaseDataSource databaseDataSource) throws IOException;

    //void generateReport(List<StudentReportData> data, String outputPath) throws IOException;
}
