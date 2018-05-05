package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;

@CronapiMetaData(type = "blockly")
@CronappSecurity
public class AtualizarCliente {

	public static final int TIMEOUT = 300;

	/**
	 *
	 * @return Var
	 */
	// AtualizarCliente
	public static Var atualizarCliente() throws Exception {
		return new Callable<Var>() {

			private Var idUser = Var.VAR_NULL;
			private Var cliente = Var.VAR_NULL;
			private Var idCliente = Var.VAR_NULL;

			public Var call() throws Exception {
				idUser = blockly.UsuarioEntidade.obterIdUsuarioLogado();
				cliente = cronapi.database.Operations.query(Var.valueOf("app.entity.Cliente"),
						Var.valueOf("select c from Cliente c where c.user.id = :userId"),
						Var.valueOf("userId", idUser));
				idCliente = cronapi.database.Operations.getField(cliente, Var.valueOf("this[0].id"));
				cronapi.database.Operations.execute(Var.valueOf("app.entity.Cliente"),
						Var.valueOf(
								"update Cliente set bairro = :bairro, ceP = :ceP, cidade = :cidade, cnPJ = :cnPJ, cpF = :cpF, crO = :crO, dataNascimento = :dataNascimento, endereco = :endereco, especialidade = :especialidade, estado = :estado, inscricaoEstadual = :inscricaoEstadual, inscricaoMunicipal = :inscricaoMunicipal, nome = :nome, razaoSocial = :razaoSocial, rg = :rg, telefone1 = :telefone1, telefone2 = :telefone2 where id = :id"),
						Var.valueOf("bairro",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.bairro"))),
						Var.valueOf("ceP",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.ceP"))),
						Var.valueOf("cidade",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.cidade"))),
						Var.valueOf("cnPJ",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.cnPJ"))),
						Var.valueOf("cpF",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.cpF"))),
						Var.valueOf("crO",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.crO"))),
						Var.valueOf("dataNascimento",
								cronapi.screen.Operations
										.getValueOfField(Var.valueOf("Cliente.active.dataNascimento | mask:'date'"))),
						Var.valueOf("endereco",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.endereco"))),
						Var.valueOf("especialidade",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.especialidade"))),
						Var.valueOf("estado",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.estado"))),
						Var.valueOf("inscricaoEstadual",
								cronapi.screen.Operations
										.getValueOfField(Var.valueOf("Cliente.active.inscricaoEstadual"))),
						Var.valueOf("inscricaoMunicipal",
								cronapi.screen.Operations
										.getValueOfField(Var.valueOf("Cliente.active.inscricaoMunicipal"))),
						Var.valueOf("nome",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.nome"))),
						Var.valueOf("razaoSocial",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.razaoSocial"))),
						Var.valueOf("rg", cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.rg"))),
						Var.valueOf("telefone1",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.telefone1"))),
						Var.valueOf("telefone2",
								cronapi.screen.Operations.getValueOfField(Var.valueOf("Cliente.active.telefone2"))),
						Var.valueOf("id", idCliente));
				cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"),
						Var.valueOf("Seu cadastro foi atualizado com sucesso!"));
				return Var.valueOf(listarCliente());
			}
		}.call();
	}

	/**
	 *
	 * @return Var
	 */
	// Descreva esta função...
	public static Var listarCliente() throws Exception {
		return new Callable<Var>() {

			private Var clienteRetorno = Var.VAR_NULL;

			public Var call() throws Exception {
				clienteRetorno = cronapi.database.Operations.query(Var.valueOf("app.entity.Cliente"),
						Var.valueOf("select c from Cliente c where c.user.id = :userId"),
						Var.valueOf("userId", blockly.UsuarioEntidade.obterIdUsuarioLogado()));
				return clienteRetorno;
			}
		}.call();
	}

}
