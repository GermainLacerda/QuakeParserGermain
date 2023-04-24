Projeto quake parser 

task 1 completa no commit 6
task 2 completa no commit 8

Parser desenvolvido na linguagem Java 11 utilizando a IDE Eclipse em sua versão mais recente

O primeiro passo para interpretar o log fornecido foi escolher a forma dessa leitura, para simplificar a obtenção das linhas 
se foi usado o bufferedReader e um loop de while para percorrer todo o arquivo.
O segundo passo foi criar os objetos de jogo e de jogadores, assim como saber quais atributos esses objetos receberiam.
O terceiro passo foi entender quando um jogo começa ou acaba pelo log, InitGame e ShutdownGame, respectivamente.
Para interpretar o que acontece dentro de um jogo se utilizou um while com condição de parada quando se tem na linha o log de ShutdownGame
Dentro do loop de jogo, é nescessario reconhecer quando um jogador se conecta, para isso a linha possui o log ClientUserinfoChanged, 
assim como, o nome e o id do jogador (id variavel por jogo).
Após guardar o player em uma linkedList, percorremos o jogo em busca do log das kills que aconteceram.
O log de kill, possui um padrão de 3 numeros após o "kill:"
 13:45 Kill: 1022 7 22: <world> killed Mal by MOD_TRIGGER_HURT
sendo o primeiro id quem matou, o segundo id quem morreu e o terceiro id a forma na qual morreu.
1022 é sempre mortes pelo mundo, e os ids da forma de morte são sempre os mesmos.
ao se comparar o id de quem matou ou morreu, com os ids presentes na linkedList de jogadores presentes no jogo, pode ser feito a 
interpretação daquela morte, assim como a contagem das mortes que ele cometeu, e caso o mundo que tenha matado o jogador é operacionalizado a subtração de 1 de suas mortes.
Depois de termos a lista de jogadores com suas mortes contabilizadas e a contagem de mortes geral da partida, podemos criar/iniciar o objeto jogo e na sequencia guarda-lo em uma
linkedList de jogos.
Essa lista é usada para se fazer o rankeamento dos jogadores, capturando os jogadores de todos os jogos e somando suas mortes para serem ordenadas de forma decrescente.


