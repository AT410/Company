package compkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
//ログイン処理クラス
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/plain; charset=windows-31j");
		PrintWriter out = response.getWriter();
		
		//入力されたID・パスワードを取得
		String LoginID = (String)request.getParameter("LoginId");
		String PassWord = (String)request.getParameter("PassWord");
		
		out.println(LoginID + PassWord);
		
		//DTOに格納
		AdminUserDTO obj = new AdminUserDTO();
		obj.setId(LoginID);
		obj.setPass(PassWord);
		
		//DAO
		AdminUserDAO dao = new AdminUserDAO();
		
		if(dao.CheckAdminUser(obj))
		{
			//ユーザー認証確認
			HttpSession session = request.getSession();
			session.setAttribute("AdminUser", obj);
			response.sendRedirect("/Company/MemberList.jsp");
		}
		else
		{
			//対象ユーザー存在なし
			request.setAttribute("result", "Not Found");
			request.getRequestDispatcher("LogIn.jsp").forward(request,response);
		}
	}
}
