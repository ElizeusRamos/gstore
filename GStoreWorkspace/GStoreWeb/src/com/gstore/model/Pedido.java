package com.gstore.model;

public class Pedido {
	private int codigo;
	private Cliente cliente;
	private Colaborador vendedor;
	private Produto produto;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Colaborador getVendedor() {
		return vendedor;
	}
	public void setVendedor(Colaborador vendedor) {
		this.vendedor = vendedor;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
