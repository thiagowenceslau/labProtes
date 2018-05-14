window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.SolicitacaoPedido = window.blockly.js.blockly.SolicitacaoPedido
		|| {};

/**
 * SolicitacaoPedido
 */
window.blockly.js.blockly.SolicitacaoPedido.visualizar = function(pedido) {

	var item, idPedido, pedido;
	idPedido = this.cronapi.util.callServerBlockly(
			'blockly.SolicitacoesPedidos:retornarIdPedido', pedido);
	this.cronapi.screen.changeView("#/home/logged/detalhesolicitacao", [{
		idPedido : idPedido
	}]);
	return idPedido;
}
