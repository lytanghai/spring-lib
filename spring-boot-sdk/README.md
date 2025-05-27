RabbitMQ
Payload for direct exchange type:
exchange: exchange1 //direct exchange
queue: queue1
routing key = routingKey



curl --request POST \
--url 'http://localhost:8080/order/zazaa?=' \
--header 'Content-Type: application/json' \
--data '{
"orderId": "123",
"name":"test",
"qty":2,
"price":25.0
}'