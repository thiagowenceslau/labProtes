package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class CadastroCliente {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// CadastroCliente
	public static Var cadastrarCliente() throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.util.Operations.redirect(Var.valueOf("#/app/public/cadastroCliente"));
				return Var.VAR_NULL;
			}
		}.call();
	}

	/**
	 */
	// Descreva esta função...
	public static void abrirTela() throws Exception {
		new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.showModal"),
						Var.valueOf("modal21517"));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
