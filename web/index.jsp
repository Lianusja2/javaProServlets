<%--
  Created by IntelliJ IDEA.
  User: Nusya
  Date: 05.11.2017
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<ol>
    <form action="/survey" method="POST">
        <li>What is your Gander?</li>
        <input type="radio" name="gender" value="male"> Male<br>
        <input type="radio" name="gender" value="female"> Female<br>
        <input type="radio" name="gender" value="other"> Other

   <p>
    <li>What is your Age?</li>
    <input type="radio" name="age" value="1-18"> 1-18<br>
    <input type="radio" name="age" value="19-25"> 19-25<br>
    <input type="radio" name="age" value="26-45"> 26-45<br>
    <input type="radio" name="age" value="46+"> 46+


    <p><li>What is your Marital status?</li>
    <input type="radio" name="marital" value="singel"> Singel<br>
    <input type="radio" name="marital" value="married"> Married<br>
    <input type="radio" name="marital" value="relationship"> In relationship

    <p><li>What is your Occupation?</li>
    <input type="radio" name="occupation" value="student"> Student<br>
    <input type="radio" name="occupation" value="worker"> Worker<br>
    <input type="radio" name="occupation" value="unemployed"> Unemployed

    <p>
    <input type="submit" value="Submit"/>
    </form>

</ol>
</body>
</html>
