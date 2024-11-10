<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Despesa</title>
</head>
<body>
<h2>Cadastro de Despesa</h2>
<form action="expense" method="POST">
    <label for="description">Descrição:</label>
    <input type="text" id="description" name="description" required><br>

    <label for="amount">Valor:</label>
    <input type="number" id="amount" name="amount" step="0.01" required><br>

    <label for="date">Data:</label>
    <input type="date" id="date" name="expenseDate" required><br>

    <label for="source">Fonte:</label>
    <input type="text" id="source" name="source" required><br>

    <button type="submit">Cadastrar Despesa</button>
</form>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>
</body>
</html>
