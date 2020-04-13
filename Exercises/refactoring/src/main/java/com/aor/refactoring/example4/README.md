**2. Object-Orientation Abusers** (Refused Bequest) - Nem todos neste contexto podem fazer *login*, logo não faz sentido ser um método de `Worker`.

A classe `User` constitui quem pode fazer login (ou seja, retém os atributos `username` e `password` bem como o método `login()`)  
Já a classe `Person` possui os dados pessoais como `name` e `phone`.
Na classe `Supervisor`, `Set<Worker>` passaria a ser `Set<User>`.