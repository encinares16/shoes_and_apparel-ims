package app.controllers;

import app.configdb.DatabaseConnect;
import static app.controllers.MenuController.*;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductController extends DatabaseConnect {
    
    public void displayProduct(int role){
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
        if (user.getRole() == 1) {
            adminMenu();
        } else {
            userMenu();
        }
    }
    
 
    
    public void displayArchivedProduct(){
        String query = "Select * from products WHERE product_archived = 1";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query); 
            System.out.println("\n----------------------- ARCHIVED PRODUCT LIST -----------------------");
            while(result.next()){
                System.out.println( "ID: " + result.getInt("product_id") 
                + "\nBrand: " + result.getString("product_brand") 
                + "\nModel: "+ result.getString("product_model")
                + "\nDescription: "+ result.getString("product_description")
                + "\nOn Stock: "+ result.getInt("on_stock"));
                System.out.println("---------------------------------------------------------------------");
            } 
            if (result.first() == false) {
                System.out.println("\nThere is no product in archived to retrieve\n");
                System.out.println("---------------------------------------------------------------------");
                adminMenu();
            }
            connect.close();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } 
    }
    
    public void checkProduct(){
        String query = "UPDATE products SET products.product_archived = 1 "
                    + "WHERE products.on_stock <= 0";
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.executeUpdate();
            System.out.println("Checking product stock...");
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        }
    }
    
    public int countOrders(int userId){
       // SELECT `invoice_manager`, COUNT(`invoice_manager`),SUM(`order_quantity`) FROM orders GROUP BY `invoice_manager`;
//        String query = "SELECT invoice_manager COUNT(invoice_manager), SUM(order_quantity) "
//                     + "FROM orders WHERE invoice_manager = "+ userId+ "";
        String query = "SELECT invoice_manager, COUNT(invoice_manager), SUM(order_quantity) "
                     + "FROM orders WHERE  invoice_manager = "+ userId+ "";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query); 
            while(result.next()){
                user.setOrdersCount(result.getInt(2));
                user.setTotalOrders(result.getInt(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    void productForm(int admin_id){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n[CREATE NEW PRODUCT]");
        System.out.println("Admin ID: " + admin_id);
        
        System.out.print("Brand: ");
        product.setBrand(scan.nextLine());
        
        System.out.print("Model: ");
        product.setModel(scan.nextLine());
        
        System.out.print("Description: ");
        product.setDescription(scan.nextLine());
        
        try {
            productSizes();
            System.out.print("Select Product Size: ");
            product.setSize(scan.nextInt());
                
            categoryList();
            System.out.print("Select Product Category: ");
            product.setCategory(scan.nextInt());

        } catch (InputMismatchException ime) {
            System.out.println(IME_MESSAGE);
            productForm(admin_id);
        }
        createProduct(admin_id);
    }
    
    public void productUpdateForm(int admin_id){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n[UPDATE PRODUCT]");
        System.out.println("Admin ID: " + admin_id);
        
        System.out.print("Select Product ID: ");
        product.setId(scan.nextInt()); scan.nextLine();
        
        System.out.print("Brand: ");
        product.setBrand(scan.nextLine());
        
        System.out.print("Model: ");
        product.setModel(scan.nextLine());
        
        System.out.print("Description: ");
        product.setDescription(scan.nextLine());
        
        updateProduct(admin_id, product.getId());
    }
    
    public void updateProduct(int user_id, int product_id){
        String query = "UPDATE products SET product_brand = '"+ product.getBrand() + "', "
                    + "product_model = '" + product.getModel() + "', "
                    + "product_description = '" + product.getDescription() + "', "
                    + "created_by = '" + user_id + "' "
                    + " WHERE products.product_id = " + product_id +"";
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.executeUpdate();
            connect.close();
            System.out.println("\nProduct ID `" + product.getId() + "` updated successfully");
            System.out.println("Product Model: " + product.getModel());
            System.out.println("Product Description: " + product.getModel());
            System.out.println("Updated Stock: " + product.getOnStock());
            System.out.println("Admin ID: " + user_id);
            adminMenu();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
            adminMenu();
        } 
    }
    
    public void createProduct(int user_id){
        String query = "INSERT INTO products (product_id, product_brand, product_model, product_description, product_size, product_category, product_archived, on_stock, created_by) "
                     + "VALUES (?,?,?,?,?,?,?,?,?)"; 
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.setString(1, null );
            pst.setString(2, product.getBrand());
            pst.setString(3, product.getModel());
            pst.setString(4, product.getDescription());
            pst.setInt(5, product.getSize());
            pst.setInt(6, product.getCategory());
            pst.setInt(7, 0);
            pst.setInt(8, 0);
            pst.setInt(9, user_id);
            pst.executeUpdate();
            connect.close();
            
            System.out.println("\nProduct " + product.getModel() + " has been added successfully");
            System.out.println("Admin ID: " + user_id);
            System.out.println("On Stock: " + product.getOnStock());
            displayProduct(1);
            
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
            adminMenu();
        } catch(Exception e){
            System.out.println(EXCEPTION_MESSAGE);
            adminMenu();
        }
    }
    
    void archived(int product_id){
        System.out.println("Product ID: " + product_id);
        String query = "UPDATE products SET product_archived = 0 WHERE products.product_id = '" + product_id + "'";
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.executeUpdate();
        }  catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
            adminMenu();
        }
        displayProduct(1);
        adminMenu();
    }
    
    void unlist(int product_id){
        System.out.println("Product ID: " + product_id);
        String query = "UPDATE products SET product_archived = 1 WHERE products.product_id = '" + product_id + "'";
        try {
            ConnectDB();
            pst = connect.prepareStatement(query);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
            adminMenu();
        }
        displayArchivedProduct();
        adminMenu();
    }
    
    private void productSizes(){
        String query = "SELECT * FROM sizes";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query); 
            System.out.println("\n[PRODUCT SIZES LIST]");
            while(result.next()){
                System.out.println("[" + result.getInt(1) + "] " + result.getString(2) + " : " + result.getString(3));
            }
            connect.close();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
            adminMenu();
        }
    }
    
    private void categoryList(){
        String query = "SELECT * FROM categories";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query); 
            System.out.println("\n------------------------- CATEGORY LIST ---------------------------");
            System.out.println("ID  Categories Type \tDescription");
            while(result.next()){
                System.out.println(result.getInt(1) + "    " + result.getString(2) +" \t" + result.getString(3));
            }
            System.out.println("---------------------------------------------------------------------");
            connect.close();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
            adminMenu();
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
            adminMenu();
        }
    }
    
    public void retrieveProduct(){
        Scanner scan = new Scanner(System.in);
        try {
            displayArchivedProduct();
            System.out.println("\n[RETRIEVE PRODUCT]");
            System.out.print("Please enter Product ID to retrive: ");
            archived(scan.nextInt());
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
            retrieveProduct();
        }
    }
    
    public void unListProduct(){ 
        Scanner scan = new Scanner(System.in);
        try {
            
            System.out.println("\n[UNLIST PRODUCT]");
            System.out.print("Please enter Product ID to unlist: ");
            unlist(scan.nextInt());
            displayProduct(1);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
            unListProduct();
        }
    }
    
    public static void main(String[] args) {
        pc.countOrders(2023001);
    }
}
