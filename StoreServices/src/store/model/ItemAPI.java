package store.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ItemAPI
 */
@WebServlet("/ItemAPI")
public class ItemAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ItemServlet itemServlet = new ItemServlet();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map paras = getParasMap(request);

		String outputString = itemServlet.updateitem(
				paras.get("itemCode").toString(),
				paras.get("item_category").toString(), 
				paras.get("item_name").toString(),
				paras.get("item_des").toString(), 
				paras.get("price").toString(), 
				paras.get("date").toString());

		response.getWriter().write(outputString);	
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map paras = getParasMap(request);
		String output = itemServlet.deleteitem(paras.get("itemCode").toString());
		response.getWriter().write(output);
		
	}
	
	private Map getParasMap(HttpServletRequest request) {

		Map<String, String> map = new HashMap<String, String>();

		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ?

					scanner.useDelimiter("\\A").next() : "";
			scanner.close();

			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {

		}
		return map;
	}

}
