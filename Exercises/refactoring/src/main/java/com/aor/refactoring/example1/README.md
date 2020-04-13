**4. Dispensable** (Data Class) - `OrderLine` apenas serve para guardar dados 
**4. Dispensable** (Duplicate Code) - Ciclo `for` em `printOrder()` repetido  
**4. Dispensable** - `if...else` pode ser convertido num único `return`  
**4. Dispensable** (Dead Code) - *Setters* de `Product` nunca são chamados  
**5. Couplers** (Feature Envy) -  `printOrder()` acede frequentemente aos métodos do atributo `product` de `OrderLine`. 
Pode-se substituir o que está dentro do `Append()` por um `line.toString()`, resolvendo igualmente o primeiro *code smell referido*.  
Bem como substituir o cálculo de `total` por um novo método `getTotalPrice()` em `OrderLine` (*Extract Method*) 
**5. Couplers** (Inappropriate Intimacy) - Na sequência do ponto anterior, os atributos de `OrderLine` poderiam passar a ser privados