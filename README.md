# Sistema Bancário em Java

Este é um sistema bancário simples implementado em Java. O sistema oferece funcionalidades básicas, como criar contas, realizar depósitos, saques e consultar saldo.

## Pré-requisitos

Certifique-se de ter o Java instalado em sua máquina. Você pode baixá-lo em [java.com](https://www.java.com/).

## Como executar o sistema

1. Clone este repositório em sua máquina local:

    ```bash
    git clone https://github.com/Kamifaria/sistema-bancario-java.git
    ```

2. Navegue até o diretório do projeto:

    ```bash
    cd sistema-bancario-java
    ```

3. Compile o código-fonte:

    ```bash
    javac Banco.java
    ```

4. Execute o programa:

    ```bash
    java Banco
    ```
## Imagem do Projeto 
![sistemabancario jpg](https://github.com/Kamifaria/Sistema-Bancario-Java/assets/91440228/a1aa1a82-49f1-4f17-824f-5883c4871c98)

## Funcionalidades

- **Criar Conta:**
  - Permite ao usuário criar uma nova conta bancária.

- **Depósito:**
  - Permite ao usuário realizar depósitos em sua conta.

- **Saque:**
  - Permite ao usuário realizar saques de sua conta.

- **Consulta de Saldo:**
  - Permite ao usuário verificar o saldo atual de sua conta.

## Exemplo de Uso

```java
// Exemplo de criação de conta
Conta conta = new Conta("Nome do Cliente", "1234-5678", 1000.0);

// Exemplo de depósito
conta.deposito(500.0);

// Exemplo de saque
conta.saque(200.0);

// Exemplo de consulta de saldo
double saldoAtual = conta.getSaldo();
System.out.println("Saldo Atual: " + saldoAtual);

```
## Licença
Este projeto é licenciado sob a MIT License - veja o arquivo LICENSE.md para detalhes.
