<h2 align="center">Sistema Gerenciador de Eventos 🎫 Rest API</h1>
<h4 align="center">Por: Amanda Perrone Degrande, RA: 140501 & Raquel Kuntz Oliveira, RA: 121036</h1>

#### 🔗 Deploy: [Heroku](https://event-rest-api.herokuapp.com/)

#### 💻 Sobre o Projeto

Foi desenvolvida uma aplicação **Web Rest API** com **SpringBoot** para controlar eventos com as seguintes regras de negócio:

 - Construir um CRUD Rest para gerenciar eventos seguindo o modelo conceitual apresentado na imagem a seguir, com três profiles: TEST (H2 Database), DEV (PostgreSQL - Local  ([localhost:8080](http://localhost:8080))) e PROD (PostgreSQL - [Heroku](https://event-rest-api.herokuapp.com/)), com pesquisas paginadas contendo filtros por Nome, Data de Início e Descrição;
 - Um evento pode ser criado por qualquer usuário administrador;
- Essa aplicação, por enquanto, não terá autenticação ou autorização, ou seja, não será possível saber o tipo de usuário que está usando o sistema (Admin ou Attendee);
 - A aplicação deverá controlar a quantidade de ingressos já vendidos;
 - Um evento poderá ser realizado em um ou mais lugares. E um lugar poderá ser usado por zero ou mais eventos, porém em datas e horários diferentes; 
 - Ao alterar o local ou data de um evento, verificar se isso é possível. Não será possível alterar as informações do evento após a sua realização. Um evento que já tenha ingressos vendidos não poderá ser removido. Um local não poderá ser removido se ele já foi usado por um evento;
 - Um participante poderá fazer a sua inscrição (adquirir ingressos) em qualquer evento cadastrado, respeitando o limite de participantes de cada evento ou a data de realização do evento. Não é possível adquirir um ingresso de um evento que ocorreu no passado;
 - Existem dois tipos de ingressos: Pago e Gratuito. Um ingresso pago deverá ter o valor pago no momento da compra. O valor do ingresso pago pode ser alterado a qualquer momento. Porém os valores dos ingressos pagos já vendidos não deverão ser alterados. Armazenar a data de venda dos ingressos e caso um ingresso seja removido/devolvido, esse poderá ser vendido novamente para o evento. O valor do ingresso pago entrará como saldo para do participante que comprou o ingresso. Não será possível remover/devolver um ingresso a partir data de início do evento;
- A aplicação deverá mostrar todas as mensagens de erro no formato resumido e a aplicação não poderá devolver erro 500.

#### 🎯 Modelo Conceitual

<img src="public/modeloconceitual.png" alt="Modelo Conceitual da aplicação" />

#### 💾 JSONs para salvar novas entidades:

- 👤 Admin:

```
{
    "name": "Admin Name",
    "email": "admin@email.com",
    "phoneNumber": "1532223333"
}
```

- 👤 Attendee:

```
{
    "name": "Attendee Name",
    "email": "attend@email.com"
}
```

- 📌 Place:

```
{
    "name": "Place Name",
    "address": "Place Address"
}
```

- 🎪 Event:

```
{
    "name": "Event Name",
    "description": "Event Description",
    "startDate": "20/04/2021",
    "endDate": "22/04/2021",
    "startTime": "08:00:00",
    "endTime": "10:30:00",
    "emailContact": "event@email.com",
    "amountFreeTickets": 20,
    "amountPayedTickets": 100,
    "priceTicket": 15.0,
    "idAdmin": 1
}
```

- 🎟️ Ticket:

```
{
    "idAttendee": 5,
    "type": 0
}
```
