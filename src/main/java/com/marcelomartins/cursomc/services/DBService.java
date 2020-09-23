package com.marcelomartins.cursomc.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelomartins.cursomc.domain.Categoria;
import com.marcelomartins.cursomc.domain.Cidade;
import com.marcelomartins.cursomc.domain.Cliente;
import com.marcelomartins.cursomc.domain.Endereco;
import com.marcelomartins.cursomc.domain.Estado;
import com.marcelomartins.cursomc.domain.ItemPedido;
import com.marcelomartins.cursomc.domain.Pagamento;
import com.marcelomartins.cursomc.domain.PagamentoComBoleto;
import com.marcelomartins.cursomc.domain.PagamentoComCartao;
import com.marcelomartins.cursomc.domain.Pedido;
import com.marcelomartins.cursomc.domain.Produto;
import com.marcelomartins.cursomc.domain.enums.EstadoPagamento;
import com.marcelomartins.cursomc.domain.enums.TipoCliente;
import com.marcelomartins.cursomc.repositories.CategoriaRepository;
import com.marcelomartins.cursomc.repositories.CidadeRepository;
import com.marcelomartins.cursomc.repositories.ClienteRepository;
import com.marcelomartins.cursomc.repositories.EnderecoRepository;
import com.marcelomartins.cursomc.repositories.EstadoRepository;
import com.marcelomartins.cursomc.repositories.ItemPedidoRepository;
import com.marcelomartins.cursomc.repositories.PagamentoRepository;
import com.marcelomartins.cursomc.repositories.PedidoRepository;
import com.marcelomartins.cursomc.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categRepo;
	@Autowired
	private ProdutoRepository prodRepo;
	@Autowired
	private EstadoRepository estRepo;
	@Autowired
	private CidadeRepository cidRepo;
	@Autowired
	private ClienteRepository cliRepo;
	@Autowired
	private EnderecoRepository endRepo;
	@Autowired
	private PedidoRepository pedRepo;
	@Autowired
	private PagamentoRepository pagtoRepo;
	@Autowired
	private ItemPedidoRepository ipRepo;

	public void instantiateTestDatabase() throws ParseException {
		Categoria cat1, cat2, cat3, cat4, cat5, cat6, cat7;
		cat1 = new Categoria(null, "Informática");
		cat2 = new Categoria(null, "Escritório");
		cat3 = new Categoria(null, "Cama mesa e banho");
		cat4 = new Categoria(null, "Eletrônicos");
		cat5 = new Categoria(null, "Jardinagem");
		cat6 = new Categoria(null, "Decoração");
		cat7 = new Categoria(null, "Perfumaria");

		Produto p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
		p1 = new Produto(null, "Computador", 2000.0);
		p2 = new Produto(null, "Impressora", 800.0);
		p3 = new Produto(null, "Mouse", 80.0);
		p4 = new Produto(null, "Mesa de escritório", 300.0);
		p5 = new Produto(null, "Toalha", 50.0);
		p6 = new Produto(null, "Colcha", 200.0);
		p7 = new Produto(null, "TV", 1200.0);
		p8 = new Produto(null, "Roçadeira", 800.0);
		p9 = new Produto(null, "Abajur", 100.0);
		p10 = new Produto(null, "Pendente", 180.0);
		p11 = new Produto(null, "Shampoo", 90.0);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));

		categRepo.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		prodRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Estado est0, est1;
		est0 = new Estado(null, "Minas Gerais");
		est1 = new Estado(null, "Sao Paulo");

		Cidade c0, c1, c2;
		c0 = new Cidade(null, "Uberlandia", est0);
		c1 = new Cidade(null, "Sao Paulo", est1);
		c2 = new Cidade(null, "Campinas", est1);

		est0.getCidades().addAll(Arrays.asList(c0));
		est1.getCidades().addAll(Arrays.asList(c1, c2));

		Cliente cli0;
		cli0 = new Cliente(null, "Maria Silva", "maria@gmail.com", "03634660295", TipoCliente.PESSOAFISICA);
		cli0.getTelefones().addAll(Arrays.asList("2345678", "1345688"));

		Endereco e0, e1;
		e0 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli0, c0);
		e1 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli0, c1);

		cli0.getEnderecos().addAll(Arrays.asList(e0, e1));

		estRepo.saveAll(Arrays.asList(est0, est1));
		cidRepo.saveAll(Arrays.asList(c0, c1, c2));
		cliRepo.saveAll(Arrays.asList(cli0));
		endRepo.saveAll(Arrays.asList(e0, e1));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped0, ped1;
		ped0 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli0, e0);
		ped1 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli0, e1);

		Pagamento pagto0, pagto1;
		pagto0 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped0, 6);
		ped0.setPagamento(pagto0);
		pagto1 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped1, sdf.parse("20/10/2017 00:00"), null);
		ped1.setPagamento(pagto1);
		cli0.getPedidos().addAll(Arrays.asList(ped0, ped1));

		pedRepo.saveAll(Arrays.asList(ped0, ped1));
		pagtoRepo.saveAll(Arrays.asList(pagto0, pagto1));

		ItemPedido ip0, ip1, ip2;
		ip0 = new ItemPedido(ped0, p1, 0.00, 1, 2000.00);
		ip1 = new ItemPedido(ped0, p3, 0.00, 2, 80.00);
		ip2 = new ItemPedido(ped1, p2, 100.00, 1, 800.00);

		ped0.getItens().addAll(Arrays.asList(ip0, ip1));
		ped1.getItens().addAll(Arrays.asList(ip2));

		p1.getItens().addAll(Arrays.asList(ip0));
		p2.getItens().addAll(Arrays.asList(ip2));
		p3.getItens().addAll(Arrays.asList(ip1));

		ipRepo.saveAll(Arrays.asList(ip0, ip1, ip2));
	}
}
