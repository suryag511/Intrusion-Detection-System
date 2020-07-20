

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registrationController
 */
@WebServlet("/registrationController")
public class registrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sql="insert into emp values(?,?,?,?,?,?)";  
		String uName =   request.getParameter("cname").toString();
	    String pwd =   request.getParameter("pwd").toString();
	    String gender =   request.getParameter("gender").toString();
	    String mac_address   =   request.getParameter("mac_address").toString();
	    String mail =    request.getParameter("mail").toString();
	    String mbileNo = request.getParameter("mobileNo").toString();
	    
	    String driver = "com.mysql.jdbc.Driver";
	    String connectionUrl = "jdbc:mysql://localhost:3306/";
	    String database = "intrusion";
	    String userid = "root";
	    String password = "root";
	    try
	    {
	    	Class.forName(driver);
	    	Connection conn = DriverManager.getConnection(connectionUrl+database, userid, password);

	    	Statement st = conn.createStatement();
	    	
	    	st.executeUpdate("INSERT INTO registration (name,password,Gender,Mac_Address,Email,mobileNo)"
	    		    +"VALUES ('"+uName+"','"+pwd+"','"+gender+"','"+mac_address+"','"+mail+"','"+mbileNo+"')");
	    		System.out.println("Insert Success");
	    		
	    		
	    		
	    		response.sendRedirect("home.jsp");

	    }
	    catch(Exception ex)
	    {
	    	System.out.println(ex);
	    }
		
	}

}
