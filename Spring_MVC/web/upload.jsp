<%--
  Created by IntelliJ IDEA.
  User: 王天语
  Date: 2022/4/24
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">
        username<input type="text" name="username"><br/>
        file<input type="file" name="upload"><br/>
        <input type="submit" name="submit">
    </form>
</body>
</html>
