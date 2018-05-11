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
				idPedido = cronapi.util.Operations.generateUUID();
				cronapi.database.Operations.insert(Var.valueOf("app.entity.Pedido"),
						Var.valueOf("cliente", Var.valueOf(retornarIdClienteLogado())),
						Var.valueOf("ativo", Var.valueOf("false")),
						Var.valueOf("paciente",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtPaciente"))),
						Var.valueOf("id", idPedido),
						Var.valueOf("sexo", cronapi.screen.Operations.getValueOfField(Var.valueOf("txtSexo"))));
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
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.refreshDatasource"),
								Var.valueOf("ItemPedido"), Var.valueOf("true"));
					}
				} // end for
				return idPedido;
			}
		}.call();
	}

	/**
	 *
	 * @param pedidoId
	 */
	// Descreva esta função...
	public static void finalizarPedido(Var pedidoId) throws Exception {
		new Callable<Var>() {

			private Var idPedido = Var.VAR_NULL;
			private Var consultaPedido = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaPedido = cronapi.database.Operations.query(Var.valueOf("app.entity.Pedido"),
						Var.valueOf("select p from Pedido p where p.cliente.id = :clienteId"),
						Var.valueOf("clienteId", Var.valueOf(retornarIdClienteLogado())));
				idPedido = cronapi.database.Operations.getField(consultaPedido, Var.valueOf("this[0].id"));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Pedido"),
						Var.valueOf(
								"update Pedido set ativo = :ativo, observacoes = :observacoes, idadePaciente = :idadePaciente, paciente = :paciente, sexo = :sexo, dataEntregaSolicitada = :dataEntregaSolicitada, situacaoPedido = :situacaoPedido where id = :id"),
						Var.valueOf("ativo", Var.valueOf("true")),
						Var.valueOf("observacoes",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtObs"))),
						Var.valueOf("idadePaciente",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtIdade"))),
						Var.valueOf("paciente",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtPaciente"))),
						Var.valueOf("sexo", cronapi.screen.Operations.getValueOfField(Var.valueOf("txtSexo"))),
						Var.valueOf("dataEntregaSolicitada",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dtEntrega"))),
						Var.valueOf("situacaoPedido", Var.valueOf("aguardando")), Var.valueOf("id", pedidoId));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Pedido finalizado com sucesso"));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var popularCombogrupo() throws Exception {
		return new Callable<Var>() {

			private Var consultaGrupo = Var.VAR_NULL;

			public Var call() throws Exception {
				System.out.println(Var.valueOf(retornarIdJson()).getObjectAsString());
				consultaGrupo = cronapi.database.Operations.query(Var.valueOf("app.entity.GrupoPedido"),
						Var.valueOf("select g from GrupoPedido g where g.tipoTrabalho.id = :tipoTrabalhoId"),
						Var.valueOf("tipoTrabalhoId", Var.valueOf(retornarIdJson())));
				return consultaGrupo;
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

			private Var cliente = Var.VAR_NULL;
			private Var idCliente = Var.VAR_NULL;

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
	 * @return Var
	 */
	// Descreva esta função...
	public static Var retornarIdJson() throws Exception {
		return new Callable<Var>() {

			private Var tipo = Var.VAR_NULL;
			private Var idJson = Var.VAR_NULL;

			public Var call() throws Exception {
				tipo = cronapi.screen.Operations.getValueOfField(Var.valueOf("TipoTrabalho.active"));
				idJson = cronapi.json.Operations.getJsonOrMapField(tipo, Var.valueOf("id"));
				System.out.println(idJson.getObjectAsString());
				return idJson;
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

}
