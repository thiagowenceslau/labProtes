package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class BlocoAtalho {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param tipo
	 * @return Var
	 */
	// BlocoAtalho
	public static Var inserir(Var tipo) throws Exception {
		return new Callable<Var>() {

			private Var consulta = Var.VAR_NULL;
			private Var tipoTrabalho = Var.VAR_NULL;

			public Var call() throws Exception {
				consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.TipoTrabalho"),
						Var.valueOf("select t from TipoTrabalho t where t = :t"), Var.valueOf("t", tipo));
				tipoTrabalho = cronapi.database.Operations.getField(consulta, Var.valueOf("this[0].nome"));
				return tipoTrabalho;
			}
		}.call();
	}

}
