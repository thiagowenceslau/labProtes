package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class UsuarioEntidade {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param dados
	 * @return Var
	 */
	// UsuarioEntidade
	public static Var obterClienteLogado(Var dados) throws Exception {
		return new Callable<Var>() {

			private Var usuario = Var.VAR_NULL;

			public Var call() throws Exception {
				usuario = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"),
						Var.valueOf("login", cronapi.util.Operations.getCurrentUserName()));
				return cronapi.database.Operations.newEntity(Var.valueOf("app.entity.User"),
						Var.valueOf("id", cronapi.database.Operations.getField(usuario, Var.valueOf("this[0].id"))));
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var obterIdUsuarioLogado() throws Exception {
		return new Callable<Var>() {

			private Var login = Var.VAR_NULL;
			private Var consulta = Var.VAR_NULL;
			private Var idUsuario = Var.VAR_NULL;

			public Var call() throws Exception {
				login = cronapi.util.Operations.getCurrentUserName();
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),
						Var.valueOf("select u from User u where u.login = :login"), Var.valueOf("login", login));
				idUsuario = cronapi.database.Operations.getField(consulta, Var.valueOf("this[0].id"));
				return idUsuario;
			}
		}.call();
	}

}
