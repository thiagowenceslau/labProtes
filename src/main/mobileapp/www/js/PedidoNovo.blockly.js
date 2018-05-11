window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.PedidoNovo = window.blockly.js.PedidoNovo || {};

/**
 * Descreva esta função...
 */
window.blockly.js.PedidoNovo.finalizar = function() {

	var item, comboTipo, idPedido, tipoTrabalho, i;
	if (this.cronapi.logic
			.isNullOrEmpty(this.cronapi.screen
					.getValueOfField("vars.txtPaciente")
					|| (this.cronapi.screen.getValueOfField("vars.txtIdade") || (this.cronapi.screen
							.getValueOfField("txtSexo") || this.cronapi.screen
							.getValueOfField("vars.dtEntrega"))))) {
		this.cronapi.screen
				.notify('warning', 'Preencha os campos obrigatórios');
	} else {
		this.cronapi.screen.changeValueOfField("vars.idPedido", '0');
		this.cronapi.screen.changeValueOfField("vars.txtPaciente", ' ');
		this.cronapi.screen.changeValueOfField("vars.txtCor", ' ');
		this.cronapi.screen.changeValueOfField("vars.txtIdade", ' ');
		this.cronapi.screen.changeValueOfField("vars.txtPaciente", ' ');
		this.cronapi.screen.changeValueOfField("vars.txtObs", ' ');
		this.cronapi.screen.changeValueOfField("vars.dtEntrega", ' ');
		this.cronapi.screen.changeValueOfField("TipoTrabalho.active", '0');
		this.cronapi.screen.changeValueOfField("GrupoPedido.active", '0');
		this.cronapi.screen.changeValueOfField("vars.dente11", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente11", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente12", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente13", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente14", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente15", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente16", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente17", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente18", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente21", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente22", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente23", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente24", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente25", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente26", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente27", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente28", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente31", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente32", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente33", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente34", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente35", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente36", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente37", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente38", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente41", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente42", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente43", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente44", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente45", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente46", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente47", ' ');
		this.cronapi.screen.changeValueOfField("vars.dente48", ' ');
		this.cronapi.screen.hideComponent("crn-container-Odontograma");
		this.cronapi.screen.hideComponent("crn-list-item-Grupo");
		this.cronapi.screen.hideComponent("crn-list-item-Cor");
		this.cronapi.screen.hideComponent("crn-list-item-btnAdd");
		this.cronapi.screen.notify('success', 'Pedido realizado com sucesso!');
	}
}

/**
 * Descreva esta função...
 */
window.blockly.js.PedidoNovo.adicionar = function() {

	var item, comboTipo, idPedido, tipoTrabalho, i;
	idPedido = this.cronapi.util
			.callServerBlockly('blockly.PedidoNovoMobile:criarPedido');
	this.cronapi.screen.changeValueOfField("vars.idPedido", idPedido);
	this.cronapi.screen.refreshDatasource("ItemPedido", 'true');
}

/**
 * PedidoNovo
 */
window.blockly.js.PedidoNovo.Executar = function(comboTipo) {

	var item, comboTipo, idPedido, tipoTrabalho, i;
	tipoTrabalho = this.cronapi.util.callServerBlockly(
			'blockly.PedidoNovoMobile:retornarNomeTipoTrabalho', comboTipo);
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
	if (tipoTrabalho == 'Enceramento') {
		this.cronapi.screen.hideComponent("crn-list-item-Cor");
	}
	if (tipoTrabalho == 'Contenção' || tipoTrabalho == 'Placa') {
		this.cronapi.screen.hideComponent("crn-container-Odontograma");
		this.cronapi.screen.hideComponent("crn-list-item-Cor");
	}
}
