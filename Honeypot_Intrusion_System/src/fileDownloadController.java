

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fileDownloadController
 */
@WebServlet("/fileDownloadController")
public class fileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileDownloadController() {
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
		
		String requestFileName = request.getParameter("filePath").toString();
		ResultSet resultSet = null;
		
		 String driver = "com.mysql.jdbc.Driver";
		    String connectionUrl = "jdbc:mysql://localhost:3306/";
		    String database = "intrusion";
		    String userid = "root";
		    String password = "root";
		    String fileData = "";
		    try
			{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(connectionUrl+database, userid, password);

			 conn.createStatement();
			Statement st = conn.createStatement();
			resultSet = st.executeQuery("select UserName,FileName,FileData from fileupload where FileName ='"+requestFileName+"'");
			
			while(resultSet.next())
			{
				fileData = resultSet.getString("FileData");
				System.out.println("fileData::"+fileData);
				
			}
			conn.close();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		
		
		 try{    
	           FileWriter fw=new FileWriter("E:\\output.txt");    
	           fw.write(fileData);    
	           fw.close();    
	          }catch(Exception e){System.out.println(e);}    
	          System.out.println("Success...");    
	          
	          File file = new File("E:\\output.txt");   
	          if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
	          {  
	          System.out.println("not supported");  
	          return;  
	          }  
	          Desktop desktop = Desktop.getDesktop();  
	          if(file.exists())         //checks file exists or not  
	          desktop.open(file);              //opens the specified file  
	          
	          response.sendRedirect("fileDownload.jsp");
	          
	          }  
	     }    
		
		
	


