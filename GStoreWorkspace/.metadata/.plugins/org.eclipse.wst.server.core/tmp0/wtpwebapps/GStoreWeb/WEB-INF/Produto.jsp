<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Área dos Produtos</title>
		
		<link rel="stylesheet" type="text/css" href="styles/bootstrap.min.css" media="screen" />
		<script type="text/javascript" src="scripts/jquery.min.js"></script>
		<script type="text/javascript" src="scripts/popper.min.js"></script>
		<script type="text/javascript" src="scripts/bootstrap.min.js"></script>
		<script type="text/javascript" src="scripts/jquery.mask.min.js"></script>
	</head>
	<body>
		<div class="container">
			<div>
				<a href="index.html" title="home"><img src="assets/GStore.png" class="img mx-auto d-block" alt="gstore logotipo"></a>
			</div>
			
			<div>
				<h3>Produtos</h3>
				<p>Gerenciamento de produtos em estoque</p>
			</div>
			
			<div class="row mb-4 mx-auto">
				<button class="btn btn-success" data-toggle="modal" data-target="#adicionarModal">+ Adicionar</button>
			</div>
			
			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nome</th>
						<th scope="col">Preço R$</th>
						<th scope="col">Quantidade Unid.</th>
						<th scope="col">Total R$</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="it" items="${lista}" varStatus="contador">
						<tr>
							<td><c:out value="${it.codigo}"/></td>
							<td><c:out value="${it.nome}"/></td>
							<td><c:out value="${it.preco}"/></td>
							<td><c:out value="${it.qtde}"/></td>
							<td><c:out value="${it.qtde * it.preco}"/></td>
							<td>
								<button class="btn btn-secondary" 
									data-toggle="modal" data-target="#alterarModal"
									onclick="onUpdate('${it.codigo}', '${it.nome}', '${it.descricao}', '${it.preco}', '${it.qtde }')">
									Alterar
								</button>
								
								<button class="btn btn-info" 
									data-toggle="modal" data-target="#excluirModal"
									onclick="onReadDelete('${it.codigo}', '${it.nome}', '${it.descricao}', '${it.preco}', '${it.qtde }')">
									Consultar
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		
		<!-- Modal Adicionar -->
		<div class="modal fade" id="adicionarModal" >
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">Adicionar Produto</h5>
		        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form action="/GStoreWeb/ProdutoController">
		        	<div class="form-group">
		        		<label for="nome">Nome</label>
		        		<input class="form-control" type="text" id="nome" name="nome" aria-descriptedby="nomeHelp" required/>
		        		<small id="nomeHelp" class="form-text text-muted">Nome do produto a ser adicionado</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="descricao">Descrição</label>
		        		<textarea 
			        		class="form-control" id="descricao" name="descricao" 
			        		aria-descriptedby="descricaoHelp" maxlength="255" style="resize: none;" rows="5"></textarea>
		        		<small id="descricaoHelp" class="form-text text-muted">Breve descrição até 255 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="preco">Preço R$</label>
		        		<input class="form-control" type="text" id="preco" name="preco" aria-descriptedby="precoHelp" required/>
		        		<small id="precoHelp" class="form-text text-muted">Preço do produto em reais</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="qtde">Quantidade Unid.</label>
		        		<input class="form-control" type="number" id="qtde" name="qtde" aria-descriptedby="qtdeHelp" min="0" required/>
		        		<small id="qtdeHelp" class="form-text text-muted">Quantidade de unidades do produtos em estoque</small>
		        	</div>
		        	
		        	<button type="submit" class="btn btn-success">
		        		Adicionar
		        	</button>
		        	
		        	<input type="hidden" name="action" value="create"/>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- Modal Alterar -->
		<div class="modal fade" id="alterarModal" >
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">Alterar Produto</h5>
		        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form action="/GStoreWeb/ProdutoController">
		        	<div class="form-group">
		        		<label for="id">ID</label>
		        		<input class="form-control" type="text" id="id" name="id" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="nome">Nome</label>
		        		<input class="form-control" type="text" id="nome" name="nome" aria-descriptedby="nomeHelp" required/>
		        		<small id="nomeHelp" class="form-text text-muted">Nome do produto a ser adicionado</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="descricao">Descrição</label>
		        		<input class="form-control" type="text" id="descricao" name="descricao" aria-descriptedby="descricaoHelp"/>
		        		<small id="descricaoHelp" class="form-text text-muted">Breve descrição até 255 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="preco">Preço R$</label>
		        		<input class="form-control" type="text" id="preco" name="preco" aria-descriptedby="precoHelp" required/>
		        		<small id="precoHelp" class="form-text text-muted">Preço do produto em reais</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="qtde">Quantidade Unid.</label>
		        		<input class="form-control" type="number" id="qtde" name="qtde" aria-descriptedby="qtdeHelp" min="0" required/>
		        		<small id="qtdeHelp" class="form-text text-muted">Quantidade de unidades do produtos em estoque</small>
		        	</div>
		        	
		        	<button type="submit" class="btn btn-warning">
		        		Alterar
		        	</button>
		        	
		        	<input type="hidden" name="action" value="update"/>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- Modal Consultar ou Excluir -->
		<div class="modal fade" id="excluirModal" >
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">Produto</h5>
		        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form action="/GStoreWeb/ProdutoController">
		        	<div class="form-group">
		        		<label for="id">ID</label>
		        		<input class="form-control" type="text" id="id" name="id" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="nome">Nome</label>
		        		<input class="form-control" type="text" id="nome" name="nome" aria-descriptedby="nomeHelp" readonly/>
		        		<small id="nomeHelp" class="form-text text-muted">Nome do produto a ser adicionado</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="descricao">Descrição</label>
		        		<input class="form-control" type="text" id="descricao" name="descricao" aria-descriptedby="descricaoHelp" readonly/>
		        		<small id="descricaoHelp" class="form-text text-muted">Breve descrição até 255 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="preco">Preço R$</label>
		        		<input class="form-control" type="text" id="preco" name="preco" aria-descriptedby="precoHelp" readonly/>
		        		<small id="precoHelp" class="form-text text-muted">Preço do produto em reais</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="qtde">Quantidade Unid.</label>
		        		<input class="form-control" type="number" id="qtde" name="qtde" aria-descriptedby="qtdeHelp" min="0" readonly/>
		        	</div>
		        	
		        	<button type="submit" class="btn btn-danger">
		        		Excluir
		        	</button>
		        	
		        	<input type="hidden" name="action" value="delete"/>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
		
		
		<script type="text/javascript">


			function onReadDelete(idP, nomeP, descricaoP, precoP, qtdeP) {
				var id = document.querySelector("#excluirModal input[name=id]");
				var nome = document.querySelector("#excluirModal input[name=nome]");
				var preco = document.querySelector("#excluirModal input[name=preco]");
				var descricao = document.querySelector("#excluirModal input[name=descricao]");
				var qtde = document.querySelector("#excluirModal input[name=qtde]");
	
				id.value = idP;
				nome.value = nomeP;
				descricao.value = descricaoP;
				preco.value = precoP;
				qtde.value = qtdeP;
			}
		
			function onUpdate(idP, nomeP, descricaoP, precoP, qtdeP) {
				var id = document.querySelector("#alterarModal input[name=id]");
				var nome = document.querySelector("#alterarModal input[name=nome]");
				var preco = document.querySelector("#alterarModal input[name=preco]");
				var descricao = document.querySelector("#alterarModal input[name=descricao]");
				var qtde = document.querySelector("#alterarModal input[name=qtde]");
	
				id.value = idP;
				nome.value = nomeP;
				descricao.value = descricaoP;
				preco.value = precoP;
				qtde.value = qtdeP;
			}


		</script>
		
	</body>
</html>