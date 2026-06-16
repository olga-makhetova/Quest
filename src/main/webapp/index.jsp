<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="model.Game" %>


<html lang="ru">
<head>
    <title>Quest</title>
    <link href="static/main.css" rel="stylesheet">
</head>

<body>
<h1>Квест!</h1>

<!-- Таблица с вопросами и ответами -->
<table class="quest-table ${game.getCssClassName()}">
    <caption>${game.getQuestion()}</caption>

    <tr>
        <c:set var="count" value="${game.getAnswersCount()}"/>
        <c:if test="${count > 0}">
            <c:forEach begin = "0" end = "${count - 1}" var = "i">
                <td onclick="window.location='/quest/go?cardId=${game.getAnswer(i).getCardId()}'">
                    ${game.getAnswer(i).getText()}
                </td>
            </c:forEach>
        </c:if>
    </tr>

</table>

<p>Всего игр сыграно: ${sessionScope.gameCount}</p>
<p>Всего побед: ${sessionScope.winCount}</p>
<p><a href="/quest/go?cardId=0"> Начать заново</a></p>


</body>
</html>