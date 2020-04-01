**2. Object-Orientation Abusers** (Switch Statements) - O `if...else` em `ApplyDiscount` pode ser simplificado, retirando o `else` desnecessário. Melhor ainda seria Separar a classe `Discount` em `DiscountFixed` e `DiscountPercentage` (*Extract Class*)   
**4. Dispensable** (Dead Code) - É possivel remover o *assignment* de `discountedPrice`, executando de logo o `return`em vez de igualar a uma variável de "resultado" 

Podemos iniciar o Discount a zero sempre, assim nunca seria nulo