window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.PedidoNovo = window.blockly.js.PedidoNovo || {};

var tipoTrabalho, comboTipo;

/**
 * PedidoNovo
 */
window.blockly.js.PedidoNovo.Executar = function(comboTipo) {
	tipoTrabalho = null;
	window.alert(this.cronapi.object.getProperty(this.cronapi.screen
			.getValueOfField("vars.txtTipo"), 'nome'));
	if (tipoTrabalho == 'Contenção' || tipoTrabalho == 'Placa') {
		this.cronapi.screen.refreshDatasource("GrupoPedido", 'true');
		this.cronapi.screen.showComponent("crn-list-item-Grupo");
		this.cronapi.screen.showComponent("crn-list-item-btnAdd");
		this.cronapi.screen.showComponent("crn-container-ItensPedido");
		this.cronapi.screen.showComponent("crn-list-item-Observacoes");
		this.cronapi.screen.showComponent("crn-button-btnFinalizar");
	} else {
		this.cronapi.screen.showComponent("crn-container-Odontograma");
		this.cronapi.screen.refreshDatasource("GrupoPedido", 'true');
		this.cronapi.screen.showComponent("crn-list-item-Grupo");
		this.cronapi.screen.showComponent("crn-list-item-Cor");
		this.cronapi.screen.showComponent("crn-list-item-btnAdd");
		this.cronapi.screen.showComponent("crn-container-ItensPedido");
		this.cronapi.screen.showComponent("crn-list-item-Observacoes");
		this.cronapi.screen.showComponent("crn-button-btnFinalizar");
	}
	this.cronapi.screen.refreshDatasource("GrupoPedido", 'true');
}
