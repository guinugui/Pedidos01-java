package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Ordem;
import entities.OrdemDoItem;
import entities.Produto;
import entities.enums.StatusDoPedido;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Cadastre o Cliente:");
		System.out.println("Nome: ");
		String nome = sc.nextLine();
		System.out.println("Email: ");
		String email = sc.nextLine();
		System.out.println("Data de Nascimento: ");
		Date dataDeNascimento = sdf.parse(sc.next());

		Cliente cliente = new Cliente(nome, email, dataDeNascimento);

		System.out.println("Ordem do pedido: ");
		System.out.println("Status: ");
		StatusDoPedido status = StatusDoPedido.valueOf(sc.next());

		Ordem ordem = new Ordem(new Date(), status, cliente);

		System.out.println("Quantos produtos dejesa colocar na list: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Coloca o #" + i + 1 + " item :");
			System.out.println("Nome do item: ");
			sc.nextLine();
			String nomeDoProduto = sc.nextLine();
			System.out.println("Preço do item: ");
			double preco = sc.nextDouble();
			System.out.println("Quantas unidade deste item deseja colocar: ");
			int quantidade = sc.nextInt();

			Produto produto = new Produto(nomeDoProduto, preco);
			OrdemDoItem ordemDoItem = new OrdemDoItem(quantidade, preco, produto);

			ordem.addItem(ordemDoItem);
		}
		System.out.println();
		System.out.println("Lista da Ordem:");
		System.out.println(ordem);
		

		sc.close();

	}

}
