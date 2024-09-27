interface Enfileiravel {
// T = "tipo generico"

    //metodos principais
    enfileirar(dado: T)
    desenfileirar(): T
    atualizar(dado: T)

    //metodos auxiliares 
    fun isEmpty(): boolean
    fun isFull(): boolean
    fun imprimir(): String
}