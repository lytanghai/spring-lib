
I Create Table:
 [Script in sql directory]


II Create Users Sequence
![img.png](img.png)

+ Create Roles Sequence
![img_1.png](img_1.png)

+ Create Refresh Token Sequence
![img_2.png](img_2.png)

III. Curl

1. Sign up
   curl --request POST \
   --url http://localhost:8081/api/auth/signup \
   --header 'Content-Type: application/json' \
   --data '{
   "username": "tanghai",
   "password": "admin",
   "email": "tanghai@gmail.com",
   "role": [
   "admin"
   ]
   }'

2. Sign In
   curl --request POST \
   --url http://localhost:8081/api/auth/signin \
   --header 'Content-Type: application/json' \
   --data '{
   "username": "tanghai",
   "password": "admin"
   }'

3. Refresh Token
   curl --request POST \
   --url http://localhost:8081/api/auth/signin \
   --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0YW5naGFpIiwiaWF0IjoxNzE4ODE0MDkyLCJleHAiOjE3MTg4MTQxNTJ9.3uyrDu0ddwQ7HYuNqC8CpFFz9v6PlxY0s2t2q_BSwWI-Vj8a-DqjQdHwVYnctFMQg4I0hWE__lEq4yEJx28iVA' \
   --header 'Content-Type: application/json' \
   --data '{
   "username": "tanghai",
   "password": "admin"
   }'
4. Sign Out
   curl --request POST \
   --url http://localhost:8081/api/auth/signout \
   --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0YW5naGFpIiwiaWF0IjoxNzE4ODE0MDQ3LCJleHAiOjE3MTg4MTQxMDd9.HtyMVV2iA24WPhQ4RDq7S-frO-oL9lycKM7eT_YkVIMi7rXv10iIq8WgT2UPFaEJ3BkVFjocSk9CSGdmf5IV3A'