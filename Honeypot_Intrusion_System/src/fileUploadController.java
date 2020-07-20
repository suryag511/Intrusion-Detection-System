

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fileUploadController
 */
@WebServlet("/fileUploadController")
public class fileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileUploadController() {
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
		String fileName = request.getParameter("filePath");
		System.out.println("fileName::"+fileName);
		String userName = "Elango";
		
		String driver = "com.mysql.jdbc.Driver";
	    String connectionUrl = "jdbc:mysql://localhost:3306/";
	    String database = "intrusion";
	    String userid = "root";
	    String password = "root";
		
		BufferedReader br = null;
		FileReader fr = null;
		
		 DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();
	        System.out.println(sdf.format(date).toString());
		
		String reason = "File Size Limit Exceeded";

		try {
			File file = new File("E:\\"+"\\"+fileName);
			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			long fileSize = file.length();
		    
		     System.out.println("File size in bytes is: " + fileSize);
		     System.out.println("File size in KB is : " + (double)fileSize/1024);
		     System.out.println("File size in MB is :" + (double)fileSize/(1024*1024));
			
			String sCurrentLine;
			System.out.println("fileSize:::"+fileSize);
			if(fileSize<100)
			{	
			

				while ((sCurrentLine = br.readLine()) != null) 
				{
					//System.out.println(sCurrentLine);
					
					insertDataIntoSensor(sCurrentLine,fileName);
					
				}
			System.out.println("Insert success::");
			response.sendRedirect("success.jsp");
			}
			else
			{
				try
			    {
			    	Class.forName(driver);
			    	Connection conn = DriverManager.getConnection(connectionUrl+database, userid, password);

			    	Statement st = conn.createStatement();
			    	
			    	st.executeUpdate("INSERT INTO nonlegitimate (Name,LoginTime,Reason)"
			    		    +"VALUES ('"+userName+"','"+sdf.format(date).toString()+"','"+reason+"')");
			    		//System.out.println("Insert Success");
			    		
			    		
			    		
			    		//response.sendRedirect("index.jsp");
			    	st.close();
			    	conn.close();

			    }
			    catch(Exception ex)
			    {
			    	System.out.println(ex);
			    }
				response.sendRedirect("error.jsp");
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		
		
	}
		
		//response.sendRedirect("viewDatas.jsp");
	}
	
	public void insertDataIntoSensor(String inputDatas,String fileName)
	{
		String userName = "Elango";
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
		    	
		    	st.executeUpdate("INSERT INTO FileUpload (UserName,FileData,FileName)"
		    		    +"VALUES ('"+userName+"','"+inputDatas.trim()+"','"+fileName+"')");
		    		//System.out.println("Insert Success");
		    		
		    		
		    		
		    		//response.sendRedirect("index.jsp");
		    	st.close();
		    	conn.close();

		    }
		    catch(Exception ex)
		    {
		    	System.out.println(ex);
		    }
		
	}
}


