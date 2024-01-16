package app.configdb;

import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.Scanner;
import app.controllers.*;
import app.main.Main;
import app.models.Product;
import app.models.User;
import java.util.Date;

public abstract class Config {
    
    final protected String DRIVER = "com.mysql.jdbc.Driver";
    final protected String URL = "jdbc:mysql://localhost:3306/shoes_and_apparel";
    final protected String USER = "root";
    final protected String PASSWORD = "";
    
    public Connection connect;
    public Statement stmnt;
    public ResultSet result;
    public PreparedStatement pst;
    
    public final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    public final SimpleDateFormat tf = new SimpleDateFormat("HH:mm:ss");
    public final SimpleDateFormat dtformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    public final SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    public final SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    protected Date date = new Date();

    protected static MenuController menu = new MenuController();
    protected static ProductController pc = new ProductController();
    protected static CategoryControler cc = new CategoryControler();
    protected static AdminController admin = new AdminController();
    protected static AuthController auth = new AuthController();
    protected static UserController uc = new UserController();
    protected static Main main = new Main();
    
    // protected static RetrieveQR download = new RetrieveQR();
    // protected static GenerateQR createQR = new GenerateQR();

    protected static User user = new User();
    protected static User updateUser = new User();
    protected static User customer = new User();

    protected static Product product = new Product();
    protected static Product updateProduct = new Product();
    protected static Product category = new Product();

    protected static final String EXCEPTION_MESSAGE = "Something went wrong...";
    protected static final String IME_MESSAGE = "Please enter number only";
    protected static final String INPUT_MESSAGE = "Invalid. Please input correct number.";
    protected static final String SQLE_MESSAGE = "Something went wrong... (SQL Exception)";
    
    // create reusable private method for user input. trying to apply 'DRY' 
    protected static int selector(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select: ");
        int selector = scanner.nextInt();
        return selector;
    }
}
