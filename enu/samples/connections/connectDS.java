//=====================================================================
//
//  File:    connectDS.java      
//  Summary: This Microsoft JDBC Driver for SQL Server sample application
//	     demonstrates how to connect to a SQL Server database by 
//	     using a data source object. It also demonstrates how to 
//	     retrieve data from a SQL Server database by using a stored 
//	     procedure.
//
//---------------------------------------------------------------------
//
//  This file is part of the Microsoft JDBC Driver for SQL Server Code Samples.
//  Copyright (C) Microsoft Corporation.  All rights reserved.
//
//  This source code is intended only as a supplement to Microsoft
//  Development Tools and/or on-line documentation.  See these other
//  materials for detailed information regarding Microsoft code samples.
//
//  THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF 
//  ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO 
//  THE IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
//  PARTICULAR PURPOSE.
//
//===================================================================== 

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.microsoft.sqlserver.jdbc.*;

public class connectDS {

    public static void main(String[] args) {

        // Declare the JDBC objects.
        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        if (args.length < 3) {
            System.out.println("Usage:");
            System.out.println("serverName portNumber databaseName");
            System.out.println("Example:");
            System.out.println("localhost 1433 databaseName");
            System.exit(1);
        }
        /*
        System.out.println("args " + args.length);
        System.out.println("args[0] " + args[0]);
        System.out.println("args[1] " + args[1]);
        System.out.println("args[2] " + args[2]);
        */
        String serverName = args[0];
        Integer portNumber = Integer.parseInt(args[1]);
        String databaseName = args[2];

        System.out.println("serverName: " + serverName);
        System.out.println("portNumber: " + portNumber.toString());
        System.out.println("databaseName: " + databaseName);

        Logger logger = Logger.getLogger("com.microsoft.sqlserver.jdbc");
        logger.setLevel(Level.ALL);

        try {
            // Establish the datasource.
            SQLServerDataSource ds = new SQLServerDataSource();

            // parms from command line
            ds.setServerName(serverName);
            ds.setPortNumber(portNumber);
            ds.setDatabaseName(databaseName);

            // parms for networky clustery
            // ds.setMultiSubnetFailover(false);
            // ds.setTransparentNetworkIPResolution(true);

            // parms for Auth
            //ds.setIntegratedSecurity(true);
            ds.setUser("sa");
            ds.setPassword("<YourStrong!Passw0rd>");

            // print the connection parameters
            System.out.println("==============================");
            System.out.println("serverName: " + ds.getServerName());
            System.out.println("portNumber: " + ds.getPortNumber());
            System.out.println("databaseName: " + ds.getDatabaseName());

            System.out.println("instanceName: " + ds.getInstanceName());
            System.out.println("user: " + ds.getUser());
            System.out.println("serverSpn: " + ds.getServerSpn());

            System.out.println("encrypt: " + ds.getEncrypt());
            System.out.println("multiSubnetFailover: " + ds.getMultiSubnetFailover());
            System.out.println("transparentNetworkIPResolution: " + ds.getTransparentNetworkIPResolution());

            System.out.println("URL: " + ds.getURL());
            System.out.println("===============================");


            // Establish the connection.
            System.out.print("trying to connect...");
            con = ds.getConnection();
            System.out.println("Successfully Connected");



            Statement statement = con.createStatement();

            System.out.println("Dropping database 'AutoATrialDB' IF EXISTS... ");
            String sql = "DROP DATABASE IF EXISTS [AutoATrialDB]";
            statement.executeUpdate(sql);


            System.out.print("Creating database 'AutoATrialDB' ... ");
            sql = "CREATE DATABASE [AutoATrialDB]";
            statement.executeUpdate(sql);
            System.out.println("Successfully Created database 'AutoATrialDB'");


            System.out.print("Creating trial table 'Tasks' ...");
            sql = new StringBuilder().append("USE AutoATrialDB; ").append("CREATE TABLE Tasks ( ")
                    .append(" Id INT IDENTITY(1,1) NOT NULL PRIMARY KEY, ").append(" Name NVARCHAR(50), ")
                    .append(" Location NVARCHAR(50) ").append("); ")
                    .append("INSERT INTO Tasks (Name, Location) VALUES ").append("(N'Jared', N'Australia'), ")
                    .append("(N'Nikita', N'India'), ").append("(N'Tom', N'Germany'); ").toString();
            statement.executeUpdate(sql);
            System.out.println("Successfully Created table 'Tasks'");

            /*
            // INSERT demo
            System.out.print("Inserting a new row into table, press ENTER to continue...");
            System.in.read();
            sql = new StringBuilder().append("INSERT Employees (Name, Location) ").append("VALUES (?, ?);")
                    .toString();
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, "Jake");
                statement.setString(2, "United States");
                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " row(s) inserted");
            }

            // UPDATE demo
            String userToUpdate = "Nikita";
            System.out.print("Updating 'Location' for user '" + userToUpdate + "', press ENTER to continue...");
            System.in.read();
            sql = "UPDATE Employees SET Location = N'United States' WHERE Name = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, userToUpdate);
                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " row(s) updated");
            }

            // DELETE demo
            String userToDelete = "Jared";
            System.out.print("Deleting user '" + userToDelete + "', press ENTER to continue...");
            System.in.read();
            sql = "DELETE FROM Employees WHERE Name = ?;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, userToDelete);
                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected + " row(s) deleted");
            }

            // READ demo
            System.out.print("Reading data from table, press ENTER to continue...");
            System.in.read();
            sql = "SELECT Id, Name, Location FROM Employees;";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    System.out.println(
                            resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
                }
            }
             */
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (cstmt != null) try {
                cstmt.close();
            } catch (Exception e) {
            }
            if (con != null) try {
                con.close();
                System.out.println("Disconnected");
            } catch (Exception e) {
            }
        }
    }
}
