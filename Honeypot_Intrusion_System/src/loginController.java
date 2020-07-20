

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
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
		String name = request.getParameter("userName").toString();
		String pwd = request.getParameter("password").toString();
		try
		{
			StringBuilder sb = new StringBuilder();
			InetAddress ip;
		
				ip = InetAddress.getLocalHost();
				
				NetworkInterface network = NetworkInterface.getByInetAddress(ip);
				byte[] mac = network.getHardwareAddress();
				System.out.print("MAC address : ");

				
				for (int i = 0; i < mac.length; i++) {
					sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
				}
				System.out.println(sb.toString());
			 
			
			
			String dbName = "";
			String dbPwd = "";
			String driver = "com.mysql.jdbc.Driver";
			String connectionUrl = "jdbc:mysql://localhost:3306/";
			String database = "intrusion";
			String userid = "root";
			String password = "root";
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			 DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
	        System.out.println(sdf.format(date));
	        Statement st = null;
	        String reason="Non-Registered User";
			
			String mac_Address = "";
			try
			{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(connectionUrl+database, userid, password);
			st = conn.createStatement();
			 conn.createStatement();
			Statement st1 = conn.createStatement();
			resultSet = st.executeQuery("select name,password,Mac_Address from registration where name ='"+name+"'");
			
			while(resultSet.next())
			{
				dbName = resultSet.getString("name");
				dbPwd  = resultSet.getString("password");
				mac_Address = resultSet.getString("Mac_Address");
			}
			
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			
			if(name.equalsIgnoreCase(dbName))
			{
				System.out.println("1");
				if(sb.toString().equalsIgnoreCase(mac_Address))
				{
					System.out.println("Elango"+sb.toString());
					response.sendRedirect("userSelection.jsp");
					System.out.println("2");
				}
				
			}
			else if(name.equalsIgnoreCase("Admin"))
			{
				response.sendRedirect("AdminSelection.jsp");
			} 
			else 
			{
				System.out.println("3");
				st.executeUpdate("INSERT INTO nonlegitimate (Name,LoginTime,Reason)"
		    		    +"VALUES ('"+name+"','"+sdf.format(date).toString()+"','"+reason+"')");
		    		System.out.println("Insert Success");
		    		
				response.sendRedirect("error.jsp");
				
			}
			
			
			
			
			
			
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		
	}

}
