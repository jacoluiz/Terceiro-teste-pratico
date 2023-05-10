#language: pt

Funcionalidade: Carrinho de compras
	Como usuário do site Advantage Shoping
	Usuário quer adicionar e remover produtos do carrinho
	Para fazer suas compras
	
Cenário: Validar alteração de cor do produto no carrinho
	Dado acesso ao site Advantage Shoping
	Quando clicar na opção Special Offer
	E clicar no botão See offer
	E alterar a cor do produto para a mesma da massa de teste
	E clicar no botão Add to cart
	Então o produto no carrinho deve possuir a mesma cor selecionada anteriormente
	
Cenário: Validar remoção de produto no carrinho
	Dado acesso ao site Advantage Shoping
	E clicar na opção Special Offer
	E clicar no botão See offer
	Quando clicar no botão Add to cart
	E acessar o carrinho
	E remover o produto do carrinho
	Então o carrinho devera ficar vazio