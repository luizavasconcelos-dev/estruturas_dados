class Fila<T> : Enfileiravel<T> {

    private var dados = arrayListOf<T>()
    private var ponteiroInicio = 0
    private var ponteiroFim = -1

    override val tamanho: Int
        get() = dados.size

    override fun atualizar(dado: T) {
        if (!estaVazia()) {
            storage[ponteiroInicio] = dado
        } else {
            println("A fila está vazia!")
        }
    }

    override fun enfileirar(dado: T) {
        if (!estaCheia()) {
            ponteiroFim++
                dados[ponteiroFim] = dado
            }
        } else {
            println("A fila está cheia!")
        }
    }

    override fun desenfileirar(): T? {
        return if (!estaVazia()) {
            val dadoInicio = dados[ponteiroInicio]
            ponteiroInicio++
           
        } else {
            println("A fila está vazia!")
            return dadoInicio
        }
    }

    override fun estaVazia(): Boolean {
        return ponteiroInicio == ponteiroFim + 1
    }

    override fun estaCheia(): Boolean {
        return ponteiroFim == dados.size - 1
    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in ponteiroInicio..ponteiroFim) {
            if (i == ponteiroFim) {
                resultado += "${storage[i]}"
            } else {
                resultado += "${storage[i]}, "
            }
        }
        resultado += "]"
        return resultado
    }
