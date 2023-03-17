## Challenge ONE Back End - Java - Conversor
#challengeoneconversorbr4 


## 🎯 Desafio

- Inicialmente o projeto pedia para converter as moedas de Reais para Dólar, Euro, Libras Esterlinas, Peso Argentino e Peso Chileno ou destas moedas para Real. 
- A cotação foi obtida online através da API api.exchangerate-api.com
- Após selecionado o par de moedas a ser utilizado. A conversão ocorre durante a digitação agilizando a exibição do resultado. 
- O Real é obrigatório como campo moeda de origem ou moeda para qual será convertido, então ao alterar um campo de moeda o sistema já seta o outro campo como Real ou não conforme a regra. 
- Para um segundo conversor optei por criar um conversor para Números Romanos.   
- Ele segue o mesmo princípio de já efetuar a conversão durante a digitação. 
- E por fim foi adicionado uma opção de idioma para inglês, português e espanhol 


## Cotação 
![](https://github.com/rasia83/challenge-one-conversor/blob/main/gif1-cotacao.gif)


## Numeros Romanos
![](https://github.com/rasia83/challenge-one-conversor/blob/main/gif2-numeros_romanos.gif)


## Idioma
![](https://github.com/rasia83/challenge-one-conversor/blob/main/gif3-idioma.gif)


## 📁 Acesso ao projeto

Você pode [acessar o código fonte do projeto inicial](https://github.com/rasia83/challenge-one-conversor/) 
ou [baixá-lo](https://github.com/rasia83/challenge-one-conversor/releases/download/V1.0/Converter-1.0-jar-with-dependencies.jar).


## 🛠️ Abrir e rodar o projeto

Para executar o conversor você precisa ter o Java 8 (JRE) instalado em seu computador.
https://www.java.com/en/download/

execute o arquivo baixado Converter-1.0-jar-with-dependencies.jar


## Tecnologias utilizadas

- O projeto foi desenvolvido em NetBeans IDE 16 (escolha feita para trabalhar com Swing)
- Foi desenvolvido em Java 17 mas para ser distribuido foi adaptado para JRE Java 8 (foi alterado a forma como trabalhava o metodo switch dos idiomas)
- Maven foi ultilizado para montar o projeto, especialmente incluir a dependencia json

