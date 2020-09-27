<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FileUpload</title>
</head>
<body>
    <!-- 文件上传 -->
    <h4>文件上传</h4>
    <form action="testFileUpload" method="post" enctype="multipart/form-data">
        File:<input type="file" name="file">
        Desc:<input type="text" name="desc">
        <input type="submit" value="submit">
    </form>
    <!-- 多个文件上传 -->
    <br><br>
    <h4>多个文件上传</h4>
    <form action="testFilesUpload" method="post" enctype="multipart/form-data">
        File1:<input type="file" name="files">
        File2:<input type="file" name="files">
        <input type="submit" value="submit">
    </form>
</body>
</html>
