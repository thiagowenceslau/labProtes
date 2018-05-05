window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.ModalPedidoNovo = window.blockly.js.ModalPedidoNovo || {};

/**
 * Descreva esta função...
 */
window.blockly.js.ModalPedidoNovo.exibir = function() {
	this.cronapi.screen.showIonicModal("modalPedido");
}

/**
 * Descreva esta função...
 */
window.blockly.js.ModalPedidoNovo.fechar = function() {
	this.cronapi.screen.hideModal("modalPedido");
}
