package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ObterCliente {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// ObterCliente
	public static Var obterClienteLogado() throws Exception {
		return new Callable<Var>() {

			private Var user = Var.VAR_NULL;
			private Var cliente = Var.VAR_NULL;
			private Var idCliente = Var.VAR_NULL;

			public Var call() throws Exception {
				user = blockly.UsuarioEntidade.obterIdUsuarioLogado();
				cliente = cronapi.database.Operations.query(Var.valueOf("app.entity.Cliente"),
						Var.valueOf("select c from Cliente c where c.user.id = :userId"), Var.valueOf("userId", user));
				idCliente = cronapi.database.Operations.getField(cliente, Var.valueOf("this[0].id"));
				return cliente;
			}
		}.call();
	}

}
