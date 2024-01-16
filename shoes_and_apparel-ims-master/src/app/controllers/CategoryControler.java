package app.controllers;

import app.configdb.DatabaseConnect;
import static app.controllers.MenuController.adminMenu;
import java.sql.SQLException;
import java.util.Scanner;

public class CategoryControler extends DatabaseConnect{
    Scanner scan = new Scanner(System.in);
    public void categoryForm(){
       String query = "SELECT * FROM categories WHERE categories_archieved = 0";
        try {
            ConnectDB();
            stmnt = connect.createStatement();
            result = stmnt.executeQuery(query);
            System.out.println("------------------------ PRODUCT CATEGORIES ------------------------");
            System.out.println("ID\tCategory Name\t  Category Description");
            while(result.next()){
                int categoryId = result.getInt("categories_id");
                String categoryName = result.getString("categories_name");
                String categoryDescription = result.getString("categories_description");
                System.out.println(categoryId + "\t" + categoryName + "\t   " + categoryDescription );
            } 
        System.out.println("--------------------------------------------------------------------");
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        } catch (Exception e) {
            System.out.println(EXCEPTION_MESSAGE);
        }
        adminMenu();
    }

    public void newCategoryForm(){
        System.out.println("\n[NEW CATEGORY]");
        System.out.print("Category Name: ");
        category.setName(scan.nextLine());
        System.out.print("Category Details: ");
        category.setDescription(scan.nextLine().toLowerCase());
        newCategory();
    }
    
    public void newCategory(){
        String qry = "INSERT INTO categories (categories_name, categories_description) VALUES (?,?)";
        try {
            ConnectDB();
            pst = connect.prepareStatement(qry);
            pst.setString(1, category.getName()); 
            pst.setString(2, category.getDescription());
            pst.executeUpdate();
            System.out.println("\nCategory " + category.getName() + " added successfully");
            categoryForm();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        }
    }
    
    public void deleteCategoryForm(){
        System.out.println("[DELETE CATEGORY]");
        System.out.print("Category ID : ");
        category.setId(scan.nextInt());
        deleteCategory();
    }
    
    public void deleteCategory(){
        String qry = "update categories set categories_archieved = 1 where categories_id = ?";
        try {
            ConnectDB();
            pst = connect.prepareStatement(qry);
            pst.setInt(1, category.getId()); 
            pst.executeUpdate();
            categoryForm();
        } catch (SQLException e) {
            System.out.println(SQLE_MESSAGE);
        }
    }
}
