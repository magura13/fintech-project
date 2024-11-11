<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Controle Financeiro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card-title, .card-text {
            font-weight: bold;
            color: #333;
        }
        .table-responsive {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }
        .btn-action {
            width: 100%;
            max-width: 150px;
            margin-top: 10px;
        }
        .main-title {
            font-weight: bold;
            color: #495057;
            margin-bottom: 30px;
        }
    </style>
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="home">Fintech Project</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container mt-5">
    <h1 class="text-center main-title">Controle Financeiro</h1>

    <div class="row mb-5">
        <div class="col-md-4">
            <div class="card text-center bg-success text-white">
                <div class="card-body">
                    <h5 class="card-title">Total de Receitas</h5>
                    <p class="card-text">R$ ${totalIncome}</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center bg-danger text-white">
                <div class="card-body">
                    <h5 class="card-title">Total de Despesas</h5>
                    <p class="card-text">R$ ${totalExpense}</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card text-center bg-primary text-white">
                <div class="card-body">
                    <h5 class="card-title">Saldo Atual</h5>
                    <p class="card-text">R$ ${balance}</p>
                </div>
            </div>
        </div>
    </div>

    <div class="d-flex justify-content-center mb-5">
        <a href="income_form.jsp" class="btn btn-success me-3 btn-action">Cadastrar Receita</a>
        <a href="expense_form.jsp" class="btn btn-danger btn-action">Cadastrar Despesa</a>
    </div>

    <h2 class="mt-4">Receitas</h2>
    <div class="table-responsive mb-5">
        <table class="table table-striped table-hover align-middle">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Fonte</th>
                <th>Descrição</th>
                <th>Valor</th>
                <th>Data</th>
                <th>Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="income" items="${incomes}">
                <tr>
                    <td>${income.incomeId}</td>
                    <td>${income.source}</td>
                    <td>${income.description}</td>
                    <td>R$ ${income.amount}</td>
                    <td>${income.incomeDate}</td>
                    <td>
                        <a href="delete?type=income&id=${income.incomeId}" class="btn btn-sm btn-outline-danger">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <h2 class="mt-4">Despesas</h2>
    <div class="table-responsive">
        <table class="table table-striped table-hover align-middle">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Fonte</th>
                <th>Descrição</th>
                <th>Valor</th>
                <th>Data</th>
                <th>Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="expense" items="${expenses}">
                <tr>
                    <td>${expense.expenseId}</td>
                    <td>${expense.source}</td>
                    <td>${expense.description}</td>
                    <td>R$ ${expense.amount}</td>
                    <td>${expense.expenseDate}</td>
                    <td>
                        <a href="delete?type=expense&id=${expense.expenseId}" class="btn btn-sm btn-outline-danger">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
