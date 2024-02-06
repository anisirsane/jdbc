// package com.example;
// import java.sql.Statement;
// import java.sql.DatabaseMetaData;
// import java.sql.ResultSet;
// import java.sql.ResultSetMetaData;

// public class TranformInput {
//     // public Connection connection = CheckDb.con;

//     UserInput manage = new UserInput(); 
//     void Tranform() throws Exception{
//         String sqlquery = manage.ManageDb();
//         //ce code est pris de: https://www.enterprisedb.com/postgres-tutorials/how-use-java-create-table-postgresql#:~:text=If%20you%20want%20to%20create%20an%20object%20or,PostgreSQL%20JDBC%20driver%20and%20classpath%20files%2C%20for%20example%3A 
//         // et est modifie selon les besoins 
//         Statement stmt;
//             stmt = CheckDb.con.createStatement();
//             System.out.println(CheckDb.con);
            
//             // Create Table Test(id int primary key, name varchar, address text) 
//             //https://herongyang.com/JDBC/sqljdbc-jar-ResultSet-Loop.html
//             // https://stackoverflow.com/questions/14853508/returning-a-resultset
//             if(sqlquery.toUpperCase().startsWith("SELECT")){
//                 DatabaseMetaData md = CheckDb.con.getMetaData();
//                 ResultSet rs = md.getTables(null, null, "%", null);
//                 while (rs.next()) {
//                     System.out.println(rs.getString(3));
//                 }
//                 //pour lire les tables, j'ai utilise ces sources:
//                 //  https://stackoverflow.com/questions/2780284/how-to-get-all-table-names-from-a-database
//                 //  https://stackoverflow.com/questions/2614416/how-to-get-the-number-of-columns-from-a-jdbc-resultset
//                 ResultSet set = stmt.executeQuery(sqlquery);
//                 ResultSetMetaData metaData = set.getMetaData();
//                 int columnCount = metaData.getColumnCount();
//                 // https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSetMetaData.html
//                 while (set.next()) {
//                     for (int i = 1; i <= columnCount; i++) {
//                     System.out.println(" "+ metaData.getColumnName(i)+ "    " + set.getObject(i));
//                     }
//             }}else if(sqlquery.toUpperCase().startsWith("CREATE")){
//                 // Statement stmt;
//                 // stmt = CheckDb.con.createStatement();
//                 stmt.executeUpdate(sqlquery);

//                 // String newSqlquery = UserInput.createtableStatement();
//                 // stmt.executeUpdate(newSqlquery);
//             }else{
//                 stmt.executeUpdate(sqlquery);

//             }

//                 String newSqlquery = UserInput.createtableStatement();
//                 stmt.executeUpdate(newSqlquery);            
//             stmt.close();


// }}
