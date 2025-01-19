
package com.example.bigquery;

import com.google.cloud.bigquery.*;

public class BigQueryApp {

    public static void main(String[] args) {
        String projectId = "your-project-id"; // Replace with your GCP project ID
        BigQuery bigquery = BigQueryOptions.newBuilder().setProjectId(projectId).build().getService();

        String query = "SELECT department, AVG(salary) as average_salary " +
                       "FROM `employee_dataset.employee_data` " +
                       "GROUP BY department";

        try {
            QueryJobConfiguration queryConfig = QueryJobConfiguration.newBuilder(query).build();
            TableResult results = bigquery.query(queryConfig);

            System.out.println("Department-wise Average Salaries:");
            System.out.println("-----------------------------------");
            System.out.printf("%-15s %-15s%n", "Department", "Average Salary");
            System.out.println("-----------------------------------");

            for (FieldValueList row : results.iterateAll()) {
                String department = row.get("department").getStringValue();
                double averageSalary = row.get("average_salary").getDoubleValue();

                System.out.printf("%-15s $%-14.2f%n", department, averageSalary);
            }

        } catch (InterruptedException e) {
            System.out.println("Query execution interrupted: " + e.getMessage());
        }
    }
}
