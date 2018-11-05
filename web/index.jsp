<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/10/14
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <form action="GetServlet" method="post" onsubmit="return lessoner(this);">
    <input type="text" placeholder="开始下标" name="pageIndex" value="" />
    <input type="text" placeholder="结束下标" name="numsPerPage" value="" />
    <button type="submit">确认查找</button>
  </form>

  </body>
</html>
