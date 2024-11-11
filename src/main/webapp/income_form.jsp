<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
  <meta charset="UTF-8">
  <title>Cadastro de Receita</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .income-container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f8f9fa;
    }
    .income-card {
      width: 100%;
      max-width: 400px;
      padding: 20px;
      box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
      background-color: white;
    }
    .income-card h2 {
      margin-bottom: 20px;
      font-weight: bold;
      color: #343a40;
    }
  </style>
  <script>
    function formatCurrency(input) {
      let value = input.value.replace(/\D/g, "");
      value = (parseInt(value, 10) / 100).toFixed(2);
      input.value = value.replace(".", ".");
    }
  </script>
</head>
<body>
<div class="income-container">
  <div class="income-card">
    <h2 class="text-center">Cadastro de Receita</h2>
    <form action="income" method="POST">
      <div class="mb-3">
        <label for="description" class="form-label">Descrição</label>
        <input type="text" class="form-control" id="description" name="description" required>
      </div>

      <div class="mb-3">
        <label for="amount" class="form-label">Valor</label>
        <input type="text" class="form-control" id="amount" name="amount" oninput="formatCurrency(this)" required>
      </div>

      <div class="mb-3">
        <label for="date" class="form-label">Data</label>
        <input type="date" class="form-control" id="date" name="incomeDate" required>
      </div>

      <div class="mb-3">
        <label for="source" class="form-label">Fonte</label>
        <input type="text" class="form-control" id="source" name="source" required>
      </div>

      <button type="submit" class="btn btn-success w-100">Cadastrar Receita</button>
    </form>

    <c:if test="${not empty error}">
      <div class="alert alert-danger mt-3 text-center">${error}</div>
    </c:if>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
