window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.PedidoNovo = window.blockly.js.PedidoNovo || {};

var item, comboTipo, idTipo, tipoTrabalho;

/**
 * Descreva esta função...
 */
window.blockly.js.PedidoNovo.adicionar = function() {
	this.cronapi.screen.hideComponent("crn-list-item-Paciente");
	this.cronapi.screen.hideComponent("crn-list-item-Idade");
	this.cronapi.screen.hideComponent("crn-list-item-Sexo");
	this.cronapi.screen.hideComponent("crn-list-item-Entrega");
}

/**
 * PedidoNovo
 */
window.blockly.js.PedidoNovo.Executar = function(comboTipo) {
	tipoTrabalho = null;
	idTipo = this.cronapi.object.getProperty(comboTipo, 'id');
	if (tipoTrabalho == 'Contenção' || tipoTrabalho == 'Placa') {
		this.cronapi.screen.showComponent("crn-list-item-Grupo");
		this.cronapi.screen.showComponent("crn-list-item-btnAdd");
		this.cronapi.screen.showComponent("crn-container-ItensPedido");
		this.cronapi.screen.showComponent("crn-list-item-Observacoes");
		this.cronapi.screen.showComponent("crn-button-btnFinalizar");
	} else {
		this.cronapi.screen.showComponent("crn-container-Odontograma");
		this.cronapi.screen.showComponent("crn-list-item-Grupo");
		this.cronapi.screen.showComponent("crn-list-item-Cor");
		this.cronapi.screen.showComponent("crn-list-item-btnAdd");
		this.cronapi.screen.showComponent("crn-container-ItensPedido");
		this.cronapi.screen.showComponent("crn-list-item-Observacoes");
		this.cronapi.screen.showComponent("crn-button-btnFinalizar");
	}
}
