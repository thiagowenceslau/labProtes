window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ModalClienteAdmin = window.blockly.js.blockly.ModalClienteAdmin
		|| {};

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalClienteAdmin.fechar = function() {
	this.cronapi.screen.hideModal("modal8785");
}

/**
 * Descreva esta função...
 */
window.blockly.js.blockly.ModalClienteAdmin.exibir = function() {
	this.cronapi.screen.showModal("modal8785");
}
