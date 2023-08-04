import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Inserir dados na tabela" +
                    "\n2. Atualizar dados na tabela" +
                    "\n3. Mostrar dados registrados na tabela" +
                    "\n4. Deletar dados da tabela" +
                    "\n0. Sair");

            try {
                Scanner scanner = new Scanner(System.in);
                int op = scanner.nextInt();

                switch (op) {
                    case 1:
                        Pessoa pessoa = criarPessoa();
                        Insert.inserir(pessoa);
                        break;
                    case 2:
                        Pessoa pessoaATualizar = atualizarDados();
                        Update.atualizarDados(pessoaATualizar);
                        break;
                    case 3:
                        Read.mostrarDadosTabela();
                        break;
                    case 4:
                        Long id = receberId();
                        Delete.deletar(id);
                        break;
                    case 0:
                        System.out.println("Finalizado");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opçao invalida, tente novamente");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro ao ler a opçao digitada, digite numeros inteiros");
            }

        }
    }

    private static Pessoa criarPessoa() {
        Pessoa pessoa = new Pessoa();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome da pessoa: ");
        pessoa.setNome(scanner.nextLine());

        System.out.print("Digite o cpf da pessoa: ");
        pessoa.setCpf(scanner.next());

        return pessoa;
    }

    private static Long receberId() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o Id que deseja remover: ");
        Long id = scanner.nextLong();

        return id;
    }

    private static Pessoa atualizarDados() {
        Pessoa pessoa = new Pessoa();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o Id que deseja atualizar: ");
        pessoa.setId(Long.valueOf(scanner.nextLine()));

        System.out.print("Digite o nome da pessoa: ");
        pessoa.setNome(scanner.nextLine());

        System.out.print("Digite o cpf: ");
        pessoa.setCpf(scanner.next());

        return pessoa;
    }
}
