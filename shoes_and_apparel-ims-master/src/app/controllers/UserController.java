package app.controllers;

import app.configdb.DatabaseConnect;
import static app.controllers.MenuController.adminMenu;
import static app.controllers.MenuController.userMenu;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserController extends DatabaseConnect{
    Scanner scan = new Scanner(System.in);
    
    private void customerForm(){
        System.out.println("[CLIENT FORM]");
        System.out.print("First Name: ");
        customer.setFirstName(scan.nextLine()); 
        System.out.print("Last Name: ");
        customer.setLastName(scan.nextLine()); 
        System.out.print("Contact: ");
        customer.setContact(scan.nextLine());
        newCustomer(); 
    }
    
    private void newCustomer(){
        String query = "INSERT INTO customers (customer_firstname, customer_lastname, customer_contact) VALUES (?,?,?)";
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.setString(1, customer.getFirstName()); 
            pst.setString(2, customer.getLastName()); 
            pst.setString(3, customer.getContact());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
        } 
        System.out.println("Customer 1" + customer.getFirstName()+ "1 " + customer.getLastName() + " added successfully");
    }
    
    public void displayCustomer(){
        String qry = "SELECT * FROM customers ORDER BY customer_id ASC";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(qry);
            System.out.println("\n---------------------------- CLIENT LIST ----------------------------");
            System.out.println("ID    Client Name");
            while(result.next()){
                // output formmating, if ID (from database) display ID 1-9. 
                if (result.getInt(1) < 10) {
                    System.out.println("["+ result.getInt("customer_id") + "]   " + result.getString("customer_firstname") + " " + result.getString("customer_lastname"));
                } else if (result.getInt(1) < 100){ // display ID 10-100, decrease spacing (1 backspace)
                    System.out.println("["+ result.getInt("customer_id") + "]  " + result.getString("customer_firstname") + " " + result.getString("customer_lastname"));
                }
            }
            connect.close();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
        } 
    }
    
    public void displayProductOnOrder(){
        String query = "Select * from products WHERE product_archived = 0";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            System.out.println("\n--------------------------- PRODUCT LIST --------------------------");
            while(result.next()){
                System.out.println( "ID: " + result.getInt("product_id") 
                + "\nBrand: " + result.getString("product_brand") 
                + "\nModel: "+ result.getString("product_model")
                + "\nDescription: "+ result.getString("product_description")
                + "\nOn Stock: "+ result.getInt("on_stock"));
                System.out.println("--------------------------------------------------------------------");
            }
            connect.close();
        } catch(SQLException e){
            System.out.println(SQLE_MESSAGE);
        } catch(Exception e){
            System.out.println(EXCEPTION_MESSAGE);
        }
    }
    
    int getStockById(int productId){
        int stock = 0;
        String query = "SELECT on_stock FROM products WHERE product_id = " + productId;
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);

            while(result.next()){
                stock = result.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        } 
        updateStock(productId, stock);
        return stock;
    }
    
    void updateStock(int productId, int stock){
        int updatedStock = stock - customer.getQuantity();
        System.out.println("On Stock (updated): " + updatedStock);
        String query = "UPDATE products SET on_stock = " + updatedStock + " WHERE products.product_id = " + productId;
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    
    public void createOrder(int user_id){
        System.out.println("\n[CREATE ORDER]");
        System.out.println("Invoice Manager ID: " + user_id);
        System.out.println("[1] Get Client Info (new) \n[2] Regular Customer");
        Scanner sc = new Scanner(System.in);
        try {
            switch(selector()){
                case 1: 
                    customerForm();
                    displayCustomer();
                    break;
                case 2: 
                    displayCustomer();
                    break;
                default:
                    System.out.println(INPUT_MESSAGE);
            }
        } catch (InputMismatchException ime) {
            System.out.println(IME_MESSAGE + "\nOrder Cancelled...");
            createOrder(user_id);
        } catch (Exception e){
            System.out.println(EXCEPTION_MESSAGE);
        }
        
        try {
            System.out.print("Please select customer id: ");
            customer.setId(scan.nextInt());
            displayProductOnOrder();
            System.out.print("Please select product id: ");
            product.setId(sc.nextInt());
            System.out.print("Please input quantity: ");
            customer.setQuantity(sc.nextInt());   
            System.out.println("[1] Yes\n[Any] Back\nDo you want to continue?");
            switch(selector()){
                case 1:
                    System.out.println("Preparing order...");
                    break;
                 default:
                    System.out.println("Back to Menu");
                    userMenu();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println(INPUT_MESSAGE);
            userMenu();
        } catch (Exception e) {
            System.out.println("Order failed.\nSomething went wrong. Please try again");
            userMenu();
        }
        
        String query = "INSERT INTO orders (customer_id, product_id, order_quantity, invoice_manager) VALUES (?,?,?,"+ user_id +")";
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.setInt(1, customer.getId());
            pst.setInt(2, product.getId());
            pst.setInt(3, customer.getQuantity());
            pst.executeUpdate();
            System.out.println("\n----------------------- ORDER SUCCESSFULLY ------------------------");
            System.out.println("Order successfully created for customer id: " + customer.getId());
            System.out.println( "Date: " + df.format(date));
            System.out.println( "Time: " + tf.format(date));
            System.out.println("Invoice Manager: " + user.getUserName());
            System.out.print("Product ID [" + product.getId() + "] ");
            getStockById(product.getId());
            System.out.println("-------------------------------------------------------------------");
            userMenu();
            connect.close();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
            userMenu();
        } catch (InputMismatchException e) {
            System.out.println(INPUT_MESSAGE);
            userMenu();
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE + "\nOrder failed. Please try again");
            userMenu();
        }
    }
    
    
     public void userInfo(int user_id, int role){
         System.out.println("yeah");
        String query = "SELECT * FROM users "
                     + "WHERE users.user_id = " + user_id +"";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            System.out.println("-------------------------- YOUR PROFILE ---------------------------");

            while(result.next()){
                System.out.println("ID: " + result.getInt("user_id"));
                System.out.println("Username: " + result.getString("username"));
                System.out.println("First Name: " + result.getString("user_firstname"));
                System.out.println("Last Name: " + result.getString("user_lastname"));
                System.out.println("Contact: " + result.getString("user_contact"));
                System.out.println("Birthday: " + result.getString("user_birthday"));
                System.out.println("Age: " + result.getInt("user_age"));
                System.out.println("Role: " + (result.getInt(11) == 1 ? "Admin" : "User"));
            }
            System.out.println("---------------------------------------------------------------------");
            if(user.getRole() == 1 || role == 1){
                adminMenu();
            } else {
                userMenu();
            }
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        }
    }
    
    public void editProfile(int user_id, int role){
        auth.userForm(user_id);
        String birthday = user.getMonthOfBirth() + " " + user.getDayOfBirth() + ", " + user.getYearOfBirth();
        String query = "UPDATE users SET user_firstname = '"+ user.getFirstName() + "', "
                    + "user_lastname = '" + user.getLastName() + "', "
                    + "user_birthday = '" + birthday + "', "
                    + "user_age = '" + user.getAge() + "', "
                    + "user_contact = '" + user.getContact() + "', "
                    + "password = '" + user.getPassword() + "' "
                    + " WHERE users.user_id = " + user_id +"";
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.executeUpdate();
            System.out.println("\n----------------------- ID " + user_id + " NEW INFO -------------------------");
            System.out.println("Username `" + user.getUserName() +"` updated successfully");
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Contact: " + user.getContact());
            System.out.println("Birthday: " + birthday);
            System.out.println("Age: " + user.getAge());
            System.out.print("Password: ");
            for (int i = 0; i < user.getPassword().length(); i++) {
                System.out.print("*");
            } 
            System.out.println("\n---------------------------------------------------------------------");
            if(user.getRole() == 1){
                adminMenu();
            } else {
                userMenu();
            }
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        }
    }

    public void editUserProfile(int user_id, int role){
        auth.userForm(user_id);
        String birthday = user.getMonthOfBirth() + " " + user.getDayOfBirth() + ", " + user.getYearOfBirth();
        String query = "UPDATE users SET user_firstname = '"+ user.getFirstName() + "', "
                    + "user_lastname = '" + user.getLastName() + "', "
                    + "user_birthday = '" + birthday + "', "
                    + "user_age = '" + user.getAge() + "', "
                    + "user_contact = '" + user.getContact() + "', "
                    + "password = '" + user.getPassword() + "' "
                    + " WHERE users.user_id = " + user_id +"";
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.executeUpdate();
            System.out.println("---------------------------------------------------------------------");
            System.out.println("User ID `" + user_id +"` updated successfully");
            System.out.println("First Name: " + user.getFirstName());
            System.out.println("Last Name: " + user.getLastName());
            System.out.println("Contact: " + user.getContact());
            System.out.println("Birthday: " + birthday);
            System.out.println("Age: " + user.getAge());
            System.out.print("Password: ");
            for (int i = 0; i < user.getPassword().length(); i++) {
                System.out.print("*");
            }
            System.out.println("\n---------------------------------------------------------------------");
            if(user.getRole() == 1){
                adminMenu();
            } else {
                userMenu();
            }
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
       
        } 
    }
    public static void main(String[] args) {
        
        uc.userInfo(2023001, 1);
    }
}
