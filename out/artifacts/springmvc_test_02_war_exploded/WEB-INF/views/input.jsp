<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/12
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>input</title>
</head>
<body>
    <!--
        1、为什么使用form（springmvc）标签呢？
        可以更快速的开发出表单页面，而且可以更方便的进行表单回显
        2、注意：
        可以通过ModelAttribute属性指定绑定的模型属性
        若没有指定该属性，则默认request域对象中读取command的表单bean，如果该属性值也不存在，则会发生错误。
     -->
    <!-- springmvc表单标签默认回显 -->
    <form:form action="${pageContext.request.contextPath}/stu" method="post" modelAttribute="student">
        <!-- path属性对应html表单标签的name属性值 -->
        <c:if test="${student.sno == null}">
            name:<form:input path="name"/>
            <form:errors path="name"></form:errors>
            <br>
        </c:if>
        <c:if test="${student.sno != null}">
            <form:hidden path="sno"/><br>
            <input type="hidden" name="_method" value="PUT"/>
        </c:if>
        age:<form:input path="age"/><br>
        mark:<form:input path="mark"/>
        <form:errors path="mark"></form:errors>
        <br>
        teacher:
        <form:select path="teacherno" items="${teachers}" itemLabel="name" itemValue="teacherno"></form:select><br>

        <%--
            1、数据类型转换
            2、数据类型格式化
            3、数据校验
                1）如何验证？注解？
                    ①使用JSR 303验证标准
                    ②加入 hibernate validator验证框架
                    ③在springmvc配置文件中加入<mvc:annotation-driven/>
                        <mvc:annotation-driven/> 会默认装配好一个LocalValidatorFactoryBean
                    ④需要在bean的属性上配置对应的注解
                    ⑤在目标方法bean类型的前面添加@Valid注解
                2）验证出错转向那个页面
                3）错误消息？如何显示，如何把错误消息进行国际化
        --%>
        birth:<form:input path="birth"/>
        <form:errors path="birth"></form:errors>
        <br>
        high:<form:input path="high"/>
        <form:errors path="high"></form:errors>
        <br>
        <input type="submit" value="submit"/><br>

        <!-- 显示所有的错误消息 -->
        <form:errors path="*"></form:errors>
    </form:form>
</body>
</html>
