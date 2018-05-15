window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.DetalheSolicitacao = window.blockly.js.blockly.DetalheSolicitacao
		|| {};

/**
 * DetalheSolicitacao
 */
window.blockly.js.blockly.DetalheSolicitacao.obterId = function() {

	var idPedido;
	idPedido = this.cronapi.screen.getParam('pedido');
	return idPedido;
}
