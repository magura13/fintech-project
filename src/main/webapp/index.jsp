<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bem-vindo ao Fintech Project</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .welcome-container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f8f9fa;
        }
        .welcome-card {
            text-align: center;
            padding: 30px;
            max-width: 500px;
            width: 100%;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            background-color: white;
        }
        .welcome-btn {
            width: 120px;
        }
    </style>
</head>
<body>
<div class="welcome-container">
    <div class="welcome-card">
        <h1 class="mb-3">Bem-vindo ao Fintech Project</h1>
        <p class="text-muted mb-4">Gerencie suas finanças de forma fácil e segura.</p>
        <div class="d-flex justify-content-center gap-3">
            <a href="login.jsp" class="btn btn-primary welcome-btn">Login</a>
            <a href="register.jsp" class="btn btn-secondary welcome-btn">Cadastrar</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
