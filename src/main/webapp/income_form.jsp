<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
  <meta charset="UTF-8">
  <title>Cadastro de Receita</title>
  <script>
    function formatCurrency(input) {
      let value = input.value.replace(/\D/g, "");
      value = (parseInt(value, 10) / 100).toFixed(2);
      input.value = value.replace(".", ".");
    }
  </script>
</head>
<body>
<h2>Cadastro de Receita</h2>
<form action="income" method="POST">
  <label for="description">Descrição:</label>
  <input type="text" id="description" name="description" required><br>

  <label for="amount">Valor:</label>
  <input type="text" id="amount" name="amount" oninput="formatCurrency(this)" required><br>

  <label for="date">Data:</label>
  <input type="date" id="date" name="incomeDate" required><br>

  <label for="source">Fonte:</label>
  <input type="text" id="source" name="source" required><br>

  <button type="submit">Cadastrar Receita</button>
</form>

<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>
</body>
</html>
