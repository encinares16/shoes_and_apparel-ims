//package app.features;
//
//import app.configdb.DatabaseConnect;
//import com.mysql.jdbc.PreparedStatement;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//
//import java.sql.SQLException;
//import java.util.logging.*;
//import javax.imageio.ImageIO;
//
//public class GenerateQR extends DatabaseConnect{
//    
//    public void generate(String username) throws InterruptedException{
//        System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
//        System.out.println("Email: " + user.getEmail());
//        System.out.println("Username: " + user.getUserName());
//        System.out.println("Password: " + user.getPassword());
//        System.out.println("Registration for user: " + user.getUserName() + " has completed.");
//        
//        try {
//            String filename = user.getUserName()+".jpg";
//            String details = user.getFirstName() + " " + user.getLastName();
//            ByteArrayOutputStream output = QRCode.from(user.getUserName()).to(ImageType.PNG).stream(); // Generate QR using qrgen library 
//            File file = new File("C://shoes-and-apparel-qr//users-qr//" + filename);  // Please create new directories to your local system and copy paste dir path
//            try {
//                FileOutputStream outputStream = new FileOutputStream(file);
//                outputStream.write(output.toByteArray());
//                outputStream.flush();
//            } catch (IOException e) {
//                 System.out.println(e);
//            }
//            ConnectDB(); // Reconnect to Database
//            System.out.println("QRCode Generated for user: " + user.getUserName());
//            pst = (PreparedStatement) connect.prepareStatement("insert into qrcode(username,filename,description,image)values(?,?,?,?)");
//            pst.setString(1, user.getUserName()); 
//            pst.setString(2, filename);
//            pst.setString(3, details);
//            FileInputStream inputStream = new FileInputStream("C://shoes-and-apparel-qr//users-qr//" + filename); 
//            pst.setBinaryStream(4, inputStream, (int) file.length());
//            pst.executeUpdate();
//            System.out.println("Uploading QR to database...");
//            Thread.sleep(5000);
//            System.out.println("QRCode Uploaded Successfully");
//            try {
//                System.out.println("Set generated image to black...");
//                Thread.sleep(5000);
//                System.out.println("--------------------------------------------------------------------");
//                BufferedImage buff = new BufferedImage(125,125,BufferedImage.TYPE_BYTE_GRAY);
//                output = new ByteArrayOutputStream();
//                Graphics2D g = buff.createGraphics();
//                g.setColor(Color.black);
//                ImageIO.write(buff, "jpg", new File("C://shoes-and-apparel-qr//users-qr//"+ username + ".jpg"));
//                output.close();
//            } catch (InterruptedException ie) {
//                System.out.println(ie);
//            } catch (IOException ex) {
//                Logger.getLogger(GenerateQR.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (FileNotFoundException | SQLException e) {
//            System.out.println(EXCEPTION_MESSAGE);
//        }
//    }
//    
//    public void create(String username) throws InterruptedException{
//        System.out.println("Name: " + user.getFirstName() + " " + user.getLastName());
//        System.out.println("Email: " + user.getEmail());
//        System.out.println("Username: " + user.getUserName());
//        System.out.println("Password: " + user.getPassword());
//        System.out.println("Registration for user: " + user.getUserName() + " has completed.");
//        
//        try {
//            String filename = user.getUserName()+".jpg";
//            String details = user.getFirstName() + " " + user.getLastName();
//            ByteArrayOutputStream output = QRCode.from(user.getUserName()).to(ImageType.PNG).stream(); // Generate QR using qrgen library 
//            File file = new File("C://shoes-and-apparel-qr//users-qr//" + filename);  // Please create new directories to your local system and copy paste dir path
//            try {
//                FileOutputStream outputStream = new FileOutputStream(file);
//                outputStream.write(output.toByteArray());
//                outputStream.flush();
//            } catch (IOException e) {
//                 System.out.println(e);
//            }
//            ConnectDB(); // Reconnect to Database
//            System.out.println("QRCode Generated for user: " + user.getUserName());
//            pst = (PreparedStatement) connect.prepareStatement("insert into qrcode(username,filename,description,image)values(?,?,?,?)");
//            pst.setString(1, user.getUserName()); 
//            pst.setString(2, filename);
//            pst.setString(3, details);
//            FileInputStream inputStream = new FileInputStream("C://shoes-and-apparel-qr//users-qr//" + filename); 
//            pst.setBinaryStream(4, inputStream, (int) file.length());
//            pst.executeUpdate();
//            System.out.println("Uploading QR to database...");
//            Thread.sleep(5000);
//            System.out.println("QRCode Uploaded Successfully");
//
//        } catch (FileNotFoundException | SQLException e) {
//            System.out.println(EXCEPTION_MESSAGE);
//        }
//    }
//}
