package app.controllers;

import app.configdb.DatabaseConnect;
import static app.controllers.MenuController.adminMenu;
import java.sql.SQLException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AdminController extends DatabaseConnect implements Controllable{
    Scanner scan = new Scanner(System.in);
    public void seeReports(){
        String query = "SELECT orders.invoice_id, customers.customer_firstname, products.product_brand, products.product_model, orders.order_quantity, orders.order_date, users.user_firstname "
            + "FROM orders "
            + "INNER JOIN customers ON orders.customer_id = customers.customer_id "
            + "INNER JOIN products ON orders.product_id = products.product_id "
            + "INNER JOIN users ON orders.invoice_manager = users.user_id ";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            System.out.println("\n------------------------- INVOICE REPORTS -------------------------");
            while(result.next()){
                System.out.println("Invoice ID: " + result.getString(1));
                System.out.println("Customer Name: " + result.getString(2));
                System.out.println("Brand: " + result.getString(3));
                System.out.println("Model: " + result.getString(4));
                System.out.println("Quantity: " + result.getInt(5));
                System.out.println("Order Date: " + dtformat.format(result.getTimestamp(6)));
                System.out.println("Invoice Manager: " + result.getString(7));
                System.out.println("---------------------------------------------------------------------");
            }
            connect.close();
            adminMenu();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
        }
    }
    
    public void checkRestockReports(){
        String query = "SELECT restock_details.restock_id, restock_details.restock_product_id, products.product_brand, products.product_model, products.product_description, restock_details.on_stock_before, restock_details.restock_quantity, restock_details.on_stock_after, restock_details.restock_date, restock_details.restock_by, users.user_firstname, users.user_lastname "
            + "FROM restock_details "
            + "INNER JOIN products ON restock_details.restock_product_id = products.product_id "
            + "INNER JOIN users ON restock_details.restock_by = users.user_id ORDER BY restock_id";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result= stmnt.executeQuery(query);
            System.out.println("\n------------------------- RESTOCK REPORTS -------------------------");
            while(result.next()){
                System.out.println("Restock ID: " + result.getInt(1));
                System.out.println("Product ID: " + result.getInt(2));
                System.out.println("Brand: " + result.getString(3));
                System.out.println("Model: " + result.getString(4));
                System.out.println("Description: " + result.getString(5));
                System.out.println("On Stock (Before): " + result.getString(6));
                System.out.println("Stock Added: " + result.getString(7));
                System.out.println("New Stock: " + result.getString(8));
                System.out.println("Restock Date: " + result.getString(9));
                System.out.println("Restock Manager: " + result.getString(11) + " " + result.getString(12) + " (Admin ID) " + result.getString(10));
                System.out.println("-------------------------------------------------------------------");
            }
            adminMenu();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        }
    }
    
    public void checkLogDetailsPrevious(){
        System.out.println("\n----------------------- PREVIOUS LOG REPORTS -----------------------");
        String query = "SELECT log_details.log_id, log_details.date_login, log_details.time_login, log_details.time_logout, users.user_id, users.user_firstname "
            + "FROM log_details "
            + "INNER JOIN users ON log_details.users_id = users.user_id WHERE log_details.time_logout <> 'NULL' ORDER BY log_details.log_id DESC ";
        
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            System.out.println("LOG ID\tLOG DATE    TIME IN   TIME OUT  USER ID\t  NAME");    

            while(result.next()){
                System.out.println(" " + result.getString(1) 
                + "\t" + result.getString(2)
                + "  " + result.getString(3)
                + "  " + result.getString(4)
                + "  " + result.getString(5)
                + "  " + result.getString(6));
                if(result.getRow() > 9){
                    break;
                }
            }
            System.out.println("--------------------------------------------------------------------");
            connect.close();
            adminMenu();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
        }
    };
    
    public void checkLogDetails(){
        System.out.println("\n---------------------- ALL USERS LOG REPORTS ----------------------");
        String query = "SELECT log_details.log_id, log_details.date_login, log_details.time_login, log_details.time_logout, users.user_id, users.user_firstname "
            + "FROM log_details "
            + "INNER JOIN users ON log_details.users_id = users.user_id WHERE log_details.time_logout <> 'NULL' ORDER BY log_details.log_id ";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            System.out.println("LOG ID\tLOG DATE    TIME IN   TIME OUT  USER ID\t  NAME");    

            while(result.next()){
                System.out.println(" " + result.getString(1) 
                + "\t" + result.getString(2)
                + "  " + result.getString(3)
                + "  " + result.getString(4)
                + "  " + result.getString(5)
                + "  " + result.getString(6));
            }
            System.out.println("--------------------------------------------------------------------");
            connect.close();
            adminMenu();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
        }
    };
    
    public void checkLogById(){
        System.out.println("[SEARCH LOG REPORTS BY USERS ID]");
        System.out.print("Please enter user id: ");
        checkLogById(scan.nextInt());
    }
    
    private void checkLogById(int userId){
        System.out.println("\n----------------------- ID " + userId + " LOG REPORTS ----------------------");
        String query = "SELECT log_details.log_id, log_details.date_login, log_details.time_login, log_details.time_logout, users.user_id, users.user_firstname "
            + "FROM log_details "
            + "INNER JOIN users ON log_details.users_id = users.user_id WHERE log_details.time_logout <> 'NULL' AND log_details.users_id = " + userId + " ORDER BY log_details.log_id ";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            System.out.println("LOG ID\t  LOG DATE     TIME IN    TIME OUT   USER ID   NAME");    

            while(result.next()){
                System.out.println(result.getString(1) 
                + "\t  " + result.getString(2)
                + "   " + result.getString(3)
                + "   " + result.getString(4)
                + "   " + result.getString(5)
                + "   " + result.getString(6));
            }
            
            if(result.first() == false){
                System.out.println("\nThere is no log reports with user ID `" + userId + "`\n");
            }
            
            System.out.println("--------------------------------------------------------------------");
            connect.close();
            adminMenu();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
        }
    };
    
    public void checkLogByDate(){
        System.out.println("[SEARCH LOG REPORTS BY DATE]");
        System.out.print("[eg.. 2023-10-11] Please enter date: ");
        checkLogByDate(scan.nextLine());
    }
    
    private void checkLogByDate(String date){
        System.out.println("\n-------------------- DATE " + date + " LOG REPORTS -------------------");
        String query = "SELECT log_details.log_id, log_details.date_login, log_details.time_login, log_details.time_logout, users.user_id, users.user_firstname "
            + "FROM log_details "
            + "INNER JOIN users ON log_details.users_id = users.user_id WHERE log_details.time_logout <> 'NULL' AND log_details.date_login = '" + date + "' ORDER BY log_details.log_id ";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            System.out.println("LOG ID\t  LOG DATE     TIME IN    TIME OUT   USER ID   NAME");    

            while(result.next()){
                System.out.println(result.getString(1) 
                + "\t  " + result.getString(2)
                + "   " + result.getString(3)
                + "   " + result.getString(4)
                + "   " + result.getString(5)
                + "   " + result.getString(6));
            }
            
            if(result.first() == false){
                System.out.println("\nThere is no log reports on date `" + date + "`\n");
            }
            System.out.println("--------------------------------------------------------------------");
            connect.close();
            adminMenu();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
        }
    };
    
    public void viewUsers(){
        System.out.println("\n-------------------------- ALL USERS LIST --------------------------");
        String query = "SELECT * FROM users WHERE user_archived = 0 ORDER BY users.user_id ASC";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            while(result.next()){
                System.out.println("ID: " + result.getInt(1));
                System.out.print("Role: ");
                System.out.println((result.getInt(11) > 0) ? "Admin" : "User");
                System.out.println("Name: " + result.getString(2) + " " + result.getString(3));
                System.out.println("Birthday: " + result.getString(4));
                System.out.println("Age: " + result.getString(5));
                System.out.println("Gender: " + result.getString(6));
                System.out.println("Username: " + result.getString(7));
                System.out.println("Email: " + result.getString(9));
                System.out.println("Contact: " + result.getString(10));
                System.out.println("Account Created: " + result.getString(12));
                System.out.println("--------------------------------------------------------------------");
            }
            connect.close();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
        }
    };

    public void viewUsersArchived(){
        System.out.println("\n--------------------- ALL USERS IN ARCHIVED -----------------------");
        String query = "SELECT * FROM users WHERE user_archived = 1 ORDER BY users.user_id ASC";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            while(result.next()){
                System.out.println("ID: " + result.getInt(1));
                System.out.print("Role: ");
                System.out.println((result.getInt(11) > 0) ? "Admin" : "User");
                System.out.println("Name: " + result.getString(2) + " " + result.getString(3));
                System.out.println("Birthday: " + result.getString(4));
                System.out.println("Age: " + result.getString(5));
                System.out.println("Gender: " + result.getString(6));
                System.out.println("Username: " + result.getString(7));
                System.out.println("Email: " + result.getString(9));
                System.out.println("Contact: " + result.getString(10));
                System.out.println("Account Created: " + result.getString(12));
                System.out.println("-------------------------------------------------------------------");
            }
            if (result.first() == false) {
                System.out.println("There is no user in archived to retrieve");
                System.out.println("-------------------------------------------------------------------");
                adminMenu();
            }
            connect.close();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
            adminMenu();
        } 
    };
    
    private void unlistUser(int user_id){
        String query = "UPDATE users SET user_archived = 1 WHERE users.user_id = '" + user_id + "' ;";
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.executeUpdate();
            connect.close();
            System.out.println("User with user-id of `" + user_id+ "` unlist successfully ");
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
            adminMenu();
        }
        adminMenu();
    }
    
    private void retrieveUser(int user_id){
        String query = "UPDATE users SET user_archived = 0 WHERE users.user_id = '" + user_id + "' ;";
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.executeUpdate();
            connect.close();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
            adminMenu();
        }
        adminMenu();
    }
    
    public void retrieveUsers(){
        
        
        viewUsersArchived();
        try {
            System.out.println("\n[RETRIEVE USERS]");
            System.out.print("Please enter User ID to retrieve: ");
            retrieveUser(scan.nextInt());
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
            retrieveUsers();
        }
    }
    
    public void deleteUsers(){
        //Scanner scan = new Scanner(System.in);
        try {
            System.out.println("\n[REMOVED USERS]");
            System.out.print("Please enter User ID to remove: ");
            unlistUser(scan.nextInt());
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
            deleteUsers();
        }
    }
    
    public void updateUser(){
        //Scanner scan = new Scanner(System.in);
        try {
            System.out.println("\n[UPDATE USER]");
            System.out.print("Please enter User ID to update: ");
            updateUser.setId(scan.nextInt());
            userUpdateForm(updateUser.getId());
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
            updateUser();
        }
    }
    
    public void userUpdateForm(int userIdToUpdate){
        //Scanner sc = new Scanner(System.in);
        System.out.println("\n[Edit User Profile]");
        System.out.println("User ID: " + userIdToUpdate);
        System.out.println("Please fill up the form correctly");
        updateUser.setId(userIdToUpdate);
        String name;
        do {            
            System.out.print("First Name: ");
            name = scan.nextLine().trim();
            updateUser.setFirstName(name);
        } while (name.equals(""));
        
        do {            
        System.out.print("Last Name: ");
            name = scan.nextLine().trim();
            updateUser.setLastName(name);
        } while (name.equals(""));

        birthMonth(updateUser.getMonthOfBirth());
        birthDay(updateUser.getDayOfBirth());
        birthYear(updateUser.getYearOfBirth());
        
        System.out.println("[M] Male  [F] Female  [Any] Unknown");
        System.out.print("Gender: ");
        String gender = scan.nextLine().toUpperCase();
        switch(gender){
            case "M":
                updateUser.setGender("Male");
                break;
            case "F":
                updateUser.setGender("Female");
                break;
            default:
                updateUser.setGender("Unknown");
                break;
        }

        validateEmail(null);
        // System.out.println("New email `" + updateUser.getEmail() + "` is available.");
        validateContact(updateUser.getContact());
        System.out.println("New contact `" + updateUser.getContact() + " is` available.");

        validateUsername(updateUser.getUserName());
        System.out.println("New username `" + updateUser.getUserName() + "` is available.");
        
        System.out.print("Create Password: ");
        updateUser.setPassword(scan.nextLine()); 
        
        System.out.println("[1] User [2] Admin");
        System.out.print("Change User Role: ");
        updateUser.setRole(scan.nextInt()-1);
        updateUserProfile(updateUser.getId());
    };
    
    public void updateUserProfile(int user_id){
        String birthday = updateUser.getMonthOfBirth() + " " + updateUser.getDayOfBirth() + ", " + updateUser.getYearOfBirth();
        updateUser.setCreatedAt(dtformat.format(date));
        String query = "UPDATE users SET user_firstname = '" + updateUser.getFirstName() + "', "
                     + "user_lastname = '" + updateUser.getLastName() + "', "
                     + "user_birthday = '" + birthday + "', "
                     + "user_age = '" + updateUser.getAge() + "', "
                     + "user_gender = '" + updateUser.getGender() + "', "
                     + "username = '" + updateUser.getUserName() + "', "
                     + "password = '" + updateUser.getPassword() + "', "
                     + "user_email = '" + updateUser.getEmail() + "', " 
                     + "user_contact = '" + updateUser.getContact() + "', "
                     + "role = '" + updateUser.getRole() + "', "
                     + "created_At = '" + updateUser.getCreatedAt() + "' "
                     + "WHERE users.user_id = '" + user_id + "'";
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.executeUpdate();
            System.out.println("\nUser `" + updateUser.getUserName() + "` successfully updated");
            displayUpdate();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        }
    }
    
    private void displayUpdate(){
        System.out.println("\n------------------------ " + updateUser.getFirstName().toUpperCase() + " NEW INFO ----------------------------");
        System.out.println("Name: " + updateUser.getFirstName() + " " + updateUser.getLastName());
        System.out.println("Age: " + updateUser.getAge());
        System.out.println("Gender: " + updateUser.getGender());
        System.out.println("Birthday: " + updateUser.getMonthOfBirth() + " " + updateUser.getDayOfBirth() + ", " + updateUser.getYearOfBirth());
        System.out.println("Contact; " + updateUser.getContact());
        System.out.println("New Email: " + updateUser.getEmail());
        System.out.println("New Username: " + updateUser.getUserName());
        System.out.println("Date Updated: " + updateUser.getCreatedAt());
        System.out.println("Account Profile: " + ((updateUser.getRole() == 1) ? "Admin" : "User"));
        System.out.println("Update By: " + user.getUserName());
        System.out.println("-------------------------------------------------------------------");
        adminMenu();
    }
    
    public int getStockById(int productId){
        int stock = 0;
        String query = "SELECT on_stock FROM products WHERE product_id = " + productId;
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            while(result.next()){
                stock = result.getInt(1);
                updateProduct.setOnStock(stock);
            }
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
        } 
        return stock;
    }
    
    int checkProductID(int productId){
        String query = "SELECT products.product_id, products.product_brand, products.product_model, products.product_description, sizes.sizes_name, categories.categories_name, products.on_stock, users.user_id, users.user_firstname, users.user_lastname "
            + "FROM products "
            + "INNER JOIN sizes ON products.product_size = sizes.sizes_id "
            + "INNER JOIN categories ON products.product_category = categories.categories_id "
            + "INNER JOIN users ON products.created_by = users.user_id "
            + "WHERE product_id = " + productId + " AND product_archived = 0";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            while(result.next()){
                System.out.println("\n------------------- PRODUCT ID "+ result.getInt(1) +" DETAILS ----------------------");
                System.out.println("Product ID: " + result.getInt(1));
                System.out.println("Brand: " + result.getString(2));
                System.out.println("Model: " + result.getString(3));
                System.out.println("Description: " + result.getString(4));
                System.out.println("Size: " + result.getString(5));
                System.out.println("Category: " + result.getString(6));
                System.out.println("On Stock: " + result.getInt(7));
                updateProduct.setOnStock(result.getInt(7));
                System.out.println("Created By: " + result.getString(8));
                System.out.println("Admin: " + result.getString(9) + " " + result.getString(10));
                System.out.println("--------------------------------------------------------------------");
            }
            if(result.first() == false){
                System.out.println("There is no product exist with that id");
                addStock();
            } else {
                
            }
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        }
        return productId;
    }
    
    int checkProductID(){
        //String query = "SELECT * FROM products WHERE product_id = " + productId + "";
        String query = "SELECT products.product_id, products.product_brand, products.product_model, products.product_description, sizes.sizes_name, categories.categories_name, products.on_stock, users.user_id, users.user_firstname, users.user_lastname "
            + "FROM products "
            + "INNER JOIN sizes ON products.product_size = sizes.sizes_id "
            + "INNER JOIN categories ON products.product_category = categories.categories_id "
            + "INNER JOIN users ON products.created_by = users.user_id "
            + "WHERE product_id = " + updateProduct.getId() + "";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            while(result.next()){
                System.out.println("Restock successfully...");
                System.out.println("\n------------------ PRODUCT ID "+ result.getInt(1) +" RESTOCK UPDATE ------------------");
                System.out.println("Product ID: " + result.getInt(1));
                System.out.println("Brand: " + result.getString(2));
                System.out.println("Model: " + result.getString(3));
                System.out.println("Description: " + result.getString(4));
                System.out.println("Size: " + result.getString(5));
                System.out.println("Category: " + result.getString(6));
                System.out.println("On Stock (updated): " + result.getInt(7));
                System.out.println("Created By: " + result.getString(8));
                System.out.println("Name: " + result.getString(9) + " " + result.getString(10));
                System.out.println("--------------------------------------------------------------------");
            }
            if(result.first() == false){
                System.out.println("\nThere is no product exist with that id\n");
                addStock();
            } else {
                adminMenu();
            }
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        }
        return updateProduct.getId();
    }
    
    public void addStock(){
        int newStock = 0;
        try {
            //Scanner scan = new Scanner(System.in);
            System.out.print("Please input product ID to add stock: ");
            updateProduct.setId(scan.nextInt());
            checkProductID(updateProduct.getId());
            System.out.println("\n[ADD STOCK]");
            System.out.print("Add stock: ");
            int stockAdded = scan.nextInt();
            newStock = stockAdded + getStockById(updateProduct.getId());
            //updateProduct.setAddStock(addStock);
            String query = "UPDATE products SET on_stock = '" + newStock + "' WHERE products.product_id = " + updateProduct.getId() +" AND product_archived = 0 ";
            try {
                ConnectDB();
                pst = connect.prepareStatement(query);
                pst.executeUpdate();
                query = "INSERT INTO restock_details (restock_product_id, on_stock_before, restock_quantity, on_stock_after, restock_date, restock_by) VALUES (?,?,?,?,?,?)";
                try {
                    pst = connect.prepareStatement(query);
                    pst.setInt(1, updateProduct.getId());
                    pst.setInt(2,updateProduct.getOnStock());
                    pst.setInt(3, stockAdded);
                    pst.setInt(4, newStock);
                    pst.setString(5, df.format(date));
                    pst.setInt(6,user.getId());
                    pst.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(EXCEPTION_MESSAGE);
                }
                checkProductID();
            } catch (SQLException e) {
                System.out.println(SQLE_MESSAGE);
            } catch (Exception e) {
                System.out.println(EXCEPTION_MESSAGE);
            }
        } catch (InputMismatchException e) {
            System.out.println(IME_MESSAGE);
            addStock();
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
            adminMenu();
        } 
    }
    
    @Override
    public void createUser(){
        String query = "INSERT INTO USERS (user_firstname,user_lastname,user_birthday,user_age,user_gender,username,password,user_email,user_contact,role,created_At) "
                     + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        String birthday = updateUser.getMonthOfBirth() + " " + updateUser.getDayOfBirth() + ", " + updateUser.getYearOfBirth();
        Date date = new Date();
        updateUser.setCreatedAt(dtformat.format(date));
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.setString(1, updateUser.getFirstName());
            pst.setString(2, updateUser.getLastName());
            pst.setString(3, birthday);
            pst.setInt(4, updateUser.getAge());
            pst.setString(5, updateUser.getGender());
            pst.setString(6, updateUser.getUserName());
            pst.setString(7, updateUser.getPassword());
            pst.setString(8, updateUser.getEmail());
            pst.setString(9, updateUser.getContact());
            pst.setInt(10, updateUser.getRole());
            pst.setString(11, updateUser.getCreatedAt());
            pst.executeUpdate();
            
            System.out.println("\nUser `" + updateUser.getUserName() + "` added successfully");
            // GenerateQR features = new GenerateQR();
            // features.generate(updateUser.getUserName());
            displayUpdate();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } 
    }

    @Override
    public void userForm(){
        //Scanner sc = new Scanner(System.in);
        System.out.println("\nREGISTER USER -----------------------------------------------------");
        System.out.println("Please fill up the form");
        String name = "";
        do {            
            System.out.print("First Name: ");
            name = scan.nextLine().trim();
            user.setFirstName(name);
        } while (name.equals(""));
        
        do {            
        System.out.print("Last Name: ");
            name = scan.nextLine().trim();
            user.setLastName(name);
        } while (name.equals(""));
        
        auth.birthMonth(user.getMonthOfBirth());
        auth.birthDay(user.getDayOfBirth());
        auth.birthYear(user.getYearOfBirth());
        
        System.out.println("[M] Male  [F] Female  [Any] Unknown");
        System.out.print("Gender: ");
        String gender = scan.nextLine().toUpperCase();
        switch(gender){
            case "M":
                user.setGender("Male");
                break;
            case "F":
                user.setGender("Female");
                break;
            default:
                user.setGender("Unknown");
                break;
        }
        
        auth.validateEmail(null);
        System.out.println("Email `" + user.getEmail() + "` is available.");
        
        auth.validateContact(user.getContact());
        System.out.println("Contact `" + user.getContact() + "` is available.");

        auth.validateUsername(user.getUserName());
        System.out.println("Username " + user.getUserName() + " is available.");
        
        System.out.print("Create Password: ");
        user.setPassword(scan.nextLine()); 
        
        user.setRole(0);
        auth.createUser();
    };
 
    @Override
    public String validateUsername(String username){
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        username = sc.nextLine();
        updateUser.setUserName(username);
        String query = "SELECT username FROM users WHERE username = '" + updateUser.getUserName() + "'";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            while(result.first()){
                if (result.getString(1).equals(updateUser.getUserName()) == true) {
                    System.out.println("The username `" + updateUser.getUserName() + "` has already taken.\nPlease try another one.");
                    validateUsername(username);
                    result.close();
                    break;
                } 
            }
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
        } 
        return username;
    }
    
    @Override
    public String validateContact(String contact) {
    Scanner sc = new Scanner(System.in);
        System.out.print("Contact: ");
        contact = sc.nextLine();
        updateUser.setContact(contact);
        String query = "SELECT user_contact FROM users WHERE user_contact = " + updateUser.getContact() + "";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
             while(result.next()){
                if (result.getString(1).equals(updateUser.getContact()) == true) {
                    System.out.println("The contact `" + updateUser.getContact() + "` has already taken.\nPlease input new one.");
                    validateContact(contact);
                    result.close();
                    break;
                } 
            }
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
        } 
        return contact;  
    }
    
    public void verifyEmail(String email){
        updateUser.setEmail(email);
        String query = "SELECT user_email FROM users WHERE user_email = '" + email + "'";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
             while(result.first()){
                if (result.getString(1).equals(updateUser.getEmail()) == true) {
                    System.out.println("The email `" + email + "` has already taken.\nPlease input new one.");
                    result.close();   
                    validateEmail(email);
                    break;
                }      
            }                    
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } 
    }
    
    @Override  // email validation using regular expression
    public String validateEmail(String email){
        Scanner sc = new Scanner(System.in);
        System.out.print("Email: ");
        email = sc.nextLine().toLowerCase();
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern p = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        while(m.matches()== true){
            System.out.println("Email " + email + " is valid");
            System.out.println("New email `" + email + "` is available.");
            verifyEmail(email);
            break;
        }
        while(m.matches()== false){
            System.out.println("Email " + email + " is invalid");
            validateEmail(email);
            break;
        }
        return email;
    }

    @Override
    public void timeIn(int user_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void birthMonth(String month){
        Scanner sc = new Scanner(System.in);
        final String months[] = {
                                    "January", "February", "March", "April", "May","June",
                                    "July", "August", "September", "October", "November","December" 
                                };
        try {
            System.out.print("[1-12] Birth Month: ");

            int m = sc.nextInt();
            updateUser.setMonth(m); // get months, numeric
            updateUser.setMonthOfBirth(months[m-1]);
            sc.nextLine();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please input valid number ranging [1-12]");
            birthMonth(month);
        } catch (InputMismatchException e) {
            System.out.println(IME_MESSAGE);
            sc.nextLine();
            birthMonth(month);
        } 
    }
    
    @Override
    public void birthDay(int day){
        //Scanner sc = new Scanner(System.in);
        try {
            do {
                System.out.print("[1-31] Birth Day: ");
                day = scan.nextInt();
                updateUser.setDayOfBirth(day);
            } while (day > 31 || day < 1);
            
        } catch (java.util.InputMismatchException e) {
            System.out.println("Please input numbers only");
            scan.nextLine();
            birthDay(day);
        }
        
        if (day < 0 && day > 31) {
            System.out.println("Please input valid number ranging [1-31]");
            birthDay(day);
        }
    }
    
    @Override
    public void birthYear(int year){
       // Scanner sc = new Scanner(System.in);
        try {
            System.out.print("[eg.. 1998] Birth Year: ");
            year = scan.nextInt();
            updateUser.setYearOfBirth(year);
            scan.nextLine();
            updateUser.setAge(auth.userAge());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please input valid year number");
            scan.nextLine();
            birthYear(year);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Please input numbers only");
            scan.nextLine();
            birthYear(year);
        }
    }
    
    @Override
    public int userAge(){
        int year = Integer.parseInt(yearFormat.format(date));
        int month = Integer.parseInt(monthFormat.format(date));
        int day = Integer.parseInt(dayFormat.format(date));
        
        int age;
        if(month < updateUser.getMonth()){
            age = (year - updateUser.getYearOfBirth()) - 1;
        } else if(month == updateUser.getMonth() && day == updateUser.getDayOfBirth()){
            age = (year - updateUser.getYearOfBirth());
            System.out.println("Today is your birthday, " + updateUser.getFirstName() + "!");
        } else if(month == updateUser.getMonth() && day < updateUser.getDayOfBirth()){
            age = (year - updateUser.getYearOfBirth()) - 1;
        } else {
            age = (year - updateUser.getYearOfBirth());
        }
        return age;
    }
    
    @Override
    public void userForm(int user_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
//    protected String retrieveQR(int role) throws IOException{
//        System.out.print("Please enter your username: ");
//        download.RetrieveQR( scan.nextLine(),role);
//        return null;
//    }
}
