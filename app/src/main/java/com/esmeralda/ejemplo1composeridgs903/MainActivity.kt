package com.esmeralda.ejemplo1composeridgs903


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx. compose. runtime. getValue
import androidx. compose. runtime. setValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text;
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx. compose. foundation. lazy. items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Card


import androidx. compose. foundation. shape. RoundedCornerShape
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

private val tarjeta: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("gohan", "Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT. "),
    PersonajeTarjeta("goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable. Originalmente enviado a la Tierra como un infante volador con la misión de conquistarla."),
    PersonajeTarjeta("piccolo", "Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación."),
    PersonajeTarjeta("vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters. "),
    PersonajeTarjeta("krillin","Amigo cercano de Goku y guerrero valiente, es un personaje del manga y anime de Dragon Ball."),
    PersonajeTarjeta("tenshinhan", "Maestro de las artes marciales y miembro de los Z Fighters."),
    PersonajeTarjeta("cell", "Cell conocido como Célula en España, es un bioandroide creado por la computadora del Dr. Gero, quien vino del futuro de la línea 3 con la intención de vengarse de Goku por haber acabado con el Ejército del Listón Rojo, y con ello el sueño de todo villano: dominar el mundo. "),
    PersonajeTarjeta("milk", "Esposa de Goku y madre de Gohan. "),
    PersonajeTarjeta("majin Buu", "También conocido como Boo original, es la forma original y pura de Majin-Boo, y la última forma de Boo que aparece en Dragon Ball Z")

)

data class PersonajeTarjeta(val title:String, val body:String)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(Experimental3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            Ejemplo1ComposerIDGS903Theme {
                Tarjeta(tarjeta)
            }

        }
    }
}


@Composable
fun ImagenHero(imageName: String){
    val context = LocalContext.current
    val ImageRestId = remember(imageName){
        context.resources.getIdentifier(imageName.lowercase(),
            "drawable", context.packageName)
    }
    Image(
             painter = painterResource(id=ImageRestId),
             contentDescription = null,
             modifier = Modifier
             .padding(16.dp)
                 .size(100.dp)
                 .clip(CircleShape)
                 .background(MaterialTheme.colorScheme.tertiary)


    )
}

@Composable
fun Image() {
    TODO("Not yet implemented")
}


@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
       // ImagenHero()
        items(personajes){ personaje ->
            MyPersonajes(personaje)
        }

    }

}

@Composable
fun MyPersonajes(personaje: PersonajeTarjeta){
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            ImagenHero(personaje.title)
            Personajes(personaje)
        }
    }

}

@Composable
fun Personaje(name:String, color:Color, style: TextStyle, lines: Int = Int.MAX_VALUE){
    Text(text = name, color = color, style = style, maxLines=lines)

}
@Composable
fun Personajes(personaje: PersonajeTarjeta){
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(start = 8.dp).clickable {
        expanded = !expanded
    }){
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium)

        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge)
           if(expanded) Int.MAX_VALUE else 1
    }


}

@Preview
@Composable
fun GeetingPreview(){
    Tarjeta(tarjeta)

}