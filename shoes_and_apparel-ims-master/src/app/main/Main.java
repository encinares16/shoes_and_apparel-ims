package app.main;

import app.controllers.MenuController;

public class Main extends MenuController{
    
    public void dashboard(String username, String password, int role, int user_id){
        pc.countOrders(user_id);
        String account = (role == 1 ? "Admin" : "User");
        System.out.println("------------------------- " + account.toUpperCase() + " DASHBOARD --------------------------");
        System.out.println("Date: " + df.format(date) + "\t\t\t      " + account + " ID: " + user_id);
        System.out.println("Time In: " + tf.format(date) + "\t\t\t      Welcome, " + username + "!");
        System.out.println("Account: " + account);
        System.out.println("Status: Good");
        if(role == 0){
            System.out.println("Orders Count: " + user.getOrdersCount());
            System.out.println("Total Order: " + user.getTotalOrders());
        }

        System.out.println("--------------------------------------------------------------------");
        user.setUserName(username);
        user.setId(user_id);
        user.setRole(role);
        auth.timeIn(user_id);
        
        if (role == 1) {
            adminMenu();
        } else {
            userMenu();
        }
    }
    
    public static void main(String[] args) {
        menu();
    }
}

