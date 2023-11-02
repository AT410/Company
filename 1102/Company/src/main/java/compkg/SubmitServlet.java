package compkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubmitServlet
 */
@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
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
		response.setContentType("text/plain; charset=windows-31j");
		PrintWriter out = response.getWriter();
		MemberListDAO dao = new MemberListDAO();
		
		//登録 or 更新
		String mode = (String)request.getParameter("action");
		String id = (String)request.getParameter("submit_id");
		if(mode == "new")
		{
			//新規登録　既存IDチェック
			if(dao.chaeckUserId(id))
			{
				//既存IDのため入力し直し
				request.setAttribute("result", "dup");
				request.getRequestDispatcher("submit.jsp").forward(request, response);
			}
		}
		
		//入力情報の取得
		MemberListDTO obj = new MemberListDTO();
		obj.setId(id);
		obj.setName((String)request.getParameter("submit_name"));
		obj.setTypeCode((String)request.getParameter("submit_type"));
		String birthday = (String)request.getParameter("submit_birthday");
		obj.setBirthDay(Date.valueOf(birthday));
		obj.setGender(Boolean.parseBoolean((String)request.getParameter("submit_gender")));
		obj.setPhone((String)request.getParameter("submit_phone"));
		obj.setMail((String)request.getParameter("submit_mail"));
		obj.setLicense((String)request.getParameter("submit_license"));
		String hire_day = (String)request.getParameter("submit_hire_day");
		obj.setHire_Day(Date.valueOf(hire_day));
		String leaving_date = (String)request.getParameter("leaving_date");
		obj.setLeavingDay(Date.valueOf(leaving_date));
		
		//登録
		
		out.println(mode);
		
	}

}
