package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.StatusDoPedido;

public class Ordem {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date momentoDoPedido;
	private StatusDoPedido status;

	private Cliente cliente;
	private List<OrdemDoItem> list = new ArrayList<>();

	public Ordem(Date momentoDoPedido, StatusDoPedido status, Cliente cliente) {
		this.momentoDoPedido = momentoDoPedido;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomentoDoPedido() {
		return momentoDoPedido;
	}

	public void setMomentoDoPedido(Date momentoDoPedido) {
		this.momentoDoPedido = momentoDoPedido;
	}

	public StatusDoPedido getStatus() {
		return status;
	}

	public void setStatus(StatusDoPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<OrdemDoItem> getList() {
		return list;
	}

	public void addItem(OrdemDoItem lista) {
		list.add(lista);
	}

	public void removeItem(OrdemDoItem lista) {
		list.remove(lista);
	}

	public Double total() {
		double sum = 0.0;
		for(OrdemDoItem item : list) {
			sum += item.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ordem do pedido: ");
		sb.append(sdf.format(momentoDoPedido) + "\n");
		sb.append("Status do pedido: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Ordem do item:\n");
		for (OrdemDoItem lista : list) {
			sb.append(lista + "\n");
		}
		sb.append("Total do preço: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
}
