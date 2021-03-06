package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class PedidoNovoMobile {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param tipo
	 * @return Var
	 */
	// PedidoNovoMobile
	public static Var retornarNomeTipoTrabalho(Var tipo) throws Exception {
		return new Callable<Var>() {

			private Var consulta = Var.VAR_NULL;
			private Var nome = Var.VAR_NULL;

			public Var call() throws Exception {
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.TipoTrabalho"),
						Var.valueOf("select t from TipoTrabalho t where t = :t"), Var.valueOf("t", tipo));
				nome = cronapi.database.Operations.getField(consulta, Var.valueOf("this[0].nome"));
				return nome;
			}
		}.call();
	}

	/**
	 *
	 * @param id_pedido
	 * @return Var
	 */
	// Descreva esta função...
	public static Var CalcularTotal(Var id_pedido) throws Exception {
		return new Callable<Var>() {

			private Var i = Var.VAR_NULL;
			private Var valorPedido = Var.VAR_NULL;

			public Var call() throws Exception {
				valorPedido = cronapi.database.Operations.query(Var.valueOf("app.entity.ItemPedido"),
						Var.valueOf("select SUM(i.valorServico) from ItemPedido i where i.pedido.id = :pedidoId"),
						Var.valueOf("pedidoId", id_pedido));
				return valorPedido;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var criarPedido() throws Exception {
		return new Callable<Var>() {

			private Var idPedido = Var.VAR_NULL;
			private Var i = Var.VAR_NULL;
			private Var dente = Var.VAR_NULL;
			private Var tipoItem = Var.VAR_NULL;
			private Var corItem = Var.VAR_NULL;
			private Var grupoItem = Var.VAR_NULL;

			public Var call() throws Exception {
				idPedido = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.idPedido"));
				if (Var.valueOf(Var.valueOf(idPedido.equals(Var.valueOf("0"))).getObjectAsBoolean()
						|| cronapi.logic.Operations.isNullOrEmpty(idPedido).getObjectAsBoolean())
						.getObjectAsBoolean()) {
					idPedido = cronapi.util.Operations.generateUUID();
					cronapi.database.Operations.insert(Var.valueOf("app.entity.Pedido"),
							Var.valueOf("cliente", Var.valueOf(retornarIdClienteLogado())),
							Var.valueOf("ativo", Var.valueOf("false")), Var.valueOf("paciente", Var.valueOf(" ")),
							Var.valueOf("id", idPedido), Var.valueOf("sexo", Var.valueOf(" ")));
				}
				for (Iterator it_i = Var.valueOf(retornarListaDentes()).iterator(); it_i.hasNext();) {
					i = Var.valueOf(it_i.next());
					if (cronapi.logic.Operations.isNullOrEmpty(i).negate().getObjectAsBoolean()) {
						dente = i;
						tipoItem = cronapi.screen.Operations.getValueOfField(Var.valueOf("TipoTrabalho.active.nome"));
						corItem = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtCor"));
						grupoItem = cronapi.screen.Operations.getValueOfField(Var.valueOf("GrupoPedido.active.nome"));
						cronapi.database.Operations.insert(Var.valueOf("app.entity.ItemPedido"),
								Var.valueOf("cor", corItem), Var.valueOf("grupo", grupoItem),
								Var.valueOf("pedido", idPedido),
								Var.valueOf("id", cronapi.util.Operations.generateUUID()), Var.valueOf("dente", dente),
								Var.valueOf("tipoTrabalho", tipoItem));
					}
				} // end for
				limparOdontograma();
				return idPedido;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var criarPedidoCompleto() throws Exception {
		return new Callable<Var>() {

			private Var protocolo = Var.VAR_NULL;
			private Var idPedido = Var.VAR_NULL;
			private Var i = Var.VAR_NULL;
			private Var dente = Var.VAR_NULL;
			private Var tipoItem = Var.VAR_NULL;
			private Var corItem = Var.VAR_NULL;
			private Var codigoPaciente = Var.VAR_NULL;
			private Var nomePaciente = Var.VAR_NULL;
			private Var dataEntrega = Var.VAR_NULL;
			private Var dataNascimento = Var.VAR_NULL;
			private Var idadePaciente = Var.VAR_NULL;
			private Var sexoPaciente = Var.VAR_NULL;
			private Var foto = Var.VAR_NULL;
			private Var validador = Var.VAR_NULL;
			private Var servicoItem = Var.VAR_NULL;
			private Var servicos = Var.VAR_NULL;
			private Var valorServico = Var.VAR_NULL;

			public Var call() throws Exception {
				idPedido = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.idPedido"));
				codigoPaciente = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtCodPaciente"));
				nomePaciente = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtPaciente"));
				dataEntrega = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dtEntrega"));
				dataNascimento = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dtNasc"));
				idadePaciente = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtIdade"));
				sexoPaciente = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtSexo"));
				foto = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.foto"));
				protocolo = Var.valueOf(retornarProcolo());
				validador = Var.VAR_TRUE;
				if (cronapi.logic.Operations.isNullOrEmpty(nomePaciente).getObjectAsBoolean()) {
					validador = Var.VAR_FALSE;
				}
				if (cronapi.logic.Operations.isNullOrEmpty(dataEntrega).getObjectAsBoolean()) {
					validador = Var.VAR_FALSE;
				}
				if (cronapi.logic.Operations.isNullOrEmpty(dataNascimento).getObjectAsBoolean()) {
					validador = Var.VAR_FALSE;
				}
				if (cronapi.logic.Operations.isNullOrEmpty(idadePaciente).getObjectAsBoolean()) {
					validador = Var.VAR_FALSE;
				}
				if (cronapi.logic.Operations.isNullOrEmpty(sexoPaciente).getObjectAsBoolean()) {
					validador = Var.VAR_FALSE;
				}
				if (validador.getObjectAsBoolean()) {
					if (Var.valueOf(Var.valueOf(idPedido.equals(Var.valueOf("0"))).getObjectAsBoolean()
							|| cronapi.logic.Operations.isNullOrEmpty(idPedido).getObjectAsBoolean())
							.getObjectAsBoolean()) {
						idPedido = cronapi.util.Operations.generateUUID();
						cronapi.database.Operations.insert(Var.valueOf("app.entity.Pedido"),
								Var.valueOf("ativo", Var.valueOf("true")), Var.valueOf("idadePaciente", idadePaciente),
								Var.valueOf("valor", Var.valueOf(0)), Var.valueOf("codigoPaciente", codigoPaciente),
								Var.valueOf("dataEntregaSolicitada", dataEntrega),
								Var.valueOf("dataEnvio", cronapi.dateTime.Operations.getNowNoHour()),
								Var.valueOf("protocolo", protocolo),
								Var.valueOf("cliente", Var.valueOf(retornarIdClienteLogado())),
								Var.valueOf("observacoes",
										cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtObs"))),
								Var.valueOf("foto", foto), Var.valueOf("paciente", nomePaciente),
								Var.valueOf("situacaoPedido", Var.valueOf("aguardando")), Var.valueOf("id", idPedido),
								Var.valueOf("sexo", sexoPaciente),
								Var.valueOf("dataNascimentoPaciente", dataNascimento));
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
								Var.valueOf("vars.idPedido"), idPedido);
					}
					for (Iterator it_i = Var.valueOf(retornarListaDentes()).iterator(); it_i.hasNext();) {
						i = Var.valueOf(it_i.next());
						if (cronapi.logic.Operations.isNullOrEmpty(i).negate().getObjectAsBoolean()) {
							dente = i;
							tipoItem = cronapi.screen.Operations
									.getValueOfField(Var.valueOf("TipoTrabalho.active.nome"));
							corItem = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtCor"));
							servicoItem = cronapi.screen.Operations
									.getValueOfField(Var.valueOf("Servico.active.descricao"));
							servicos = cronapi.database.Operations.query(Var.valueOf("app.entity.Servico"),
									Var.valueOf("select s from Servico s where s.tipoTrabalho.id = :tipoTrabalhoId"),
									Var.valueOf("tipoTrabalhoId", cronapi.screen.Operations
											.getValueOfField(Var.valueOf("TipoTrabalho.active.id"))));
							valorServico = cronapi.database.Operations.getField(servicos,
									Var.valueOf("this[0].preco1"));
							cronapi.database.Operations.insert(Var.valueOf("app.entity.ItemPedido"),
									Var.valueOf("nomeServico", servicoItem), Var.valueOf("cor", corItem),
									Var.valueOf("pedido", idPedido),
									Var.valueOf("id", cronapi.util.Operations.generateUUID()),
									Var.valueOf("servico",
											cronapi.database.Operations.newEntity(Var.valueOf("app.entity.Servico"),
													Var.valueOf("id",
															cronapi.screen.Operations.getValueOfField(
																	Var.valueOf("Servico.active.id"))))),
									Var.valueOf("dente", dente), Var.valueOf("tipoTrabalho", tipoItem),
									Var.valueOf("valorServico", valorServico));
						}
					} // end for
					limparOdontograma();
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
							Var.valueOf("TipoTrabalho.active"), Var.valueOf("0"));
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
							Var.valueOf("Servico.active"), Var.valueOf("0"));
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
							Var.valueOf("vars.txtCor"), Var.VAR_NULL);
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.showComponent"),
							Var.valueOf("crn-button-btnFinalizar"));
				} else {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("warning"), Var.valueOf("Preencha os campos obrigatórios"));
				}
				return idPedido;
			}
		}.call();
	}

	/**
	 */
	// Descreva esta função...
	public static void finalizarPedido() throws Exception {
		new Callable<Var>() {

			private Var codigoPaciente = Var.VAR_NULL;
			private Var idadePaciente = Var.VAR_NULL;
			private Var foto = Var.VAR_NULL;

			public Var call() throws Exception {
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Pedido"),
						Var.valueOf(
								"update Pedido set observacoes = :observacoes, foto = :foto, idadePaciente = :idadePaciente, paciente = :paciente, dataNascimentoPaciente = :dataNascimentoPaciente, codigoPaciente = :codigoPaciente, dataEntregaSolicitada = :dataEntregaSolicitada, valor = :valor where id = :id"),
						Var.valueOf("observacoes",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtObs"))),
						Var.valueOf("foto", cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.foto"))),
						Var.valueOf("idadePaciente",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtIdade"))),
						Var.valueOf("paciente",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtPaciente"))),
						Var.valueOf("dataNascimentoPaciente",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dtNasc"))),
						Var.valueOf("codigoPaciente",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtCodPaciente"))),
						Var.valueOf("dataEntregaSolicitada",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dtEntrega"))),
						Var.valueOf("valor", cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtTotal"))),
						Var.valueOf("id", cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.idPedido"))));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideComponent"),
						Var.valueOf("crn-container-Odontograma"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideComponent"),
						Var.valueOf("crn-list-item-Grupo"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideComponent"),
						Var.valueOf("crn-list-item-Cor"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideComponent"),
						Var.valueOf("crn-list-item-btnAdd"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.hideComponent"),
						Var.valueOf("crn-button-btnFinalizar"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.idPedido"), Var.valueOf("0"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.txtPaciente"), Var.valueOf(" "));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.txtObs"), Var.valueOf(" "));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.foto"), Var.valueOf(" "));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.txtIdade"), Var.valueOf(" "));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.txtCodPaciente"), Var.valueOf(" "));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dtEntrega"), Var.valueOf(" "));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dtNasc"), Var.valueOf(" "));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("TipoTrabalho.active"), Var.valueOf("0"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"),
						Var.valueOf("ItemPedido"), Var.valueOf("true"));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Pedido realizado com sucesso!"));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 */
	// Descreva esta função...
	public static void limparOdontograma() throws Exception {
		new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente11"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente12"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente13"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente14"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente15"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente16"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente17"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente18"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente21"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente22"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente23"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente24"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente25"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente26"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente27"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente28"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente31"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente32"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente33"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente34"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente35"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente36"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente37"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente38"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente41"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente42"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente43"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente44"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente45"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente46"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente47"), Var.VAR_FALSE);
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
						Var.valueOf("vars.dente48"), Var.VAR_FALSE);
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarIdClienteLogado() throws Exception {
		return new Callable<Var>() {

			private Var idCliente = Var.VAR_NULL;
			private Var cliente = Var.VAR_NULL;

			public Var call() throws Exception {
				cliente = cronapi.database.Operations.query(Var.valueOf("app.entity.Cliente"),
						Var.valueOf("select c from Cliente c where c.user.id = :userId"),
						Var.valueOf("userId", blockly.UsuarioEntidade.obterIdUsuarioLogado()));
				idCliente = cronapi.database.Operations.getField(cliente, Var.valueOf("this[0].id"));
				return idCliente;
			}
		}.call();
	}

	/**
	 *
	 * @param comboTipo
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarIdTipoTrabalho(Var comboTipo) throws Exception {
		return new Callable<Var>() {

			private Var consultaId = Var.VAR_NULL;
			private Var idTipoTrabalho = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaId = cronapi.database.Operations.query(Var.valueOf("app.entity.TipoTrabalho"),
						Var.valueOf("select t from TipoTrabalho t where t = :t"), Var.valueOf("t", comboTipo));
				idTipoTrabalho = cronapi.database.Operations.getField(consultaId, Var.valueOf("this[0].id"));
				return idTipoTrabalho;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarListaDentes() throws Exception {
		return new Callable<Var>() {

			private Var dentes = Var.VAR_NULL;

			public Var call() throws Exception {
				dentes = cronapi.list.Operations.newList();
				dentes = cronapi.list.Operations.newList(
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente11")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente12")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente13")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente14")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente15")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente16")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente17")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente18")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente21")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente22")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente23")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente24")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente25")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente26")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente27")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente28")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente31")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente32")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente33")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente34")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente35")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente36")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente37")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente38")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente41")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente42")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente43")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente44")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente45")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente46")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente47")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente48")));
				return dentes;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarProcolo() throws Exception {
		return new Callable<Var>() {

			private Var idCliente = Var.VAR_NULL;
			private Var mesAtual = Var.VAR_NULL;
			private Var horaAtual = Var.VAR_NULL;
			private Var minutoAtual = Var.VAR_NULL;
			private Var anoAtual = Var.VAR_NULL;
			private Var diaAtual = Var.VAR_NULL;
			private Var protocolo = Var.VAR_NULL;

			public Var call() throws Exception {
				idCliente = Var.valueOf(retornarIdClienteLogado());
				mesAtual = cronapi.dateTime.Operations.getMonth(cronapi.dateTime.Operations.getNow());
				horaAtual = cronapi.dateTime.Operations.getHour(cronapi.dateTime.Operations.getNow());
				minutoAtual = cronapi.dateTime.Operations.getMinute(cronapi.dateTime.Operations.getNow());
				anoAtual = cronapi.dateTime.Operations.getYear(cronapi.dateTime.Operations.getNow());
				diaAtual = cronapi.dateTime.Operations.getDay(cronapi.dateTime.Operations.getNow());
				protocolo = Var.valueOf(cronapi.text.Operations
						.getLettersFromStartToFromStart(idCliente, Var.valueOf(1), Var.valueOf(3)).toString()
						+ diaAtual.toString() + mesAtual.toString()
						+ cronapi.text.Operations
								.getLettersFromStartToFromStart(anoAtual, Var.valueOf(3), Var.valueOf(4)).toString()
						+ horaAtual.toString() + minutoAtual.toString());
				return protocolo;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var somar() throws Exception {
		return new Callable<Var>() {

			private Var i = Var.VAR_NULL;
			private Var consultaItens = Var.VAR_NULL;
			private Var tipos = Var.VAR_NULL;
			private Var consultaServico = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaItens = cronapi.database.Operations.query(Var.valueOf("app.entity.ItemPedido"),
						Var.valueOf("select i from ItemPedido i where i.pedido.id = :pedidoId"), Var.valueOf("pedidoId",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.idPedido"))));
				tipos = cronapi.database.Operations.getField(consultaItens, Var.valueOf("this[0].tipoTrabalho"));
				consultaServico = cronapi.database.Operations.query(Var.valueOf("app.entity.Servico"),
						Var.valueOf("select s from Servico s where s.tipoTrabalho.id = :tipoTrabalhoId"),
						Var.valueOf("tipoTrabalhoId", Var.VAR_NULL));
				return tipos;
			}
		}.call();
	}

}
