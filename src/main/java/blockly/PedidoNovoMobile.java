package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
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
	public static Var popularComboGrupo() throws Exception {
		return new Callable<Var>() {

			private Var consultaId = Var.VAR_NULL;
			private Var idTipoTrabalho = Var.VAR_NULL;
			private Var consultaGrupo = Var.VAR_NULL;

			public Var call() throws Exception {
				consultaId = cronapi.database.Operations.query(Var.valueOf("app.entity.TipoTrabalho"),
						Var.valueOf("select t from TipoTrabalho t where t.id = :id"),
						Var.valueOf("id",
								cronapi.object.Operations.getObjectField(
										cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtTipo")),
										Var.valueOf("id"))));
				idTipoTrabalho = cronapi.database.Operations.getField(consultaId, Var.valueOf("this[0].id"));
				consultaGrupo = cronapi.database.Operations.query(Var.valueOf("app.entity.GrupoPedido"),
						Var.valueOf("select g from GrupoPedido g where g.tipoTrabalho.id = :tipoTrabalhoId"),
						Var.valueOf("tipoTrabalhoId", idTipoTrabalho));
				return consultaGrupo;
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
