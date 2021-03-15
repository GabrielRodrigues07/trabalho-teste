package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.impl.ProdutoDaoJDBC;
import model.entities.Produto;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Produto> list = new ArrayList<>();

		ProdutoDaoJDBC prod = (ProdutoDaoJDBC) ProdutoDaoJDBC.createProdutoDao();

		System.out.println("INFORME OS DADOS PARA INSERIR NO BANCO DE DADOS: ");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Valor: ");
		double valor = sc.nextDouble();

		Produto newSeller = new Produto(null, name, valor, new Date());
		prod.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println();

		System.out.print("INSIRA O ID QUE DESEJA ENCONTRAR: ");
		int id = sc.nextInt();
		Produto p = prod.findById(id);
		while (p == null) {
			System.out.println("ESSE ID NAO EXISTE, TENTE NOVAMENTE");
			id = sc.nextInt();
			p = prod.findById(id);
		}
		System.out.println(p);
		
		System.out.println();

		System.out.println("ENCONTRAR TODOS");
		list = prod.findAll();
		for (Produto obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		System.out.print("ESCOLHA UM ID PARA DELETAR: ");
		int idD = sc.nextInt();
		prod.deleteById(idD);
		System.out.println("Delete completed");
		
		System.out.println();
	
		System.out.print("ESCOLHA OUTRO ID PARA DELETAR: ");
		int idd2 = sc.nextInt();
		prod.deleteById(idd2);
		System.out.println("Delete completed");
		sc.close();
	}

}
