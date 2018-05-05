window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.ModalCliente = window.blockly.js.ModalCliente || {};

/**
 * Descreva esta função...
 */
window.blockly.js.ModalCliente.fechar = function() {
	this.cronapi.screen.hideModal("modal21257");
}

/**
 * ModalCliente
 */
window.blockly.js.ModalCliente.abrir = function() {
	this.cronapi.screen.showModal("modal21257");
}
