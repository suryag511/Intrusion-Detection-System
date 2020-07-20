

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
 * Servlet implementation class thresholdController
 */
@WebServlet("/thresholdController")
public class thresholdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thresholdController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uName =   request.getParameter("cname").toString();
	    String u_Size =   request.getParameter("u_Size").toString();
	    String d_Size =   request.getParameter("d_Size").toString();
	    
	    
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
	    	
	    	st.executeUpdate("INSERT INTO Protocol (userName,Upload_Size,Download_Size)"
	    		    +"VALUES ('"+uName+"','"+u_Size+"','"+d_Size+"')");
	    		System.out.println("Insert Success");
	    		
	    		
	    		
	    		response.sendRedirect("AdminSelection.jsp");

	    }
	    catch(Exception ex)
	    {
	    	System.out.println(ex);
	    }
		
	}

}
