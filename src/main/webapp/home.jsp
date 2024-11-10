<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Controle Financeiro</h1>

    <!-- Add options -->
    <div class="d-flex justify-content-center mb-4">
        <a href="income_form.jsp" class="btn btn-success me-2">Cadastrar Receita</a>
        <a href="expense_form.jsp" class="btn btn-danger">Cadastrar Despesa</a>
    </div>

    <!-- Incomes tables -->
    <h2 class="mt-4">Receitas</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Fonte</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th>Data</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="income" items="${incomes}">
            <tr>
                <td>${income.incomeId}</td>
                <td>${income.source}</td>
                <td>${income.description}</td>
                <td>${income.amount}</td>
                <td>${income.incomeDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <!-- expense tables -->
    <h2 class="mt-4">Despesas</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Fonte</th>
            <th>Descrição</th>
            <th>Valor</th>
            <th>Data</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="expense" items="${expenses}">
            <tr>
                <td>${expense.expenseId}</td>
                <td>${expense.source}</td>
                <td>${expense.description}</td>
                <td>${expense.amount}</td>
                <td>${expense.expenseDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
