<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Cadastro de Usuário</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .register-container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f8f9fa;
    }
    .register-card {
      width: 100%;
      max-width: 400px;
      padding: 20px;
      box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
      background-color: white;
    }
    .register-card h2 {
      margin-bottom: 20px;
      font-weight: bold;
      color: #343a40;
    }
    .register-btn {
      width: 100%;
    }
  </style>
</head>
<body>
<div class="register-container">
  <div class="register-card">
    <h2 class="text-center">Cadastro</h2>
    <form method="post" action="register">
      <div class="mb-3">
        <label for="name" class="form-label">Nome</label>
        <input type="text" class="form-control" id="name" name="name" required>
      </div>
      <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" class="form-control" id="email" name="email" required>
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">Senha</label>
        <input type="password" class="form-control" id="password" name="password" required>
      </div>
      <button type="submit" class="btn btn-primary register-btn">Cadastrar</button>
    </form>

    <c:if test="${not empty error}">
      <div class="alert alert-danger mt-3" style="display: inline-block; padding: 0.5rem; border-radius: 0.25rem;">
          ${error}
      </div>
    </c:if>

    <p class="mt-3 text-center">
      Já tem uma conta? <a href="login.jsp">Faça login aqui</a>.
    </p>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
