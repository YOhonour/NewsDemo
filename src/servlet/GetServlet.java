package servlet;


import bean.Datas;
import dao.NewsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

@WebServlet(name = "GetServlet")
public class GetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Datas datas = new Datas();

        HttpSession session = request.getSession(false);
        int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        int numsPerPage = Integer.parseInt(request.getParameter("numsPerPage"));

        Map map = new HashMap();
        int flag = 1;

        if ( request.getParameter("pageIndex") != null && request.getParameter("numsPerPage") != null) {
                try {
                    datas = new NewsDao().get(pageIndex,numsPerPage);

                }catch (Exception e){
                    flag = 0;
                }
        }
        datas.setFlag(flag);
        response.getWriter().print(JSONArray.fromObject(datas));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}