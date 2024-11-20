class arvoreHeapMinima : Amontoavel {

    private var dados = LongArray(tamanho) {} // Declarar array
    private var ponteiroFim = -1 // Indica o final do heap

    override fun inserir(dado: Long) {
        if (!estaCheia()) {
            ponteiroFim++
            dados[ponteiroFim] = dado // Insere o dado
            ajustarAcima(ponteiroFim) // Reorganiza para manter a propriedade de heap
        } else {
            println("Heap está cheia! Não é possível inserir novos elementos")
        }
    }

    override fun ajustarAcima(indice: Int) {
        var indiceFilho = indice
        while (indiceFilho != 0) {
            val indicePai = indicePai(indiceFilho)
            if (dados[indicePai] > dados[indiceFilho]) { // Compara pai e filho
                trocar(indiceFilho, indicePai)
                indiceFilho = indicePai // Atualiza o índice para continuar ajustando
            } else {
                break
            }
        }
    }

    override fun ajustarAbaixo(indice: Int) {
        var pai = indice
        while (pai <= ponteiroFim) {
            val filhoEsquerdo = indiceFilhoEsquerda(pai)
            val filhoDireito = indiceFilhoDireita(pai)
            var menor = pai

            if (filhoEsquerdo <= ponteiroFim && dados[filhoEsquerdo] < dados[menor]) {
                menor = filhoEsquerdo
            }
            if (filhoDireito <= ponteiroFim && dados[filhoDireito] < dados[menor]) {
                menor = filhoDireito
            }

            if (menor != pai) {
                trocar(pai, menor)
                pai = menor
            } else {
                break
            }
        }
    }

    private fun indicePai(indiceFilho: Int): Int = (indiceFilho - 1) / 2

    private fun indiceFilhoEsquerda(indicePai: Int): Int = 2 * indicePai + 1

    private fun indiceFilhoDireita(indicePai: Int): Int = 2 * indicePai + 2

    private fun trocar(i: Int, j: Int) {
        val temp = dados[i]
        dados[i] = dados[j]
        dados[j] = temp
    }

    override fun extrair(): Long? {
        return if (!estaVazia()) {
            val dadoRaiz = dados[0]
            dados[0] = dados[ponteiroFim]
            ponteiroFim--
            ajustarAbaixo(0)
            dadoRaiz
        } else {
            println("Heap está vazia!")
            null
        }
    }

    override fun atualizar(dado: Long) {
        if (!estaVazia()) {
            dados[0] = dado
            ajustarAbaixo(0)
        } else {
            println("Heap está vazia!")
        }
    }

    override fun obter(): Long? {
        return if (!estaVazia()) {
            dados[0]
        } else {
            println("Heap está vazia!")
            null
        }
    }

    override fun estaVazia(): Boolean = ponteiroFim == -1

    override fun estaCheia(): Boolean = ponteiroFim == dados.size - 1

    override fun imprimir(): String {
        val resultado = StringBuilder("[")
        for (i in 0..ponteiroFim) {
            resultado.append(dados[i])
            if (i != ponteiroFim) resultado.append(", ")
        }
        resultado.append("]")
        return resultado.toString()
    }
}