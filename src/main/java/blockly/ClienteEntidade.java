package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class ClienteEntidade {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// ClienteEntidade
	public static Var insereUsuario() throws Exception {
		return new Callable<Var>() {

			private Var nome = Var.VAR_NULL;
			private Var email = Var.VAR_NULL;
			private Var cpf = Var.VAR_NULL;
			private Var cro = Var.VAR_NULL;
			private Var dtNasc = Var.VAR_NULL;
			private Var senha = Var.VAR_NULL;
			private Var idUser = Var.VAR_NULL;
			private Var exception = Var.VAR_NULL;

			public Var call() throws Exception {
				if (Var.valueOf(!cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtSenha"))
						.equals(cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtConfirma"))))
						.getObjectAsBoolean()) {
					cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
							Var.valueOf("error"), Var.valueOf("A senha não confere. Tente novamente!"));
				} else {
					nome = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtNome"));
					email = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtEmail"));
					cpf = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtCpf"));
					cro = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtCro"));
					dtNasc = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.dtNasc"));
					senha = cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.txtSenha"));
					idUser = cronapi.util.Operations.generateUUID();
					try {
						cronapi.database.Operations.insert(Var.valueOf("app.entity.User"),
								Var.valueOf("password", senha), Var.valueOf("name", nome), Var.valueOf("id", idUser),
								Var.valueOf("login", email), Var.valueOf("email", email));
						cronapi.database.Operations.insert(Var.valueOf("app.entity.Role"),
								Var.valueOf("id", Var.valueOf("Clientes")), Var.valueOf("user", idUser));
						cronapi.database.Operations.insert(Var.valueOf("app.entity.Cliente"), Var.valueOf("crO", cro),
								Var.valueOf("cpF", cpf), Var.valueOf("nome", nome),
								Var.valueOf("dataNascimento", dtNasc), Var.valueOf("user", idUser));
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
								Var.valueOf("success"), Var.valueOf("Conta criada com sucesso!"));
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
								Var.valueOf("user.username"), email);
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"),
								Var.valueOf("user.password"), senha);
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.myfunctions.chamarLogin"),
								Var.valueOf("btnLogin"));
					} catch (Exception exception_exception) {
						exception = Var.valueOf(exception_exception);
						cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"),
								Var.valueOf("error"), Var.valueOf("Erro ao realizar a operação!"));
					}
				}
				return Var.VAR_NULL;
			}
		}.call();
	}

}
