package compkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
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
		
		String selectServlet = request.getParameter("menber_check");
		String pushBT = request.getParameter("action");
		
		out.println("RADIO:" + selectServlet);
		out.println("BUTTON:" + pushBT);
		
		//押下されたボタンによって処理を変更
		switch(pushBT)
		{
			case"info"://詳細確認
				//無選択状態なら一覧へリダイレクト
				break;
			case"save"://登録・更新
				if(selectServlet == null)
				{
					//新規登録処理
					
				}
				else
				{
					//更新処理
					
				}
				break;
			case"delete"://削除
				//無選択状態なら一覧へリダイレクト
				
				break;
		}
	}

}
