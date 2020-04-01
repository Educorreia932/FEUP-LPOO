**4. Dispensables** - Comentários desnecessários nos atributos da classe `Shape`. Se eles estão lá podem ser sintomas de problemas maiores no resto do código.
**2. Object-Orientation Abusers** (Switch Statements) - Switch complicado em `Shape.draw()` (que mais se complicaria, quanto mais formas geométricas se criassem) pode ser resolvido através de uma estratégia de polimorfismo (a classe `Shape` passaria a ser abstrata e as classes `Rectangle` e `Circle` suas derivadas.  
**1. Bloaters** (Large Class) - Ainda na sequência do ponto anterior, a classe `Shape`, apesar de não ser extremamente "grande", é a maior do exemplo em questão (e só iria aumentar mais de tamanho se se tivesse tido em conta mais tipos de formas geométricas).  
Pode ser facilmente estruturada de modo a diminuir o seu tamanho e, consequentemente, nível de complexidade

