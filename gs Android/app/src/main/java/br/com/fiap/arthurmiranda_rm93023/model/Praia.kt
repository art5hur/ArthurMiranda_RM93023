package br.com.fiap.arthurmiranda_rm93023.model

    data class Praia(val nome: String, val cidade: String, val estado: String,
    val onRemove: (Praia) -> Unit
)