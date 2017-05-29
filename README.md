
# Instructions
I. Open and run the server.
1. Open pom.xml with Intelij or Eclipse
2. Run Main.java
3. Open browser on http://localhost:8080

OR

1. Go to Maven Projects in Intelij abd there at sprint-boot, in Lifecycle, double click
on install to build the jar file
2. Run "java -jar sprint-boot-1.0-SNAPSHOT.jar" in target directory, to run the server.

II. Create the SQL database.
1. I created my online database with GearHost.com. 
    - i hosted my own site and after that on that site i 
created a database with the name "unicredt". 
    - i created an account here: https://my.gearhost.com to make 
the site and the database.
2. To create the table of my database i used MySQL Workbanch. Download it from here: https://dev.mysql.com/downloads/workbench/
    - At migration, at Database menu, you can connect to a database and populate it 
    with some specific data.
3. How to connect to my database: 
    - Hostname: mysql3.gear.host
    - Username: unicredtdb
    - Password: you select Store in keychain and write the password : parola2017!
4. To create the table : select the scheme and then add table where you can create 
the columns as you want.

III. Populate the database.

1. To populate the databse you just created at the previous step, i used PostMan. Here
you can download it: https://www.getpostman.com

2.You have to write the URL: localhost:8080//[] where [] is the way where your database
is. Then you should select the comand you want to give. For example to buy a ticket you should
 enter the URL : localhost:8080//buy_ticket/ and give the command "POST", but first, 
 you need to check the body of the command. You should take care to add in the table you 
 want with the exact columns and spaces you created before with the MySQL Workbanch.
 
 Body example: {
                 "id": 1,
                 "price": 500,
                 "owner": "Dicaprio",
                 "event": "Titanic Cinema"
               }
               
  This is how you populate your database.

#Testing the app
 
 I. To test the app you need to use the PostMan app you used before to populate the 
 database, as i showed you before.

II. To remove a ticket is the same as the adding one just that the URL will now be :
localhost:8080//remove_ticket/

III. To see details about a ticket, by id, you need to make a HTTP "GET" request
at : localhost:8080//ticket_details/{id}, where id is the ticket's id.
 
 
#Implementation

I. The implementation stands on layers.

 1. This means that it starts in Event/TicketController, passes over to Event/TicketService
    and after it goes to, or local LocalEvent/TicketDao of MysqlEvent/TicketDao.
   
II. Explanations.

  1. Event/TicketController: 
        - Establish the method we will use to call this function and the 
         way, for example: "list_events".
        - It passes the functions over to service
     
  2. In Event/TicketService we pass the functions to the Dao but to the qualifier:
    mysqlEvents/Tickets which means that it will choose to look on the cloud database.
        
  3. LocalEvent/TicketDao.
        - Here i implemented the functions for a local database use.
    
  4. MysqlEvent/TicketDao
        - Here i implemented the functions for a cloud database use.
        - i used a jdbcTemplate to update the database or to get the informations from a
        database, case where we used a RowMapper, implemented for our current situation.
        - A RowMapper takes from the SQL table of a database exactly the values of the
        exact columns we tell him and puts it in "Sets". Then we return one line of the table.