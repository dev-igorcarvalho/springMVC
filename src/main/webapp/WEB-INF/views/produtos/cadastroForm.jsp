<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- Import da taglib -->
<!-- Lib do JSTL-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--Lib do SpringForms-->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!--Lib do SpringTags--> 
<!--para o Spring preencher a URL-->
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Livros de Java, Android, iPhone, PHP, Ruby e muito mais - Casa do Código</title>
    </head>
    <body>
        <!-- action="${s:mvcUrl('PC#gravar').build()}" usar as iniciais maiusculas da classe seguido de # nome do metodo a ser usado-->
        <form:form action="${s:mvcUrl('PC#gravar').build()}" method="POST" commandName="produto">
            <div>
                <label>Título</label>
                <input type="text" name="titulo" />
                <form:errors path="titulo" />
            </div>
            <div>
                <label>Data de Lançamento</label>
                <input type="text" name="dataLancamento"/>
                <form:errors path="dataLancamento" />
            </div>
            <div>
                <label>Descrição</label>
                <textarea rows="10" cols="20" name="descricao"></textarea>
                <form:errors path="descricao" />
            </div>
            <div>
                <label>Páginas</label>
                <input type="number" name="paginas" />
                <form:errors path="paginas" />
            </div>
            <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
                <div>
                    <label>${tipoPreco.value}</label>
                    <input type="number" name="precos[${status.index}].preco" />
                    <input type="hidden" name="precos[${status.index}].tipoPrecoEnum" value="${tipoPreco}" />
                    <%--<form:errors path="precos[${status.index}].preco" />--%>
                </div>
            </c:forEach>
            <button type="submit">Cadastrar</button>
        </form:form>
    </body>
</html>