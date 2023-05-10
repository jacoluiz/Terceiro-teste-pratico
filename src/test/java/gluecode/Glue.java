package gluecode;

import org.junit.Assert;

import io.cucumber.java.pt.*;
import pages.CarrinhoPage;
import pages.CheckoutPage;
import pages.DetalhePage;
import pages.HomePage;

public class Glue {
	HomePage homePage = new HomePage();
	DetalhePage detalhePage = new DetalhePage();
	CarrinhoPage carrinhoPage = new CarrinhoPage();
	CheckoutPage checkoutPage = new CheckoutPage();

	@Dado("^acesso ao site Advantage Shoping$")
	public void acesso_ao_site_Advantage_Shoping() throws Throwable {
		homePage.validarPaginaInicial();
	}

	@Quando("^clicar na opção Special Offer$")
	public void clicar_na_opção_Special_Offer() throws Throwable {
		homePage.clicarBotaoSpecialOffer();
	}

	@Quando("^clicar no botão See offer$")
	public void clicar_no_botão_See_offer() throws Throwable {
		homePage.clicarBotaoSeeOffer();
		detalhePage.aguardarPaginaCarregar();
	}

	@Então("^validar nas especificações o \"([^\"]*)\"$")
	public void validar_nas_especificacoes(String campo) throws Throwable {
		if (!campo.isEmpty() && !campo.isBlank()) {
			detalhePage.validarDetalhesProduto(campo);
		} else {
			System.err.println("Parrametro campo enviado em branco ou vazio");
			Assert.fail();
		}
	}

	@Quando("alterar a cor do produto para a mesma da massa de teste")
	public void alterar_a_cor_do_produto_para_a_mesma_da_massa_de_teste() {
		detalhePage.alterarCor();
	}

	@Quando("clicar no botão Add to cart")
	public void clicar_no_botão_add_to_cart() {
		detalhePage.clicarBotaoAddToCart();
	}

	@Então("o produto no carrinho deve possuir a mesma cor selecionada anteriormente")
	public void o_produto_no_carrinho_deve_possuir_a_mesma_cor_selecionada_anteriormente() {
		detalhePage.navegarAteCarrinho();
		carrinhoPage.esperarPaginaCarregar();
		carrinhoPage.validarCorDoProduto();
	}

	@Quando("acessar o carrinho")
	public void acessar_o_carrinho() {
		detalhePage.navegarAteCarrinho();
		carrinhoPage.esperarPaginaCarregar();
	}

	@Quando("remover o produto do carrinho")
	public void remover_o_produto_do_carrinho() {
		carrinhoPage.removerProdutoDoCarrinho();
	}

	@Então("o carrinho devera ficar vazio")
	public void o_carrinho_devera_ficar_vazio() {
		carrinhoPage.validarCarrinhoVazio();
	}

	@Dado("pesquiso o nome do produto")
	public void pesquiso_o_nome_do_produto() throws InterruptedException {
		homePage.pesquisarProduto();
	}

	@Dado("seleciono produto pesquisado")
	public void seleciono_produto_pesquisado() throws InterruptedException {
		homePage.clicarResultadoPesquisa();
		detalhePage.aguardarPaginaCarregar();
	}

	@Dado("alterar a cor do produto para uma diferente da massa de teste")
	public void alterar_a_cor_do_produto_para_uma_diferente_da_massa_de_teste() {
		detalhePage.alterarCorParaDiferenteDaPresenteNaMassa();
	}

	@Dado("alterar a quantidade de produtos para comprar")
	public void alterar_a_quantidade_de_produtos_para_comprar() {
		detalhePage.alterarQuantidade();
	}

	@Quando("acessar o checkout")
	public void acessar_o_checkout() {
		carrinhoPage.navegarParaCheckout();
		checkoutPage.aguardarPaginaCarregar();
	}

	@Então("verificar que a soma dos preços está correta")
	public void verificar_que_a_soma_dos_preços_está_correta() {
		checkoutPage.validarSomaDosProdutos();
	}

}