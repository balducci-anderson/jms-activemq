<h1>Mensageria com JMS e ActiveMQ</h1>

Projeto criado em Java, utilizando Maven.

Foram criadas duas aplicações, um produtor e um consumidor de mensagens, para exemplificar o funcionamento de comunicação entre duas aplicações utilizando o conceito de mensageria.

O produtor envia um objeto do tipo Cliente para uma fila do broker ActiveMQ, que por sua vez fica responsável por enviar esta mensagem para o consumidor.

O consumidor recebe a mensagem (objeto Cliente), e imprime os dados, desde que as propriedades do objeto definidas no produtor atendam o selector.

É necessário baixar e executar o ActiveMQ para o funcionamento das aplicações
