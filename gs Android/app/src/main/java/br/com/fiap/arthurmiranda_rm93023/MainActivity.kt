package br.com.fiap.arthurmiranda_rm93023


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.arthurmiranda_rm93023.adapter.PraiaAdapter
import br.com.fiap.arthurmiranda_rm93023.model.Praia



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val textViewTitulo = findViewById<TextView>(R.id.textViewTitulo)
        //textViewTitulo.text = textViewTitulo.text

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val praiaAdapter = PraiaAdapter()
        recyclerView.adapter = praiaAdapter


        val button = findViewById<Button>(R.id.button)
        val editTextNomePraia = findViewById<EditText>(R.id.editTextNomePraia)
        val editTextCidade = findViewById<EditText>(R.id.editTextCidade)
        val editTextEstado = findViewById<EditText>(R.id.editTextEstado)

        button.setOnClickListener {
            if (editTextNomePraia.text.isEmpty()) {
                editTextNomePraia.error = "Preencha um valor"
                return@setOnClickListener
            }
            if (editTextCidade.text.isEmpty()) {
                editTextCidade.error = "Preencha um valor"
                return@setOnClickListener
            }
            if (editTextEstado.text.isEmpty()) {
                editTextEstado.error = "Preencha um valor"
                return@setOnClickListener
            }

            val item = Praia(
                nome = editTextNomePraia.text.toString(),
                cidade = editTextCidade.text.toString(),
                estado = editTextEstado.text.toString(),
                onRemove = {
                    praiaAdapter.removeItem(it)
                }
            )

            praiaAdapter.addItem(item)

            editTextNomePraia.text.clear()
            editTextCidade.text.clear()
            editTextEstado.text.clear()
        }
    }
}
