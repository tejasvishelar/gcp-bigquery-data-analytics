
# Employee Data Analytics with BigQuery and Java

This project demonstrates the integration of Google BigQuery with a Java application for performing data analytics.

## Features
- Connect to BigQuery using a service account.
- Perform a query to calculate average salaries per department.
- Display the data in a tabular format.

## Prerequisites
1. Set up a GCP project with BigQuery enabled.
2. Create a BigQuery dataset and table (`employee_dataset.employee_data`).
3. Populate the table with sample data.
4. Download the service account key file and set the `GOOGLE_APPLICATION_CREDENTIALS` environment variable.

## Running the Project
1. Build the project:
    ```bash
    mvn clean package
    ```
2. Run the application:
    ```bash
    java -cp target/EmployeeDataAnalytics-1.0-SNAPSHOT.jar com.example.bigquery.BigQueryApp
    ```
