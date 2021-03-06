<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Área do Colaborador</title>
		
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
				<h3>Colaboradores</h3>
				<p>Gerenciamento de colaboradores cadastrados e adição de novos</p>
			</div>
			
			<div class="row mb-4 mx-auto">
				<button class="btn btn-success" data-toggle="modal" data-target="#adicionarModal">+ Adicionar</button>
			</div>
			
			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Nome</th>
						<th scope="col">Email</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="it" items="${lista}" varStatus="contador">
						<tr>
							<td><c:out value="${it.codigo}"/></td>
							<td><c:out value="${it.nome}"/></td>
							<td><c:out value="${it.email}"/></td>
							<td>
								<button class="btn btn-secondary" 
									data-toggle="modal" data-target="#alterarModal"
									onclick="onUpdate('${it.codigo}', '${it.nome}', '${it.email }', '${it.cargo }', '${it.descricao }', ${it.ativo })"
									>
									Alterar
								</button>
								
								<button class="btn btn-info" 
									data-toggle="modal" data-target="#excluirModal"
									onclick="onReadDelete('${it.codigo}', '${it.nome}', '${it.email }', '${it.cargo }', '${it.descricao }', ${it.ativo })"
									>
									Consultar
								</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		<!-- Modal Adicionar -->
		<div class="modal fade" id="adicionarModal" >
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">Adicionar Colaborador</h5>
		        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form action="/GStoreWeb/ColaboradorController">
		        	<div class="form-group">
		        		<label for="nome">Nome</label>
		        		<input class="form-control" type="text" id="nome" name="nome" aria-descriptedby="nomeHelp" required/>
		        		<small id="nomeHelp" class="form-text text-muted">Nome do colaborador a ser cadastrado</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="email">Email</label>
		        		<input class="form-control" type="email" id="email" name="email" aria-descriptedby="emailHelp" maxlength="255" required/>
		        		<small id="emailHelp" class="form-text text-muted">Email, máx 255 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="descricao">Descricao</label>
		        		<input class="form-control" type="text" id="descricao" name="descricao" aria-descriptedby="descricaoHelp" maxlength="255"/>
		        		<small id="descricaoHelp" class="form-text text-muted">Breve Descrição, máx 255 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="cargo">Cargo</label>
		        		<input class="form-control" type="text" id="cargo" name="cargo" aria-descriptedby="cargoHelp" maxlength="255"/>
		        		<small id="cargoHelp" class="form-text text-muted">Cargo do colaborador</small>
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
		        <h5 class="modal-title">Alterar Dados Colaborador</h5>
		        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form action="/GStoreWeb/ColaboradorController">
		        	<div class="form-group">
		        		<label for="id">ID</label>
		        		<input class="form-control" type="text" id="id" name="id" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="nome">Nome</label>
		        		<input class="form-control" type="text" id="nome" name="nome" aria-descriptedby="nomeHelp" required/>
		        		<small id="nomeHelp" class="form-text text-muted">Nome do colaborador a ser cadastrado</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="email">Email</label>
		        		<input class="form-control" type="email" id="email" name="email" aria-descriptedby="emailHelp" maxlength="255" required/>
		        		<small id="emailHelp" class="form-text text-muted">Email, máx 255 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="descricao">Descricao</label>
		        		<input class="form-control" type="text" id="descricao" name="descricao" aria-descriptedby="descricaoHelp" maxlength="255"/>
		        		<small id="descricaoHelp" class="form-text text-muted">Breve Descrição, máx 255 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="cargo">Cargo</label>
		        		<input class="form-control" type="text" id="cargo" name="cargo" aria-descriptedby="cargoHelp" maxlength="255"/>
		        		<small id="cargoHelp" class="form-text text-muted">Cargo do colaborador</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="ativo">Colaborador Ativo</label>
		        		<select class="form-control"  id="ativo" name="ativo" aria-descriptedby="statusHelp" required>
			        		<option value="none" selected disabled hidden="hidden">
					          Selecione uma opção
					        </option>
		        			<option value="true">ATIVO</option>
		        			<option value="false">INATIVO</option>
		        		</select>
		        		<small id="statusHelp" class="form-text text-muted">Status ativo/inativo</small>
		        	</div>
		        	
		        	<button type="submit" class="btn btn-warning">
		        		Alterar
		        	</button>
		        	
		        	<input type="hidden" name="ativo" />
		        	
		        	<input type="hidden" name="action" value="update"/>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
		</div>
		
		<!-- Modal Consultar ou Excluir -->
		<div class="modal fade" id="excluirModal" >
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">Colaborador</h5>
		        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form action="/GStoreWeb/ColaboradorController">
		        	<div class="form-group">
		        		<label for="id">ID</label>
		        		<input class="form-control" type="text" id="id" name="id" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="nome">Nome</label>
		        		<input class="form-control" type="text" id="nome" name="nome" aria-descriptedby="nomeHelp" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="email">Email</label>
		        		<input class="form-control" type="email" id="email" name="email" aria-descriptedby="emailHelp" maxlength="255" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="descricao">Descricao</label>
		        		<input class="form-control" type="text" id="descricao" name="descricao" aria-descriptedby="descricaoHelp" maxlength="255" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="cargo">Cargo</label>
		        		<input class="form-control" type="text" id="cargo" name="cargo" aria-descriptedby="cargoHelp" maxlength="255" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="ativo">Colaborador Ativo</label>
		        		<input class="form-control" type="text" id="ativo" name="ativo" readonly/>
		        	</div>
		        	
		        	<button type="submit" class="btn btn-warning">
		        		Excluir
		        	</button>
		        	
		        	<input type="hidden" name="ativo" />
		        	
		        	<input type="hidden" name="action" value="delete"/>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
		
		
		<script type="text/javascript">
		
			function onUpdate(idC, nomeC, emailC, cargoC, descricaoC, ativoC) {
				var id = document.querySelector("#alterarModal input[name=id]");
				var email = document.querySelector("#excluirModal input[name=email]");
				var nome = document.querySelector("#alterarModal input[name=nome]");
				var cargo = document.querySelector("#alterarModal input[name=cargo]");
				var descricao = document.querySelector("#alterarModal input[name=descricao]");
				var ativo = document.querySelector("#alterarModal input[name=ativo]");

				id.value = idC;
				nome.value = nomeC;
				cargo.value = cargoC;
				email.value = emailC;
				descricao.value = descricaoC;
				ativo.value = ativoC;
			}

			function onReadDelete(idC, nomeC, emailC, cargoC, descricaoC, ativoC) {
				var id = document.querySelector("#excluirModal input[name=id]");
				var nome = document.querySelector("#excluirModal input[name=nome]");
				var cargo = document.querySelector("#excluirModal input[name=cargo]");
				var email = document.querySelector("#excluirModal input[name=email]");
				var descricao = document.querySelector("#excluirModal input[name=descricao]");
				var ativo = document.querySelector("#excluirModal input[name=ativo]");

				id.value = idC;
				nome.value = nomeC;
				cargo.value = cargoC;
				email.value = emailC;
				descricao.value = descricaoC;
				ativo.value = ativoC;
			}

		</script>
	</body>
</html>