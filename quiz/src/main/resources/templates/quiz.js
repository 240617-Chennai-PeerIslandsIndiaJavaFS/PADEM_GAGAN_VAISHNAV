<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Question</title>
</head>
<body>
    <h1>Quiz Question</h1>
    <form action="/quiz/answer" method="post">
        <p>${question.questionText}</p>
        <input type="text" name="answer" />
        <input type="hidden" name="questionId" value="${question.id}" />
        <button type="submit">Submit Answer</button>
    </form>
</body>
</html>
