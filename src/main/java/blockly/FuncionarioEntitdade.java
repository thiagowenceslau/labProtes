package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class FuncionarioEntitdade {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @param Entidade
	 * @return Var
	 */
	// FuncionarioEntitdade
	public static Var insereEObtemUsuario(Var Entidade) throws Exception {
		return new Callable<Var>() {

			private Var senha = Var.VAR_NULL;
			private Var email = Var.VAR_NULL;
			private Var nome = Var.VAR_NULL;
			private Var idUser = Var.VAR_NULL;

			public Var call() throws Exception {
				senha = cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("user.password"));
				email = cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("email"));
				nome = cronapi.object.Operations.getObjectField(Entidade, Var.valueOf("nome"));
				idUser = cronapi.util.Operations.generateUUID();
				cronapi.database.Operations.insert(Var.valueOf("app.entity.User"), Var.valueOf("password", senha),
						Var.valueOf("name", nome), Var.valueOf("id", idUser), Var.valueOf("login", email),
						Var.valueOf("email", email));
				cronapi.database.Operations.insert(Var.valueOf("app.entity.Role"),
						Var.valueOf("id", Var.valueOf("Funcionarios")), Var.valueOf("user", idUser));
				cronapi.object.Operations.setObjectField(Entidade, Var.valueOf("user"), idUser);
				return Entidade;
			}
		}.call();
	}

}
