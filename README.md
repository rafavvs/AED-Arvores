# Relatório: Remoção de nós em uma árvore binária

## Removendo nós com dois filhos (Estratégia do Sucessor)
Quando é necessário remover um nó que possui dois filhos, a implementação utiliza a regra do Sucessor, que consiste basicamente em pegar o menor valor do lado direito (menor dos maiores).

**Motivo:**

Adotar essa estratégia mantém a árvore organizada. Se o nó fosse simplesmente apagado, os dois filhos dele (e tudo o que está abaixo deles) ficariam "soltos" e desconectados. Em vez disso, o algoritmo procura o menor número da subárvore da direita e copia o valor dele para o nó que deve ser apagado.
Como o menor número do lado direito é escolhido, há a garantia matemática de que a regra da árvore continua valendo: tudo à esquerda continua sendo menor, e tudo à direita continua sendo maior. Depois de realizar a cópia do valor, o algoritmo apenas apaga o nó original de onde o número foi retirado (o que é uma operação muito mais simples, pois é garantido que esse nó nunca terá dois filhos).

**Por que a implementação recursiva:**

Optei por utilizar a recursão (o método chama a si mesmo) em vez de um laço de repetição convencional (como o while usado no método de inserção original).
O motivo para essa escolha é que a recursão torna o código muito mais simples de ler e manter. Para remover um nó em uma estrutura de árvore, o "nó pai" precisa ser atualizado para apontar para a nova estrutura correta. Se isso fosse feito com um laço while, seria necessário criar diversas variáveis auxiliares apenas para rastrear quem era o nó pai a cada passo e de qual lado o filho estava posicionado.
Com a recursão, o próprio sistema gerencia esse controle de quem é o pai automaticamente, utilizando a memória do computador. O código simplesmente devolve o pedaço da árvore atualizado de volta para quem o chamou. Isso deixa a solução mais limpa, mais curta e reduz drasticamente as chances de falhas no programa.
