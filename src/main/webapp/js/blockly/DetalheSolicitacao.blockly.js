window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.DetalheSolicitacao = window.blockly.js.blockly.DetalheSolicitacao
		|| {};

/**
 * DetalheSolicitacao
 */
window.blockly.js.blockly.DetalheSolicitacao.obterId = function() {

	var item, idPedido, pedidoId;
	idPedido = this.cronapi.screen.getParam('idPedido');
	return idPedido;
}
