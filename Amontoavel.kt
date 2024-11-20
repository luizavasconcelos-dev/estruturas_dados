public interface Amontoavel {
    //CRUD
	fun inserir(dado: Long) 	
	fun extrair(): Long?		
	fun obter(): Long?			
	fun atualizar(dado: Long)
	
    //Metodos aux
	fun imprimir(): String
	fun estaVazia(): Boolean
	fun estaCheia(): Boolean

    //metodos heap 
	private fun indiceFilhoEsquerda(indicePai: Int): Int	
	private fun indiceFilhoDireita(indicePai: Int): Int	
	private fun indicePai(indiceFilho: Int): Int
	private fun trocar(i: Int, j: Int)	
	private fun ajustarAbaixo(pai: Int) 	
	private fun ajustarAcima(indice: Int) 
}