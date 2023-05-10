#language: pt

Funcionalidade: Checkout da compra
	Como usuário do site Advantage Shoping
	Usuário quer avançar com a compra
	Para anlisar se todos os valores estão corretos
	
Cenário: Validar página de checkout
	Dado acesso ao site Advantage Shoping
	E pesquiso o nome do produto
	E seleciono produto pesquisado
	E alterar a cor do produto para uma diferente da massa de teste
	E alterar a quantidade de produtos para comprar
	E clicar no botão Add to cart
	Quando acessar o carrinho
	E acessar o checkout
	Então verificar que a soma dos preços está correta