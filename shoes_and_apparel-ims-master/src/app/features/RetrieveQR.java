//package app.features;
//
//import app.configdb.DatabaseConnect;
//import app.controllers.MenuController;
//import com.mysql.jdbc.Blob;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.InputMismatchException;
//
//public class RetrieveQR extends DatabaseConnect {
//    
//    public void RetrieveQR(String username, int role) throws IOException{
//        String query = "SELECT image FROM qrcode WHERE qrcode.username = '" + username + "'";
//        try {
//            ConnectDB();
//            pst = connect.prepareCall(query);
//            result = pst.executeQuery();
//            System.out.println("Connecting database...");
//            Thread.sleep(3000);
//            System.out.println("Checking QR for user `" + username + "`");
//            Thread.sleep(3000);
//            System.out.println("Downloading QR for user `" + username + "`");
//            Thread.sleep(3000);
//            while(result.next()){
//                Blob b = (Blob) result.getBlob(1);
//                byte barr[] = b.getBytes(1, (int)b.length());
//                File file = new File("C://shoes-and-apparel-qr//users-qr//" + username + ".jpg"); // Please create new directories to your local system and copy paste dir path
//                try (FileOutputStream output = new FileOutputStream(file)) {
//                    output.write(barr);
//                }
//                System.out.println("QR downloaded successfuly");
//            }
//            if(result.first() == false){
//                Thread.sleep(2000);
//                System.out.println("There is no image QR that exist in the database\nDo you want to create one ?\n[1] Yes [Any] No (Back to Menu)");
//                switch(selector()){
//                    case 1:
//                        createQR.create(user.getUserName());
//                        break;
//                    default:
//                        if(role == 1 || user.getRole() == 1){
//                            MenuController.adminMenu();
//                        } else {
//                            MenuController.userMenu();
//                        }
//                }
//            } 
//        } catch (InterruptedException | SQLException e) {
//            System.out.println(SQLE_MESSAGE);
//        } catch (InputMismatchException e){
//            if(role == 1 || user.getRole() == 1){
//                MenuController.adminMenu();
//            } else {
//                MenuController.userMenu();
//            }
//        }
//    }
//}
