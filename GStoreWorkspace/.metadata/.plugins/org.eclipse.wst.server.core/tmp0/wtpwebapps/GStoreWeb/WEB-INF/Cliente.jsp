<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Área do Cliente</title>
		
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
				<h3>Clientes</h3>
				<p>Gerenciamento de clientes cadastrados e adição de novos</p>
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
									onclick="onUpdate('${it.codigo}', '${it.nome}', '${it.cpf }', '${it.email }', '${it.email }', '${it.cep }', '${it.endereco }', '${it.bairro }', '${it.cidade }', ${it.ativo })"
									>
									Alterar
								</button>
								
								<button class="btn btn-info" 
									data-toggle="modal" data-target="#excluirModal"
									onclick="onReadDelete('${it.codigo}', '${it.nome}', '${it.cpf }', '${it.email }', '${it.email }', '${it.cep }', '${it.endereco }', '${it.bairro }', '${it.cidade }', ${it.ativo })"
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
		        <h5 class="modal-title">Adicionar Cliente</h5>
		        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form action="/GStoreWeb/ClienteController">
		        	<div class="form-group">
		        		<label for="nome">Nome</label>
		        		<input class="form-control" type="text" id="nome" name="nome" aria-descriptedby="nomeHelp" required/>
		        		<small id="nomeHelp" class="form-text text-muted">Nome do cliente a ser cadastrado</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="cpf">CPF</label>
		        		<input class="form-control" type="text" id="cpf" name="cpf" aria-descriptedby="cpfHelp" maxlength="11" required/>
		        		<small id="cpfHelp" class="form-text text-muted">CPF obrigatório, 11 caracteres sem pontos</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="email">Email</label>
		        		<input class="form-control" type="email" id="email" name="email" aria-descriptedby="emailHelp" maxlength="255" required/>
		        		<small id="emailHelp" class="form-text text-muted">Email, máx 255 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="telefone">Telefone</label>
		        		<input class="form-control" type="text" id="telefone" name="telefone" aria-descriptedby="telefoneHelp" maxlength="15"/>
		        		<small id="telefoneHelp" class="form-text text-muted">Telefone, máx 15 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="cep">CEP</label>
		        		<input class="form-control" type="text" id="cep" name="cep" aria-descriptedby="cepHelp" maxlength="8"/>
		        		<small id="cepHelp" class="form-text text-muted">CEP, apenas números</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="endereco">Endereço</label>
		        		<input class="form-control" type="text" id="endereco" name="endereco" aria-descriptedby="enderecoHelp" maxlength="255"/>
		        		<small id="enderecoHelp" class="form-text text-muted">Endereço, máx. 255 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="bairro">Bairro</label>
		        		<input class="form-control" type="text" id="bairro" name="bairro" maxlength="255"/>
		        	</div>
		        	<div class="form-group">
		        		<label for="cidade">Cidade</label>
		        		<input class="form-control" type="text" id="cidade" name="cidade" maxlength="255"/>
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
		        <h5 class="modal-title">Alterar Dados Cliente</h5>
		        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form action="/GStoreWeb/ClienteController">
		        	<div class="form-group">
		        		<label for="id">ID</label>
		        		<input class="form-control" type="text" id="id" name="id" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="nome">Nome</label>
		        		<input class="form-control" type="text" id="nome" name="nome" aria-descriptedby="nomeHelp" required/>
		        		<small id="nomeHelp" class="form-text text-muted">Nome do cliente a ser cadastrado</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="cpf">CPF</label>
		        		<input class="form-control" type="text" id="cpf" name="cpf" aria-descriptedby="cpfHelp" maxlength="11" required/>
		        		<small id="cpfHelp" class="form-text text-muted">CPF obrigatório, 11 caracteres sem pontos</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="email">Email</label>
		        		<input class="form-control" type="email" id="email" name="email" aria-descriptedby="emailHelp" maxlength="255" required/>
		        		<small id="emailHelp" class="form-text text-muted">Email, máx 255 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="telefone">Telefone</label>
		        		<input class="form-control" type="text" id="telefone" name="telefone" aria-descriptedby="telefoneHelp" maxlength="15"/>
		        		<small id="telefoneHelp" class="form-text text-muted">Telefone, máx 15 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="cep">CEP</label>
		        		<input class="form-control" type="text" id="cep" name="cep" aria-descriptedby="cepHelp" maxlength="8"/>
		        		<small id="cepHelp" class="form-text text-muted">CEP, apenas números</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="endereco">Endereço</label>
		        		<input class="form-control" type="text" id="endereco" name="endereco" aria-descriptedby="enderecoHelp" maxlength="255"/>
		        		<small id="enderecoHelp" class="form-text text-muted">Endereço, máx. 255 caracteres</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="bairro">Bairro</label>
		        		<input class="form-control" type="text" id="bairro" name="bairro" maxlength="255"/>
		        	</div>
		        	<div class="form-group">
		        		<label for="cidade">Cidade</label>
		        		<input class="form-control" type="text" id="cidade" name="cidade" maxlength="255"/>
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
		        <h5 class="modal-title">Cliente</h5>
		        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form action="/GStoreWeb/ClienteController">
		        	<div class="form-group">
		        		<label for="id">ID</label>
		        		<input class="form-control" type="text" id="id" name="id" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="nome">Nome</label>
		        		<input class="form-control" type="text" id="nome" name="nome" aria-descriptedby="nomeHelp" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="cpf">CPF</label>
		        		<input class="form-control" type="text" id="cpf" name="cpf" aria-descriptedby="cpfHelp" maxlength="11" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="email">Email</label>
		        		<input class="form-control" type="email" id="email" name="email" aria-descriptedby="emailHelp" maxlength="255" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="telefone">Telefone</label>
		        		<input class="form-control" type="text" id="telefone" name="telefone" aria-descriptedby="telefoneHelp" maxlength="15" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="cep">CEP</label>
		        		<input class="form-control" type="text" id="cep" name="cep" aria-descriptedby="cepHelp" maxlength="8" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="endereco">Endereço</label>
		        		<input class="form-control" type="text" id="endereco" name="endereco" aria-descriptedby="enderecoHelp" maxlength="255" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="bairro">Bairro</label>
		        		<input class="form-control" type="text" id="bairro" name="bairro" maxlength="255" readonly/>
		        	</div>
		        	<div class="form-group">
		        		<label for="cidade">Cidade</label>
		        		<input class="form-control" type="text" id="cidade" name="cidade" maxlength="255" readonly/>
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
		
			function onUpdate(idC, nomeC, cpfC, emailC, telefoneC, cepC, enderecoC, bairroC, cidadeC, ativoC) {
				var id = document.querySelector("#alterarModal input[name=id]");
				var nome = document.querySelector("#alterarModal input[name=nome]");
				var cpf = document.querySelector("#alterarModal input[name=cpf]");
				var email = document.querySelector("#alterarModal input[name=email]");
				var telefone = document.querySelector("#alterarModal input[name=telefone]");
				var cep = document.querySelector("#alterarModal input[name=cep]");
				var endereco = document.querySelector("#alterarModal input[name=endereco]");
				var bairro = document.querySelector("#alterarModal input[name=bairro]");
				var cidade = document.querySelector("#alterarModal input[name=cidade]");
				var ativo = document.querySelector("#alterarModal input[name=ativo]");

				id.value = idC;
				nome.value = nomeC;
				cpf.value = cpfC;
				email.value = emailC;
				telefone.value = telefoneC;
				cep.value = cepC;
				endereco.value = enderecoC;
				bairro.value = bairroC;
				cidade.value = cidadeC;
				ativo.value = ativoC;
			}

			function onReadDelete(idC, nomeC, cpfC, emailC, telefoneC, cepC, enderecoC, bairroC, cidadeC, ativoC) {
				var id = document.querySelector("#excluirModal input[name=id]");
				var nome = document.querySelector("#excluirModal input[name=nome]");
				var cpf = document.querySelector("#excluirModal input[name=cpf]");
				var email = document.querySelector("#excluirModal input[name=email]");
				var telefone = document.querySelector("#excluirModal input[name=telefone]");
				var cep = document.querySelector("#excluirModal input[name=cep]");
				var endereco = document.querySelector("#excluirModal input[name=endereco]");
				var bairro = document.querySelector("#excluirModal input[name=bairro]");
				var cidade = document.querySelector("#excluirModal input[name=cidade]");
				var ativo = document.querySelector("#excluirModal input[name=ativo]");

				id.value = idC;
				nome.value = nomeC;
				cpf.value = cpfC;
				email.value = emailC;
				telefone.value = telefoneC;
				cep.value = cepC;
				endereco.value = enderecoC;
				bairro.value = bairroC;
				cidade.value = cidadeC;
				ativo.value = ativoC;
			}

		</script>
	</body>
</html>