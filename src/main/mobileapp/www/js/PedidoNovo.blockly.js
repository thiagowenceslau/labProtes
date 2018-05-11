window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.PedidoNovo = window.blockly.js.PedidoNovo || {};

/**
 * Descreva esta função...
 */
window.blockly.js.PedidoNovo.adicionar = function() {

	var idPedido, tipoTrabalho, comboTipo;
	idPedido = this.cronapi.util
			.callServerBlockly('blockly.PedidoNovoMobile:criarPedidoCompleto');
	this.cronapi.screen.changeValueOfField("vars.idPedido", idPedido);
	this.cronapi.screen.refreshDatasource("ItemPedido", 'true');
}

/**
 * Descreva esta função...
 */
window.blockly.js.PedidoNovo.finalizar = function() {

	var idPedido, tipoTrabalho, comboTipo;
	this.cronapi.util
			.callServerBlocklyNoReturn('blockly.PedidoNovoMobile:finalizarPedido');
	this.cronapi.screen.changeValueOfField("vars.idPedido", '0');
	this.cronapi.screen.hideComponent("crn-container-Odontograma");
	this.cronapi.screen.hideComponent("crn-list-item-Grupo");
	this.cronapi.screen.hideComponent("crn-list-item-Cor");
	this.cronapi.screen.hideComponent("crn-list-item-btnAdd");
	this.cronapi.screen.hideComponent("crn-button-btnFinalizar");
	this.cronapi.screen.refreshDatasource("ItemPedido", 'true');
	this.cronapi.screen.notify('warning', 'Pedido realizado com sucesso!');
}

/**
 * PedidoNovo
 */
window.blockly.js.PedidoNovo.Executar = function(comboTipo) {

	var idPedido, tipoTrabalho, comboTipo;
	tipoTrabalho = this.cronapi.util.callServerBlockly(
			'blockly.PedidoNovoMobile:retornarNomeTipoTrabalho', comboTipo);
	if (tipoTrabalho == 'Contenção' || tipoTrabalho == 'Placa') {
		this.cronapi.screen.showComponent("crn-list-item-Grupo");
		this.cronapi.screen.showComponent("crn-list-item-btnAdd");
		this.cronapi.screen.showComponent("crn-container-ItensPedido");
		this.cronapi.screen.showComponent("crn-list-item-Observacoes");
	} else {
		this.cronapi.screen.showComponent("crn-container-Odontograma");
		this.cronapi.screen.showComponent("crn-list-item-Grupo");
		this.cronapi.screen.showComponent("crn-list-item-btnAdd");
		this.cronapi.screen.showComponent("crn-list-item-Cor");
		this.cronapi.screen.showComponent("crn-container-ItensPedido");
		this.cronapi.screen.showComponent("crn-list-item-Observacoes");
	}
	if (tipoTrabalho == 'Enceramento') {
		this.cronapi.screen.hideComponent("crn-list-item-Cor");
	}
	if (tipoTrabalho == 'Contenção' || tipoTrabalho == 'Placa') {
		this.cronapi.screen.hideComponent("crn-container-Odontograma");
		this.cronapi.screen.hideComponent("crn-list-item-Cor");
	}
}
