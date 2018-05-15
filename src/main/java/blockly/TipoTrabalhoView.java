package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class TipoTrabalhoView {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param nome
	 * @return Var
	 */
	// TipoTrabalhoView
	public static Var inserir(Var nome) throws Exception {
		return new Callable<Var>() {

			public Var call() throws Exception {
				cronapi.database.Operations.insert(Var.valueOf("app.entity.TipoTrabalho"), Var.valueOf("nome", nome));
				return Var.VAR_NULL;
			}
		}.call();
	}

}
