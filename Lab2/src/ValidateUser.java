

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ValidateUser() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String unm=request.getParameter("txtUname");
		String pwd=request.getParameter("txtpwd");
		if((unm.equals("Admin"))&&(pwd.equals("admin"))) {
			RequestDispatcher rdValid=request.getRequestDispatcher("/SuccessServlet.html");
			rdValid.forward(request, response);
	}
	else {
        out.print("Sorry username or password error");  
		RequestDispatcher rdFail=request.getRequestDispatcher("/Login.html");
		rdFail.include(request, response);
	}
	}
}
