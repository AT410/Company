package compkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    response.setContentType("text/html; charset=Shift_JIS");
	    PrintWriter out = response.getWriter();

	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>データベーステスト</title>");
	    out.println("</head>");
	    out.println("<body>");

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	    String msg = "";
	    try {
	      Class.forName("com.mysql.jdbc.Driver");
	      msg = "ドライバのロードに成功しました" + "<br>";
	      
	      con = DriverManager.getConnection("jdbc:mysql://localhost/tatsu_db?serverTimezone=UTC","root","Q3bjAZGX");
	    }catch (ClassNotFoundException e){
	      msg = "CLSドライバのロードに失敗しました:"
	      		+ e.getMessage() + "<br>"
	      		+ e.getLocalizedMessage(); 
	    }catch(SQLException e){
	    	msg = "SQLエラー"
	    			+ e.getMessage() + "<br>"
	    			+ e.getLocalizedMessage();
	    }catch (Exception e){
	      msg = "ドライバのロードに失敗しました:"
	      		+ e.getMessage() + "<br>"
	      		+ e.getLocalizedMessage();
	    }finally {
	    	try {
	    		if(con != null) {
	    			con.close();
	    		}
	    	}catch(SQLException e) {
	    		
	    	}
	    }

	    out.println("<p>");
	    out.println(msg);
	    out.println("</p>");

	    out.println("</body>");
	    out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
