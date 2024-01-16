package app.controllers;

import app.configdb.DatabaseConnect;
import java.util.InputMismatchException;

public class MenuController extends DatabaseConnect{

    public static void userMenu(){
        System.out.println("\n[USER MENU]");
        System.out.println("[1] Create Order         [5] Download QR");
        System.out.println("[2] Check Product List   [6] Edit Profile");
        System.out.println("[3] Your Dashboard       [7] Logout");
        System.out.println("[4] Profile");
        try {
            switch(selector()){
            case 1:
                pc.checkProduct();
                uc.createOrder(user.getId());
                break;
            case 2:
                pc.checkProduct();
                pc.displayProduct(user.getRole());
                break;
            case 3:
                header();
                break;
            case 4:
                uc.userInfo(user.getId(), user.getRole());
                userMenu();
                break;
            case 5:
                System.out.println("Please download qrgen library");
                // admin.retrieveQR(user.getRole());
                userMenu();
                break;
            case 6:
                uc.editProfile(user.getId(),user.getRole());
                break;
            case 7:
                auth.timeOut();
                menu();
                break;
            default:
                System.out.println("Invalid input");
                userMenu();
                break;
            }
        } catch (InputMismatchException ime) {
             System.out.println(IME_MESSAGE);
             userMenu();
        } catch (Exception e){
             System.out.println(EXCEPTION_MESSAGE);
             userMenu();
        } 
    }
    
    public static void adminMenu(){
        System.out.println("\n[ADMIN MENU]");
        System.out.println("[1] Check Products       [7]  Account Dashboard");
        System.out.println("[2] Check Category       [8]  Retrieve QR");
        System.out.println("[3] Check Users          [9]  Profile");
        System.out.println("[4] Invoice Reports      [10] Edit Profile");
        System.out.println("[5] Log Details          [11] Logout");
        System.out.println("[6] Restock Reports");
        try {
            switch(selector()){
                case 1:
                    System.out.println("\n[Check Products]");
                    System.out.println("[1] Create Product\n[2] Update Product\n[3] Add Stock\n[4] Unlist Product\n[5] Retrieve Product\n[6] View Products");
                    switch(selector()){
                        case 1:
                            pc.productForm(user.getId());
                            break;
                        case 2:
                            pc.productUpdateForm(user.getId());
                            break;
                        case 3:
                            admin.addStock();
                            break;
                        case 4:
                            pc.unListProduct();
                            break;
                        case 5:
                            pc.retrieveProduct();
                            break;
                        case 6:
                            pc.displayProduct(user.getRole());
                            break;
                        default:
                            System.out.println(EXCEPTION_MESSAGE);
                            adminMenu();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\n[Check Category]");
                    System.out.println("[1] New Category\n[2] Delete Category\n[3] View Categories");
                    switch(selector()){
                        case 1:
                            cc.newCategoryForm();
                            break;
                        case 2:
                            cc.deleteCategoryForm();
                            break;
                        case 3:
                            cc.categoryForm();
                            break;
                        default:
                            System.out.println(INPUT_MESSAGE);
                            adminMenu();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("\n[Check Users]");
                    System.out.println("[1] Update User\n[2] Delete User\n[3] Retrieve User\n[4] View Users");
                    switch(selector()){
                        case 1:
                            admin.updateUser();
                            break;
                        case 2:
                            admin.deleteUsers();
                            break;
                        case 3:
                            admin.retrieveUsers();
                            break;
                        case 4:
                            System.out.println("\n[View Users]");
                            System.out.println("[1] View All Users\n[2] View All Users in Archived");
                            System.out.print("Select:");
                            switch(selector()){
                                case 1:
                                    admin.viewUsers();
                                    adminMenu();
                                    break;
                                case 2:
                                    admin.viewUsersArchived();
                                    adminMenu();
                                    break;
                                default:
                                    System.out.println(INPUT_MESSAGE);
                                    adminMenu();
                                    break;
                            }
                            break;
                        default:
                            System.out.println(INPUT_MESSAGE);
                            adminMenu();
                            break;
                    }
                    break;
                case 4:
                    admin.seeReports();
                    break;
                case 5:
                    System.out.println("\n[Check Log Reports]");
                    System.out.println("[1] Check By Date\n[2] Check By ID\n[3] Previous Logs\n[4] All Logs");
                    switch(selector()){
                        case 1:
                            admin.checkLogByDate();
                            adminMenu();
                            break;
                         case 2:
                            admin.checkLogById();
                            adminMenu();
                            break;
                        case 3:
                            admin.checkLogDetailsPrevious();
                            adminMenu();
                            break;
                        case 4:
                            admin.checkLogDetails();
                            adminMenu();
                            break;
                        default:
                            System.out.println(INPUT_MESSAGE);
                            break;
                    }
                    break;
                case 6:
                    admin.checkRestockReports();
                    break;
                case 7:
                    header();
                    break;
                case 8:
                    System.out.println("Please download qrgen library");
                    // admin.retrieveQR(user.getRole());
                    adminMenu();
                    break;
                case 9:
                    uc.userInfo(user.getId(), user.getRole());
                    adminMenu();
                    break;
                case 10:
                    uc.editProfile(user.getId(),user.getRole());
                    break;
                case 11:
                    auth.timeOut();
                    menu();
                    break;
                default:
                    System.out.println(INPUT_MESSAGE);
                    adminMenu();
                    break;
            }
         } catch (InputMismatchException ime) {
             System.out.println(IME_MESSAGE);
             adminMenu();
         } catch (Exception e){
             System.out.println(EXCEPTION_MESSAGE);
             adminMenu();
         } 
    }
    
    
    protected static void menu(){
        System.out.println("--------------------------- LOGIN USER ----------------------------");
        System.out.println("[1] Login\n[2] Create User\n[3] Exit");
         try {
            switch(selector()){
                case 1: 
                    auth.login(0,null,null);
                    break;
                case 2: 
                    auth.userForm();
                    menu();
                    break;
                case 3: 
                    System.out.println("Program Closed.");
                    System.exit(0);
                default:
                    System.out.println(INPUT_MESSAGE);
                    menu();
            }
        } catch (InputMismatchException ime) {
            System.out.println(IME_MESSAGE);     
            menu();
        } catch (Exception e){
            System.out.println(EXCEPTION_MESSAGE);
            menu();
        } 
    }
    protected static void header(){
        System.out.println("\n\n ------------------------------------------------------------------ ");
        System.out.println("▸                                                                 ◂");
        System.out.println("▸▸                      SHOES AND APPAREL                       ◂◂");
        System.out.println("▸▸▸                 INVENTORY MANAGEMENT SYSTEM               ◂◂◂");
        System.out.println("▸▸                           GROUP 4                            ◂◂");
        System.out.println("▸                                                                 ◂");
        System.out.println(" ------------------------------------------------------------------ ");
        main.dashboard(user.getUserName(), user.getPassword(), user.getRole(), user.getId());
    }
}
