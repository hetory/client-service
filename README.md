"# client-service" 

JAVA_VERSION : 1.8

Iniciar aplicacao

Executar o arquivo na raiz do projeto
  Executavel : client-service\mvnw.cmd

1 - Start no projeto client-server :
    Start Class :  Application.java



API

URL : 


Content-Type:application/json
Method-Type:POST

BODY :
{  
   "name":"Hetory",
   "limit":1000,
   "risk":"A"
}




Cenario de testes :

Cenario A

Nome Cliente  : Hetory
Limite de credito : 10 
Risco
Caso A
 entao retorna taxa de juros = 0



Cenario B

Nome Cliente  : Hetory
Limite de credito : 10 
Risco
Caso B
 entao retorna taxa de juros = 10



Cenario C

Nome Cliente  : Hetory
Limite de credito : 10 
Risco
Caso B
 entao retorna taxa de juros = 20