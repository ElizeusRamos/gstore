<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Área de Pedidos</title>
		
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
				<h3>Pedidos</h3>
				<p>Gerenciamento de pedidos realizados</p>
			</div>
			
			<div class="row mb-4 mx-auto">
				<button class="btn btn-success" data-toggle="modal" data-target="#adicionarModal">+ Adicionar</button>
			</div>
			
			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Total do Pedido R$</th>
						<th scope="col">Atendente</th>
						<th scope="col">Cliente</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="it" items="${lista}" varStatus="contador">
						<tr>
							<td><c:out value="${it.codigo}"/></td>
							<td><c:out value="${it.totalPedido}"/></td>
							<td><c:out value="${it.vendedor}"/></td>
							<td><c:out value="${it.cliente}"/></td>
							<td>
								<button class="btn btn-info" 
									data-toggle="modal" data-target="#excluirModal"
									onclick="onReadDelete('${it.codigo}', '${it.vendedor}', '${it.cliente}', '${it.totalPedido}')">
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
		        <h5 class="modal-title">Adicionar Pedido</h5>
		        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form action="/GStoreWeb/PedidoController">
		        	<div class="form-group">
		        		<label for="vendedor">Vendedor</label>
		        		<input class="form-control" type="text" id="vendedor" name="vendedor" aria-descriptedby="vendedorHelp" required/>
		        		<small id="vendedorHelp" class="form-text text-muted">Nome do vendedor</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="nome">Cliente</label>
		        		<input class="form-control" type="text" id="cliente" name="cliente" aria-descriptedby="clienteHelp" required/>
		        		<small id="clienteHelp" class="form-text text-muted">Nome do cliente</small>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="nome">Valor total R$</label>
		        		<input class="form-control" type="text" id="total" name="total" aria-descriptedby="totalHelp" required/>
		        		<small id="totalHelp" class="form-text text-muted">Valor total do pedido</small>
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
		
		<!-- Modal Consultar ou Excluir -->
		<div class="modal fade" id="excluirModal" >
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">Pedido</h5>
		        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <form action="/GStoreWeb/PedidoController">
		        	<div class="form-group">
		        		<label for="id">ID</label>
		        		<input class="form-control" type="text" id="id" name="id" readonly/>
		        	</div> 
		        	
		        	<div class="form-group">
		        		<label for="vendedor">Vendedor</label>
		        		<input class="form-control" type="text" id="vendedor" name="vendedor" aria-descriptedby="vendedorHelp" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="nome">Cliente</label>
		        		<input class="form-control" type="text" id="cliente" name="cliente" aria-descriptedby="clienteHelp" readonly/>
		        	</div>
		        	
		        	<div class="form-group">
		        		<label for="nome">Valor total R$</label>
		        		<input class="form-control" type="text" id="total" name="total" aria-descriptedby="totalHelp" readonly/>
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


			function onReadDelete(idP, vendedorP, clienteP, totalP) {
				var id = document.querySelector("#excluirModal input[name=id]");
				var vendedor = document.querySelector("#excluirModal input[name=vendedor]");
				var cliente = document.querySelector("#excluirModal input[name=cliente]");
				var total = document.querySelector("#excluirModal input[name=total]");
	
				id.value = idP;
				vendedor.value = vendedorP;
				cliente.value = clienteP;
				total.value = totalP;
			}
		
			function onUpdate(idP, nomeP, descricaoP, statusP) {
				var id = document.querySelector("#alterarModal input[name=id]");
				var vendedor = document.querySelector("#alterarModal input[name=vendedor]");
				var cliente = document.querySelector("#alterarModal input[name=cliente]");
				var total = document.querySelector("#alterarModal input[name=total]");
	
				id.value = idP;
				vendedor.value = vendedorP;
				cliente.value = clienteP;
				total.value = totalP;
			}


		</script>
	</body>
</html>