## Exercício 2 - Intent

```
+--------------------+      +--------------------+
|                    |      |                    |
|    Oi, Fulano!     |      |       Fulano       |
|                    |      |  +--------------+  |
| +----------------+ |      |                    |
| | Trocar usuário | +------>  +--------------+  |
| +----------------+ |      |  |   Confirmar  |  |
|                    |      |  +--------------+  |
|                    |      |                    |
|                    |      |  +--------------+  |
|                    |      |  |   Cancelar   |  |
|                    |      |  +--------------+  |
|                    |      |                    |
+--------------------+      +--------------------+
```

Seu app deve possuir duas activities: a `MainActivity` (exibida à esquerda no desenho acima), contendo um TextView com id `textView` e um botão com id `btnTrocar`, e a `OutraActivity`, contendo um EditText com id `editText` e dois botões, um com id `btnConfirmar` e outro com id `btnCancelar`.

Os botões devem ter o rótulo apresentado no desenho acima. O TextView inicialmente deve apresentar o texto "Oi!", e o EditText inicialmente deve vir vazio.

A lógica básica do app é que a mensagem na primeira tela cumprimenta o usuário atual com o texto `Oi, NOME!`, onde `NOME` é o nome do usuário atual. Ao clicar em "Trocar usuário", digitar um novo nome e então clicar em "Confirmar", muda-se o o usuário atual para aquele cujo nome foi digitado. Se o nome digitado for uma string vazia, isso sinaliza que não há nenhum usuário atual, e a mensagem deve ficar apenas "Oi!".

Ao abrir a `OutraActivity`, a caixa de texto deve mostrar o nome do usuário atual ou, se não houver usuário atual, ela deve estar limpa.

Como sempre, o app deve funcionar segundo a especificação mesmo se o usuário rotacionar a tela.
