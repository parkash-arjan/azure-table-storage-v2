package com.lab.storage.azure.azuretablestoragev2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Include the following imports to use table APIs
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.table.CloudTableClient;


@SpringBootApplication
public class AzureTableStorageV2Application {
	public static final String storageConnectionString = 
			"DefaultEndpointsProtocol=https;"+ 
			"AccountName="+ (String)System.getenv("AccountName")+
			"AccountKey="+(String)System.getenv("AccountKey")	;

	
	public static void main(String[] args) {
		SpringApplication.run(AzureTableStorageV2Application.class, args);
		list();
	}

	public static void list() {

		try {
			// Retrieve storage account from connection-string.
			CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

			// Create the table client.
			CloudTableClient tableClient = storageAccount.createCloudTableClient();

			// Loop through the collection of table names.
			for (String table : tableClient.listTables()) {
				// Output each table name.
				System.out.println(table);
			}
		} catch (Exception e) {
			// Output the stack trace.
			e.printStackTrace();
		}
	}
}
