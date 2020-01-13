# WeatherForecast
Teste HBSIS

Tecnologias utilizadas

- Backend: Java utilizando o Spring Framework(Spring Boot, Spring MVC, Spring Data JPA);
- Frontend: JavaScript, JSON, JQuery, HTML, CSS e Bootstrap;
- Banco de Dados: MySQL;
- Utilizado a API publica do open weather ( http://openweathermap.org/api ).

Ferramentas utilizadas

- IntelliJ IDEA Community Edition 2019.3.1;
- MySQL Workbench 8.0 CE.

Fluxo de telas

1º Tela: Cadastro de cidade e listagem das cidades cadastradas.
- Permite que o usuário possa cadastrar a cidade que deseja visualizar a previsão do tempo, 
e logo abaixo é listado em uma tabela todas as cidades já cadastradas, onde para cada cidade 
tem um link que direciona para a tela de previsão do tempo.

2º Tela: Previsão do tempo;
- Permite que o usuário possa visualizar detalhes da previsão do tempo de até 5 dias para a
cidade selecionada, os detalhes são: imagem do tempo, data/hora, temperatura, temperatura mínima,
temperatuda máxima e tempo.

Importar/rodar o projeto

- Criar uma conexão no banco de dados MySQL com as seguintes informações:
Hostname: localhost
Port: 3306
username: root
password: root

- Rodar o script do arquivo create_database.sql no banco de dados

- Baixar a branch master do repositorio https://github.com/everton-goes/WeatherForecast.git

- Importar o projeto na IDE

- Logo após o Maven importar todas as dependencias executar a classe Main WeatherforecastApplication
 localizada em com.teste.web.hbsis.weatherforecast.WeatherforecastApplication

