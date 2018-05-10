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
	 */
	// Descreva esta função...
	public static void finalizarPedido() throws Exception {
		new Callable<Var>() {

			private Var cliente = Var.VAR_NULL;
			private Var idCliente = Var.VAR_NULL;
			private Var idPedido = Var.VAR_NULL;

			public Var call() throws Exception {
				cliente = cronapi.database.Operations.query(Var.valueOf("app.entity.Cliente"),
						Var.valueOf("select c from Cliente c where c.user.id = :userId"),
						Var.valueOf("userId", blockly.UsuarioEntidade.obterIdUsuarioLogado()));
				idCliente = cronapi.database.Operations.getField(cliente, Var.valueOf("this[0].id"));
				idPedido = cronapi.util.Operations.generateUUID();
				cronapi.database.Operations.insert(Var.valueOf("app.entity.Pedido"), Var.valueOf("cliente", idCliente),
						Var.valueOf("observacoes",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtObs"))),
						Var.valueOf("ativo", Var.valueOf("")),
						Var.valueOf("idadePaciente",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtIdade"))),
						Var.valueOf("paciente",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtPaciente"))),
						Var.valueOf("codigoPaciente", Var.valueOf("")),
						Var.valueOf("dataEntregaSolicitada",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dtEntrega"))),
						Var.valueOf("id", idPedido),
						Var.valueOf("sexo", cronapi.screen.Operations.getValueOfField(Var.valueOf("txtSexo"))));
				cronapi.database.Operations.insert(Var.valueOf("app.entity.ItemPedido"),
						Var.valueOf("cor", cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtCor"))),
						Var.valueOf("grupo", cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtGrupo"))),
						Var.valueOf("pedido", idPedido), Var.valueOf("id", cronapi.util.Operations.generateUUID()),
						Var.valueOf("dente", Var.VAR_NULL), Var.valueOf("tipoTrabalho",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtTipo"))));
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
	public static Var preencherGridItens() throws Exception {
		return new Callable<Var>() {

			private Var dentes = Var.VAR_NULL;
			private Var i = Var.VAR_NULL;
			private Var dente = Var.VAR_NULL;
			private Var grupoItem = Var.VAR_NULL;
			private Var tipoItem = Var.VAR_NULL;
			private Var corItem = Var.VAR_NULL;
			private Var itensPedido = Var.VAR_NULL;
			private Var listaItem = Var.VAR_NULL;

			public Var call() throws Exception {
				dentes = cronapi.list.Operations.newList(
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD11")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD12")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD13")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD14")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD15")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD16")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD17")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD18")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD21")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD22")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD23")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD24")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD25")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD26")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD27")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD28")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD31")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD32")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD33")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD34")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD35")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD36")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD37")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD38")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD41")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD42")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD43")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD44")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD45")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD46")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD47")),
						cronapi.screen.Operations.getValueOfField(Var.valueOf("cbD48")));
				System.out.println(
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtTipo")).getObjectAsString());
				System.out.println(
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtCor")).getObjectAsString());
				System.out.println(
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente48")).getObjectAsString());
				System.out.println(
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente47")).getObjectAsString());
				System.out.println(
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente45")).getObjectAsString());
				System.out.println(
						cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dente44")).getObjectAsString());
				for (Iterator it_i = dentes.iterator(); it_i.hasNext();) {
					i = Var.valueOf(it_i.next());
					if (cronapi.logic.Operations.isNullOrEmpty(i).negate().getObjectAsBoolean()) {
						dente = i;
						grupoItem = Var.valueOf("Temporário");
						tipoItem = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtTipo"));
						corItem = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtCor"));
						itensPedido = cronapi.object.Operations.newObject(Var.valueOf("app.entity.ItemPedido"),
								Var.valueOf("tipoTrabalho", tipoItem), Var.valueOf("dente", dente),
								Var.valueOf("grupo", grupoItem), Var.valueOf("cor", corItem));
						listaItem = cronapi.list.Operations.newList(itensPedido);
					}
				} // end for
				return listaItem;
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
				tipo = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtTipo"));
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

}