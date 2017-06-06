# kart-rank
Autor: Rodolfo D. Ramos
Projeto desafio Kark Rank 

### Passos para execução:

#### Duas formas para rodas

1 - Executar o arquivo janelaCorrida.bat
1.1 - Clicar em selecionar arquivo. Selecionar o arquivo do log de corrida.
1.2 - A aplicação irá executar a leitura e o log aparecerá na TextArea e no System.out.print

2 - Ir para a pasta target e rodar o comando: java -jar kart_rank-0.0.1-SNAPSHOT.jar com.rodolfo.kartrank.App "LOCAL_TXT_LOG"

OBS: O local do arquivo deve ser informado completo, ex: D:\Projetos\java\eclipse\logrank.txt 

### Implementações

* Posição Chegada, Código Piloto, Nome Piloto, Qtde Voltas Completadas e Tempo Total de Prova
- Descobrir a melhor volta de cada piloto
- Descobrir a melhor volta da corrida
- Calcular a velocidade média de cada piloto durante toda corrida
+ Descobrir quanto tempo cada piloto chegou após o vencedor


### Saída do log

 Posição no Grid Codigo Piloto     Nome Piloto Numero de Voltas   Tempo Total  Melhor Volta Velocidade Média Tempo atras do primeiro
               1           038         F.MASSA                4  00:04:11.578  00:01:02.769           44,246                   00:00
               2           002     K.RAIKKONEN                4  00:04:15.153  00:01:03.076           43,627            00:00:03.575
               3           033   R.BARRICHELLO                4  00:04:16.080  00:01:03.716           43,468            00:00:04.502
               4           023        M.WEBBER                4  00:04:17.722  00:01:04.216           43,191            00:00:06.144
               5           015        F.ALONSO                4  00:04:54.221  00:01:07.011           38,066            00:00:42.643
               6           011        S.VETTEL                3  00:06:27.276  00:01:18.097           25,746            00:02:15.698

Melhor Volta -> 038 – F.MASSA - Tempo: 00:01:02.769 - Volta: 3
